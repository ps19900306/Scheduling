package com.android.system.talker.excuter


import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.area.DirectionType
import com.android.schedule.corelibrary.area.TwoFingerType
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.SlidingArea
import com.android.schedule.corelibrary.click.SwipeArea
import com.android.schedule.corelibrary.click.TwoFingerArea
import com.android.schedule.corelibrary.img.color_rule.ColorRuleImpl
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import com.android.schedule.corelibrary.img.img_rule.HpTaskImpl
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.img_rule.MultiFindImgTask
import com.android.schedule.corelibrary.img.img_rule.MultiImgContainmentTask
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.img.point_rule.PointRules
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule


class StarWarEnvironment {

    val isLoadingGameT by lazy {
        val tag = "isLoadingGame"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            91, 54, 92, 54, 87, 50,
            1.05F, 0.8852459F, 1.1437501F, 0.8852459F, 1.1624999F, 0.9216867F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1048, 440), ruleRatio1
                //red72 green73 blue68 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1048, 440), ruleRatio1
                //red72 green73 blue68 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1030, 567), ruleRatio1
                //red71 green72 blue67 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1183, 451), ruleRatio1
                //red61 green62 blue57 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1194, 569), ruleRatio1
                //red83 green84 blue79 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1064, 469), ruleRatio1
                //red62 green63 blue58 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1101, 511), ruleRatio1
                //red63 green64 blue59 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1069, 565), ruleRatio1
                //red80 green81 blue76 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1165, 469), ruleRatio1
                //red74 green75 blue70 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1107, 566), ruleRatio1
                //red63 green64 blue59 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1143, 578), ruleRatio1
                //red70 green71 blue66 blockNumber3
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isAnnouncementT by lazy {
        val tag = "isAnnouncement"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            267, 221, 267, 223, 267, 220,
            1.0584677F, 0.8927419F, 1.0584677F, 0.8927419F, 1.0628572F, 0.8928F
        )
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1218, 127), ruleRatio1))
        //red249 green249 blue249 blockNumber1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1207, 144), ruleRatio1
                //red253 green253 blue253 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1235, 127), ruleRatio1
                //red249 green249 blue249 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1237, 131), ruleRatio1
                //red249 green249 blue249 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1248, 145), ruleRatio1
                //red249 green249 blue249 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1226, 142), ruleRatio1
                //red251 green251 blue251 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1217, 155), ruleRatio1
                //red249 green251 blue250 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1237, 155), ruleRatio1
                //red250 green250 blue250 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1235, 164), ruleRatio1
                //red253 green253 blue253 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1246, 168), ruleRatio1
                //red252 green252 blue252 blockNumber5
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1218, 127),
                CoordinatePoint(1218, 123),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1226, 142),
                CoordinatePoint(1226, 138),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1222, 165),
                CoordinatePoint(1222, 162),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val closeAnnouncementArea by lazy { ClickArea(1917, 90, 70, 67) }


    val isStartGameT by lazy {
        val tag = "isStartGame"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            267, 228, 267, 215, 258, 189,
            1.1202928F, 0.9F, 1.275F, 0.9F, 1.2249999F, 0.9329268F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            267, 225, 196, 161, 77, 54,
            1.4899441F, 1.2193549F, 4.4449997F, 1.2193549F, 3.1325F, 2.2256756F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2221, 959), ruleRatio1
                //red255 green252 blue226 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2221, 959), ruleRatio1
                //red255 green252 blue226 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2220, 963), ruleRatio1
                //red255 green246 blue224 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2223, 965), ruleRatio1
                //red255 green246 blue226 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2217, 965), ruleRatio1
                //red255 green244 blue211 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2227, 966), ruleRatio1
                //red255 green245 blue212 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2220, 969), ruleRatio1
                //red255 green246 blue220 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2221, 955), ruleRatio2
                //red252 green186 blue74 blockNumber0
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2217, 960), ruleRatio2
                //red252 green184 blue73 blockNumber0
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val isStartGameArea by lazy { ClickArea(1002, 758, 419, 147) }

    val isSelectRoleT by lazy {
        val tag = "isSelectRole"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(544, 603), ColorRuleRatioImpl.getSimple(161, 164, 169))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(549, 603), ColorRuleRatioImpl.getSimple(164, 169, 175))
            // sequenceNumber:12 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(544, 603),
                CoordinatePoint(541, 603),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )

        pointList.add(
            TwoPointRule(
                CoordinatePoint(549, 603),
                CoordinatePoint(554, 600),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(533, 610), ColorRuleRatioImpl.getSimple(163, 166, 171))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(526, 610), ColorRuleRatioImpl.getSimple(163, 164, 168))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(549, 610), ColorRuleRatioImpl.getSimple(158, 163, 167))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(526, 596), ColorRuleRatioImpl.getSimple(164, 165, 170))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(537, 609), ColorRuleRatioImpl.getSimple(162, 165, 170))
            // sequenceNumber:32 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(536, 596), ColorRuleRatioImpl.getSimple(165, 166, 170))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(543, 597), ColorRuleRatioImpl.getSimple(163, 166, 171))
            // sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(550, 596), ColorRuleRatioImpl.getSimple(163, 164, 168))
            // sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(533, 610),
                CoordinatePoint(533, 614),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(528, 596),
                CoordinatePoint(528, 592),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val selectRoleArea by lazy { ClickArea(585, 187, 226, 343, false) }

    val isClosePositionMenuT by lazy {
        val tag = "isClosePositionMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(134, 281), ColorRuleRatioImpl.getSimple(124, 124, 124))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(142, 284), ColorRuleRatioImpl.getSimple(125, 125, 125))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(128, 285), ColorRuleRatioImpl.getSimple(127, 127, 127))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(144, 289), ColorRuleRatioImpl.getSimple(136, 136, 136))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(142, 294), ColorRuleRatioImpl.getSimple(144, 144, 145))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(127, 291), ColorRuleRatioImpl.getSimple(137, 137, 137))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(141, 296), ColorRuleRatioImpl.getSimple(145, 148, 150))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(131, 299), ColorRuleRatioImpl.getSimple(147, 157, 157))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(135, 307), ColorRuleRatioImpl.getSimple(160, 166, 171))
            // sequenceNumber:35 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(134, 281),
                CoordinatePoint(134, 278),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(144, 289),
                CoordinatePoint(140, 289),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(131, 296),
                CoordinatePoint(132, 291),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(135, 307),
                CoordinatePoint(130, 307),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:35sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val openPositionArea by lazy { ClickArea(102, 265, 67, 63, true) }
    val isOpenPositionMenuT by lazy {
        val tag = "isOpenPositionMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(496, 284), ColorRuleRatioImpl.getSimple(123, 124, 124))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(489, 281), ColorRuleRatioImpl.getSimple(124, 124, 124))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(496, 295), ColorRuleRatioImpl.getSimple(144, 146, 148))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(484, 284), ColorRuleRatioImpl.getSimple(125, 125, 125))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(482, 291), ColorRuleRatioImpl.getSimple(138, 138, 138))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(484, 295), ColorRuleRatioImpl.getSimple(138, 149, 149))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(497, 294), ColorRuleRatioImpl.getSimple(145, 145, 145))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(482, 291), ColorRuleRatioImpl.getSimple(138, 138, 138))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(493, 302), ColorRuleRatioImpl.getSimple(159, 164, 169))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(486, 299), ColorRuleRatioImpl.getSimple(147, 157, 157))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(490, 308), ColorRuleRatioImpl.getSimple(158, 164, 169))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(496, 284),
                CoordinatePoint(494, 286),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(484, 284),
                CoordinatePoint(484, 279),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(482, 291),
                CoordinatePoint(478, 291),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    //这个是灰色的
    val isOpenPositionMenuGrayT by lazy {
        val tag = "isOpenPositionMenuGray"
        val list = mutableListOf<PointRule>()
        PointRule(CoordinatePoint(131, 282), ColorRuleRatioImpl.getSimple(46, 46, 46))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(141, 283), ColorRuleRatioImpl.getSimple(46, 46, 46))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(127, 287), ColorRuleRatioImpl.getSimple(48, 48, 48))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(144, 288), ColorRuleRatioImpl.getSimple(49, 49, 51))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(130, 296), ColorRuleRatioImpl.getSimple(49, 53, 54))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(132, 297), ColorRuleRatioImpl.getSimple(50, 54, 55))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(141, 296), ColorRuleRatioImpl.getSimple(51, 53, 52))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(133, 303), ColorRuleRatioImpl.getSimple(56, 57, 59))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(133, 302), ColorRuleRatioImpl.getSimple(56, 57, 59))
            // sequenceNumber:35 blockNumber: 0  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(131, 282),
                CoordinatePoint(131, 278),
                CompareDifferenceRuleImpl.getSimple(10, 10, 10)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(144, 288),
                CoordinatePoint(139, 288),
                CompareDifferenceRuleImpl.getSimple(10, 15, 15)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(141, 296),
                CoordinatePoint(137, 291),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isInSpaceStationT by lazy {
        val isInSpaceStationT1 by lazy {
            val tag = "isInSapceStation"
            val ruleRatio1 = ColorRuleRatioImpl.getSimple(
                173, 113, 149, 96, 55, 27,
                1.2761538F, 1.0369565F, 5.351613F, 1.0369565F, 4.470968F, 2.2754717F
            )
            val list = mutableListOf<PointRule>()
            list.add(
                PointRule(
                    CoordinatePoint(2060, 354), ruleRatio1
                    //red159 green137 blue51 blockNumber4
                )
            )
            val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(
                    CoordinatePoint(2071, 360), ruleRatio1
                    //red157 green132 blue31 blockNumber1
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2070, 364), ruleRatio1
                    //red156 green130 blue33 blockNumber2
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2061, 367), ruleRatio1
                    //red156 green131 blue31 blockNumber3
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2064, 369), ruleRatio1
                    //red156 green131 blue31 blockNumber3
                )
            )

            pointList.add(
                PointRule(
                    CoordinatePoint(2060, 354), ruleRatio1
                    //red159 green137 blue51 blockNumber4
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2071, 350), ruleRatio1
                    //red163 green139 blue49 blockNumber5
                )
            )
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }


        val isInSpaceStationT2 by lazy {
            val tag = "isInSapceStation"
            val ruleRatio1 = ColorRuleRatioImpl.getSimple(
                186, 129, 156, 110, 48, 31,
                1.2732284F, 0.99642855F, 4.6576924F, 0.99642855F, 4.11F, 2.809756F
            )

            val list = mutableListOf<PointRule>()
            list.add(
                PointRule(
                    CoordinatePoint(2039, 353), ruleRatio1
                    //red159 green137 blue51 blockNumber4
                )
            )
            val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(
                    CoordinatePoint(2039, 353), ruleRatio1
                    //red173 green146 blue41 blockNumber1
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2071, 351), ruleRatio1
                    //red170 green145 blue44 blockNumber2
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(2101, 351), ruleRatio1
                    //red174 green147 blue40 blockNumber3
                )
            )
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }


        val isInSpaceStationT3 by lazy {
            val tag = "isInSpaceStationT3"
            val list = mutableListOf<PointRule>()
            list.add(
                PointRule(CoordinatePoint(2056, 373), ColorRuleRatioImpl.getSimple(158, 130, 32))
                // sequenceNumber:0 blockNumber: 0  positionType:4
            )
            val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(CoordinatePoint(2062, 365), ColorRuleRatioImpl.getSimple(155, 132, 34))
                // sequenceNumber:8 blockNumber: 0  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2041, 382), ColorRuleRatioImpl.getSimple(92, 82, 28))
                // sequenceNumber:16 blockNumber: 0  positionType:0
            )
            pointList.add(
                PointRule(CoordinatePoint(2054, 345), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:24 blockNumber: 0  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2057, 380), ColorRuleRatioImpl.getSimple(156, 131, 32))
                // sequenceNumber:32 blockNumber: 0  positionType:3
            )
            pointList.add(
                PointRule(CoordinatePoint(2042, 335), ColorRuleRatioImpl.getSimple(169, 145, 41))
                // sequenceNumber:40 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2072, 365), ColorRuleRatioImpl.getSimple(157, 130, 32))
                // sequenceNumber:48 blockNumber: 0  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2056, 338), ColorRuleRatioImpl.getSimple(173, 148, 41))
                // sequenceNumber:56 blockNumber: 0  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2073, 354), ColorRuleRatioImpl.getSimple(174, 146, 40))
                // sequenceNumber:64 blockNumber: 0  positionType:3
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2056, 373),
                    CoordinatePoint(2053, 368),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2042, 335),
                    CoordinatePoint(2042, 331),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                PointRule(CoordinatePoint(2009, 335), ColorRuleRatioImpl.getSimple(175, 140, 42))
                // sequenceNumber:0 blockNumber: 1  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2011, 336), ColorRuleRatioImpl.getSimple(174, 146, 40))
                // sequenceNumber:8 blockNumber: 1  positionType:3
            )
            pointList.add(
                PointRule(CoordinatePoint(2024, 339), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:16 blockNumber: 1  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2028, 352), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:24 blockNumber: 1  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2040, 355), ColorRuleRatioImpl.getSimple(174, 146, 40))
                // sequenceNumber:32 blockNumber: 1  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2022, 372), ColorRuleRatioImpl.getSimple(158, 130, 32))
                // sequenceNumber:40 blockNumber: 1  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2037, 367), ColorRuleRatioImpl.getSimple(158, 130, 32))
                // sequenceNumber:48 blockNumber: 1  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2008, 384), ColorRuleRatioImpl.getSimple(153, 130, 26))
                // sequenceNumber:56 blockNumber: 1  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2018, 381), ColorRuleRatioImpl.getSimple(156, 131, 32))
                // sequenceNumber:68 blockNumber: 1  positionType:3
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2009, 335),
                    CoordinatePoint(2009, 331),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2040, 355),
                    CoordinatePoint(2042, 351),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:32sequenceNumber blockNumber: $1  positionType:$1
            )
            pointList.add(
                PointRule(CoordinatePoint(2075, 335), ColorRuleRatioImpl.getSimple(169, 144, 41))
                // sequenceNumber:0 blockNumber: 2  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2079, 335), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:8 blockNumber: 2  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2089, 347), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:16 blockNumber: 2  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2093, 341), ColorRuleRatioImpl.getSimple(174, 147, 40))
                // sequenceNumber:24 blockNumber: 2  positionType:3
            )
            pointList.add(
                PointRule(CoordinatePoint(2094, 367), ColorRuleRatioImpl.getSimple(158, 130, 32))
                // sequenceNumber:32 blockNumber: 2  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2109, 357), ColorRuleRatioImpl.getSimple(174, 146, 41))
                // sequenceNumber:40 blockNumber: 2  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2078, 382), ColorRuleRatioImpl.getSimple(156, 132, 33))
                // sequenceNumber:48 blockNumber: 2  positionType:3
            )
            pointList.add(
                PointRule(CoordinatePoint(2101, 369), ColorRuleRatioImpl.getSimple(157, 131, 32))
                // sequenceNumber:56 blockNumber: 2  positionType:4
            )
            pointList.add(
                PointRule(CoordinatePoint(2081, 384), ColorRuleRatioImpl.getSimple(156, 131, 32))
                // sequenceNumber:64 blockNumber: 2  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2087, 380), ColorRuleRatioImpl.getSimple(157, 130, 32))
                // sequenceNumber:71 blockNumber: 2  positionType:4
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2075, 335),
                    CoordinatePoint(2075, 331),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2109, 357),
                    CoordinatePoint(2110, 352),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 10)
                ) // sequenceNumber:40sequenceNumber blockNumber: $2  positionType:$2
            )
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }


        MultiImgContainmentTask(arrayOf(isInSpaceStationT3, isInSpaceStationT1, isInSpaceStationT2))
    }


    val isOpenBigMenuT by lazy {
        val tag = "isOpenBigMenu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            237, 189, 250, 207, 249, 205,
            1.0097872F, 0.80466104F, 1.0228448F, 0.80466104F, 1.0726293F, 0.89610386F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(152, 46), ruleRatio1
                //red212 green234 blue231 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(152, 46), ruleRatio1
                //red212 green234 blue231 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(171, 46), ruleRatio1
                //red222 green237 blue234 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(167, 49), ruleRatio1
                //red222 green237 blue234 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(187, 49), ruleRatio1
                //red223 green238 blue235 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(152, 58), ruleRatio1
                //red213 green235 blue232 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(172, 58), ruleRatio1
                //red222 green237 blue234 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(152, 68), ruleRatio1
                //red211 green236 blue232 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(170, 71), ruleRatio1
                //red221 green237 blue236 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(166, 74), ruleRatio1
                //red220 green232 blue232 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(188, 73), ruleRatio1
                //red223 green233 blue232 blockNumber3
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(152, 46),
                CoordinatePoint(150, 46),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(172, 58),
                CoordinatePoint(172, 55),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val closeBigMenuArea by lazy { ClickArea(2185, 27, 78, 73) }


    val isSailingT by lazy {
        val tag = "isSailing"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            153, 108, 175, 124, 170, 118,
            0.9521739F, 0.74693877F, 0.9826923F, 0.74693877F, 1.0977272F, 0.9116883F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(127, 293), ruleRatio1
                //red122 green147 blue143 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()

        pointList.add(
            PointRule(
                CoordinatePoint(139, 296), ruleRatio1
                //red131 green156 blue152 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(138, 304), ruleRatio1
                //red143 green160 blue154 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(127, 297), ruleRatio1
                //red136 green156 blue154 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(126, 305), ruleRatio1
                //red142 green159 blue153 blockNumber2
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(139, 292),
                CoordinatePoint(136, 292),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(127, 293),
                CoordinatePoint(124, 293),
                CompareDifferenceRuleImpl.getSimple(20, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isCloseEyeMenuT by lazy {
        val tag = "isCloseEyeMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(2245, 599), ColorRuleRatioImpl.getSimple(146, 146, 146))
            // sequenceNumber:0 blockNumber: 0  positionType:3
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(2234, 594), ColorRuleRatioImpl.getSimple(139, 139, 139))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2232, 613), ColorRuleRatioImpl.getSimple(128, 126, 124))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2238, 615), ColorRuleRatioImpl.getSimple(170, 170, 170))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2240, 613), ColorRuleRatioImpl.getSimple(169, 169, 169))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2221, 602), ColorRuleRatioImpl.getSimple(156, 156, 156))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2224, 613), ColorRuleRatioImpl.getSimple(170, 170, 170))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2220, 609), ColorRuleRatioImpl.getSimple(167, 167, 167))
            // sequenceNumber:32 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(2243, 597), ColorRuleRatioImpl.getSimple(145, 145, 145))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2223, 598), ColorRuleRatioImpl.getSimple(145, 145, 145))
            // sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(2229, 594), ColorRuleRatioImpl.getSimple(139, 138, 138))
            // sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2245, 599),
                CoordinatePoint(2247, 594),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2224, 611),
                CoordinatePoint(2227, 608),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2229, 594),
                CoordinatePoint(2229, 591),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(2232, 604), ColorRuleRatioImpl.getSimple(157, 157, 157))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2234, 604), ColorRuleRatioImpl.getSimple(159, 159, 159))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2232, 604),
                CoordinatePoint(2228, 604),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2234, 604),
                CoordinatePoint(2234, 599),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val openEyeMenuArea by lazy { ClickArea(2200, 572, 70, 64, true) }
    val isOpenEyeMenuT by lazy {
        val tag = "isOpenEyeMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1861, 613), ColorRuleRatioImpl.getSimple(167, 167, 167))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1849, 613), ColorRuleRatioImpl.getSimple(169, 168, 168))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1864, 612), ColorRuleRatioImpl.getSimple(170, 170, 170))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1864, 597), ColorRuleRatioImpl.getSimple(145, 145, 145))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1844, 603), ColorRuleRatioImpl.getSimple(157, 156, 156))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1849, 595), ColorRuleRatioImpl.getSimple(144, 144, 144))
            // sequenceNumber:46 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1871, 602), ColorRuleRatioImpl.getSimple(156, 156, 156))
            // sequenceNumber:24 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(1839, 602), ColorRuleRatioImpl.getSimple(156, 156, 156))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1849, 595), ColorRuleRatioImpl.getSimple(144, 144, 144))
            // sequenceNumber:46 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1861, 613),
                CoordinatePoint(1861, 609),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1872, 606),
                CoordinatePoint(1877, 606),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1855, 604), ColorRuleRatioImpl.getSimple(159, 159, 159))
            // sequenceNumber:0 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1855, 605), ColorRuleRatioImpl.getSimple(159, 159, 159))
            // sequenceNumber:9 blockNumber: 1  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1855, 604),
                CoordinatePoint(1855, 599),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1855, 605),
                CoordinatePoint(1855, 609),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:9sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)

    }


    //可以领取或者可以收集
    val isGiftMenuTipsT by lazy {
        val tag = "isGiftMenuTips"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            255, 212, 217, 171, 130, 100,
            1.3303665F, 1.052174F, 2.2687502F, 1.052174F, 1.8808696F, 1.451613F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            257, 200, 64, 44, 81, 58,
            5.25F, 3.4819672F, 3.78F, 3.4819672F, 0.85499996F, 0.6375F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(164, 518), ruleRatio2
                //red225 green50 blue67 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(148, 529), ruleRatio1
                //red242 green207 blue117 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(156, 529), ruleRatio1
                //red242 green197 blue114 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(171, 521), ruleRatio2
                //red240 green55 blue73 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(171, 525), ruleRatio2
                //red240 green53 blue72 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(166, 528), ruleRatio2
                //red235 green52 blue70 blockNumber1
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = openGiftMenuArea
        }
    }
    val openGiftMenuArea by lazy { ClickArea(115, 516, 61, 65) }


    val isCanCollectGiftT by lazy {
        val tag = "isCanCollectGift"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            221, 170, 174, 126, 102, 73,
            1.4595745F, 1.0936708F, 2.509756F, 1.0936708F, 1.9068965F, 1.5065217F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            187, 154, 40, 26, 31, 20,
            6.3F, 4.0846157F, 7.852174F, 4.0846157F, 1.70625F, 1.0038462F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(712, 736), ruleRatio1
                //red194 green144 blue83 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(712, 736), ruleRatio1
                //red194 green144 blue83 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(708, 750), ruleRatio1
                //red205 green157 blue91 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(712, 760), ruleRatio1
                //red192 green155 blue87 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(726, 760), ruleRatio1
                //red194 green157 blue89 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(716, 736), ruleRatio2
                //red176 green33 blue27 blockNumber1
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //领取礼物
    val openCollectGiftArea by lazy { ClickArea(442, 723, 335, 60) }
    val closeCollectGiftArea by lazy { ClickArea(1902, 150, 60, 63) }

    val collectChipMenuArea by lazy { ClickArea(1797, 153, 61, 57) }


    val isCollectChipMenuT by lazy {
        val tag = "isCollectChipMenu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            199, 154, 70, 47, 85, 64,
            3.461111F, 2.458209F, 2.625F, 2.458209F, 0.9479167F, 0.6230769F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1929, 892), ruleRatio1
                //red187 green65 blue80 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1929, 892), ruleRatio1
                //red187 green65 blue80 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1933, 897), ruleRatio1
                //red177 green55 blue78 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1929, 892),
                CoordinatePoint(1929, 889),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -10)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1933, 897),
                CoordinatePoint(1938, 897),
                CompareDifferenceRuleImpl.getSimple(-15, -30, -15)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = CollectChipArea
        }
    }
    val CollectChipArea by lazy { ClickArea(1635, 881, 347, 89) }
    val CloseCollectChipMenuArea by lazy { ClickArea(1922, 97, 58, 64) } //未点击一件领取点这里关闭
    val hasTakeArea by lazy { ClickArea(816, 483, 766, 508) } //点击了一键领取点击这里关闭


    //打开了机遇大菜单
    val isOpenJiyuBigMenuTask by lazy {
        val tag = "isOpenJiyuBigMenu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            192, 131, 202, 146, 201, 144,
            0.9955958F, 0.79636365F, 1.0111111F, 0.79636365F, 1.0881817F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(287, 38), ruleRatio1
                //red156 green172 blue171 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(287, 38), ruleRatio1
                //red156 green172 blue171 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(274, 58), ruleRatio1
                //red160 green175 blue172 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(280, 58), ruleRatio1
                //red163 green178 blue175 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(272, 77), ruleRatio1
                //red174 green186 blue184 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(299, 38), ruleRatio1
                //red151 green167 blue166 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(306, 59), ruleRatio1
                //red154 green169 blue166 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(313, 59), ruleRatio1
                //red157 green172 blue169 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(316, 76), ruleRatio1
                //red164 green176 blue174 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(310, 79), ruleRatio1
                //red157 green169 blue167 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(292, 63), ruleRatio1
                //red150 green165 blue162 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(307, 72), ruleRatio1
                //red174 green186 blue184 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(283, 76), ruleRatio1
                //red166 green178 blue176 blockNumber3
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(287, 38),
                CoordinatePoint(290, 38),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(313, 59),
                CoordinatePoint(314, 57),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenCaiBigMenuTask by lazy {
        val tag = "isOpenCaiBigMenu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            195, 140, 206, 153, 202, 151,
            1.0F, 0.7944134F, 1.0214673F, 0.7944134F, 1.0906076F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(283, 44), ruleRatio1
                //red157 green176 blue174 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(296, 43), ruleRatio1
                //red156 green176 blue174 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(299, 44), ruleRatio1
                //red157 green176 blue174 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(283, 44), ruleRatio1
                //red157 green176 blue174 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(293, 46), ruleRatio1
                //red158 green177 blue175 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(275, 52), ruleRatio1
                //red163 green178 blue175 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(306, 46), ruleRatio1
                //red158 green177 blue175 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(274, 67), ruleRatio1
                //red164 green179 blue174 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(317, 58), ruleRatio1
                //red165 green177 blue175 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(313, 60), ruleRatio1
                //red169 green184 blue181 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(261, 70), ruleRatio1
                //red167 green179 blue175 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(277, 70), ruleRatio1
                //red175 green190 blue185 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(299, 66), ruleRatio1
                //red172 green184 blue182 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(291, 68), ruleRatio1
                //red166 green181 blue178 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(327, 50), ruleRatio1
                //red162 green177 blue174 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(312, 68), ruleRatio1
                //red170 green181 blue177 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(293, 75), ruleRatio1
                //red176 green188 blue184 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(296, 82), ruleRatio1
                //red171 green183 blue179 blockNumber5
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(296, 43),
                CoordinatePoint(300, 39),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(313, 60),
                CoordinatePoint(316, 62),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(296, 82),
                CoordinatePoint(296, 85),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenWarehouseBigMenuTask by lazy {
        val tag = "isOpenWarehouseBigMenu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            196, 144, 207, 154, 203, 153,
            0.9963068F, 0.8154696F, 1.0254387F, 0.8154696F, 1.0910615F, 0.8947977F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(269, 56), ruleRatio1
                //red167 green179 blue177 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(269, 56), ruleRatio1
                //red167 green179 blue177 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(282, 63), ruleRatio1
                //red160 green175 blue172 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(269, 69), ruleRatio1
                //red175 green190 blue187 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(291, 73), ruleRatio1
                //red178 green190 blue188 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(279, 79), ruleRatio1
                //red170 green182 blue180 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(316, 56), ruleRatio1
                //red165 green180 blue177 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(303, 64), ruleRatio1
                //red167 green182 blue179 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(316, 69), ruleRatio1
                //red175 green190 blue185 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(296, 75), ruleRatio1
                //red180 green192 blue190 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(308, 79), ruleRatio1
                //red173 green184 blue180 blockNumber2
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(316, 56),
                CoordinatePoint(316, 53),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(269, 56),
                CoordinatePoint(267, 56),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    //这个是左边的大图
    private val itemOffset = 465  //X 条目X轴位移
    val item1IsNormalTask by lazy {
        val tag = "item1IsNormal"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            135, 114, 148, 125, 147, 123,
            0.9606383F, 0.82230216F, 0.9744604F, 0.82230216F, 1.0653284F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(614, 324), ruleRatio1
                //red128 green140 blue140 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(614, 324), ruleRatio1
                //red128 green140 blue140 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(642, 325), ruleRatio1
                //red127 green139 blue139 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(627, 338), ruleRatio1
                //red128 green140 blue140 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(626, 342), ruleRatio1
                //red128 green140 blue140 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(614, 357), ruleRatio1
                //red129 green141 blue139 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(642, 357), ruleRatio1
                //red127 green139 blue137 blockNumber5
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(614, 324),
                CoordinatePoint(617, 324),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(626, 342),
                CoordinatePoint(623, 342),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(642, 357),
                CoordinatePoint(639, 357),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsNormalTaskList by lazy {
        arrayOf(
            item1IsNormalTask,
            item1IsNormalTask.copyOffset("item2IsNormal", itemOffset, 0),
            item1IsNormalTask.copyOffset("item3IsNormal", itemOffset * 2, 0)
        )
    }

    val item1ZeroDistanceTask by lazy {
        val tag = "item1ZeroDistance"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            155, 98, 161, 106, 162, 105,
            1.0186567F, 0.8313559F, 1.0111111F, 0.8313559F, 1.0589744F, 0.8784F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(609, 495), ruleRatio1
                //red130 green134 blue137 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 2, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(609, 495), ruleRatio1
                //red130 green134 blue137 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(608, 501), ruleRatio1
                //red147 green153 blue153 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(608, 507), ruleRatio1
                //red147 green153 blue153 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(612, 511), ruleRatio1
                //red116 green122 blue122 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(617, 508), ruleRatio1
                //red119 green125 blue125 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(617, 502), ruleRatio1
                //red118 green127 blue126 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(616, 496), ruleRatio1
                //red115 green121 blue121 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(609, 495),
                CoordinatePoint(609, 493),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(616, 496),
                CoordinatePoint(615, 497),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(612, 511),
                CoordinatePoint(612, 509),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsZeroDistanceList by lazy {
        arrayOf(
            item1ZeroDistanceTask,
            item1ZeroDistanceTask.copyOffset("item2ZeroDistance", itemOffset, 0),
            item1ZeroDistanceTask.copyOffset("item3ZeroDistance", itemOffset * 2, 0)
        )
    }


    val item1OneDistanceTask by lazy {
        val tag = "itemOne1Distance"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            141, 101, 148, 105, 148, 106,
            1.019343F, 0.83720934F, 1.0119566F, 0.83720934F, 1.0582031F, 0.8807143F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(610, 495), ruleRatio1
                //red113 green117 blue118 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(610, 495), ruleRatio1
                //red113 green117 blue118 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(612, 498), ruleRatio1
                //red122 green128 blue128 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(612, 501), ruleRatio1
                //red122 green128 blue128 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(612, 504), ruleRatio1
                //red122 green128 blue128 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(612, 507), ruleRatio1
                //red122 green128 blue128 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(611, 510), ruleRatio1
                //red118 green124 blue124 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(608, 511), ruleRatio1
                //red116 green122 blue122 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(615, 511), ruleRatio1
                //red117 green121 blue122 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(610, 495),
                CoordinatePoint(610, 494),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(612, 507),
                CoordinatePoint(614, 507),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsOneDistanceList by lazy {
        arrayOf(
            item1OneDistanceTask,
            item1OneDistanceTask.copyOffset("itemOne2Distance", itemOffset, 0),
            item1OneDistanceTask.copyOffset("itemOne3Distance", itemOffset * 2, 0)
        )
    }


    //pickUpTask
    val pickUpTaskArea by lazy { ClickArea(566, 623, 449, 72) }
    val pickUp1ItemTask2 by lazy {
        val tag = "pickUpItem"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            212, 111, 238, 139, 234, 135,
            0.9549774F, 0.6975F, 0.95972854F, 0.6975F, 1.094277F, 0.9040909F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(765, 650), ruleRatio1
                //red196 green225 blue221 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(765, 650), ruleRatio1
                //red196 green225 blue221 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(769, 663), ruleRatio1
                //red142 green173 blue168 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(784, 661), ruleRatio1
                //red139 green165 blue162 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(781, 669), ruleRatio1
                //red135 green166 blue161 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(779, 674), ruleRatio1
                //red140 green169 blue165 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(781, 653), ruleRatio1
                //red190 green212 blue209 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(786, 652), ruleRatio1
                //red156 green185 blue181 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(812, 650), ruleRatio1
                //red200 green227 blue222 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(818, 662), ruleRatio1
                //red162 green192 blue190 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(797, 664), ruleRatio1
                //red185 green211 blue208 blockNumber3
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(779, 649),
                CoordinatePoint(779, 647),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(765, 650),
                CoordinatePoint(762, 650),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = pickUpTaskArea
        }
    }

    private val pickUp1ItemTask = MultiImgContainmentTask(arrayOf(pickUp1ItemTask2))
    val pickUpItemList by lazy {
        var i = 0
        val tag = "pickUpItem"
        val task = pickUp1ItemTask
        val offset = itemOffset
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", offset * i, 0),
            task.copyOffset("$tag${++i}", offset * i, 0),
        )
    }


    val refreshTaskArea by lazy { ClickArea(1311, 177, 245, 88) }

    //是否可以刷新任务
    val isCanRefreshTask by lazy {
        val tag = "isCanRefresh"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            189, 135, 201, 142, 197, 140,
            1.0101266F, 0.81377244F, 1.0230769F, 0.81377244F, 1.0818181F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1336, 215), ruleRatio1
                //red160 green175 blue172 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1345, 208), ruleRatio1
                //red155 green171 blue168 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1354, 211), ruleRatio1
                //red151 green167 blue164 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1357, 222), ruleRatio1
                //red154 green166 blue164 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1336, 215), ruleRatio1
                //red160 green175 blue172 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1335, 225), ruleRatio1
                //red168 green183 blue180 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1343, 233), ruleRatio1
                //red169 green181 blue177 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1337, 239), ruleRatio1
                //red160 green169 blue166 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1351, 240), ruleRatio1
                //red158 green167 blue164 blockNumber5
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1345, 208),
                CoordinatePoint(1344, 205),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1335, 225),
                CoordinatePoint(1332, 225),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = refreshTaskArea
        }
    }

    //接取任务 前往的点击区域
    private val isQianWangTask1 by lazy {
        val tag = "isQianWang"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            233, 144, 253, 167, 250, 164,
            0.9759912F, 0.7538071F, 0.9803097F, 0.7538071F, 1.0807316F, 0.90398234F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1751, 899), ruleRatio1
                //red197 green224 blue219 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1751, 899), ruleRatio1
                //red197 green224 blue219 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1770, 903), ruleRatio1
                //red203 green229 blue226 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1781, 899), ruleRatio1
                //red197 green223 blue220 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1792, 899), ruleRatio1
                //red187 green214 blue209 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1788, 913), ruleRatio1
                //red183 green210 blue205 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1798, 913), ruleRatio1
                //red184 green209 blue206 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1793, 916), ruleRatio1
                //red205 green225 blue223 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1781, 906), ruleRatio1
                //red180 green206 blue203 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1748, 908), ruleRatio1
                //red206 green231 blue228 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1747, 924), ruleRatio1
                //red182 green211 blue207 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1768, 908), ruleRatio1
                //red181 green206 blue203 blockNumber6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1764, 924), ruleRatio1
                //red183 green212 blue208 blockNumber6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1762, 909), ruleRatio1
                //red169 green195 blue192 blockNumber7
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1762, 918), ruleRatio1
                //red174 green200 blue197 blockNumber7
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1751, 899),
                CoordinatePoint(1748, 899),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1781, 906),
                CoordinatePoint(1782, 903),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1762, 918),
                CoordinatePoint(1759, 918),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isQianWangTask = MultiImgContainmentTask(arrayOf(isQianWangTask1))

    //点击前往区域
    val qianWangArea by lazy { ClickArea(1583, 853, 378, 109) }

    //点击放弃任务
    val abandonTaskArea by lazy { ClickArea(1733, 197, 225, 79) }


    val endNormalArea by lazy { ClickArea(2088, 332, 115, 111) }

    //右边的正常的图片
    val isEndNormalTask by lazy {
        val tag = "isEndNormal"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            216, 168, 216, 168, 216, 169,
            1.0610526F, 0.89052635F, 1.0611111F, 0.89052635F, 1.0611111F, 0.89047617F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2123, 366), ruleRatio1
                //red191 green193 blue192 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2148, 366), ruleRatio1
                //red194 green192 blue193 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2124, 375), ruleRatio1
                //red205 green203 blue204 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2158, 375), ruleRatio1
                //red203 green203 blue203 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2142, 395), ruleRatio1
                //red198 green200 blue199 blockNumber9
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2126, 404), ruleRatio1
                //red197 green197 blue197 blockNumber14
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2156, 404), ruleRatio1
                //red194 green196 blue195 blockNumber15
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2145, 415), ruleRatio1
                //red190 green192 blue191 blockNumber18
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2138, 365),
                CoordinatePoint(2138, 363),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2142, 395),
                CoordinatePoint(2142, 398),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = endNormalArea
        }
    }
    val isEndNormalList by lazy {
        var i = 0
        val tag = "isEndNormal"
        val task = isEndNormalTask
        val offset = 173
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", 0, offset * i),
            task.copyOffset("$tag${++i}", 0, offset * i),
        )
    }


    val isConfirmDialogTask2 by lazy {
        val tag = "isConfirmDialog"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            238, 177, 255, 196, 254, 193,
            0.98663795F, 0.78451324F, 0.99264705F, 0.78451324F, 1.0785068F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2090, 810), ruleRatio1
                //red197 green226 blue222 blockNumber3
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 20, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2106, 809), ruleRatio1
                //red208 green233 blue230 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2138, 833), ruleRatio1
                //red208 green230 blue227 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2090, 825), ruleRatio1
                //red209 green229 blue227 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2111, 812), ruleRatio1
                //red201 green223 blue221 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2129, 812), ruleRatio1
                //red204 green229 blue225 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2102, 832), ruleRatio1
                //red202 green227 blue224 blockNumber6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2111, 815), ruleRatio1
                //red206 green226 blue224 blockNumber7
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2116, 818), ruleRatio1
                //red211 green232 blue227 blockNumber8
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2128, 834), ruleRatio1
                //red207 green227 blue225 blockNumber9
            )
        )

        pointList.add(
            PointRule(
                CoordinatePoint(2092, 833), ruleRatio1
                //red202 green222 blue220 blockNumber11
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2147, 832), ruleRatio1
                //red210 green230 blue228 blockNumber12
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2106, 809),
                CoordinatePoint(2106, 806),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2111, 815),
                CoordinatePoint(2108, 814),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val confirmDialogEnsureArea by lazy { ClickArea(1960, 762, 317, 120, false) }
    val confirmDialogCancelArea by lazy { ClickArea(1624, 766, 314, 112, false) }

    val isConfirmDialogTask by lazy {
        val isConfirmDialog1Task by lazy {
            val tag = "isConfirmDialog1"
            val pr =
                PointRule(CoordinatePoint(2106, 810), ColorRuleRatioImpl.getSimple(205, 225, 223))
            // sequenceNumber:0 blockNumber: 0  positionType:1
            val findArea = CoordinateArea(2103, 625, 7, 334)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(CoordinatePoint(2102, 817), ColorRuleRatioImpl.getSimple(225, 240, 237))
                // sequenceNumber:8 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2103, 817), ColorRuleRatioImpl.getSimple(215, 231, 228))
                // sequenceNumber:8 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2112, 812), ColorRuleRatioImpl.getSimple(221, 240, 238))
                // sequenceNumber:8 blockNumber: 0  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2103, 823), ColorRuleRatioImpl.getSimple(214, 233, 231))
                // sequenceNumber:16 blockNumber: 0  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2109, 823), ColorRuleRatioImpl.getSimple(220, 239, 235))
                // sequenceNumber:16 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2110, 823), ColorRuleRatioImpl.getSimple(210, 229, 227))
                // sequenceNumber:16 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2116, 822), ColorRuleRatioImpl.getSimple(205, 224, 220))
                // sequenceNumber:16 blockNumber: 0  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2101, 834), ColorRuleRatioImpl.getSimple(193, 215, 212))
                // sequenceNumber:24 blockNumber: 0  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2109, 829), ColorRuleRatioImpl.getSimple(224, 240, 237))
                // sequenceNumber:24 blockNumber: 0  positionType:2
            )
            pointList.add(
                PointRule(CoordinatePoint(2116, 828), ColorRuleRatioImpl.getSimple(212, 228, 227))
                // sequenceNumber:24 blockNumber: 0  positionType:1
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2106, 810),
                    CoordinatePoint(2106, 806),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2110, 823),
                    CoordinatePoint(2113, 820),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                PointRule(CoordinatePoint(2091, 823), ColorRuleRatioImpl.getSimple(224, 240, 239))
                // sequenceNumber:16 blockNumber: 1  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2093, 833), ColorRuleRatioImpl.getSimple(217, 238, 233))
                // sequenceNumber:26 blockNumber: 1  positionType:1
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2090, 810),
                    CoordinatePoint(2090, 807),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2091, 823),
                    CoordinatePoint(2087, 823),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
            )
            FindImgTask(pr, findArea, pointList, tag)
        }

        val isConfirmDialog2Task by lazy {
            val tag = "isConfirmDialog2"

            val pr =
                PointRule(CoordinatePoint(2142, 809), ColorRuleRatioImpl.getSimple(209, 223, 221))
            // sequenceNumber:0 blockNumber: 0  positionType:0
            val findArea = CoordinateArea(2139, 711, 7, 246)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(CoordinatePoint(2142, 815), ColorRuleRatioImpl.getSimple(211, 225, 223))
                // sequenceNumber:8 blockNumber: 0  positionType:0
            )
            pointList.add(
                PointRule(CoordinatePoint(2142, 823), ColorRuleRatioImpl.getSimple(227, 238, 236))
                // sequenceNumber:16 blockNumber: 0  positionType:1
            )
            pointList.add(
                PointRule(CoordinatePoint(2136, 835), ColorRuleRatioImpl.getSimple(213, 226, 224))
                // sequenceNumber:28 blockNumber: 0  positionType:0
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2142, 809),
                    CoordinatePoint(2142, 806),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2142, 823),
                    CoordinatePoint(2139, 823),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
            )
            pointList.add(
                PointRule(CoordinatePoint(2123, 819), ColorRuleRatioImpl.getSimple(212, 226, 223))
                // sequenceNumber:0 blockNumber: 2  positionType:0
            )
            pointList.add(
                PointRule(CoordinatePoint(2129, 821), ColorRuleRatioImpl.getSimple(211, 225, 223))
                // sequenceNumber:8 blockNumber: 2  positionType:0
            )
            pointList.add(
                PointRule(CoordinatePoint(2129, 832), ColorRuleRatioImpl.getSimple(225, 236, 234))
                // sequenceNumber:20 blockNumber: 2  positionType:0
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2123, 819),
                    CoordinatePoint(2123, 816),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2129, 821),
                    CoordinatePoint(2132, 821),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(2129, 832),
                    CoordinatePoint(2126, 832),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                ) // sequenceNumber:20sequenceNumber blockNumber: $2  positionType:$2
            )
            FindImgTask(pr, findArea, pointList, tag)
        }
        MultiFindImgTask(arrayOf(isConfirmDialog1Task, isConfirmDialog2Task))
    }


    val leftDialogArea by lazy { ClickArea(335, 373, 617, 185) }

    //左边的对话框
    val isShowLeftDialogBox by lazy {
        val tag = "isShowLeftDialog"

        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            48, 27, 97, 58, 84, 50,
            0.6211268F, 0.41447368F, 0.70000005F, 0.41447368F, 1.2438462F, 1.0016129F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            56, 37, 160, 95, 135, 81,
            0.45652172F, 0.31176472F, 0.530303F, 0.31176472F, 1.2583333F, 1.040625F
        )
        val ruleRatio3 = ColorRuleRatioImpl.getSimple(
            58, 47, 163, 138, 137, 116,
            0.37692308F, 0.30974028F, 0.44885495F, 0.30974028F, 1.2534883F, 1.0717556F
        )
        val ruleRatio4 = ColorRuleRatioImpl.getSimple(
            42, 24, 67, 43, 59, 39,
            0.72413796F, 0.48571432F, 0.80769235F, 0.48571432F, 1.2115384F, 0.9574468F
        )
        val ruleRatio5 = ColorRuleRatioImpl.getSimple(
            48, 31, 108, 70, 92, 61,
            0.4871134F, 0.35816327F, 0.5762195F, 0.35816327F, 1.242073F, 1.0216217F
        )
        val ruleRatio6 = ColorRuleRatioImpl.getSimple(
            33, 23, 65, 42, 58, 38,
            0.5808511F, 0.45F, 0.6348837F, 0.45F, 1.1886792F, 0.98333335F
        )
        val ruleRatio7 = ColorRuleRatioImpl.getSimple(
            35, 30, 80, 68, 70, 59,
            0.46973684F, 0.3974026F, 0.54090905F, 0.3974026F, 1.2090908F, 1.0343283F
        )
        val ruleRatio8 = ColorRuleRatioImpl.getSimple(
            131, 99, 112, 92, 192, 161,
            1.25F, 0.9699029F, 0.7291666F, 0.9699029F, 0.62765366F, 0.5065574F
        )

        val ruleList = listOf(
            ruleRatio1,
            ruleRatio2,
            ruleRatio3,
            ruleRatio4,
            ruleRatio5,
            ruleRatio6,
            ruleRatio7,
            ruleRatio8
        )

        val correctPositionModel = null
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRules(
                CoordinatePoint(906, 531), ruleList
                //red61 green153 blue130
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(928, 531), ruleList
                //red52 green116 blue100
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(951, 531), ruleList
                //red41 green74 blue67
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val rightDialogArea by lazy { ClickArea(1521, 305, 557, 177) }
    val isShowRightDialogBox by lazy {
        val tag = "isShowRightDialog"

        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            48, 27, 97, 58, 84, 50,
            0.6211268F, 0.41447368F, 0.70000005F, 0.41447368F, 1.2438462F, 1.0016129F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            56, 37, 160, 95, 135, 81,
            0.45652172F, 0.31176472F, 0.530303F, 0.31176472F, 1.2583333F, 1.040625F
        )
        val ruleRatio3 = ColorRuleRatioImpl.getSimple(
            58, 47, 163, 138, 137, 116,
            0.37692308F, 0.30974028F, 0.44885495F, 0.30974028F, 1.2534883F, 1.0717556F
        )
        val ruleRatio4 = ColorRuleRatioImpl.getSimple(
            42, 24, 67, 43, 59, 39,
            0.72413796F, 0.48571432F, 0.80769235F, 0.48571432F, 1.2115384F, 0.9574468F
        )
        val ruleRatio5 = ColorRuleRatioImpl.getSimple(
            48, 31, 108, 70, 92, 61,
            0.4871134F, 0.35816327F, 0.5762195F, 0.35816327F, 1.242073F, 1.0216217F
        )
        val ruleRatio6 = ColorRuleRatioImpl.getSimple(
            33, 23, 65, 42, 58, 38,
            0.5808511F, 0.45F, 0.6348837F, 0.45F, 1.1886792F, 0.98333335F
        )
        val ruleRatio7 = ColorRuleRatioImpl.getSimple(
            35, 30, 80, 68, 70, 59,
            0.46973684F, 0.3974026F, 0.54090905F, 0.3974026F, 1.2090908F, 1.0343283F
        )
        val ruleRatio8 = ColorRuleRatioImpl.getSimple(
            131, 99, 112, 92, 192, 161,
            1.25F, 0.9699029F, 0.7291666F, 0.9699029F, 0.62765366F, 0.5065574F
        )

        val ruleList = listOf(
            ruleRatio1,
            ruleRatio2,
            ruleRatio3,
            ruleRatio4,
            ruleRatio5,
            ruleRatio6,
            ruleRatio7,
            ruleRatio8
        )
        val correctPositionModel = null
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRules(
                CoordinatePoint(2011, 469), ruleList
                //red61 green153 blue130
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(2033, 469), ruleList
                //red52 green116 blue100
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(2058, 469), ruleList
                //red41 green74 blue67
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    //是否可以锁定的按钮 注意这里需要对颜色调整，会有变化范围
    val isCanLockTask by lazy {
        val tag = "isCanLock"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            144, 98, 155, 104, 152, 101,
            1.0418605F, 0.8007353F, 1.1294118F, 0.8007353F, 1.1431452F, 0.9132353F
        )
        val ruleRatio2 = ColorRuleRatioImpl.getSimple(
            150, 121, 160, 127, 156, 119,
            1.0278169F, 0.81543624F, 1.0973684F, 0.81543624F, 1.126087F, 0.9183673F
        )
        val ruleRatio3 = ColorRuleRatioImpl.getSimple(
            239, 201, 195, 162, 161, 134,
            1.3110498F, 1.0994594F, 1.596F, 1.0994594F, 1.3036913F, 1.0705882F
        )

        val ruleList = listOf(ruleRatio1, ruleRatio2, ruleRatio3)

        val list = mutableListOf<PointRule>()

        list.add(
            PointRule(
                CoordinatePoint(1457, 692), ColorRuleImpl.getAllOver(90)
                //red128 green138 blue137
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRules(
                CoordinatePoint(1457, 692), ruleList
                //red116 green125 blue124
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1439, 697), ruleList
                //red126 green132 blue132
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1427, 701), ruleList
                //red122 green128 blue128
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1433, 704), ruleList
                //red130 green139 blue138
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1439, 704), ruleList
                //red119 green128 blue127
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1445, 704), ruleList
                //red116 green122 blue120
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1451, 701), ruleList
                //red116 green120 blue121
            )
        )
        pointList.add(
            PointRules(
                CoordinatePoint(1456, 696), ruleList
                //red129 green135 blue135
            )
        )

        pointList.add(
            TwoPointRule(
                CoordinatePoint(1457, 692),
                CoordinatePoint(1455, 692),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1439, 704),
                CoordinatePoint(1437, 702),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance = 2
        }
    }
    val lockTargetArea by lazy { ClickArea(1391, 640, 96, 96) }


    val bottomDeviceArea by lazy { ClickArea(1643, 952, 92, 88) }
    val isBottomDeviceTask by lazy {
        val tag = "isBottomDevice"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            229, 163, 267, 206, 255, 191,
            0.9125F, 0.7055085F, 0.9462963F, 0.7055085F, 1.1406819F, 0.93333334F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1690, 948), ruleRatio1
                //red199 green237 blue224 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 2, 2, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1690, 948), ruleRatio1
                //red199 green237 blue224 blockNumber1
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = bottomDeviceArea
        }
    }


    val topDeviceArea by lazy { ClickArea(1650, 838, 76, 80) }
    val isTopDeviceTask by lazy {
        val tag = "isTopDevice"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            229, 163, 267, 206, 255, 191,
            0.9125F, 0.7055085F, 0.9462963F, 0.7055085F, 1.1406819F, 0.93333334F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1688, 834), ruleRatio1
                //red198 green242 blue229 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 2, 2, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1688, 834), ruleRatio1
                //red198 green242 blue229 blockNumber1
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = topDeviceArea
        }
    }

    val BottomDeviceOffset = 109
    val topDeviceList by lazy {
        var i = 0
        val tag = "isTopDevice"
        val task = isTopDeviceTask
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
        )
    }

    val bottomDeviceList by lazy {
        var i = 0
        val tag = "isBottomDevice"
        val task = isBottomDeviceTask
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
            task.copyOffset("$tag${++i}", BottomDeviceOffset * i, 0),
        )
    }


    val isBigNormalTask by lazy {
        val tag = "isBigNormal"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            220, 141, 219, 141, 217, 138,
            1.0560694F, 0.88867927F, 1.0772728F, 0.88867927F, 1.0840908F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1086, 567), ruleRatio1
                //red194 green194 blue194 blockNumber3
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1102, 564), ruleRatio1
                //red190 green190 blue190 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1122, 565), ruleRatio1
                //red196 green196 blue196 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1086, 567), ruleRatio1
                //red194 green194 blue194 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1082, 578), ruleRatio1
                //red190 green190 blue190 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1127, 579), ruleRatio1
                //red195 green195 blue193 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1106, 594), ruleRatio1
                //red203 green203 blue201 blockNumber6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1118, 603), ruleRatio1
                //red190 green190 blue188 blockNumber7
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1083, 605), ruleRatio1
                //red191 green191 blue189 blockNumber8
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1093, 612), ruleRatio1
                //red200 green200 blue198 blockNumber9
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1127, 601),
                CoordinatePoint(1132, 601),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //这个是刚进入的 是否存在任务
    val isBigNormalList by lazy {
        var i = 0
        val tag = "isBigNormal"
        val task = isBigNormalTask
        val offset = 171
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", 0, offset * i),
            task.copyOffset("$tag${++i}", 0, offset * i),
        )
    }

    val openWarehouseItemArea by lazy { ClickArea(103, 146, 65, 64) }
    val openJiYuItemArea by lazy { ClickArea(222, 151, 63, 56) }
    val openCaiItemArea by lazy { ClickArea(343, 152, 59, 55) }


    val isNojiYuTask by lazy {
        val tag = "isNojiYu"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            228, 171, 245, 191, 243, 189,
            0.97820514F, 0.7905406F, 0.9909091F, 0.7905406F, 1.0741936F, 0.90775865F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1559, 787), ruleRatio1
                //red192 green217 blue214 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1575, 795), ruleRatio1
                //red204 green226 blue223 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1554, 795), ruleRatio1
                //red212 green232 blue230 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1559, 803), ruleRatio1
                //red203 green228 blue225 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1575, 809), ruleRatio1
                //red209 green231 blue228 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1561, 808), ruleRatio1
                //red191 green213 blue210 blockNumber5
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1569, 786),
                CoordinatePoint(1569, 783),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1559, 803),
                CoordinatePoint(1557, 801),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1564, 808),
                CoordinatePoint(1564, 811),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val goJiyuListMenuArea by lazy { ClickArea(1208, 742, 650, 106) } //前往公告版
    val startJiyuBigArea by lazy { ClickArea(1895, 516, 148, 147) } //这个是打开对话框
    val openJiyuBigArea by lazy { ClickArea(1285, 532, 560, 109) }  //这个是打开可以进行放弃


    private val itemTopOffset = 378  //X 条目X轴位 378
    private val topItemInver = 130
    val topLockTarget by lazy {
        val tag = "topLockTarget"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            227, 131, 228, 126, 231, 126,
            1.2191275F, 0.8484076F, 1.2357142F, 0.8484076F, 1.095092F, 0.88150686F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2198, 39), ruleRatio1
                //red149 green147 blue148 blockNumber10
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2167, 77), ruleRatio1
                //red170 green170 blue170 blockNumber10
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2171, 81), ruleRatio1
                //red149 green148 blue146 blockNumber10
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2198, 39), ruleRatio1
                //red149 green147 blue148 blockNumber10
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2167, 77),
                CoordinatePoint(2232, 93),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val topTargetHpTask by lazy {
        val tag = "topTargetHp"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            232, 132, 221, 130, 220, 129,
            1.1279702F, 0.84303796F, 1.144975F, 0.84303796F, 1.0862069F, 0.88258064F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2155, 98), ruleRatio1
                //red165 green169 blue168 blockNumber2
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()

        pointList.add(
            PointRule(
                CoordinatePoint(2254, 101), ruleRatio1
                //red161 green161 blue159 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2229, 31), ruleRatio1
                //red165 green169 blue170 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2177, 33), ruleRatio1
                //red165 green169 blue168 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2155, 98), ruleRatio1
                //red172 green174 blue173 blockNumber2
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
        HpTaskImpl(pointList, tag, correctPositionModel)
    }

    //这个是关闭右边菜单
    val topLockTargetList1 by lazy {
        var i = 8
        val tag = "topLock1Target"
        val task = topLockTarget
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task
        )
    }

    //这个是打开右边菜单
    val topLockTargetList2 by lazy {
        var i = 8
        val tag = "topLock2Target"
        val task = topLockTarget
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", -itemTopOffset, 0),
        )
    }


    val topTargetHpList1 by lazy {
        var i = 8
        val tag = "topTargetHp1Task"
        val task = topTargetHpTask
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task.copyOffset("$tag${--i}", offset * i, 0),
            task
        )
    }

    val topTargetHpList2 by lazy {
        var i = 8
        val tag = "topTargetHp2Task"
        val task = topTargetHpTask
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", offset * i - itemTopOffset, 0),
            task.copyOffset("$tag${--i}", -itemTopOffset, 0),
        )
    }

    fun getPositionArea(index: Int): ClickArea {
        return ClickArea(431, 425 + (index * 75), 75, 59) //这个是根据2个跳的距离(左边跳转的距离)
    }


    val isUpdateGameT by lazy {
        val tag = "isUpdateGame"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            65, 45, 66, 45, 68, 47,
            1.0333333F, 0.88235295F, 1.0015385F, 0.88235295F, 1.0176923F, 0.8660378F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(841, 343), ruleRatio1
                //red58 green59 blue61 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(841, 343), ruleRatio1
                //red58 green59 blue61 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(844, 347), ruleRatio1
                //red57 green58 blue60 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(849, 343), ruleRatio1
                //red61 green62 blue64 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(853, 343), ruleRatio1
                //red61 green62 blue64 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(857, 343), ruleRatio1
                //red61 green62 blue64 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(855, 354), ruleRatio1
                //red57 green58 blue60 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(861, 343), ruleRatio1
                //red61 green62 blue64 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(841, 343),
                CoordinatePoint(841, 340),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(859, 350),
                CoordinatePoint(863, 350),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val updateGameArea by lazy { ClickArea(1206, 663, 317, 108) }


    val isZeroEnemyTask by lazy {
        val tag = "isZeroEnemy"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            205, 149, 206, 149, 208, 151,
            1.05625F, 0.87931037F, 1.0380682F, 0.87931037F, 1.04467F, 0.8739884F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(818, 705), ruleRatio1
                //red175 green176 blue180 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(818, 705), ruleRatio1
                //red175 green176 blue180 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(826, 708), ruleRatio1
                //red169 green170 blue172 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(827, 717), ruleRatio1
                //red181 green182 blue186 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(825, 726), ruleRatio1
                //red196 green197 blue199 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(816, 725), ruleRatio1
                //red183 green187 blue188 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(815, 716), ruleRatio1
                //red177 green178 blue182 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(818, 705),
                CoordinatePoint(818, 703),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(825, 726),
                CoordinatePoint(825, 728),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOneEnemyTask by lazy {
        val tag = "isOneEnemy"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            217, 141, 218, 142, 222, 145,
            1.0449519F, 0.8789474F, 1.0332446F, 0.8789474F, 1.0442307F, 0.8777778F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(815, 707), ruleRatio1
                //red177 green181 blue184 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(815, 707), ruleRatio1
                //red177 green181 blue184 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(819, 708), ruleRatio1
                //red191 green192 blue196 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(819, 716), ruleRatio1
                //red187 green188 blue192 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(819, 724), ruleRatio1
                //red187 green188 blue192 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(823, 726), ruleRatio1
                //red171 green172 blue176 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(815, 707),
                CoordinatePoint(815, 705),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(819, 716),
                CoordinatePoint(817, 716),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(823, 726),
                CoordinatePoint(823, 724),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isZeroEnemyList by lazy {
        var i = 0
        val tag = "isZeroEnemy"
        val task = isZeroEnemyTask
        val offset = -124
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", offset * i, 0),
            task.copyOffset("$tag${++i}", offset * i, 0),
        )
    }

    val isOneEnemyList by lazy {
        var i = 0
        val tag = "isOneEnemy"
        val task = isOneEnemyTask
        val offset = -124
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", offset * i, 0),
            task.copyOffset("$tag${++i}", offset * i, 0),
        )
    }


    val isOpenGameActivityTask by lazy {
        val tag = "isOpenGameActivity"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1924, 50), ColorRuleRatioImpl.getSimple(255, 254, 250))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 100, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1927, 53), ColorRuleRatioImpl.getSimple(255, 255, 253))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1937, 57), ColorRuleRatioImpl.getSimple(254, 254, 252))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1941, 50), ColorRuleRatioImpl.getSimple(255, 254, 254))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1936, 63), ColorRuleRatioImpl.getSimple(254, 253, 251))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1928, 71), ColorRuleRatioImpl.getSimple(255, 255, 254))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1930, 67), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1941, 76), ColorRuleRatioImpl.getSimple(254, 253, 251))
            // sequenceNumber:38 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1924, 50),
                CoordinatePoint(1924, 46),
                CompareDifferenceRuleImpl.getSimple(20, 20, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1925, 63),
                CoordinatePoint(1925, 60),
                CompareDifferenceRuleImpl.getSimple(15, 20, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1928, 71),
                CoordinatePoint(1923, 71),
                CompareDifferenceRuleImpl.getSimple(15, 20, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenAgreementTask by lazy {
        val tag = "isOpenAgreement"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(355, 42), ColorRuleRatioImpl.getSimple(145, 160, 157)))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(350, 49), ColorRuleRatioImpl.getSimple(158, 172, 172))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(368, 54), ColorRuleRatioImpl.getSimple(163, 178, 175))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(333, 59), ColorRuleRatioImpl.getSimple(145, 157, 155))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(373, 58), ColorRuleRatioImpl.getSimple(165, 181, 178))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(346, 59), ColorRuleRatioImpl.getSimple(157, 172, 169))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(355, 60), ColorRuleRatioImpl.getSimple(159, 173, 173))
            // sequenceNumber:49 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(376, 58),
                CoordinatePoint(376, 54),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(340, 69), ColorRuleRatioImpl.getSimple(147, 159, 157))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(340, 74), ColorRuleRatioImpl.getSimple(146, 161, 158))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(356, 69), ColorRuleRatioImpl.getSimple(162, 178, 175))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(343, 84), ColorRuleRatioImpl.getSimple(160, 176, 173))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(370, 70), ColorRuleRatioImpl.getSimple(166, 180, 180))
            // sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(359, 84), ColorRuleRatioImpl.getSimple(165, 179, 179))
            // sequenceNumber:40 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(368, 86), ColorRuleRatioImpl.getSimple(163, 179, 176))
            // sequenceNumber:49 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(364, 69),
                CoordinatePoint(364, 66),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    //desX:238 desY:0  distance2desX:355 desY:1  distance3
    fun getQuickMenuArea(offset: Int): ClickArea {
        return ClickArea(99 + offset * 118, 141, 72, 72, true)
    }


    val openMenuMenuArea = ClickArea(92, 0, 159, 113, false)

    val openWarehouseMenuArea = ClickArea(508, 419, 176, 173, false)
    val openTaskMenuArea = ClickArea(283, 673, 360, 183, false)
    val openPlanetaryMenuArea = ClickArea(1055, 676, 176, 178, false)
    val openAgreementMenuArea = ClickArea(1055, 418, 177, 177, false)
    val openActivityMenuArea = ClickArea(648, 678, 176, 176, false)


    val isOpenMenuMenu by lazy {
        val tag = "isOpenMenuMenu"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1025, 128), ColorRuleRatioImpl.getSimple(152, 170, 170)))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1034, 131), ColorRuleRatioImpl.getSimple(155, 174, 170))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1026, 132), ColorRuleRatioImpl.getSimple(156, 175, 173))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1042, 138), ColorRuleRatioImpl.getSimple(162, 181, 177))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1020, 139), ColorRuleRatioImpl.getSimple(164, 180, 177))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1042, 148), ColorRuleRatioImpl.getSimple(175, 191, 188))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1016, 148), ColorRuleRatioImpl.getSimple(174, 189, 186))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1033, 154), ColorRuleRatioImpl.getSimple(180, 192, 188))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1023, 158), ColorRuleRatioImpl.getSimple(180, 191, 187))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1042, 151), ColorRuleRatioImpl.getSimple(167, 179, 177))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1038, 158), ColorRuleRatioImpl.getSimple(187, 198, 194))
            // sequenceNumber:57 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1025, 128),
                CoordinatePoint(1025, 124),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1020, 139),
                CoordinatePoint(1024, 139),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1044, 139),
                CoordinatePoint(1049, 139),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1038, 158),
                CoordinatePoint(1038, 161),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:57sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isSpaceStationWarehouseTask by lazy {
        val tag = "isSpaceStationWarehouse"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(163, 153), ColorRuleRatioImpl.getSimple(50, 70, 68)))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(170, 157), ColorRuleRatioImpl.getSimple(55, 81, 80))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(156, 157), ColorRuleRatioImpl.getSimple(53, 82, 78))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(160, 162), ColorRuleRatioImpl.getSimple(55, 81, 78))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(176, 163), ColorRuleRatioImpl.getSimple(37, 57, 55))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(152, 160), ColorRuleRatioImpl.getSimple(54, 83, 79))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(153, 166), ColorRuleRatioImpl.getSimple(50, 76, 73))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(176, 163),
                CoordinatePoint(175, 162),
                CompareDifferenceRuleImpl.getSimple(10, 10, 10)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(164, 173), ColorRuleRatioImpl.getSimple(51, 80, 76))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(160, 179), ColorRuleRatioImpl.getSimple(55, 81, 78))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 180), ColorRuleRatioImpl.getSimple(52, 78, 75))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(176, 180), ColorRuleRatioImpl.getSimple(51, 75, 75))
            // sequenceNumber:21 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(166, 180),
                CoordinatePoint(166, 182),
                CompareDifferenceRuleImpl.getSimple(10, 15, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val switchSpaceStationWarehouseArea = ClickArea(487, 136, 52, 58, false)

    val isCloseSpaceStationWarehouseTask by lazy {
        val tag = "isCloseSpaceStationWarehouseTask"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(516, 151), ColorRuleRatioImpl.getSimple(74, 80, 80)))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(513, 155), ColorRuleRatioImpl.getSimple(75, 81, 81))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(509, 159), ColorRuleRatioImpl.getSimple(74, 79, 82))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(505, 163), ColorRuleRatioImpl.getSimple(74, 79, 82))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(509, 159),
                CoordinatePoint(509, 154),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(512, 170), ColorRuleRatioImpl.getSimple(72, 80, 82))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(516, 176), ColorRuleRatioImpl.getSimple(69, 77, 79))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(516, 176),
                CoordinatePoint(515, 178),
                CompareDifferenceRuleImpl.getSimple(10, 10, 10)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val swipeWarehouseDown = SlidingArea(DirectionType.BOTTOM, CoordinateArea(117, 222, 434, 743))
    val swipeWarehouseTop = SlidingArea(DirectionType.TOP, CoordinateArea(117, 222, 434, 743))
    val isVegetableShipTask by lazy {
        val tag = "isVegetableShip"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(739, 149), ColorRuleRatioImpl.getSimple(124, 125, 127)))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val correctPositionModel = CorrectPositionModel(list, tag, 80, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(735, 156), ColorRuleRatioImpl.getSimple(126, 127, 129))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(742, 156), ColorRuleRatioImpl.getSimple(129, 130, 132))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(728, 158), ColorRuleRatioImpl.getSimple(138, 139, 141))
            // sequenceNumber:18 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(744, 159),
                CoordinatePoint(742, 158),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(735, 159), ColorRuleRatioImpl.getSimple(120, 121, 123))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(744, 159), ColorRuleRatioImpl.getSimple(116, 117, 119))
            // sequenceNumber:12 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(744, 159),
                CoordinatePoint(742, 158),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(740, 169), ColorRuleRatioImpl.getSimple(148, 149, 151))
            // sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(736, 173), ColorRuleRatioImpl.getSimple(119, 121, 120))
            // sequenceNumber:6 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(736, 173),
                CoordinatePoint(736, 171),
                CompareDifferenceRuleImpl.getSimple(20, 30, 20)
            ) // sequenceNumber:6sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(746, 170), ColorRuleRatioImpl.getSimple(134, 135, 137))
            // sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(750, 172), ColorRuleRatioImpl.getSimple(120, 121, 123))
            // sequenceNumber:5 blockNumber: 6  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(750, 172),
                CoordinatePoint(751, 170),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:5sequenceNumber blockNumber: $6  positionType:$6
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isVegetableShipList by lazy {
        val offset = 422
        arrayOf(
            isVegetableShipTask,
            isVegetableShipTask.copyOffset("isVegetableShip1", offset, 0),
            isVegetableShipTask.copyOffset("isVegetableShip2", offset * 2, 0),
            isVegetableShipTask.copyOffset("isVegetableShip2", offset * 3, 0)
        )
    }

    val isVegetable2ShipTask by lazy {
        val tag = "isVegetable2Ship"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(729, 150), ColorRuleRatioImpl.getSimple(134, 136, 136))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 80, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(735, 150), ColorRuleRatioImpl.getSimple(134, 136, 136))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(743, 150), ColorRuleRatioImpl.getSimple(134, 136, 136))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(730, 172), ColorRuleRatioImpl.getSimple(129, 131, 132))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(738, 173), ColorRuleRatioImpl.getSimple(139, 141, 141))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(750, 173), ColorRuleRatioImpl.getSimple(139, 141, 141))
            // sequenceNumber:44 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(729, 150),
                CoordinatePoint(729, 148),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(729, 164),
                CoordinatePoint(731, 164),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(740, 159), ColorRuleRatioImpl.getSimple(152, 153, 153))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(737, 167), ColorRuleRatioImpl.getSimple(130, 132, 132))
            // sequenceNumber:11 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(740, 159),
                CoordinatePoint(742, 157),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(737, 167),
                CoordinatePoint(740, 167),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:11sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(745, 164), ColorRuleRatioImpl.getSimple(122, 123, 124))
            // sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(747, 167), ColorRuleRatioImpl.getSimple(139, 140, 141))
            // sequenceNumber:6 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(745, 164),
                CoordinatePoint(745, 166),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(747, 167),
                CoordinatePoint(745, 167),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:6sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isVegetableShipList2 by lazy {
        val offset = 422
        arrayOf(
            isVegetable2ShipTask,
            isVegetable2ShipTask.copyOffset("isVegetable2Ship1", offset, 0),
            isVegetable2ShipTask.copyOffset("isVegetable2Ship2", offset * 2, 0),
            isVegetable2ShipTask.copyOffset("isVegetable2Ship2", offset * 3, 0)
        )
    }


    val isJiYuTask by lazy {
        val tag = "isJiYu"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(619, 149), ColorRuleRatioImpl.getSimple(125, 126, 128)))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(625, 153), ColorRuleRatioImpl.getSimple(136, 137, 139))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(614, 153), ColorRuleRatioImpl.getSimple(136, 137, 139))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(609, 154), ColorRuleRatioImpl.getSimple(145, 147, 146))
            // sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(614, 153),
                CoordinatePoint(614, 155),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(619, 164), ColorRuleRatioImpl.getSimple(137, 138, 140))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(608, 173), ColorRuleRatioImpl.getSimple(130, 131, 133))
            // sequenceNumber:20 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(619, 164),
                CoordinatePoint(616, 164),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isJiYuShipList by lazy {
        val offset = 418
        arrayOf(
            isJiYuTask,
            isJiYuTask.copyOffset("isJiYu1", offset, 0),
            isJiYuTask.copyOffset("isJiYu2", offset * 2, 0),
            isJiYuTask.copyOffset("isJiYu3", offset * 3, 0)
        )
    }


    val isJiYu2Task by lazy {
        val tag = "is2JiYu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1885, 149), ColorRuleRatioImpl.getSimple(129, 130, 130))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1889, 153), ColorRuleRatioImpl.getSimple(136, 137, 138))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1877, 153), ColorRuleRatioImpl.getSimple(136, 137, 137))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1894, 153), ColorRuleRatioImpl.getSimple(137, 138, 140))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1874, 153), ColorRuleRatioImpl.getSimple(147, 148, 148))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1885, 152), ColorRuleRatioImpl.getSimple(128, 129, 129))
            // sequenceNumber:27 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1894, 153),
                CoordinatePoint(1894, 150),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1885, 157), ColorRuleRatioImpl.getSimple(119, 120, 121))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1884, 164), ColorRuleRatioImpl.getSimple(147, 148, 149))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1886, 164), ColorRuleRatioImpl.getSimple(144, 145, 146))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1874, 173), ColorRuleRatioImpl.getSimple(141, 142, 143))
            // sequenceNumber:21 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1886, 164),
                CoordinatePoint(1889, 164),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(1878, 159), ColorRuleRatioImpl.getSimple(95, 96, 97))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1876, 163), ColorRuleRatioImpl.getSimple(122, 123, 125))
            // sequenceNumber:6 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1876, 163),
                CoordinatePoint(1875, 161),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:6sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(1894, 160), ColorRuleRatioImpl.getSimple(112, 113, 114))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1892, 163), ColorRuleRatioImpl.getSimple(129, 130, 131))
            // sequenceNumber:6 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1892, 163),
                CoordinatePoint(1892, 160),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:6sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isJiYuShip2List by lazy {
        val offset = 418
        arrayOf(
            isJiYu2Task.copyOffset("isJiYu3", -offset * 3, 0),
            isJiYu2Task.copyOffset("isJiYu2", -offset * 2, 0),
            isJiYu2Task.copyOffset("isJiYu1", -offset, 0),
            isJiYu2Task,
        )
    }

    val isActivationLocationTask by lazy {
        val tag = "isActivationLocation"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(621, 368), ColorRuleRatioImpl.getSimple(150, 183, 174)))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(625, 361), ColorRuleRatioImpl.getSimple(137, 171, 157))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(628, 368), ColorRuleRatioImpl.getSimple(147, 180, 171))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(628, 365), ColorRuleRatioImpl.getSimple(142, 174, 163))
            // sequenceNumber:15 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(621, 368),
                CoordinatePoint(618, 368),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(625, 361),
                CoordinatePoint(622, 361),
                CompareDifferenceRuleImpl.getSimple(20, 15, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(628, 368),
                CoordinatePoint(627, 370),
                CompareDifferenceRuleImpl.getSimple(20, 15, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(628, 365),
                CoordinatePoint(630, 364),
                CompareDifferenceRuleImpl.getSimple(20, 15, 20)
            ) // sequenceNumber:15sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isActivationLocationList by lazy {
        val offset = 422
        arrayOf(
            isActivationLocationTask,
            isActivationLocationTask.copyOffset("isActivationLocation1", offset, 0),
            isActivationLocationTask.copyOffset("isActivationLocation2", offset * 2, 0),
            isActivationLocationTask.copyOffset("isActivationLocation3", offset * 3, 0)
        )
    }


    fun getShipArea(offset: Int): ClickArea {
        return ClickArea(596 + offset * 422, 134, 413, 262, false)
    }

    //更改激活的找寻
    val activationShipArea by lazy { ClickArea(1586, 319, 345, 116, false) }
    val isActivationShipTask by lazy {
        val tag = "isActivationShip"
        val pr = PointRule(CoordinatePoint(1774, 389), ColorRuleRatioImpl.getSimple(64, 136, 124))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(607, 194, 1660, 365)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1774, 382), ColorRuleRatioImpl.getSimple(68, 147, 133))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1780, 374), ColorRuleRatioImpl.getSimple(75, 165, 149))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1780, 378), ColorRuleRatioImpl.getSimple(63, 134, 123))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1786, 383), ColorRuleRatioImpl.getSimple(65, 140, 127))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1779, 367), ColorRuleRatioImpl.getSimple(67, 146, 133))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1780, 374), ColorRuleRatioImpl.getSimple(75, 165, 149))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1785, 366), ColorRuleRatioImpl.getSimple(71, 157, 142))
            // sequenceNumber:34 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1786, 383),
                CoordinatePoint(1788, 383),
                CompareDifferenceRuleImpl.getSimple(15, 20, 20)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1766, 367), ColorRuleRatioImpl.getSimple(64, 136, 125))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1767, 367), ColorRuleRatioImpl.getSimple(65, 138, 127))
            // sequenceNumber:5 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1767, 367),
                CoordinatePoint(1767, 365),
                CompareDifferenceRuleImpl.getSimple(15, 30, 20)
            ) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(1764, 375), ColorRuleRatioImpl.getSimple(69, 149, 135))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1766, 376), ColorRuleRatioImpl.getSimple(65, 139, 127))
            // sequenceNumber:5 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1766, 376),
                CoordinatePoint(1766, 374),
                CompareDifferenceRuleImpl.getSimple(15, 20, 20)
            ) // sequenceNumber:5sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(1768, 383), ColorRuleRatioImpl.getSimple(67, 146, 133))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1764, 390), ColorRuleRatioImpl.getSimple(73, 160, 145))
            // sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1764, 390),
                CoordinatePoint(1766, 390),
                CompareDifferenceRuleImpl.getSimple(15, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    fun getCelestialClickArea(offset: Int): ClickArea {
        return if (offset <= 3) {
            ClickArea(102, 193 + offset * 198, 456, 183, false)
        } else if (offset == 4) {
            ClickArea(129, 1001, 387, 77, false)
        } else { //这里其实是等于5
            ClickArea(129, 1001, 387, 77, false)
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

    val celestialClick6Area = ClickArea(129, 1010, 428, 70)


    val addCelestialArea = ClickArea(2100, 158, 102, 95, true)
    val isShowAddCelestialTask by lazy {
        val tag = "isShowAddCelestial"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2127, 203), ColorRuleRatioImpl.getSimple(204, 233, 229)))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(2133, 203), ColorRuleRatioImpl.getSimple(205, 234, 230))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2138, 206), ColorRuleRatioImpl.getSimple(206, 232, 231))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2148, 197), ColorRuleRatioImpl.getSimple(196, 222, 219))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2154, 206), ColorRuleRatioImpl.getSimple(202, 231, 229))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2148, 181), ColorRuleRatioImpl.getSimple(194, 223, 219))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2170, 206), ColorRuleRatioImpl.getSimple(204, 230, 229))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 188), ColorRuleRatioImpl.getSimple(185, 214, 210))
            // sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2163, 203), ColorRuleRatioImpl.getSimple(206, 231, 228))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2155, 203), ColorRuleRatioImpl.getSimple(206, 232, 229))
            // sequenceNumber:71 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2148, 181),
                CoordinatePoint(2145, 181),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(2148, 213), ColorRuleRatioImpl.getSimple(189, 215, 212))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2152, 216), ColorRuleRatioImpl.getSimple(184, 213, 209))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2148, 219), ColorRuleRatioImpl.getSimple(196, 222, 219))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2151, 229), ColorRuleRatioImpl.getSimple(207, 234, 229))
            // sequenceNumber:21 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2148, 219),
                CoordinatePoint(2145, 219),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    var setTargetArea = ClickArea(1923, 903, 355, 115)//行星开采设置终点的位置
    var eraseWarningArea = ClickArea(102, 261, 64, 70)//这里是开始导航的位置


    //发射行星菜滑动区域
    val swipeResourceArea =
        SlidingArea(DirectionType.TOP, CoordinateArea(1539, 322, 736, 574, false))
    val lunchAreaArea = ClickArea(2016, 712, 233, 92, false)
    val findLunchAreaTask by lazy {
        val tag = "findLunchArea"
        val pr = PointRule(CoordinatePoint(2118, 749), ColorRuleRatioImpl.getSimple(198, 223, 220))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(2115, 419, 7, 384)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(2116, 756), ColorRuleRatioImpl.getSimple(218, 234, 231))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2119, 755), ColorRuleRatioImpl.getSimple(198, 218, 216))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2111, 750), ColorRuleRatioImpl.getSimple(195, 220, 217))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2114, 764), ColorRuleRatioImpl.getSimple(219, 238, 234))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2115, 763), ColorRuleRatioImpl.getSimple(224, 240, 237))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2127, 756), ColorRuleRatioImpl.getSimple(188, 213, 210))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2108, 770), ColorRuleRatioImpl.getSimple(182, 204, 201))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2120, 771), ColorRuleRatioImpl.getSimple(209, 229, 227))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2121, 771), ColorRuleRatioImpl.getSimple(224, 240, 237))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2126, 766), ColorRuleRatioImpl.getSimple(194, 219, 215))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2129, 774), ColorRuleRatioImpl.getSimple(185, 210, 207))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2118, 749),
                CoordinatePoint(2118, 746),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2114, 764),
                CoordinatePoint(2112, 762),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2120, 771),
                CoordinatePoint(2116, 771),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    //这里是收菜的一键领取
    val closeOneClickArea by lazy {
        ClickArea(964, 95, 64, 57, true)
    }
    val oneClickClaimArea by lazy {
        ClickArea(344, 882, 682, 105, false)
    }
    val isOneClickClaimTask by lazy {
        val tag = "isOneClickClaim"
        val pr = PointRule(CoordinatePoint(706, 923), ColorRuleRatioImpl.getSimple(190, 208, 205))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(519, 887, 335, 91)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(700, 930), ColorRuleRatioImpl.getSimple(204, 221, 217))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(701, 931), ColorRuleRatioImpl.getSimple(205, 221, 218))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(710, 931), ColorRuleRatioImpl.getSimple(211, 225, 223))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(710, 931), ColorRuleRatioImpl.getSimple(211, 225, 223))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(706, 923),
                CoordinatePoint(708, 923),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(701, 931),
                CoordinatePoint(701, 934),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(710, 931),
                CoordinatePoint(710, 934),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(692, 924), ColorRuleRatioImpl.getSimple(216, 229, 227))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(692, 932), ColorRuleRatioImpl.getSimple(216, 229, 227))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(692, 940), ColorRuleRatioImpl.getSimple(216, 229, 227))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(691, 947), ColorRuleRatioImpl.getSimple(193, 211, 209))
            // sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(692, 924),
                CoordinatePoint(690, 924),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(692, 940),
                CoordinatePoint(690, 940),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(700, 938), ColorRuleRatioImpl.getSimple(220, 232, 230))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(709, 938), ColorRuleRatioImpl.getSimple(212, 225, 223))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(700, 941), ColorRuleRatioImpl.getSimple(193, 212, 209))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(709, 946), ColorRuleRatioImpl.getSimple(191, 210, 207))
            // sequenceNumber:19 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(700, 938),
                CoordinatePoint(698, 938),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(700, 941),
                CoordinatePoint(698, 941),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val closeMaxArea = ClickArea(789, 100, 72, 57, true)   //关闭掉最大的按钮
    val clickMaxConfArea = ClickArea(648, 863, 219, 122, false)//点击最大确定按钮
    val clickMaxArea = ClickArea(802, 418, 54, 35, false)//点击最大部分
    val isShowMaxTask by lazy {
        val tag = "isShowMax"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(238, 136), ColorRuleRatioImpl.getSimple(211, 223, 221))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 10, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(243, 136), ColorRuleRatioImpl.getSimple(211, 223, 221))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(238, 140), ColorRuleRatioImpl.getSimple(211, 224, 221))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(240, 139), ColorRuleRatioImpl.getSimple(211, 223, 220))
            // sequenceNumber:17 blockNumber: 0  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(238, 136),
                CoordinatePoint(238, 132),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(243, 136),
                CoordinatePoint(243, 132),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(238, 140),
                CoordinatePoint(234, 140),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(240, 139),
                CoordinatePoint(245, 140),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:17sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val outSpaceArea = ClickArea(1995, 324, 132, 73, false)

    //仓库点击的约束区域
    val warehouseTypeConstraint = CoordinateArea(113, 210, 448, 754, false)


    val stationGoodsArea by lazy {
        ClickArea(113, 217, 441, 179, false).apply {
            constrainedArea = warehouseTypeConstraint
        }
    }

    val isStationGoodsTask by lazy {
        val tag = "isStationGoods"
        val pr = PointRule(CoordinatePoint(169, 312), ColorRuleRatioImpl.getSimple(173, 190, 184))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(166, 212, 7, 366)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(169, 304), ColorRuleRatioImpl.getSimple(166, 185, 181))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 324), ColorRuleRatioImpl.getSimple(182, 194, 190))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(175, 306), ColorRuleRatioImpl.getSimple(169, 186, 180))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(191, 331), ColorRuleRatioImpl.getSimple(186, 198, 194))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(191, 318), ColorRuleRatioImpl.getSimple(177, 192, 189))
            // sequenceNumber:45 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(175, 306),
                CoordinatePoint(177, 301),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(218, 319), ColorRuleRatioImpl.getSimple(177, 192, 189))
            // sequenceNumber:0 blockNumber: 1  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(222, 313), ColorRuleRatioImpl.getSimple(173, 189, 186))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(202, 330), ColorRuleRatioImpl.getSimple(186, 198, 194))
            // sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(222, 300), ColorRuleRatioImpl.getSimple(165, 180, 177))
            // sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(200, 322), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 314), ColorRuleRatioImpl.getSimple(175, 190, 187))
            // sequenceNumber:44 blockNumber: 1  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(222, 300),
                CoordinatePoint(222, 297),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(170, 290), ColorRuleRatioImpl.getSimple(156, 168, 166))
            // sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(184, 299), ColorRuleRatioImpl.getSimple(157, 172, 169))
            // sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(184, 299),
                CoordinatePoint(184, 296),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            PointRule(CoordinatePoint(215, 294), ColorRuleRatioImpl.getSimple(156, 171, 168))
            // sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(215, 294),
                CoordinatePoint(215, 291),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val isStationGoodsCheckTask by lazy {
        val tag = "isStationGoodsCheck"
        val pr =
            PointRule(CoordinatePoint(192, 277), ColorRuleRatioImpl.getSimple(229, 250, 245))
        // sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(189, 215, 7, 368)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(188, 279), ColorRuleRatioImpl.getSimple(231, 251, 249))
            // sequenceNumber:5 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(188, 279),
                CoordinatePoint(188, 276),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(208, 282), ColorRuleRatioImpl.getSimple(233, 252, 250))
            // sequenceNumber:9 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(208, 282),
                CoordinatePoint(208, 279),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:9sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(170, 290), ColorRuleRatioImpl.getSimple(229, 255, 252))
            // sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(176, 294), ColorRuleRatioImpl.getSimple(234, 254, 252))
            // sequenceNumber:8 blockNumber: 7  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(176, 294),
                CoordinatePoint(176, 290),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(
            PointRule(CoordinatePoint(215, 294), ColorRuleRatioImpl.getSimple(233, 252, 250))
            // sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(206, 299), ColorRuleRatioImpl.getSimple(221, 247, 244))
            // sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(215, 294),
                CoordinatePoint(215, 290),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            PointRule(CoordinatePoint(168, 300), ColorRuleRatioImpl.getSimple(249, 255, 255))
            // sequenceNumber:0 blockNumber: 9  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(169, 304), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:8 blockNumber: 9  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(181, 310), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 9  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(172, 319), ColorRuleRatioImpl.getSimple(255, 253, 254))
            // sequenceNumber:24 blockNumber: 9  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(191, 319), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:32 blockNumber: 9  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(191, 332), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:45 blockNumber: 9  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(172, 319),
                CoordinatePoint(169, 323),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $9  positionType:$9
        )
        pointList.add(
            PointRule(CoordinatePoint(222, 300), ColorRuleRatioImpl.getSimple(249, 255, 255))
            // sequenceNumber:0 blockNumber: 10  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(216, 307), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:8 blockNumber: 10  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(221, 313), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 10  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 315), ColorRuleRatioImpl.getSimple(255, 255, 253))
            // sequenceNumber:24 blockNumber: 10  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(209, 325), ColorRuleRatioImpl.getSimple(254, 254, 254))
            // sequenceNumber:32 blockNumber: 10  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(200, 332), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:42 blockNumber: 10  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(201, 315),
                CoordinatePoint(196, 314),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 302), ColorRuleRatioImpl.getSimple(228, 255, 250))
            // sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(196, 305), ColorRuleRatioImpl.getSimple(231, 253, 250))
            // sequenceNumber:9 blockNumber: 12  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(196, 305),
                CoordinatePoint(196, 303),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:9sequenceNumber blockNumber: $12  positionType:$12
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val stationShipArea by lazy {
        ClickArea(114, 346, 439, 173, false).apply {
            constrainedArea = warehouseTypeConstraint
        }
    }

    val isStationShipTask by lazy {
        val tag = "isStationShip"
        val pr = PointRule(CoordinatePoint(201, 419), ColorRuleRatioImpl.getSimple(159, 178, 174))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(198, 171, 7, 335)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(200, 411), ColorRuleRatioImpl.getSimple(155, 174, 170))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 435), ColorRuleRatioImpl.getSimple(171, 187, 184))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 404), ColorRuleRatioImpl.getSimple(149, 169, 167))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 453), ColorRuleRatioImpl.getSimple(184, 196, 192))
            // sequenceNumber:32 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 451), ColorRuleRatioImpl.getSimple(181, 196, 189))
            // sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 439), ColorRuleRatioImpl.getSimple(173, 190, 184))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 431), ColorRuleRatioImpl.getSimple(168, 184, 181))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 423), ColorRuleRatioImpl.getSimple(164, 180, 177))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(208, 451), ColorRuleRatioImpl.getSimple(181, 196, 189))
            // sequenceNumber:72 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(190, 407), ColorRuleRatioImpl.getSimple(151, 171, 169))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 454), ColorRuleRatioImpl.getSimple(184, 196, 192))
            // sequenceNumber:88 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(225, 447), ColorRuleRatioImpl.getSimple(172, 183, 179))
            // sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(187, 414), ColorRuleRatioImpl.getSimple(157, 176, 172))
            // sequenceNumber:104 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(222, 455), ColorRuleRatioImpl.getSimple(185, 197, 193))
            // sequenceNumber:112 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(211, 455), ColorRuleRatioImpl.getSimple(185, 197, 193))
            // sequenceNumber:120 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 438), ColorRuleRatioImpl.getSimple(173, 190, 184))
            // sequenceNumber:128 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 456), ColorRuleRatioImpl.getSimple(185, 197, 193))
            // sequenceNumber:136 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(181, 451), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:144 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(186, 457), ColorRuleRatioImpl.getSimple(183, 198, 193))
            // sequenceNumber:152 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(165, 448), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:160 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 457), ColorRuleRatioImpl.getSimple(186, 198, 194))
            // sequenceNumber:168 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 452), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:168 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(168, 455), ColorRuleRatioImpl.getSimple(185, 197, 193))
            // sequenceNumber:178 blockNumber: 0  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(201, 419),
                CoordinatePoint(198, 419),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(188, 423),
                CoordinatePoint(185, 423),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:64sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(187, 432),
                CoordinatePoint(185, 429),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:120sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(168, 455),
                CoordinatePoint(169, 450),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:178sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val isStationShipCheckTask by lazy {
        val tag = "isShipWarehouseCheck"
        val pr = PointRule(CoordinatePoint(194, 517), ColorRuleRatioImpl.getSimple(255, 255, 255))
        // sequenceNumber:0 blockNumber: 0  positionType:4
        val findArea = CoordinateArea(191, 206, 7, 372)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(189, 505), ColorRuleRatioImpl.getSimple(252, 255, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 504), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 489), ColorRuleRatioImpl.getSimple(252, 255, 255))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 488), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(190, 473), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 472), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(187, 468), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 467), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 475), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(181, 513), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:104 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(175, 516), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:112 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(218, 517), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:120 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(224, 514), ColorRuleRatioImpl.getSimple(251, 255, 254))
            // sequenceNumber:128 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 520), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:136 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(211, 518), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:152 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(186, 523), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:160 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 523), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:172 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(201, 480),
                CoordinatePoint(198, 482),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(209, 512),
                CoordinatePoint(209, 507),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:112sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(195, 523),
                CoordinatePoint(195, 527),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:172sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    //普通船舱位置
    val shipWarehouseArea by lazy {
        ClickArea(115, 694, 337, 171, false).apply {
            constrainedArea = warehouseTypeConstraint
        }
    }

    //特殊船舱位置
    val specialArea by lazy {
        ClickArea(114, 874, 438, 171, false).apply {
            constrainedArea = warehouseTypeConstraint
        }
    }

    val switchSpecialArea by lazy {
        ClickArea(491, 806, 60, 56, false).apply {
            constrainedArea = warehouseTypeConstraint
        }
    }

    val isShipWarehouseTask by lazy {
        val tag = "isShipWarehouseCheck"
        val pr = PointRule(CoordinatePoint(145, 708), ColorRuleRatioImpl.getSimple(128, 164, 150))
        // sequenceNumber:0 blockNumber: 2  positionType:1
        val findArea = CoordinateArea(142, 210, 7, 710)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(143, 713), ColorRuleRatioImpl.getSimple(146, 179, 168))
            // sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(148, 713), ColorRuleRatioImpl.getSimple(146, 177, 169))
            // sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(143, 714), ColorRuleRatioImpl.getSimple(152, 183, 175))
            // sequenceNumber:19 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(145, 708),
                CoordinatePoint(142, 708),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(143, 713),
                CoordinatePoint(140, 711),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(148, 713),
                CoordinatePoint(152, 713),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(143, 714),
                CoordinatePoint(138, 714),
                CompareDifferenceRuleImpl.getSimple(30, 20, 30)
            ) // sequenceNumber:19sequenceNumber blockNumber: $2  positionType:$2
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    //当前仓库已经选中
    val isShipWarehouseSelectTask by lazy {
        val tag = "isShipWarehouseSelect"

        val pr = PointRule(CoordinatePoint(146, 708), ColorRuleRatioImpl.getSimple(138, 169, 157))
        // sequenceNumber:0 blockNumber: 1  positionType:2
        val findArea = CoordinateArea(142, 214, 7, 715)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(148, 714), ColorRuleRatioImpl.getSimple(149, 179, 171))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(143, 713), ColorRuleRatioImpl.getSimple(147, 179, 169))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(144, 714), ColorRuleRatioImpl.getSimple(153, 181, 175))
            // sequenceNumber:21 blockNumber: 1  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(146, 708),
                CoordinatePoint(142, 708),
                CompareDifferenceRuleImpl.getSimple(20, 10, 10)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(148, 714),
                CoordinatePoint(148, 719),
                CompareDifferenceRuleImpl.getSimple(20, 10, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(143, 713),
                CoordinatePoint(138, 713),
                CompareDifferenceRuleImpl.getSimple(20, 10, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(144, 714),
                CoordinatePoint(144, 719),
                CompareDifferenceRuleImpl.getSimple(20, 10, 15)
            ) // sequenceNumber:21sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)

    }

    val isShipWarehouseTaskList by lazy {
        MultiFindImgTask(
            arrayOf(
                isShipWarehouseTask,
                isShipWarehouseSelectTask
            )
        )
    }

    //这个是判断船的特殊仓库是否已经打开
    val isShipWarehouseCloseTask by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(520, 818), ColorRuleRatioImpl.getSimple(175, 184, 185))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(518, 820), ColorRuleRatioImpl.getSimple(176, 185, 186))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(514, 824), ColorRuleRatioImpl.getSimple(175, 185, 186))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(510, 828), ColorRuleRatioImpl.getSimple(175, 184, 185))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(520, 818),
                CoordinatePoint(520, 813),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(514, 824),
                CoordinatePoint(514, 819),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(517, 837), ColorRuleRatioImpl.getSimple(176, 186, 186))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(521, 840), ColorRuleRatioImpl.getSimple(175, 184, 185))
            // sequenceNumber:9 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(517, 837),
                CoordinatePoint(513, 837),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(521, 840),
                CoordinatePoint(521, 835),
                CompareDifferenceRuleImpl.getSimple(30, 20, 20)
            ) // sequenceNumber:9sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val warehouseSelectAllArea by lazy { ClickArea(1703, 907, 182, 140, false) }

    val isEmptyWarehouseTask by lazy {
        val tag = "isEmptyWarehouse"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1484, 610), ColorRuleRatioImpl.getSimple(43, 63, 61))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1490, 610), ColorRuleRatioImpl.getSimple(42, 61, 59))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1486, 620), ColorRuleRatioImpl.getSimple(42, 62, 60))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1501, 619), ColorRuleRatioImpl.getSimple(43, 65, 62))
            // sequenceNumber:30 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1501, 611),
                CoordinatePoint(1501, 607),
                CompareDifferenceRuleImpl.getSimple(10, 15, 15)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1479, 627), ColorRuleRatioImpl.getSimple(44, 66, 63))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1484, 627), ColorRuleRatioImpl.getSimple(45, 64, 62))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1478, 640), ColorRuleRatioImpl.getSimple(44, 66, 63))
            // sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1488, 638), ColorRuleRatioImpl.getSimple(42, 67, 63))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1489, 629),
                CoordinatePoint(1492, 626),
                CompareDifferenceRuleImpl.getSimple(10, 15, 15)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(1496, 627), ColorRuleRatioImpl.getSimple(44, 64, 62))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1502, 627), ColorRuleRatioImpl.getSimple(46, 66, 64))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1496, 641), ColorRuleRatioImpl.getSimple(42, 62, 60))
            // sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1506, 639), ColorRuleRatioImpl.getSimple(42, 67, 63))
            // sequenceNumber:24 blockNumber: 2  positionType:2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val moveToArea by lazy {
        ClickArea(115, 158, 403, 125, false)
    }
    val isShowMoveToTask by lazy {
        val tag = "isShowMoveTo"
        val pr = PointRule(CoordinatePoint(178, 220), ColorRuleRatioImpl.getSimple(166, 184, 180))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(175, 154, 7, 646)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(178, 212), ColorRuleRatioImpl.getSimple(160, 179, 175))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(175, 226), ColorRuleRatioImpl.getSimple(171, 188, 184))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 205), ColorRuleRatioImpl.getSimple(154, 174, 170))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(167, 226), ColorRuleRatioImpl.getSimple(171, 187, 183))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(177, 212), ColorRuleRatioImpl.getSimple(160, 179, 175))
            // sequenceNumber:24 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(162, 226), ColorRuleRatioImpl.getSimple(171, 188, 184))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(167, 214), ColorRuleRatioImpl.getSimple(161, 180, 177))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(155, 227), ColorRuleRatioImpl.getSimple(148, 162, 159))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(160, 207), ColorRuleRatioImpl.getSimple(154, 173, 169))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(169, 223), ColorRuleRatioImpl.getSimple(168, 185, 181))
            // sequenceNumber:40 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(161, 208), ColorRuleRatioImpl.getSimple(158, 177, 172))
            // sequenceNumber:50 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(178, 220),
                CoordinatePoint(182, 220),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(167, 226),
                CoordinatePoint(167, 230),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(155, 227),
                CoordinatePoint(155, 225),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val moveToStationGoodsArea by lazy { ClickArea(427, 181, 613, 127, false) }
    val moveToStationGoodsTask by lazy {
        val tag = "moveToStationGoods"
        val pr = PointRule(CoordinatePoint(467, 233), ColorRuleRatioImpl.getSimple(147, 165, 162))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(418, 145, 151, 187)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(473, 237), ColorRuleRatioImpl.getSimple(150, 168, 164))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(481, 242), ColorRuleRatioImpl.getSimple(154, 170, 167))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(493, 242), ColorRuleRatioImpl.getSimple(138, 154, 151))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(501, 237), ColorRuleRatioImpl.getSimple(137, 153, 149))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(507, 233), ColorRuleRatioImpl.getSimple(128, 143, 141))
            // sequenceNumber:42 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(493, 242),
                CoordinatePoint(493, 240),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(508, 242), ColorRuleRatioImpl.getSimple(165, 183, 179))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(503, 246), ColorRuleRatioImpl.getSimple(168, 185, 181))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(508, 254), ColorRuleRatioImpl.getSimple(176, 191, 186))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(491, 254), ColorRuleRatioImpl.getSimple(176, 191, 186))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(490, 267), ColorRuleRatioImpl.getSimple(186, 199, 194))
            // sequenceNumber:37 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(508, 254),
                CoordinatePoint(512, 254),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(467, 243), ColorRuleRatioImpl.getSimple(167, 184, 180))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(467, 244), ColorRuleRatioImpl.getSimple(167, 185, 181))
            // sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(482, 253), ColorRuleRatioImpl.getSimple(174, 190, 185))
            // sequenceNumber:16 blockNumber: 2  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(472, 258), ColorRuleRatioImpl.getSimple(179, 193, 188))
            // sequenceNumber:24 blockNumber: 2  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(482, 265), ColorRuleRatioImpl.getSimple(186, 198, 193))
            // sequenceNumber:35 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(482, 253),
                CoordinatePoint(482, 248),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(473, 228), ColorRuleRatioImpl.getSimple(125, 141, 138))
            // sequenceNumber:13 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(473, 228),
                CoordinatePoint(473, 227),
                CompareDifferenceRuleImpl.getSimple(20, 30, 20)
            ) // sequenceNumber:13sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(501, 228), ColorRuleRatioImpl.getSimple(134, 152, 149))
            // sequenceNumber:12 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(501, 228),
                CoordinatePoint(501, 226),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:12sequenceNumber blockNumber: $4  positionType:$4
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    //这个是小米的
     val exitGame1Task by lazy {
        val tag = "exitGame1"
        val pr = PointRule(CoordinatePoint(1352, 849), ColorRuleRatioImpl.getSimple(63, 176, 242))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(1349, 793, 7, 149)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1359, 849), ColorRuleRatioImpl.getSimple(50, 180, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1368, 850), ColorRuleRatioImpl.getSimple(50, 180, 255))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1368, 858), ColorRuleRatioImpl.getSimple(52, 180, 253))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1383, 849), ColorRuleRatioImpl.getSimple(50, 180, 255))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1382, 858), ColorRuleRatioImpl.getSimple(53, 180, 251))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1358, 867), ColorRuleRatioImpl.getSimple(53, 179, 253))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1370, 874), ColorRuleRatioImpl.getSimple(53, 179, 253))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1356, 875), ColorRuleRatioImpl.getSimple(50, 180, 255))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1382, 876), ColorRuleRatioImpl.getSimple(50, 180, 255))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1356, 881), ColorRuleRatioImpl.getSimple(62, 177, 244))
            // sequenceNumber:56 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1377, 886), ColorRuleRatioImpl.getSimple(55, 179, 251))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1352, 849),
                CoordinatePoint(1352, 846),
                CompareDifferenceRuleImpl.getSimple(-30, -20, -10)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1357, 858),
                CoordinatePoint(1357, 854),
                CompareDifferenceRuleImpl.getSimple(-30, -20, -10)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1383, 867),
                CoordinatePoint(1388, 867),
                CompareDifferenceRuleImpl.getSimple(-30, -20, -10)
            ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1384, 883),
                CoordinatePoint(1381, 882),
                CompareDifferenceRuleImpl.getSimple(-30, -20, -10)
            ) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            clickArea = ClickArea(769, 799, 374, 135, false)
        }
    }


    //这个是官方的
     val exitGame2Task by lazy {
        val tag = "exitGame2"
        val pr  = PointRule(CoordinatePoint(1049, 693), ColorRuleRatioImpl.getSimple(188,206,204))
        // sequenceNumber:0 blockNumber: 1  positionType:0
        val findArea = CoordinateArea(1046,638,7,130)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1049, 699), ColorRuleRatioImpl.getSimple(196,213,211))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1043, 704), ColorRuleRatioImpl.getSimple(188,206,204))
            // sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1056, 704), ColorRuleRatioImpl.getSimple(200,216,214))
            // sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1042, 712), ColorRuleRatioImpl.getSimple(190,208,205))
            // sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1055, 712), ColorRuleRatioImpl.getSimple(204,220,216))
            // sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(1054, 718), ColorRuleRatioImpl.getSimple(190,208,205))
            // sequenceNumber:31 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1049, 693),CoordinatePoint(1047, 693), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1056, 704),CoordinatePoint(1058, 704), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(1054, 718),CoordinatePoint(1053, 716), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:31sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(1037, 710), ColorRuleRatioImpl.getSimple(207,222,219))
            // sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(1035, 715), ColorRuleRatioImpl.getSimple(200,217,214))
            // sequenceNumber:7 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(1037, 710),CoordinatePoint(1037, 707), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(TwoPointRule(CoordinatePoint(1035, 715),CoordinatePoint(1032, 715), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:7sequenceNumber blockNumber: $5  positionType:$5
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            clickArea = ClickArea(1214, 654, 313, 107, false)
        }
    }





    val exitGameTask by lazy {
        MultiFindImgTask(arrayOf(exitGame1Task, exitGame2Task))
    }


    //这个是右边菜单的克隆中心
    val cloneCenterArea by lazy {
        ClickArea(2178, 811, 69, 67, false)
    }

    val isCloneCenterTask by lazy {
        val tag = "isCloneCenter"
        val pr = PointRule(CoordinatePoint(2201, 817), ColorRuleRatioImpl.getSimple(150, 169, 167))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(2013, 512, 254, 384)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(2199, 823), ColorRuleRatioImpl.getSimple(154, 170, 169))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(2192, 840), ColorRuleRatioImpl.getSimple(166, 182, 179))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2188, 855), ColorRuleRatioImpl.getSimple(177, 192, 189))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2189, 867), ColorRuleRatioImpl.getSimple(187, 199, 195))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2206, 867), ColorRuleRatioImpl.getSimple(188, 201, 194))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2222, 867), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2237, 860), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2238, 850), ColorRuleRatioImpl.getSimple(172, 187, 184))
            // sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2223, 818), ColorRuleRatioImpl.getSimple(149, 170, 165))
            // sequenceNumber:136 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2222, 867),
                CoordinatePoint(2222, 864),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:80sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(2212, 828), ColorRuleRatioImpl.getSimple(158, 174, 173))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(2218, 831), ColorRuleRatioImpl.getSimple(159, 178, 174))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2217, 832), ColorRuleRatioImpl.getSimple(160, 179, 175))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2206, 841), ColorRuleRatioImpl.getSimple(167, 183, 180))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2207, 842), ColorRuleRatioImpl.getSimple(167, 183, 180))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2219, 841), ColorRuleRatioImpl.getSimple(168, 184, 181))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2210, 847), ColorRuleRatioImpl.getSimple(171, 187, 184))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2204, 857), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2197, 859), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2224, 858), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2228, 859), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(2212, 859), ColorRuleRatioImpl.getSimple(181, 196, 191))
            // sequenceNumber:64 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2210, 847),
                CoordinatePoint(2205, 847),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val clickShipArea by lazy { ClickArea(821, 380, 430, 248, false) }

    val clickLeveShipArea by lazy { ClickArea(937, 405, 219, 200, true) }

    val isOpenShipMenuTask by lazy {
        val tag = "isOpenShipMenu"
        val pr = PointRule(CoordinatePoint(1051, 814), ColorRuleRatioImpl.getSimple(255, 255, 255))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(762, 698, 593, 252)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1046, 816), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1059, 816), ColorRuleRatioImpl.getSimple(252, 250, 251))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1042, 816), ColorRuleRatioImpl.getSimple(248, 247, 245))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1067, 816), ColorRuleRatioImpl.getSimple(255, 253, 254))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1054, 816), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:31 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1051, 814),
                CoordinatePoint(1050, 809),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1042, 816),
                CoordinatePoint(1042, 811),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1023, 829), ColorRuleRatioImpl.getSimple(255, 254, 255))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1038, 831), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1053, 829), ColorRuleRatioImpl.getSimple(250, 249, 247))
            // sequenceNumber:33 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1023, 829),
                CoordinatePoint(1023, 825),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1038, 831),
                CoordinatePoint(1033, 834),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1053, 829),
                CoordinatePoint(1053, 825),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:33sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val isShowLeaveTask by lazy {
        val tag = "isShowLeave"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1046, 471), ColorRuleRatioImpl.getSimple(167, 183, 180))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1052, 476), ColorRuleRatioImpl.getSimple(169, 185, 182))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1031, 483), ColorRuleRatioImpl.getSimple(171, 187, 184))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1063, 486), ColorRuleRatioImpl.getSimple(173, 188, 183))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1030, 495), ColorRuleRatioImpl.getSimple(176, 191, 188))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1063, 502), ColorRuleRatioImpl.getSimple(179, 194, 191))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1034, 509), ColorRuleRatioImpl.getSimple(183, 195, 191))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1046, 505), ColorRuleRatioImpl.getSimple(182, 194, 190))
            // sequenceNumber:60 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1046, 471),
                CoordinatePoint(1046, 466),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1063, 494),
                CoordinatePoint(1059, 494),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1009, 476), ColorRuleRatioImpl.getSimple(167, 182, 179))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1004, 484), ColorRuleRatioImpl.getSimple(172, 188, 185))
            // sequenceNumber:8 blockNumber: 1  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(1005, 488), ColorRuleRatioImpl.getSimple(173, 190, 184))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1001, 496), ColorRuleRatioImpl.getSimple(176, 191, 188))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1005, 504), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1001, 512), ColorRuleRatioImpl.getSimple(182, 197, 192))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1009, 521), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1001, 525), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1025, 521), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:64 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1017, 525), ColorRuleRatioImpl.getSimple(189, 201, 197))
            // sequenceNumber:72 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1041, 521), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:80 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1033, 525), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:88 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1057, 521), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:96 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1049, 525), ColorRuleRatioImpl.getSimple(189, 201, 197))
            // sequenceNumber:104 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1073, 521), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:112 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1065, 525), ColorRuleRatioImpl.getSimple(188, 200, 196))
            // sequenceNumber:120 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1090, 513), ColorRuleRatioImpl.getSimple(184, 196, 192))
            // sequenceNumber:128 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1081, 525), ColorRuleRatioImpl.getSimple(189, 201, 197))
            // sequenceNumber:136 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1090, 497), ColorRuleRatioImpl.getSimple(175, 192, 186))
            // sequenceNumber:144 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1093, 520), ColorRuleRatioImpl.getSimple(187, 199, 195))
            // sequenceNumber:152 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1087, 481), ColorRuleRatioImpl.getSimple(170, 186, 183))
            // sequenceNumber:160 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1093, 504), ColorRuleRatioImpl.getSimple(179, 194, 189))
            // sequenceNumber:168 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1092, 484), ColorRuleRatioImpl.getSimple(173, 189, 186))
            // sequenceNumber:176 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1093, 489), ColorRuleRatioImpl.getSimple(174, 189, 184))
            // sequenceNumber:183 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1009, 476),
                CoordinatePoint(1014, 477),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1041, 525),
                CoordinatePoint(1041, 530),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:96sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val openShipVolume by lazy {
        TwoFingerArea(TwoFingerType.PULL_OPEN, CoordinateArea(692, 16, 1053, 1017, true))
    }

    val closeShipVolume by lazy {
        TwoFingerArea(TwoFingerType.REDUCE_CLOSE, CoordinateArea(692, 16, 1053, 1017, true))
    }


    val clickShip2Area by lazy {
        ClickArea(1058, 425, 266, 261, true)
    }

    val isOpenShipMenu2Task by lazy {
        val tag = "isOpenShipMenu2"
        val pr = PointRule(CoordinatePoint(1144, 858), ColorRuleRatioImpl.getSimple(255, 255, 255))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(880, 740, 521, 239)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1138, 859), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1158, 860), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1144, 858),
                CoordinatePoint(1145, 853),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1138, 859),
                CoordinatePoint(1138, 854),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1115, 873), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1128, 874), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1129, 875), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1144, 872), ColorRuleRatioImpl.getSimple(252, 252, 252))
            // sequenceNumber:32 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1115, 873),
                CoordinatePoint(1115, 870),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1129, 875),
                CoordinatePoint(1129, 870),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val clickSelfExplosionArea by lazy {
        ClickArea(874, 396, 91, 128, false)
    }

    val isShowExplosionTask by lazy {
        val tag = "isShowExplosion"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(868, 406), ColorRuleRatioImpl.getSimple(149, 165, 162))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(867, 416), ColorRuleRatioImpl.getSimple(157, 176, 174))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(867, 420), ColorRuleRatioImpl.getSimple(159, 178, 176))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(869, 428), ColorRuleRatioImpl.getSimple(163, 182, 178))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(861, 439), ColorRuleRatioImpl.getSimple(171, 187, 184))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(869, 436), ColorRuleRatioImpl.getSimple(169, 185, 182))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(855, 446), ColorRuleRatioImpl.getSimple(176, 191, 188))
            // sequenceNumber:40 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(869, 452), ColorRuleRatioImpl.getSimple(177, 192, 187))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(846, 451), ColorRuleRatioImpl.getSimple(178, 193, 190))
            // sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(867, 467), ColorRuleRatioImpl.getSimple(190, 201, 197))
            // sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(849, 451), ColorRuleRatioImpl.getSimple(179, 191, 187))
            // sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(858, 468), ColorRuleRatioImpl.getSimple(189, 200, 196))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(865, 456), ColorRuleRatioImpl.getSimple(182, 197, 192))
            // sequenceNumber:90 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(868, 406),
                CoordinatePoint(871, 406),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(847, 443),
                CoordinatePoint(843, 443),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(865, 456),
                CoordinatePoint(861, 456),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:90sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(886, 450), ColorRuleRatioImpl.getSimple(180, 192, 190))
            // sequenceNumber:5 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(886, 450),
                CoordinatePoint(883, 450),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(892, 467), ColorRuleRatioImpl.getSimple(189, 201, 197))
            // sequenceNumber:6 blockNumber: 5  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(892, 467),
                CoordinatePoint(892, 463),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:6sequenceNumber blockNumber: $5  positionType:$5
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenCloneMenuTask by lazy {
        val tag = "isOpenCloneMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(894, 114), ColorRuleRatioImpl.getSimple(163, 178, 175))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(899, 114), ColorRuleRatioImpl.getSimple(141, 151, 150))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(895, 119), ColorRuleRatioImpl.getSimple(153, 165, 163))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(884, 114), ColorRuleRatioImpl.getSimple(139, 151, 149))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(903, 122), ColorRuleRatioImpl.getSimple(157, 169, 167))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(886, 121), ColorRuleRatioImpl.getSimple(145, 157, 155))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(902, 126), ColorRuleRatioImpl.getSimple(156, 168, 166))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(893, 127), ColorRuleRatioImpl.getSimple(148, 163, 160))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(886, 126), ColorRuleRatioImpl.getSimple(147, 159, 157))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(898, 132), ColorRuleRatioImpl.getSimple(161, 173, 171))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(888, 134), ColorRuleRatioImpl.getSimple(158, 170, 168))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(907, 134), ColorRuleRatioImpl.getSimple(140, 152, 150))
            // sequenceNumber:43 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(894, 114),
                CoordinatePoint(894, 109),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(902, 126),
                CoordinatePoint(900, 124),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(888, 134),
                CoordinatePoint(886, 132),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    fun getCloneClickArea(position: Int): ClickArea {
        return ClickArea(1416, 723 + (122 * (position - 1)), 117, 119, false).apply {
            constrainedArea = CoordinateArea(1375, 418, 179, 576, false)
        }
    }


    val swipeCloneListTArea =
        SlidingArea(DirectionType.TOP, CoordinateArea(916, 261, 504, 680, false))

    val isCloneListTask by lazy {
        val tag = "isCloneList"
        val pr = PointRule(CoordinatePoint(988, 687), ColorRuleRatioImpl.getSimple(65, 119, 111))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(985, 435, 7, 458)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(991, 681), ColorRuleRatioImpl.getSimple(64, 117, 108))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(997, 681), ColorRuleRatioImpl.getSimple(72, 136, 125))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(991, 691), ColorRuleRatioImpl.getSimple(63, 113, 106))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(993, 692), ColorRuleRatioImpl.getSimple(66, 123, 114))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(997, 676), ColorRuleRatioImpl.getSimple(67, 125, 116))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(999, 681), ColorRuleRatioImpl.getSimple(67, 123, 114))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1005, 685), ColorRuleRatioImpl.getSimple(59, 106, 98))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(997, 672), ColorRuleRatioImpl.getSimple(69, 131, 120))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(997, 672), ColorRuleRatioImpl.getSimple(69, 131, 120))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1005, 672), ColorRuleRatioImpl.getSimple(62, 112, 104))
            // sequenceNumber:33 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(988, 687),
                CoordinatePoint(988, 689),
                CompareDifferenceRuleImpl.getSimple(10, 20, 15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(993, 692),
                CoordinatePoint(994, 690),
                CompareDifferenceRuleImpl.getSimple(10, 20, 20)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(989, 676),
                CoordinatePoint(987, 676),
                CompareDifferenceRuleImpl.getSimple(10, 15, 15)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    //活动的菜单位置
    val activityMenuArea by lazy {
        CoordinateArea(144, 184, 381, 768)
    }


    val activityMenuSlideTop by lazy {
        SlidingArea(DirectionType.TOP, activityMenuArea)
    }

    val activityMenuSlideBottom by lazy {
        SlidingArea(DirectionType.BOTTOM, activityMenuArea)
    }

    val supplyMaterialsArea by lazy {
        ClickArea(144, 667, 382, 148, false).apply {
            constrainedArea = activityMenuArea
        }
    }
    val isSupplyMaterialsTask by lazy {
        val tag = "isSupplyMaterialsTask"
        val pr = PointRule(CoordinatePoint(403, 730), ColorRuleRatioImpl.getSimple(101, 100, 103))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(400, 227, 7, 708)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(405, 740), ColorRuleRatioImpl.getSimple(151, 151, 152))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(403, 744), ColorRuleRatioImpl.getSimple(133, 132, 134))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(403, 752), ColorRuleRatioImpl.getSimple(133, 132, 134))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(403, 730),
                CoordinatePoint(401, 730),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(403, 744),
                CoordinatePoint(400, 744),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(393, 731), ColorRuleRatioImpl.getSimple(162, 162, 163))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(388, 735), ColorRuleRatioImpl.getSimple(105, 104, 106))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(396, 738), ColorRuleRatioImpl.getSimple(172, 172, 173))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(390, 745), ColorRuleRatioImpl.getSimple(158, 158, 159))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(394, 745), ColorRuleRatioImpl.getSimple(152, 152, 153))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(393, 752), ColorRuleRatioImpl.getSimple(172, 172, 174))
            // sequenceNumber:23 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(393, 731),
                CoordinatePoint(393, 728),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(390, 745),
                CoordinatePoint(390, 741),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val quickClaimArea by lazy {
        ClickArea(1794, 847, 314, 89, false)
    }

    val isQuickClaimTask by lazy {
        val tag = "isQuickClaim"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(737, 235), ColorRuleRatioImpl.getSimple(255, 255, 253))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(740, 238), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(727, 249), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 239), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(736, 239), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(735, 254), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(772, 239), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(731, 264), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(754, 250), ColorRuleRatioImpl.getSimple(255, 255, 253))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(764, 251), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(733, 275), ColorRuleRatioImpl.getSimple(255, 254, 255))
            // sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(768, 263), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(744, 277), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(767, 264), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:88 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(764, 278), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:96 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(772, 277), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:104 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(764, 283), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:116 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(737, 235),
                CoordinatePoint(732, 231),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(764, 251),
                CoordinatePoint(760, 256),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(738, 262), ColorRuleRatioImpl.getSimple(249, 245, 244))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(738, 262),
                CoordinatePoint(742, 258),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 262), ColorRuleRatioImpl.getSimple(246, 242, 241))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(756, 262),
                CoordinatePoint(759, 257),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val agreementMenuArea by lazy {
        ClickArea(891, 26, 265, 70, false)
    }

    //这个是左上角的任务 这个是判断中间图形
    val isAgreementMenuTask by lazy {
        val tag = "isAgreementMenu"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(539, 280), ColorRuleRatioImpl.getSimple(189, 193, 194))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(540, 285), ColorRuleRatioImpl.getSimple(192, 194, 193))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(543, 288), ColorRuleRatioImpl.getSimple(192, 194, 193))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(548, 296), ColorRuleRatioImpl.getSimple(193, 194, 196))
            // sequenceNumber:21 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(566, 280), ColorRuleRatioImpl.getSimple(188, 189, 191))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(563, 288), ColorRuleRatioImpl.getSimple(192, 193, 195))
            // sequenceNumber:8 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(565, 285), ColorRuleRatioImpl.getSimple(192, 193, 195))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(557, 294), ColorRuleRatioImpl.getSimple(192, 193, 195))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(559, 293), ColorRuleRatioImpl.getSimple(192, 193, 195))
            // sequenceNumber:16 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(556, 299), ColorRuleRatioImpl.getSimple(184, 185, 187))
            // sequenceNumber:23 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(560, 281), ColorRuleRatioImpl.getSimple(165, 170, 173))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(556, 286), ColorRuleRatioImpl.getSimple(174, 178, 179))
            // sequenceNumber:7 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(549, 287),
                CoordinatePoint(552, 283),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(547, 284), ColorRuleRatioImpl.getSimple(178, 180, 179))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(549, 287), ColorRuleRatioImpl.getSimple(180, 181, 183))
            // sequenceNumber:7 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(549, 287),
                CoordinatePoint(552, 283),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val protocolChallengesArea by lazy {
        ClickArea(326, 493, 304, 121, false)
    }


    val isProtocolChallengesTasks by lazy {
        val tag = "isProtocolChallenges"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(617, 505), ColorRuleRatioImpl.getSimple(255,42,63))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(616, 511), ColorRuleRatioImpl.getSimple(254,42,64))
            // sequenceNumber:14 blockNumber: 0  positionType:2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val agreementWeekArea by lazy {
        ClickArea(1634, 810, 96, 95, false)
    }

    val isAgreementWeekTask by lazy {
        val tag = "isAgreementWeek"
        val pr = PointRule(CoordinatePoint(1713, 821), ColorRuleRatioImpl.getSimple(254, 42, 63))
        // sequenceNumber:0 blockNumber: 0  positionType:3
        val findArea = CoordinateArea(783, 818, 942, 7)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1718, 821), ColorRuleRatioImpl.getSimple(253, 42, 63))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(1711, 824), ColorRuleRatioImpl.getSimple(254, 42, 63))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1716, 828), ColorRuleRatioImpl.getSimple(255, 43, 65))
            // sequenceNumber:19 blockNumber: 0  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1713, 821),
                CoordinatePoint(1711, 816),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1718, 821),
                CoordinatePoint(1718, 816),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1711, 824),
                CoordinatePoint(1706, 822),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1716, 828),
                CoordinatePoint(1718, 833),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:19sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val agreementChallengesClickArea by lazy {
        ClickArea(1802, 426, 262, 113, false)
    }

    val isAgreementChallengesClickTask by lazy {
        val tag = "isAgreementChallengesClick"
        val pr = PointRule(CoordinatePoint(1951, 471), ColorRuleRatioImpl.getSimple(180, 188, 192))
        // sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(1948, 445, 7, 324)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1954, 475), ColorRuleRatioImpl.getSimple(181, 188, 192))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1943, 475), ColorRuleRatioImpl.getSimple(180, 188, 192))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1951, 481), ColorRuleRatioImpl.getSimple(197, 203, 206))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1951, 485), ColorRuleRatioImpl.getSimple(182, 189, 193))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1952, 494), ColorRuleRatioImpl.getSimple(195, 201, 204))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1945, 494), ColorRuleRatioImpl.getSimple(184, 191, 195))
            // sequenceNumber:40 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1951, 471),
                CoordinatePoint(1949, 471),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1951, 481),
                CoordinatePoint(1949, 479),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1940, 481),
                CoordinatePoint(1940, 479),
                CompareDifferenceRuleImpl.getSimple(20, 15, 15)
            ) // sequenceNumber:32sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1961, 486),
                CoordinatePoint(1961, 485),
                CompareDifferenceRuleImpl.getSimple(15, 15, 15)
            ) // sequenceNumber:52sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val openGiftArea by lazy {
        ClickArea(110, 516, 64, 64, true)
    }
    val closeGiftArea by lazy {
        ClickArea(1905, 153, 56, 55, true)
    }


    val freeDailyGiftArea by lazy { ClickArea(441, 723, 336, 53, false) }
    val isFreeDailyGiftTask by lazy {
        val tag = "isFreeDailyGift"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(592, 740), ColorRuleRatioImpl.getSimple(133, 109, 63))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(595, 741), ColorRuleRatioImpl.getSimple(136, 112, 66))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(595, 741),
                CoordinatePoint(595, 739),
                CompareDifferenceRuleImpl.getSimple(-20, -15, -10)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(607, 748), ColorRuleRatioImpl.getSimple(141, 115, 64))
            // sequenceNumber:0 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(607, 751), ColorRuleRatioImpl.getSimple(140, 116, 68))
            // sequenceNumber:5 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(607, 751),
                CoordinatePoint(608, 751),
                CompareDifferenceRuleImpl.getSimple(-20, -15, -15)
            ) // sequenceNumber:5sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(588, 755), ColorRuleRatioImpl.getSimple(145, 118, 63))
            // sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(591, 755), ColorRuleRatioImpl.getSimple(129, 106, 62))
            // sequenceNumber:5 blockNumber: 7  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(591, 755),
                CoordinatePoint(591, 756),
                CompareDifferenceRuleImpl.getSimple(-15, -15, -15)
            ) // sequenceNumber:5sequenceNumber blockNumber: $7  positionType:$7
        )
        pointList.add(
            PointRule(CoordinatePoint(602, 755), ColorRuleRatioImpl.getSimple(129, 106, 65))
            // sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(608, 762), ColorRuleRatioImpl.getSimple(145, 115, 63))
            // sequenceNumber:12 blockNumber: 8  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(608, 762),
                CoordinatePoint(609, 762),
                CompareDifferenceRuleImpl.getSimple(-15, -15, -15)
            ) // sequenceNumber:12sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            PointRule(CoordinatePoint(588, 760), ColorRuleRatioImpl.getSimple(137, 113, 67))
            // sequenceNumber:0 blockNumber: 9  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(586, 763), ColorRuleRatioImpl.getSimple(148, 120, 70))
            // sequenceNumber:6 blockNumber: 9  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(586, 763),
                CoordinatePoint(586, 764),
                CompareDifferenceRuleImpl.getSimple(-15, -15, -15)
            ) // sequenceNumber:6sequenceNumber blockNumber: $9  positionType:$9
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val closeGiftV2Area by lazy {
        ClickArea(1920, 98, 60, 58, true)
    }
    val openGiftV2Area by lazy {
        ClickArea(1795, 147, 65, 61, true)
    }

    val isOpenGiftV2Task by lazy {
        val tag = "isOpenGiftV2"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(592, 114), ColorRuleRatioImpl.getSimple(209, 205, 202))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(592, 123), ColorRuleRatioImpl.getSimple(207, 204, 199))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(605, 114), ColorRuleRatioImpl.getSimple(209, 205, 202))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(610, 123), ColorRuleRatioImpl.getSimple(207, 206, 202))
            // sequenceNumber:30 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(592, 114),
                CoordinatePoint(592, 111),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(605, 114),
                CoordinatePoint(605, 111),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(586, 132), ColorRuleRatioImpl.getSimple(205, 201, 198))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(592, 132), ColorRuleRatioImpl.getSimple(205, 201, 198))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(587, 145), ColorRuleRatioImpl.getSimple(212, 211, 209))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(586, 132),
                CoordinatePoint(586, 129),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(586, 137),
                CoordinatePoint(589, 137),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(587, 145),
                CoordinatePoint(582, 145),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(605, 132), ColorRuleRatioImpl.getSimple(205, 201, 200))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(611, 132), ColorRuleRatioImpl.getSimple(205, 201, 198))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(607, 132), ColorRuleRatioImpl.getSimple(205, 201, 200))
            // sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(616, 134), ColorRuleRatioImpl.getSimple(211, 207, 206))
            // sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(606, 145), ColorRuleRatioImpl.getSimple(212, 211, 209))
            // sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(615, 145), ColorRuleRatioImpl.getSimple(212, 211, 209))
            // sequenceNumber:27 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(605, 132),
                CoordinatePoint(605, 129),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(616, 134),
                CoordinatePoint(620, 134),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val canGiftV2Area by lazy {
        ClickArea(1634, 881, 349, 91, false)
    }

    val isCanGiftV2Task by lazy {
        val tag = "isCanGiftV2"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1756, 929), ColorRuleRatioImpl.getSimple(116, 94, 57))
            // sequenceNumber:0 blockNumber: 3  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1762, 929), ColorRuleRatioImpl.getSimple(117, 93, 57))
            // sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1774, 929), ColorRuleRatioImpl.getSimple(117, 93, 57))
            // sequenceNumber:20 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1756, 929),
                CoordinatePoint(1756, 930),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1762, 929),
                CoordinatePoint(1762, 930),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -15)
            ) // sequenceNumber:8sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1774, 929),
                CoordinatePoint(1774, 930),
                CompareDifferenceRuleImpl.getSimple(-20, -20, -15)
            ) // sequenceNumber:20sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val canGiftV3Area by lazy {
        ClickArea(446, 122, 1545, 918, false)
    }

    val isCanGiftV3Task by lazy {
        val tag = "isCanGiftV3"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1117, 400), ColorRuleRatioImpl.getSimple(252, 255, 255))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1122, 400), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1130, 400), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1144, 401), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1137, 415), ColorRuleRatioImpl.getSimple(254, 255, 255))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1121, 415), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1118, 409), ColorRuleRatioImpl.getSimple(254, 255, 253))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1119, 414), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1123, 433), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1138, 433), ColorRuleRatioImpl.getSimple(254, 255, 253))
            // sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1149, 429), ColorRuleRatioImpl.getSimple(255, 255, 255))
            // sequenceNumber:122 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1117, 400),
                CoordinatePoint(1117, 396),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1137, 415),
                CoordinatePoint(1137, 410),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //这个判断际遇任务全部完成了
    val isCompleteAllTask by lazy {
        val tag = "isCompleteAll"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1001, 213), ColorRuleRatioImpl.getSimple(162, 45, 67))
            // sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1006, 221), ColorRuleRatioImpl.getSimple(157, 45, 65))
            // sequenceNumber:14 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1001, 213),
                CoordinatePoint(1000, 211),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1006, 221),
                CoordinatePoint(1011, 220),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:14sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(1004, 233), ColorRuleRatioImpl.getSimple(155, 44, 64))
            // sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1007, 233), ColorRuleRatioImpl.getSimple(153, 44, 63))
            // sequenceNumber:5 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1004, 233),
                CoordinatePoint(1004, 234),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1007, 233),
                CoordinatePoint(1007, 234),
                CompareDifferenceRuleImpl.getSimple(30, 10, 15)
            ) // sequenceNumber:5sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val isCloseAiTask by lazy {
        val tag = "isCloseAi"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(1897, 834), ColorRuleRatioImpl.getSimple(73, 74, 69))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1905, 832), ColorRuleRatioImpl.getSimple(69, 64, 60))
            // sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(1890, 835), ColorRuleRatioImpl.getSimple(74, 70, 67))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1913, 834), ColorRuleRatioImpl.getSimple(75, 74, 70))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(1923, 837), ColorRuleRatioImpl.getSimple(77, 73, 70))
            // sequenceNumber:26 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1897, 834),
                CoordinatePoint(1897, 837),
                CompareDifferenceRuleImpl.getSimple(15, 15, 10)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1905, 832),
                CoordinatePoint(1905, 836),
                CompareDifferenceRuleImpl.getSimple(10, 10, 10)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1890, 835),
                CoordinatePoint(1891, 838),
                CompareDifferenceRuleImpl.getSimple(15, 10, 10)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1913, 834),
                CoordinatePoint(1913, 837),
                CompareDifferenceRuleImpl.getSimple(15, 15, 10)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1923, 837),
                CoordinatePoint(1922, 840),
                CompareDifferenceRuleImpl.getSimple(15, 15, 10)
            ) // sequenceNumber:26sequenceNumber blockNumber: $0  positionType:$0
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val hasXiaoTipsTask by lazy {
        val tag = "hasXiaoTips"
        val pr = PointRule(CoordinatePoint(1682, 166), ColorRuleRatioImpl.getSimple(210, 217, 236))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(1553, 79, 280, 226)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(1687, 170), ColorRuleRatioImpl.getSimple(210, 217, 236))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1699, 176), ColorRuleRatioImpl.getSimple(211, 216, 235))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1694, 178), ColorRuleRatioImpl.getSimple(212, 217, 237))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1707, 168), ColorRuleRatioImpl.getSimple(211, 216, 235))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1687, 188), ColorRuleRatioImpl.getSimple(213, 216, 235))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1689, 186), ColorRuleRatioImpl.getSimple(213, 216, 235))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1697, 178), ColorRuleRatioImpl.getSimple(211, 216, 235))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1702, 186), ColorRuleRatioImpl.getSimple(214, 216, 237))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(1708, 167), ColorRuleRatioImpl.getSimple(211, 216, 235))
            // sequenceNumber:34 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1682, 166),
                CoordinatePoint(1679, 166),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1694, 178),
                CoordinatePoint(1690, 178),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1689, 186),
                CoordinatePoint(1689, 182),
                CompareDifferenceRuleImpl.getSimple(30, 30, 20)
            ) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1708, 167),
                CoordinatePoint(1708, 163),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:34sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea, pointList, tag).apply {
            clickArea = ClickArea(1648, 133, 96, 92, true)
        }
    }
}