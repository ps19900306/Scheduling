package com.android.system.talker.ui


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.expand.runOnIO
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.CmdType
import com.android.system.talker.R
import com.android.system.talker.TimeAccessibilityService
import com.android.system.talker.TimeAccessibilityService.Companion.Intent_Filter_TAG
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.TaskDb
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb
import com.android.system.talker.databinding.FragmentHomeBinding
import com.android.system.talker.view.UserListAdapter

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var adapter: UserListAdapter
    private var nowUserId = -1L
    private val hasSetUserId
        get() = nowUserId != -1L

    //private val viewModel by viewModels<SetViewModel>()
    private val dataBase by lazy {
        AppDataBase.getInstance(requireContext().applicationContext)
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
        _binding.taskCb.setButtonClickBack {
            if (hasSetUserId)
                resetTask()
        }


        _binding.taskCb.singleClick {
            if (hasSetUserId) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_taskFragment,
                    UserIdArgs(nowUserId).toBundle()
                )
            }
        }

        _binding.vegetableCb.setSelectCallBack {
            if (hasSetUserId)
                updateVegetable(it)
        }

        _binding.vegetableCb.setButtonClickBack {
            if (hasSetUserId)
                resetVegetable()
        }

        _binding.vegetableCb.singleClick {
            if (hasSetUserId) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_vegetableFragment,
                    UserIdArgs(nowUserId).toBundle()
                )
            }
        }

        _binding.startBtn.singleClick {
            val intent = Intent(Intent_Filter_TAG)
            intent.setDataAndType(Intent_Filter_TAG.toUri(), "cmd/int")
            intent.putExtra(
                TimeAccessibilityService.CMD,
                if (_binding.everyDayCk.isChecked) CmdType.START_CIRCULATE else CmdType.START
            )
            requireActivity().sendBroadcast(intent);
        }

        _binding.endBtn.singleClick {
            val intent = Intent(Intent_Filter_TAG)
            intent.setDataAndType(Intent_Filter_TAG.toUri(), "cmd/int")
            intent.putExtra(TimeAccessibilityService.CMD, CmdType.CLOSE)
            requireActivity().sendBroadcast(intent);
        }
    }


    private fun updateUser(userDb: UserDb) {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                dataBase.getUserDao().update(userDb)
            }
        }
    }

    fun refreshUserList() {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                val list = dataBase.getUserDao().list()
                runOnUI {
                    if (!hasSetUserId) {
                        list.getOrNull(0)?.id?.let {
                            nowUserId = it
                        }
                    }
                    adapter = UserListAdapter(nowUserId, list, {
                        updateUser(it)
                    }, {
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserIdArgs(it).toBundle()
                        )
                    }, {
                        if (nowUserId != it) {
                            nowUserId = it
                            refreshOptList(it)
                        }
                    }, {
                        //这个是添加操作
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserIdArgs(-1L).toBundle()
                        )
                    })
                    _binding.userList.adapter = adapter


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
                        taskDb?.let { data ->
                            _binding.taskCb.setChecked(data.isSwitch == 1)
                            if(!TextUtils.isEmpty(data.errorStr)){
                                _binding.taskCb.setTipsText(data.errorStr)
                            }else if (data.lastCompletionTime != 0L) {
                                _binding.taskCb.setTipsText(TimeUtils.getNowTime(data.lastCompletionTime))
                            }else{
                                _binding.taskCb.setTipsText("")
                            }
                        }

                        vegetableDb?.let { data ->
                            _binding.vegetableCb.setChecked(data.isSwitch)
                            if(!TextUtils.isEmpty(data.errorStr)){
                                _binding.vegetableCb.setTipsText(data.errorStr)
                            }else if (data.lastCompletionTime != 0L) {
                                _binding.vegetableCb.setTipsText(TimeUtils.getNowTime(data.lastCompletionTime))
                            }else{
                                _binding.taskCb.setTipsText("")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun updateTask(isCheck: Boolean) {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getTaskDao().queryByUserId(nowUserId) ?: TaskDb()).let {
                    it.isSwitch = if (isCheck) 1 else 0
                    if (it.id == 0L) {
                        L.i("新建Task id:${it.id} $isCheck")
                        it.userid = nowUserId
                        dataBase.getTaskDao().insert(it)
                    } else {
                        L.i("更新Task id:${it.id} $isCheck")
                        it.userid = nowUserId
                        dataBase.getTaskDao().update(it)
                    }
                }
            }
        }
    }

    private fun resetTask() {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getTaskDao().queryByUserId(nowUserId) ?: TaskDb()).let {
                    it.lastCompletionTime = 0L
                    if (it.id == 0L) {
                        it.userid = nowUserId
                        dataBase.getTaskDao().insert(it)
                    } else {
                        it.userid = nowUserId
                        dataBase.getTaskDao().update(it)
                    }
                }
            }
        }
    }

    private fun updateVegetable(isCheck: Boolean) {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getVegetableDao().queryByUserId(nowUserId) ?: VegetableDb()).let {
                    it.isSwitch = isCheck
                    if (it.id == 0L) {
                        it.userid = nowUserId
                        dataBase.getVegetableDao().insert(it)
                    } else {
                        it.userid = nowUserId
                        dataBase.getVegetableDao().update(it)
                    }
                }
            }
        }
    }

    private fun resetVegetable() {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                (dataBase.getVegetableDao().queryByUserId(nowUserId) ?: VegetableDb()).let {
                    it.lastCompletionTime = 0L
                    if (it.id == 0L) {
                        it.userid = nowUserId
                        dataBase.getVegetableDao().insert(it)
                    } else {
                        it.userid = nowUserId
                        dataBase.getVegetableDao().update(it)
                    }
                }
            }
        }
    }
}