package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant

class FightConstant {
    var APP_LOCATION_Y = 1 //APP位于当前页的第一行
    val APP_LOCATION_X
        get() = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
            1
        } else {
            2
        }

    var REFRESH_INTERVAL = 31 * 60 * 1000L
    var NAVIGATING_TOO_LONG = 15 * 60 * 1000L
    var NAVIGATING_EXCEPTION = 40 * 60 * 1000L
    var INTO_BATTLE_EXCEPTION = 5 * 60 * 1000L
    var MAX_BATTLE_TIME = 30 * 60 * 1000L

    var MenuArea = Area(84, 3, 198, 120)
    var FightTaskMenuArea = Area(84, 3, 198, 120)


    var openTaskArea = Area(1195, 524, 661, 125)
    var optTaskArea = Area(1912, 542, 110, 115)//(1912, 542, 110, 115)
    var cancelTaskArea = Area(1740, 201, 212, 67)

    var dialogDetermineArea = Area(2000, 770, 250, 90)//这个是右小角弹出窗口的确定按钮
    var dialogCancleArea = Area(1675, 824, 212, 42)

    var newTaskListArea = Area(1257, 753, 555, 83)

    var refreshTaskListArea = Area(1319, 185, 220, 70)

    var pickTaskArea = Area(570, 668, 444, 25)

    var openTaskRightArea = Area(2085, 326, 303, 120) //这个是进入任务页 进行取消操作

    var openTaskDetermineArea = Area(1607, 869, 331, 87)//这个是点击确定按钮

    var leftDialogueArea = Area(335, 373, 617, 185)
    var rightDialogueArea = Area(1521, 305, 557, 177)


    var pickUpTask1Area = Area(570, 668, 444, 25)
    var pickUpTask2Area = Area(1031, 666, 444, 25)

    var lockTargetGroupArea = Area(1395, 639, 92, 94)

    var eraseWarningArea = Area(102, 261, 64, 70)

    var defaultCoordinateMenuArea = Area(457, 264, 65, 65)

    var closeAnnouncementArea = Area(1919, 96, 55, 55)
    var startGameArea = Area(1051, 790, 299, 88)
    var selectRoleArea = Area(587, 173, 210, 296)
    var closeBigMenuArea = Area(2186, 22, 75, 76)

    var generalWarehouseArea = Area(122, 735, 405, 93)
    var mineralWarehouseArea = Area(219, 896, 273, 50)

    var warehouseSelectAllArea = Area(1714, 913, 170, 130)
    var warehouseMoveArea = Area(160, 180, 270, 63)
    var warehouseAllArea = Area(630, 200, 370, 70) //物品机库


    fun getTopEquipArea(index: Int): Area {
        return Area(1640 + 109 * index, 832, 95, 96)
    }

    fun getBottomEquipArea(index: Int): Area {
        return Area(1640 + 109 * index, 947, 96, 94)
    }

    fun getAddressArea(index: Int): Area {
        return Area(431, 425 + (index * 75), 75, 59)
    }

    fun getTopMenuArea(index: Int): Area {
        return Area(102 + (index - 1) * 117, 140, 70, 70)
    }
}