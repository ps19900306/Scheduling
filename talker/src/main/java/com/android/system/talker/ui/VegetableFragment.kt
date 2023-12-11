package com.android.system.talker.ui

import android.os.Bundle
import android.util.Log
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
import com.android.system.talker.R
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.database.VegetableDb
import com.android.system.talker.databinding.FragmentUserBinding
import com.android.system.talker.databinding.FragmentVegetableBinding


class VegetableFragment : Fragment() {

    private lateinit var _binding: FragmentVegetableBinding

    private val args by lazy { UserIdArgs(arguments ?: Bundle()) }

    private val vegetableDao by lazy {
        AppDataBase.getInstance(requireContext()).getVegetableDao()
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
                L.i("lala VegetableDb ${mData.id} userID: ${mData.userid}")
                vegetableDao.list().forEach {
                    L.i("VegetableDb ${it.id} userID: ${it.userid}")
                }

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
            _binding.baseCloneLocationEdt.text.toString().toIntOrNull()?.let {
                mData.baseCloneLocation = it
            }
            _binding.baseMenuLocationEdt.text.toString().toIntOrNull()?.let {
                mData.baseMenuLocation = it
            }
            _binding.plantCountEdt.text.toString().toIntOrNull()?.let {
                mData.numberCount = it
            }
            _binding.addIntervalEdt.text.toString().toIntOrNull()?.let {
                mData.addInterval = it
            }
            _binding.completeIntervalEdt.text.toString().toIntOrNull()?.let {
                mData.completeInterval = it
            }
            lifecycleScope.runOnIO {
                mData.switch = true
                vegetableDao.insert(mData)
                runOnUI {
                    findNavController().popBackStack()
                }
            }
        }
    }
}