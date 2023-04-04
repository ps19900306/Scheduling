package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.SwipeArea
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant

class BaseConstant {
    var APP_LOCATION_Y = 1 //APP位于当前页的第一行
    val APP_LOCATION_X
        get() = if (SPRepo.role == SpConstant.PREFIX_ROLE1) {
            1
        } else {
            2
        }

    var REFRESH_INTERVAL = 31 * 60 * 1000L
    var NAVIGATING_TOO_LONG = 10 * 60 * 1000L
    var NAVIGATING_EXCEPTION = 40 * 60 * 1000L
    var INTO_BATTLE_EXCEPTION = 3 * 60 * 1000L
    var MAX_BATTLE_TIME = 30 * 60 * 1000L

    val listInterval1 = 165 * 1000L
    val listInterval2 = 170 * 1000L
    val listInterval3 = 75 * 1000L
    val offsetInterval = 1000L

    var MenuArea = Area(84, 3, 198, 120)
    var FightTaskMenuArea = Area(84, 3, 198, 120)


    var openTaskArea = Area(1195, 524, 661, 125)
    var optTaskArea = Area(1896, 516, 138, 144)//(1912, 542, 110, 115)
    var optTaskArea2 = Area(1893, 678, 145, 158)//(1912, 542, 110, 115)
    var cancelTaskArea = Area(1740, 201, 212, 67)
    var closeWalletArea = Area(1917, 97, 67, 66)
    var leftJiYuMenu = Area(285, 677, 356, 178)//左边菜单际遇按钮
    var leftCangKuMenu = Area(506, 420, 179, 178)//左边菜单仓库按钮
    var leftCaiMenu = Area(1055, 676, 179, 178)//左边菜单行星按钮

    var dialogDetermineArea = Area(2000, 770, 250, 90)//这个是右小角弹出窗口的确定按钮
    var dialogCancleArea = Area(1675, 824, 212, 42)

    fun newTaskListArea(boolean: Boolean): Area {
        return if (boolean) {
            Area(309, 167, 660, 250)
        } else {
            Area(1257, 753, 555, 83)
        }
    }


    var refreshTaskListArea = Area(1319, 185, 220, 70)

    var pickTaskArea = Area(570, 668, 444, 25)

    var openTaskRightArea = Area(2085, 326, 303, 120) //这个是进入任务页 进行取消操作
    var openTaskRightArea2 = Area(2085, 569, 303, 120) //这个是进入任务页 进行取消操作
    var openTaskDetermineArea = Area(1607, 869, 331, 87)//这个是点击确定按钮

    var leftDialogueArea = Area(335, 373, 617, 185)
    var rightDialogueArea = Area(1521, 305, 557, 177)


    var pickUpTask1Area = Area(570, 668, 444, 25)
    var pickUpTask2Area = Area(1031, 666, 444, 25)

    var lockTargetGroupArea = Area(1395, 639, 92, 94)

    var eraseWarningArea = Area(102, 261, 64, 70)//这里是开始导航的位置

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
    var addTimeArea = Area(2113, 169, 73, 75)//增加时间的
    var setTargetArea = Area(1923, 903, 355, 115)//行星开采设置终点的位置
    var collectButtonArea1 = Area(344, 881, 682, 107)//收集按钮1
    var collectButtonArea2 = Area(683, 879, 279, 109)//收集按钮2

    var jikuArea = Area(118, 409, 433, 84)//点击机库
    var theTwoArea = Area(1066, 207, 158, 114)//第二个船
    var jiHuoArea = Area(2050, 320, 342, 110)//点击激活

    var libaoArea1 = Area(111, 518, 66, 65)//点击激活
    var libaoArea2 = Area(451, 731, 315, 51)//点击激活
    var libaoArea3 = Area(1906, 152, 56, 58)//点击激活
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

    fun getAppArea(): Area {
        return Area(82 + (APP_LOCATION_X - 1) * 254, 185 + (APP_LOCATION_Y - 1) * 291, 154, 153)
    }


    fun celestialBodyItem(position: Int): Area {
        return if (position <= 3) {
            Area(127, 261 + (position * 200), 419, 99)
        } else if (position == 4) {
            Area(129, 1010, 428, 70)
        } else {
            Area(129, 1010, 428, 70)
        }
    }

    fun celestialSwipeArea(delayTime: Long = 0L): SwipeArea {
        var y = 1040 - (Math.random() * 270)
        var x = 150 + (Math.random() * 100)
        return SwipeArea(
            x,
            y,
            x + (Math.random() * 20),
            y - 210 - (Math.random() * 10),
            900 + (Math.random() * 50),
            delayTime
        )
    }

    fun resourceLocation(position: Int): Area {
        return if (position <= 2) {
            Area(2051, 447 + (143 * position), 174, 51)
        } else {
            Area(2027, 511 + 143 * (position - 3), 174, 51)
        }
    }

    fun resourceSwipeArea(delayTime: Long = 0L): SwipeArea {
        return SwipeArea(
            1610 + (Math.random() * 306),
            783 + (Math.random() * 70),
            1610 + (Math.random() * 306),
            373 - (Math.random() * 43),
            500 + (Math.random() * 200),
            delayTime
        )
    }


    fun eyeMenuSwipeToTopArea(delayTime: Long = 0L): SwipeArea {
        return SwipeArea(
            2250 + (Math.random() * 50),
            150 + (Math.random() * 60),
            2250 + (Math.random() * 50),
            900 - (Math.random() * 60),
            500 + (Math.random() * 300),
            delayTime
        )
    }

    //挖矿
    val isOpenPositionArea = Area(455, 258, 73, 76)//已经开启的位置
    val closePositionArea = Area(418, 342, 100, 70)//已经开启的位置
    val localListArea = Area(102, 989, 179, 56)//打开本地图标
    val localBaseX = Coordinate(567, 716)//用于修正X偏差度
    val localBaseY = Coordinate(573, 705)//用于修正Y偏差度
    val openEyeMenuArea = Area(2197, 565, 70, 70)//打开本地图标
    val closeEyeMenuArea = Area(2197 - 377, 565, 70, 70)//打开本地图标
    val outSpaceArea = Area(2004, 331, 111, 59)//打开本地图标
    fun getTransitionArea(index: Int): Area {//点击跃迁
        return Area(1580, 200 + (index * 100), 300, 100)
    }

    fun getLockingArea(index: Int): Area {//点击锁定
        return Area(1609, 104 + (index * 105), 230, 64)
    }

    fun getTopClickArea(index: Int): Area {//顶部可以点击目标
        return Area(1790 - 124 * index, 43, 30, 40)
    }

    fun getTopApproachArea(index: Int): Area {//点击接近
        return Area(1703 - 124 * index, 274, 142, 57)
    }

    fun getTopSurroundArea(index: Int): Area {//点击环绕
        return Area(1552 - 124 * index, 412, 188, 70)
    }

    //点击右边的菜单栏目资源的条目 点击行星位置 行星群
    fun clickEyesMenuItemArea(index: Int): Area {
        return Area(1985, 85 + (index * 105), 188, 70)
    }


    //副本接受按钮
    val preparationDungeonArea = Area(1131, 445, 135, 139)//打开本地图标
    val acceptDungeonArea = Area(2004, 331, 111, 59)//打开本地图标
    val completeDungeonArea = Area(2004, 331, 111, 59)//完成按钮
}