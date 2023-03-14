package com.nwq.function.scheduling.core_code

import android.accessibilityservice.AccessibilityService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.view.accessibility.AccessibilityEvent
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import com.nwq.function.scheduling.executer.star_wars.FightController
import com.nwq.function.scheduling.utils.ContextUtil
import com.nwq.function.scheduling.utils.TimeUtils
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant
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
        val nowRole = SPRepo.role
        var lastTime by SP(nowRole + SpConstant.LAST_COMPLETE_TIME, 0L)
        lastTime = System.currentTimeMillis()
        var count by SP(nowRole + SpConstant.NUMBER_OF_TASKS_RECEIVED, 0)
        count = 0
        Timber.d("${SPRepo.role} onCompleteLister NwqAccessibilityService NWQ_ 2023/3/13");
        if (SPRepo.continueToTheNext) {
            val nextRole = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
                SpConstant.PREFIX_ROLE2
            } else {
                SpConstant.PREFIX_ROLE1
            }
            SPRepo.role = nextRole
            var lastTime1 = SP.getValue(nextRole + SpConstant.LAST_COMPLETE_TIME, 0L)
            if (TimeUtils.isNewTaskDay(lastTime1)) {
                startOpt(true)
            }
        }
        true
    }


    private fun startOpt(outGame: Boolean = false) {
        var count by SP(SPRepo.role + SpConstant.NUMBER_OF_TASKS_RECEIVED, 0)
        var lastTime = SP.getValue(SPRepo.role + SpConstant.LAST_COMPLETE_TIME, 0L)
        if (count == 0 && TimeUtils.isNewTaskDay(lastTime)) {
            Timber.d("刷新任务数 ${SPRepo.role} startOpt NwqAccessibilityService NWQ_ 2023/3/13");
            count = 50
        }

        list.forEach { it.close() }
        list.clear()
        if (outGame) {
            if ((helper.screenBitmap?.width ?: 0) > (helper.screenBitmap?.height
                    ?: 0)
            ) helper.pressHomeBtn()
        } else {
            helper.pressHomeBtn()
        }
        val fight = FightController(helper, onCompleteLister)
        fight.startGame()
        list.add(fight)
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