package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.core_code.img.TwoPointTask
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.executer.fight.rule.*
import timber.log.Timber

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
            TwoPointTask(1439, 687, 1437, 672, HasLockComparison),
            TwoPointTask(1439, 675, 1443, 682, HasLockComparison),
            TwoPointTask(1439, 689, 1437, 692, HasLockComparison),
        )
        return ImgUtils.performTwoPointTask(
            list, screenBitmap, 0
        )
    }


    fun getTagNumber(): Int {
        var number = -1
        for (i in 7 downTo 0) {
            if (hasTarget(i)) {
                number = i + 1
                Timber.d("$number getTagNumber FightVisualEnvironment NWQ_ 2023/3/11");
                return number
            }
        }
        Timber.d("$number getTagNumber FightVisualEnvironment NWQ_ 2023/3/11");
        return number
    }

    fun getUnTagNumber(): Int {
        for (i in 8 downTo 0) {
            if (hasUnTarget(i)) {
                Timber.d("$i getUnTagNumber FightVisualEnvironment NWQ_ 2023/3/12");
                return i
            }
        }
        return -1
    }

    //是否已经进入空间站 TODO 需要优化取点过多
    fun isInSpaceStation(): Boolean {
        val list = listOf(
            verificationTask(2038, 360, InSpaceStationRule),
            verificationTask(2066, 360, InSpaceStationRule),
            verificationTask(2054, 360, InSpaceStationRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
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
            verificationTask(2227, 605, AllLess50Rule),
            verificationTask(2218, 605, AllOver150Rule),
            verificationTask(2234, 605, AllOver150Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }


    fun judgeIsOpenBottom(index: Int): Boolean {
        val list = listOf(
            verificationTask(1688 + index * 109, 949, isOpenRule),
            verificationTask(1689 + index * 109, 950, isOpenRule),
            verificationTask(1690 + index * 109, 950, isOpenRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun judgeIsOpenTop(index: Int): Boolean {
        val list = listOf(
            verificationTask(1688 + index * 109, 835, isOpenRule),
            verificationTask(1690 + index * 109, 836, isOpenRule),
            verificationTask(1692 + index * 109, 836, isOpenRule),
        )
        return ImgUtils.performPointsColorVerificationV2(
            list, screenBitmap
        )
    }

    fun isOpenEyesMenu(): Boolean {
        val list = listOf(
            verificationTask(1841, 606, AllOver150Rule),
            verificationTask(1870, 606, AllOver150Rule),
            verificationTask(1862, 606, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }





    //判断菜单是否是打开的
    fun isOpenPositionMenuGray(): Boolean {
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
            verificationTask(136, 375, AllOver200Rule),
            verificationTask(110, 378, AllLess70Rule),
            verificationTask(269, 382, AllLess50Rule),
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
        return isOpenPositionMenu() || isClosePositionMenu()
    }

    //判断菜单是否是打开的
    fun isOpenPositionMenu(): Boolean {
        val list = listOf(
            verificationTask(490, 305, AllOver150Rule),
            verificationTask(490, 291, AllLess70Rule),
            verificationTask(490, 320, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }
    fun isSailing(): Boolean {
        val list = listOf(
            verificationTask(490, 305, AllOver150Rule),
            verificationTask(490, 291, AllLess70Rule),
            verificationTask(490, 320, AllLess70Rule),
            verificationTask(127, 305, AllOver150Rule,1),
            verificationTask(139, 305, AllOver150Rule,1),
            verificationTask(134, 305, AllLess70Rule,1),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }



    //判断菜单是否是关闭
    fun isClosePositionMenu(): Boolean {
        val list = listOf(
            verificationTask(135, 305, AllOver150Rule),
            verificationTask(135, 291, AllLess70Rule),
            verificationTask(135, 320, AllLess70Rule),
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
        val list1 = listOf(
            verificationTask(2170 - 130 * index, 80, AllOver150Rule),
            verificationTask(2241 - 130 * index, 80, AllOver150Rule),
            verificationTask(2175 - 130 * index, 80, AllLess50Rule),
            verificationTask(2235 - 130 * index, 80, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
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
            verificationTask(2168 - (index * 130), 78, AllOver170Rule),
            verificationTask(2169 - (index * 130), 80, AllOver170Rule),
            verificationTask(2243 - (index * 130), 113, AllLess70Rule),
            verificationTask(2244 - (index * 130), 111, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun judgeIsSmall(index: Int): Boolean {
        val list = listOf(
            verificationTask((2200 - 130 * index), 100, RedRule),
            verificationTask((2208 - 130 * index), 100, RedRule),
            verificationTask((2079 - 130 * index), 94, RedRule),
            verificationTask((2070 - 130 * index), 94, RedRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //这里是进入游戏的
    fun hasIntoGame(): Boolean {
        val flag1 = hasPositionMenu()
        val flag2 = hasEyesMenu()
        val flag3 = isInSpaceStation()
     //   Timber.d("hasPositionMenu:$flag1 hasPositionMenu:$flag2  isInSpaceStation:$flag3   hasIntoGame FightVisualEnvironment NWQ_ 2023/3/12");
        return flag1 && (flag2 || flag3)
    }


    fun showAnnouncement(): Boolean {
        val list = listOf(
            verificationTask(2196, 986, IntoAnnouncementRule1),
            verificationTask(2188, 971, IntoAnnouncementRule2),
            verificationTask(2188, 1018, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun readStartGame(): Boolean {
        val list = listOf(
            verificationTask(2196, 986, ReadStartGameRule1),
            verificationTask(2188, 971, AllOver200Rule),
            verificationTask(2188, 1018, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun selectRole(): Boolean {
        val list = listOf(
            verificationTask(535, 605, SelectRoleRule),
            verificationTask(546, 604, SelectRoleRule),
            verificationTask(540, 598, SelectRoleRule),
            verificationTask(549, 611, SelectRoleRule),
            verificationTask(541, 605, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun isOpenBigMenu(): Boolean {
        val list = listOf(
            verificationTask(173, 48, AllOver200Rule),
            verificationTask(173, 55, IsOpenBigMenuRule),
            verificationTask(173, 61, AllOver200Rule),
            verificationTask(173, 68, IsOpenBigMenuRule),
            verificationTask(173, 74, AllOver200Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


}