package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.PixelsInfo
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.FindPointByColorTask
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.core_code.img.TwoPointTask
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.executer.star_wars.rule.*
import timber.log.Timber

/**
create by: 86136
create time: 2023/2/28 10:37
Function description:
所有需要进行图片判断的方法都需要放到这个里面
 */

class BaseVisualEnvironment(helper: AccessibilityHelper) : VisualEnvironment(helper) {

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

    //用于判断仓库是否是空的
    fun isEmptyWarehouse(): Boolean {
        val list = listOf(
            TwoPointTask(1423, 491, 1428, 491, AllGreater15Comparison),
            TwoPointTask(1424, 568, 1429, 568, AllGreater15Comparison),
            TwoPointTask(1425, 546, 1430, 546, AllGreater15Comparison),
        )
        return ImgUtils.performTwoPointTask(
            list, screenBitmap, 1
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
        ) && hasPositionMenu()
    }


    fun hasReceivedTask(boolean: Boolean): Boolean {
        if (boolean) {
            val list = listOf(
                verificationTask(1104, 760, AllOver170Rule),
                verificationTask(1094, 760, AllLess50Rule),
                verificationTask(1124, 789, AllLess50Rule),
            )
            return ImgUtils.performPointsColorVerification(
                list, screenBitmap, 0
            )
        }

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

    fun showNotTask(): Boolean {//这个是基于下面的前往公告版 就是没有接取任务
        val list = listOf(
            verificationTask(1375, 801, QingRule),
            verificationTask(1670, 800, QingRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun hasLegionnaires(): Boolean {//这个是判断有军团任务的情况下是否加载了任务
        val list = listOf(
            verificationTask(1937, 588, AllOver150Rule),
            verificationTask(1969, 598, AllOver150Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun hasLegionnairesTask(): Boolean {//这个是判断有军团任务的情况下是否加载了任务
        val list = listOf(
            verificationTask(1104, 760, AllOver170Rule),
            verificationTask(1094, 760, AllLess50Rule),
            verificationTask(1124, 789, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun hasTask(): Boolean {//这个是判断没有军团任务的情况下是否加载了任务
        val list = listOf(
            verificationTask(1105, 591, AllOver170Rule),
            verificationTask(1095, 591, AllLess50Rule),
            verificationTask(1124, 591, AllLess50Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    fun isShowDetermine(): Boolean {
        val list = listOf(
            verificationTask(2001, 824, SimpleRule.getSimple(48, 95, 89), 1),
            verificationTask(1667, 827, SimpleRule.getSimple(28, 48, 49), 1),
            verificationTask(2100, 553, AllLess50Rule, 1),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    fun isHighTask(): Boolean {
        val list = listOf(
            verificationTask(602, 343, HighTaskRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun isHighTaskRight(): Boolean {
        val list = listOf(
            verificationTask(2121, 398, HighTaskRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun checkIsCommonTask(): Int {
        var list = listOf(
            verificationTask(628, 342, BaiQingRule),
            verificationTask(644, 342, QianQingRule),
        )
        if (ImgUtils.performPointsColorVerification(
                list, screenBitmap, 0
            )
        ) return 1
        list = listOf(
            verificationTask(1093, 342, BaiQingRule),
            verificationTask(1109, 342, QianQingRule),
        )
        if (ImgUtils.performPointsColorVerification(
                list, screenBitmap, 0
            )
        ) return 2
        return -1
    }


    fun hasPickUpSuccess(): Boolean {
        val list = listOf(
            verificationTask(2142, 391, AllOver170Rule),
            verificationTask(2152, 391, AllLess70Rule),
        )

        val list2 = listOf(
            verificationTask(2142, 565, AllOver170Rule),
            verificationTask(2152, 565, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        ) || ImgUtils.performPointsColorVerification(
            list2, screenBitmap, 0
        )

        634
    }

    fun hasPickUpSuccessL(): Boolean {
        val list = listOf(
            verificationTask(2142, 634, AllOver170Rule),
            verificationTask(2152, 634, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //确保存在眼睛菜单
    fun hasEyesMenu(): Boolean {
        return isCloseEyesMenu() || isOpenEyesMenu()
    }

    fun isOpenEyesMenu(): Boolean {
        val list = listOf(
            verificationTask(1841, 606, AllOver150Rule),
            verificationTask(1870, 606, AllOver150Rule),
            verificationTask(1862, 606, AllLess80Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 1
        )
    }

    fun isCloseEyesMenu(): Boolean {
        val list = listOf(
            verificationTask(2227, 605, AllLess80Rule),
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


    fun hasGrayPositionMenu(): Boolean {
        return isOpenPositionMenuGray() || isClosePositionMenuGray()
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

    fun isClosePositionMenuGray(): Boolean {
        val list = listOf(
            verificationTask(136, 301, "#ff37383a"),
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


    //是否有位置菜单
    fun hasPositionMenu(): Boolean {
        return isOpenPositionMenu() || isClosePositionMenu()
    }

    //判断菜单是否是打开的
    fun isOpenPositionMenu(): Boolean {
        val list = listOf(
            verificationTask(490, 305, AllOver150Rule),
            verificationTask(490, 291, AllLess80Rule),
            verificationTask(490, 320, AllLess80Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun isSailing(): Boolean {
        val list = listOf(
            verificationTask(490, 305, AllOver150Rule),
            verificationTask(490, 291, AllLess80Rule),
            verificationTask(490, 320, AllLess80Rule),
            verificationTask(127, 305, AllOver150Rule, 1),
            verificationTask(139, 305, AllOver150Rule, 1),
            verificationTask(134, 305, AllLess80Rule, 1),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //判断菜单是否是关闭
    fun isClosePositionMenu(): Boolean {
        val list = listOf(
            verificationTask(135, 305, AllOver150Rule),
            verificationTask(135, 291, AllLess80Rule),
            verificationTask(135, 320, AllLess80Rule),
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
            verificationTask(1007, 213, RedRule, 1),
            verificationTask(1080, 224, RedRule, 1),
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
            verificationTask(2175 - 130 * index, 80, AllLess70Rule),
            verificationTask(2235 - 130 * index, 80, AllLess70Rule),
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

    fun warehouseIsFull(): Boolean {
        val list = listOf(
            verificationTask(141, 144, WarehouseIsFullRule1),
            verificationTask(143, 144, WarehouseIsFullRule1),
            verificationTask(136, 148, WarehouseIsFullRule2),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun judeIsLaunchComplete(position: Int): Boolean {
        var x = 2058
        var y = if (position <= 2) {
            473 + (143 * position)
        } else {
            541 + 143 * (position - 3)
        }
        val list = listOf(
            verificationTask(x, y, LaunchCompleteRule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    fun isShowCollectBtn(): Boolean {
        val list = listOf(
            verificationTask(785, 902, ShowCollectRule1),
            verificationTask(793, 970, ShowCollectRule1),
            verificationTask(787, 872, ShowCollectRule2),
            verificationTask(805, 995, ShowCollectRule2),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //通过颜色去找颜色最接近的点
    fun findPointByColor(
        data: FindPointByColorTask,
        colorRule: String,
        tolerance: Int = 255,
    ): Coordinate? {
        return ImgUtils.findPointByColor(screenBitmap, data, colorRule, tolerance)
    }

    //通过颜色去找颜色最接近的点
    fun findPointByColor(
        data: FindPointByColorTask,
        colorList: List<Int>,
        tolerance: Int = 255,
    ): Coordinate? {
        return ImgUtils.findPointByColor(
            screenBitmap, data, colorList, tolerance
        )
    }


    /********************************************************************************
     * 这个不太确定是啥
     */
    fun isOpenLocalList(): Boolean {
        val list = listOf(
            verificationTask(852, 147, AllOver150Rule),
            verificationTask(842, 157, AllOver150Rule),
            verificationTask(841, 147, AllLess70Rule),
            verificationTask(851, 157, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }


    //是否危险的
    fun isDangerous(localOffsetX: Int, localOffsetY: Int): Boolean {
        return discoverEnemyList(0, localOffsetX, localOffsetY) || discoverEnemyList(
            1, localOffsetX, localOffsetY
        ) || discoverEnemyList(2, localOffsetX, localOffsetY)
    }

    //是否发现敌人 ，发现返回TRUE
    fun discoverEnemyList(Index: Int, offsetX: Int, YOffset: Int): Boolean {
        val XOffset = Index * 124 + offsetX
        val list = listOf(
            verificationTask(567 + XOffset, 712 + YOffset, AllOver140Rule, 1),
            verificationTask(567 + XOffset, 722 + YOffset, AllOver140Rule, 1),
            verificationTask(572 + XOffset, 727 + YOffset, AllOver140Rule, 1),
            verificationTask(578 + XOffset, 721 + YOffset, AllOver140Rule, 1),
            verificationTask(578 + XOffset, 713 + YOffset, AllOver140Rule, 1),
            verificationTask(573 + XOffset, 706 + YOffset, AllOver140Rule, 1),
        )
        return !ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun getOreTargetNumber(): Int {
        var number = -1
        for (i in 4 downTo 0) {
            if (hasOreTarget(i)) {
                number = i + 1
                Timber.d("$number getMiniTarget FightVisualEnvironment NWQ_ 2023/3/11");
                return number
            }
        }
        Timber.d("$number getMiniTarget FightVisualEnvironment NWQ_ 2023/3/11");
        return number
    }

    //是否具有开采的行星目标 这个判断是资源条(从右边数第一个)
    //判断是否存在一个黑圈 通过色差判定
    fun hasOreTarget(index: Int): Boolean {
        val list1 = listOf(
            verificationTask(1800 - 130 * index, 101, AllOver150Rule),
            verificationTask(1798 - 130 * index, 99, AllOver150Rule),
            verificationTask(1787 - 130 * index, 98, AllLess50Rule),
            verificationTask(1797 - 130 * index, 79, AllLess70Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        )
    }

    //右侧菜单是否有条目
    fun hasEyeItem(): Boolean {
        val info = PixelsInfo(1954, 86, 1, 90, 1, 0)
        return ImgUtils.findColorRule(info, screenBitmap, AllOver150Rule)
    }

    //需要根据图片确认位置的
    val REMOTE_PLANETARY_GROUP = 801 //远端行星群
    val RESOURCE_PLANET = 802 //资源行星
    val CURRENT_PLANETARY_GROUP = 803 //当前行星群
    val MENU_NOT_OPEN = 804 //未点开的状态
    fun judeResourceType(position: Int): Int {
        val offestY = 104
        val list1 = listOf(
            verificationTask(1626, 600 - offestY + offestY * position, AllLess70Rule),
            verificationTask(1627, 583 - offestY + offestY * position, AllOver150Rule, 3),
            verificationTask(1627, 615 - offestY + offestY * position, AllOver150Rule, 3),
        )
        if (ImgUtils.performPointsColorVerification(
                list1, screenBitmap, 0
            )
        ) {
            return RESOURCE_PLANET
        }

        val list2 = listOf(
            verificationTask(1626, 378 + offestY * position, AllLess70Rule),
            verificationTask(1627, 362 + offestY * position, AllOver150Rule, 1),
            verificationTask(1627, 395 + offestY * position, AllOver150Rule, 1),
        )
        if (ImgUtils.performPointsColorVerification(
                list2, screenBitmap, 0
            )
        ) {
            return CURRENT_PLANETARY_GROUP
        }

        val list3 = listOf(
            verificationTask(1637, 132 + offestY * position, AllLess70Rule),
            verificationTask(1628, 142 + offestY * position, AllOver150Rule, 1),
            verificationTask(1650, 141 + offestY * position, AllOver150Rule, 1),
        )
        if (ImgUtils.performPointsColorVerification(
                list3, screenBitmap, 0
            )
        ) {
            return REMOTE_PLANETARY_GROUP
        }
        return MENU_NOT_OPEN
    }


    //判断资源条目是否已经到了顶部
    fun IsTheResourceNotTop(): Boolean {
        val info = PixelsInfo(1954, 90, 1, 30, 1, 0)
        return ImgUtils.findColorRule(info, screenBitmap, AllOver150Rule)
    }

    //是否已经损毁
    fun isDamage(): Boolean {
        val list1 = listOf(
            verificationTask(2138, 1012, AllOver200Rule, 1),
            verificationTask(2096, 1017, RedRule, 1),
            verificationTask(2127, 1024, AllLess80Rule, 1),
        )
        return !ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        ) && hasPositionMenu() && hasEyesMenu()
    }

    fun isDamageM(): Boolean {//这个是采矿的损毁
        val list1 = listOf(
            verificationTask(1679, 976, AllOver200Rule, 1),
            verificationTask(1686, 1019, AllLess50Rule, 1),
        )
        return !ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        )
    }


    fun isOpenWallet(): Boolean {
        val list1 = listOf(
            verificationTask(437, 130, AllOver200Rule),
            verificationTask(444, 130, QingRuleN),
            verificationTask(452, 130, AllOver200Rule),
        )
        return ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        ) && !hasPositionMenu()
    }


    fun isShowTaskOpt(): Boolean {
        val list1 = listOf(
            verificationTask(1724, 914, QingRule),
            verificationTask(1820, 914, QingRule),
        )
        return !ImgUtils.performPointsColorVerification(
            list1, screenBitmap, 0
        )
    }

    //判断是否是普通异常
    fun isCommonUnusual() {

    }

}