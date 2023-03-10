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
            verificationTask(1439, 687, AllOver110Rule),
            verificationTask(1439, 675, AllOver110Rule),
            verificationTask(1439, 689, AllOver110Rule),
            verificationTask(1437, 672, AllLess50Rule),
            verificationTask(1443, 682, AllLess50Rule),
            verificationTask(1437, 692, AllLess50Rule),
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
            PixelsInfo(2182, 312, 81, 40), screenBitmap, "#ffae9328", 15
        ) || ImgUtils.findColorLike(
            PixelsInfo(2022, 333, 110, 56), screenBitmap, "#ffae9328", 15
        )
    }


    fun hasReceivedTask(): Boolean {
        val list = listOf(
            verificationTask(1424, 787, AllOver200Rule),
            verificationTask(1492, 785, AllOver200Rule),
            verificationTask(1628, 789, AllOver200Rule),
        )
        val list2 = listOf(
            verificationTask(1476, 791, AllOver200Rule),
            verificationTask(1496, 800, AllOver200Rule),
            verificationTask(1538, 806, AllOver200Rule),
        )
        if (ImgUtils.performPointsColorVerification(
                list, screenBitmap, 0
            )
        ) {
            return false
        } else if (ImgUtils.performPointsColorVerification(
                list2, screenBitmap, 0
            )
        ) {
            return false
        } else {
            return true
        }
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
            verificationTask(2142, 381, AllOver110Rule),
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
            verificationTask(2221, 605, "#ffa2a2a2", 15),
            verificationTask(2248, 605, "#ff9f9f9f", 15),
            verificationTask(2234, 605, "#ff9f9f9f", 15),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }


    fun judgeIsOpenBottom(indx: Int): Boolean {
        val list = listOf(
            verificationTask(1688 + indx * 109, 949, isOpenRule),
            verificationTask(1689 + indx * 109, 950, isOpenRule),
            verificationTask(1690 + indx * 109, 950, isOpenRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }

    fun judgeIsOpenTop(indx: Int): Boolean {
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
            verificationTask(1843, 605, "#ffa2a2a2", 15),
            verificationTask(1856, 605, "#ff9f9f9f", 15),
            verificationTask(1869, 605, "#ff9f9f9f", 15),
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

    //是不是默认的坐标菜单
    fun isDefaultCoordinateMenu(): Boolean {
        val list = listOf(
            verificationTask(128, 358, "#ff326e64"),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
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

    //是否有位置菜单
    fun hasPositionMenu(): Boolean {
        val list = listOf(
            verificationTask(136, 301, "#ff9ca0a5"),
            verificationTask(491, 301, "#ffd6d7d7"),
        )
        return !ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap,
        )
    }

    //判断菜单是否是打开的
    fun isOpenPositionMenu(): Boolean {
        val list = listOf(
            verificationTask(136, 301, "#ff9ca0a5"),
        )
        val list1 = listOf(
            verificationTask(491, 301, "#ffd6d7d7"),
        )
        return !ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        ) && ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
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
        var a1 = Coordinate(2205 - (index * 130), 41)
        var a = Coordinate(2205 - (index * 130), 46)
        val task1 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate(2169 - (index * 130), 76)
        a = Coordinate(2164 - (index * 130), 76)
        val task2 = TwoPointTask(a1, a, AllGreater10Comparison)

        a1 = Coordinate(2241 - (index * 130), 77)
        a = Coordinate(2245 - (index * 130), 77)
        val task3 = TwoPointTask(a1, a, AllGreater10Comparison)

        return ImgUtils.performTwoPointTask(
            listOf(task1, task2, task3), screenBitmap, 0
        )
    }

    //有未锁定的目标
    private fun hasUnTarget(index: Int): Boolean {
        val list1 = listOf(
            verificationTask(2204 - 130 * index, 71, RedRule),
            verificationTask(2194 - 130 * index, 80, RedRule),
            verificationTask(2214 - 130 * index, 80, RedRule),
            verificationTask(2205 - 130 * index, 76, RedRule),
        )

        val list2 = listOf(
            verificationTask((2075 + 130 - 130 * index), 64, RedRule),
            verificationTask((2065 + 130 - 130 * index), 73, RedRule),
            verificationTask((2084 + 130 - 130 * index), 86, RedRule),
            verificationTask((2205 - 130 * index), 76, RedRule),
        )

        val list3 = listOf(
            verificationTask((1945 + 130 * 2 - 130 * index), 67, RedRule),
            verificationTask((1935 + 130 * 2 - 130 * index), 97, RedRule),
            verificationTask((1955 + 130 * 2 - 130 * index), 79, RedRule),
            verificationTask((2205 - 130 * index), 76, RedRule),
        )

        val list4 = listOf(
            verificationTask((1815 + 130 * 3 - 130 * index), 65, RedRule),
            verificationTask((1805 + 130 * 3 - 130 * index), 77, RedRule),
            verificationTask((1826 + 130 * 3 - 130 * index), 77, RedRule),
            verificationTask((2205 - 130 * index), 76, RedRule),
        )
        return ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        ) || ImgUtils.performPointsColorVerification(
            list2, screenBitmap, 0
        ) || ImgUtils.performPointsColorVerification(
            list3, screenBitmap, 0
        ) || ImgUtils.performPointsColorVerification(
            list4, screenBitmap, 0
        )
    }


    fun judgeNowAttackPosition(index: Int): Boolean {
        val list = listOf(
            verificationTask(2245 - (index * 130), 113, NowAttackRule1),
            verificationTask(2246 - (index * 130), 111, NowAttackRule1),
            verificationTask(2241 - (index * 130), 117, NowAttackRule2),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun judgeIsSmall(index: Int): Boolean {
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