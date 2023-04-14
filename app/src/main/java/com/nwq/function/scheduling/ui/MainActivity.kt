package com.nwq.function.scheduling.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.nwq.function.scheduling.auto_code.ui.AutoCodeActivity
import com.nwq.function.scheduling.core_code.CmdType
import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.databinding.ActivityMainBinding
import com.nwq.function.scheduling.utils.singleClick
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant


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
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.startRole2.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            intent.putExtra(Constant.CMD, CmdType.START)
            sendBroadcast(intent);
        }
        bind.closeAll.singleClick {
            SPRepo.role = SpConstant.PREFIX_ROLE2
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
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
            startActivity(Intent(this, AutoCodeActivity::class.java))
        }
    }
}