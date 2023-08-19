package com.nwq.function.scheduling.executer.star_wars


import com.nwq.function.scheduling.executer.area.CoordinateArea
import com.nwq.function.scheduling.executer.area.CoordinatePoint
import com.nwq.function.scheduling.executer.img.pcheck.IPR
import com.nwq.function.scheduling.executer.img.pcheck.PointRule
import com.nwq.function.scheduling.executer.img.pcheck.PointRules
import com.nwq.function.scheduling.executer.img.pcheck.TwoPointRule
import com.nwq.function.scheduling.executer.img.rule.ColorRuleImpl
import com.nwq.function.scheduling.executer.img.rule.ColorRuleRatioImpl
import com.nwq.function.scheduling.executer.img.rule.CompareDifferenceRuleImpl
import com.nwq.function.scheduling.executer.img.task.*

object StarWarEnvironmentK30 {

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
    val closeAnnouncementArea by lazy { CoordinateArea(1917, 90, 70, 67) }


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
    val isStartGameArea by lazy { CoordinateArea(1002, 758, 419, 147) }


    val isSelectRoleT by lazy {
        val tag = "isSelectRole"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            163, 135, 163, 135, 165, 135,
            1.05F, 0.9F, 1.0637255F, 0.9F, 1.0637255F, 0.88846153F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(524, 595), ruleRatio1
                //red155 green155 blue157 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(524, 595), ruleRatio1
                //red155 green155 blue157 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(535, 595), ruleRatio1
                //red155 green155 blue155 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(524, 606), ruleRatio1
                //red155 green155 blue157 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(546, 595), ruleRatio1
                //red155 green155 blue155 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(532, 612), ruleRatio1
                //red154 green154 blue154 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(543, 612), ruleRatio1
                //red154 green154 blue154 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(537, 599), ruleRatio1
                //red155 green155 blue155 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(552, 609), ruleRatio1
                //red155 green155 blue155 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(540, 608), ruleRatio1
                //red155 green155 blue155 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(544, 602), ruleRatio1
                //red155 green155 blue155 blockNumber2
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(524, 595),
                CoordinatePoint(522, 595),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(543, 612),
                CoordinatePoint(543, 614),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val selectRoleArea by lazy { CoordinateArea(543, 313, 241, 263) }

    val isClosePositionMenuT by lazy {
        val tag = "isClosePositionMenuT"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            165, 115, 171, 123, 175, 124,
            1.05F, 0.8347826F, 1.05F, 0.8347826F, 1.0576087F, 0.87039477F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(127, 295), ruleRatio1
                //red133 green142 blue141 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(134, 307), ruleRatio1
                //red158 green163 blue167 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(131, 303), ruleRatio1
                //red142 green147 blue150 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(129, 299), ruleRatio1
                //red139 green148 blue147 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(139, 304), ruleRatio1
                //red148 green153 blue157 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(141, 300), ruleRatio1
                //red150 green154 blue157 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(143, 296), ruleRatio1
                //red145 green145 blue147 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(133, 296), ruleRatio1
                //red142 green147 blue150 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(137, 296), ruleRatio1
                //red144 green147 blue152 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(141, 300),
                CoordinatePoint(145, 300),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(134, 307),
                CoordinatePoint(130, 307),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openPositionArea by lazy { CoordinateArea(96, 258, 80, 77) }


    val isOpenPositionMenuT by lazy {
        val tag = "isOpenPosition"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            164, 117, 170, 122, 174, 123,
            1.05F, 0.8383562F, 1.05F, 0.8383562F, 1.0576643F, 0.8707792F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(485, 294), ruleRatio1
                //red133 green142 blue141 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(495, 302), ruleRatio1
                //red157 green161 blue164 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(497, 298), ruleRatio1
                //red148 green148 blue148 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(493, 306), ruleRatio1
                //red146 green149 blue154 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(499, 294), ruleRatio1
                //red142 green142 blue142 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(490, 310), ruleRatio1
                //red138 green146 blue148 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(499, 290), ruleRatio1
                //red137 green137 blue137 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(488, 306), ruleRatio1
                //red152 green155 blue160 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(486, 302), ruleRatio1
                //red149 green154 blue157 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(489, 296), ruleRatio1
                //red144 green148 blue151 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(484, 298), ruleRatio1
                //red141 green151 blue152 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(495, 302),
                CoordinatePoint(498, 302),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(488, 306),
                CoordinatePoint(484, 306),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
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
            val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 186,129,156,110,48,31,
                1.2732284F,0.99642855F,4.6576924F,0.99642855F,4.11F, 2.809756F)

            val list = mutableListOf<PointRule>()
            list.add(
                PointRule(
                    CoordinatePoint(2039, 353), ruleRatio1
                    //red159 green137 blue51 blockNumber4
                )
            )
            val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(PointRule(CoordinatePoint(2039, 353), ruleRatio1
                //red173 green146 blue41 blockNumber1
            ))
            pointList.add(PointRule(CoordinatePoint(2071, 351), ruleRatio1
                //red170 green145 blue44 blockNumber2
            ))
            pointList.add(PointRule(CoordinatePoint(2101, 351), ruleRatio1
                //red174 green147 blue40 blockNumber3
            ))
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }

        MultiImgContainmentTask(arrayOf(isInSpaceStationT1,isInSpaceStationT2))
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
    val closeBigMenuArea by lazy { CoordinateArea(2185, 27, 78, 73) }


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
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            185, 150, 185, 150, 185, 150,
            1.0625749F, 0.8893491F, 1.0625749F, 0.8893491F, 1.0625749F, 0.8895349F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(2222, 610), ruleRatio1
                //red169 green169 blue169 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2245, 609), ruleRatio1
                //red169 green169 blue169 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2242, 612), ruleRatio1
                //red170 green170 blue170 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2238, 614), ruleRatio1
                //red171 green171 blue171 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2234, 614), ruleRatio1
                //red176 green176 blue176 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2230, 614), ruleRatio1
                //red176 green176 blue176 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2226, 613), ruleRatio1
                //red169 green169 blue169 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2222, 610), ruleRatio1
                //red169 green169 blue169 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2245, 609),
                CoordinatePoint(2241, 606),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(2234, 614),
                CoordinatePoint(2234, 611),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openEyeMenuArea by lazy { CoordinateArea(2197, 568, 75, 77) }




    val isOpenEyeMenuT by lazy {
        val isOpenEyeMenuT1 by lazy {
            val tag = "isOpenEyeMenu"
            val ruleRatio1 = ColorRuleRatioImpl.getSimple(
                185, 152, 185, 152, 185, 152,
                1.05F, 0.9F, 1.05F, 0.9F, 1.05F, 0.9F
            )
            val list = mutableListOf<PointRule>()
            list.add(
                PointRule(
                    CoordinatePoint(1752, 609), ruleRatio1
                    //red170 green170 blue170 blockNumber1
                )
            )
            val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(
                PointRule(
                    CoordinatePoint(1752, 609), ruleRatio1
                    //red170 green170 blue170 blockNumber1
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(1764, 614), ruleRatio1
                    //red176 green176 blue176 blockNumber1
                )
            )
            pointList.add(
                PointRule(
                    CoordinatePoint(1776, 609), ruleRatio1
                    //red169 green169 blue169 blockNumber1
                )
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(1752, 609),
                    CoordinatePoint(1756, 608),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                )
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(1764, 614),
                    CoordinatePoint(1764, 611),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                )
            )
            pointList.add(
                TwoPointRule(
                    CoordinatePoint(1776, 609),
                    CoordinatePoint(1777, 614),
                    CompareDifferenceRuleImpl.getSimple(30, 30, 30)
                )
            )
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }



        val isOpenEyeMenuT2 by lazy {
            val tag = "isOpenEyeMenu"
            val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 186,151,186,151,186,149,
                1.062426F,0.9F,1.0626507F,0.9F,1.0626507F, 0.89470583F)
            val list = mutableListOf<PointRule>()
            list.add(PointRule(CoordinatePoint(1843, 609), ruleRatio1
                //red168 green168 blue168 blockNumber1
            ))
            val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
            val pointList = mutableListOf<IPR>()
            pointList.add(PointRule(CoordinatePoint(1843, 609), ruleRatio1
                //red168 green168 blue168 blockNumber1
            ))
            pointList.add(PointRule(CoordinatePoint(1855, 614), ruleRatio1
                //red176 green176 blue176 blockNumber1
            ))
            pointList.add(PointRule(CoordinatePoint(1867, 609), ruleRatio1
                //red169 green169 blue169 blockNumber1
            ))
            pointList.add(TwoPointRule(CoordinatePoint(1843, 609),CoordinatePoint(1848, 607), CompareDifferenceRuleImpl.getSimple(30,30,30)))
            pointList.add(TwoPointRule(CoordinatePoint(1867, 609),CoordinatePoint(1862, 609), CompareDifferenceRuleImpl.getSimple(30,30,30)))
            pointList.add(TwoPointRule(CoordinatePoint(1855, 614),CoordinatePoint(1855, 611), CompareDifferenceRuleImpl.getSimple(30,30,30)))
            ImgTaskImpl1(pointList, tag, correctPositionModel)
        }

        MultiImgContainmentTask(arrayOf(isOpenEyeMenuT2,isOpenEyeMenuT1))
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
    val openGiftMenuArea by lazy { CoordinateArea(115, 516, 61, 65) }


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
    val openCollectGiftArea by lazy { CoordinateArea(442, 723, 335, 60) }
    val closeCollectGiftArea by lazy { CoordinateArea(1902, 150, 60, 63) }

    val collectChipMenuArea by lazy { CoordinateArea(1797, 153, 61, 57) }


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
    val CollectChipArea by lazy { CoordinateArea(1635, 881, 347, 89) }
    val CloseCollectChipMenuArea by lazy { CoordinateArea(1922, 97, 58, 64) } //未点击一件领取点这里关闭
    val hasTakeArea by lazy { CoordinateArea(816, 483, 766, 508) } //点击了一键领取点击这里关闭


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
    val pickUpTaskArea by lazy { CoordinateArea(566, 623, 449, 72) }
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


    val refreshTaskArea by lazy { CoordinateArea(1311, 177, 245, 88) }

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
    val qianWangArea by lazy { CoordinateArea(1583, 853, 378, 109) }

    //点击放弃任务
    val abandonTaskArea by lazy { CoordinateArea(1733, 197, 225, 79) }


    val endNormalArea by lazy { CoordinateArea(2088, 332, 115, 111) }

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


    val isConfirmDialogTask = MultiImgContainmentTask(arrayOf(isConfirmDialogTask2))

    val confirmDialogEnsureArea by lazy { CoordinateArea(1960, 761, 318, 120) }
    val confirmDialogCancelArea by lazy { CoordinateArea(622, 767, 316, 108) }


    val leftDialogArea by lazy { CoordinateArea(335, 373, 617, 185) }

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

    val rightDialogArea by lazy { CoordinateArea(1521, 305, 557, 177) }
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
    val lockTargetArea by lazy { CoordinateArea(1391, 640, 96, 96) }


    val bottomDeviceArea by lazy { CoordinateArea(1643, 952, 92, 88) }
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


    val topDeviceArea by lazy { CoordinateArea(1650, 838, 76, 80) }
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

    val openWarehouseItemArea by lazy { CoordinateArea(103, 146, 65, 64) }
    val openJiYuItemArea by lazy { CoordinateArea(222, 151, 63, 56) }
    val openCaiItemArea by lazy { CoordinateArea(343, 152, 59, 55) }


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


    val goJiyuListMenuArea by lazy { CoordinateArea(1208, 742, 650, 106) } //前往公告版
    val startJiyuBigArea by lazy { CoordinateArea(1895, 516, 148, 147) } //这个是打开对话框
    val openJiyuBigArea by lazy { CoordinateArea(1285, 532, 560, 109) }  //这个是打开可以进行放弃


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

    fun getPositionArea(index: Int): CoordinateArea {
        return CoordinateArea(431, 425 + (index * 75), 75, 59) //这个是根据2个跳的距离(左边跳转的距离)
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
    val updateGameArea by lazy { CoordinateArea(1206, 663, 317, 108) }


    /**
     * TODO
     *  NO实现的
     **/
    val exitGameTask1 by lazy {
        val tag = "exitGameTask"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            218, 111, 238, 135, 236, 132,
            0.9621146F, 0.70434785F, 0.97066665F, 0.70434785F, 1.086628F, 0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(
                CoordinatePoint(1034, 693), ruleRatio1
                //red183 green213 blue211 blockNumber1
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1034, 693), ruleRatio1
                //red183 green213 blue211 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1049, 693), ruleRatio1
                //red182 green208 blue205 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1054, 706), ruleRatio1
                //red170 green192 blue190 blockNumber2
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1056, 694), ruleRatio1
                //red181 green207 blue204 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1054, 698), ruleRatio1
                //red162 green192 blue190 blockNumber3
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1042, 695), ruleRatio1
                //red176 green202 blue199 blockNumber4
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1034, 702), ruleRatio1
                //red194 green219 blue216 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1037, 704), ruleRatio1
                //red157 green189 blue186 blockNumber5
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1037, 712), ruleRatio1
                //red191 green216 blue212 blockNumber6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1033, 717), ruleRatio1
                //red170 green199 blue195 blockNumber6
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1034, 693),
                CoordinatePoint(1034, 690),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1033, 717),
                CoordinatePoint(1031, 716),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(1057, 716),
                CoordinatePoint(1059, 716),
                CompareDifferenceRuleImpl.getSimple(20, 20, 20)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = CoordinateArea(1215, 653, 310, 104)
        }
    }


    val exitGameTask2 by lazy {
        val tag = "exitGameTask"
        val ruleRatio1 = ColorRuleRatioImpl.getSimple(
            114, 90, 114, 90, 114, 90,
            1.05F, 0.9F, 1.05F, 0.9F, 1.05F, 0.9F
        )
        val correctPositionModel = null
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(931, 814), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(931, 829), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(918, 828), ruleRatio1
                //red108 green108 blue108 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(946, 829), ruleRatio1
                //red100 green100 blue100 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(916, 823), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(933, 834), ruleRatio1
                //red100 green100 blue100 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(931, 849), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(946, 851), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(917, 852), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(949, 840), ruleRatio1
                //red101 green101 blue101 blockNumber1
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(931, 814),
                CoordinatePoint(931, 812),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            )
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(933, 834),
                CoordinatePoint(934, 835),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = CoordinateArea(780, 771, 352, 125)
        }
    }

    val exitGameTask by lazy {
        MultiImgTask(arrayOf(exitGameTask1, exitGameTask2))
    }


    val isZeroEnemyTask by lazy {
        val tag = "isZeroEnemy"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 205,149,206,149,208,151,
            1.05625F,0.87931037F,1.0380682F,0.87931037F,1.04467F, 0.8739884F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(818, 705), ruleRatio1
            //red175 green176 blue180 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(818, 705), ruleRatio1
            //red175 green176 blue180 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(826, 708), ruleRatio1
            //red169 green170 blue172 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(827, 717), ruleRatio1
            //red181 green182 blue186 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(825, 726), ruleRatio1
            //red196 green197 blue199 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(816, 725), ruleRatio1
            //red183 green187 blue188 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(815, 716), ruleRatio1
            //red177 green178 blue182 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(818, 705),CoordinatePoint(818, 703), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(825, 726),CoordinatePoint(825, 728), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }



    val isOneEnemyTask by lazy {
        val tag = "isOneEnemy"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 217,141,218,142,222,145,
            1.0449519F,0.8789474F,1.0332446F,0.8789474F,1.0442307F, 0.8777778F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(815, 707), ruleRatio1
            //red177 green181 blue184 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(815, 707), ruleRatio1
            //red177 green181 blue184 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(819, 708), ruleRatio1
            //red191 green192 blue196 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(819, 716), ruleRatio1
            //red187 green188 blue192 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(819, 724), ruleRatio1
            //red187 green188 blue192 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(823, 726), ruleRatio1
            //red171 green172 blue176 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(815, 707),CoordinatePoint(815, 705), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(819, 716),CoordinatePoint(817, 716), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(823, 726),CoordinatePoint(823, 724), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }



    val isZeroEnemyList by lazy {
        var i = 0
        val tag = "isZeroEnemy"
        val task = isZeroEnemyTask
        val offset = -124
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", offset * i,0),
            task.copyOffset("$tag${++i}", offset * i,0),
        )
    }

    val isOneEnemyList by lazy {
        var i = 0
        val tag = "isOneEnemy"
        val task = isOneEnemyTask
        val offset = -124
        arrayOf(
            task,
            task.copyOffset("$tag${++i}", offset * i,0),
            task.copyOffset("$tag${++i}", offset * i,0),
        )
    }

}