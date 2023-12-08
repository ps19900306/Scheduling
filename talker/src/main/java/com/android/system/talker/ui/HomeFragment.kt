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
import com.android.system.talker.R
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.databinding.FragmentHomeBinding
import com.android.system.talker.view.UserListAdapter

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding

    private lateinit var adapter: UserListAdapter
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
    }


    fun refreshUserList() {
        lifecycleScope.launchWhenResumed {
            runOnIO {
                val list = dataBase.getUserDao().list()
                runOnUI {
                    adapter = UserListAdapter(list, {
                        runOnIO {
                            dataBase.getUserDao().insert(it)
                        }
                    }, {
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserFragmentArgs(it).toBundle()
                        )
                    }, {
                        findNavController().navigate(
                            R.id.action_homeFragment_to_userFragment,
                            UserFragmentArgs(-1).toBundle()
                        )
                    })

                    _binding.userList.adapter = adapter

                }
            }
        }
    }


    fun refreshOptList() {

    }

}