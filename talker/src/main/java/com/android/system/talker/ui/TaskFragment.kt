package com.android.system.talker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.expand.runOnIO
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.TaskDb
import com.android.system.talker.databinding.FragmentTaskBinding
import kotlinx.coroutines.delay


class TaskFragment : Fragment() {

    private lateinit var _binding: FragmentTaskBinding
    private val args by lazy { UserIdArgs(arguments ?: Bundle()) }

    private val mDao by lazy {
        AppDataBase.getInstance(requireContext().applicationContext).getTaskDao()
    }

    private lateinit var mData: TaskDb
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            runOnIO {
                mData = mDao.queryByUserId(args.userId) ?: TaskDb()
                runOnUI {
                    _binding.baseCloneLocationEdt.setText(mData.baseCloneLocation.toString())
                    _binding.baseMenuLocationEdt.setText(mData.baseMenuLocation.toString())
                }
            }
        }

        _binding.saveBtn.singleClick {
            _binding.baseCloneLocationEdt.text.toIntOrNull()?.let {
                mData.baseCloneLocation = it
            }
            _binding.baseMenuLocationEdt.text.toIntOrNull()?.let {
                mData.baseMenuLocation = it
            }
            lifecycleScope.runOnIO {
                mData.isSwitch = 1
                if (mData.id == 0L) {
                    mData.userid = args.userId
                    mDao.insert(mData)
                } else {
                    mData.userid = args.userId
                    L.i("保存更新TaskDb id:${mData.id} ${mData.isSwitch})")
                    mDao.update(mData)
                    delay(1000)
                }
                runOnUI {
                    findNavController().popBackStack()
                }
            }
        }
    }
}