package com.android.system.talker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.schedule.corelibrary.expand.runOnIO
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.TimeUtils
import com.android.system.talker.R
import com.android.system.talker.database.AppDataBase
import com.android.system.talker.database.UserDb
import com.android.system.talker.databinding.FragmentHomeBinding
import com.android.system.talker.databinding.FragmentUserBinding


class UserFragment : Fragment() {


    private lateinit var _binding: FragmentUserBinding

    private val args by lazy { UserIdArgs(arguments ?: Bundle()) }

    private val userDao by lazy {
        AppDataBase.getInstance(requireContext()).getUserDao()
    }
    private lateinit var mData: UserDb

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            runOnIO {
                mData = if (args.userId != -1L) {
                    userDao.queryById(args.userId) ?: UserDb()
                } else {
                    UserDb()
                }
                runOnUI {
                    _binding.userNameEdt.setText(mData.sccoutStr)
                    _binding.baseMenuLocationEdt.setText(mData.baseMenuLocation.toString())
                    _binding.baseCloneLocationEdt.setText(mData.baseCloneLocation.toString())
                    _binding.dailyGiftCb.setChecked(mData.dailyGiftSwitch)
                    _binding.agreementGiftCb.setChecked(mData.agreementGiftSwitch)
                    _binding.activeGiftCb.setChecked(mData.activeGiftSwitch)
                    _binding.appLocationXEdt.setText(mData.appLocationX.toString())
                    _binding.appLocationYEdt.setText(mData.appLocationY.toString())


                    if (mData.dailyGiftTime != 0L) {
                        _binding.dailyGiftCb.setTipsText(TimeUtils.getNowTime(mData.dailyGiftTime))
                    }
                    if (mData.activeGiftTime != 0L) {
                        _binding.activeGiftCb.setTipsText(TimeUtils.getNowTime(mData.activeGiftTime))
                    }
                    if (mData.agreementGiftTime != 0L) {
                        _binding.agreementGiftCb.setTipsText(TimeUtils.getNowTime(mData.agreementGiftTime))
                    }

                }
            }
        }

        _binding.saveBtn.singleClick {
            mData.sccoutStr = _binding.userNameEdt.text.toString()
            _binding.baseCloneLocationEdt.text.toString().toIntOrNull()?.let {
                mData.baseCloneLocation = it
            }
            _binding.baseMenuLocationEdt.text.toString().toIntOrNull()?.let {
                mData.baseMenuLocation = it
            }
            mData.dailyGiftSwitch = _binding.dailyGiftCb.isChecked
            mData.agreementGiftSwitch = _binding.agreementGiftCb.isChecked
            mData.activeGiftSwitch = _binding.activeGiftCb.isChecked
            _binding.appLocationXEdt.text.toString().toIntOrNull()?.let {
                mData.appLocationX = it
            }
            _binding.appLocationYEdt.text.toString().toIntOrNull()?.let {
                mData.appLocationY = it
            }
            lifecycleScope.runOnIO {
                if (mData.id == 0L) {
                    userDao.insert(mData)
                } else {
                    userDao.update(mData)
                }
                runOnUI {
                    findNavController().popBackStack()
                }
            }
        }


        _binding.dailyGiftCb.setButtonClickBack {
            mData.dailyGiftTime = 0L
        }
        _binding.agreementGiftCb.setButtonClickBack {
            mData.agreementGiftTime = 0L
        }
        _binding.activeGiftCb.setButtonClickBack {
            mData.activeGiftTime = 0L
        }
    }


}