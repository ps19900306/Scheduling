package com.nwq.function.corelib.excuter.star_wars.function

import android.graphics.Bitmap
import com.nwq.function.corelib.Constant
import com.nwq.function.corelib.img.task.BasicImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/7/25 15:29
Function description:
 */

class EnemyMonitor(private val zeroList: Array<ImgTaskImpl1>, private val oneList: Array<ImgTaskImpl1>) {


    companion object {

        private const val NO_NUMBER = 0
        private const val ONE_NUMBER = 1
        private const val MULTI_NUMBER = 2


        private const val ABSOLUTELY_SAFE = -1 //安全期
        private const val SLIGHTLY_SAFE = 8 //有白经过
        private const val SMALL_ENEMY = 9 //一个敌军
        private const val VERY_DANGEROUS = 10 //非常危险
    }


    private val numberRecord = arrayOf(0, 0, 0)
    private val safeTimeRecord = arrayOf(0L, 0L, 0L)
    private val notSafeTimeRecord = arrayOf(0L, 0L, 0L)
    private val continueTimeRecord = arrayOf(0L, 0L, 0L)//为上次持续时间


    private var safeLevel = ABSOLUTELY_SAFE
    private var waitTime = 0L
    private var toBeJudged = false

    suspend fun updateInfo(bitmap: Bitmap) {
        zeroList.forEachIndexed { index, task ->
            if (task.verificationRule(bitmap)) {
                updateNumberInfo(index, NO_NUMBER)
            } else {
                if (oneList[index].verificationRule(bitmap)) {
                    updateNumberInfo(index, ONE_NUMBER)
                } else {
                    updateNumberInfo(index, MULTI_NUMBER)
                }
            }
        }
    }

    fun getEnemyNumber(): Int {
        var total = 0
        numberRecord.forEach {
            total += it
        }
        return total
    }

    fun canFight(): Boolean {
        var total = 0
        numberRecord.forEach {
            total += it
        }
        return total <= 1 && safeLevel <= SMALL_ENEMY
    }


    fun isSafe(): Boolean {
        if (!toBeJudged && safeLevel == ABSOLUTELY_SAFE) {
            return true
        }
        toBeJudged = false

        var total = 0
        numberRecord.forEach {
            total += it
        }
        if (total >= 2) {
            updateSafeLevel(VERY_DANGEROUS)
            return false
        } else if (total == 1) { //只有一个敌军先不判断
            updateSafeLevel(SLIGHTLY_SAFE)
            return false
        } else {
            continueTimeRecord.forEach {
                if (it > Constant.MINUTE) {
                    updateSafeLevel(SMALL_ENEMY)
                }
            }
            continueTimeRecord[0] = 0
            continueTimeRecord[1] = 0
            continueTimeRecord[2] = 0


            val nowTime = System.currentTimeMillis()
            if (safeTimeRecord.find { nowTime - it < waitTime } == null) {
                safeLevel = ABSOLUTELY_SAFE
                waitTime = 0L
                return true
            }
        }

        return false
    }


    private fun updateSafeLevel(now: Int) {
        if (now > safeLevel) {
            safeLevel = now
            waitTime = when (now) {
                SLIGHTLY_SAFE -> ((Math.random() + 1) * Constant.MINUTE).toLong()
                SMALL_ENEMY -> ((Math.random() * 3 + 5) * Constant.MINUTE).toLong()
                VERY_DANGEROUS -> ((Math.random() * 5 + 10) * Constant.MINUTE).toLong()
                else -> 0L
            }
        }
    }


    private fun updateNumberInfo(index: Int, number: Int) {
        val lastNumber = numberRecord[index]
        if (number != lastNumber) {
            toBeJudged = true
            val nowTime = System.currentTimeMillis()
            if (number == NO_NUMBER) {//表示刚进入安全时期
                safeTimeRecord[index] = nowTime
                continueTimeRecord[index] = nowTime - notSafeTimeRecord[index]
                numberRecord[index] = number
            } else if (lastNumber == NO_NUMBER) {//表示刚进入敌军来的时候
                notSafeTimeRecord[index] = nowTime
                numberRecord[index] = number
            } else {
                numberRecord[index] = numberRecord[index].coerceAtLeast(number)
            }
        }
    }

}