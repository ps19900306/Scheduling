package com.nwq.function.scheduling.core_code

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.provider.Settings.Global
import android.view.accessibility.AccessibilityEvent
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.executer.star_wars.FightController
import com.nwq.function.scheduling.executer.star_wars.HarvestVegetableController
import com.nwq.function.scheduling.executer.star_wars.MinerController
import com.nwq.function.scheduling.executer.test.ClickTestController
import com.nwq.function.scheduling.utils.ContextUtil
import com.nwq.function.scheduling.utils.TimeUtils
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


/**
create by: 86136
create time: 2023/2/24 13:33
Function description:
 */

class NwqAccessibilityService : AccessibilityService() {

    private val TAG = "NwqAccessibilityService"
    private val list = mutableListOf<TravelController>()
    private val communicationBroadcast by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.let { dealEvent(it) }
            }
        }
    }

    private val helper by lazy {
        AccessibilityHelper(this)
    }

    private val onCompleteLister = {
        SPRepoPrefix.getNowSPRepo().lastCompleteTimeSP = System.currentTimeMillis()
        Timber.d("${SPRepo.role} onCompleteLister NwqAccessibilityService NWQ_ 2023/3/13");
        if (SPRepo.continueToTheNext) {
            SPRepo.role = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
                SpConstant.PREFIX_ROLE2
            } else {
                SpConstant.PREFIX_ROLE1
            }
            var lastTime1 = SPRepoPrefix.getNowSPRepo().lastCompleteTimeSP
            if (TimeUtils.isNewTaskDay(lastTime1)) {
                startOpt(true)
            } else {
                helper.pressHomeBtn()
            }
        }
        true
    }


    private fun startOpt(outGame: Boolean = false) {
        //每次启动都刷新任务数目
        list.forEach { it.close() }
        list.clear()
        if (outGame) {
            if ((helper.screenBitmap?.width ?: 0) > (helper.screenBitmap?.height
                    ?: 0)
            ) helper.pressHomeBtn()
        } else {
            helper.pressHomeBtn()
        }
        if (SPRepoPrefix.getNowSPRepo().nowSelectModeSP == SpConstant.FIGHT_MODEL) {
            Timber.d("启动任务 startOpt NwqAccessibilityService NWQ_ 2023/3/20");
            val fight = FightController(helper, onCompleteLister)
            fight.startOperation()
            list.add(fight)
        } else {
            Timber.d("启动采集 startOpt NwqAccessibilityService NWQ_ 2023/3/20");
            val fight = MinerController(helper, { true })
            fight.startOperation()
            list.add(fight)
        }

    }


    fun dealEvent(intent: Intent) {
        val cmd = intent.getIntExtra(Constant.CMD, CmdType.START)
        when (cmd) {
            CmdType.START -> {
                startOpt()
            }
            CmdType.CLOSE -> {
                list.forEach { it.close() }
                list.clear()
            }
            CmdType.CHECK_COLOR -> {

            }
        }
    }


    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        // 获取包名
        val pkgName = event.packageName.toString();
        val eventType = event.eventType;
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Timber.d("onServiceConnected NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver()
        ContextUtil.context = this


    }

    private fun registerReceiver() {
        Timber.d("registerReceiver NwqAccessibilityService NWQ_ 2023/3/12");
        registerReceiver(communicationBroadcast, IntentFilter.create("schedule.cmd", "cmd/int"))
    }


    override fun onInterrupt() {
        unregisterReceiver(communicationBroadcast)
        Timber.d("onInterrupt NwqAccessibilityService NWQ_ 2023/3/12");
    }


}