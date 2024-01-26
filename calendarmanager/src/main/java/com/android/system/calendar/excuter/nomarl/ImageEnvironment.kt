package com.android.system.calendar.excuter.nomarl

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule

//这个是用于
class ImageEnvironment {


    val activityMenuBtnArea by lazy {
        ClickArea(835, 21, 42, 44, true)
    }

    val isActivityMenuBtnTask by lazy {
        val tag = "isActivityMenuBtn"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            187,
            255,
            183,
            240,
            170,
            1.0761411F,
            0.9170616F,
            1.1630045F,
            0.9904762F,
            1.1386666F,
            0.97142863F
        )
        val pr = PointRule(CoordinatePoint(848, 63), colorRule1)
        //red253,green248,blue229 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(763, 60, 186, 7)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(846, 66), colorRule1)
            //red253,green248,blue229 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(845, 69), colorRule1)
            //red212,green208,blue192 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(850, 68), colorRule1)
            //red208,green204,blue189 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(843, 73), colorRule1)
            //red253,green248,blue229 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(849, 73), colorRule1)
            //red249,green244,blue225 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(867, 62), colorRule1)
            //red215,green211,blue195 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(868, 67), colorRule1)
            //red253,green248,blue229 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(865, 68), colorRule1)
            //red231,green226,blue209 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(872, 68), colorRule1)
            //red253,green248,blue229 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(860, 70), colorRule1)
            //red252,green247,blue228 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(863, 73), colorRule1)
            //red242,green237,blue219 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(870, 75), colorRule1)
            //red253,green248,blue229 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(856, 70), colorRule1)
            //red247,green241,blue223 sequenceNumber:15 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(840, 72), colorRule1)
            //red240,green235,blue217 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(838, 75), colorRule1)
            //red253,green248,blue229 sequenceNumber:5 blockNumber: 5  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(848, 63),
                CoordinatePoint(849, 62),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(850, 68),
                CoordinatePoint(851, 67),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(849, 74),
                CoordinatePoint(848, 74),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:15sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(867, 62),
                CoordinatePoint(870, 65),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(872, 68),
                CoordinatePoint(873, 70),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(856, 70),
                CoordinatePoint(858, 72),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:15sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(838, 75),
                CoordinatePoint(838, 73),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val activityNeedArea by lazy {
        ClickArea(81,644,35,57,false)}
    //活动的必做任务
    val isActivityNeedTask by lazy {
        val tag = "isActivityMenuNeed"
        val colorRule1=ColorRuleRatioImpl.getSimple(118,92,111,87,97,78,1.1206731F,0.95399994F,1.2758064F,1.0655173F,1.1967741F, 1.0034482F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(99, 655), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(97, 660), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(91, 662), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(95, 668), colorRule1)
            //red103,green97,blue87 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(101, 668), colorRule1)
            //red103,green97,blue87 sequenceNumber:22 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(101, 660), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(104, 662), colorRule1)
            //red103,green97,blue87 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(87, 664), colorRule1)
            //red103,green97,blue87 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(89, 677), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(88, 684), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(89, 687), colorRule1)
            //red106,green100,blue89 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(88, 693), colorRule1)
            //red103,green97,blue87 sequenceNumber:18 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(99, 677), colorRule1)
            //red111,green104,blue92 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(101, 686), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(100, 690), colorRule1)
            //red103,green97,blue87 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(103, 694), colorRule1)
            //red103,green97,blue87 sequenceNumber:19 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(94, 678), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(91, 690), colorRule1)
            //red113,green106,blue93 sequenceNumber:14 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(91, 662),CoordinatePoint(91, 660), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(104, 662),CoordinatePoint(106, 662), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(87, 664),CoordinatePoint(85, 664), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(88, 684),CoordinatePoint(90, 684), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(100, 690),CoordinatePoint(98, 690), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:16sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(94, 680),CoordinatePoint(92, 680), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }


    val isOpenActivityMenuTask by lazy {
        val tag = "isOpenActivityMenuTask"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            78,
            54,
            60,
            42,
            24,
            17,
            1.3874999F,
            1.154717F,
            3.5F,
            2.8636365F,
            2.7078946F,
            2.1857142F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(20, 27), colorRule1)
            //red75,green58,blue23 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(23, 29), colorRule1)
            //red74,green57,blue23 sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(24, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(27, 30), colorRule1)
            //red74,green57,blue23 sequenceNumber:14 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(34, 28), colorRule1)
            //red75,green57,blue23 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(37, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:4 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(43, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(38, 36), colorRule1)
            //red72,green56,blue22 sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(49, 31), colorRule1)
            //red74,green57,blue23 sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(46, 41), colorRule1)
            //red71,green54,blue22 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(41, 43), colorRule1)
            //red70,green54,blue22 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(47, 46), colorRule1)
            //red69,green53,blue21 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(36, 49), colorRule1)
            //red68,green53,blue21 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(52, 46), colorRule1)
            //red69,green53,blue21 sequenceNumber:28 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(33, 52), colorRule1)
            //red67,green52,blue21 sequenceNumber:28 blockNumber: 1  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(56, 45), colorRule1)
            //red70,green54,blue21 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(59, 47), colorRule1)
            //red69,green53,blue21 sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(31, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(35, 62), colorRule1)
            //red64,green49,blue20 sequenceNumber:44 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(42, 50), colorRule1)
            //red68,green52,blue21 sequenceNumber:48 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(42, 61), colorRule1)
            //red65,green50,blue20 sequenceNumber:48 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(43, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:52 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(36, 67), colorRule1)
            //red63,green48,blue19 sequenceNumber:52 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(45, 49), colorRule1)
            //red68,green53,blue21 sequenceNumber:56 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(37, 71), colorRule1)
            //red61,green47,blue19 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(45, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:68 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(48, 59), colorRule1)
            //red65,green50,blue20 sequenceNumber:68 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(54, 61), colorRule1)
            //red65,green50,blue20 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(49, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(56, 63), colorRule1)
            //red64,green49,blue20 sequenceNumber:76 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(53, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(55, 66), colorRule1)
            //red63,green49,blue19 sequenceNumber:85 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(13, 40), colorRule1)
            //red71,green55,blue22 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(15, 45), colorRule1)
            //red70,green54,blue21 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(17, 48), colorRule1)
            //red69,green53,blue21 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(16, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(15, 57), colorRule1)
            //red66,green51,blue20 sequenceNumber:19 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(24, 51), colorRule1)
            //red68,green52,blue21 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(23, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(21, 59), colorRule1)
            //red65,green50,blue20 sequenceNumber:8 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(18, 65), colorRule1)
            //red63,green49,blue19 sequenceNumber:12 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(15, 67), colorRule1)
            //red63,green48,blue19 sequenceNumber:16 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(13, 71), colorRule1)
            //red61,green47,blue19 sequenceNumber:20 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(17, 69), colorRule1)
            //red62,green48,blue19 sequenceNumber:20 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(15, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:24 blockNumber: 3  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(24, 29),
                CoordinatePoint(24, 25),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(60, 48),
                CoordinatePoint(60, 44),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(17, 50),
                CoordinatePoint(13, 50),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -30)
            ) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(15, 67),
                CoordinatePoint(15, 63),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply { nErrorTolerance = 5 }
    }

    //开启师门任务的按钮
    val startDivisionArea by lazy {
        ClickArea(57, 507, 123, 39, false)
    }

    //活动里面的师门任务
    val findDivisionTaskTask by lazy {
        val tag = "findDivisionTask"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            84,
            70,
            65,
            54,
            29,
            21,
            1.365F,
            1.1612903F,
            3.4125F,
            2.5714285F,
            2.625F,
            1.9928571F
        )
        val pr = PointRule(CoordinatePoint(151, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(68, 310, 1073, 7)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(150, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(76, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(76, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(75, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(124, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(121, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(122, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(122, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:17 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(155, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(151, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(151, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(158, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(150, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(84, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(83, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(86, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(83, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(88, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(83, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:17 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(108, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(111, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(111, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(111, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(133, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(130, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(131, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(131, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(134, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(72, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(73, 323), colorRule1)
            //red80,green62,blue28 sequenceNumber:7 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(98, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(98, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(98, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(79, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(134, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(155, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(154, 331), colorRule1)
            //red80,green62,blue28 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(150, 316),
                CoordinatePoint(148, 316),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(76, 321),
                CoordinatePoint(74, 321),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(121, 321),
                CoordinatePoint(120, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(154, 321),
                CoordinatePoint(155, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(86, 320),
                CoordinatePoint(86, 321),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(111, 320),
                CoordinatePoint(109, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(131, 322),
                CoordinatePoint(129, 322),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(98, 324),
                CoordinatePoint(97, 323),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(79, 324),
                CoordinatePoint(78, 323),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(136, 323),
                CoordinatePoint(136, 321),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(155, 327),
                CoordinatePoint(154, 327),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            nErrorTolerance = 2
        }
    }

    val startBangTaskArea by lazy {
        ClickArea(248,504,127,41,false)}
    val findBangTaskTask by lazy {
        val tag = "findBangTask"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            84,
            70,
            65,
            54,
            29,
            21,
            1.365F,
            1.1612903F,
            3.4125F,
            2.5714285F,
            2.625F,
            1.9928571F
        )
        val pr = PointRule(CoordinatePoint(297, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(68, 310, 997, 7)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(293, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(345, 313), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(344, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(272, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(270, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(318, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(315, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(316, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(316, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:17 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(349, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(345, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(345, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(352, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(344, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(277, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(278, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(327, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(324, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(325, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(325, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(328, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(300, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(302, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(306, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(275, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(273, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(275, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(328, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(278, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(280, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 17  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(299, 325), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(349, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(348, 331), colorRule1)
            //red80,green62,blue28 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(297, 315),
                CoordinatePoint(295, 315),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(344, 316),
                CoordinatePoint(342, 316),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(272, 316),
                CoordinatePoint(270, 315),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(315, 321),
                CoordinatePoint(314, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(348, 321),
                CoordinatePoint(349, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(278, 320),
                CoordinatePoint(279, 320),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(325, 322),
                CoordinatePoint(323, 322),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(302, 319),
                CoordinatePoint(302, 317),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(273, 325),
                CoordinatePoint(273, 324),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(330, 323),
                CoordinatePoint(330, 321),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(280, 328),
                CoordinatePoint(282, 328),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:7sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(302, 325),
                CoordinatePoint(302, 323),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(349, 327),
                CoordinatePoint(348, 327),
                CompareDifferenceRuleImpl.getSimple(-40, -40, -40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            nErrorTolerance = 2
        }
    }

    val startMountainsAndRiversTaskArea by lazy {
        ClickArea(442,503,129,45,false)}
    //山河印画
    val findMountainsAndRiversTaskTask by lazy {
        val tag = "findMountainsAndRiversTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val pr  = PointRule(CoordinatePoint(517, 314), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(67,311,1007,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(518, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(517, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(467, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(468, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(468, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(462, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(461, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:22 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(498, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(498, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(497, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(510, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(511, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(545, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(544, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(507, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(507, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(539, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(540, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(514, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(515, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(535, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(536, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(475, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(475, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 15  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(521, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(548, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(532, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(534, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(486, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(484, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(520, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(523, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(518, 320),CoordinatePoint(520, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(468, 325),CoordinatePoint(466, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(498, 320),CoordinatePoint(500, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(511, 324),CoordinatePoint(510, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 320),CoordinatePoint(543, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(507, 327),CoordinatePoint(506, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:10sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(540, 323),CoordinatePoint(542, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(515, 323),CoordinatePoint(513, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(TwoPointRule(CoordinatePoint(536, 323),CoordinatePoint(534, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(TwoPointRule(CoordinatePoint(475, 327),CoordinatePoint(474, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(TwoPointRule(CoordinatePoint(523, 324),CoordinatePoint(523, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(TwoPointRule(CoordinatePoint(548, 325),CoordinatePoint(546, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(533, 326),CoordinatePoint(531, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(TwoPointRule(CoordinatePoint(484, 329),CoordinatePoint(482, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(TwoPointRule(CoordinatePoint(523, 331),CoordinatePoint(523, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $24  positionType:$24
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startTreasureMapTaskArea by lazy {
        ClickArea(639,506,122,37,false)}
    //惩戒凶打图
    val findTreasureMapTaskTask by lazy {
        val tag = "findTreasureMapTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val pr  = PointRule(CoordinatePoint(707, 314), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(63,311,1006,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(706, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(705, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(740, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(728, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(658, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(719, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(715, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(715, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(736, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(694, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(694, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(678, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(679, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(682, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:11 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(728, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 24  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(706, 320),CoordinatePoint(705, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(741, 320),CoordinatePoint(739, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(665, 318),CoordinatePoint(663, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(688, 318),CoordinatePoint(687, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(728, 318),CoordinatePoint(729, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(657, 320),CoordinatePoint(656, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(715, 323),CoordinatePoint(713, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 323),CoordinatePoint(737, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(694, 326),CoordinatePoint(692, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(TwoPointRule(CoordinatePoint(679, 328),CoordinatePoint(678, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(TwoPointRule(CoordinatePoint(728, 331),CoordinatePoint(729, 330), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(662, 331),CoordinatePoint(662, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startMultiplayerDungeonTaskArea by lazy {
        ClickArea(832,505,125,40,false)}
    //多人副本
    val findMultiplayerDungeonTaskTask by lazy {
        val tag = "findMultiplayerDungeonTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(927, 314), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(66,311,1074,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(927, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(925, 324), colorRule1)
            //red80,green62,blue28 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(931, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(927, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(935, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(860, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(855, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(861, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(856, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(879, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(879, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(875, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:14 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(912, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(913, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(913, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(912, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(908, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(909, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(903, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(905, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(882, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(886, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(896, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(897, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(901, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(925, 324),CoordinatePoint(925, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(855, 321),CoordinatePoint(854, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(879, 321),CoordinatePoint(877, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(913, 321),CoordinatePoint(914, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(909, 321),CoordinatePoint(907, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(905, 328),CoordinatePoint(903, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:7sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(TwoPointRule(CoordinatePoint(886, 329),CoordinatePoint(886, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(TwoPointRule(CoordinatePoint(897, 328),CoordinatePoint(895, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $15  positionType:$15
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startJiangHuExperienceTaskArea by lazy {
        ClickArea(1027,507,123,39,false)}
    val findJiangHuExperienceTaskTask by lazy {
        val tag = "findJiangHuExperienceTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(1073, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(67,310,995,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1073, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1126, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1124, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1104, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1099, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1082, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1083, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1083, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1093, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1093, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1092, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1078, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1078, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:11 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1051, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1053, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1100, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1099, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1104, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1104, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1102, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:11 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1127, 321), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1127, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1125, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1045, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1042, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1073, 315),CoordinatePoint(1072, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1126, 316),CoordinatePoint(1124, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1099, 316),CoordinatePoint(1099, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(1083, 322),CoordinatePoint(1081, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(1093, 322),CoordinatePoint(1092, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(1078, 326),CoordinatePoint(1079, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:11sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(1053, 325),CoordinatePoint(1051, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:9sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(TwoPointRule(CoordinatePoint(1100, 321),CoordinatePoint(1098, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(TwoPointRule(CoordinatePoint(1104, 327),CoordinatePoint(1103, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(TwoPointRule(CoordinatePoint(1127, 327),CoordinatePoint(1125, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(1042, 329),CoordinatePoint(1042, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $26  positionType:$26
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startChessGameTaskArea by lazy {
        ClickArea(927,504,87,39,false)}
    val findChessGameTaskTask by lazy {
        val tag = "findChessGameTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val pr  = PointRule(CoordinatePoint(934, 314), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(54,311,1055,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(933, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(975, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(973, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(974, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(975, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(985, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(986, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(986, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(988, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:15 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1006, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1007, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(957, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(957, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1000, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1000, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(998, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(981, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(981, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(927, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(927, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(950, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(950, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(949, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1011, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1010, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:11 blockNumber: 16  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(959, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(938, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(936, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(959, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(966, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 31  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(933, 318),CoordinatePoint(932, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(973, 320),CoordinatePoint(973, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(986, 320),CoordinatePoint(984, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1007, 317),CoordinatePoint(1006, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(957, 319),CoordinatePoint(955, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(1000, 321),CoordinatePoint(998, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(981, 322),CoordinatePoint(979, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(927, 319),CoordinatePoint(925, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(950, 324),CoordinatePoint(949, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(1010, 331),CoordinatePoint(1009, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:11sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(TwoPointRule(CoordinatePoint(959, 326),CoordinatePoint(957, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(TwoPointRule(CoordinatePoint(936, 329),CoordinatePoint(936, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(TwoPointRule(CoordinatePoint(961, 331),CoordinatePoint(961, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $31  positionType:$31
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startBangHuiPartyTaskArea by lazy {
        ClickArea(1129,506,73,39,false)}
    //帮会宴饮
    val findBangHuiPartyTaskTask by lazy {
        val tag = "findBangHuiPartyTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(1149, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(45,310,1107,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1145, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1124, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1122, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1177, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1177, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1169, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1167, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1129, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1130, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1152, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1154, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1158, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1193, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1200, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1202, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1179, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1196, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1197, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1127, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1125, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1127, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1169, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1168, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 21  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1176, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1181, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 22  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1130, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1132, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1151, 325), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1201, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1203, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1149, 315),CoordinatePoint(1147, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1124, 316),CoordinatePoint(1122, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1177, 318),CoordinatePoint(1175, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(1169, 317),CoordinatePoint(1167, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(1130, 320),CoordinatePoint(1131, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(1154, 319),CoordinatePoint(1154, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(1195, 317),CoordinatePoint(1195, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(1202, 321),CoordinatePoint(1204, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(TwoPointRule(CoordinatePoint(1181, 320),CoordinatePoint(1181, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(TwoPointRule(CoordinatePoint(1197, 325),CoordinatePoint(1195, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(TwoPointRule(CoordinatePoint(1125, 325),CoordinatePoint(1125, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(1169, 325),CoordinatePoint(1167, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(TwoPointRule(CoordinatePoint(1176, 325),CoordinatePoint(1175, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(TwoPointRule(CoordinatePoint(1132, 328),CoordinatePoint(1134, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:7sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(TwoPointRule(CoordinatePoint(1154, 325),CoordinatePoint(1154, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(TwoPointRule(CoordinatePoint(1200, 328),CoordinatePoint(1202, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $28  positionType:$28
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }


    val activityChallengeBtnArea by lazy {
        ClickArea(174,639,43,69,false)}
    val isActivityChallengeTask by lazy {
        val tag = "isActivityChallenge"
        val colorRule1=ColorRuleRatioImpl.getSimple(128,92,118,87,102,78,1.135135F,0.955102F,1.3125F,1.0636363F,1.2140625F, 1.0022727F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(188, 653), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(189, 658), colorRule1)
            //red103,green97,blue87 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(188, 663), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(188, 669), colorRule1)
            //red103,green97,blue87 sequenceNumber:18 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(197, 654), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(197, 660), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(197, 664), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(198, 668), colorRule1)
            //red103,green97,blue87 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(203, 668), colorRule1)
            //red103,green97,blue87 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(193, 656), colorRule1)
            //red122,green113,blue98 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(194, 662), colorRule1)
            //red120,green111,blue96 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(193, 667), colorRule1)
            //red104,green98,blue88 sequenceNumber:13 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(194, 677), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(195, 683), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(196, 687), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(197, 691), colorRule1)
            //red104,green98,blue88 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(202, 695), colorRule1)
            //red103,green97,blue87 sequenceNumber:20 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(187, 679), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(188, 685), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(191, 690), colorRule1)
            //red103,green97,blue87 sequenceNumber:14 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(185, 689), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(186, 692), colorRule1)
            //red103,green97,blue87 sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(188, 659),CoordinatePoint(187, 658), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(197, 664),CoordinatePoint(199, 665), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(194, 662),CoordinatePoint(193, 660), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(196, 687),CoordinatePoint(194, 687), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:12sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(188, 685),CoordinatePoint(186, 685), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(186, 692),CoordinatePoint(184, 692), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:5sequenceNumber blockNumber: $10  positionType:$10
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }


    val startTransportTreasureTaskArea by lazy {
        ClickArea(248,502,128,46,false)}

    val findTransportTreasureTaskTask by lazy {
        val tag = "findTransportTreasureTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(297, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(46,310,1168,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(293, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(272, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(270, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(341, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(277, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(278, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(348, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(349, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(300, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(302, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(306, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(355, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(323, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(275, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(273, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(275, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(278, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(280, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(299, 325), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 29  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(348, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(350, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(319, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(325, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(330, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 40  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(297, 315),CoordinatePoint(295, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(272, 316),CoordinatePoint(270, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(341, 317),CoordinatePoint(339, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(278, 320),CoordinatePoint(279, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(349, 319),CoordinatePoint(348, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(302, 319),CoordinatePoint(302, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(354, 320),CoordinatePoint(353, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(TwoPointRule(CoordinatePoint(324, 322),CoordinatePoint(322, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(TwoPointRule(CoordinatePoint(273, 325),CoordinatePoint(273, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(TwoPointRule(CoordinatePoint(280, 328),CoordinatePoint(282, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:7sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(TwoPointRule(CoordinatePoint(302, 325),CoordinatePoint(302, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $29  positionType:$29
        )
        pointList.add(TwoPointRule(CoordinatePoint(350, 329),CoordinatePoint(348, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:7sequenceNumber blockNumber: $36  positionType:$36
        )
        pointList.add(TwoPointRule(CoordinatePoint(325, 331),CoordinatePoint(325, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $40  positionType:$40
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }


    val startQianKunLunWuTaskArea by lazy {
        ClickArea(443,506,126,42,false)}
    val findQianKunLunWuTaskTask by lazy {
        val tag = "findQianKunLunWuTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(495, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(46,310,1091,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(494, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(495, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(495, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(500, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(499, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:22 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(540, 313), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(543, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(465, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(464, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(472, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(471, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(518, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(486, 315), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(486, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(520, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(524, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(509, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(510, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(538, 322), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(534, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(517, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(517, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(524, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(462, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(464, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(544, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(550, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(470, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(478, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 31  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(495, 323),CoordinatePoint(493, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(541, 315),CoordinatePoint(540, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(464, 318),CoordinatePoint(466, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(471, 318),CoordinatePoint(470, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(518, 316),CoordinatePoint(516, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(486, 321),CoordinatePoint(485, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(524, 321),CoordinatePoint(524, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(510, 324),CoordinatePoint(509, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(TwoPointRule(CoordinatePoint(538, 324),CoordinatePoint(536, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(517, 329),CoordinatePoint(515, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(TwoPointRule(CoordinatePoint(464, 331),CoordinatePoint(462, 331), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:9sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 327),CoordinatePoint(546, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $27  positionType:$27
        )
        pointList.add(TwoPointRule(CoordinatePoint(478, 329),CoordinatePoint(477, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $31  positionType:$31
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startSongLiaoWarTaskArea by lazy {
        ClickArea(652,502,90,49,false)}
    val findSongLiaoWarTaskTask by lazy {
        val tag = "findSongLiaoWarTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val pr  = PointRule(CoordinatePoint(708, 314), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(44,311,1121,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(709, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(709, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(715, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(735, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(728, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(729, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(661, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(661, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:14 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(741, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(739, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(744, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(666, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(670, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(731, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(726, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(712, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(715, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 25  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(687, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(709, 324),CoordinatePoint(707, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 316),CoordinatePoint(734, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(729, 318),CoordinatePoint(727, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(660, 325),CoordinatePoint(658, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(690, 322),CoordinatePoint(688, 322), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(TwoPointRule(CoordinatePoint(739, 329),CoordinatePoint(738, 330), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(666, 327),CoordinatePoint(666, 325), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(TwoPointRule(CoordinatePoint(732, 327),CoordinatePoint(730, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(TwoPointRule(CoordinatePoint(727, 329),CoordinatePoint(725, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(TwoPointRule(CoordinatePoint(715, 330),CoordinatePoint(715, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(TwoPointRule(CoordinatePoint(689, 331),CoordinatePoint(688, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $28  positionType:$28
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val activityXianXiaArea by lazy {
        ClickArea(470,642,38,67,false)}
    val isActivityXianXiaTask by lazy {
        val tag = "isActivityXianXia"
        val colorRule1=ColorRuleRatioImpl.getSimple(143,92,134,87,113,78,1.125F,0.9545454F,1.3319445F,1.0636363F,1.2444445F, 1.0022727F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(489, 655), colorRule1)
            //red129,green121,blue103 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(495, 656), colorRule1)
            //red103,green97,blue87 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(494, 661), colorRule1)
            //red105,green99,blue88 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 665), colorRule1)
            //red120,green113,blue97 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 670), colorRule1)
            //red103,green97,blue87 sequenceNumber:21 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(480, 657), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(480, 663), colorRule1)
            //red104,green98,blue88 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(479, 669), colorRule1)
            //red103,green97,blue87 sequenceNumber:14 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(488, 660), colorRule1)
            //red109,green102,blue90 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(485, 664), colorRule1)
            //red137,green128,blue108 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(487, 668), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(488, 679), colorRule1)
            //red105,green99,blue88 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(482, 680), colorRule1)
            //red103,green97,blue87 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(479, 682), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 687), colorRule1)
            //red103,green97,blue87 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(479, 686), colorRule1)
            //red103,green97,blue87 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 691), colorRule1)
            //red103,green97,blue87 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(478, 690), colorRule1)
            //red120,green112,blue97 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 679), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(493, 685), colorRule1)
            //red103,green97,blue87 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(493, 689), colorRule1)
            //red103,green97,blue87 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(496, 693), colorRule1)
            //red107,green100,blue89 sequenceNumber:11 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(494, 661),CoordinatePoint(493, 661), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(480, 663),CoordinatePoint(479, 663), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(485, 664),CoordinatePoint(484, 664), CompareDifferenceRuleImpl.getSimple(-30,-20,-20)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(479, 682),CoordinatePoint(477, 682), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(494, 680),CoordinatePoint(493, 680), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(492, 691),CoordinatePoint(490, 691), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    val startBangShangTaskArea by lazy {
        ClickArea(251,503,123,43,false)}
    //帮会跑商人
    val findBangShangTaskTask by lazy {
        val tag = "findBangShangTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(297, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(41,310,1131,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(293, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(325, 313), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(324, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(272, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(270, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(354, 315), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(349, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(277, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(278, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(300, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(302, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(306, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(329, 317), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(329, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(351, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(352, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(352, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:13 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(318, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(318, 326), colorRule1)
            //red78,green60,blue24 sequenceNumber:6 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(322, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(322, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(325, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(332, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 21  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(341, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(340, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(275, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(273, 325), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(275, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:10 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(278, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(280, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(299, 325), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 30  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(315, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 34  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(297, 315),CoordinatePoint(295, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(324, 316),CoordinatePoint(323, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(272, 316),CoordinatePoint(270, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(349, 316),CoordinatePoint(349, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(278, 320),CoordinatePoint(279, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(302, 319),CoordinatePoint(302, 317), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(330, 319),CoordinatePoint(328, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(352, 326),CoordinatePoint(354, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(TwoPointRule(CoordinatePoint(318, 326),CoordinatePoint(319, 326), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:6sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(325, 331),CoordinatePoint(325, 329), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(TwoPointRule(CoordinatePoint(341, 324),CoordinatePoint(339, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(TwoPointRule(CoordinatePoint(273, 325),CoordinatePoint(273, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(TwoPointRule(CoordinatePoint(280, 328),CoordinatePoint(282, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:7sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(TwoPointRule(CoordinatePoint(302, 325),CoordinatePoint(302, 323), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $30  positionType:$30
        )
        pointList.add(TwoPointRule(CoordinatePoint(315, 327),CoordinatePoint(316, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $34  positionType:$34
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startHorseBanditsTaskArea by lazy {
        ClickArea(638,504,124,41,false)}
    //夺宝马贼任务
    val findHorseBanditsTaskTask by lazy {
        val tag = "findHorseBanditsTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(661, 313), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(36,310,1114,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(659, 320), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(737, 314), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(738, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(710, 315), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(712, 319), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(717, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(717, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(691, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(730, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(731, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(726, 318), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(726, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(667, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(729, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(663, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(663, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(661, 332), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(686, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 331), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:17 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(739, 324), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(739, 328), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(744, 332), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(735, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(661, 315),CoordinatePoint(660, 314), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(737, 316),CoordinatePoint(736, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(712, 319),CoordinatePoint(711, 318), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(693, 317),CoordinatePoint(693, 315), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 319),CoordinatePoint(730, 319), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(726, 320),CoordinatePoint(725, 320), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(669, 323),CoordinatePoint(669, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(TwoPointRule(CoordinatePoint(663, 328),CoordinatePoint(661, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(TwoPointRule(CoordinatePoint(686, 328),CoordinatePoint(684, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(TwoPointRule(CoordinatePoint(739, 328),CoordinatePoint(738, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(TwoPointRule(CoordinatePoint(735, 325),CoordinatePoint(733, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $19  positionType:$19
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val startBaiYeArea by lazy {
        ClickArea(833,505,124,41,false)}
    val findBaiYeTaskTask by lazy {
        val tag = "findBaiYeTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(84,70,65,54,29,21,1.365F,1.1612903F,3.4125F,2.5714285F,2.625F, 1.9928571F)
        val pr  = PointRule(CoordinatePoint(906, 315), colorRule1)
        //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(50,312,1113,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(906, 321), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(906, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:14 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(882, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(887, 316), colorRule1)
            //red78,green60,blue24 sequenceNumber:7 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(871, 317), colorRule1)
            //red80,green62,blue28 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(901, 317), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(902, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(902, 327), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(898, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(885, 323), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(884, 330), colorRule1)
            //red78,green60,blue24 sequenceNumber:11 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(875, 322), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(876, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:9 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(910, 329), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(906, 321),CoordinatePoint(904, 321), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(884, 316),CoordinatePoint(884, 314), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(873, 317),CoordinatePoint(873, 316), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(902, 327),CoordinatePoint(900, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(884, 330),CoordinatePoint(887, 330), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:11sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(876, 324),CoordinatePoint(874, 324), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(912, 329),CoordinatePoint(912, 327), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }




    val huodongDiloag1Area by lazy {
        ClickArea(1035,426,124,25,false)}
    val huodongDiloag2Area by lazy {
        ClickArea(949,498,295,37,false)}

    val isHuodongDiloagTask by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(957, 492), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:0 blockNumber: 0  positionType:4
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(961, 492), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(954, 496), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(965, 492), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(950, 499), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:8 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(949, 503), ColorRuleRatioImpl.getSimple(135,165,151))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 507), ColorRuleRatioImpl.getSimple(134,166,150))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 511), ColorRuleRatioImpl.getSimple(135,167,151))
            // sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 515), ColorRuleRatioImpl.getSimple(138,170,154))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 519), ColorRuleRatioImpl.getSimple(139,171,155))
            // sequenceNumber:28 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 523), ColorRuleRatioImpl.getSimple(135,167,153))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(950, 531), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:36 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(954, 533), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(957, 538), ColorRuleRatioImpl.getSimple(162,194,179))
            // sequenceNumber:44 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(961, 538), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(965, 538), ColorRuleRatioImpl.getSimple(162,195,179))
            // sequenceNumber:52 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(957, 492),CoordinatePoint(957, 491), CompareDifferenceRuleImpl.getSimple(0,0,0)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(949, 503),CoordinatePoint(949, 502), CompareDifferenceRuleImpl.getSimple(0,0,0)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(949, 523),CoordinatePoint(949, 522), CompareDifferenceRuleImpl.getSimple(0,0,0)) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(965, 538),CoordinatePoint(965, 537), CompareDifferenceRuleImpl.getSimple(10,10,10)) // sequenceNumber:52sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    val clickShiMenTypeArea by lazy {
        ClickArea(80,282,129,41,false)}
    //这个是师门任务的导航
    val isShiMenTypeTask by lazy {
        val tag = "isShiMenType"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,203,255,203,255,205,1.05F,0.8962185F,1.05F,0.8921052F,1.05F, 0.8921052F)
        val pr  = PointRule(CoordinatePoint(122, 278), colorRule1)
        //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(119,152,7,229)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(128, 284), colorRule1)
            //red249,green249,blue250 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(78, 278), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(79, 284), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(77, 290), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(86, 279), colorRule1)
            //red229,green229,blue230 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(85, 283), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(84, 291), colorRule1)
            //red237,green237,blue238 sequenceNumber:14 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(108, 280), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(108, 285), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(108, 291), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(75, 281), colorRule1)
            //red235,green235,blue236 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(76, 285), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(97, 281), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(97, 287), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(96, 290), colorRule1)
            //red237,green238,blue239 sequenceNumber:11 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(81, 286), colorRule1)
            //red238,green239,blue240 sequenceNumber:5 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(124, 287), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(120, 287), colorRule1)
            //red226,green226,blue228 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(121, 291), colorRule1)
            //red254,green254,blue254 sequenceNumber:7 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(122, 279),CoordinatePoint(124, 279), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(81, 286),CoordinatePoint(80, 286), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:5sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(84, 285),CoordinatePoint(83, 285), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(108, 285),CoordinatePoint(106, 285), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(76, 285),CoordinatePoint(74, 285), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(97, 287),CoordinatePoint(96, 286), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(120, 287),CoordinatePoint(120, 286), CompareDifferenceRuleImpl.getSimple(40,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=3 }
    }

    //这个是默认的打图标位置
    val closeBtnArea by lazy {
        ClickArea(1229,11,30,32,true)}
    val findCloseBtnTask by lazy {
        val tag = "findCloseBtn"
        val pr  = PointRule(CoordinatePoint(1236, 19), ColorRuleRatioImpl.getSimple(242,224,169))
        // sequenceNumber:0 blockNumber: 1  positionType:2
        val findArea = CoordinateArea(1033,12,227,196)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1241, 24), ColorRuleRatioImpl.getSimple(253,237,177))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1249, 23), ColorRuleRatioImpl.getSimple(250,234,174))
            // sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1243, 29), ColorRuleRatioImpl.getSimple(255,239,178))
            // sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1252, 20), ColorRuleRatioImpl.getSimple(242,224,169))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1239, 33), ColorRuleRatioImpl.getSimple(255,239,179))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1254, 18), ColorRuleRatioImpl.getSimple(238,220,166))
            // sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1236, 36), ColorRuleRatioImpl.getSimple(255,239,177))
            // sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1247, 30), ColorRuleRatioImpl.getSimple(255,239,179))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1251, 34), ColorRuleRatioImpl.getSimple(255,239,179))
            // sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1253, 36), ColorRuleRatioImpl.getSimple(255,239,178))
            // sequenceNumber:39 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1236, 19),CoordinatePoint(1240, 19), CompareDifferenceRuleImpl.getSimple(30,30,20)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1243, 29),CoordinatePoint(1240, 28), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1236, 36),CoordinatePoint(1236, 32), CompareDifferenceRuleImpl.getSimple(30,30,20)) // sequenceNumber:20sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag)
    }





    //*** 这些都是操作流程
    val skipPlotFlowArea by lazy {
        ClickArea(1146, 15, 42, 54, false)
    }

    //often 跳过对话框
    val isSkipPlotFlowTask by lazy {
        val tag = "isSkipPlotFlow"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1163, 18), ColorRuleRatioImpl.getSimple(248, 215, 132))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1168, 24), ColorRuleRatioImpl.getSimple(255, 229, 146))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1169, 25), ColorRuleRatioImpl.getSimple(255, 230, 148))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1168, 33), ColorRuleRatioImpl.getSimple(255, 240, 164))
            // sequenceNumber:22 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1154, 22), ColorRuleRatioImpl.getSimple(255, 232, 139))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1157, 27), ColorRuleRatioImpl.getSimple(255, 232, 152))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1158, 27), ColorRuleRatioImpl.getSimple(255, 232, 152))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1156, 32), ColorRuleRatioImpl.getSimple(255, 238, 164))
            // sequenceNumber:18 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1180, 20), ColorRuleRatioImpl.getSimple(250, 217, 136))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1180, 26), ColorRuleRatioImpl.getSimple(252, 226, 145))
            // sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1180, 35), ColorRuleRatioImpl.getSimple(249, 237, 166))
            // sequenceNumber:17 blockNumber: 2  positionType:0
        )

        //这个是跳过的文字
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            173,
            255,
            173,
            255,
            173,
            1.05F,
            0.9F,
            1.05F,
            0.9F,
            1.05F,
            0.9F
        )
        pointList.add(
            PointRule(CoordinatePoint(1179, 55), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1175, 56), colorRule1)
            //red215,green215,blue215 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1177, 62), colorRule1)
            //red218,green218,blue218 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1179, 65), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1171, 57), colorRule1)
            //red255,green255,blue255 sequenceNumber:26 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1159, 51), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1153, 53), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1157, 58), colorRule1)
            //red245,green245,blue245 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1158, 59), colorRule1)
            //red193,green193,blue193 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1149, 62), colorRule1)
            //red241,green241,blue241 sequenceNumber:18 blockNumber: 1  positionType:0
        )

        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 2
        }
    }


    //点击使用
    val clickUseArea by lazy {
        ClickArea(775,426,76,83,true)}
    //often
    val isClickUseTask by lazy {
        val tag = "isClickUse"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,165,255,164,255,162,1.0557376F,0.9F,1.0674033F,0.9F,1.0616022F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(735, 473), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(736, 476), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(736, 480), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(731, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 480),CoordinatePoint(734, 479), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(715, 474), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(716, 476), colorRule1)
            //red249,green249,blue248 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(713, 483), colorRule1)
            //red255,green254,blue254 sequenceNumber:11 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(716, 476),CoordinatePoint(717, 475), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(757, 473), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(757, 476), colorRule1)
            //red250,green250,blue250 sequenceNumber:5 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(755, 481), colorRule1)
            //red243,green242,blue242 sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(756, 483), colorRule1)
            //red184,green183,blue181 sequenceNumber:10 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(758, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(750, 479), colorRule1)
            //red255,green255,blue255 sequenceNumber:25 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(752, 474), colorRule1)
            //red255,green255,blue255 sequenceNumber:31 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(756, 483),CoordinatePoint(759, 483), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(775, 475), colorRule1)
            //red251,green251,blue251 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(771, 475), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(780, 474), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(780, 481), colorRule1)
            //red226,green225,blue225 sequenceNumber:10 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(771, 481), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(775, 482), colorRule1)
            //red252,green252,blue252 sequenceNumber:10 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(780, 487), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(780, 481),CoordinatePoint(779, 480), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(709, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(709, 487), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(709, 487),CoordinatePoint(711, 487), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }
    //often
    val isClickEquipTask by lazy {
        val tag = "isClickEquip"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,164,255,163,255,162,1.0557692F,0.9F,1.0675F,0.9F,1.0616667F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(735, 473), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(736, 476), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(736, 480), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(730, 482), colorRule1)
            //red206,green206,blue204 sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(732, 485), colorRule1)
            //red236,green235,blue235 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(738, 486), colorRule1)
            //red248,green247,blue247 sequenceNumber:19 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(730, 482),CoordinatePoint(730, 480), CompareDifferenceRuleImpl.getSimple(30,30,40)) // sequenceNumber:15sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(757, 472), colorRule1)
            //red241,green241,blue241 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(757, 475), colorRule1)
            //red236,green236,blue235 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(752, 475), colorRule1)
            //red183,green182,blue180 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(753, 482), colorRule1)
            //red249,green249,blue249 sequenceNumber:10 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(748, 486), colorRule1)
            //red195,green194,blue192 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(752, 475),CoordinatePoint(751, 474), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(773, 472), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(776, 475), colorRule1)
            //red255,green255,blue254 sequenceNumber:5 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(773, 475), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(779, 482), colorRule1)
            //red233,green233,blue233 sequenceNumber:10 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(772, 481), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(778, 488), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(779, 482),CoordinatePoint(779, 479), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(715, 474), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(716, 476), colorRule1)
            //red249,green249,blue249 sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(713, 481), colorRule1)
            //red225,green225,blue224 sequenceNumber:11 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(716, 476),CoordinatePoint(717, 475), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(709, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(709, 487), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(709, 487),CoordinatePoint(711, 487), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }

    //提升弹框的
    val tipsDetermineArea by lazy { ClickArea(718, 460, 149, 45, false) }
    val tipsCancellationArea by lazy { ClickArea(718, 460, 149, 45, false) }
    //often
    val isTipsDetermineTask by lazy {
        val tag = "isTipsDetermine"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            226,
            255,
            219,
            229,
            189,
            1.0844262F,
            0.9071146F,
            1.2540284F,
            1.0479451F,
            1.2193547F,
            1.039726F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(781, 473), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(781, 475), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(781, 475),
                CoordinatePoint(779, 475),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(784, 475), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(783, 478), colorRule1)
            //red255,green252,blue218 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(781, 483), colorRule1)
            //red253,green248,blue214 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(786, 482), colorRule1)
            //red255,green253,blue219 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(777, 489), colorRule1)
            //red255,green253,blue219 sequenceNumber:18 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(781, 483),
                CoordinatePoint(780, 482),
                CompareDifferenceRuleImpl.getSimple(15, 40, 30)
            ) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(808, 476), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(804, 476), colorRule1)
            //red255,green252,blue217 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(804, 476),
                CoordinatePoint(804, 478),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(774, 476), colorRule1)
            //red254,green250,blue216 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(772, 481), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(772, 485), colorRule1)
            //red255,green253,blue219 sequenceNumber:11 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(772, 481),
                CoordinatePoint(771, 479),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(796, 477), colorRule1)
            //red252,green244,blue211 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(798, 477), colorRule1)
            //red254,green250,blue216 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(798, 477),
                CoordinatePoint(798, 476),
                CompareDifferenceRuleImpl.getSimple(15, 30, 30)
            ) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(802, 481), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(803, 484), colorRule1)
            //red255,green252,blue218 sequenceNumber:5 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(802, 488), colorRule1)
            //red255,green253,blue219 sequenceNumber:10 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(809, 490), colorRule1)
            //red252,green248,blue214 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(802, 488),
                CoordinatePoint(802, 490),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $6  positionType:$6
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 3
        }
    }

    //新的功能開啓
    val isEnableNewFeaturesArea by lazy {
        ClickArea(433, 82, 426, 569, false)
    }
    //often
    val isEnableNewFeaturesTask by lazy {
        val tag = "isEnableNewFeatures"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            208,
            255,
            207,
            229,
            179,
            1.0591304F,
            0.9035714F,
            1.229147F,
            1.0458333F,
            1.2193547F,
            1.0381396F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(588, 628), colorRule1)
            //red252,green250,blue216 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(589, 633), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(589, 637), colorRule1)
            //red254,green252,blue218 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(590, 640), colorRule1)
            //red245,green243,blue210 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(589, 637),
                CoordinatePoint(588, 635),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(629, 628), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(631, 631), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(631, 631),
                CoordinatePoint(631, 626),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(711, 628), colorRule1)
            //red241,green239,blue207 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(712, 632), colorRule1)
            //red255,green253,blue219 sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(712, 632),
                CoordinatePoint(710, 633),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:7sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(568, 629), colorRule1)
            //red245,green243,blue210 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(570, 632), colorRule1)
            //red248,green247,blue213 sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(573, 636), colorRule1)
            //red255,green253,blue219 sequenceNumber:18 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(570, 632),
                CoordinatePoint(571, 631),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(606, 630), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(605, 632), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(604, 637), colorRule1)
            //red238,green236,blue204 sequenceNumber:10 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(604, 642), colorRule1)
            //red255,green253,blue219 sequenceNumber:15 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(604, 637),
                CoordinatePoint(603, 638),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(645, 629), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(644, 632), colorRule1)
            //red232,green230,blue199 sequenceNumber:5 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(645, 637), colorRule1)
            //red236,green235,blue203 sequenceNumber:10 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(644, 642), colorRule1)
            //red255,green253,blue219 sequenceNumber:15 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(645, 637),
                CoordinatePoint(646, 637),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(670, 629), colorRule1)
            //red232,green231,blue199 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(671, 630), colorRule1)
            //red232,green230,blue199 sequenceNumber:6 blockNumber: 7  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(671, 630),
                CoordinatePoint(672, 630),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(
            PointRule(CoordinatePoint(693, 629), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(693, 632), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(693, 640), colorRule1)
            //red255,green253,blue219 sequenceNumber:13 blockNumber: 8  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(693, 632),
                CoordinatePoint(698, 637),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            PointRule(CoordinatePoint(613, 630), colorRule1)
            //red249,green247,blue214 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(611, 637), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 10  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(611, 638), colorRule1)
            //red255,green253,blue219 sequenceNumber:10 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(614, 642), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 10  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(611, 638),
                CoordinatePoint(609, 639),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:10sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(
            PointRule(CoordinatePoint(627, 631), colorRule1)
            //red247,green245,blue212 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(627, 632), colorRule1)
            //red247,green245,blue212 sequenceNumber:4 blockNumber: 13  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(668, 631), colorRule1)
            //red242,green241,blue208 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(672, 634), colorRule1)
            //red234,green232,blue200 sequenceNumber:6 blockNumber: 14  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(672, 634),
                CoordinatePoint(674, 635),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(
            PointRule(CoordinatePoint(688, 631), colorRule1)
            //red243,green242,blue209 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(689, 638), colorRule1)
            //red241,green239,blue207 sequenceNumber:9 blockNumber: 15  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(689, 638),
                CoordinatePoint(684, 640),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:9sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(
            PointRule(CoordinatePoint(707, 632), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(702, 634), colorRule1)
            //red233,green232,blue200 sequenceNumber:6 blockNumber: 17  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(702, 634),
                CoordinatePoint(702, 633),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(
            PointRule(CoordinatePoint(633, 633), colorRule1)
            //red242,green241,blue208 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(635, 633), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(635, 633),
                CoordinatePoint(636, 631),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:4sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(
            PointRule(CoordinatePoint(653, 633), colorRule1)
            //red251,green250,blue216 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(649, 634), colorRule1)
            //red250,green248,blue215 sequenceNumber:4 blockNumber: 19  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(649, 634),
                CoordinatePoint(649, 632),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:4sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(
            PointRule(CoordinatePoint(687, 633), colorRule1)
            //red246,green244,blue211 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(684, 637), colorRule1)
            //red247,green245,blue211 sequenceNumber:6 blockNumber: 20  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(684, 637),
                CoordinatePoint(682, 637),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(
            PointRule(CoordinatePoint(631, 635), colorRule1)
            //red234,green232,blue200 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(632, 638), colorRule1)
            //red253,green251,blue217 sequenceNumber:6 blockNumber: 22  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(632, 638),
                CoordinatePoint(635, 638),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(
            PointRule(CoordinatePoint(593, 636), colorRule1)
            //red241,green239,blue207 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(595, 636), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 23  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(595, 636),
                CoordinatePoint(595, 634),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:4sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(
            PointRule(CoordinatePoint(653, 636), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(653, 639), colorRule1)
            //red244,green242,blue209 sequenceNumber:5 blockNumber: 26  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(653, 639),
                CoordinatePoint(655, 639),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(
            PointRule(CoordinatePoint(668, 636), colorRule1)
            //red253,green252,blue217 sequenceNumber:0 blockNumber: 27  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(666, 639), colorRule1)
            //red233,green232,blue200 sequenceNumber:5 blockNumber: 27  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(675, 643), colorRule1)
            //red247,green246,blue212 sequenceNumber:13 blockNumber: 27  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(666, 639),
                CoordinatePoint(665, 639),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $27  positionType:$27
        )
        pointList.add(
            PointRule(CoordinatePoint(712, 636), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 30  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(708, 640), colorRule1)
            //red241,green240,blue207 sequenceNumber:7 blockNumber: 30  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(708, 640),
                CoordinatePoint(707, 641),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:7sequenceNumber blockNumber: $30  positionType:$30
        )
        pointList.add(
            PointRule(CoordinatePoint(593, 639), colorRule1)
            //red245,green243,blue210 sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(594, 642), colorRule1)
            //red255,green253,blue219 sequenceNumber:5 blockNumber: 34  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(594, 642),
                CoordinatePoint(596, 642),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(
            PointRule(CoordinatePoint(585, 640), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 36  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(585, 642), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 36  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(585, 642),
                CoordinatePoint(583, 641),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:4sequenceNumber blockNumber: $36  positionType:$36
        )
        pointList.add(
            PointRule(CoordinatePoint(626, 641), colorRule1)
            //red239,green238,blue205 sequenceNumber:0 blockNumber: 42  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(633, 642), colorRule1)
            //red244,green242,blue209 sequenceNumber:9 blockNumber: 42  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(633, 642), colorRule1)
            //red244,green242,blue209 sequenceNumber:9 blockNumber: 42  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(633, 642),
                CoordinatePoint(633, 646),
                CompareDifferenceRuleImpl.getSimple(50, 50, 40)
            ) // sequenceNumber:9sequenceNumber blockNumber: $42  positionType:$42
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 9
        }
    }


    val isAutoFightingTask by lazy {
        val tag = "isAutoFightingTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,208,255,207,255,205,1.0855932F,0.9F,1.0960525F,0.9F,1.0722458F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(589, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 20, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(588, 223), colorRule1)
            //red252,green251,blue250 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(586, 229), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(586, 232), colorRule1)
            //red255,green255,blue254 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(585, 235), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(650, 221), colorRule1)
            //red232,green231,blue229 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(651, 223), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(651, 230), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(651, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(655, 229), colorRule1)
            //red244,green241,blue236 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(651, 236), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(651, 231),CoordinatePoint(648, 232), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(668, 221), colorRule1)
            //red247,green244,blue241 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 226), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(664, 226), colorRule1)
            //red238,green232,blue228 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(670, 230), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(665, 229), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(675, 227), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(669, 236), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(665, 229),CoordinatePoint(664, 232), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(613, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(613, 224), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 227), colorRule1)
            //red237,green236,blue235 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(606, 228), colorRule1)
            //red242,green242,blue242 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(608, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(616, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(601, 229), colorRule1)
            //red250,green249,blue248 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(606, 228),CoordinatePoint(607, 227), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(630, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 224), colorRule1)
            //red244,green236,blue236 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 228), colorRule1)
            //red252,green250,blue250 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(634, 226), colorRule1)
            //red239,green237,blue233 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(632, 232), colorRule1)
            //red253,green251,blue251 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(635, 236), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 227), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 223), colorRule1)
            //red248,green248,blue246 sequenceNumber:26 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(591, 225), colorRule1)
            //red249,green244,blue244 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(593, 230), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(589, 235), colorRule1)
            //red241,green241,blue240 sequenceNumber:14 blockNumber: 7  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }


    val isAutomaticPathfindingTask by lazy {
        val tag = "isAutomaticPathfinding"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,212,255,213,255,213,1.05F,0.8962025F,1.05F,0.8925926F,1.05F, 0.89626557F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(601, 191), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 40, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(601, 193), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(600, 197), colorRule1)
            //red241,green242,blue243 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(599, 201), colorRule1)
            //red236,green237,blue237 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(605, 200), colorRule1)
            //red246,green246,blue247 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(599, 204), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(599, 201),CoordinatePoint(597, 204), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(579, 192), colorRule1)
            //red240,green240,blue241 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(581, 192), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 195), colorRule1)
            //red240,green241,blue241 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(581, 200), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(581, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(579, 206), colorRule1)
            //red242,green242,blue242 sequenceNumber:19 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(581, 200),CoordinatePoint(586, 205), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(596, 193), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(593, 195), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(592, 199), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(592, 199),CoordinatePoint(589, 204), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:14sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    //总战力 用于判断是否进入卡点
    val isTotalCombatPowerTask by lazy {
        val tag = "isTotalCombatPower"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,177,255,176,255,176,1.0553571F,0.9F,1.0553571F,0.9F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(170, 12), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 100, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(169, 17), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(163, 17), colorRule1)
            //red197,green196,blue196 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(174, 16), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(168, 19), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(165, 25), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(174, 19), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(172, 27), colorRule1)
            //red255,green255,blue255 sequenceNumber:19 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(170, 12),CoordinatePoint(170, 10), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(168, 19),CoordinatePoint(166, 19), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(148, 12), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(149, 17), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(142, 14), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(150, 21), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(153, 21), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(140, 23), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(145, 23), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(151, 25), colorRule1)
            //red247,green247,blue247 sequenceNumber:15 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(155, 28), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(148, 12),CoordinatePoint(148, 10), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(153, 21),CoordinatePoint(156, 21), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(155, 28),CoordinatePoint(155, 26), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:20sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(122, 13), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(129, 12), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(122, 21), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(124, 21), colorRule1)
            //red241,green241,blue241 sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(128, 20), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(117, 26), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(122, 27), colorRule1)
            //red254,green254,blue254 sequenceNumber:15 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(130, 27), colorRule1)
            //red255,green255,blue255 sequenceNumber:19 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(122, 13),CoordinatePoint(122, 11), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(128, 20),CoordinatePoint(128, 22), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }


    val itemsInDemandArea by lazy {
        ClickArea(512,161,106,49,false)}

    val isItemsInDemandTask by lazy {
        val tag = "isItemsInDemand"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,202,252,136,187,105,1.5542762F,0.94499993F,2.0192306F,1.2589887F,1.4101745F, 1.1617022F)
        val pr  = PointRule(CoordinatePoint(209, 146), colorRule1)
        //red244,green202,blue154 sequenceNumber:4 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(206,134,7,255)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(214, 148), colorRule1)
            //red248,green231,blue174 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(203, 150), colorRule1)
            //red241,green182,blue141 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(208, 154), colorRule1)
            //red251,green238,blue178 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(213, 156), colorRule1)
            //red249,green231,blue172 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(213, 160), colorRule1)
            //red251,green239,blue179 sequenceNumber:17 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(208, 166), colorRule1)
            //red252,green240,blue179 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(207, 169), colorRule1)
            //red243,green214,blue162 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(204, 171), colorRule1)
            //red231,green163,blue126 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(208, 173), colorRule1)
            //red251,green239,blue178 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(202, 178), colorRule1)
            //red249,green237,blue178 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(205, 175), colorRule1)
            //red225,green152,blue117 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(211, 169), colorRule1)
            //red251,green239,blue179 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(212, 177), colorRule1)
            //red250,green238,blue178 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(207, 180), colorRule1)
            //red242,green223,blue167 sequenceNumber:17 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(209, 146),CoordinatePoint(209, 144), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(208, 154),CoordinatePoint(208, 158), CompareDifferenceRuleImpl.getSimple(15,40,30)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(213, 160),CoordinatePoint(212, 159), CompareDifferenceRuleImpl.getSimple(15,40,30)) // sequenceNumber:17sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(208, 166),CoordinatePoint(206, 166), CompareDifferenceRuleImpl.getSimple(15,40,30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }


    val isPurchaseItemArea by lazy {
        ClickArea(737,522,158,51,false)}

    val isPurchaseItemTask by lazy {
        val tag = "isPurchaseItem"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,215,255,193,229,164,1.1672094F,0.9071146F,1.3713115F,1.0479451F,1.2336065F, 1.039726F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(805, 539), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(805, 539), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(800, 546), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(799, 541), colorRule1)
            //red255,green252,blue218 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(795, 543), colorRule1)
            //red254,green251,blue217 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(797, 547), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(803, 550), colorRule1)
            //red255,green252,blue218 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(810, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(794, 547), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(807, 550), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(810, 547), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(795, 553), colorRule1)
            //red252,green247,blue213 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(799, 553), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(810, 552), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(808, 556), colorRule1)
            //red255,green253,blue219 sequenceNumber:23 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(810, 543),CoordinatePoint(810, 541), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(831, 540), colorRule1)
            //red253,green245,blue211 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(831, 540), colorRule1)
            //red253,green245,blue211 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(823, 540), colorRule1)
            //red250,green237,blue204 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(820, 540), colorRule1)
            //red249,green230,blue197 sequenceNumber:9 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(823, 540),CoordinatePoint(823, 539), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(827, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(827, 546), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(827, 548), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(828, 546), colorRule1)
            //red244,green222,blue190 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(822, 549), colorRule1)
            //red242,green220,blue189 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(825, 552), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(832, 548), colorRule1)
            //red253,green249,blue215 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(817, 550), colorRule1)
            //red239,green215,blue183 sequenceNumber:15 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(822, 549),CoordinatePoint(821, 548), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(822, 543), colorRule1)
            //red252,green245,blue211 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(823, 544), colorRule1)
            //red252,green245,blue211 sequenceNumber:5 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(823, 544),CoordinatePoint(821, 544), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(828, 552), colorRule1)
            //red252,green246,blue212 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(832, 555), colorRule1)
            //red255,green253,blue219 sequenceNumber:6 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(832, 555),CoordinatePoint(832, 552), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    val isPurchaseItem2Area by lazy {
        ClickArea(589,490,103,39,false)}
    //这个是商会的购买
    val isPurchaseItem2Task by lazy {
        val tag = "isPurchaseItem2"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,215,255,193,229,164,1.1672094F,0.9071146F,1.3713115F,1.0479451F,1.2336065F, 1.039726F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(630, 501), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(625, 508), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(624, 503), colorRule1)
            //red255,green252,blue218 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(620, 505), colorRule1)
            //red254,green251,blue217 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(622, 509), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(628, 512), colorRule1)
            //red255,green252,blue218 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(635, 505), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(632, 512), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(635, 509), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(620, 515), colorRule1)
            //red252,green247,blue213 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 515), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(635, 514), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(633, 518), colorRule1)
            //red255,green253,blue219 sequenceNumber:23 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(656, 502), colorRule1)
            //red253,green245,blue211 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(648, 502), colorRule1)
            //red250,green237,blue204 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(652, 505), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(652, 510), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 511), colorRule1)
            //red242,green220,blue189 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(650, 514), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 510), colorRule1)
            //red253,green249,blue215 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(642, 512), colorRule1)
            //red239,green215,blue183 sequenceNumber:15 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(647, 505), colorRule1)
            //red252,green245,blue211 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 517), colorRule1)
            //red255,green253,blue219 sequenceNumber:6 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(635, 505),CoordinatePoint(635, 503), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(648, 502),CoordinatePoint(648, 501), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(647, 511),CoordinatePoint(646, 510), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(648, 506),CoordinatePoint(646, 506), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(657, 517),CoordinatePoint(657, 514), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }


    val closeFriendshipArea by lazy {
        ClickArea(1228,38,33,36,true)}
    val isANewFriendshipTask by lazy {
        val tag = "ANewFriendship"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1176, 45), ColorRuleRatioImpl.getSimple(255,245,183))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1178, 47), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1175, 46), ColorRuleRatioImpl.getSimple(255,245,183))
            // sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1178, 47), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1170, 50), ColorRuleRatioImpl.getSimple(255,244,185))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1167, 52), ColorRuleRatioImpl.getSimple(255,244,185))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1159, 54), ColorRuleRatioImpl.getSimple(253,245,183))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1163, 55), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1159, 56), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1166, 60), ColorRuleRatioImpl.getSimple(255,244,185))
            // sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1158, 56), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1169, 63), ColorRuleRatioImpl.getSimple(255,242,184))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1160, 59), ColorRuleRatioImpl.getSimple(255,244,185))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1174, 67), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1174, 65), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1178, 66), ColorRuleRatioImpl.getSimple(254,245,183))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1178, 68), ColorRuleRatioImpl.getSimple(254,244,183))
            // sequenceNumber:37 blockNumber: 0  positionType:3
        )
        pointList.add(TwoPointRule(CoordinatePoint(1176, 45),CoordinatePoint(1176, 42), CompareDifferenceRuleImpl.getSimple(40,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1167, 52),CoordinatePoint(1167, 50), CompareDifferenceRuleImpl.getSimple(30,30,20)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1158, 56),CoordinatePoint(1156, 54), CompareDifferenceRuleImpl.getSimple(30,30,20)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1178, 66),CoordinatePoint(1182, 66), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }


    //这里是又选择对话框
    val dialogueSelectionBox1Area by lazy {
        ClickArea(883, 358, 368, 70, false)
    }
    val dialogueSelectionBox2Area by lazy {
        ClickArea(881, 456, 369, 72, false)
    }
    //often
    val hasDialogueSelectionBoxTask by lazy {
        val tag = "hasDialogueSelectionBox"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            195,
            164,
            172,
            144,
            126,
            105,
            1.2009375F,
            1.0207317F,
            1.6602564F,
            1.395F,
            1.4628205F,
            1.2203391F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(889, 358), colorRule1)
            //red183,green161,blue118 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(892, 358), colorRule1)
            //red183,green161,blue117 sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(888, 361), colorRule1)
            //red183,green160,blue118 sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(884, 365), colorRule1)
            //red183,green160,blue118 sequenceNumber:10 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 370), colorRule1)
            //red183,green161,blue117 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 375), colorRule1)
            //red183,green161,blue117 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 380), colorRule1)
            //red183,green161,blue117 sequenceNumber:25 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 385), colorRule1)
            //red184,green162,blue118 sequenceNumber:30 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 390), colorRule1)
            //red186,green164,blue120 sequenceNumber:35 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(882, 395), colorRule1)
            //red184,green161,blue117 sequenceNumber:40 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(882, 400), colorRule1)
            //red184,green161,blue117 sequenceNumber:45 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(882, 405), colorRule1)
            //red184,green161,blue118 sequenceNumber:50 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(882, 410), colorRule1)
            //red185,green162,blue117 sequenceNumber:55 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(881, 415), colorRule1)
            //red185,green162,blue117 sequenceNumber:60 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(886, 420), colorRule1)
            //red186,green163,blue118 sequenceNumber:66 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(889, 358),
                CoordinatePoint(891, 360),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(881, 385),
                CoordinatePoint(883, 385),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -30)
            ) // sequenceNumber:30sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(886, 420),
                CoordinatePoint(886, 418),
                CompareDifferenceRuleImpl.getSimple(-15, -20, -20)
            ) // sequenceNumber:66sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(889, 424), colorRule1)
            //red185,green163,blue117 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(894, 425), colorRule1)
            //red185,green163,blue119 sequenceNumber:7 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(889, 424),
                CoordinatePoint(890, 423),
                CompareDifferenceRuleImpl.getSimple(-15, -20, -20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(894, 425),
                CoordinatePoint(894, 424),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance =
                3
        }
    }

    val pickUpBangTask1Area by lazy {
        ClickArea(197,460,133,47,false)}
    val pickUpBangTask2Area by lazy {
        ClickArea(474,461,131,47,false)}
    val isBangTaskMenuTask by lazy {
        val tag = "isBangTaskMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(42, 116), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(48, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(35, 123), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 121), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(45, 126), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(44, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(43, 123), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(42, 135), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(42, 128), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(41, 139), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(37, 130), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(42, 146), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(36, 137), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(48, 146), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(53, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(56, 131), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(56, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(63, 136), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(54, 143), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(39, 144), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(56, 123), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(66, 135), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(58, 143), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(52, 145), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(36, 146), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(61, 121), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(62, 128), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(65, 145), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(53, 150), colorRule1)
            //red78,green60,blue24 sequenceNumber:118 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(34, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(63, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(66, 150), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(52, 153), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(65, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(64, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(52, 157), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(60, 154), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(52, 161), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(41, 152), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(62, 157), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(52, 165), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(42, 156), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(52, 169), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(42, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(52, 173), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(42, 116),CoordinatePoint(42, 112), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(53, 138),CoordinatePoint(53, 134), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:60sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(52, 153),CoordinatePoint(50, 153), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:76sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }

    val submitItemArea by lazy {
        ClickArea(566,474,151,42,false)}
    val isSubmitItemsTask by lazy {
        val tag = "isSubmitItems"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,182,229,154,1.2131069F,0.9071146F,1.4223838F,1.0479451F,1.2392441F, 1.039726F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(621, 483), colorRule1)
            //red248,green221,blue189 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(623, 489), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(618, 497), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(622, 494), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(628, 493), colorRule1)
            //red238,green206,blue176 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(622, 500), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(626, 496), colorRule1)
            //red254,green250,blue216 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(633, 487), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(633, 492), colorRule1)
            //red241,green213,blue182 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 499), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(636, 501), colorRule1)
            //red248,green239,blue206 sequenceNumber:26 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(651, 485), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(657, 486), colorRule1)
            //red255,green253,blue219 sequenceNumber:10 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(648, 491), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(653, 493), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(654, 490), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 499), colorRule1)
            //red233,green203,blue172 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(653, 499), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(659, 501), colorRule1)
            //red255,green253,blue219 sequenceNumber:18 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(621, 483),CoordinatePoint(621, 482), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(622, 500),CoordinatePoint(620, 499), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(636, 501),CoordinatePoint(636, 500), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:26sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(651, 485),CoordinatePoint(653, 485), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(651, 486),CoordinatePoint(649, 486), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(648, 491),CoordinatePoint(648, 493), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(654, 490),CoordinatePoint(651, 490), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(659, 501),CoordinatePoint(659, 499), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:18sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }

    val findAViewBtnArea by lazy {
        ClickArea(716,308,71,63,true)}
    val isFindAViewBtnTask by lazy {
        val tag = "isFindAViewBtn"
        val pr  = PointRule(CoordinatePoint(747, 327), ColorRuleRatioImpl.getSimple(242,236,203))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(645,273,213,159)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(746, 331), ColorRuleRatioImpl.getSimple(236,229,194))
            // sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(753, 326), ColorRuleRatioImpl.getSimple(239,234,205))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 331), ColorRuleRatioImpl.getSimple(239,231,198))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(738, 333), ColorRuleRatioImpl.getSimple(234,224,190))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(757, 329), ColorRuleRatioImpl.getSimple(238,230,199))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(744, 333), ColorRuleRatioImpl.getSimple(233,225,190))
            // sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(734, 333), ColorRuleRatioImpl.getSimple(234,224,190))
            // sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(761, 332), ColorRuleRatioImpl.getSimple(235,227,192))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(740, 337), ColorRuleRatioImpl.getSimple(228,216,182))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(765, 333), ColorRuleRatioImpl.getSimple(234,224,190))
            // sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(765, 338), ColorRuleRatioImpl.getSimple(226,212,179))
            // sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(739, 341), ColorRuleRatioImpl.getSimple(221,205,171))
            // sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(765, 342), ColorRuleRatioImpl.getSimple(220,203,169))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(740, 348), ColorRuleRatioImpl.getSimple(212,190,156))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(731, 335), ColorRuleRatioImpl.getSimple(232,219,185))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(768, 335), ColorRuleRatioImpl.getSimple(233,219,185))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(764, 350), ColorRuleRatioImpl.getSimple(208,185,152))
            // sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(742, 351), ColorRuleRatioImpl.getSimple(208,184,151))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(731, 339), ColorRuleRatioImpl.getSimple(225,211,176))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(746, 353), ColorRuleRatioImpl.getSimple(204,183,150))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(731, 343), ColorRuleRatioImpl.getSimple(220,200,166))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(759, 352), ColorRuleRatioImpl.getSimple(221,195,163))
            // sequenceNumber:36 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(731, 347), ColorRuleRatioImpl.getSimple(214,192,158))
            // sequenceNumber:36 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(768, 348), ColorRuleRatioImpl.getSimple(210,188,155))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(738, 351), ColorRuleRatioImpl.getSimple(207,183,150))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(731, 351), ColorRuleRatioImpl.getSimple(206,181,148))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(748, 338), ColorRuleRatioImpl.getSimple(223,216,184))
            // sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(755, 337), ColorRuleRatioImpl.getSimple(222,212,182))
            // sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(745, 342), ColorRuleRatioImpl.getSimple(221,199,177))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(758, 345), ColorRuleRatioImpl.getSimple(211,196,163))
            // sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(752, 348), ColorRuleRatioImpl.getSimple(215,188,161))
            // sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(747, 327),CoordinatePoint(747, 325), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(765, 342),CoordinatePoint(761, 342), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(733, 351),CoordinatePoint(733, 356), CompareDifferenceRuleImpl.getSimple(30,30,20)) // sequenceNumber:45sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(748, 338),CoordinatePoint(748, 335), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(745, 342),CoordinatePoint(744, 342), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag)
    }


    val closeViewShareArea by lazy {
        ClickArea(1208,19,31,34,true)}
    val findAViewBtn2Area by lazy {
        ClickArea(1049,305,110,117,true)}
    val isFindAViewBtn2Task by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1102, 341), ColorRuleRatioImpl.getSimple(255,255,242))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1100, 345), ColorRuleRatioImpl.getSimple(251,250,241))
            // sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1108, 339), ColorRuleRatioImpl.getSimple(249,249,241))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1104, 346), ColorRuleRatioImpl.getSimple(248,247,234))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1112, 339), ColorRuleRatioImpl.getSimple(250,247,240))
            // sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1108, 346), ColorRuleRatioImpl.getSimple(248,247,232))
            // sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1089, 348), ColorRuleRatioImpl.getSimple(252,252,247))
            // sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1119, 341), ColorRuleRatioImpl.getSimple(242,242,228))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1112, 346), ColorRuleRatioImpl.getSimple(248,245,227))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1085, 348), ColorRuleRatioImpl.getSimple(253,253,251))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1081, 348), ColorRuleRatioImpl.getSimple(254,254,252))
            // sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1123, 348), ColorRuleRatioImpl.getSimple(242,237,210))
            // sequenceNumber:24 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(1127, 349), ColorRuleRatioImpl.getSimple(239,233,203))
            // sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1077, 351), ColorRuleRatioImpl.getSimple(254,254,249))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1130, 352), ColorRuleRatioImpl.getSimple(237,232,192))
            // sequenceNumber:36 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1077, 355), ColorRuleRatioImpl.getSimple(252,252,247))
            // sequenceNumber:36 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1130, 356), ColorRuleRatioImpl.getSimple(234,228,181))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1077, 359), ColorRuleRatioImpl.getSimple(251,249,240))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1129, 360), ColorRuleRatioImpl.getSimple(231,225,177))
            // sequenceNumber:44 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1077, 363), ColorRuleRatioImpl.getSimple(248,246,234))
            // sequenceNumber:44 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1129, 364), ColorRuleRatioImpl.getSimple(230,222,170))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1077, 367), ColorRuleRatioImpl.getSimple(246,243,226))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1129, 368), ColorRuleRatioImpl.getSimple(229,221,169))
            // sequenceNumber:52 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1077, 371), ColorRuleRatioImpl.getSimple(244,241,218))
            // sequenceNumber:52 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1130, 374), ColorRuleRatioImpl.getSimple(227,219,166))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1077, 375), ColorRuleRatioImpl.getSimple(239,239,206))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1079, 379), ColorRuleRatioImpl.getSimple(239,231,198))
            // sequenceNumber:60 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1123, 380), ColorRuleRatioImpl.getSimple(229,221,169))
            // sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1083, 380), ColorRuleRatioImpl.getSimple(234,229,187))
            // sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1119, 380), ColorRuleRatioImpl.getSimple(229,220,169))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1087, 380), ColorRuleRatioImpl.getSimple(235,229,181))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1115, 380), ColorRuleRatioImpl.getSimple(229,220,169))
            // sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1091, 380), ColorRuleRatioImpl.getSimple(233,227,180))
            // sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1111, 380), ColorRuleRatioImpl.getSimple(229,220,169))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1095, 380), ColorRuleRatioImpl.getSimple(232,225,174))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1107, 380), ColorRuleRatioImpl.getSimple(229,221,169))
            // sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1099, 380), ColorRuleRatioImpl.getSimple(231,223,171))
            // sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1103, 380), ColorRuleRatioImpl.getSimple(229,221,169))
            // sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1105, 355), ColorRuleRatioImpl.getSimple(249,242,216))
            // sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1103, 357), ColorRuleRatioImpl.getSimple(249,242,210))
            // sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1110, 353), ColorRuleRatioImpl.getSimple(239,239,212))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1101, 362), ColorRuleRatioImpl.getSimple(239,231,198))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1115, 354), ColorRuleRatioImpl.getSimple(239,239,212))
            // sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1102, 367), ColorRuleRatioImpl.getSimple(239,231,198))
            // sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1104, 369), ColorRuleRatioImpl.getSimple(236,229,177))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1120, 362), ColorRuleRatioImpl.getSimple(233,222,178))
            // sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1110, 372), ColorRuleRatioImpl.getSimple(231,222,173))
            // sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1119, 367), ColorRuleRatioImpl.getSimple(233,222,178))
            // sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1116, 370), ColorRuleRatioImpl.getSimple(226,220,169))
            // sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1102, 341),CoordinatePoint(1102, 338), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1077, 363),CoordinatePoint(1074, 363), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:44sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1105, 355),CoordinatePoint(1105, 352), CompareDifferenceRuleImpl.getSimple(40,40,30)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1117, 355),CoordinatePoint(1117, 353), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val mountainsRiversPaintingTypeArea by lazy {
        ClickArea(84,221,144,31,false)}
    val isMountainsRiversPaintingTypeTask by lazy {
        val tag = "isMountainsRiversPaintingType"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,212,255,212,255,212,1.05F,0.9F,1.05F,0.89631146F,1.05F, 0.89631146F)
        val pr  = PointRule(CoordinatePoint(83, 218), colorRule1)
        //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(80,152,7,204)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(84, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(104, 218), colorRule1)
            //red243,green243,blue244 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(100, 219), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(77, 221), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(78, 227), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(105, 221), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(102, 224), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(99, 226), colorRule1)
            //red255,green255,blue255 sequenceNumber:19 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(108, 225), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(108, 230), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(104, 230), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(83, 226), colorRule1)
            //red244,green244,blue244 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(87, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(88, 226), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(95, 226), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(98, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(84, 222),CoordinatePoint(85, 223), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(100, 219),CoordinatePoint(100, 218), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(78, 223),CoordinatePoint(78, 219), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(102, 224),CoordinatePoint(104, 223), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(108, 230),CoordinatePoint(110, 230), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(84, 228),CoordinatePoint(86, 228), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(96, 228),CoordinatePoint(95, 228), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }


    val chamberCommerceArea by lazy {
        ClickArea(572,390,92,42,false)}

    val isChamberCommerceTask by lazy {
        val tag = "isChamberCommerce"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,186,255,185,255,185,1.055097F,0.9F,1.055097F,0.9F,1.05F, 0.9F)
        val pr  = PointRule(CoordinatePoint(376, 404), colorRule1)
        //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(373,300,7,225)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(382, 410), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(372, 409), colorRule1)
            //red251,green251,blue251 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(375, 414), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(379, 417), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(355, 403), colorRule1)
            //red219,green218,blue218 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(356, 406), colorRule1)
            //red229,green229,blue229 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(349, 406), colorRule1)
            //red207,green206,blue206 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(354, 408), colorRule1)
            //red249,green249,blue249 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(361, 410), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(362, 405), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(352, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(357, 414), colorRule1)
            //red232,green231,blue231 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(361, 418), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(376, 404),CoordinatePoint(378, 404), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(372, 409),CoordinatePoint(372, 407), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(379, 417),CoordinatePoint(380, 415), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(355, 403),CoordinatePoint(355, 402), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(362, 405),CoordinatePoint(362, 403), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val closeTradeMenuArea by lazy {
        ClickArea(1150,60,39,35,true)}
    val isTradeMenuTask by lazy {
        val tag = "isTradeMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(116, 58), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(120, 60), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(118, 62), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(125, 60), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(121, 63), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(113, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(112, 75), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(106, 75), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(122, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(103, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(127, 70), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(131, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(106, 80), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(110, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(123, 75), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(119, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(112, 88), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(116, 82), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(107, 91), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(104, 93), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(100, 94), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(125, 87), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(120, 95), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(128, 85), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(107, 95), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(119, 101), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(131, 84), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(111, 100), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(134, 86), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(110, 111), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(106, 113), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(122, 90), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(102, 114), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(96, 114), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(92, 113), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(124, 103), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(128, 104), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(135, 108), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(140, 112), colorRule1)
            //red78,green60,blue24 sequenceNumber:124 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(115, 107), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(144, 114), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(147, 116), colorRule1)
            //red78,green60,blue24 sequenceNumber:132 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(145, 118), colorRule1)
            //red78,green60,blue24 sequenceNumber:136 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(112, 88),CoordinatePoint(109, 85), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(102, 114),CoordinatePoint(102, 111), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:100sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(136, 109),CoordinatePoint(138, 107), CompareDifferenceRuleImpl.getSimple(-30,-30,-20)) // sequenceNumber:148sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }

    //多人副本的菜單
    val isMultiplayerDungeonMenuTask by lazy {
        val tag = "isMultiplayerDungeonMenuTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(50, 118), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(50, 122), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(52, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(46, 126), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(42, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(59, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(48, 130), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(59, 128), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(51, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(56, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(47, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(55, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(43, 142), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(65, 144), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(52, 142), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(48, 149), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(44, 151), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(58, 152), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(55, 156), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(52, 152), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(53, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(50, 164), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(46, 168), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(43, 170), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(40, 171), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(34, 172), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(50, 118),CoordinatePoint(48, 117), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(56, 132),CoordinatePoint(61, 132), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:28sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(55, 156),CoordinatePoint(50, 156), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:64sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(34, 172),CoordinatePoint(34, 170), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:92sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }

    val dungeonYanZiWuArea by lazy {
        ClickArea(137,559,123,37,false)}
    val findDungeonYanZiWuTask by lazy {
        val tag = "findDungeonYanZiWu"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,210,253,198,214,168,1.1240089F,0.95228213F,1.3232143F,1.1216749F,1.2428572F, 1.0585493F)
        val pr  = PointRule(CoordinatePoint(136, 217), colorRule1)
        //red253,green239,blue203 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(118,214,999,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(132, 223), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(140, 221), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(131, 219), colorRule1)
            //red254,green240,blue203 sequenceNumber:14 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(138, 224), colorRule1)
            //red242,green228,blue193 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(141, 227), colorRule1)
            //red238,green224,blue190 sequenceNumber:9 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(129, 225), colorRule1)
            //red249,green235,blue199 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(126, 231), colorRule1)
            //red240,green226,blue192 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(126, 235), colorRule1)
            //red247,green233,blue198 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(140, 233), colorRule1)
            //red254,green240,blue203 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(143, 235), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(138, 250), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(135, 256), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(128, 257), colorRule1)
            //red243,green229,blue194 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(142, 255), colorRule1)
            //red239,green225,blue191 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(134, 265), colorRule1)
            //red255,green241,blue204 sequenceNumber:18 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(129, 250), colorRule1)
            //red234,green220,blue187 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(136, 277), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(134, 283), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(134, 287), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(129, 279), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(129, 284), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(127, 289), colorRule1)
            //red249,green235,blue199 sequenceNumber:14 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(140, 281), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 13  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(139, 285), colorRule1)
            //red255,green241,blue204 sequenceNumber:6 blockNumber: 13  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(142, 288), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(141, 295), colorRule1)
            //red255,green241,blue204 sequenceNumber:9 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(138, 291), colorRule1)
            //red243,green227,blue193 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(133, 292), colorRule1)
            //red247,green232,blue196 sequenceNumber:5 blockNumber: 15  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(132, 223),CoordinatePoint(134, 223), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(139, 226),CoordinatePoint(137, 226), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(129, 227),CoordinatePoint(127, 226), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(126, 235),CoordinatePoint(125, 234), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(143, 235),CoordinatePoint(143, 232), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(128, 257),CoordinatePoint(128, 256), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(132, 250),CoordinatePoint(132, 248), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:5sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(134, 283),CoordinatePoint(134, 279), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(129, 284),CoordinatePoint(127, 281), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val dungeonManTuoShanArea by lazy {
        ClickArea(333,556,123,44,false)}
    val findDungeonManTuoShanTask by lazy {
        val tag = "findDungeonManTuoShan"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,211,253,198,214,168,1.1170213F,0.95228213F,1.3207895F,1.1227722F,1.2434211F, 1.0575F)
        val pr  = PointRule(CoordinatePoint(332, 128), colorRule1)
        //red255,green241,blue204 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(119,125,1003,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(327, 130), colorRule1)
            //red247,green233,blue197 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(323, 129), colorRule1)
            //red252,green238,blue202 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(334, 134), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(327, 134), colorRule1)
            //red239,green225,blue190 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(330, 139), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(326, 139), colorRule1)
            //red235,green221,blue187 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(326, 144), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(332, 145), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(336, 146), colorRule1)
            //red255,green241,blue204 sequenceNumber:13 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(325, 160), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(324, 167), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(329, 162), colorRule1)
            //red236,green222,blue188 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(328, 166), colorRule1)
            //red250,green235,blue200 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(329, 170), colorRule1)
            //red255,green241,blue204 sequenceNumber:16 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(337, 173), colorRule1)
            //red255,green241,blue204 sequenceNumber:26 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(320, 160), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(321, 170), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(320, 174), colorRule1)
            //red255,green241,blue204 sequenceNumber:16 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(336, 162), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(328, 190), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(328, 195), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(328, 199), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(322, 202), colorRule1)
            //red255,green241,blue204 sequenceNumber:16 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(335, 201), colorRule1)
            //red255,green241,blue204 sequenceNumber:16 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(336, 196), colorRule1)
            //red255,green241,blue204 sequenceNumber:23 blockNumber: 11  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(327, 130),CoordinatePoint(327, 127), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(334, 135),CoordinatePoint(334, 132), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(326, 135),CoordinatePoint(324, 136), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(326, 144),CoordinatePoint(325, 143), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(329, 162),CoordinatePoint(329, 161), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(321, 170),CoordinatePoint(319, 170), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(336, 162),CoordinatePoint(336, 159), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(328, 199),CoordinatePoint(326, 199), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $11  positionType:$11
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }

    val dungeonTianNingShiArea by lazy {
        ClickArea(526,559,125,39,false)}
    val findDungeonTianNingShiTask by lazy {
        val tag = "findDungeonTianNingShiTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,206,253,193,214,163,1.1183721F,0.95228213F,1.3211539F,1.1227722F,1.2424083F, 1.059375F)
        val pr  = PointRule(CoordinatePoint(524, 129), colorRule1)
        //red241,green227,blue192 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(121,126,993,7)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(521, 131), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(521, 136), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(520, 139), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(528, 134), colorRule1)
            //red239,green225,blue191 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 142), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(517, 143), colorRule1)
            //red255,green241,blue204 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(531, 145), colorRule1)
            //red255,green241,blue204 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(529, 161), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(524, 161), colorRule1)
            //red240,green226,blue191 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(516, 162), colorRule1)
            //red255,green241,blue204 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(524, 166), colorRule1)
            //red240,green226,blue192 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(518, 167), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(522, 176), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(523, 189), colorRule1)
            //red255,green241,blue204 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(523, 195), colorRule1)
            //red255,green241,blue204 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(516, 196), colorRule1)
            //red252,green238,blue202 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(525, 198), colorRule1)
            //red255,green241,blue204 sequenceNumber:12 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(524, 201), colorRule1)
            //red244,green230,blue195 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(530, 194), colorRule1)
            //red229,green215,blue182 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(523, 207), colorRule1)
            //red255,green241,blue204 sequenceNumber:21 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(528, 134),CoordinatePoint(528, 133), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(524, 161),CoordinatePoint(524, 163), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:5sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(515, 163),CoordinatePoint(514, 161), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(516, 167),CoordinatePoint(516, 166), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(525, 198),CoordinatePoint(527, 197), CompareDifferenceRuleImpl.getSimple(40,50,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }



    val maFeiTartArea by lazy {
        ClickArea(680,365,33,36,true)}
    //这个是马匪找图标的
    val findMaFeiTartTask by lazy {
        val tag = "isOpen"
        val pr  = PointRule(CoordinatePoint(688, 380), ColorRuleRatioImpl.getSimple(160,100,76))
        // sequenceNumber:0 blockNumber: 8  positionType:0
        val findArea = CoordinateArea(412,117,480,505)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(687, 386), ColorRuleRatioImpl.getSimple(176,110,84))
            // sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(702, 380), ColorRuleRatioImpl.getSimple(172,105,80))
            // sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(701, 383), ColorRuleRatioImpl.getSimple(179,113,87))
            // sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(691, 382), ColorRuleRatioImpl.getSimple(149,88,67))
            // sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 387), ColorRuleRatioImpl.getSimple(181,114,87))
            // sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(704, 387), ColorRuleRatioImpl.getSimple(183,111,86))
            // sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 391), ColorRuleRatioImpl.getSimple(165,97,72))
            // sequenceNumber:5 blockNumber: 19  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(692, 389), ColorRuleRatioImpl.getSimple(164,103,78))
            // sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(698, 391), ColorRuleRatioImpl.getSimple(159,97,73))
            // sequenceNumber:8 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(692, 369), ColorRuleRatioImpl.getSimple(189,123,96))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 371), ColorRuleRatioImpl.getSimple(214,139,109))
            // sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 375), ColorRuleRatioImpl.getSimple(182,118,93))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(702, 376), ColorRuleRatioImpl.getSimple(212,140,109))
            // sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(703, 381), ColorRuleRatioImpl.getSimple(203,128,100))
            // sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(693, 382), ColorRuleRatioImpl.getSimple(194,120,95))
            // sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 389), ColorRuleRatioImpl.getSimple(210,135,105))
            // sequenceNumber:0 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(702, 369), ColorRuleRatioImpl.getSimple(68,44,28))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(705, 370), ColorRuleRatioImpl.getSimple(72,48,28))
            // sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(692, 371), ColorRuleRatioImpl.getSimple(240,161,127))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(698, 371), ColorRuleRatioImpl.getSimple(242,159,126))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(688, 376), ColorRuleRatioImpl.getSimple(229,148,117))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(701, 376), ColorRuleRatioImpl.getSimple(241,166,134))
            // sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(694, 381), ColorRuleRatioImpl.getSimple(255,164,134))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(696, 385), ColorRuleRatioImpl.getSimple(247,163,130))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(690, 384), ColorRuleRatioImpl.getSimple(222,146,115))
            // sequenceNumber:22 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(686, 381), ColorRuleRatioImpl.getSimple(224,154,125))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 386), ColorRuleRatioImpl.getSimple(225,149,117))
            // sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(704, 384), ColorRuleRatioImpl.getSimple(222,144,111))
            // sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 392), ColorRuleRatioImpl.getSimple(247,168,137))
            // sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(686, 394), ColorRuleRatioImpl.getSimple(247,168,137))
            // sequenceNumber:10 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(703, 391), ColorRuleRatioImpl.getSimple(245,169,138))
            // sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(703, 395), ColorRuleRatioImpl.getSimple(237,161,132))
            // sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(686, 371), ColorRuleRatioImpl.getSimple(86,56,35))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 374), ColorRuleRatioImpl.getSimple(103,65,41))
            // sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(705, 371), ColorRuleRatioImpl.getSimple(86,58,34))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(706, 377), ColorRuleRatioImpl.getSimple(98,61,40))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(695, 373), ColorRuleRatioImpl.getSimple(251,187,164))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(702, 392), ColorRuleRatioImpl.getSimple(248,178,148))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(701, 396), ColorRuleRatioImpl.getSimple(240,189,167))
            // sequenceNumber:6 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 374), ColorRuleRatioImpl.getSimple(115,72,46))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 379), ColorRuleRatioImpl.getSimple(118,73,47))
            // sequenceNumber:7 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 381), ColorRuleRatioImpl.getSimple(132,74,53))
            // sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 385), ColorRuleRatioImpl.getSimple(114,64,43))
            // sequenceNumber:6 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 394), ColorRuleRatioImpl.getSimple(126,72,52))
            // sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(698, 393), ColorRuleRatioImpl.getSimple(123,67,48))
            // sequenceNumber:7 blockNumber: 10  positionType:0
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=2 }
    }



    val startTransportTreasureArea by lazy {
        ClickArea(987,601,150,44,false)}

    val refreshTransportTreasureArea by lazy {
        ClickArea(246,602,149,42,false)}

    val isTransportTreasureMenuTask by lazy {
        val tag = "isTransportTreasureMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(60, 332), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(57, 334), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(53, 334), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(61, 342), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(55, 337), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(52, 344), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(70, 345), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(60, 350), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(67, 349), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(54, 351), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(49, 353), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(65, 351), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(58, 354), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(46, 347), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(52, 360), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(41, 348), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(63, 358), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(56, 360), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(33, 349), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(38, 352), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(34, 342), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(38, 357), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(36, 338), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(42, 357), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(43, 340), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(37, 362), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 363), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(38, 336), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(38, 368), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(35, 334), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 372), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(43, 372), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(47, 371), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(31, 376), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(51, 368), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(47, 377), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(55, 367), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(31, 346), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(29, 349), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(60, 366), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(58, 372), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(28, 355), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(51, 377), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(68, 364), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(26, 357), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(71, 365), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(63, 371), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(58, 380), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(24, 361), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(29, 365), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(70, 374), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(22, 363), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(71, 377), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(32, 361), colorRule1)
            //red78,green60,blue24 sequenceNumber:120 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(70, 380), colorRule1)
            //red78,green60,blue24 sequenceNumber:120 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(60, 332),CoordinatePoint(60, 328), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(63, 358),CoordinatePoint(63, 355), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(47, 380),CoordinatePoint(43, 380), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:96sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=6 }
    }


    val initiateDialogueBtnArea by lazy {
        ClickArea(818,329,50,25,false)}
    //这个是对话
    val findInitiateDialogueBtnTask by lazy {
        val tag = "findInitiateDialogueBtn"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,186,255,185,255,185,1.055097F,0.9F,1.0599526F,0.9F,1.0549762F, 0.9F)
        val pr  = PointRule(CoordinatePoint(835, 332), colorRule1)
        //red248,green248,blue248 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(741,287,168,104)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(837, 337), colorRule1)
            //red246,green246,blue246 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(829, 336), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(836, 346), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(826, 343), colorRule1)
            //red213,green212,blue211 sequenceNumber:18 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(867, 332), colorRule1)
            //red230,green230,blue230 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(867, 338), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(867, 342), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(868, 348), colorRule1)
            //red220,green219,blue219 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(884, 332), colorRule1)
            //red230,green230,blue229 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(888, 336), colorRule1)
            //red240,green240,blue239 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(888, 340), colorRule1)
            //red240,green240,blue239 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(888, 344), colorRule1)
            //red240,green239,blue239 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(884, 348), colorRule1)
            //red207,green206,blue206 sequenceNumber:21 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(856, 334), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(855, 339), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(859, 338), colorRule1)
            //red223,green222,blue222 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(848, 339), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(851, 343), colorRule1)
            //red231,green230,blue230 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(848, 345), colorRule1)
            //red253,green253,blue253 sequenceNumber:17 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(875, 335), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(875, 340), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(874, 345), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(867, 338),CoordinatePoint(865, 338), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(888, 340),CoordinatePoint(889, 340), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(859, 338),CoordinatePoint(859, 337), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(875, 341),CoordinatePoint(876, 342), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=3 }
    }


    val transportTreasureTypeArea by lazy {
        ClickArea(79,230,168,53,false)}
    //护送镖车的任务
    val isTransportTreasureTypeTask by lazy {
        val tag = "isTransportTreasureType"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,210,255,210,255,210,1.05F,0.9F,1.05F,0.9F,1.05F, 0.9F)
        val pr  = PointRule(CoordinatePoint(202, 217), colorRule1)
        //red251,green251,blue251 sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(199,154,7,248)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(201, 221), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(203, 225), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(202, 231), colorRule1)
            //red234,green234,blue234 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(138, 218), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(139, 223), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(137, 227), colorRule1)
            //red239,green239,blue239 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(138, 232), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(178, 218), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(176, 224), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(178, 227), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(188, 218), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(183, 219), colorRule1)
            //red240,green240,blue240 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(147, 222), colorRule1)
            //red251,green251,blue251 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(165, 222), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(164, 225), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(143, 223), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(142, 230), colorRule1)
            //red245,green245,blue245 sequenceNumber:9 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(185, 228), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(185, 232), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 18  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(205, 228), colorRule1)
            //red240,green240,blue240 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(195, 229), colorRule1)
            //red241,green241,blue241 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(160, 230), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(168, 232), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(203, 225),CoordinatePoint(201, 224), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(137, 227),CoordinatePoint(137, 225), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(176, 224),CoordinatePoint(174, 224), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(187, 220),CoordinatePoint(187, 217), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(148, 224),CoordinatePoint(146, 224), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:5sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(TwoPointRule(CoordinatePoint(164, 225),CoordinatePoint(162, 224), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:4sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(TwoPointRule(CoordinatePoint(142, 230),CoordinatePoint(141, 229), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:9sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(TwoPointRule(CoordinatePoint(185, 232),CoordinatePoint(184, 230), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:5sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(TwoPointRule(CoordinatePoint(208, 228),CoordinatePoint(208, 230), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(TwoPointRule(CoordinatePoint(198, 229),CoordinatePoint(197, 228), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:5sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(TwoPointRule(CoordinatePoint(162, 231),CoordinatePoint(162, 233), CompareDifferenceRuleImpl.getSimple(50,50,50)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=4 }
    }

    val closeTeamStatusArea by lazy {
        ClickArea(937,190,30,37,true)}
    val isTeamStatusTask by lazy {
        val tag = "isTeamStatus"
        val colorRule1=ColorRuleRatioImpl.getSimple(85,70,67,54,30,21,1.365F,1.1390625F,3.4125F,2.513793F,2.625F, 1.9862069F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(684, 198), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(683, 203), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(681, 206), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 208), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(688, 202), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 210), colorRule1)
            //red78,green60,blue24 sequenceNumber:18 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(620, 199), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(617, 206), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(617, 212), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(616, 218), colorRule1)
            //red78,green60,blue24 sequenceNumber:22 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(649, 200), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(649, 204), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(649, 208), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(643, 215), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 212), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(649, 216), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(648, 219), colorRule1)
            //red78,green60,blue24 sequenceNumber:23 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(656, 198), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 204), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 208), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(656, 212), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(662, 216), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(662, 207), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(666, 218), colorRule1)
            //red78,green60,blue24 sequenceNumber:23 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(598, 200), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(597, 205), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(596, 209), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(594, 213), colorRule1)
            //red80,green62,blue27 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(601, 215), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(606, 218), colorRule1)
            //red78,green60,blue24 sequenceNumber:22 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(590, 201), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(632, 200), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(628, 201), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 202), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(627, 204), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(626, 208), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(631, 208), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(625, 212), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(631, 216), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(635, 216), colorRule1)
            //red78,green60,blue24 sequenceNumber:25 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 201), colorRule1)
            //red81,green64,blue29 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 207), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 211), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 215), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 219), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(589, 206), colorRule1)
            //red81,green64,blue29 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(590, 210), colorRule1)
            //red78,green60,blue24 sequenceNumber:5 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(691, 213), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(675, 217), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 16  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(680, 217), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(682, 219), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(687, 221), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 18  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(692, 220), colorRule1)
            //red78,green60,blue24 sequenceNumber:14 blockNumber: 18  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(681, 206),CoordinatePoint(680, 205), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(617, 208),CoordinatePoint(619, 208), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(643, 215),CoordinatePoint(643, 213), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:16sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(656, 212),CoordinatePoint(655, 212), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(TwoPointRule(CoordinatePoint(596, 209),CoordinatePoint(594, 209), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(590, 202),CoordinatePoint(588, 202), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(631, 208),CoordinatePoint(631, 205), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:12sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(585, 211),CoordinatePoint(583, 211), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:12sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(TwoPointRule(CoordinatePoint(693, 214),CoordinatePoint(693, 212), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(TwoPointRule(CoordinatePoint(674, 218),CoordinatePoint(672, 218), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(TwoPointRule(CoordinatePoint(687, 221),CoordinatePoint(687, 219), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:8sequenceNumber blockNumber: $18  positionType:$18
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=7 }
    }






    val findTianNingShiDialogTask by lazy {
        val tag = "findTianNingShiDialog"
        val colorRule1=ColorRuleRatioImpl.getSimple(56,26,59,25,58,24,1.0875F,0.846F,1.1277777F,0.86785716F,1.09375F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1122, 429), colorRule1)
            //red42,green43,blue42 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1071, 431), colorRule1)
            //red47,green50,blue48 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1099, 432), colorRule1)
            //red47,green50,blue48 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1125, 432), colorRule1)
            //red33,green32,blue32 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1119, 433), colorRule1)
            //red39,green40,blue39 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1123, 433), colorRule1)
            //red54,green57,blue56 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1074, 436), colorRule1)
            //red33,green32,blue32 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1120, 436), colorRule1)
            //red52,green55,blue53 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1068, 437), colorRule1)
            //red39,green40,blue39 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1117, 437), colorRule1)
            //red33,green32,blue32 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1091, 438), colorRule1)
            //red39,green40,blue39 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1097, 438), colorRule1)
            //red29,green28,blue27 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1071, 440), colorRule1)
            //red29,green28,blue27 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1096, 440), colorRule1)
            //red47,green50,blue48 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1127, 440), colorRule1)
            //red42,green43,blue42 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1070, 442), colorRule1)
            //red36,green36,blue36 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1074, 442), colorRule1)
            //red39,green40,blue39 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1068, 444), colorRule1)
            //red29,green28,blue27 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1080, 445), colorRule1)
            //red33,green32,blue32 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1122, 445), colorRule1)
            //red39,green40,blue39 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1123, 448), colorRule1)
            //red42,green43,blue42 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1073, 437),CoordinatePoint(1073, 438), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:9sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(TwoPointRule(CoordinatePoint(1117, 433),CoordinatePoint(1117, 432), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(TwoPointRule(CoordinatePoint(1075, 441),CoordinatePoint(1075, 440), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:4sequenceNumber blockNumber: $27  positionType:$27
        )
        pointList.add(TwoPointRule(CoordinatePoint(1095, 448),CoordinatePoint(1094, 448), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $34  positionType:$34
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    //退出副本按钮
    val exitDungeonBtnArea by lazy {
        ClickArea(1236,160,35,38,false)}
    //用是否有退出按钮判断是否进入了副本
    val isDungeonExitBtnTask by lazy {
        val tag = "isDungeonExitBtn"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1243, 169), ColorRuleRatioImpl.getSimple(253,245,214))
            // sequenceNumber:0 blockNumber: 0  positionType:3
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1246, 165), ColorRuleRatioImpl.getSimple(255,247,215))
            // sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1246, 172), ColorRuleRatioImpl.getSimple(251,240,208))
            // sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(1250, 165), ColorRuleRatioImpl.getSimple(255,247,215))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1254, 165), ColorRuleRatioImpl.getSimple(255,247,215))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1248, 176), ColorRuleRatioImpl.getSimple(247,235,202))
            // sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1258, 168), ColorRuleRatioImpl.getSimple(253,245,212))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1248, 180), ColorRuleRatioImpl.getSimple(244,230,197))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1249, 186), ColorRuleRatioImpl.getSimple(243,227,194))
            // sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1257, 186), ColorRuleRatioImpl.getSimple(243,227,195))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1246, 189), ColorRuleRatioImpl.getSimple(237,217,185))
            // sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1245, 186), ColorRuleRatioImpl.getSimple(239,221,189))
            // sequenceNumber:32 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(1242, 166), ColorRuleRatioImpl.getSimple(253,247,215))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1242, 179), ColorRuleRatioImpl.getSimple(245,231,198))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1242, 175), ColorRuleRatioImpl.getSimple(248,236,204))
            // sequenceNumber:44 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1254, 175), ColorRuleRatioImpl.getSimple(249,236,203))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1259, 175), ColorRuleRatioImpl.getSimple(248,238,212))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1266, 173), ColorRuleRatioImpl.getSimple(255,238,221))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1266, 178), ColorRuleRatioImpl.getSimple(249,236,203))
            // sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1243, 169),CoordinatePoint(1239, 169), CompareDifferenceRuleImpl.getSimple(50,50,40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1249, 186),CoordinatePoint(1251, 184), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:20sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1254, 175),CoordinatePoint(1252, 175), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1259, 175),CoordinatePoint(1259, 172), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1266, 173),CoordinatePoint(1266, 170), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1266, 178),CoordinatePoint(1265, 176), CompareDifferenceRuleImpl.getSimple(50,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }


}