package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.core_code.img.TwoPointTask
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.executer.fight.rule.*

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
            if (hasTarget(i)) return i
        }
        return -1
    }

    fun getUnTagNumber(): Int {
        for (i in 8 downTo 0) {
            if (hasUnTarget(i)) return i
        }
        return -1
    }

    //是否已经进入空间站 TODO 需要优化取点过多
    fun isInSpaceStation(): Boolean {
        return ImgUtils.findColorLike(
            PixelsInfo(2182, 312, 81, 40), screenBitmap, "#ae9328", 5
        ) || ImgUtils.findColorLike(
            PixelsInfo(2022, 333, 110, 56), screenBitmap, "#ae9328", 5
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
        ) || isClosePositionMenuGray()
    }


    fun isOpenBigMenu(): Boolean {
        val list = listOf(
            verificationTask(172, 48, "#ffe3ebea"),
            verificationTask(172, 55, "#ff337064"),
            verificationTask(166, 60, "#ffe3ebe9"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    fun isHighTask(): Boolean {
        val list = listOf(
            verificationTask(628, 333, AllOver110Rule),
            verificationTask(628, 341, AllLess50Rule),
            verificationTask(628, 349, AllOver110Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun isHighTaskRight(): Boolean {
        val list = listOf(
            verificationTask(2142, 2142, AllOver110Rule),
            verificationTask(2142, 390, AllLess50Rule),
            verificationTask(2142, 399, AllOver110Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //确保存在眼睛菜单
    fun hasEyesMenu(): Boolean {
        if (isCloseEyesMenu() || isOpenEyesMenu()) {
            return true
        } else { //这个就是说不存在菜单则以此判断为不再太空
            return false
        }
    }

    fun isCloseEyesMenu(): Boolean {
        val list = listOf(
            verificationTask(2221, 605, "#ffa2a2a2"),
            verificationTask(2248, 605, "#ff9f9f9f"),
            verificationTask(2234, 605, "#ff9f9f9f"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }


    fun judeIsOpenBottom(indx: Int): Boolean {
        val list = listOf(
            verificationTask(1688 + indx * 109, 949, isOpenRule),
            verificationTask(1689 + indx * 109, 950, isOpenRule),
            verificationTask(1690 + indx * 109, 950, isOpenRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }

    fun judeIsOpenTop(indx: Int): Boolean {
        val list = listOf(
            verificationTask(1688 + indx * 109, 836, isOpenRule),
            verificationTask(1690 + indx * 109, 836, isOpenRule),
            verificationTask(1692 + indx * 109, 836, isOpenRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }

    fun isOpenEyesMenu(): Boolean {
        val list = listOf(
            verificationTask(1843, 605, "#ffa2a2a2"),
            verificationTask(1856, 605, "#ff9f9f9f"),
            verificationTask(1869, 605, "#ff9f9f9f"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }

    //判断菜单是否是打开的
    fun isOpenPostionMenuGray(): Boolean {
        val list = listOf(
            verificationTask(491, 301, "#ff37383a"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //判断菜单是否是关闭
    fun isClosePositionMenu(): Boolean {
        val list = listOf(
            verificationTask(136, 301, "#ff9ca0a5"),
        )
        val list1 = listOf(
            verificationTask(491, 301, "#ffd6d7d7"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        ) && !ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        )
    }


    //判断菜单是否是关闭 此时弹出了确定框
    fun isClosePositionMenuGray(): Boolean {
        val list = listOf(
            verificationTask(136, 301, "#ff37383a"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    fun hasLeftDialogue(): Boolean {
        val list = listOf(
            verificationTask(906, 531, DialogueColorRule),
            verificationTask(928, 531, DialogueColorRule),
            verificationTask(951, 531, DialogueColorRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun hasRightDialogue(): Boolean {
        val list = listOf(
            verificationTask(2011, 469, DialogueColorRule),
            verificationTask(2033, 469, DialogueColorRule),
            verificationTask(2058, 469, DialogueColorRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun shieldTooLow(): Boolean {
        val list = listOf(
            verificationTask(1126, 995, RedRule),
            verificationTask(1232, 855, RedRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun shieldFull(): Boolean {
        val list = listOf(
            verificationTask(1250, 864, AllOver170Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun armorTooLow(): Boolean {
        val list = listOf(
            verificationTask(1139, 993, RedRule),
            verificationTask(1224, 864, RedRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun armorFull(): Boolean {
        val list = listOf(
            verificationTask(1244, 874, AllOver170Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //判断所有的任务是否已经完成
    fun isCompleteAllTask(): Boolean {
        val list = listOf(
            verificationTask(1025, 220, RedRule),
            verificationTask(1075, 220, RedRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    //判断所有的任务是否可以刷新
    fun canRefresh(): Boolean {
        val list = listOf(
            verificationTask(1348, 233, AllOver110Rule),
            verificationTask(1346, 210, AllOver110Rule),
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


    fun judeNowAttackPosition(index: Int): Boolean {
        val list = listOf(
            verificationTask(2245 - (index * 130), 113, NowAttackRule1),
            verificationTask(2246 - (index * 130), 111, NowAttackRule1),
            verificationTask(2241 - (index * 130), 117, NowAttackRule2),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun judeIsSmall(index: Int): Boolean {
        val list = listOf(
            verificationTask((1950 + 260 - 130 * index), 95, RedRule),
            verificationTask((1940 + 260 - 130 * index), 95, RedRule),
            verificationTask((1945 + 260 - 130 * index), 101, RedRule),
            verificationTask((1945 + 260 - 130 * index), 103, NotRedRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }




}