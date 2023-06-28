package com.nwq.function.corelib


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.nwq.function.corelib.NwqAccessibilityService.Companion.Intent_Filter_TAG
import com.nwq.function.corelib.auto_code.AutoCodeActivity
import com.nwq.function.corelib.baseIf.CmdType
import com.nwq.function.corelib.databinding.ActivityMainBinding
import com.nwq.function.corelib.ui.SelectModelActivity
import com.nwq.function.corelib.utils.singleClick
import com.nwq.function.corelib.utils.sp.SPRepo
import com.nwq.function.corelib.utils.sp.SPRepoPrefix
import com.nwq.function.corelib.utils.sp.SpConstant
import kotlinx.coroutines.*
import timber.log.Timber
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val controller = WindowInsetsControllerCompat(window, window.decorView)
//        controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
//        controller.hide(WindowInsetsCompat.Type.navigationBars())
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        val params = window.attributes
//        params.layoutInDisplayCutoutMode =
//            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
//        window.attributes = params

        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1).lastStatus.let {
            bind.role1StatusTv.text = it
        }
        SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2).lastStatus.let {
            bind.role2StatusTv.text = it
        }

        bind.startRole1.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE1
            val intent = Intent(Intent_Filter_TAG)
            intent.setDataAndType(Intent_Filter_TAG.toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.startRole2.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent(Intent_Filter_TAG)
            intent.setDataAndType(Intent_Filter_TAG.toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.closeAll.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent(Intent_Filter_TAG)
            intent.setDataAndType(Intent_Filter_TAG.toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.CLOSE)
            sendBroadcast(intent);
        }

        bind.setRole1.singleClick {
            SelectModelActivity.startSelectSet(SpConstant.PREFIX_ROLE1, this)
        }
        bind.setRole2.singleClick {
            SelectModelActivity.startSelectSet(SpConstant.PREFIX_ROLE2, this)
        }
        bind.testColor.singleClick {
            SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1).lastCompleteTime = 0L
            SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2).lastCompleteTime = 0L
        }

        bind.continueToTheNextCb.isChecked = SPRepo.continueToTheNext
        bind.continueToTheNextCb.setOnCheckedChangeListener { compoundButton, b ->
            SPRepo.continueToTheNext = b
        }

        bind.autoBtn.singleClick {
            //test2()
           startActivity(Intent(this, AutoCodeActivity::class.java))
        }
    }



    private suspend fun startOCR(): String {
        return withContext(Dispatchers.IO) {
            delay(2000)
            Timber.d("Thread startOCR: ${Thread.currentThread().name}")
            "sdf"
        }
    }
}
