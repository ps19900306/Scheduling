package com.nwq.function.corelib

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.accessibility.AccessibilityEvent
import com.nwq.function.corelib.baseIf.CmdType
import com.nwq.function.corelib.excuter.BaseController
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.excuter.star_wars.AdventureTaskController
import com.nwq.function.corelib.excuter.star_wars.GetColorController
import com.nwq.function.corelib.excuter.star_wars.InterstellarMiners
import com.nwq.function.corelib.utils.ContextUtil
import com.nwq.function.corelib.utils.TimeUtils
import com.nwq.function.corelib.utils.sp.SPRepo
import com.nwq.function.corelib.utils.sp.SPRepoPrefix
import com.nwq.function.corelib.utils.sp.SpConstant
import timber.log.Timber


/**
create by: 86136
create time: 2023/2/24 13:33
Function description:
 */

class NwqAccessibilityService : AccessibilityService() {

    private val TAG = "NwqAccessibilityService"
    private val cList = mutableListOf<BaseController>()

    companion object {
        const val Intent_Filter_TAG = "schedule.cmd.v2"
    }


    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let { dealEvent(it) }
            }
        }
    }

    val endLister = object : EndLister {
        override fun onEndLister() {
            if (SPRepoPrefix.getNowSPRepo().nowSelectMode == SpConstant.FIGHT_MODEL) {
                SPRepoPrefix.getNowSPRepo().lastCompleteTime = System.currentTimeMillis()
            }
            Timber.d("${SPRepo.role} onCompleteLister NwqAccessibilityService NWQ_ 2023/3/13");
            if (SPRepo.continueToTheNext) {
                val spReo = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
                    SPRepo.role = SpConstant.PREFIX_ROLE2
                    SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE2)
                } else {
                    SPRepo.role = SpConstant.PREFIX_ROLE1
                    SPRepoPrefix.getSPRepo(SpConstant.PREFIX_ROLE1)
                }
                if (spReo.nowSelectMode == SpConstant.MINER_MODEL || TimeUtils.isNewTaskDay(spReo.lastCompleteTime)) {
                    startOpt(false)
                }
            }
        }
    }

    private fun startOpt(pressBackHome: Boolean = false) {
        Timber.d("启动脚本 GetColorController NWQ_ 2023/3/12");
        val interstellarMiners = AdventureTaskController(this, endLister)
        interstellarMiners.startWork(pressBackHome)
        cList.add(interstellarMiners)
    }

    fun dealEvent(intent: Intent) {
        val cmd = intent.getIntExtra(Constant.CMD, CmdType.START)
        when (cmd) {
            CmdType.START -> {
                cList.forEach { it.closeWork() }
                cList.clear()
                startOpt(true)
            }
            CmdType.CLOSE -> {
                cList.forEach { it.closeWork() }
                cList.clear()
            }
            CmdType.CHECK_COLOR -> {
                if (cList.find { it is GetColorController } == null) {
                    Timber.d("启动脚本 GetColorController NWQ_ 2023/3/12");
                    val interstellarMiners = GetColorController(this, endLister)
                    interstellarMiners.startWork()
                    cList.add(interstellarMiners)
                }
            }
        }
    }


    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.d("onServiceConnected NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver()
        ContextUtil.context = this
    }

    private fun registerReceiver() {
        Timber.d("registerReceiver NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver(communicationBroadcast, IntentFilter.create(Intent_Filter_TAG, "cmd/int"))
    }

    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {

    }


    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        Timber.d("onInterrupt NwqAccessibilityService NWQ_ 2023/3/12");
    }


}