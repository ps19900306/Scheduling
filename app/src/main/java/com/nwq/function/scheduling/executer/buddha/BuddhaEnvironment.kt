package com.nwq.function.scheduling.executer.buddha

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.executer.base.VisualEnvironment

class BuddhaEnvironment(helper: AccessibilityHelper) : VisualEnvironment(helper) {

    fun updateEquipmentColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1622, 623, 227, 136, 79),
            buildSinglePointTask(1757, 621, 230, 146, 84),
            buildSinglePointTask(1618, 677, 232, 148, 84),
            buildSinglePointTask(1756, 675, 220, 110, 57),
            buildSinglePointTask(1756, 675, 220, 110, 57),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun summoningEagleColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2058, 895, 255, 250, 235),
            buildSinglePointTask(2055, 915, 255, 246, 230),
            buildSinglePointTask(2040, 898, 215, 113, 73),
            buildSinglePointTask(2042, 916, 229, 139, 87),
            buildSinglePointTask(2183, 905, 255, 247, 232),
        )

        // Screenshot_2023-04-14-23-32-53-143_com.lxzucvt7us.wknp497.jpg
        val list1 = listOf(
            buildSinglePointTask(2060, 893, 112, 92, 85),
            buildSinglePointTask(2108, 898, 157, 137, 128),
            buildSinglePointTask(2195, 890, 92, 73, 67),
            buildSinglePointTask(2151, 897, 125, 105, 98),
            buildSinglePointTask(2077, 903, 245, 243, 228),
            buildSinglePointTask(2128, 898, 248, 246, 231),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        ) || ImgUtils.performPointsColorVerification(list1, screenBitmap, 0)
    }


    fun skipAnimationColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1316, 656, 128, 113, 94),
            buildSinglePointTask(1337, 666, 156, 140, 117),
            buildSinglePointTask(1325, 662, 133, 116, 96),
            buildSinglePointTask(1361, 665, 139, 120, 103),
            buildSinglePointTask(1346, 663, 252, 249, 204),
            buildSinglePointTask(1368, 668, 252, 249, 204),
            buildSinglePointTask(1307, 656, 252, 247, 205),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    // Screenshot_2023-04-14-23-31-30-367_com.lxzucvt7us.wknp497.jpg
    fun tapToContinueColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2023, 946, 250, 236, 207),
            buildSinglePointTask(2067, 958, 254, 245, 216),
            buildSinglePointTask(2101, 952, 255, 246, 212),
            buildSinglePointTask(2185, 946, 255, 242, 208),
            buildSinglePointTask(2256, 951, 255, 253, 239),
            buildSinglePointTask(2296, 958, 251, 239, 213),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun skipConversationColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2190, 61, 252, 238, 209),
            buildSinglePointTask(2207, 56, 255, 245, 221),
            buildSinglePointTask(2227, 57, 255, 246, 216),
            buildSinglePointTask(2250, 57, 251, 232, 200),
            buildSinglePointTask(2265, 57, 252, 243, 214),
            buildSinglePointTask(2280, 52, 255, 247, 228),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun breakingBoundariesColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2251, 900, 230, 148, 92),
            buildSinglePointTask(2197, 957, 255, 238, 174),
            buildSinglePointTask(2306, 960, 250, 165, 101),
            buildSinglePointTask(2253, 1008, 255, 171, 107),
            buildSinglePointTask(112, 383, 167, 53, 29),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    fun breakingCompletionColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2250, 900, 73, 135, 120),
            buildSinglePointTask(2193, 960, 102, 173, 155),
            buildSinglePointTask(2308, 955, 76, 140, 124),
            buildSinglePointTask(2252, 1008, 83, 154, 136),
            buildSinglePointTask(2227, 912, 238, 238, 238),
            buildSinglePointTask(2227, 961, 253, 253, 253),
            buildSinglePointTask(2277, 963, 254, 254, 254),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    fun rightCloseColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(2330, 28, 224, 202, 153),
            buildSinglePointTask(2305, 30, 248, 238, 187),
            buildSinglePointTask(2305, 52, 231, 215, 166),
            buildSinglePointTask(2328, 52, 218, 204, 157),
            buildSinglePointTask(2335, 40, 117, 72, 51),
            buildSinglePointTask(2315, 57, 133, 82, 61),
            buildSinglePointTask(2300, 42, 124, 73, 54),
            buildSinglePointTask(2318, 23, 113, 65, 45),
            buildSinglePointTask(2317, 41, 223, 199, 153),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun challengeFailedColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1048, 810, 255, 253, 222),
            buildSinglePointTask(1050, 860, 255, 250, 198),
            buildSinglePointTask(1352, 808, 253, 255, 252),
            buildSinglePointTask(1355, 862, 250, 248, 235),
            buildSinglePointTask(1053, 270, 222, 239, 246),
            buildSinglePointTask(1188, 275, 224, 241, 248),
            buildSinglePointTask(1311, 276, 228, 241, 249),
            buildSinglePointTask(1452, 261, 174, 187, 195),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    fun challengeSuccessColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1051, 272, 245, 227, 153),
            buildSinglePointTask(1183, 268, 234, 207, 130),
            buildSinglePointTask(1303, 273, 249, 226, 146),
            buildSinglePointTask(1440, 247, 203, 179, 105),
            buildSinglePointTask(1052, 838, 253, 253, 251),
            buildSinglePointTask(1051, 887, 250, 248, 236),
            buildSinglePointTask(1391, 836, 249, 183, 122),
            buildSinglePointTask(1388, 893, 254, 246, 183),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    fun isMainInterface(): Boolean {
        val list = listOf(
            buildSinglePointTask(361, 26, 228, 254, 227),
            buildSinglePointTask(368, 22, 98, 160, 113),
            buildSinglePointTask(352, 21, 103, 159, 122),
            buildSinglePointTask(352, 35, 225, 244, 222),
            buildSinglePointTask(367, 35, 233, 250, 234),
            buildSinglePointTask(346, 36, 110, 165, 125),
            buildSinglePointTask(373, 37, 107, 166, 122),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    // 正在自动导航中
    fun navigationByOneselfColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1037, 830, 252, 224, 174),
            buildSinglePointTask(1031, 836, 242, 228, 179),
            buildSinglePointTask(1081, 822, 245, 228, 174),
            buildSinglePointTask(1097, 847, 92, 49, 33, 15),
            buildSinglePointTask(1127, 848, 83, 47, 35, 15),
            buildSinglePointTask(1156, 846, 78, 48, 40, 15),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    //点击互动对话框
    fun clickInteractiveDialogueColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(1608, 606, 55, 59, 62),
            buildSinglePointTask(1618, 605, 64, 65, 69),
            buildSinglePointTask(1628, 606, 83, 84, 89),
            buildSinglePointTask(1612, 613, 215, 215, 215),
            buildSinglePointTask(1623, 613, 215, 215, 215),
            buildSinglePointTask(1618, 597, 254, 254, 255),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }


    // 互动点击区域 拾取等
    fun clickInteractivePickupColor(): Boolean {
        val list = listOf(
            buildTwoPointTask(1836, 628, 213, 213, 215, 1830, 622, 40, 39, 47),
            buildTwoPointTask(1870, 628, 210, 210, 210, 1860, 628, 38, 39, 44),
            buildTwoPointTask(1881, 585, 255, 255, 255, 1876, 573, 40, 39, 45),
            buildTwoPointTask(1886, 608, 219, 219, 219, 1895, 615, 40, 40, 42),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    //正在自动战斗中
    fun inAutomaticCombatColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(913, 893, 254, 226, 186),
            buildSinglePointTask(920, 893, 255, 241, 197),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun needAutomaticCombatColor(): Boolean {
        val list = listOf(
            buildSinglePointTask(913, 893, 192, 201, 208),
            buildSinglePointTask(922, 893, 192, 201, 208),
            buildSinglePointTask(843, 745, 136, 126, 117),
            buildSinglePointTask(913, 748, 81, 71, 62),
            buildSinglePointTask(838, 741, 236, 227, 212),
            buildSinglePointTask(898, 746, 237, 228, 213),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)
    }

    fun needStartMainColor():Boolean {
        val list = listOf(
            buildSinglePointTask(501,202,254, 254, 254),
            buildSinglePointTask(556,188,239, 232, 206),
            buildSinglePointTask(593,187,227, 222, 203),
        )
        return ImgUtils.performPointsColorVerification(list, screenBitmap, 0)}

}