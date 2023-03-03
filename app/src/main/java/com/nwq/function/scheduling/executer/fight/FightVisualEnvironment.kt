package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.core_code.img.TwoPointTask
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.executer.fight.rule.AllGreater10Comparison
import com.nwq.function.scheduling.executer.fight.rule.AllOver110Rule
import com.nwq.function.scheduling.executer.fight.rule.AllLess50Rule
import com.nwq.function.scheduling.executer.fight.rule.AllOver200Rule

/**
create by: 86136
create time: 2023/2/28 10:37
Function description:
所有需要进行图片判断的方法都需要放到这个里面
 */

class FightVisualEnvironment(helper: AccessibilityHelper) : VisualEnvironment(helper) {


    //是否有全部锁定按钮
    fun hasGroupLock(): Boolean {
        val list = listOf(
            verificationTask(1439f, 687f, AllOver110Rule),
            verificationTask(1439f, 675f, AllOver110Rule),
            verificationTask(1439f, 689f, AllOver110Rule),
            verificationTask(1437f, 672f, AllLess50Rule),
            verificationTask(1443f, 682f, AllLess50Rule),
            verificationTask(1437f, 692f, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    //是否已经进入
    fun hasIntoGame(): Boolean {
        return false
    }

    fun getTagNumber(): Int {
        for (i in 8 downTo 0) {
            if (hasTarget(i))
                return i
        }
        return -1
    }

    fun getUnTagNumber(): Int {
        for (i in 8 downTo 0) {
            if (hasUnTarget(i))
                return i
        }
        return -1
    }

    //是否已经进入空间站 TODO 需要优化取点过多
    fun isInSpaceStation(): Boolean {
        return ImgUtils.findColorLike(PixelsInfo(2182, 312, 81, 40), screenBitmap, "#ae9328", 5)
                || ImgUtils.findColorLike(
            PixelsInfo(2022, 333, 110, 56),
            screenBitmap,
            "#ae9328",
            5
        )
    }


    //是否已经 TODO 需要优化取点过多
    fun hasReceivedTask(): Boolean {
        val list = listOf(
            verificationTask(1424, 787, AllOver200Rule),
            verificationTask(1492, 785, AllOver200Rule),
            verificationTask(1628, 789, AllOver200Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun isShowDetermine(): Boolean {
        val list = listOf(
            verificationTask(2118, 780, "#ff2d5a55"),
            verificationTask(2013, 843, "#ff33615d"),
            verificationTask(2215, 849, "#ff315f5a"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    /**
     * 下面是私有方法
     */
    //有已经锁定的目标
    private fun hasTarget(index: Int): Boolean {
        var a1 = Coordinate((2233 - (index * 121)).toFloat(), 91F)
        var a = Coordinate((2229 - (index * 121)).toFloat(), 89F)
        val task1 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate((2198 - (index * 121)).toFloat(), 38F)
        a = Coordinate((2198 - (index * 121)).toFloat(), 42F)
        val task2 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate((2159 - (index * 121)).toFloat(), 81F)
        a = Coordinate((2164 - (index * 121)).toFloat(), 81F)
        val task3 = TwoPointTask(a1, a, AllGreater10Comparison)

        return ImgUtils.performTwoPointTask(
            listOf(task1, task2, task3), screenBitmap, 0
        )
    }

    //有未锁定的目标
    private fun hasUnTarget(index: Int): Boolean {
        var a1 = Coordinate((2246 - (index * 121)).toFloat(), 85F)
        var a = Coordinate((2250 - (index * 121)).toFloat(), 85F)
        val task1 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate((2196 - (index * 121)).toFloat(), 29F)
        a = Coordinate((2196 - (index * 121)).toFloat(), 24F)
        val task2 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate((2148 - (index * 121)).toFloat(), 80F)
        a = Coordinate((2143 - (index * 121)).toFloat(), 80F)
        val task3 = TwoPointTask(a1, a, AllGreater10Comparison)

        return ImgUtils.performTwoPointTask(
            listOf(task1, task2, task3), screenBitmap, 0
        )
    }


}