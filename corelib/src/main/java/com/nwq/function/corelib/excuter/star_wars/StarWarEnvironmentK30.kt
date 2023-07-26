package com.nwq.function.corelib.excuter.star_wars

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.pcheck.TwoPointRule
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioUnImpl
import com.nwq.function.corelib.img.rule.CompareDifferenceRuleImpl
import com.nwq.function.corelib.img.task.CorrectPositionModel
import com.nwq.function.corelib.img.task.ImgTaskImpl1

class StarWarEnvironmentK30 {

    val isLoadingGameT by lazy {
        val tag = "isLoadingGame"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 91,54,92,54,87,50,
            1.05F,0.8852459F,1.1437501F,0.8852459F,1.1624999F, 0.9216867F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1048, 440), ruleRatio1
            //red72 green73 blue68 blockNumber1
        ))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1048, 440), ruleRatio1
            //red72 green73 blue68 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1030, 567), ruleRatio1
            //red71 green72 blue67 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1183, 451), ruleRatio1
            //red61 green62 blue57 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1194, 569), ruleRatio1
            //red83 green84 blue79 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1064, 469), ruleRatio1
            //red62 green63 blue58 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1101, 511), ruleRatio1
            //red63 green64 blue59 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1069, 565), ruleRatio1
            //red80 green81 blue76 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1165, 469), ruleRatio1
            //red74 green75 blue70 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1107, 566), ruleRatio1
            //red63 green64 blue59 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1143, 578), ruleRatio1
            //red70 green71 blue66 blockNumber3
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isAnnouncementT by lazy {
        val tag = "isAnnouncement"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 267,221,267,223,267,220,
            1.0584677F,0.8927419F,1.0584677F,0.8927419F,1.0628572F, 0.8928F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1218, 127), ruleRatio1 ))
            //red249 green249 blue249 blockNumber1
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1207, 144), ruleRatio1
            //red253 green253 blue253 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1235, 127), ruleRatio1
            //red249 green249 blue249 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1237, 131), ruleRatio1
            //red249 green249 blue249 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1248, 145), ruleRatio1
            //red249 green249 blue249 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1226, 142), ruleRatio1
            //red251 green251 blue251 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1217, 155), ruleRatio1
            //red249 green251 blue250 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1237, 155), ruleRatio1
            //red250 green250 blue250 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1235, 164), ruleRatio1
            //red253 green253 blue253 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1246, 168), ruleRatio1
            //red252 green252 blue252 blockNumber5
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1218, 127),CoordinatePoint(1218, 123), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1226, 142),CoordinatePoint(1226, 138), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1222, 165),CoordinatePoint(1222, 162), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val closeAnnouncementArea by lazy { CoordinateArea(1917,90,70,67)}


    val isStartGameT by lazy {
        val tag = "isStartGame"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 267,228,267,215,258,189,
            1.1202928F,0.9F,1.275F,0.9F,1.2249999F, 0.9329268F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 267,225,196,161,77,54,
            1.4899441F,1.2193549F,4.4449997F,1.2193549F,3.1325F, 2.2256756F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2221, 959), ruleRatio1
            //red255 green252 blue226 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2221, 959), ruleRatio1
            //red255 green252 blue226 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2220, 963), ruleRatio1
            //red255 green246 blue224 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2223, 965), ruleRatio1
            //red255 green246 blue226 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2217, 965), ruleRatio1
            //red255 green244 blue211 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2227, 966), ruleRatio1
            //red255 green245 blue212 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2220, 969), ruleRatio1
            //red255 green246 blue220 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2221, 955), ruleRatio2
            //red252 green186 blue74 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(2217, 960), ruleRatio2
            //red252 green184 blue73 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val isStartGameArea by lazy {  CoordinateArea(1002,758,419,147) }



    val isSelectRoleT by lazy {
        val tag = "isSelectRole"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 163,135,163,135,165,135,
            1.05F,0.9F,1.0637255F,0.9F,1.0637255F, 0.88846153F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(524, 595), ruleRatio1
            //red155 green155 blue157 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(524, 595), ruleRatio1
            //red155 green155 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(535, 595), ruleRatio1
            //red155 green155 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(524, 606), ruleRatio1
            //red155 green155 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(546, 595), ruleRatio1
            //red155 green155 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(532, 612), ruleRatio1
            //red154 green154 blue154 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(543, 612), ruleRatio1
            //red154 green154 blue154 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(537, 599), ruleRatio1
            //red155 green155 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(552, 609), ruleRatio1
            //red155 green155 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(540, 608), ruleRatio1
            //red155 green155 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(544, 602), ruleRatio1
            //red155 green155 blue155 blockNumber2
        ))
        pointList.add(TwoPointRule(CoordinatePoint(524, 595),CoordinatePoint(522, 595), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(543, 612),CoordinatePoint(543, 614), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val selectRoleArea by lazy { CoordinateArea(543,313,241,263)}

    val isClosePositionMenuT by lazy {
        val tag = "isClosePositionMenuT"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 165,115,171,123,175,124,
            1.05F,0.8347826F,1.05F,0.8347826F,1.0576087F, 0.87039477F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(127, 295), ruleRatio1
            //red133 green142 blue141 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(134, 307), ruleRatio1
            //red158 green163 blue167 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(131, 303), ruleRatio1
            //red142 green147 blue150 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(129, 299), ruleRatio1
            //red139 green148 blue147 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(139, 304), ruleRatio1
            //red148 green153 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(141, 300), ruleRatio1
            //red150 green154 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(143, 296), ruleRatio1
            //red145 green145 blue147 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(133, 296), ruleRatio1
            //red142 green147 blue150 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(137, 296), ruleRatio1
            //red144 green147 blue152 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(141, 300),CoordinatePoint(145, 300), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(134, 307),CoordinatePoint(130, 307), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openPositionArea by lazy { CoordinateArea(96,258,80,77)}



    val isOpenPositionMenuT by lazy {
        val tag = "isOpenPosition"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 164,117,170,122,174,123,
            1.05F,0.8383562F,1.05F,0.8383562F,1.0576643F, 0.8707792F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(485, 294), ruleRatio1
            //red133 green142 blue141 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(495, 302), ruleRatio1
            //red157 green161 blue164 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(497, 298), ruleRatio1
            //red148 green148 blue148 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(493, 306), ruleRatio1
            //red146 green149 blue154 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(499, 294), ruleRatio1
            //red142 green142 blue142 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(490, 310), ruleRatio1
            //red138 green146 blue148 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(499, 290), ruleRatio1
            //red137 green137 blue137 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(488, 306), ruleRatio1
            //red152 green155 blue160 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(486, 302), ruleRatio1
            //red149 green154 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(489, 296), ruleRatio1
            //red144 green148 blue151 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(484, 298), ruleRatio1
            //red141 green151 blue152 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(495, 302),CoordinatePoint(498, 302), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(488, 306),CoordinatePoint(484, 306), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isInSpaceStationT by lazy {
        val tag = "isInSapceStation"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 173,113,149,96,55,27,
            1.2761538F,1.0369565F,5.351613F,1.0369565F,4.470968F, 2.2754717F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2060, 354), ruleRatio1
            //red159 green137 blue51 blockNumber4
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2071, 360), ruleRatio1
            //red157 green132 blue31 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2070, 364), ruleRatio1
            //red156 green130 blue33 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(2061, 367), ruleRatio1
            //red156 green131 blue31 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(2064, 369), ruleRatio1
            //red156 green131 blue31 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(2064, 359), ruleRatio1
            //red149 green125 blue37 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(2060, 354), ruleRatio1
            //red159 green137 blue51 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(2061, 364), ruleRatio1
            //red148 green128 blue42 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(2071, 350), ruleRatio1
            //red163 green139 blue49 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(2079, 359), ruleRatio1
            //red160 green138 blue53 blockNumber5
        ))
        pointList.add(TwoPointRule(CoordinatePoint(2060, 354),CoordinatePoint(2055, 354), CompareDifferenceRuleImpl.getSimple(30,30,10)))
        pointList.add(TwoPointRule(CoordinatePoint(2079, 359),CoordinatePoint(2075, 369), CompareDifferenceRuleImpl.getSimple(30,20,10)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }



    val isOpenBigMenuT by lazy {
        val tag = "isOpenBigMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 237,189,250,207,249,205,
            1.0097872F,0.80466104F,1.0228448F,0.80466104F,1.0726293F, 0.89610386F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(152, 46), ruleRatio1
            //red212 green234 blue231 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(152, 46), ruleRatio1
            //red212 green234 blue231 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(171, 46), ruleRatio1
            //red222 green237 blue234 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(167, 49), ruleRatio1
            //red222 green237 blue234 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(187, 49), ruleRatio1
            //red223 green238 blue235 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(152, 58), ruleRatio1
            //red213 green235 blue232 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(172, 58), ruleRatio1
            //red222 green237 blue234 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(152, 68), ruleRatio1
            //red211 green236 blue232 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(170, 71), ruleRatio1
            //red221 green237 blue236 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(166, 74), ruleRatio1
            //red220 green232 blue232 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(188, 73), ruleRatio1
            //red223 green233 blue232 blockNumber3
        ))
        pointList.add(TwoPointRule(CoordinatePoint(152, 46),CoordinatePoint(150, 46), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(172, 58),CoordinatePoint(172, 55), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

































    /**
     * TODO
     *  NO实现的
     **/
    val isUpdateGameT by lazy {
        val tag = "isUpdateGame"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 239,162,256,184,254,181,
            0.9884937F,0.7677725F,0.9975F,0.7677725F,1.0754855F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 239,162,256,184,254,181,
            0.9884937F,0.7677725F,0.9975F,0.7677725F,1.0754855F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1350, 698), ColorRuleRatioImpl.getSimple(45,90,85)))
        val correctPositionModel =CorrectPositionModel(list, tag, 5, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1347, 716), ruleRatio1
            //red214 green233 blue231 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1350, 701), ruleRatio1
            //red200 green225 blue222 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1360, 710), ruleRatio1
            //red217 green237 blue235 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1361, 726), ruleRatio1
            //red210 green232 blue229 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1369, 710), ruleRatio1
            //red197 green219 blue216 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1395, 710), ruleRatio1
            //red197 green222 blue219 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1337, 726), ruleRatio1
            //red219 green235 blue234 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1382, 724), ruleRatio1
            //red216 green234 blue234 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1389, 720), ruleRatio1
            //red203 green228 blue224 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1350, 698), ruleRatio2
            //red45 green90 blue85 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1366, 710), ruleRatio2
            //red44 green89 blue84 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val updateGameArea by lazy { CoordinateArea(1207,663,315,104) }
}