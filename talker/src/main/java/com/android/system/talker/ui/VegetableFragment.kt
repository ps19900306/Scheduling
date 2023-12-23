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
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.VegetableDb
import com.android.system.talker.databinding.FragmentVegetableBinding


class VegetableFragment : Fragment() {

    private lateinit var _binding: FragmentVegetableBinding

    private val args by lazy { UserIdArgs(arguments ?: Bundle()) }

    private val vegetableDao by lazy {
        AppDataBase.getInstance(requireContext().applicationContext).getVegetableDao()
    }

    private lateinit var mData: VegetableDb

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVegetableBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenResumed {
            runOnIO {
                mData = vegetableDao.queryByUserId(args.userId) ?: VegetableDb()
                runOnUI {
                    _binding.baseCloneLocationEdt.setText(mData.baseCloneLocation.toString())
                    _binding.baseMenuLocationEdt.setText(mData.baseMenuLocation.toString())
                    _binding.plantCountEdt.setText(mData.numberCount.toString())
                    _binding.addIntervalEdt.setText(mData.addInterval.toString())
                    _binding.completeIntervalEdt.setText(mData.completeInterval.toString())
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
            _binding.plantCountEdt.text.toIntOrNull()?.let {
                mData.numberCount = it
            }
            _binding.addIntervalEdt.text.toIntOrNull()?.let {
                mData.addInterval = it
            }
            _binding.completeIntervalEdt.text.toIntOrNull()?.let {
                mData.completeInterval = it
            }
            lifecycleScope.runOnIO {
                mData.isSwitch = true
                if (mData.id == 0L) {
                    mData.userid = args.userId
                    vegetableDao.insert(mData)
                } else {
                    mData.userid = args.userId
                    vegetableDao.update(mData)
                }
                runOnUI {
                    findNavController().popBackStack()
                }
            }
        }
    }
}