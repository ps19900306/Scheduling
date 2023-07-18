package com.nwq.function.corelib.excuter.star_wars

import android.graphics.Bitmap
import com.nwq.function.corelib.img.task.HpTaskImpl
import com.nwq.function.corelib.img.task.ImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/7/17 10:45
Function description:
这个是用来管理顶部的锁定的目标的
 */

class TopTargetMonitor(val tagList: List<ImgTaskImpl1>, val hpList: List<HpTaskImpl>) {

    private val maxSize = tagList.size
    private val toleranceInterval = 15 * 1000

    private var numberOfRounds = 0
    private var lastTargetNumber = 0
    private var lastHpTaskImpl: HpTaskImpl? = null
    private var lastTimeStamp = 0L//用于记录没有变化的时间戳
    var needOpenReducer = false
    private var abnormalRecords = 10 // 如果多次需要开启网子 可能就是卡脚本了
    private var abnormalWaitEnd = 10 // 这个是用来修复

    fun clearData() {
        numberOfRounds = 0
        lastTargetNumber = 0
        lastHpTaskImpl = null
        lastTimeStamp = 0
        needOpenReducer = false
        abnormalRecords = 10
        abnormalWaitEnd = 10
    }


    fun isEndData(): Boolean {
        val flag = numberOfRounds >= 3 && lastTargetNumber == 0
        return flag
    }

    //这里表示过长时间数据异常
    fun isNeedAbnormal(): Boolean {
        return abnormalRecords < 1 || abnormalWaitEnd < 1
    }


    suspend fun updateInfo(bitmap: Bitmap) {
        val nowNumber = getTagNumber(bitmap)
        val nowTime = System.currentTimeMillis()
        if (nowNumber > 0) {//只有目标大于零才进行数据处理
            val nowAttack = getNowAttackTarget(nowNumber, bitmap)
            //目标数目没有变化，攻击的目标相同且血量相同 或者长时间没有目标
            if (nowNumber == lastTargetNumber && lastHpTaskImpl == nowAttack && (nowAttack?.getNowPercent()
                    ?: 100) > 0 && (nowAttack?.getNowPercent()
                    ?: 100) == (lastHpTaskImpl?.getNowPercent() ?: 100)
            ) {//这里表示数值没有变化
                if (lastTimeStamp == 0L) {
                    lastTimeStamp = nowTime
                } else {
                    abnormalRecords--
                    needOpenReducer = (nowTime - lastTimeStamp > toleranceInterval)
                }
            } else {
                abnormalRecords = 10
                needOpenReducer = false
                lastTimeStamp = nowTime
            }

            if (nowNumber >= 3 && lastTargetNumber == 0) { //有新的锁定
                numberOfRounds++
            }
            lastHpTaskImpl = nowAttack
            abnormalWaitEnd = 10
        }else{
            abnormalWaitEnd --
        }
        lastTargetNumber = nowNumber
    }


    //这里获取有几个目标
    private suspend fun getTagNumber(bitmap: Bitmap): Int {
        tagList.forEachIndexed { index, imgTaskImpl1 ->
            if (imgTaskImpl1.verificationRule(bitmap)) {
                return maxSize - index
            }
        }
        return 0
    }

    //这里记录当前的攻击目标
    private suspend fun getNowAttackTarget(startNumber: Int, bitmap: Bitmap): HpTaskImpl? {
        hpList.forEachIndexed { index, hpTaskImpl ->
            if (index >= maxSize - startNumber) {
                if (hpTaskImpl.verificationRule(bitmap)) {
                    return hpTaskImpl
                }
            }
        }
        return null
    }

}