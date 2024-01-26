package com.android.system.calendar.ui

import android.content.Context
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.controller.ImageTakeUtils
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.calendar.CalendarAccessibilityService
import com.android.system.calendar.R
import com.android.system.calendar.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var mMediaProjectionManager: MediaProjectionManager? = null
    private val requestDataLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                result.data?.let {
                    ImageTakeUtils.startRecord(
                        mMediaProjectionManager!!, result.resultCode, it,
                        Handler(Looper.getMainLooper()), resources.displayMetrics
                    )
                }
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button.singleClick {
            mMediaProjectionManager =
               activity?.getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager?;
            mMediaProjectionManager?.createScreenCaptureIntent()?.let {
                requestDataLauncher.launch(it)
            }
        }

        binding.startOriginBtn.singleClick {
            CalendarAccessibilityService.instance?.startOrigin()
        }

        binding.startDailyBtn.singleClick {
            CalendarAccessibilityService.instance?.startDaily()
        }

        binding.startDungeonBtn.singleClick {
            CalendarAccessibilityService.instance?.startDungeon()
        }


        binding.startShiMenBtn.singleClick {
            CalendarAccessibilityService.instance?.startShiMen()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}