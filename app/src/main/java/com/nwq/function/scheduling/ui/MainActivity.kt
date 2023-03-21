package com.nwq.function.scheduling.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.core.net.toUri
import com.nwq.function.scheduling.R
import com.nwq.function.scheduling.core_code.CmdType
import com.nwq.function.scheduling.core_code.Constant
import com.nwq.function.scheduling.databinding.ActivityGetColorBinding
import com.nwq.function.scheduling.databinding.ActivityMainBinding
import com.nwq.function.scheduling.utils.BroadcastUtils
import com.nwq.function.scheduling.utils.singleClick
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

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
            SetRoleInfoActivity2.startSetRole(SpConstant.PREFIX_ROLE1, this)
        }
        bind.setRole2.singleClick {
            SetRoleInfoActivity2.startSetRole(SpConstant.PREFIX_ROLE2, this)
        }
        bind.testColor.singleClick {
            SelectModelActivity.startSelectSet(SpConstant.PREFIX_ROLE1, this)
        }

        bind.continueToTheNextCb.isChecked = SPRepo.continueToTheNext
        bind.continueToTheNextCb.setOnCheckedChangeListener { compoundButton, b ->
            SPRepo.continueToTheNext = b
        }
    }
}