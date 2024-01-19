package com.android.system.calendar.excuter

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

class LeiDianImageEnvironment {

    val switchAutoFightArea by lazy {
        ClickArea(700,542,99,33,false)}

    val closeBigMenuArea by lazy {
        ClickArea(1228,11,30,40,true)}

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




    val isChooseFashion1Area by lazy {
        ClickArea(638, 361, 83, 82, false)
    }
    val isChooseFashion2Area by lazy {
        ClickArea(778, 361, 83, 82, false)
    }
    val isChooseFashion3Area by lazy {
        ClickArea(919, 362, 81, 81, false)
    }


    //这个是确认按钮
    val isChooseFashionCfArea by lazy {
        ClickArea(725, 510, 188, 59, false)
    }
    //选择时装 KeyStep1
    val isChooseFashionTask by lazy {
        val tag = "isChooseFashion"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            220,
            255,
            207,
            229,
            179,
            1.1136363F,
            0.9071146F,
            1.2927135F,
            1.0479451F,
            1.2232499F,
            1.039726F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(781, 528), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(780, 533), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(783, 531), colorRule1)
            //red251,green244,blue211 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(777, 540), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(782, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(770, 539), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(766, 545), colorRule1)
            //red255,green252,blue218 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(780, 547), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(788, 547), colorRule1)
            //red255,green253,blue219 sequenceNumber:34 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(782, 543),
                CoordinatePoint(777, 548),
                CompareDifferenceRuleImpl.getSimple(15, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(863, 526), colorRule1)
            //red250,green244,blue210 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(861, 535), colorRule1)
            //red251,green244,blue210 sequenceNumber:11 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(861, 535),
                CoordinatePoint(861, 534),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(800, 528), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(799, 534), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(801, 533), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(798, 546), colorRule1)
            //red255,green253,blue219 sequenceNumber:21 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(801, 533),
                CoordinatePoint(802, 531),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(839, 528), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(840, 534), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(840, 534), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(840, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(838, 548), colorRule1)
            //red255,green253,blue219 sequenceNumber:23 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(840, 534),
                CoordinatePoint(838, 533),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(858, 528), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(852, 535), colorRule1)
            //red246,green233,blue200 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(852, 535),
                CoordinatePoint(852, 534),
                CompareDifferenceRuleImpl.getSimple(15, 30, 30)
            ) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(811, 529), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(808, 534), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(810, 534), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(808, 548), colorRule1)
            //red254,green251,blue216 sequenceNumber:22 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(810, 534),
                CoordinatePoint(812, 533),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(827, 531), colorRule1)
            //red245,green231,blue199 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(830, 536), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(825, 538), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 8  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(829, 544), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 8  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(825, 538),
                CoordinatePoint(827, 535),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            PointRule(CoordinatePoint(860, 537), colorRule1)
            //red254,green250,blue216 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(857, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 9  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(857, 543), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 9  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(863, 539), colorRule1)
            //red248,green235,blue202 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(866, 545), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 9  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(872, 546), colorRule1)
            //red250,green237,blue204 sequenceNumber:17 blockNumber: 9  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(863, 539),
                CoordinatePoint(866, 536),
                CompareDifferenceRuleImpl.getSimple(15, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 5
        }
    }


    val isShowCloseArea by lazy {
        ClickArea(1212, 6, 48, 67, false)
    }

    //often
    //正在显示关闭
    val isShowCloseTask by lazy {
        val tag = "isShowClose"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1228, 22), ColorRuleRatioImpl.getSimple(255, 227, 142))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1229, 23), ColorRuleRatioImpl.getSimple(255, 227, 142))
            // sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1232, 29), ColorRuleRatioImpl.getSimple(253, 233, 157))
            // sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1239, 23), ColorRuleRatioImpl.getSimple(255, 232, 139))
            // sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1240, 22), ColorRuleRatioImpl.getSimple(253, 227, 137))
            // sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1236, 29), ColorRuleRatioImpl.getSimple(255, 233, 156))
            // sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1240, 34), ColorRuleRatioImpl.getSimple(255, 244, 167))
            // sequenceNumber:21 blockNumber: 0  positionType:0
        )

        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            213,
            255,
            211,
            255,
            211,
            1.0589361F,
            0.9F,
            1.0589361F,
            0.9F,
            1.05F,
            0.9F
        )
        pointList.add(
            PointRule(CoordinatePoint(1225, 53), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1223, 59), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1229, 65), colorRule1)
            //red244,green244,blue244 sequenceNumber:18 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1223, 59),
                CoordinatePoint(1221, 58),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1246, 52), colorRule1)
            //red237,green235,blue235 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1249, 58), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1249, 64), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1249, 58),
                CoordinatePoint(1246, 58),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:10sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(1238, 54), colorRule1)
            //red237,green237,blue237 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1238, 57), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1237, 63), colorRule1)
            //red241,green241,blue241 sequenceNumber:11 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1238, 57),
                CoordinatePoint(1238, 53),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(1244, 54), colorRule1)
            //red240,green240,blue240 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1243, 59), colorRule1)
            //red251,green251,blue251 sequenceNumber:7 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1243, 59),
                CoordinatePoint(1241, 59),
                CompareDifferenceRuleImpl.getSimple(50, 50, 50)
            ) // sequenceNumber:7sequenceNumber blockNumber: $5  positionType:$5
        )

        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 1
        }
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

    //KeyStep=2 这里是打开神兵引
    val openWeaponGuideMenuArea by lazy {
        ClickArea(892, 101, 62, 52, false)
    }
    val isWeaponGuideMenuTask by lazy {
        val tag = "isWeaponGuideMenu"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            209,
            255,
            208,
            255,
            208,
            1.0545259F,
            0.9F,
            1.0589744F,
            0.9F,
            1.0544872F,
            0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(806, 194), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(807, 199), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(807, 203), colorRule1)
            //red254,green254,blue254 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(808, 206), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(824, 194), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(825, 199), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(824, 204), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(824, 208), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(870, 194), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(871, 197), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(870, 202), colorRule1)
            //red241,green241,blue240 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(874, 198), colorRule1)
            //red252,green252,blue252 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(786, 195), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(788, 198), colorRule1)
            //red249,green249,blue248 sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(791, 202), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(890, 195), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(888, 196), colorRule1)
            //red240,green240,blue240 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(911, 195), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(912, 198), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(912, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(912, 208), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(849, 196), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(850, 201), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 7  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(850, 204), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(854, 200), colorRule1)
            //red238,green238,blue237 sequenceNumber:10 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(850, 208), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(843, 197), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(844, 206), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(883, 197), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(884, 200), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(889, 202), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(893, 204), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(864, 200), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 13  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(864, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 13  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(863, 207), colorRule1)
            //red242,green241,blue241 sequenceNumber:10 blockNumber: 13  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(829, 200), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(831, 209), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 14  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(867, 200), colorRule1)
            //red251,green251,blue251 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(868, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 15  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(902, 200), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(902, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 16  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(905, 207), colorRule1)
            //red236,green236,blue235 sequenceNumber:11 blockNumber: 16  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(811, 202), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(813, 202), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(811, 205), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(812, 208), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 19  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(803, 206), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(803, 208), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(885, 206), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(882, 209), colorRule1)
            //red241,green241,blue241 sequenceNumber:5 blockNumber: 22  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(889, 206), colorRule1)
            //red236,green235,blue234 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(891, 207), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 23  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 6
        }
    }


    //神兵引的目标
    val receiveDivineWeapon1Area by lazy {
        ClickArea(615, 461, 83, 84, false)
    }
    //
    val receiveDivineWeapon5Area by lazy {
        ClickArea(1064,462,83,83,false)}

    //关闭神兵引
    val closeWeaponGuideTask by lazy {
        ClickArea(1168, 78, 33, 37, true)
    }
    val isOpenWeaponGuideTask by lazy {
        val tag = "isOpenWeaponGuide"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(149, 318), ColorRuleRatioImpl.getSimple(255, 237, 113))
            // sequenceNumber:0 blockNumber: 0  positionType:3
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(148, 318), ColorRuleRatioImpl.getSimple(255, 241, 129))
            // sequenceNumber:5 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(160, 317), ColorRuleRatioImpl.getSimple(255, 234, 113))
            // sequenceNumber:10 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(164, 321), ColorRuleRatioImpl.getSimple(255, 239, 130))
            // sequenceNumber:15 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(153, 322), ColorRuleRatioImpl.getSimple(249, 230, 106))
            // sequenceNumber:20 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(152, 334), ColorRuleRatioImpl.getSimple(255, 226, 100))
            // sequenceNumber:30 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(162, 341), ColorRuleRatioImpl.getSimple(255, 224, 100))
            // sequenceNumber:35 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(150, 340), ColorRuleRatioImpl.getSimple(255, 226, 110))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(152, 345), ColorRuleRatioImpl.getSimple(254, 225, 105))
            // sequenceNumber:45 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(161, 351), ColorRuleRatioImpl.getSimple(255, 214, 87))
            // sequenceNumber:50 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(151, 358), ColorRuleRatioImpl.getSimple(241, 198, 74))
            // sequenceNumber:55 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 361), ColorRuleRatioImpl.getSimple(247, 222, 123))
            // sequenceNumber:60 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(145, 362), ColorRuleRatioImpl.getSimple(231, 206, 110))
            // sequenceNumber:65 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(168, 369), ColorRuleRatioImpl.getSimple(244, 212, 102))
            // sequenceNumber:70 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(147, 371), ColorRuleRatioImpl.getSimple(246, 214, 103))
            // sequenceNumber:75 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 379), ColorRuleRatioImpl.getSimple(236, 200, 91))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(152, 366), ColorRuleRatioImpl.getSimple(255, 215, 107))
            // sequenceNumber:85 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(162, 389), ColorRuleRatioImpl.getSimple(238, 195, 87))
            // sequenceNumber:90 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 394), ColorRuleRatioImpl.getSimple(239, 198, 90))
            // sequenceNumber:95 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(152, 395), ColorRuleRatioImpl.getSimple(242, 206, 104))
            // sequenceNumber:100 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(165, 372), ColorRuleRatioImpl.getSimple(241, 199, 89))
            // sequenceNumber:105 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(144, 392), ColorRuleRatioImpl.getSimple(239, 206, 106))
            // sequenceNumber:110 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(160, 378), ColorRuleRatioImpl.getSimple(255, 238, 136))
            // sequenceNumber:115 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(134, 389), ColorRuleRatioImpl.getSimple(255, 233, 134))
            // sequenceNumber:120 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(149, 386), ColorRuleRatioImpl.getSimple(208, 180, 97))
            // sequenceNumber:125 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(146, 387), ColorRuleRatioImpl.getSimple(255, 221, 119))
            // sequenceNumber:130 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(143, 389), ColorRuleRatioImpl.getSimple(239, 206, 104))
            // sequenceNumber:134 blockNumber: 0  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(149, 318),
                CoordinatePoint(149, 314),
                CompareDifferenceRuleImpl.getSimple(40, 40, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(168, 364),
                CoordinatePoint(171, 364),
                CompareDifferenceRuleImpl.getSimple(40, 40, 20)
            ) // sequenceNumber:65sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(190, 382), ColorRuleRatioImpl.getSimple(239, 207, 111))
            // sequenceNumber:0 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(192, 377), ColorRuleRatioImpl.getSimple(241, 206, 105))
            // sequenceNumber:5 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 392), ColorRuleRatioImpl.getSimple(246, 223, 127))
            // sequenceNumber:10 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(193, 367), ColorRuleRatioImpl.getSimple(243, 210, 99))
            // sequenceNumber:15 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(193, 357), ColorRuleRatioImpl.getSimple(247, 206, 98))
            // sequenceNumber:25 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(193, 352), ColorRuleRatioImpl.getSimple(249, 213, 98))
            // sequenceNumber:30 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 381), ColorRuleRatioImpl.getSimple(243, 211, 111))
            // sequenceNumber:35 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(193, 342), ColorRuleRatioImpl.getSimple(255, 229, 114))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 371), ColorRuleRatioImpl.getSimple(242, 207, 99))
            // sequenceNumber:45 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(192, 335), ColorRuleRatioImpl.getSimple(255, 223, 115))
            // sequenceNumber:50 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 361), ColorRuleRatioImpl.getSimple(245, 210, 102))
            // sequenceNumber:55 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 326), ColorRuleRatioImpl.getSimple(255, 239, 140))
            // sequenceNumber:60 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 351), ColorRuleRatioImpl.getSimple(254, 217, 103))
            // sequenceNumber:65 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 325), ColorRuleRatioImpl.getSimple(255, 239, 140))
            // sequenceNumber:70 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 341), ColorRuleRatioImpl.getSimple(255, 229, 117))
            // sequenceNumber:75 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 335), ColorRuleRatioImpl.getSimple(255, 231, 126))
            // sequenceNumber:80 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(190, 382),
                CoordinatePoint(186, 382),
                CompareDifferenceRuleImpl.getSimple(30, 40, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(193, 337),
                CoordinatePoint(196, 337),
                CompareDifferenceRuleImpl.getSimple(40, 40, 30)
            ) // sequenceNumber:45sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 3
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
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
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
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
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


    //KeyStep 这里是点击轻功位置
    val clickLightnessSkillArea by lazy {
        ClickArea(1194,510,72,80,true)}
    val isClickLightnessSkillTask by lazy {
        val tag = "isClickLightnessSkill"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(959, 541), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(960, 544), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(960, 548), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(954, 550), ColorRuleRatioImpl.getSimple(208,206,204))
            // sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(956, 553), ColorRuleRatioImpl.getSimple(236,236,235))
            // sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(962, 554), ColorRuleRatioImpl.getSimple(248,247,247))
            // sequenceNumber:19 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(954, 550),CoordinatePoint(954, 548), CompareDifferenceRuleImpl.getSimple(30,30,40)) // sequenceNumber:15sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(996, 541), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(995, 543), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(997, 543), ColorRuleRatioImpl.getSimple(204,202,200))
            // sequenceNumber:5 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(992, 548), ColorRuleRatioImpl.getSimple(250,250,250))
            // sequenceNumber:10 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1005, 544), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1002, 548), ColorRuleRatioImpl.getSimple(241,241,240))
            // sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1007, 553), ColorRuleRatioImpl.getSimple(254,254,254))
            // sequenceNumber:17 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(992, 548),CoordinatePoint(992, 546), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1098, 540), ColorRuleRatioImpl.getSimple(250,250,250))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1101, 542), ColorRuleRatioImpl.getSimple(186,183,181))
            // sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1095, 545), ColorRuleRatioImpl.getSimple(177,174,171))
            // sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1105, 549), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1093, 554), ColorRuleRatioImpl.getSimple(253,253,253))
            // sequenceNumber:18 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1095, 545),CoordinatePoint(1094, 545), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(939, 542), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(940, 544), ColorRuleRatioImpl.getSimple(249,249,248))
            // sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(937, 549), ColorRuleRatioImpl.getSimple(226,225,224))
            // sequenceNumber:11 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(940, 544),CoordinatePoint(941, 543), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(975, 541), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(976, 545), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(974, 549), ColorRuleRatioImpl.getSimple(217,216,214))
            // sequenceNumber:10 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(982, 542), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(984, 549), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(987, 549), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(982, 542),CoordinatePoint(982, 540), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(1060, 542), ColorRuleRatioImpl.getSimple(250,250,250))
            // sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1059, 543), ColorRuleRatioImpl.getSimple(254,254,254))
            // sequenceNumber:5 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1063, 546), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1059, 549), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1051, 554), ColorRuleRatioImpl.getSimple(181,178,175))
            // sequenceNumber:21 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1063, 546),CoordinatePoint(1063, 544), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(1081, 541), ColorRuleRatioImpl.getSimple(213,212,211))
            // sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1079, 543), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1083, 545), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1075, 546), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1076, 554), ColorRuleRatioImpl.getSimple(235,234,234))
            // sequenceNumber:15 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1083, 555), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:15 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1086, 556), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:21 blockNumber: 6  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1075, 546),CoordinatePoint(1075, 544), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(1122, 542), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1122, 546), ColorRuleRatioImpl.getSimple(254,254,254))
            // sequenceNumber:5 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1121, 553), ColorRuleRatioImpl.getSimple(248,247,247))
            // sequenceNumber:10 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1121, 554), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:15 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1116, 543), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:23 blockNumber: 7  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1121, 553),CoordinatePoint(1123, 553), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(1022, 543), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1020, 542), ColorRuleRatioImpl.getSimple(185,183,180))
            // sequenceNumber:5 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1026, 542), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:5 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1014, 543), ColorRuleRatioImpl.getSimple(237,237,236))
            // sequenceNumber:10 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1022, 549), ColorRuleRatioImpl.getSimple(247,247,247))
            // sequenceNumber:10 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1021, 555), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:15 blockNumber: 8  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1014, 543),CoordinatePoint(1014, 542), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(1038, 543), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1035, 543), ColorRuleRatioImpl.getSimple(203,201,199))
            // sequenceNumber:5 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1039, 548), ColorRuleRatioImpl.getSimple(249,249,248))
            // sequenceNumber:5 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1040, 552), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1044, 545), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:10 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1042, 548), ColorRuleRatioImpl.getSimple(233,232,232))
            // sequenceNumber:10 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1045, 555), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:16 blockNumber: 9  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1040, 552),CoordinatePoint(1041, 551), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(1014, 546), ColorRuleRatioImpl.getSimple(233,232,232))
            // sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1018, 546), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:6 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1018, 546),CoordinatePoint(1017, 545), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:6sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(933, 554), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:0 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(933, 555), ColorRuleRatioImpl.getSimple(255,255,255))
            // sequenceNumber:4 blockNumber: 11  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(933, 555),CoordinatePoint(935, 555), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }

    //ofen正在寻路中
    val isSearchingWayTask by lazy {
        val tag = "isSearchingWay"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,193,255,192,255,192,1.0549065F,0.9F,1.0549065F,0.9F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(601, 193), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(597, 194), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(603, 194), colorRule1)
            //red254,green254,blue254 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(593, 194), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 203), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(605, 202), colorRule1)
            //red236,green235,blue235 sequenceNumber:10 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(594, 197), colorRule1)
            //red230,green229,blue229 sequenceNumber:18 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(601, 193),CoordinatePoint(599, 193), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(593, 194),CoordinatePoint(593, 192), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(594, 197),CoordinatePoint(592, 197), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:18sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(577, 192), colorRule1)
            //red215,green214,blue214 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 192), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(576, 195), colorRule1)
            //red234,green233,blue233 sequenceNumber:10 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 197), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(580, 207), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(577, 192),CoordinatePoint(577, 191), CompareDifferenceRuleImpl.getSimple(30,30,40)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(576, 195),CoordinatePoint(576, 194), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(580, 207),CoordinatePoint(578, 207), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:17sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    //KeyStep 打开功能列表
    val openFeatureListArea by lazy {
        ClickArea(1201,216,65,50,true)}
    val isOpenFeatureListTask by lazy {
        val tag = "isOpenFeatureList"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0589744F,0.9F,1.0545259F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(960, 231), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(961, 236), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(961, 240), colorRule1)
            //red254,green254,blue254 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(962, 243), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(961, 240),CoordinatePoint(960, 241), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(978, 231), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(979, 236), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(978, 241), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(978, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(978, 241),CoordinatePoint(980, 241), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1042, 231), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1042, 234), colorRule1)
            //red243,green243,blue243 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1042, 240), colorRule1)
            //red240,green240,blue239 sequenceNumber:11 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1042, 234),CoordinatePoint(1041, 234), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1067, 231), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1068, 234), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1068, 239), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1067, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1068, 239),CoordinatePoint(1066, 239), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(1080, 231), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1081, 234), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1077, 239), colorRule1)
            //red239,green238,blue238 sequenceNumber:10 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1083, 236), colorRule1)
            //red240,green240,blue239 sequenceNumber:10 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1087, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1077, 239),CoordinatePoint(1077, 238), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(940, 232), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(942, 235), colorRule1)
            //red249,green249,blue249 sequenceNumber:5 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(945, 239), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(942, 235),CoordinatePoint(943, 234), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(1024, 232), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1024, 237), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1023, 240), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1026, 243), colorRule1)
            //red250,green250,blue249 sequenceNumber:15 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1023, 240),CoordinatePoint(1025, 240), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(1037, 232), colorRule1)
            //red234,green234,blue233 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1036, 235), colorRule1)
            //red253,green253,blue253 sequenceNumber:5 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1036, 235),CoordinatePoint(1035, 234), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(1003, 233), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1004, 238), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1004, 241), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1008, 237), colorRule1)
            //red238,green238,blue237 sequenceNumber:10 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1004, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1004, 241),CoordinatePoint(1002, 241), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(1059, 233), colorRule1)
            //red234,green233,blue233 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1056, 238), colorRule1)
            //red236,green235,blue234 sequenceNumber:7 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1056, 238),CoordinatePoint(1056, 236), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:7sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(997, 234), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(998, 243), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(998, 243),CoordinatePoint(997, 242), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(1018, 235), colorRule1)
            //red241,green240,blue240 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1017, 238), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1013, 242), colorRule1)
            //red249,green249,blue249 sequenceNumber:9 blockNumber: 13  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1017, 238),CoordinatePoint(1015, 238), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(PointRule(CoordinatePoint(1064, 235), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1064, 239), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 15  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1064, 239),CoordinatePoint(1062, 239), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(983, 237), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(985, 246), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 18  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(985, 246),CoordinatePoint(984, 244), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(1060, 237), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1058, 243), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1058, 243),CoordinatePoint(1056, 243), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(1039, 238), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1039, 245), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 20  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1039, 245),CoordinatePoint(1038, 244), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:9sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(965, 239), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(967, 239), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(967, 239),CoordinatePoint(967, 237), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(965, 242), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(966, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(966, 245),CoordinatePoint(968, 245), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(957, 243), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(957, 245), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 27  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(957, 245),CoordinatePoint(956, 244), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $27  positionType:$27
        )
        pointList.add(PointRule(CoordinatePoint(1049, 243), colorRule1)
            //red233,green233,blue232 sequenceNumber:0 blockNumber: 29  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1043, 245), colorRule1)
            //red250,green250,blue250 sequenceNumber:7 blockNumber: 29  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1043, 245),CoordinatePoint(1044, 244), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:7sequenceNumber blockNumber: $29  positionType:$29
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=8 }
    }

    val isOpenMartialArtsInterfaceArea by lazy {
        ClickArea(1205,380,62,54,true)}
    val isOpenMartialArtsInterfaceTask by lazy {
        val tag = "isOpenMartialArtsInterface"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0545259F,0.9F,1.0545065F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(993, 399), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(994, 404), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(994, 408), colorRule1)
            //red254,green254,blue254 sequenceNumber:10 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(995, 411), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(994, 408),CoordinatePoint(993, 409), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(1011, 399), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1012, 404), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1011, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1011, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1011, 409),CoordinatePoint(1013, 409), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1054, 399), colorRule1)
            //red248,green247,blue247 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1056, 402), colorRule1)
            //red253,green253,blue253 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1057, 407), colorRule1)
            //red252,green252,blue252 sequenceNumber:10 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1062, 413), colorRule1)
            //red252,green252,blue252 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1057, 407),CoordinatePoint(1058, 406), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1078, 400), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1079, 403), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1079, 403),CoordinatePoint(1080, 401), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:7sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(1098, 399), colorRule1)
            //red235,green234,blue234 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1095, 402), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1091, 403), colorRule1)
            //red255,green255,blue254 sequenceNumber:10 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1092, 411), colorRule1)
            //red254,green254,blue254 sequenceNumber:17 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1091, 403),CoordinatePoint(1089, 403), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:10sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(973, 400), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(975, 403), colorRule1)
            //red249,green249,blue249 sequenceNumber:5 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(978, 407), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(975, 403),CoordinatePoint(976, 402), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(1117, 400), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1107, 406), colorRule1)
            //red244,green244,blue243 sequenceNumber:10 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1109, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1115, 406), colorRule1)
            //red244,green244,blue243 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1119, 412), colorRule1)
            //red255,green255,blue254 sequenceNumber:29 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1109, 411),CoordinatePoint(1107, 411), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:15sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(1036, 401), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1037, 406), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1037, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1041, 405), colorRule1)
            //red238,green238,blue237 sequenceNumber:10 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1037, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1037, 409),CoordinatePoint(1035, 409), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(1030, 402), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1031, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1031, 411),CoordinatePoint(1030, 410), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(1016, 405), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1018, 414), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 15  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1018, 414),CoordinatePoint(1017, 412), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(1049, 406), colorRule1)
            //red234,green234,blue233 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1050, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1047, 413), colorRule1)
            //red255,green255,blue254 sequenceNumber:9 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1050, 409),CoordinatePoint(1048, 409), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(1076, 406), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1074, 409), colorRule1)
            //red255,green255,blue254 sequenceNumber:5 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1074, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 18  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1074, 409),CoordinatePoint(1074, 407), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(1097, 408), colorRule1)
            //red248,green247,blue247 sequenceNumber:0 blockNumber: 19  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1099, 408), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1096, 413), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1099, 408),CoordinatePoint(1099, 406), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(998, 407), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1000, 407), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 20  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1000, 407),CoordinatePoint(1000, 405), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(1077, 409), colorRule1)
            //red238,green237,blue237 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1079, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1079, 409),CoordinatePoint(1079, 407), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(PointRule(CoordinatePoint(998, 410), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(999, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 23  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(999, 413),CoordinatePoint(1001, 413), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(PointRule(CoordinatePoint(1068, 410), colorRule1)
            //red239,green238,blue238 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1070, 410), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1070, 410),CoordinatePoint(1070, 409), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(990, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(990, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(990, 413),CoordinatePoint(989, 412), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $25  positionType:$25
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=8 }
    }

    val closeUpgradeAllSkillArea by lazy {
        ClickArea(1226,11,37,31,true)}
    val oneUpgradeAllSkill2Area by lazy {
        ClickArea(522,397,35,32,false)}
    val oneUpgradeAllSkill3Area by lazy {
        ClickArea(714,459,156,47,false)}
    val oneUpgradeAllSkillArea by lazy {
        ClickArea(832,637,156,52,false)}
    val isOneUpgradeAllSkillTask by lazy {
        val tag = "OneUpgradeAllSkill"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,209,255,208,1.0544872F,0.9F,1.0590129F,0.9F,1.0545259F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(648, 590), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(649, 595), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(649, 599), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(649, 600), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(650, 602), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(649, 599),CoordinatePoint(648, 600), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(769, 590), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(768, 594), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(767, 597), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(764, 600), colorRule1)
            //red253,green253,blue253 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(767, 600), colorRule1)
            //red250,green250,blue250 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(767, 603), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(764, 600),CoordinatePoint(764, 598), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(785, 590), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(786, 595), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(785, 600), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(783, 600), colorRule1)
            //red251,green251,blue251 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(785, 600), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(785, 604), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(783, 600),CoordinatePoint(783, 598), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(791, 590), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(792, 595), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(792, 596), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(793, 600), colorRule1)
            //red251,green251,blue251 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(796, 605), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(792, 596),CoordinatePoint(794, 596), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(810, 590), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(810, 592), colorRule1)
            //red245,green245,blue244 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(811, 596), colorRule1)
            //red243,green242,blue242 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(810, 599), colorRule1)
            //red240,green240,blue239 sequenceNumber:11 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(811, 596),CoordinatePoint(812, 595), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(628, 591), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 594), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(627, 600), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(633, 598), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(627, 600),CoordinatePoint(628, 600), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(684, 591), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(684, 593), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(683, 597), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(684, 601), colorRule1)
            //red255,green255,blue254 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(686, 600), colorRule1)
            //red235,green235,blue234 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 596), colorRule1)
            //red245,green245,blue245 sequenceNumber:20 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 602), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 598), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(694, 605), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 594), colorRule1)
            //red255,green255,blue255 sequenceNumber:28 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(693, 591), colorRule1)
            //red255,green255,blue255 sequenceNumber:33 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(689, 596),CoordinatePoint(689, 593), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:20sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(712, 591), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(712, 597), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(712, 597), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(715, 596), colorRule1)
            //red233,green233,blue232 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(708, 592), colorRule1)
            //red250,green250,blue249 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(708, 599), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(712, 601), colorRule1)
            //red249,green249,blue249 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(706, 603), colorRule1)
            //red255,green255,blue254 sequenceNumber:16 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(708, 592),CoordinatePoint(707, 592), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(754, 591), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 593), colorRule1)
            //red234,green234,blue233 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(751, 597), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 602), colorRule1)
            //red245,green245,blue245 sequenceNumber:13 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(748, 597),CoordinatePoint(749, 598), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(805, 591), colorRule1)
            //red235,green234,blue233 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(804, 594), colorRule1)
            //red253,green253,blue253 sequenceNumber:5 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(804, 594),CoordinatePoint(803, 593), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(733, 592), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(734, 594), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(734, 598), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(730, 598), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(733, 603), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(733, 603), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(726, 602), colorRule1)
            //red235,green234,blue234 sequenceNumber:16 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(730, 598),CoordinatePoint(728, 598), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(745, 593), colorRule1)
            //red241,green240,blue240 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(744, 595), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(744, 599), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(743, 602), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(744, 599),CoordinatePoint(742, 599), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(773, 593), colorRule1)
            //red247,green247,blue246 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(775, 593), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 15  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(775, 593),CoordinatePoint(775, 591), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(727, 595), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(723, 596), colorRule1)
            //red245,green244,blue244 sequenceNumber:5 blockNumber: 17  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(723, 596),CoordinatePoint(722, 595), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(757, 595), colorRule1)
            //red240,green240,blue239 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(754, 601), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(754, 604), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 18  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(754, 601),CoordinatePoint(752, 601), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(746, 596), colorRule1)
            //red239,green239,blue238 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(748, 597), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(748, 597),CoordinatePoint(749, 598), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(772, 596), colorRule1)
            //red253,green252,blue252 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(772, 598), colorRule1)
            //red245,green245,blue245 sequenceNumber:4 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(773, 602), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(772, 605), colorRule1)
            //red250,green250,blue250 sequenceNumber:11 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(773, 602),CoordinatePoint(775, 602), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(PointRule(CoordinatePoint(674, 597), colorRule1)
            //red239,green238,blue238 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 598), colorRule1)
            //red244,green244,blue243 sequenceNumber:6 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(668, 598),CoordinatePoint(668, 597), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(807, 597), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(807, 604), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(807, 604),CoordinatePoint(806, 603), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:9sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(PointRule(CoordinatePoint(653, 598), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(655, 598), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(655, 598),CoordinatePoint(655, 596), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(653, 601), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 35  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(654, 604), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 35  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(654, 604),CoordinatePoint(656, 604), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $35  positionType:$35
        )
        pointList.add(PointRule(CoordinatePoint(645, 602), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(645, 604), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 36  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(645, 604),CoordinatePoint(644, 603), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $36  positionType:$36
        )
        pointList.add(PointRule(CoordinatePoint(817, 602), colorRule1)
            //red234,green234,blue233 sequenceNumber:0 blockNumber: 38  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(811, 604), colorRule1)
            //red251,green250,blue250 sequenceNumber:7 blockNumber: 38  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(811, 604),CoordinatePoint(812, 603), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:7sequenceNumber blockNumber: $38  positionType:$38
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=6 }
    }



    //总战力 用于判断是否进入卡点
    val isTotalCombatPowerTask by lazy {
        val tag = "isTotalCombatPower"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,177,255,176,255,176,1.0553571F,0.9F,1.0553571F,0.9F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(170, 12), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
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
            nErrorTolerance=4 }
    }


    val mainTaskArea by lazy {
        ClickArea(58,155,179,44,false)}
    val isMainTaskTask by lazy {
        val tag = "isMainTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,219,255,216,255,211,1.0630707F,0.9F,1.0902128F,0.9F,1.0768085F, 0.9F)
        val pr  = PointRule(CoordinatePoint(60, 161), colorRule1)
        //red244,green241,blue235 sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(57,150,7,219)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(55, 162), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(58, 167), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(60, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(64, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(60, 161),CoordinatePoint(63, 156), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(55, 162),CoordinatePoint(53, 157), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(64, 170),CoordinatePoint(65, 173), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(64, 170),CoordinatePoint(65, 173), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag)
    }


    val painting1Area by lazy {
        ClickArea(922,105,119,95,false)}
    val painting2Area by lazy {
        ClickArea(803,487,119,95,false)}

    //Key
    val isPainting1Task by lazy {
        val tag = "isPainting1"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,196,255,190,229,160,1.0846698F,0.9071146F,1.2963687F,1.0479451F,1.2553073F, 1.039726F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(359, 48), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(359, 49), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(357, 53), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(359, 54), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(350, 54), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(352, 57), colorRule1)
            //red221,green215,blue181 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(359, 57), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(363, 52), colorRule1)
            //red238,green234,blue201 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(361, 57), colorRule1)
            //red222,green216,blue182 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(352, 49), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(349, 55), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(351, 63), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(359, 61), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(360, 61), colorRule1)
            //red221,green214,blue179 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(358, 66), colorRule1)
            //red255,green253,blue219 sequenceNumber:21 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(363, 52),CoordinatePoint(363, 51), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(334, 48), colorRule1)
            //red218,green212,blue179 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(330, 49), colorRule1)
            //red224,green219,blue186 sequenceNumber:6 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(330, 49),CoordinatePoint(330, 48), CompareDifferenceRuleImpl.getSimple(20,30,30)) // sequenceNumber:6sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(336, 53), colorRule1)
            //red255,green253,blue218 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(329, 53), colorRule1)
            //red239,green235,blue201 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(337, 53), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(328, 54), colorRule1)
            //red255,green253,blue219 sequenceNumber:9 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(337, 53),CoordinatePoint(337, 50), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(381, 56), colorRule1)
            //red219,green212,blue178 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(381, 56), colorRule1)
            //red219,green212,blue178 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(387, 56), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(373, 57), colorRule1)
            //red239,green236,blue201 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(371, 57), colorRule1)
            //red228,green223,blue189 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(387, 56),CoordinatePoint(387, 54), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(341, 58), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(340, 60), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(339, 63), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(330, 63), colorRule1)
            //red243,green240,blue205 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(326, 63), colorRule1)
            //red252,green250,blue216 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(325, 59), colorRule1)
            //red255,green253,blue219 sequenceNumber:22 blockNumber: 4  positionType:1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }

    val OpenMedicationList3Area by lazy {
        ClickArea(1212,334,40,42,true)}
    val OpenMedicationList2Area by lazy {
        ClickArea(673,263,321,94,false)}
    val OpenMedicationList1Area by lazy {
        ClickArea(1112,330,56,49,true)}

    val isOpenMedicationListTask by lazy {
        val tag = "OpenMedicationList"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0589744F,0.9F,1.0545065F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(948, 255), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(949, 260), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 264), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(949, 265), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(950, 267), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(949, 264),CoordinatePoint(948, 265), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(966, 255), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(967, 260), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(966, 265), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(965, 265), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(966, 265), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(966, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(965, 265),CoordinatePoint(965, 263), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1012, 255), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1008, 258), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1008, 258),CoordinatePoint(1009, 257), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1055, 255), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1055, 257), colorRule1)
            //red234,green234,blue233 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1056, 261), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1055, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1055, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1056, 261),CoordinatePoint(1054, 261), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(1068, 255), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1069, 258), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1068, 261), colorRule1)
            //red237,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1066, 265), colorRule1)
            //red245,green244,blue244 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1069, 265), colorRule1)
            //red245,green244,blue244 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1075, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1066, 265),CoordinatePoint(1064, 265), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(928, 256), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(930, 259), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(927, 265), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(933, 263), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(927, 265),CoordinatePoint(928, 265), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(991, 257), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(993, 257), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(992, 262), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(992, 263), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(996, 261), colorRule1)
            //red238,green238,blue237 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(992, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(992, 263),CoordinatePoint(994, 263), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(1032, 258), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1032, 259), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1032, 259),CoordinatePoint(1030, 259), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(1047, 257), colorRule1)
            //red234,green233,blue233 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1046, 259), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1044, 262), colorRule1)
            //red236,green235,blue234 sequenceNumber:7 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1046, 259),CoordinatePoint(1044, 259), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(985, 258), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(982, 263), colorRule1)
            //red237,green237,blue236 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(986, 267), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(982, 263),CoordinatePoint(982, 262), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(1025, 258), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1026, 260), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1026, 260),CoordinatePoint(1024, 260), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(1052, 259), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1052, 263), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1052, 263),CoordinatePoint(1050, 263), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(1011, 260), colorRule1)
            //red236,green236,blue235 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1012, 262), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1016, 265), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1014, 271), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 16  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1016, 265),CoordinatePoint(1014, 265), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(971, 261), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(973, 270), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(973, 270), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 17  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(973, 270),CoordinatePoint(972, 268), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(1006, 261), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1004, 263), colorRule1)
            //red242,green242,blue241 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1004, 263),CoordinatePoint(1004, 261), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(1048, 261), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1046, 267), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1046, 267),CoordinatePoint(1044, 267), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(953, 263), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(955, 263), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 20  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(955, 263),CoordinatePoint(955, 261), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(1036, 265), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 21  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1035, 266), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1031, 266), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1030, 265), colorRule1)
            //red254,green254,blue254 sequenceNumber:11 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1031, 266),CoordinatePoint(1033, 266), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(1025, 265), colorRule1)
            //red234,green234,blue233 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1022, 266), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 23  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1022, 266),CoordinatePoint(1022, 264), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(PointRule(CoordinatePoint(953, 266), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(954, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(954, 269),CoordinatePoint(956, 269), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(945, 267), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(945, 269), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(945, 269),CoordinatePoint(944, 268), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=10 }
    }

    val baishamenArea by lazy {
        ClickArea(935,51,35,37,true)}
    //Key
    val isBaishamenTask by lazy {
        val tag = "isBaishamen"
        val colorRule1=ColorRuleRatioImpl.getSimple(39,21,38,18,39,18,1.2F,0.92432433F,1.2F,0.9F,1.05F, 0.8735294F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(797, 144), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(796, 145), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(793, 149), colorRule1)
            //red24,green21,blue21 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(788, 154), colorRule1)
            //red24,green21,blue21 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(788, 156), colorRule1)
            //red24,green21,blue21 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(789, 162), colorRule1)
            //red24,green21,blue21 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(795, 163), colorRule1)
            //red35,green33,blue34 sequenceNumber:28 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(795, 163), colorRule1)
            //red35,green33,blue34 sequenceNumber:28 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(803, 164), colorRule1)
            //red24,green21,blue21 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(804, 159), colorRule1)
            //red24,green21,blue21 sequenceNumber:36 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(805, 155), colorRule1)
            //red24,green21,blue21 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(804, 151), colorRule1)
            //red24,green21,blue21 sequenceNumber:44 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(796, 151), colorRule1)
            //red38,green37,blue38 sequenceNumber:53 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(795, 163),CoordinatePoint(795, 162), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:28sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(800, 176), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(801, 177), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(800, 181), colorRule1)
            //red24,green21,blue21 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(800, 188), colorRule1)
            //red24,green21,blue21 sequenceNumber:14 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(800, 181),CoordinatePoint(798, 181), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(806, 182), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(809, 183), colorRule1)
            //red24,green21,blue21 sequenceNumber:5 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(809, 183),CoordinatePoint(809, 180), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(788, 186), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(788, 186), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(788, 186),CoordinatePoint(788, 183), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(795, 184), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(794, 187), colorRule1)
            //red24,green21,blue21 sequenceNumber:5 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(794, 187),CoordinatePoint(793, 186), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:5sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(805, 187), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(805, 188), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(803, 193), colorRule1)
            //red24,green21,blue21 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(800, 197), colorRule1)
            //red24,green21,blue21 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(794, 201), colorRule1)
            //red24,green21,blue21 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(803, 193),CoordinatePoint(801, 192), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(790, 191), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(788, 194), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(787, 196), colorRule1)
            //red24,green21,blue21 sequenceNumber:7 blockNumber: 9  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(788, 194),CoordinatePoint(788, 191), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(804, 210), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(801, 210), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(805, 211), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(805, 215), colorRule1)
            //red24,green21,blue21 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(805, 219), colorRule1)
            //red24,green21,blue21 sequenceNumber:12 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(806, 226), colorRule1)
            //red24,green21,blue21 sequenceNumber:16 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(805, 228), colorRule1)
            //red24,green21,blue21 sequenceNumber:20 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(804, 230), colorRule1)
            //red24,green21,blue21 sequenceNumber:23 blockNumber: 11  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(805, 219),CoordinatePoint(803, 219), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:12sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(787, 212), colorRule1)
            //red24,green21,blue21 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(788, 214), colorRule1)
            //red24,green21,blue21 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(788, 218), colorRule1)
            //red24,green21,blue21 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(788, 225), colorRule1)
            //red24,green21,blue21 sequenceNumber:12 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(787, 228), colorRule1)
            //red24,green21,blue21 sequenceNumber:18 blockNumber: 12  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(788, 218),CoordinatePoint(786, 218), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=6 }
    }

    val isAutoFightingTask by lazy {
        val tag = "isAutoFightingTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,208,255,207,255,205,1.0855932F,0.9F,1.0960525F,0.9F,1.0722458F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(589, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
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
        val correctPositionModel =CorrectPositionModel(list, tag, 15, 3, true)
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


    val openTheSettingsScreenArea by lazy {
        ClickArea(1132,384,51,47,true)}
    val isOpenTheSettingsScreenTask by lazy {
        val tag = "isOpenTheSettingsScreen"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0589744F,0.9F,1.0545065F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(917, 401), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(918, 406), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(918, 410), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(918, 411), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(919, 413), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(918, 410),CoordinatePoint(917, 411), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(935, 401), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(936, 406), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(935, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(934, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(935, 411), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(935, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(934, 411),CoordinatePoint(934, 409), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1022, 401), colorRule1)
            //red235,green234,blue234 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1023, 403), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1018, 403), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1016, 408), colorRule1)
            //red235,green234,blue234 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1016, 413), colorRule1)
            //red254,green254,blue254 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1018, 403),CoordinatePoint(1018, 401), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(897, 402), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(899, 405), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(896, 411), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(902, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(896, 411),CoordinatePoint(897, 411), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(982, 403), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(978, 403), colorRule1)
            //red244,green244,blue244 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(982, 404), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(979, 406), colorRule1)
            //red238,green237,blue237 sequenceNumber:7 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(982, 404),CoordinatePoint(984, 404), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(999, 402), colorRule1)
            //red234,green234,blue233 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1000, 403), colorRule1)
            //red234,green233,blue233 sequenceNumber:6 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1000, 403),CoordinatePoint(1001, 403), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(1041, 402), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1037, 403), colorRule1)
            //red238,green237,blue237 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1036, 407), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1032, 410), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1036, 410), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1033, 414), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1041, 407), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1044, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1043, 414), colorRule1)
            //red255,green255,blue254 sequenceNumber:29 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1036, 410),CoordinatePoint(1034, 410), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(960, 403), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(962, 403), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(961, 408), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(961, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(965, 407), colorRule1)
            //red238,green238,blue237 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(961, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(961, 409),CoordinatePoint(963, 409), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(954, 404), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(951, 409), colorRule1)
            //red237,green237,blue236 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(955, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(951, 409),CoordinatePoint(951, 408), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(997, 404), colorRule1)
            //red243,green243,blue243 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1001, 407), colorRule1)
            //red236,green235,blue234 sequenceNumber:6 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1001, 407),CoordinatePoint(1003, 408), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(940, 407), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(942, 416), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 13  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(942, 416), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 13  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(942, 416),CoordinatePoint(941, 414), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(PointRule(CoordinatePoint(973, 408), colorRule1)
            //red251,green251,blue251 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(974, 414), colorRule1)
            //red251,green251,blue251 sequenceNumber:4 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(973, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(974, 414),CoordinatePoint(972, 414), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(1021, 410), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 15  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1022, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1021, 410), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 15  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1020, 415), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 15  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1021, 410),CoordinatePoint(1019, 411), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(922, 409), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(924, 409), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(924, 409),CoordinatePoint(924, 407), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(981, 409), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(978, 411), colorRule1)
            //red247,green247,blue246 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(983, 416), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(985, 416), colorRule1)
            //red247,green247,blue247 sequenceNumber:11 blockNumber: 17  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(983, 416),CoordinatePoint(983, 414), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(997, 409), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(995, 411), colorRule1)
            //red243,green242,blue242 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1001, 412), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1004, 416), colorRule1)
            //red248,green248,blue248 sequenceNumber:13 blockNumber: 18  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1001, 412),CoordinatePoint(1003, 412), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(922, 412), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(923, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 20  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(923, 415),CoordinatePoint(925, 415), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(914, 413), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(914, 415), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(914, 415),CoordinatePoint(913, 414), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $22  positionType:$22
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=9 }
    }


    val closeSettingArea by lazy {
        ClickArea(1155,63,30,29,false)}
    val clickFuZhu3Area by lazy {
        ClickArea(794,165,224,83,false)}
    val clickFuZhu2Area by lazy {
        ClickArea(1038,510,83,81,false)}
    val clickFuZhu1Area by lazy {
        ClickArea(604,507,81,83,false)}
    val clickFuZhuArea by lazy {
        ClickArea(85,316,101,52,false)}
    val isOpenSettingMenuTask by lazy {
        val tag = "isOpenSettingMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(99, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(101, 64), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(102, 65), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(104, 64), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(102, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(129, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(131, 62), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(126, 63), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(132, 62), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(122, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(131, 66), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(128, 64), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(130, 70), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(128, 70), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(130, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(128, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(135, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(129, 76), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(138, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(130, 80), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(125, 88), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(130, 79), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(121, 91), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(129, 88), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(117, 92), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(133, 88), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(117, 92), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(131, 90), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(130, 94), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(121, 92), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(130, 98), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(131, 104), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(130, 92), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(135, 105), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(129, 100), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(139, 107), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(127, 104), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(143, 109), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(121, 102), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(147, 112), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(127, 104), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(115, 99), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(151, 116), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(124, 108), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(113, 97), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(121, 111), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(108, 94), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(118, 112), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(104, 97), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(112, 113), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(104, 98), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(123, 109), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(107, 112), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(103, 86), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(102, 102), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(103, 111), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(105, 82), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(99, 106), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(108, 80), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(95, 110), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(95, 110), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(106, 80), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(94, 108), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(102, 83), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(98, 106), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(98, 85), colorRule1)
            //red78,green60,blue24 sequenceNumber:120 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(101, 102), colorRule1)
            //red78,green60,blue24 sequenceNumber:120 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(92, 85), colorRule1)
            //red78,green60,blue24 sequenceNumber:124 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(103, 98), colorRule1)
            //red78,green60,blue24 sequenceNumber:124 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(103, 90), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(92, 88), colorRule1)
            //red78,green60,blue24 sequenceNumber:132 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(102, 86), colorRule1)
            //red78,green60,blue24 sequenceNumber:132 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(93, 89), colorRule1)
            //red78,green60,blue24 sequenceNumber:138 blockNumber: 1  positionType:3
        )
        pointList.add(TwoPointRule(CoordinatePoint(147, 112),CoordinatePoint(147, 108), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:72sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(120, 67), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(117, 68), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(119, 69), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(119, 71), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(117, 71), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(118, 75), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(117, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(116, 79), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(116, 79), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(115, 83), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 2  positionType:2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=9 }
    }
    val openEquipSettingArea by lazy {
        ClickArea(1210,456,49,62,true)}
    val isOpenEquipSettingTask by lazy {
        val tag = "isOpenEquipSetting"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0545259F,0.9F,1.054468F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(993, 481), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(994, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(994, 490), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(994, 491), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(995, 493), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(994, 490),CoordinatePoint(993, 491), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(1011, 481), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1012, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1011, 491), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1010, 491), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1011, 491), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1011, 495), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1010, 491),CoordinatePoint(1010, 489), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1056, 481), colorRule1)
            //red242,green241,blue241 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1057, 484), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1057, 485), colorRule1)
            //red248,green247,blue247 sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1057, 484),CoordinatePoint(1055, 483), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1072, 481), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1072, 483), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1075, 486), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1070, 492), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1077, 491), colorRule1)
            //red249,green249,blue249 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1072, 494), colorRule1)
            //red236,green236,blue235 sequenceNumber:18 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1070, 492),CoordinatePoint(1070, 489), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(1098, 481), colorRule1)
            //red235,green234,blue234 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1099, 483), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1094, 483), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1092, 488), colorRule1)
            //red235,green234,blue234 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1092, 493), colorRule1)
            //red254,green254,blue254 sequenceNumber:17 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1094, 483),CoordinatePoint(1094, 481), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(973, 482), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(975, 485), colorRule1)
            //red249,green249,blue248 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(972, 491), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(978, 489), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(972, 491),CoordinatePoint(973, 491), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(1051, 482), colorRule1)
            //red238,green237,blue237 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1052, 485), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1052, 485),CoordinatePoint(1054, 486), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:6sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(1117, 482), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1113, 483), colorRule1)
            //red238,green237,blue237 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1112, 487), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1108, 490), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1112, 490), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1109, 494), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1117, 487), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1120, 489), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1119, 494), colorRule1)
            //red255,green255,blue254 sequenceNumber:29 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1112, 490),CoordinatePoint(1110, 490), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(1036, 483), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1038, 483), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1037, 488), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1037, 489), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1041, 487), colorRule1)
            //red238,green238,blue237 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1037, 495), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1037, 489),CoordinatePoint(1039, 489), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(1030, 484), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1027, 489), colorRule1)
            //red237,green237,blue236 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1031, 493), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1027, 489),CoordinatePoint(1027, 488), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(1016, 487), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1018, 496), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1018, 496), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1018, 496),CoordinatePoint(1017, 494), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(1097, 490), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1098, 489), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1097, 490), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1096, 495), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1097, 490),CoordinatePoint(1095, 491), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(998, 489), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1000, 489), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 15  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1000, 489),CoordinatePoint(1000, 487), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(1054, 489), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1052, 491), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1052, 497), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 16  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1052, 491),CoordinatePoint(1055, 491), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(1058, 491), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1056, 493), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1060, 495), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1056, 493),CoordinatePoint(1056, 491), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(998, 492), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(999, 495), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(999, 495),CoordinatePoint(1001, 495), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(990, 493), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(990, 495), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(990, 495),CoordinatePoint(989, 494), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $21  positionType:$21
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=9 }
    }

    val closeEquipMenuArea by lazy {
        ClickArea(1230,9,30,38,true)}
    val clickJewel4Area by lazy {
        ClickArea(1082,190,144,68,false)}
    val clickJewel3Area by lazy {
        ClickArea(1045,119,184,33,false)}
    val clickJewel2Area by lazy {
        ClickArea(586,393,83,82,true)}
    val clickJewel1Area by lazy {
        ClickArea(1077,186,136,75,false)}

    val isOpenEquipMenuTask by lazy {
        val tag = "isOpenEquipMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(41, 21), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(42, 22), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 22), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 22), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(43, 26), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 25), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 34), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(51, 31), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(32, 34), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(35, 34), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(51, 31), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(39, 33), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(46, 31), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 32), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(41, 41), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 40), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(37, 42), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(45, 40), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(49, 40), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(46, 40), colorRule1)
            //red78,green60,blue24 sequenceNumber:54 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(23, 24), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(25, 26), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(28, 26), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(26, 29), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(26, 28), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(26, 34), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(26, 34), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(24, 39), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(19, 43), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(25, 40), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(13, 46), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(25, 44), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(12, 47), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(25, 48), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(13, 49), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(25, 42), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(16, 31), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(16, 31), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(35, 48), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(37, 49), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(37, 49), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(38, 49), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 54), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(50, 53), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(43, 54), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 53), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(35, 55), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(43, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(46, 57), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 57), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(33, 57), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(40, 64), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(31, 58), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(33, 68), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(44, 65), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(24, 59), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 70), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(50, 68), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(46, 70), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(21, 60), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(57, 71), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(41, 75), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 74), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(17, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(38, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(58, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(40, 76), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(14, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(62, 73), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(60, 73), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(17, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(65, 76), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 80), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(19, 61), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(66, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(30, 79), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(24, 59), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(30, 77), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(25, 68), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(21, 72), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(26, 67), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(17, 76), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(23, 71), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 4  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(13, 78), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(19, 74), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(9, 79), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 4  positionType:1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=9 }
    }


    val isAvoidPedestriansTask by lazy {
        val tag = "isAvoidPedestriansTask"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(92, 555), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(90, 558), ColorRuleRatioImpl.getSimple(251,239,210))
            // sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(91, 557), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(87, 562), ColorRuleRatioImpl.getSimple(251,242,211))
            // sequenceNumber:8 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(91, 559), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(82, 565), ColorRuleRatioImpl.getSimple(252,246,213))
            // sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(91, 563), ColorRuleRatioImpl.getSimple(249,240,210))
            // sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(79, 569), ColorRuleRatioImpl.getSimple(253,245,213))
            // sequenceNumber:16 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(92, 571), ColorRuleRatioImpl.getSimple(250,239,210))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(75, 572), ColorRuleRatioImpl.getSimple(255,247,214))
            // sequenceNumber:20 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(71, 576), ColorRuleRatioImpl.getSimple(255,248,215))
            // sequenceNumber:24 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(99, 574), ColorRuleRatioImpl.getSimple(247,235,209))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(67, 579), ColorRuleRatioImpl.getSimple(255,248,215))
            // sequenceNumber:28 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(103, 575), ColorRuleRatioImpl.getSimple(246,235,207))
            // sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(63, 581), ColorRuleRatioImpl.getSimple(255,248,215))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(107, 575), ColorRuleRatioImpl.getSimple(245,233,206))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(69, 586), ColorRuleRatioImpl.getSimple(255,248,215))
            // sequenceNumber:40 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(73, 589), ColorRuleRatioImpl.getSimple(255,247,214))
            // sequenceNumber:44 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(77, 593), ColorRuleRatioImpl.getSimple(254,246,214))
            // sequenceNumber:48 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(81, 596), ColorRuleRatioImpl.getSimple(253,244,213))
            // sequenceNumber:52 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(84, 600), ColorRuleRatioImpl.getSimple(252,243,212))
            // sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(89, 603), ColorRuleRatioImpl.getSimple(250,241,211))
            // sequenceNumber:60 blockNumber: 0  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(91, 607), ColorRuleRatioImpl.getSimple(249,239,211))
            // sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(91, 601), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(91, 597), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(91, 593), ColorRuleRatioImpl.getSimple(250,240,210))
            // sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(98, 589), ColorRuleRatioImpl.getSimple(248,237,208))
            // sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(102, 589), ColorRuleRatioImpl.getSimple(246,235,207))
            // sequenceNumber:92 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(106, 589), ColorRuleRatioImpl.getSimple(245,233,206))
            // sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(110, 589), ColorRuleRatioImpl.getSimple(243,230,204))
            // sequenceNumber:100 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(92, 555),CoordinatePoint(92, 553), CompareDifferenceRuleImpl.getSimple(15,15,10)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(71, 576),CoordinatePoint(71, 571), CompareDifferenceRuleImpl.getSimple(15,15,15)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(84, 600),CoordinatePoint(80, 600), CompareDifferenceRuleImpl.getSimple(15,15,10)) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }

    //装备一键强化
    val oneClickReinforcementArea by lazy {
        ClickArea(606,639,154,47,false)}

    val uncontrolArea by lazy {
        ClickArea(920,416,69,69,true)}
    val isUncontrolTask by lazy {
        val tag = "isUncontrol"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,212,255,212,255,211,1.0543933F,0.9F,1.054468F,0.9F,1.054468F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(680, 442), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(679, 444), colorRule1)
            //red241,green241,blue241 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(679, 444),CoordinatePoint(678, 444), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(700, 442), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(700, 444), colorRule1)
            //red251,green251,blue251 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(698, 448), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(702, 447), colorRule1)
            //red253,green253,blue253 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(699, 452), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(698, 456), colorRule1)
            //red248,green247,blue247 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(702, 447),CoordinatePoint(702, 445), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(720, 442), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(721, 447), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(720, 452), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(718, 452), colorRule1)
            //red251,green251,blue251 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(720, 452), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(720, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(718, 452),CoordinatePoint(718, 450), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(726, 442), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 447), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(727, 448), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(728, 452), colorRule1)
            //red251,green251,blue251 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(731, 457), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(727, 448),CoordinatePoint(729, 448), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(745, 442), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(745, 444), colorRule1)
            //red245,green244,blue244 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(746, 448), colorRule1)
            //red243,green242,blue242 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(745, 451), colorRule1)
            //red240,green240,blue239 sequenceNumber:11 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(746, 448),CoordinatePoint(747, 447), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(760, 442), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(759, 444), colorRule1)
            //red241,green241,blue241 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(759, 444),CoordinatePoint(758, 444), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(800, 442), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(800, 444), colorRule1)
            //red251,green251,blue251 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(798, 448), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(802, 447), colorRule1)
            //red253,green253,blue253 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(799, 452), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(798, 456), colorRule1)
            //red248,green247,blue247 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(802, 447),CoordinatePoint(802, 445), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(646, 443), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(647, 446), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(646, 449), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(643, 453), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(648, 446), colorRule1)
            //red249,green249,blue249 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(650, 457), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(643, 453),CoordinatePoint(642, 454), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(690, 443), colorRule1)
            //red245,green244,blue244 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 445), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(690, 445),CoordinatePoint(692, 445), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(741, 443), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(739, 446), colorRule1)
            //red253,green253,blue253 sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(739, 446),CoordinatePoint(738, 445), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(770, 443), colorRule1)
            //red245,green244,blue244 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(770, 445), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(770, 445),CoordinatePoint(772, 445), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(786, 443), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(785, 445), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(786, 445), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(790, 448), colorRule1)
            //red248,green248,blue248 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(786, 445),CoordinatePoint(786, 447), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(821, 443), colorRule1)
            //red243,green243,blue242 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(822, 447), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(822, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(822, 453), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(822, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(822, 449),CoordinatePoint(826, 450), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(830, 443), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(831, 445), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(831, 449), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(830, 457), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 15  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(830, 457), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 15  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(831, 449),CoordinatePoint(832, 449), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $15  positionType:$15
        )
        pointList.add(PointRule(CoordinatePoint(640, 444), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(639, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 16  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(639, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(639, 449),CoordinatePoint(637, 449), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(666, 444), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 444), colorRule1)
            //red251,green251,blue251 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 448), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(669, 448), colorRule1)
            //red236,green236,blue235 sequenceNumber:8 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 451), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(670, 452), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 454), colorRule1)
            //red248,green247,blue247 sequenceNumber:12 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 457), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 17  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(665, 451),CoordinatePoint(663, 450), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(781, 444), colorRule1)
            //red240,green239,blue239 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(777, 445), colorRule1)
            //red245,green245,blue245 sequenceNumber:4 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(778, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(777, 455), colorRule1)
            //red241,green241,blue240 sequenceNumber:14 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(778, 449),CoordinatePoint(776, 449), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(660, 445), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 454), colorRule1)
            //red251,green251,blue251 sequenceNumber:11 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(660, 454),CoordinatePoint(658, 454), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(PointRule(CoordinatePoint(708, 446), colorRule1)
            //red241,green241,blue240 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(711, 446), colorRule1)
            //red254,green254,blue254 sequenceNumber:5 blockNumber: 23  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(711, 446),CoordinatePoint(711, 444), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(PointRule(CoordinatePoint(808, 446), colorRule1)
            //red241,green241,blue240 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(811, 446), colorRule1)
            //red254,green254,blue254 sequenceNumber:5 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(811, 446),CoordinatePoint(811, 444), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(PointRule(CoordinatePoint(681, 447), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(680, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(680, 453), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(680, 449),CoordinatePoint(680, 446), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(761, 447), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(760, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(760, 453), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(760, 449),CoordinatePoint(760, 446), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(PointRule(CoordinatePoint(827, 447), colorRule1)
            //red238,green238,blue237 sequenceNumber:0 blockNumber: 29  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(828, 450), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 29  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(828, 450),CoordinatePoint(829, 450), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $29  positionType:$29
        )
        pointList.add(PointRule(CoordinatePoint(678, 448), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 30  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(678, 451), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 30  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(678, 451),CoordinatePoint(676, 451), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $30  positionType:$30
        )
        pointList.add(PointRule(CoordinatePoint(758, 448), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(758, 451), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 32  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(758, 451),CoordinatePoint(756, 451), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $32  positionType:$32
        )
        pointList.add(PointRule(CoordinatePoint(688, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(688, 453), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 34  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(688, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 34  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(688, 453),CoordinatePoint(686, 452), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(PointRule(CoordinatePoint(742, 449), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 37  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 456), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 37  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(742, 456),CoordinatePoint(741, 455), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:9sequenceNumber blockNumber: $37  positionType:$37
        )
        pointList.add(PointRule(CoordinatePoint(768, 449), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 39  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(768, 453), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 39  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(768, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 39  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(768, 453),CoordinatePoint(766, 452), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $39  positionType:$39
        )
        pointList.add(PointRule(CoordinatePoint(785, 450), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(786, 452), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(784, 457), colorRule1)
            //red246,green246,blue245 sequenceNumber:9 blockNumber: 43  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(786, 452),CoordinatePoint(784, 451), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $43  positionType:$43
        )
        pointList.add(PointRule(CoordinatePoint(824, 451), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 45  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(825, 454), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 45  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(825, 454),CoordinatePoint(827, 455), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $45  positionType:$45
        )
        pointList.add(PointRule(CoordinatePoint(705, 453), colorRule1)
            //red241,green241,blue240 sequenceNumber:0 blockNumber: 50  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(710, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 50  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(710, 456),CoordinatePoint(710, 454), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $50  positionType:$50
        )
        pointList.add(PointRule(CoordinatePoint(805, 453), colorRule1)
            //red241,green241,blue240 sequenceNumber:0 blockNumber: 51  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(810, 456), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 51  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(810, 456),CoordinatePoint(810, 454), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $51  positionType:$51
        )
        pointList.add(PointRule(CoordinatePoint(752, 455), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 54  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(746, 456), colorRule1)
            //red250,green250,blue250 sequenceNumber:6 blockNumber: 54  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(746, 456),CoordinatePoint(747, 455), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $54  positionType:$54
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=15 }
    }

    val closeShareActionArea by lazy {
        ClickArea(1224,21,32,39,true)}
    val isShareActionTask by lazy {
        val tag = "isShareAction"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,220,255,207,229,176,1.1367391F,0.9F,1.3339286F,1.0479451F,1.2328359F, 1.0479451F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1065, 660), colorRule1)
            //red249,green230,blue196 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1067, 660), colorRule1)
            //red255,green255,blue219 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1071, 665), colorRule1)
            //red255,green255,blue219 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1075, 668), colorRule1)
            //red255,green255,blue219 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1071, 670), colorRule1)
            //red255,green255,blue219 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1067, 669), colorRule1)
            //red248,green236,blue201 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1069, 676), colorRule1)
            //red255,green255,blue219 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1061, 668), colorRule1)
            //red255,green255,blue219 sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1068, 677), colorRule1)
            //red255,green255,blue219 sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1061, 668), colorRule1)
            //red255,green255,blue219 sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1062, 675), colorRule1)
            //red255,green255,blue219 sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1065, 660),CoordinatePoint(1065, 661), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1067, 669),CoordinatePoint(1067, 666), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1062, 675),CoordinatePoint(1062, 677), CompareDifferenceRuleImpl.getSimple(20,40,40)) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1097, 661), colorRule1)
            //red252,green242,blue207 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1091, 662), colorRule1)
            //red252,green244,blue209 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1090, 662), colorRule1)
            //red248,green230,blue196 sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1097, 661),CoordinatePoint(1097, 660), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1090, 662),CoordinatePoint(1090, 661), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:7sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1090, 662),CoordinatePoint(1090, 661), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:7sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1092, 664), colorRule1)
            //red248,green232,blue198 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1094, 664), colorRule1)
            //red255,green255,blue219 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1095, 669), colorRule1)
            //red255,green255,blue219 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1088, 667), colorRule1)
            //red255,green255,blue219 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1091, 671), colorRule1)
            //red254,green254,blue218 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1092, 672), colorRule1)
            //red255,green255,blue219 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1085, 673), colorRule1)
            //red245,green231,blue197 sequenceNumber:18 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1092, 664),CoordinatePoint(1090, 666), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(1088, 667),CoordinatePoint(1086, 666), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(TwoPointRule(CoordinatePoint(1085, 673),CoordinatePoint(1085, 672), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:18sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }

    val openMainRewardArea by lazy {
        ClickArea(291,155,32,23,true)}

    val isOpenMainRewardTask by lazy {
        val tag = "OpenMainRewards"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0545259F,0.9F,1.0544872F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(423, 165), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(424, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(424, 174), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(424, 175), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(425, 177), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(424, 174),CoordinatePoint(423, 175), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(441, 165), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(442, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(441, 175), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(440, 175), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(441, 175), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(441, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(440, 175),CoordinatePoint(440, 173), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(568, 165), colorRule1)
            //red235,green234,blue234 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(569, 167), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 167), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(562, 172), colorRule1)
            //red235,green234,blue234 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(562, 177), colorRule1)
            //red254,green254,blue254 sequenceNumber:17 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(564, 167),CoordinatePoint(564, 165), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(403, 166), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(405, 169), colorRule1)
            //red249,green249,blue248 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(402, 175), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(408, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(402, 175),CoordinatePoint(403, 175), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(504, 166), colorRule1)
            //red235,green235,blue234 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(505, 168), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(506, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(507, 176), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(509, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(510, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(507, 176),CoordinatePoint(505, 176), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(527, 166), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 168), colorRule1)
            //red241,green241,blue241 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(526, 168),CoordinatePoint(525, 167), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(549, 166), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 168), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(548, 172), colorRule1)
            //red250,green250,blue250 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(551, 171), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 176), colorRule1)
            //red250,green250,blue249 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(551, 171),CoordinatePoint(551, 169), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(587, 166), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 167), colorRule1)
            //red238,green237,blue237 sequenceNumber:4 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 171), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(578, 174), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 174), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(579, 178), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(587, 171), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(590, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(589, 178), colorRule1)
            //red255,green255,blue254 sequenceNumber:29 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(582, 174),CoordinatePoint(580, 174), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(466, 167), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(468, 167), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(467, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(467, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(471, 171), colorRule1)
            //red238,green238,blue237 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(467, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(467, 173),CoordinatePoint(469, 173), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(500, 167), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(499, 169), colorRule1)
            //red245,green245,blue245 sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(499, 175), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 11  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(499, 169),CoordinatePoint(498, 168), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(460, 168), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(457, 173), colorRule1)
            //red237,green237,blue236 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(461, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(457, 173),CoordinatePoint(457, 172), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(539, 168), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(539, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(538, 176), colorRule1)
            //red255,green255,blue254 sequenceNumber:10 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(539, 170),CoordinatePoint(537, 170), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(485, 170), colorRule1)
            //red245,green244,blue244 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(481, 171), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(484, 175), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 18  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(484, 176), colorRule1)
            //red251,green251,blue251 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(487, 179), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(490, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 18  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(484, 176),CoordinatePoint(483, 177), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $18  positionType:$18
        )
        pointList.add(PointRule(CoordinatePoint(446, 171), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(448, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 20  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(448, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 20  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(448, 180),CoordinatePoint(447, 178), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(522, 171), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(524, 176), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 21  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(524, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(530, 180), colorRule1)
            //red248,green247,blue247 sequenceNumber:14 blockNumber: 21  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(524, 177),CoordinatePoint(525, 179), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $21  positionType:$21
        )
        pointList.add(PointRule(CoordinatePoint(541, 171), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(541, 175), colorRule1)
            //red252,green252,blue252 sequenceNumber:6 blockNumber: 22  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(541, 175),CoordinatePoint(540, 174), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $22  positionType:$22
        )
        pointList.add(PointRule(CoordinatePoint(567, 174), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 24  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(568, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(567, 174), colorRule1)
            //red248,green247,blue247 sequenceNumber:4 blockNumber: 24  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(566, 179), colorRule1)
            //red252,green252,blue252 sequenceNumber:9 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(567, 174),CoordinatePoint(565, 175), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(428, 173), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(430, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(430, 173),CoordinatePoint(430, 171), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(PointRule(CoordinatePoint(544, 174), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(544, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(544, 177),CoordinatePoint(543, 175), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(PointRule(CoordinatePoint(428, 176), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(429, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 31  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(429, 179),CoordinatePoint(431, 179), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $31  positionType:$31
        )
        pointList.add(PointRule(CoordinatePoint(420, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(420, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 32  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(420, 179),CoordinatePoint(419, 178), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $32  positionType:$32
        )
        pointList.add(PointRule(CoordinatePoint(477, 180), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(479, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 40  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(479, 180),CoordinatePoint(479, 178), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $40  positionType:$40
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }


    val claimYourRewardsArea by lazy {
        ClickArea(1072,581,156,50,false)}
    val isOpenMainRewardMenuTask by lazy {
        val tag = "isOpenMainRewardMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(46, 116), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(48, 118), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(48, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(50, 117), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(53, 117), colorRule1)
            //red78,green60,blue24 sequenceNumber:14 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(46, 116),CoordinatePoint(46, 113), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(48, 120),CoordinatePoint(45, 120), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(53, 117),CoordinatePoint(53, 120), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:14sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(59, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(61, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(53, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(49, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(45, 125), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(41, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(40, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(40, 129), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(41, 133), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(43, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(35, 137), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(48, 133), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(32, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(55, 129), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(26, 139), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(56, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(55, 131), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(59, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(63, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(71, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(73, 135), colorRule1)
            //red78,green60,blue24 sequenceNumber:54 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(59, 124),CoordinatePoint(59, 121), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(35, 137),CoordinatePoint(35, 134), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:28sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(55, 137), colorRule1)
            //red78,green60,blue24 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(59, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(49, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(60, 142), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(61, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(48, 139), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(58, 143), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(61, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(51, 144), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(57, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(59, 144), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(48, 145), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 151), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(41, 151), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(40, 146), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(51, 156), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(39, 144), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 157), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(54, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(39, 141), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(39, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(62, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(39, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(62, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 164), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(33, 162), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(66, 156), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 168), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(30, 161), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(70, 157), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(51, 172), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(55, 137),CoordinatePoint(55, 135), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(39, 144),CoordinatePoint(36, 144), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:28sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=7 }
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

    val sideQuestArea by lazy {
        ClickArea(74,209,151,52,false)}
    val isSideQuestTask by lazy {
        val tag = "isSideQuest"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,216,255,222,255,220,1.05F,0.87813765F,1.05F,0.8853061F,1.0585713F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(58, 217), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(58, 219), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(58, 222), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(58, 217),CoordinatePoint(59, 216), CompareDifferenceRuleImpl.getSimple(30,20,20)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(58, 219),CoordinatePoint(57, 219), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(58, 222),CoordinatePoint(57, 222), CompareDifferenceRuleImpl.getSimple(40,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(60, 223), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(60, 225), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(56, 229), colorRule1)
            //red241,green247,blue245 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(60, 229), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(64, 231), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(60, 223),CoordinatePoint(59, 222), CompareDifferenceRuleImpl.getSimple(40,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(56, 229),CoordinatePoint(55, 229), CompareDifferenceRuleImpl.getSimple(30,20,20)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(TwoPointRule(CoordinatePoint(64, 231),CoordinatePoint(65, 230), CompareDifferenceRuleImpl.getSimple(30,20,20)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }


    val openTheActivityHallArea by lazy {
        ClickArea(940,21,44,56,false)}
    val isOpenTheActivityHallTask by lazy {
        val tag = "OpenTheActivityHall"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0545259F,0.9F,1.0544492F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(871, 118), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(872, 123), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(872, 127), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(872, 128), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(873, 130), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(872, 127),CoordinatePoint(871, 128), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(889, 118), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(890, 123), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(889, 128), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(888, 128), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(889, 128), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(889, 132), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(888, 128),CoordinatePoint(888, 126), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(851, 119), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(853, 122), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(850, 128), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(856, 126), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(850, 128),CoordinatePoint(851, 128), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(936, 119), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(934, 121), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(934, 125), colorRule1)
            //red253,green253,blue253 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(939, 124), colorRule1)
            //red244,green244,blue244 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(932, 131), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(934, 125),CoordinatePoint(933, 124), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(956, 119), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(956, 121), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(953, 124), colorRule1)
            //red235,green234,blue234 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(949, 125), colorRule1)
            //red242,green241,blue241 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(951, 129), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(959, 128), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(947, 129), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(949, 125),CoordinatePoint(949, 124), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(971, 119), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(971, 125), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(971, 125), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(970, 129), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(976, 132), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(978, 132), colorRule1)
            //red243,green243,blue243 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(970, 129),CoordinatePoint(969, 128), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(914, 120), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(916, 120), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(915, 125), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(915, 126), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(919, 124), colorRule1)
            //red238,green238,blue237 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(915, 132), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(915, 126),CoordinatePoint(917, 126), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(994, 120), colorRule1)
            //red245,green244,blue244 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(996, 120), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(996, 120),CoordinatePoint(996, 118), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(908, 121), colorRule1)
            //red233,green232,blue232 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(905, 126), colorRule1)
            //red237,green237,blue236 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(909, 130), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(905, 126),CoordinatePoint(905, 125), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(988, 121), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(988, 123), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(988, 127), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(987, 130), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(988, 127),CoordinatePoint(986, 127), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(894, 124), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(896, 133), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(896, 133), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 14  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(896, 133),CoordinatePoint(895, 131), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(995, 124), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(997, 124), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(995, 126), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(994, 133), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 17  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(995, 126),CoordinatePoint(993, 126), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(876, 126), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(878, 126), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(878, 126),CoordinatePoint(878, 124), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(937, 128), colorRule1)
            //red237,green237,blue236 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(937, 130), colorRule1)
            //red240,green240,blue239 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(937, 130),CoordinatePoint(936, 130), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(876, 129), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(877, 132), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(877, 132),CoordinatePoint(879, 132), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(PointRule(CoordinatePoint(868, 130), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(868, 132), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(868, 132),CoordinatePoint(867, 131), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=8 }
    }

    val tiaozhanClick2Area by lazy {
        ClickArea(53,505,128,41,false)}
    val tiaozhanClick1Area by lazy {
        ClickArea(161,637,65,78,false)}
    val isTheActivityHallMenuTask by lazy {
        val tag = "TheActivityHallMenu"
        val colorRule1=ColorRuleRatioImpl.getSimple(78,54,60,42,24,17,1.3874999F,1.154717F,3.5F,2.8636365F,2.7078946F, 2.1857142F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(20, 27), colorRule1)
            //red75,green58,blue23 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(21, 28), colorRule1)
            //red75,green57,blue23 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(23, 29), colorRule1)
            //red74,green57,blue23 sequenceNumber:4 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(24, 29), colorRule1)
            //red74,green57,blue23 sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(24, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(27, 30), colorRule1)
            //red74,green57,blue23 sequenceNumber:14 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(24, 29),CoordinatePoint(24, 24), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(34, 28), colorRule1)
            //red75,green57,blue23 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(37, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:4 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(38, 34), colorRule1)
            //red73,green56,blue22 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 32), colorRule1)
            //red74,green56,blue23 sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(38, 36), colorRule1)
            //red72,green56,blue22 sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(44, 31), colorRule1)
            //red74,green57,blue23 sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 34), colorRule1)
            //red73,green56,blue22 sequenceNumber:16 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(49, 31), colorRule1)
            //red74,green57,blue23 sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(49, 33), colorRule1)
            //red73,green56,blue22 sequenceNumber:20 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(46, 41), colorRule1)
            //red71,green54,blue22 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(41, 43), colorRule1)
            //red70,green54,blue22 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(52, 31), colorRule1)
            //red74,green57,blue23 sequenceNumber:20 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(47, 46), colorRule1)
            //red69,green53,blue21 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(36, 49), colorRule1)
            //red68,green53,blue21 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(37, 50), colorRule1)
            //red68,green52,blue21 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(52, 46), colorRule1)
            //red69,green53,blue21 sequenceNumber:28 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(33, 52), colorRule1)
            //red67,green52,blue21 sequenceNumber:28 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(56, 45), colorRule1)
            //red70,green54,blue21 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(59, 47), colorRule1)
            //red69,green53,blue21 sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(31, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:36 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(60, 48), colorRule1)
            //red69,green53,blue21 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(34, 53), colorRule1)
            //red67,green52,blue21 sequenceNumber:44 blockNumber: 1  positionType:4
        )
        pointList.add(PointRule(CoordinatePoint(35, 62), colorRule1)
            //red64,green49,blue20 sequenceNumber:44 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 50), colorRule1)
            //red68,green52,blue21 sequenceNumber:48 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(35, 63), colorRule1)
            //red64,green49,blue20 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 61), colorRule1)
            //red65,green50,blue20 sequenceNumber:48 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(43, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:52 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(36, 67), colorRule1)
            //red63,green48,blue19 sequenceNumber:52 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(45, 49), colorRule1)
            //red68,green53,blue21 sequenceNumber:56 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(37, 71), colorRule1)
            //red61,green47,blue19 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 53), colorRule1)
            //red67,green52,blue21 sequenceNumber:60 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(37, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:60 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:68 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(48, 59), colorRule1)
            //red65,green50,blue20 sequenceNumber:68 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(45, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:68 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(54, 61), colorRule1)
            //red65,green50,blue20 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(49, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(56, 63), colorRule1)
            //red64,green49,blue20 sequenceNumber:76 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(53, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(55, 66), colorRule1)
            //red63,green49,blue19 sequenceNumber:85 blockNumber: 1  positionType:3
        )
        pointList.add(TwoPointRule(CoordinatePoint(60, 48),CoordinatePoint(60, 44), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:40sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(13, 40), colorRule1)
            //red71,green55,blue22 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(15, 45), colorRule1)
            //red70,green54,blue21 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(15, 46), colorRule1)
            //red69,green53,blue21 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(17, 48), colorRule1)
            //red69,green53,blue21 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(17, 50), colorRule1)
            //red68,green52,blue21 sequenceNumber:12 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(18, 50), colorRule1)
            //red68,green52,blue21 sequenceNumber:12 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(16, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(15, 57), colorRule1)
            //red66,green51,blue20 sequenceNumber:19 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(17, 50),CoordinatePoint(13, 49), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(24, 51), colorRule1)
            //red68,green52,blue21 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(23, 54), colorRule1)
            //red67,green51,blue21 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(21, 59), colorRule1)
            //red65,green50,blue20 sequenceNumber:8 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(21, 59), colorRule1)
            //red65,green50,blue20 sequenceNumber:8 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(18, 65), colorRule1)
            //red63,green49,blue19 sequenceNumber:12 blockNumber: 3  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(20, 61), colorRule1)
            //red65,green50,blue20 sequenceNumber:12 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(15, 67), colorRule1)
            //red63,green48,blue19 sequenceNumber:16 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(19, 65), colorRule1)
            //red63,green49,blue19 sequenceNumber:16 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(13, 71), colorRule1)
            //red61,green47,blue19 sequenceNumber:20 blockNumber: 3  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(17, 69), colorRule1)
            //red62,green48,blue19 sequenceNumber:20 blockNumber: 3  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(13, 72), colorRule1)
            //red61,green47,blue19 sequenceNumber:24 blockNumber: 3  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(15, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:24 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(13, 73), colorRule1)
            //red61,green47,blue19 sequenceNumber:27 blockNumber: 3  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(15, 67),CoordinatePoint(15, 63), CompareDifferenceRuleImpl.getSimple(-40,-40,-30)) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=8 }
    }

    val qianKunMartialArtsArea by lazy {
        ClickArea(995,579,154,50,false)}
    val isQianKunMartialArtsTask by lazy {
        val tag = "isQianKunMartialArts"
        val colorRule1=ColorRuleRatioImpl.getSimple(81,70,63,54,25,21,1.365F,1.17F,3.4125F,2.925F,2.625F, 2.25F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(42, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(42, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(42, 120), colorRule1)
            //red78,green60,blue24 sequenceNumber:4 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(43, 122), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(42, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(38, 130), colorRule1)
            //red78,green60,blue24 sequenceNumber:12 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(46, 127), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(33, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(42, 128), colorRule1)
            //red78,green60,blue24 sequenceNumber:20 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(33, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 132), colorRule1)
            //red78,green60,blue24 sequenceNumber:28 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(39, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(35, 139), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(39, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(33, 145), colorRule1)
            //red78,green60,blue24 sequenceNumber:36 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(33, 149), colorRule1)
            //red78,green60,blue24 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(34, 151), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(34, 151), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(40, 150), colorRule1)
            //red78,green60,blue24 sequenceNumber:44 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 147), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(44, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(41, 157), colorRule1)
            //red78,green60,blue24 sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(46, 142), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(39, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:52 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(48, 140), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(34, 161), colorRule1)
            //red78,green60,blue24 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(52, 137), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(40, 163), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(29, 163), colorRule1)
            //red78,green60,blue24 sequenceNumber:60 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(54, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(28, 163), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(39, 167), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(25, 166), colorRule1)
            //red78,green60,blue24 sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(56, 129), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(25, 165), colorRule1)
            //red78,green60,blue24 sequenceNumber:68 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(57, 126), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(41, 159), colorRule1)
            //red78,green60,blue24 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(57, 122), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(45, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:76 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(59, 123), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(47, 153), colorRule1)
            //red78,green60,blue24 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(59, 124), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(52, 150), colorRule1)
            //red78,green60,blue24 sequenceNumber:84 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(57, 128), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(54, 149), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(55, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:88 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(55, 146), colorRule1)
            //red78,green60,blue24 sequenceNumber:92 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(62, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(60, 138), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(61, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(58, 155), colorRule1)
            //red78,green60,blue24 sequenceNumber:96 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(66, 134), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(62, 135), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(56, 162), colorRule1)
            //red78,green60,blue24 sequenceNumber:100 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(56, 163), colorRule1)
            //red78,green60,blue24 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(60, 167), colorRule1)
            //red78,green60,blue24 sequenceNumber:108 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(63, 166), colorRule1)
            //red78,green60,blue24 sequenceNumber:112 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(71, 166), colorRule1)
            //red78,green60,blue24 sequenceNumber:116 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(72, 165), colorRule1)
            //red78,green60,blue24 sequenceNumber:120 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(73, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(71, 152), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(73, 160), colorRule1)
            //red78,green60,blue24 sequenceNumber:128 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(70, 148), colorRule1)
            //red78,green60,blue24 sequenceNumber:134 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(42, 120),CoordinatePoint(42, 116), CompareDifferenceRuleImpl.getSimple(-40,-40,-40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(41, 157),CoordinatePoint(38, 156), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(52, 150),CoordinatePoint(49, 149), CompareDifferenceRuleImpl.getSimple(-30,-40,-40)) // sequenceNumber:84sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=7 }
    }

    //乾坤论物理
    val isOpenQianKunFightTask by lazy {
        val tag = "isOpenQianKunFight"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,196,236,172,110,85,1.1941177F,1.0157143F,2.55F,2.0652633F,2.25F, 1.8189473F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(82, 155), colorRule1)
            //red255,green225,blue105 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(82, 158), colorRule1)
            //red255,green225,blue105 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(75, 160), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(82, 161), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(86, 159), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(75, 160), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(82, 164), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(82, 169), colorRule1)
            //red255,green225,blue105 sequenceNumber:17 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(86, 159),CoordinatePoint(86, 156), CompareDifferenceRuleImpl.getSimple(40,30,15)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(119, 154), colorRule1)
            //red248,green219,blue103 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(121, 160), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(121, 160), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(113, 161), colorRule1)
            //red218,green192,blue95 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(118, 163), colorRule1)
            //red254,green224,blue105 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(124, 167), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(112, 168), colorRule1)
            //red255,green225,blue105 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(113, 161),CoordinatePoint(113, 160), CompareDifferenceRuleImpl.getSimple(30,30,10)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(56, 154), colorRule1)
            //red232,green204,blue100 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(56, 157), colorRule1)
            //red255,green225,blue105 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(54, 162), colorRule1)
            //red245,green216,blue103 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(61, 159), colorRule1)
            //red251,green222,blue104 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(56, 166), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(56, 166), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(62, 155), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(51, 167), colorRule1)
            //red238,green210,blue101 sequenceNumber:15 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(61, 167),CoordinatePoint(59, 167), CompareDifferenceRuleImpl.getSimple(40,30,15)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(100, 154), colorRule1)
            //red221,green195,blue96 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(100, 157), colorRule1)
            //red253,green224,blue105 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(101, 157), colorRule1)
            //red255,green225,blue105 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(98, 161), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(106, 161), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(100, 165), colorRule1)
            //red255,green225,blue105 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(106, 167), colorRule1)
            //red247,green218,blue103 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(106, 166), colorRule1)
            //red233,green205,blue99 sequenceNumber:19 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(106, 161),CoordinatePoint(106, 159), CompareDifferenceRuleImpl.getSimple(40,30,15)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(94, 162), colorRule1)
            //red255,green225,blue105 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(94, 163), colorRule1)
            //red253,green224,blue105 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(94, 168), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(94, 163),CoordinatePoint(93, 163), CompareDifferenceRuleImpl.getSimple(40,30,15)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(62, 163), colorRule1)
            //red237,green210,blue101 sequenceNumber:0 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(61, 167), colorRule1)
            //red255,green225,blue105 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(67, 169), colorRule1)
            //red255,green225,blue105 sequenceNumber:13 blockNumber: 8  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(61, 167),CoordinatePoint(59, 167), CompareDifferenceRuleImpl.getSimple(40,30,15)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }


    val qianKunFightLeveArea by lazy {
        ClickArea(421,555,158,50,false)}
    val qianKunFightNextArea by lazy {
        ClickArea(702,555,156,50,false)}
    //乾坤论物理
    val isOpenQianKunFightNextTask by lazy {
        val tag = "isOpenQianKunFightNext"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,216,255,197,229,169,1.1554794F,0.9071146F,1.3460107F,1.0479451F,1.2258883F, 1.039726F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(769, 569), colorRule1)
            //red252,green239,blue206 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(771, 573), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(775, 576), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(771, 573),CoordinatePoint(773, 574), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(748, 571), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(746, 575), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(748, 578), colorRule1)
            //red255,green253,blue218 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(751, 572), colorRule1)
            //red251,green240,blue206 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(747, 580), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(749, 580), colorRule1)
            //red253,green247,blue213 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 587), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(748, 586), colorRule1)
            //red251,green245,blue211 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(740, 576), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(751, 586), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 577), colorRule1)
            //red247,green232,blue199 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(738, 572), colorRule1)
            //red255,green253,blue219 sequenceNumber:30 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(742, 587),CoordinatePoint(739, 587), CompareDifferenceRuleImpl.getSimple(20,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(763, 571), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(762, 572), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(763, 572), colorRule1)
            //red252,green240,blue207 sequenceNumber:4 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(761, 580), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(761, 580), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(763, 572),CoordinatePoint(765, 572), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:4sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(786, 570), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(787, 575), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(786, 576), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(786, 581), colorRule1)
            //red255,green253,blue219 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(786, 586), colorRule1)
            //red255,green253,blue219 sequenceNumber:18 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(786, 576),CoordinatePoint(785, 575), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(815, 570), colorRule1)
            //red252,green241,blue208 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(816, 572), colorRule1)
            //red253,green247,blue213 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(818, 577), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(819, 581), colorRule1)
            //red254,green252,blue217 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(813, 584), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(822, 587), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(813, 582), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(812, 584), colorRule1)
            //red245,green230,blue197 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(825, 585), colorRule1)
            //red246,green233,blue201 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(824, 588), colorRule1)
            //red255,green253,blue219 sequenceNumber:20 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(810, 576), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(810, 580), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(810, 573), colorRule1)
            //red255,green253,blue219 sequenceNumber:30 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(813, 582),CoordinatePoint(813, 579), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:20sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(795, 571), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(795, 573), colorRule1)
            //red255,green253,blue218 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(795, 577), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(796, 585), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(797, 580), colorRule1)
            //red252,green247,blue213 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(796, 585), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(801, 586), colorRule1)
            //red255,green253,blue219 sequenceNumber:19 blockNumber: 5  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(796, 585),CoordinatePoint(794, 585), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(791, 573), colorRule1)
            //red252,green245,blue211 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(792, 579), colorRule1)
            //red252,green246,blue212 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(791, 584), colorRule1)
            //red255,green253,blue218 sequenceNumber:13 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(792, 579),CoordinatePoint(790, 580), CompareDifferenceRuleImpl.getSimple(15,40,30)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(770, 578), colorRule1)
            //red253,green248,blue214 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(770, 583), colorRule1)
            //red255,green253,blue219 sequenceNumber:4 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(768, 582), colorRule1)
            //red246,green232,blue199 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(773, 582), colorRule1)
            //red241,green219,blue188 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(764, 583), colorRule1)
            //red251,green244,blue210 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(766, 588), colorRule1)
            //red243,green228,blue196 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(758, 585), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(773, 582),CoordinatePoint(773, 581), CompareDifferenceRuleImpl.getSimple(15,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(739, 584), colorRule1)
            //red250,green241,blue208 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 585), colorRule1)
            //red251,green244,blue211 sequenceNumber:5 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 585),CoordinatePoint(736, 584), CompareDifferenceRuleImpl.getSimple(15,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $10  positionType:$10
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=7 }
    }


    val isJiXuMianOpenTask by lazy {
        val tag = "isJiXuMianOpen"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,209,255,208,255,208,1.0545259F,0.9F,1.0545259F,0.9F,1.0543933F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(337, 169), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(338, 174), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(338, 178), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(338, 179), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(339, 181), colorRule1)
            //red246,green246,blue245 sequenceNumber:15 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(338, 178),CoordinatePoint(337, 179), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(417, 169), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(416, 171), colorRule1)
            //red243,green243,blue242 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(420, 171), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(418, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(422, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(418, 179), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(416, 182), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(418, 179),CoordinatePoint(416, 178), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(317, 170), colorRule1)
            //red246,green245,blue245 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(319, 173), colorRule1)
            //red249,green249,blue248 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(316, 179), colorRule1)
            //red241,green241,blue240 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(322, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(316, 179),CoordinatePoint(317, 179), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(359, 170), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(360, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(360, 176), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(360, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(366, 182), colorRule1)
            //red255,green255,blue255 sequenceNumber:19 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(366, 182), colorRule1)
            //red255,green255,blue255 sequenceNumber:19 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(360, 180),CoordinatePoint(362, 180), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(380, 170), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(381, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(381, 176), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(380, 183), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(373, 177), colorRule1)
            //red251,green251,blue251 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(382, 184), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(374, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(375, 173), colorRule1)
            //red244,green244,blue243 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(374, 171), colorRule1)
            //red248,green248,blue248 sequenceNumber:24 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(373, 177),CoordinatePoint(373, 179), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(395, 171), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(394, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(392, 176), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(393, 180), colorRule1)
            //red248,green247,blue247 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(393, 183), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(392, 176),CoordinatePoint(391, 175), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(441, 170), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(440, 172), colorRule1)
            //red251,green251,blue251 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(438, 176), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(438, 180), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(443, 178), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(442, 184), colorRule1)
            //red253,green253,blue253 sequenceNumber:20 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(445, 184), colorRule1)
            //red249,green249,blue249 sequenceNumber:23 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(438, 180),CoordinatePoint(436, 180), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(402, 171), colorRule1)
            //red250,green250,blue249 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(399, 173), colorRule1)
            //red241,green241,blue240 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(400, 178), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 8  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(400, 181), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(403, 183), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(400, 178),CoordinatePoint(398, 177), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(456, 171), colorRule1)
            //red243,green243,blue242 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(456, 173), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(454, 177), colorRule1)
            //red250,green250,blue249 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(452, 182), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(451, 178), colorRule1)
            //red244,green244,blue243 sequenceNumber:15 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(454, 177),CoordinatePoint(453, 177), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(355, 172), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(355, 174), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(356, 178), colorRule1)
            //red238,green237,blue237 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(353, 181), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(352, 177), colorRule1)
            //red255,green255,blue254 sequenceNumber:15 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(356, 178),CoordinatePoint(357, 178), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(462, 173), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(465, 173), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 13  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(465, 173),CoordinatePoint(465, 171), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(PointRule(CoordinatePoint(342, 177), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(344, 177), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 19  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(344, 177),CoordinatePoint(344, 175), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $19  positionType:$19
        )
        pointList.add(PointRule(CoordinatePoint(433, 179), colorRule1)
            //red240,green240,blue239 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(434, 180), colorRule1)
            //red233,green232,blue232 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(434, 180),CoordinatePoint(435, 179), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(459, 179), colorRule1)
            //red237,green236,blue236 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(461, 184), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 25  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(461, 184),CoordinatePoint(460, 183), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $25  positionType:$25
        )
        pointList.add(PointRule(CoordinatePoint(342, 180), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(343, 183), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(343, 183),CoordinatePoint(345, 183), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:5sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(334, 181), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(334, 183), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 27  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(334, 183),CoordinatePoint(333, 182), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $27  positionType:$27
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=9 }
    }

    val fishingOnWaterArea by lazy {
        ClickArea(1086,528,104,104,true)}
    val isFishingOnWaterTask by lazy {
        val tag = "isOpen"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,216,255,216,255,216,1.05F,0.9F,1.0543209F,0.9F,1.0543209F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(532, 76), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(528, 80), colorRule1)
            //red250,green250,blue250 sequenceNumber:6 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(528, 80),CoordinatePoint(528, 78), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:6sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(585, 76), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 82), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 82), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 86), colorRule1)
            //red250,green250,blue249 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(574, 85),CoordinatePoint(579, 84), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(PointRule(CoordinatePoint(611, 76), colorRule1)
            //red246,green246,blue246 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(612, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(612, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(609, 86), colorRule1)
            //red247,green247,blue247 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(612, 86), colorRule1)
            //red245,green245,blue245 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(612, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(615, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:23 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(609, 86),CoordinatePoint(610, 89), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(485, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 79), colorRule1)
            //red250,green250,blue250 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 83), colorRule1)
            //red249,green249,blue249 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(506, 77), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(504, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(504, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(525, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(525, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(524, 82), colorRule1)
            //red246,green246,blue245 sequenceNumber:7 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(525, 79),CoordinatePoint(523, 79), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(565, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 79), colorRule1)
            //red250,green250,blue250 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 83), colorRule1)
            //red249,green249,blue248 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 83), colorRule1)
            //red250,green250,blue250 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(634, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(633, 79), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 83), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(634, 82), colorRule1)
            //red245,green245,blue245 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(632, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(632, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(671, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(671, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 78), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(666, 80), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(666, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 88), colorRule1)
            //red248,green248,blue248 sequenceNumber:12 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(551, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(550, 81), colorRule1)
            //red246,green246,blue245 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 17  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 86),CoordinatePoint(547, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $33  positionType:$33
        )
        pointList.add(PointRule(CoordinatePoint(594, 80), colorRule1)
            //red255,green255,blue254 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(595, 82), colorRule1)
            //red242,green242,blue242 sequenceNumber:4 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(595, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 23  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(595, 82),CoordinatePoint(593, 87), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(PointRule(CoordinatePoint(512, 81), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(508, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(511, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 25  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(511, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(515, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 25  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(534, 81), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(536, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(535, 87), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(536, 83),CoordinatePoint(536, 79), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(590, 81), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(591, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(591, 88),CoordinatePoint(593, 88), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:10sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(PointRule(CoordinatePoint(554, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 29  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(553, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 29  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(553, 86),CoordinatePoint(556, 82), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:6sequenceNumber blockNumber: $29  positionType:$29
        )
        pointList.add(PointRule(CoordinatePoint(491, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(491, 85), colorRule1)
            //red250,green250,blue250 sequenceNumber:4 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(492, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(496, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 83), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(525, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(525, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 32  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(525, 85),CoordinatePoint(522, 80), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $32  positionType:$32
        )
        pointList.add(PointRule(CoordinatePoint(544, 83), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 33  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(545, 86), colorRule1)
            //red242,green242,blue242 sequenceNumber:5 blockNumber: 33  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 86),CoordinatePoint(547, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $33  positionType:$33
        )
        pointList.add(PointRule(CoordinatePoint(571, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(571, 85), colorRule1)
            //red250,green250,blue250 sequenceNumber:4 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(574, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(572, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(576, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 34  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(574, 85),CoordinatePoint(579, 84), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(PointRule(CoordinatePoint(655, 83), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(649, 84), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(648, 84), colorRule1)
            //red244,green244,blue243 sequenceNumber:7 blockNumber: 36  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(671, 85), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 39  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(672, 87), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 39  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(672, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:7 blockNumber: 39  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(504, 88), colorRule1)
            //red240,green240,blue240 sequenceNumber:0 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(504, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(545, 91), colorRule1)
            //red242,green242,blue242 sequenceNumber:0 blockNumber: 50  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 50  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=5 }
    }


    val isFastClickFishingTask by lazy {
        val tag = "isFastClickFishingTask"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,207,255,207,255,207,1.05F,0.9F,1.0545454F,0.9F,1.0545454F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(490, 76), colorRule1)
            //red251,green251,blue251 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(491, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(491, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(490, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(491, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(496, 90), colorRule1)
            //red238,green238,blue238 sequenceNumber:17 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(490, 86),CoordinatePoint(489, 84), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(510, 76), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(511, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(511, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(513, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(511, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(511, 90), colorRule1)
            //red247,green247,blue247 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(504, 89), colorRule1)
            //red236,green236,blue236 sequenceNumber:23 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(515, 91), colorRule1)
            //red254,green254,blue254 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(504, 89), colorRule1)
            //red236,green236,blue236 sequenceNumber:23 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(511, 86),CoordinatePoint(508, 86), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(548, 76), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(549, 85), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(545, 85), colorRule1)
            //red231,green231,blue231 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 86), colorRule1)
            //red243,green243,blue242 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(550, 88), colorRule1)
            //red246,green246,blue246 sequenceNumber:15 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 85),CoordinatePoint(544, 84), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(572, 76), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(572, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(571, 81), colorRule1)
            //red255,green255,blue254 sequenceNumber:7 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(572, 78),CoordinatePoint(570, 78), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(625, 76), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(623, 82), colorRule1)
            //red237,green237,blue237 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 82), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(631, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(630, 81), colorRule1)
            //red253,green253,blue253 sequenceNumber:24 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(635, 82), colorRule1)
            //red242,green242,blue241 sequenceNumber:32 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(635, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:36 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(636, 89), colorRule1)
            //red238,green238,blue238 sequenceNumber:39 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(631, 88),CoordinatePoint(633, 88), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(484, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(485, 82), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(484, 83), colorRule1)
            //red232,green232,blue232 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(484, 87), colorRule1)
            //red243,green243,blue243 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(484, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(484, 83),CoordinatePoint(483, 81), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(528, 77), colorRule1)
            //red245,green245,blue245 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(530, 80), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(526, 86), colorRule1)
            //red249,green249,blue249 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(533, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 6  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(526, 86),CoordinatePoint(525, 86), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(565, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(563, 82), colorRule1)
            //red236,green236,blue236 sequenceNumber:7 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(565, 79),CoordinatePoint(563, 79), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(588, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(587, 79), colorRule1)
            //red241,green241,blue241 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(590, 79), colorRule1)
            //red236,green236,blue236 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(587, 83), colorRule1)
            //red246,green246,blue246 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(594, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 8  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(587, 83),CoordinatePoint(587, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(605, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(605, 82), colorRule1)
            //red255,green255,blue254 sequenceNumber:4 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(605, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 9  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(609, 81), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(603, 86), colorRule1)
            //red243,green243,blue243 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(603, 87), colorRule1)
            //red237,green237,blue236 sequenceNumber:12 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(605, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 9  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(609, 81),CoordinatePoint(609, 79), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(PointRule(CoordinatePoint(647, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(647, 79), colorRule1)
            //red233,green233,blue233 sequenceNumber:4 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(647, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(647, 79),CoordinatePoint(646, 79), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(668, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(667, 79), colorRule1)
            //red241,green241,blue241 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(670, 79), colorRule1)
            //red237,green237,blue236 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(667, 83), colorRule1)
            //red246,green246,blue246 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(665, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(674, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 12  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(667, 83),CoordinatePoint(667, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(690, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(697, 87), colorRule1)
            //red250,green250,blue250 sequenceNumber:18 blockNumber: 13  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(690, 84),CoordinatePoint(688, 84), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $13  positionType:$13
        )
        pointList.add(PointRule(CoordinatePoint(685, 79), colorRule1)
            //red238,green238,blue238 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(685, 88),CoordinatePoint(687, 88), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(493, 80), colorRule1)
            //red234,green234,blue234 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(494, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(494, 82),CoordinatePoint(496, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $17  positionType:$17
        )
        pointList.add(PointRule(CoordinatePoint(574, 81), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(575, 83), colorRule1)
            //red231,green231,blue231 sequenceNumber:4 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(575, 87), colorRule1)
            //red252,green252,blue252 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(575, 83),CoordinatePoint(574, 83), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $20  positionType:$20
        )
        pointList.add(PointRule(CoordinatePoint(566, 83), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 23  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(565, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 23  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(565, 85),CoordinatePoint(564, 85), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $23  positionType:$23
        )
        pointList.add(PointRule(CoordinatePoint(611, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(611, 85), colorRule1)
            //red250,green250,blue250 sequenceNumber:4 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(613, 85), colorRule1)
            //red233,green233,blue232 sequenceNumber:8 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(612, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(616, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 24  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(613, 85),CoordinatePoint(613, 83), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $24  positionType:$24
        )
        pointList.add(PointRule(CoordinatePoint(553, 84), colorRule1)
            //red242,green242,blue241 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(555, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(555, 84),CoordinatePoint(555, 86), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(650, 84), colorRule1)
            //red242,green242,blue242 sequenceNumber:0 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(652, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(655, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 27  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(653, 92), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 27  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(655, 86),CoordinatePoint(653, 86), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $27  positionType:$27
        )
        pointList.add(PointRule(CoordinatePoint(553, 87), colorRule1)
            //red246,green246,blue246 sequenceNumber:0 blockNumber: 31  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(554, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 31  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(554, 90),CoordinatePoint(556, 90), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $31  positionType:$31
        )
        pointList.add(PointRule(CoordinatePoint(545, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(545, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 34  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(545, 90),CoordinatePoint(544, 89), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(PointRule(CoordinatePoint(642, 88), colorRule1)
            //red239,green239,blue239 sequenceNumber:0 blockNumber: 35  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(645, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 35  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(645, 88),CoordinatePoint(645, 86), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $35  positionType:$35
        )
        pointList.add(PointRule(CoordinatePoint(594, 90), colorRule1)
            //red234,green234,blue234 sequenceNumber:0 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(588, 91), colorRule1)
            //red255,green255,blue254 sequenceNumber:4 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 91), colorRule1)
            //red232,green232,blue231 sequenceNumber:11 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 91), colorRule1)
            //red232,green232,blue231 sequenceNumber:11 blockNumber: 40  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(584, 91),CoordinatePoint(583, 90), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $40  positionType:$40
        )
        pointList.add(PointRule(CoordinatePoint(674, 90), colorRule1)
            //red234,green234,blue234 sequenceNumber:0 blockNumber: 41  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 41  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 91), colorRule1)
            //red232,green232,blue232 sequenceNumber:11 blockNumber: 41  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 91), colorRule1)
            //red232,green232,blue232 sequenceNumber:11 blockNumber: 41  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(664, 91),CoordinatePoint(664, 90), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $41  positionType:$41
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=8 }
    }

    val itemsInDemandArea by lazy {
        ClickArea(510,163,110,46,false)}
    val isItemsInDemandTask by lazy {
        val tag = "isItemsInDemand"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,202,252,136,189,105,1.5542762F,0.93375003F,2.0192306F,1.245F,1.4101745F, 1.1617022F)
        val pr  = PointRule(CoordinatePoint(209, 146), colorRule1)
        //red244,green202,blue154 sequenceNumber:4 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(206,137,7,477)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(209, 146), colorRule1)
            //red244,green202,blue154 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(209, 148), colorRule1)
            //red251,green238,blue179 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(214, 148), colorRule1)
            //red248,green231,blue174 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(203, 150), colorRule1)
            //red241,green182,blue141 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(208, 154), colorRule1)
            //red251,green238,blue178 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(202, 151), colorRule1)
            //red249,green240,blue180 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(207, 156), colorRule1)
            //red249,green240,blue180 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(207, 156), colorRule1)
            //red249,green240,blue180 sequenceNumber:12 blockNumber: 0  positionType:1
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
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=3 }
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
            nErrorTolerance=4 }
    }





   val locationAccordinglyAreaList= listOf( ClickArea(650,162,23,16,true),ClickArea(643,303,16,19,true),ClickArea(572,424,16,18,true), ClickArea(737,448,16,19,true))

    val isClickLocationAccordinglyTask by lazy {
        val tag = "isClickLocationAccordingly"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,194,255,193,255,190,1.0597675F,0.9F,1.0698113F,0.9F,1.0648586F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(571, 77), colorRule1)
            //red233,green232,blue231 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(571, 81), colorRule1)
            //red248,green248,blue248 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(569, 83), colorRule1)
            //red243,green243,blue242 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(572, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(572, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(572, 92), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(565, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(576, 92), colorRule1)
            //red237,green236,blue235 sequenceNumber:20 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 85), colorRule1)
            //red239,green238,blue238 sequenceNumber:27 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(563, 90), colorRule1)
            //red218,green217,blue215 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 85), colorRule1)
            //red239,green238,blue238 sequenceNumber:27 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(572, 92),CoordinatePoint(570, 90), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(584, 77), colorRule1)
            //red248,green248,blue247 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(585, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(584, 83), colorRule1)
            //red216,green215,blue212 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 91), colorRule1)
            //red251,green251,blue251 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(592, 84), colorRule1)
            //red233,green232,blue231 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(589, 88), colorRule1)
            //red237,green236,blue235 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(592, 80), colorRule1)
            //red226,green225,blue223 sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(593, 87), colorRule1)
            //red254,green254,blue254 sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(595, 92), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(589, 81), colorRule1)
            //red217,green215,blue213 sequenceNumber:25 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(592, 84),CoordinatePoint(589, 84), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(525, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(525, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(523, 84), colorRule1)
            //red255,green255,blue254 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(524, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(530, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(529, 92), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(532, 81), colorRule1)
            //red224,green223,blue221 sequenceNumber:20 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(534, 84), colorRule1)
            //red237,green236,blue235 sequenceNumber:20 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(535, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(536, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:23 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(529, 92),CoordinatePoint(527, 90), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(549, 78), colorRule1)
            //red216,green215,blue212 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 80), colorRule1)
            //red227,green226,blue224 sequenceNumber:4 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(548, 84), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(553, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(556, 92), colorRule1)
            //red240,green240,blue239 sequenceNumber:17 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(549, 88),CoordinatePoint(547, 88), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(608, 78), colorRule1)
            //red246,green246,blue245 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 81), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(607, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(612, 85), colorRule1)
            //red246,green245,blue245 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(607, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 6  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(607, 88),CoordinatePoint(608, 87), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(625, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(623, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(624, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(625, 91), colorRule1)
            //red245,green245,blue244 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(627, 91), colorRule1)
            //red241,green241,blue240 sequenceNumber:16 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(632, 88), colorRule1)
            //red221,green219,blue217 sequenceNumber:20 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(631, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:24 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(635, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(634, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:30 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(627, 91),CoordinatePoint(627, 90), CompareDifferenceRuleImpl.getSimple(30,30,40)) // sequenceNumber:16sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(545, 86), colorRule1)
            //red243,green242,blue242 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(541, 89), colorRule1)
            //red237,green236,blue235 sequenceNumber:5 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(541, 89),CoordinatePoint(541, 88), CompareDifferenceRuleImpl.getSimple(30,30,40)) // sequenceNumber:5sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(616, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(616, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(616, 91),CoordinatePoint(616, 89), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $17  positionType:$17
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=7 }
    }

    val catchFlyingBeads12Area by lazy {
        ClickArea(752,375,65,74,true)}
    val catchFlyingBeads11Area by lazy {
        ClickArea(396,244,96,70,true)}
    val isCatchFlyingBeads1Task by lazy {
        val tag = "isCatchFlyingBeads1"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,205,255,204,255,204,1.0546255F,0.9F,1.0546255F,0.9F,1.0545454F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(519, 76), colorRule1)
            //red247,green247,blue247 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(520, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(520, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(518, 86), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(518, 86), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(518, 90), colorRule1)
            //red250,green250,blue250 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 76), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(584, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(582, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(582, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 90), colorRule1)
            //red252,green252,blue252 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(627, 76), colorRule1)
            //red252,green252,blue252 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(625, 80), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(627, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(622, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(629, 85), colorRule1)
            //red248,green248,blue248 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(627, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 76), colorRule1)
            //red228,green227,blue227 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 78), colorRule1)
            //red238,green237,blue237 sequenceNumber:4 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(643, 79), colorRule1)
            //red229,green228,blue228 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(644, 86), colorRule1)
            //red239,green239,blue238 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(647, 86), colorRule1)
            //red244,green244,blue244 sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(541, 77), colorRule1)
            //red249,green249,blue248 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 87), colorRule1)
            //red235,green234,blue234 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(539, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:15 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(607, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(606, 80), colorRule1)
            //red241,green241,blue240 sequenceNumber:5 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(621, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(620, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(619, 89), colorRule1)
            //red254,green254,blue254 sequenceNumber:14 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 77), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 9  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(748, 77), colorRule1)
            //red237,green237,blue237 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(749, 79), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(561, 79), colorRule1)
            //red235,green235,blue235 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 84), colorRule1)
            //red249,green249,blue248 sequenceNumber:8 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(564, 84), colorRule1)
            //red249,green249,blue248 sequenceNumber:8 blockNumber: 12  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(564, 88), colorRule1)
            //red247,green247,blue247 sequenceNumber:12 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(571, 89), colorRule1)
            //red232,green231,blue231 sequenceNumber:17 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(678, 78), colorRule1)
            //red239,green239,blue239 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(680, 78), colorRule1)
            //red239,green239,blue238 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(684, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 14  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(680, 84), colorRule1)
            //red235,green234,blue234 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(685, 84), colorRule1)
            //red253,green253,blue253 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(690, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(711, 78), colorRule1)
            //red242,green242,blue242 sequenceNumber:0 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(709, 80), colorRule1)
            //red234,green234,blue234 sequenceNumber:4 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(708, 84), colorRule1)
            //red232,green232,blue231 sequenceNumber:8 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(710, 89), colorRule1)
            //red254,green254,blue254 sequenceNumber:13 blockNumber: 15  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(719, 78), colorRule1)
            //red246,green246,blue246 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(717, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(723, 83), colorRule1)
            //red247,green247,blue247 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(716, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(722, 88), colorRule1)
            //red254,green254,blue254 sequenceNumber:14 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(738, 78), colorRule1)
            //red228,green228,blue228 sequenceNumber:0 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(740, 78), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(740, 86), colorRule1)
            //red253,green253,blue253 sequenceNumber:12 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(740, 90), colorRule1)
            //red242,green242,blue242 sequenceNumber:18 blockNumber: 18  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(528, 79), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(528, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(526, 89), colorRule1)
            //red250,green250,blue250 sequenceNumber:13 blockNumber: 19  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 79), colorRule1)
            //red234,green233,blue233 sequenceNumber:0 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(657, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 20  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(659, 79), colorRule1)
            //red248,green248,blue248 sequenceNumber:0 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(661, 84), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 88), colorRule1)
            //red238,green238,blue238 sequenceNumber:12 blockNumber: 21  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(666, 79), colorRule1)
            //red242,green241,blue241 sequenceNumber:0 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(671, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 22  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(639, 80), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(639, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 24  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(638, 88), colorRule1)
            //red250,green249,blue249 sequenceNumber:10 blockNumber: 24  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 81), colorRule1)
            //red245,green245,blue244 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(543, 82), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(547, 85), colorRule1)
            //red252,green252,blue252 sequenceNumber:4 blockNumber: 26  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(546, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(550, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:14 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(611, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 28  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(610, 83), colorRule1)
            //red240,green240,blue239 sequenceNumber:4 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(609, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 28  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(609, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:11 blockNumber: 28  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(601, 82), colorRule1)
            //red244,green244,blue244 sequenceNumber:4 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(598, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(602, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 32  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(586, 86), colorRule1)
            //red238,green238,blue237 sequenceNumber:0 blockNumber: 39  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(589, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 39  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(664, 86), colorRule1)
            //red231,green230,blue230 sequenceNumber:0 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 40  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(682, 88), colorRule1)
            //red250,green250,blue250 sequenceNumber:0 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(679, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(678, 89), colorRule1)
            //red253,green253,blue253 sequenceNumber:8 blockNumber: 43  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }


    val catchFlyingBeads21Area by lazy {
        ClickArea(360,258,60,59,true)}
    val catchFlyingBeads22Area by lazy {
        ClickArea(616,441,67,52,true)}
    val catchFlyingBeads23Area by lazy {
        ClickArea(894,423,42,55,true)}

    val isCatchFlyingBeads2Task by lazy {
        val tag = "isCatchFlyingBeads2"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,167,255,165,255,164,1.061413F,0.9F,1.067213F,0.9F,1.0613514F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(520, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(521, 80), colorRule1)
            //red228,green228,blue228 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(518, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(517, 86), colorRule1)
            //red210,green209,blue208 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(519, 90), colorRule1)
            //red253,green253,blue253 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(526, 83), colorRule1)
            //red203,green202,blue201 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(519, 90), colorRule1)
            //red253,green253,blue253 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 79), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 80), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(527, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 86), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(520, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(519, 90),CoordinatePoint(518, 89), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(583, 76), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(582, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 86), colorRule1)
            //red253,green253,blue253 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(583, 82),CoordinatePoint(582, 81), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(626, 76), colorRule1)
            //red222,green222,blue221 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(628, 80), colorRule1)
            //red237,green237,blue237 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(624, 85), colorRule1)
            //red221,green220,blue220 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(628, 82), colorRule1)
            //red243,green243,blue243 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(620, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(622, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(630, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(631, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(619, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(627, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(621, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(622, 86),CoordinatePoint(621, 85), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(647, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 80), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(640, 83), colorRule1)
            //red229,green229,blue228 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 83), colorRule1)
            //red244,green244,blue244 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(639, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(640, 83), colorRule1)
            //red229,green229,blue228 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(644, 86), colorRule1)
            //red239,green239,blue238 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 86), colorRule1)
            //red247,green247,blue247 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(637, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(639, 81),CoordinatePoint(641, 81), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:12sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(665, 76), colorRule1)
            //red195,green193,blue192 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(665, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 83), colorRule1)
            //red215,green214,blue213 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(659, 79), colorRule1)
            //red248,green248,blue248 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(658, 83), colorRule1)
            //red234,green234,blue233 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(656, 79), colorRule1)
            //red203,green202,blue202 sequenceNumber:19 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(660, 83),CoordinatePoint(659, 82), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(541, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(542, 90), colorRule1)
            //red188,green187,blue185 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(546, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(546, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(549, 89), colorRule1)
            //red186,green184,blue183 sequenceNumber:24 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 80), colorRule1)
            //red195,green193,blue192 sequenceNumber:30 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(542, 90),CoordinatePoint(542, 89), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(607, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(607, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(602, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(603, 83), colorRule1)
            //red248,green248,blue248 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(604, 83), colorRule1)
            //red208,green207,blue207 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 82), colorRule1)
            //red251,green251,blue251 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 85), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 85), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(602, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(609, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(610, 82),CoordinatePoint(609, 83), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(689, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(683, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(689, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(682, 78), colorRule1)
            //red239,green238,blue238 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(684, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(685, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(683, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(688, 87), colorRule1)
            //red211,green211,blue210 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 87), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(679, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(685, 83),CoordinatePoint(685, 86), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(PointRule(CoordinatePoint(747, 76), colorRule1)
            //red207,green206,blue206 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(749, 79), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(749, 90), colorRule1)
            //red252,green252,blue252 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(750, 83),CoordinatePoint(749, 83), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(563, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(560, 79), colorRule1)
            //red200,green200,blue199 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(564, 84), colorRule1)
            //red249,green249,blue248 sequenceNumber:8 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(566, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(569, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 10  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(564, 84),CoordinatePoint(562, 84), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(711, 77), colorRule1)
            //red201,green200,blue199 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(709, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(708, 84), colorRule1)
            //red232,green232,blue231 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(710, 90), colorRule1)
            //red247,green247,blue247 sequenceNumber:14 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(708, 84),CoordinatePoint(707, 84), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(718, 78), colorRule1)
            //red213,green212,blue211 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(721, 79), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(716, 80), colorRule1)
            //red199,green198,blue197 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(722, 83), colorRule1)
            //red214,green213,blue213 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(716, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(722, 88), colorRule1)
            //red254,green254,blue254 sequenceNumber:13 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(722, 83),CoordinatePoint(721, 83), CompareDifferenceRuleImpl.getSimple(30,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(738, 78), colorRule1)
            //red216,green215,blue215 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 78), colorRule1)
            //red219,green219,blue218 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 83), colorRule1)
            //red242,green241,blue241 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 87), colorRule1)
            //red238,green237,blue237 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 88), colorRule1)
            //red249,green249,blue248 sequenceNumber:17 blockNumber: 14  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(741, 83),CoordinatePoint(741, 81), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $14  positionType:$14
        )
        pointList.add(PointRule(CoordinatePoint(730, 83), colorRule1)
            //red237,green237,blue237 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(729, 85), colorRule1)
            //red242,green241,blue241 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 89), colorRule1)
            //red232,green232,blue231 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(729, 85),CoordinatePoint(729, 83), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:4sequenceNumber blockNumber: $16  positionType:$16
        )
        pointList.add(PointRule(CoordinatePoint(664, 86), colorRule1)
            //red231,green230,blue230 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(664, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 17  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(664, 88),CoordinatePoint(662, 88), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:4sequenceNumber blockNumber: $17  positionType:$17
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }

    val catchFlyingBeads31Area by lazy {
        ClickArea(391,252,44,64,true)}
    val catchFlyingBeads32Area by lazy {
        ClickArea(435,402,49,45,true)}
    val catchFlyingBeads33Area by lazy {
        ClickArea(819,387,55,42,true)}
    val catchFlyingBeads34Area by lazy {
        ClickArea(926,276,39,43,true)}
    val isCatchFlyingBeads3Task by lazy {
        val tag = "isCatchFlyingBeads3"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,167,255,165,255,164,1.061413F,0.9F,1.067213F,0.9F,1.0613514F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(520, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(521, 80), colorRule1)
            //red228,green228,blue228 sequenceNumber:4 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(518, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(517, 86), colorRule1)
            //red210,green209,blue208 sequenceNumber:12 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(519, 90), colorRule1)
            //red253,green253,blue253 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(526, 83), colorRule1)
            //red203,green202,blue201 sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(519, 90), colorRule1)
            //red253,green253,blue253 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 79), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 80), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(527, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(528, 86), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(520, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 76), colorRule1)
            //red254,green254,blue254 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(584, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 82), colorRule1)
            //red210,green209,blue208 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(582, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(583, 86), colorRule1)
            //red253,green253,blue253 sequenceNumber:12 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(583, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(626, 76), colorRule1)
            //red222,green222,blue221 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(628, 80), colorRule1)
            //red237,green237,blue237 sequenceNumber:4 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(624, 85), colorRule1)
            //red221,green220,blue220 sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(628, 82), colorRule1)
            //red243,green243,blue243 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(620, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(622, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(630, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(631, 85), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(619, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(627, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(621, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 77), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 80), colorRule1)
            //red254,green254,blue254 sequenceNumber:4 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(640, 83), colorRule1)
            //red229,green229,blue228 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(647, 83), colorRule1)
            //red244,green244,blue244 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(639, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(640, 83), colorRule1)
            //red229,green229,blue228 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(644, 86), colorRule1)
            //red239,green239,blue238 sequenceNumber:12 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(646, 86), colorRule1)
            //red247,green247,blue247 sequenceNumber:12 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(637, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(665, 76), colorRule1)
            //red195,green193,blue192 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(668, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(665, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(660, 83), colorRule1)
            //red215,green214,blue213 sequenceNumber:12 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(659, 79), colorRule1)
            //red248,green248,blue248 sequenceNumber:16 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(658, 83), colorRule1)
            //red234,green234,blue233 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(656, 79), colorRule1)
            //red203,green202,blue202 sequenceNumber:19 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(541, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(539, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(542, 90), colorRule1)
            //red188,green187,blue185 sequenceNumber:16 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(546, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(546, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(549, 89), colorRule1)
            //red186,green184,blue183 sequenceNumber:24 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(549, 80), colorRule1)
            //red195,green193,blue192 sequenceNumber:30 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(607, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(607, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(602, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(603, 83), colorRule1)
            //red248,green248,blue248 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(604, 83), colorRule1)
            //red208,green207,blue207 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 82), colorRule1)
            //red251,green251,blue251 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 85), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(599, 85), colorRule1)
            //red252,green252,blue252 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(602, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(610, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(609, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(689, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(683, 78), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(689, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(682, 78), colorRule1)
            //red239,green238,blue238 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(684, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(685, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(683, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(688, 87), colorRule1)
            //red211,green211,blue210 sequenceNumber:12 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(689, 87), colorRule1)
            //red254,green254,blue254 sequenceNumber:12 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(679, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(747, 76), colorRule1)
            //red207,green206,blue206 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(749, 79), colorRule1)
            //red249,green249,blue249 sequenceNumber:4 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 83), colorRule1)
            //red254,green254,blue254 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(750, 87), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(749, 90), colorRule1)
            //red252,green252,blue252 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(563, 79), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(560, 79), colorRule1)
            //red200,green200,blue199 sequenceNumber:4 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(564, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(564, 84), colorRule1)
            //red249,green249,blue248 sequenceNumber:8 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(566, 89), colorRule1)
            //red255,green255,blue255 sequenceNumber:12 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(569, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:17 blockNumber: 10  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(711, 77), colorRule1)
            //red201,green200,blue199 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(709, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 11  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(708, 84), colorRule1)
            //red232,green232,blue231 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(710, 90), colorRule1)
            //red247,green247,blue247 sequenceNumber:14 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(718, 78), colorRule1)
            //red213,green212,blue211 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(721, 79), colorRule1)
            //red253,green253,blue253 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(716, 80), colorRule1)
            //red199,green198,blue197 sequenceNumber:4 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(722, 83), colorRule1)
            //red214,green213,blue213 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(716, 84), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(722, 88), colorRule1)
            //red254,green254,blue254 sequenceNumber:13 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 78), colorRule1)
            //red216,green216,blue215 sequenceNumber:0 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(739, 81), colorRule1)
            //red230,green229,blue229 sequenceNumber:4 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(736, 85), colorRule1)
            //red201,green199,blue198 sequenceNumber:8 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(741, 87), colorRule1)
            //red248,green248,blue248 sequenceNumber:12 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(742, 87), colorRule1)
            //red248,green248,blue248 sequenceNumber:15 blockNumber: 14  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(730, 83), colorRule1)
            //red237,green237,blue237 sequenceNumber:0 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(729, 85), colorRule1)
            //red242,green241,blue241 sequenceNumber:4 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(727, 89), colorRule1)
            //red232,green232,blue231 sequenceNumber:8 blockNumber: 16  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(664, 86), colorRule1)
            //red231,green230,blue230 sequenceNumber:0 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(664, 88), colorRule1)
            //red255,green255,blue255 sequenceNumber:4 blockNumber: 17  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(669, 91), colorRule1)
            //red255,green255,blue255 sequenceNumber:10 blockNumber: 17  positionType:1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=4 }
    }

}