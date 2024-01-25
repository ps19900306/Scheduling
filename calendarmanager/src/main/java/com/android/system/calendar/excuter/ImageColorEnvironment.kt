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

//K30的弃用
class ImageColorEnvironment {

    val skipPlotFlowArea by lazy {
        ClickArea(2098, 20, 67, 83, false)
    }

    //剧情的跳过按钮
    val isSkipPlotFlowTask by lazy { 
        val tag = "isSkipPlotFlow"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(2111, 33), ColorRuleRatioImpl.getSimple(254, 232, 139))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(2117, 39), ColorRuleRatioImpl.getSimple(255, 229, 145))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2114, 38), ColorRuleRatioImpl.getSimple(255, 229, 145))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2125, 43), ColorRuleRatioImpl.getSimple(255, 236, 154))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2114, 49), ColorRuleRatioImpl.getSimple(255, 238, 164))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2114, 50), ColorRuleRatioImpl.getSimple(255, 239, 165))
            // sequenceNumber:27 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2134, 37), ColorRuleRatioImpl.getSimple(255, 229, 147))
            // sequenceNumber:0 blockNumber: 1  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(2127, 29), ColorRuleRatioImpl.getSimple(250, 217, 134))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2142, 42), ColorRuleRatioImpl.getSimple(255, 233, 154))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2132, 35), ColorRuleRatioImpl.getSimple(255, 227, 144))
            // sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2143, 44), ColorRuleRatioImpl.getSimple(255, 234, 156))
            // sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2134, 47), ColorRuleRatioImpl.getSimple(255, 238, 160))
            // sequenceNumber:24 blockNumber: 1  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(2135, 50), ColorRuleRatioImpl.getSimple(255, 241, 164))
            // sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2129, 54), ColorRuleRatioImpl.getSimple(255, 244, 167))
            // sequenceNumber:35 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 31), ColorRuleRatioImpl.getSimple(249, 216, 137))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 39), ColorRuleRatioImpl.getSimple(251, 225, 145))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 45), ColorRuleRatioImpl.getSimple(250, 229, 154))
            // sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 54), ColorRuleRatioImpl.getSimple(249, 238, 167))
            // sequenceNumber:25 blockNumber: 2  positionType:1
        )

        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255, 215, 255, 215, 255, 215, 1.05F, 0.9F, 1.05F, 0.9F, 1.05F, 0.9F
        )
        pointList.add(
            PointRule(CoordinatePoint(2150, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2150, 81), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2149, 93), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2119, 76), colorRule1)
            //red253,green253,blue253 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2120, 82), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2119, 90), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2127, 94), colorRule1)
            //red249,green249,blue249 sequenceNumber:27 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2111, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2106, 83), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2109, 93), colorRule1)
            //red253,green253,blue253 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2104, 88), colorRule1)
            //red239,green239,blue239 sequenceNumber:23 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2116, 80), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2113, 96), colorRule1)
            //red253,green253,blue253 sequenceNumber:19 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2137, 86), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2137, 91), colorRule1)
            //red250,green250,blue250 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2143, 96), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2154, 98), colorRule1)
            //red255,green255,blue255 sequenceNumber:27 blockNumber: 6  positionType:0
        )

        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val confirmationPromptOkArea by lazy { ClickArea(1308, 686, 237, 78, false) }
    val confirmationPromptCancelArea by lazy { ClickArea(856, 688, 235, 75, false) }

    //提示的确定按钮
    val isConfirmationPromptTask by lazy {
        val tag = "isOpen"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            222,
            255,
            205,
            229,
            176,
            1.1375F,
            0.9071146F,
            1.3232143F,
            1.0479451F,
            1.2214286F,
            1.039726F
        )
        val pr = PointRule(CoordinatePoint(1412, 710), colorRule1)
        //red255,green253,blue219 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(1409, 644, 7, 173)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1417, 714), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1410, 715), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1408, 721), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1413, 721), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1420, 720), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1407, 729), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1408, 727), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1413, 729), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1420, 726), colorRule1)
            //red255,green253,blue219 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1419, 736), colorRule1)
            //red255,green253,blue219 sequenceNumber:33 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1420, 720),
                CoordinatePoint(1420, 716),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1444, 711), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1440, 715), colorRule1)
            //red247,green228,blue196 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1451, 714), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1434, 717), colorRule1)
            //red255,green253,blue219 sequenceNumber:18 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1451, 714),
                CoordinatePoint(1451, 711),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(1403, 714), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1400, 718), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1397, 729), colorRule1)
            //red250,green242,blue209 sequenceNumber:19 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1400, 718),
                CoordinatePoint(1397, 718),
                CompareDifferenceRuleImpl.getSimple(15, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(1446, 720), colorRule1)
            //red255,green253,blue219 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1444, 724), colorRule1)
            //red255,green253,blue219 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1445, 726), colorRule1)
            //red254,green250,blue216 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1437, 727), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1443, 732), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1450, 736), colorRule1)
            //red255,green253,blue219 sequenceNumber:16 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1457, 736), colorRule1)
            //red255,green253,blue219 sequenceNumber:27 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1437, 727),
                CoordinatePoint(1437, 722),
                CompareDifferenceRuleImpl.getSimple(15, 40, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        FindImgTask(pr, findArea, pointList, tag).apply { nErrorTolerance = 3 }
    }

    //正在自动战斗的标识符
    val isInAutomaticCombatTask by lazy {
        val tag = "isInAutomaticCombat"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255, 216, 255, 216, 255, 214, 1.0761411F, 0.8964F, 1.0764706F, 0.9F, 1.0720588F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1124, 333), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1118, 340), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1121, 337), colorRule1)
            //red241,green240,blue239 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1119, 348), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1124, 343), colorRule1)
            //red253,green253,blue252 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1129, 338), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1118, 354), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1121, 353), colorRule1)
            //red247,green241,blue241 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1130, 351), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1129, 354), colorRule1)
            //red255,green255,blue255 sequenceNumber:31 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1129, 338),
                CoordinatePoint(1129, 334),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1160, 334), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1160, 339), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1157, 346), colorRule1)
            //red244,green243,blue243 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1164, 347), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1161, 353), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1157, 346),
                CoordinatePoint(1156, 345),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(1186, 334), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1187, 342), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1189, 348), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1181, 349), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1192, 353), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1177, 342), colorRule1)
            //red249,green250,blue249 sequenceNumber:32 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1174, 348), colorRule1)
            //red255,green255,blue255 sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1177, 336), colorRule1)
            //red255,green255,blue255 sequenceNumber:41 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1216, 333), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1217, 337), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1217, 346), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1221, 344), colorRule1)
            //red243,green242,blue239 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1216, 355), colorRule1)
            //red254,green253,blue253 sequenceNumber:25 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1217, 346),
                CoordinatePoint(1214, 344),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(1244, 333), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1244, 339), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1239, 346), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1244, 346), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1251, 344), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1244, 356), colorRule1)
            //red254,green253,blue253 sequenceNumber:26 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1244, 346),
                CoordinatePoint(1249, 343),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:16sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(1150, 342), colorRule1)
            //red249,green249,blue249 sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1146, 349), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 9  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1146, 349),
                CoordinatePoint(1145, 347),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:9sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(
            PointRule(CoordinatePoint(1208, 346), colorRule1)
            //red244,green243,blue238 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1211, 346), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 11  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1211, 346),
                CoordinatePoint(1211, 348),
                CompareDifferenceRuleImpl.getSimple(40, 40, 40)
            ) // sequenceNumber:5sequenceNumber blockNumber: $11  positionType:$11
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 5
        }
    }

    //正在进行自动寻路中
    val isSearchingWayTask by lazy {
        val tag = "isSearchingWay"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,216,255,216,255,216,1.054375F,0.892562F,1.054375F,0.8852459F,1.05F, 0.89262295F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1144, 288), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 100, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1144, 295), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1134, 296), colorRule1)
            //red240,green242,blue244 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1142, 301), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1147, 299), colorRule1)
            //red243,green244,blue246 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1138, 309), colorRule1)
            //red245,green247,blue248 sequenceNumber:25 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1173, 288), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1170, 293), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1176, 291), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1170, 301), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1176, 300), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1175, 308), colorRule1)
            //red251,green252,blue252 sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1170, 301),CoordinatePoint(1166, 301), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1133, 289), colorRule1)
            //red250,green250,blue251 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1136, 289), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1162, 290), colorRule1)
            //red241,green240,blue240 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1158, 299), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1158, 299),CoordinatePoint(1156, 301), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:21sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(1128, 301), colorRule1)
            //red248,green249,blue249 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1132, 301), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 5  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }



    val shopDemandLeftArea by lazy {
        ClickArea(1005,243,165,72,false)}
    //这里是左边购物需求的位置
    val isShopDemandLeftTask by lazy {
        val tag = "isShopDemandLeft"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            214,
            247,
            167,
            185,
            129,
            1.3548386F,
            0.95361704F,
            1.7596552F,
            1.2661017F,
            1.4082353F,
            1.1624999F
        )
        val pr = PointRule(CoordinatePoint(552, 220), colorRule1)
        //red249,green232,blue174 sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(549, 210, 7, 672)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(560, 222), colorRule1)
            //red243,green198,blue151 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(549, 224), colorRule1)
            //red243,green190,blue145 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(549, 224), colorRule1)
            //red243,green190,blue145 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(556, 230), colorRule1)
            //red243,green193,blue148 sequenceNumber:46 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(561, 224), colorRule1)
            //red247,green221,blue167 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(544, 225), colorRule1)
            //red244,green206,blue157 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(548, 235), colorRule1)
            //red240,green186,blue144 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(560, 235), colorRule1)
            //red247,green221,blue167 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(545, 239), colorRule1)
            //red248,green227,blue171 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(550, 237), colorRule1)
            //red246,green201,blue153 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(560, 242), colorRule1)
            //red248,green228,blue172 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(556, 230), colorRule1)
            //red243,green193,blue148 sequenceNumber:46 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(552, 220),
                CoordinatePoint(552, 216),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(544, 225),
                CoordinatePoint(541, 225),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(556, 230),
                CoordinatePoint(560, 230),
                CompareDifferenceRuleImpl.getSimple(10, 30, 20)
            ) // sequenceNumber:46sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(552, 249), colorRule1)
            //red248,green234,blue175 sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(552, 254), colorRule1)
            //red251,green236,blue176 sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(550, 254), colorRule1)
            //red241,green197,blue149 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(559, 250), colorRule1)
            //red240,green203,blue154 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(560, 250), colorRule1)
            //red244,green214,blue162 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(558, 258), colorRule1)
            //red247,green229,blue173 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(559, 257), colorRule1)
            //red247,green227,blue171 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(546, 260), colorRule1)
            //red241,green219,blue166 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(557, 264), colorRule1)
            //red248,green232,blue175 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(542, 267), colorRule1)
            //red245,green226,blue169 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(565, 268), colorRule1)
            //red238,green201,blue152 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(559, 266), colorRule1)
            //red249,green235,blue177 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 271), colorRule1)
            //red248,green231,blue174 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(552, 266), colorRule1)
            //red247,green228,blue170 sequenceNumber:50 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(552, 249),
                CoordinatePoint(549, 249),
                CompareDifferenceRuleImpl.getSimple(15, 40, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(546, 260),
                CoordinatePoint(543, 260),
                CompareDifferenceRuleImpl.getSimple(15, 40, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            nErrorTolerance = 4
        }
    }

    val automaticCombatSwitchArea by lazy { ClickArea(1291,813,148,50,false)}

    val isOpenAutomaticCombatTask by lazy {
        val tag = "isActivateAutomaticCombat"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,180,241,160,153,102,1.1798387F,0.99782604F,1.8441176F,1.5719178F,1.6582758F, 1.4052632F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1373, 827), colorRule1)
            //red255,green230,blue146 sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1370, 832), colorRule1)
            //red255,green230,blue146 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1371, 830), colorRule1)
            //red255,green230,blue146 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1368, 837), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1373, 836), colorRule1)
            //red233,green209,blue133 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1379, 832), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1379, 834), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1367, 845), colorRule1)
            //red255,green230,blue146 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1371, 846), colorRule1)
            //red200,green178,blue114 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1379, 838), colorRule1)
            //red255,green230,blue146 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1379, 842), colorRule1)
            //red255,green230,blue146 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1378, 847), colorRule1)
            //red255,green230,blue146 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1409, 827), colorRule1)
            //red255,green230,blue146 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1409, 833), colorRule1)
            //red255,green230,blue146 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1408, 834), colorRule1)
            //red255,green230,blue146 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1414, 834), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1413, 838), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1399, 836), colorRule1)
            //red254,green229,blue145 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1407, 840), colorRule1)
            //red255,green230,blue146 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1411, 846), colorRule1)
            //red255,green230,blue146 sequenceNumber:28 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1400, 831), colorRule1)
            //red255,green230,blue146 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1397, 831), colorRule1)
            //red209,green186,blue119 sequenceNumber:6 blockNumber: 2  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=3 }
    }

    val isCloseAutomaticCombatTask by lazy {
        val tag = "isCloseAutomaticCombat"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,207,255,198,216,169,1.1017938F,0.938961F,1.2946602F,1.1010638F,1.2385923F, 1.0531914F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1373, 827), colorRule1)
            //red254,green243,blue206 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1371, 832), colorRule1)
            //red240,green230,blue196 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1371, 832), colorRule1)
            //red240,green230,blue196 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1368, 842), colorRule1)
            //red254,green243,blue206 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1373, 836), colorRule1)
            //red233,green223,blue190 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1379, 832), colorRule1)
            //red254,green243,blue206 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1379, 845), colorRule1)
            //red254,green243,blue206 sequenceNumber:30 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1409, 827), colorRule1)
            //red254,green243,blue206 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1409, 831), colorRule1)
            //red254,green243,blue206 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1409, 832), colorRule1)
            //red254,green243,blue206 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1413, 840), colorRule1)
            //red254,green243,blue206 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1406, 842), colorRule1)
            //red254,green243,blue206 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1410, 846), colorRule1)
            //red254,green243,blue206 sequenceNumber:25 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1401, 830), colorRule1)
            //red234,green223,blue190 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1395, 832), colorRule1)
            //red241,green231,blue196 sequenceNumber:6 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1401, 835), colorRule1)
            //red231,green221,blue188 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1390, 837), colorRule1)
            //red230,green220,blue188 sequenceNumber:11 blockNumber: 3  positionType:0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

    val clickOptArea by lazy {
        ClickArea(1387,657,257,93,false)}
    //这里是中间点击装备的 及其他点击效果的操作
    val isClickOptTask by lazy {
        val tag = "isClickOptOpen"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,181,255,180,255,180,1.0552238F,0.9F,1.0605F,0.9F,1.05525F, 0.9F)
        val pr  = PointRule(CoordinatePoint(1483, 709), colorRule1)
        //red255,green255,blue254 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(1427,673,313,86)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1485, 715), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1484, 716), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1486, 721), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1481, 721), colorRule1)
            //red202,green201,blue200 sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1484, 722), colorRule1)
            //red254,green254,blue254 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1494, 720), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1472, 722), colorRule1)
            //red204,green203,blue202 sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1478, 730), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(1491, 728), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1492, 727), colorRule1)
            //red255,green255,blue255 sequenceNumber:33 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1484, 722),CoordinatePoint(1482, 723), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(1453, 710), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1454, 713), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1459, 714), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1460, 721), colorRule1)
            //red255,green255,blue255 sequenceNumber:18 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(1459, 714),CoordinatePoint(1459, 712), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1445, 729), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1444, 731), colorRule1)
            //red255,green255,blue255 sequenceNumber:6 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1444, 731),CoordinatePoint(1441, 731), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:6sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(1463, 728), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1465, 729), colorRule1)
            //red255,green255,blue255 sequenceNumber:5 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1465, 729),CoordinatePoint(1465, 726), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        FindImgTask(pr, findArea,pointList, tag).apply {
            nErrorTolerance=3 }
    }


    val isOpenTask by lazy {
        val tag = "isOpen"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,202,255,201,255,201,1.0546875F,0.9F,1.0546875F,0.9F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(735, 473), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(736, 480), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(738, 486), colorRule1)
            //red247,green247,blue247 sequenceNumber:19 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(735, 473),CoordinatePoint(735, 471), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 480),CoordinatePoint(734, 479), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(738, 486),CoordinatePoint(738, 487), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:19sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(715, 474), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(713, 481), colorRule1)
            //red225,green224,blue224 sequenceNumber:11 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(715, 474),CoordinatePoint(713, 474), CompareDifferenceRuleImpl.getSimple(40,40,50)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(713, 481),CoordinatePoint(713, 479), CompareDifferenceRuleImpl.getSimple(40,40,40)) // sequenceNumber:11sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=2 }
    }

}