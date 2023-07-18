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
    private var lastHpTaskImpl: AttackTargetResult? = null
    private var roundMaxNumber = 0
    private var lastTimeStamp = 0L//用于记录没有变化的时间戳
    var needOpenReducer = false
    private val maxAbnormal = 30
    private var abnormalRecords = maxAbnormal // 如果多次需要开启网子 可能就是卡脚本了
    private var abnormalWaitEnd = maxAbnormal // 这个是用来修复


    fun clearData() {
        numberOfRounds = 0
        lastTargetNumber = 0
        lastHpTaskImpl = null
        lastTimeStamp = 0
        needOpenReducer = false
        abnormalRecords = maxAbnormal
        abnormalWaitEnd = maxAbnormal
    }

    private var newAgainLock = false // 在一个回合里 第一次再次锁定则可以开一次网子

    //挡触发新的锁定
    fun onNewLock(): Boolean {
        lastTimeStamp = System.currentTimeMillis()
        if (newAgainLock && lastTargetNumber > 4) {
            newAgainLock = false
            return true
        }
        return false
    }

    //是否结束战斗了 默认是三轮
    fun isEndData(): Boolean {
        val flag = numberOfRounds >= 3 && lastTargetNumber == 0
        return flag
    }

    //这里表示过长时间数据异常 这里需要回去修正错误
    fun isNeedAbnormal(): Boolean {
        return abnormalRecords < 1 || abnormalWaitEnd < 1
    }


    suspend fun updateInfo(bitmap: Bitmap) {
        val nowNumber = getTagNumber(bitmap)
        val nowTime = System.currentTimeMillis()
        if (lastTargetNumber == 0) {
            if (nowNumber <= 0) {
                abnormalWaitEnd--
            } else {
                lastTimeStamp = nowTime
                newAgainLock = true
                roundMaxNumber = 0
                numberOfRounds++
            }
        } else if (nowNumber > 0) {
            roundMaxNumber = roundMaxNumber.coerceAtLeast(nowNumber)
            val nowAttack = getNowAttackTarget(nowNumber, bitmap)
            //这里对lastTimeStamp进行赋值
            if (lastTimeStamp == 0L) {
                lastTimeStamp = nowTime
            }
            //这里表示刚好比最大值少了一个
            if (nowNumber >= lastTargetNumber ) {
                if (nowTime - lastTimeStamp > toleranceInterval * 6) {
                    lastTimeStamp = nowTime
                    needOpenReducer = true
                } else if (nowNumber == roundMaxNumber - 1 && (nowAttack?.index
                        ?: 10) != roundMaxNumber
                ) {
                    lastTimeStamp = nowTime
                    needOpenReducer = true
                } else if (nowNumber == lastTargetNumber && lastHpTaskImpl == nowAttack && (nowAttack?.task?.getNowPercent()
                        ?: 0) == (lastHpTaskImpl?.task?.getNowPercent() ?: 0)  && (nowTime - lastTimeStamp > toleranceInterval)
                ) {
                    needOpenReducer = true
                    lastTimeStamp = nowTime
                }
                abnormalRecords--
            } else {
                abnormalRecords = maxAbnormal
                needOpenReducer = false
                lastTimeStamp = nowTime
            }
        }
        abnormalWaitEnd--
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
    private suspend fun getNowAttackTarget(startNumber: Int, bitmap: Bitmap): AttackTargetResult? {
        hpList.forEachIndexed { index, hpTaskImpl ->
            if (index >= maxSize - startNumber) {
                if (hpTaskImpl.verificationRule(bitmap)) {
                    return AttackTargetResult(hpTaskImpl, maxSize - index)
                }
            }
        }
        return null
    }


    internal data class AttackTargetResult(val task: HpTaskImpl, val index: Int)
}