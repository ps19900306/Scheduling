package com.nwq.function.corelib.excuter.star_wars.function

import android.graphics.Bitmap
import com.nwq.function.corelib.img.task.BasicImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/7/25 15:29
Function description:
 */

class EnemyMonitor(val zeroList: Array<BasicImgTask>, val oneList: Array<BasicImgTask>) {


    companion object {
        private const val WHITE_TYPE = 0
        private const val RED_TYPE = 1
        private const val DANGEROUS_TYPE = 2
        private const val SAFE_TYPE = 3

        private const val NO_NUMBER = 0
        private const val ONE_NUMBER = 1
        private const val MULTI_NUMBER = 2
    }



    private val numberRecord = arrayOf(0, 0, 0)
    private val safeTimeRecord = arrayOf(0L, 0L, 0L)
    private val notSafeTimeRecord = arrayOf(0L, 0L, 0L)

    private val continueTimeRecord = arrayOf(0L, 0L, 0L)//为偶像欧

    private val size = 3
    private var lastStatus = SAFE_TYPE
    private var needBack = true


    suspend fun updateInfo(bitmap: Bitmap) {
        zeroList.forEachIndexed { index, task ->
            if (!task.verificationRule(bitmap)) {
                if (oneList[index].verificationRule(bitmap)) {
                    updateNumberInfo(index, ONE_NUMBER)
                } else {
                    updateNumberInfo(index, MULTI_NUMBER)
                }
            } else {
                updateNumberInfo(index, NO_NUMBER)
            }
        }
    }

    private fun updateNumberInfo(index: Int, number: Int) {
        val lastNumber = numberRecord[index]
        if (number != lastNumber) {
             if(number==NO_NUMBER){

             }
        }
    }


    suspend fun checkZero(bitmap: Bitmap): Int {
        zeroList.forEachIndexed { index, task ->
            if (!task.verificationRule(bitmap)) {
                return size - index
            }
        }
        return SAFE_TYPE
    }


}