package com.android.system.talker.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.expand.runOnIO
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.talker.R
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.TaskDb
import com.android.system.talker.database.VegetableDb
import com.android.system.talker.databinding.FragmentHomeBinding
import com.android.system.talker.databinding.ViewComboControlBinding
import com.android.system.talker.view.UserListAdapter

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var adapter: UserListAdapter
    private var nowUserId = -1L
    private val hasSetUserId
        get() = nowUserId != -1L

    private val dataBase by lazy {
        AppDataBase.getInstance(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshUserList()



        _binding.taskCb.setSelectCallBack {
            if (hasSetUserId)
                updateTask(it)
        }



        _binding.taskCb.singleClick {
            if (hasSetUserId) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_vegetableFragment,
                    UserIdArgs(nowUserId).toBundle()
                )
            }
        }

        _binding.vegetableCb.setSelectCallBack {
            if (hasSetUserId)
                updateVegetable(it)
        }

        _binding.vegetableCb.singleClick {
            if (hasSetUserId) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_vegetableFragment,
                    UserIdArgs(nowUserId).toBundle()
                )
            }
        }
    }


    fun refreshUserList() {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                val list = dataBase.getUserDao().list()
                runOnUI {
                    adapter = UserListAdapter(list, {
                        runOnIO {
                            dataBase.getUserDao().update(it)
                        }
                    }, {
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserIdArgs(it).toBundle()
                        )
                    }, {
                        nowUserId = it
                        refreshOptList(it)
                    }, {
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserIdArgs(nowUserId).toBundle()
                        )
                    })
                    _binding.userList.adapter = adapter

                    if (!hasSetUserId) {
                        list.getOrNull(0)?.id?.let {
                            nowUserId = it
                        }
                    }
                    refreshOptList(nowUserId)
                }
            }
        }
    }


    fun refreshOptList(userid: Long) {
        if (hasSetUserId) {
            lifecycleScope.launchWhenResumed {
                runOnIO {
                    val taskDb = dataBase.getTaskDao().queryByUserId(userid)
                    val vegetableDb = dataBase.getVegetableDao().queryByUserId(userid)
                    runOnUI {
                        _binding.taskCb.setChecked(taskDb?.switch?:false)
                        _binding.vegetableCb.setChecked(vegetableDb?.switch?:false)
                    }
                }
            }
        }
    }

    private fun updateTask(isCheck: Boolean) {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getTaskDao().queryByUserId(nowUserId) ?: TaskDb()).let {
                    it.switch = isCheck
                    if ((it.id ?: 0L) >= 0L) {
                        if (it.userid == nowUserId)
                            dataBase.getTaskDao().insert(it)
                    } else {
                        it.userid = nowUserId
                        dataBase.getTaskDao().insert(it)
                    }
                }
            }
        }
    }

    private fun updateVegetable(isCheck: Boolean) {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getVegetableDao().queryByUserId(nowUserId) ?: VegetableDb()).let {
                    it.switch = isCheck
                    if ((it.id ?: 0L) > 0L) {
                        if (it.userid == nowUserId) {
                            dataBase.getVegetableDao().insert(it)
                        }
                    } else {
                        it.userid = nowUserId
                        dataBase.getVegetableDao().insert(it)
                    }
                }
            }
        }
    }


}