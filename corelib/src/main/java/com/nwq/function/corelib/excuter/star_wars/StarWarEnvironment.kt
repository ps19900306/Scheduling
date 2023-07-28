package com.nwq.function.corelib.excuter.star_wars

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.*
import com.nwq.function.corelib.img.rule.ColorRuleImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioUnImpl
import com.nwq.function.corelib.img.rule.CompareDifferenceRuleImpl
import com.nwq.function.corelib.img.task.*

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 这个是K40的环境
 */

class StarWarEnvironment {

    //正在加载游戏先不管
    val isLoadingGameT by lazy {
        val tag = "isLoadingGame"
        val list = mutableListOf<PointRule>(
            PointRule(
                CoordinatePoint(1735, 441), ColorRuleRatioImpl.getSimple(61, 62, 57)
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1726, 470), ColorRuleRatioImpl.getSimple(61, 62, 57)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1801, 479), ColorRuleRatioImpl.getSimple(61, 62, 57)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1728, 489), ColorRuleRatioImpl.getSimple(61, 62, 57)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1738, 512), ColorRuleRatioImpl.getSimple(61, 62, 57)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1790, 430), ColorRuleRatioImpl.getSimple(231, 0, 18)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1788, 438), ColorRuleRatioImpl.getSimple(231, 0, 18)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1786, 448), ColorRuleRatioImpl.getSimple(231, 0, 18)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1732, 438), ColorRuleRatioImpl.getSimple(255, 255, 255)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

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

    val isAnnouncementT by lazy {
        val tag = "isAnnouncement"
        val list = mutableListOf<PointRule>(
            PointRule(
                CoordinatePoint(1292, 119), ColorRuleRatioImpl.getSimple(252, 254, 253)
            )
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1276, 121), ColorRuleRatioImpl.getSimple(244, 246, 245)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1280, 128), ColorRuleRatioImpl.getSimple(254, 254, 254)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1308, 128), ColorRuleRatioImpl.getSimple(255, 255, 255)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1276, 142), ColorRuleRatioImpl.getSimple(250, 252, 251)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1298, 142), ColorRuleRatioImpl.getSimple(251, 251, 251)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1276, 152), ColorRuleRatioImpl.getSimple(254, 254, 254)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1307, 155), ColorRuleRatioImpl.getSimple(255, 255, 255)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1292, 168), ColorRuleRatioImpl.getSimple(252, 254, 253)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1305, 169), ColorRuleRatioImpl.getSimple(222, 224, 223)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1274, 170), ColorRuleRatioImpl.getSimple(251, 251, 251)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1289, 116), ColorRuleRatioUnImpl.getSimple(
                    289,
                    189,
                    290,
                    190,
                    292,
                    192,
                    1.195F,
                    0.7966667F,
                    1.185124F,
                    0.79008263F,
                    1.1900827F,
                    0.7933884F
                )
                //red32 green35 blue40
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1302, 171), ColorRuleRatioUnImpl.getSimple(
                    289,
                    189,
                    290,
                    190,
                    292,
                    192,
                    1.195F,
                    0.7966667F,
                    1.185124F,
                    0.79008263F,
                    1.1900827F,
                    0.7933884F
                )
                //red52 green56 blue59
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val closeAnnouncementArea by lazy { CoordinateArea(1917, 89, 67, 71) }

    val isStartGameT by lazy {
        val tag = "isStartGame"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2233, 956), ColorRuleRatioImpl.getSimple(254, 187, 74)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2236, 959), ColorRuleRatioImpl.getSimple(255, 252, 226)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2230, 966), ColorRuleRatioImpl.getSimple(255, 244, 212)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2237, 968), ColorRuleRatioImpl.getSimple(255, 249, 231)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2233, 956), ColorRuleRatioImpl.getSimple(254, 187, 74)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2227, 963), ColorRuleRatioImpl.getSimple(253, 185, 78)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2240, 971), ColorRuleRatioImpl.getSimple(252, 186, 74)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val isStartGameArea by lazy { CoordinateArea(1044, 790, 309, 92) }

    val isSelectRoleT by lazy {
        val tag = "isSelectRole"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(519, 595), ColorRuleRatioImpl.getSimple(155, 155, 157)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(536, 587), ColorRuleRatioImpl.getSimple(125, 125, 127)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(519, 595), ColorRuleRatioImpl.getSimple(155, 155, 157)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(532, 595), ColorRuleRatioImpl.getSimple(155, 155, 155)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(544, 597), ColorRuleRatioImpl.getSimple(155, 155, 157)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(529, 599), ColorRuleRatioImpl.getSimple(155, 155, 155)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(538, 603), ColorRuleRatioImpl.getSimple(155, 155, 155)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(519, 608), ColorRuleRatioImpl.getSimple(155, 155, 155)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(544, 609), ColorRuleRatioImpl.getSimple(155, 155, 153)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(530, 611), ColorRuleRatioImpl.getSimple(155, 155, 155)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(533, 584), ColorRuleRatioUnImpl.getSimple(
                    160,
                    90,
                    160,
                    90,
                    162,
                    92,
                    1.2F,
                    0.8F,
                    1.1811024F,
                    0.7874016F,
                    1.1811024F,
                    0.7874016F
                )
                //red4 green4 blue6
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(547, 594), ColorRuleRatioUnImpl.getSimple(
                    160,
                    90,
                    160,
                    90,
                    162,
                    92,
                    1.2F,
                    0.8F,
                    1.1811024F,
                    0.7874016F,
                    1.1811024F,
                    0.7874016F
                )
                //red4 green3 blue8
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(535, 601), ColorRuleRatioUnImpl.getSimple(
                    160,
                    90,
                    160,
                    90,
                    162,
                    92,
                    1.2F,
                    0.8F,
                    1.1811024F,
                    0.7874016F,
                    1.1811024F,
                    0.7874016F
                )
                //red4 green3 blue8
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val selectRoleArea by lazy { CoordinateArea(563, 223, 235, 218) }


    //关闭左边位置菜单
    val isClosePositionMenuT by lazy {
        val tag = "isClosePositionMenuT"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 150,90,154,98,157,98,
            1.0673554F,0.81891894F,1.069266F,0.81891894F,1.069266F, 0.8605839F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(113, 283), ruleRatio1
            //red115 green115 blue115 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(110, 289), ruleRatio1
            //red120 green120 blue120 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(111, 295), ruleRatio1
            //red115 green119 blue118 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(113, 283), ruleRatio1
            //red115 green115 blue115 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(114, 301), ruleRatio1
            //red108 green116 blue118 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(115, 292), ruleRatio1
            //red108 green112 blue113 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(118, 307), ruleRatio1
            //red126 green131 blue137 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(119, 280), ruleRatio1
            //red113 green113 blue113 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(124, 294), ruleRatio1
            //red122 green126 blue129 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(125, 281), ruleRatio1
            //red118 green118 blue118 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(125, 304), ruleRatio1
            //red122 green128 blue128 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(128, 298), ruleRatio1
            //red131 green131 blue131 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(130, 286), ruleRatio1
            //red111 green111 blue109 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(130, 292), ruleRatio1
            //red128 green128 blue128 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(119, 280),CoordinatePoint(119, 278), CompareDifferenceRuleImpl.getSimple(20,20,20)))
        pointList.add(TwoPointRule(CoordinatePoint(130, 292),CoordinatePoint(133, 292), CompareDifferenceRuleImpl.getSimple(20,20,20)))
        pointList.add(TwoPointRule(CoordinatePoint(118, 307),CoordinatePoint(115, 307), CompareDifferenceRuleImpl.getSimple(20,20,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openPositionArea by lazy { CoordinateArea(85, 258, 71, 74) }
    //开启左边位置菜单
    val isOpenPositionMenuT by lazy {
        val tag = "isOpenPosition"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 164,117,170,121,174,124,
            1.05F,0.83706295F,1.05F,0.83706295F,1.057554F, 0.8637584F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(483, 295), ruleRatio1
            //red147 green147 blue147 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(477, 307), ruleRatio1
            //red157 green162 blue166 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(480, 303), ruleRatio1
            //red146 green151 blue154 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(482, 299), ruleRatio1
            //red141 green142 blue144 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(483, 295), ruleRatio1
            //red147 green147 blue147 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(470, 301), ruleRatio1
            //red139 green147 blue149 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(468, 297), ruleRatio1
            //red137 green145 blue147 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(467, 293), ruleRatio1
            //red139 green143 blue144 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(474, 296), ruleRatio1
            //red144 green147 blue152 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(474, 296),CoordinatePoint(474, 292), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(470, 301),CoordinatePoint(467, 301), CompareDifferenceRuleImpl.getSimple(20,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(477, 307),CoordinatePoint(480, 307), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }



    //在空间站里面
    val isInSpaceStationT by lazy {
        val tag = "isInSapceStation"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2031, 335), ColorRuleRatioImpl.getSimple(174, 146, 37)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2063, 335), ColorRuleRatioImpl.getSimple(174, 147, 40)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2092, 335), ColorRuleRatioImpl.getSimple(172, 148, 42)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2122, 354), ColorRuleRatioImpl.getSimple(172, 144, 44)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2079, 357), ColorRuleRatioImpl.getSimple(170, 142, 43)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2122, 363), ColorRuleRatioImpl.getSimple(156, 132, 34)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2087, 365), ColorRuleRatioImpl.getSimple(156, 130, 33)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2052, 367), ColorRuleRatioImpl.getSimple(158, 130, 33)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2059, 384), ColorRuleRatioImpl.getSimple(158, 133, 30)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2092, 357), ColorRuleRatioImpl.getSimple(168, 142, 45)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2059, 358), ColorRuleRatioImpl.getSimple(165, 140, 47)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2040, 356), ColorRuleRatioUnImpl.getSimple(
                    215,
                    135,
                    178,
                    108,
                    59,
                    29,
                    1.4685315F,
                    0.979021F,
                    4.7727275F,
                    3.1818182F,
                    3.9F,
                    2.6000001F
                )
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2125, 366), ColorRuleRatioUnImpl.getSimple(
                    215,
                    135,
                    178,
                    108,
                    59,
                    29,
                    1.4685315F,
                    0.979021F,
                    4.7727275F,
                    3.1818182F,
                    3.9F,
                    2.6000001F
                )
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenBigMenuT by lazy {
        val tag = "isOpenBigMenu"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(138, 46), ColorRuleRatioImpl.getSimple(220, 236, 235)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(138, 46), ColorRuleRatioImpl.getSimple(220, 236, 235)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(156, 46), ColorRuleRatioImpl.getSimple(222, 237, 234)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(150, 49), ColorRuleRatioImpl.getSimple(222, 237, 234)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(138, 58), ColorRuleRatioImpl.getSimple(220, 236, 235)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(173, 60), ColorRuleRatioImpl.getSimple(220, 235, 232)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(138, 69), ColorRuleRatioImpl.getSimple(223, 235, 233)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(150, 74), ColorRuleRatioImpl.getSimple(220, 230, 231)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(172, 74), ColorRuleRatioImpl.getSimple(222, 234, 232)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(135, 43), ColorRuleRatioUnImpl.getSimple(
                    278,
                    178,
                    284,
                    184,
                    284,
                    184,
                    1.1692308F,
                    0.7794872F,
                    1.1692308F,
                    0.7794872F,
                    1.2F,
                    0.8F
                )
                //red48 green104 blue95
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(153, 55), ColorRuleRatioUnImpl.getSimple(
                    278,
                    178,
                    284,
                    184,
                    284,
                    184,
                    1.1692308F,
                    0.7794872F,
                    1.1692308F,
                    0.7794872F,
                    1.2F,
                    0.8F
                )
                //red54 green107 blue97
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(169, 77), ColorRuleRatioUnImpl.getSimple(
                    278,
                    178,
                    284,
                    184,
                    284,
                    184,
                    1.1692308F,
                    0.7794872F,
                    1.1692308F,
                    0.7794872F,
                    1.2F,
                    0.8F
                )
                //red62 green115 blue105
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val closeBigMenuArea by lazy { CoordinateArea(2225, 28, 67, 72) }




    //正在航行
    val isSailingT by lazy {
        val tag = "isSailing"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(112, 295), ColorRuleRatioImpl.getSimple(130, 150, 148)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(112, 295), ColorRuleRatioImpl.getSimple(130, 150, 148)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(124, 296), ColorRuleRatioImpl.getSimple(133, 155, 152)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(112, 304), ColorRuleRatioImpl.getSimple(162, 179, 173)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(123, 306), ColorRuleRatioImpl.getSimple(149, 164, 157)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(109, 292), ColorRuleRatioUnImpl.getSimple(
                    165,
                    95,
                    185,
                    115,
                    183,
                    113,
                    1.0400001F,
                    0.6933333F,
                    1.0540541F,
                    0.7027027F,
                    1.2162163F,
                    0.81081086F
                )
                //red30 green42 blue38
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(121, 293), ColorRuleRatioUnImpl.getSimple(
                    165,
                    95,
                    185,
                    115,
                    183,
                    113,
                    1.0400001F,
                    0.6933333F,
                    1.0540541F,
                    0.7027027F,
                    1.2162163F,
                    0.81081086F
                )
                //red38 green53 blue48
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isCloseEyeMenuT by lazy {
        val tag = "isCloseEyeMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 185,128,185,128,185,128,
            1.05F,0.8885351F,1.05F,0.8885351F,1.0567307F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2246, 614), ruleRatio1
            //red147 green147 blue147 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2238, 607), ruleRatio1
            //red159 green159 blue159 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2255, 611), ruleRatio1
            //red143 green143 blue143 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2259, 603), ruleRatio1
            //red152 green152 blue152 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2254, 595), ruleRatio1
            //red145 green145 blue145 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2266, 607), ruleRatio1
            //red156 green156 blue156 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2236, 612), ruleRatio1
            //red169 green169 blue169 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2258, 614), ruleRatio1
            //red158 green158 blue158 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2247, 603), ruleRatio1
            //red151 green151 blue151 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(2250, 606), ruleRatio1
            //red155 green157 blue156 blockNumber2
        ))
        pointList.add(TwoPointRule(CoordinatePoint(2254, 595),CoordinatePoint(2252, 598), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(2250, 606),CoordinatePoint(2253, 606), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(2246, 614),CoordinatePoint(2246, 611), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openEyeMenuArea by lazy { CoordinateArea(2211, 570, 75, 71) }






    val isOpenEyeMenuT by lazy {
        val tag = "isOpenEyeMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 185,126,185,126,185,125,
            1.05F,0.88767123F,1.0651078F,0.88767123F,1.0651078F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1858, 612), ruleRatio1
            //red146 green146 blue146 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1858, 612), ruleRatio1
            //red169 green169 blue169 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1851, 604), ruleRatio1
            //red146 green146 blue146 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1867, 616), ruleRatio1
            //red151 green151 blue151 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1876, 615), ruleRatio1
            //red169 green169 blue169 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1859, 597), ruleRatio1
            //red142 green142 blue142 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1860, 605), ruleRatio1
            //red149 green149 blue149 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1885, 611), ruleRatio1
            //red157 green157 blue157 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1888, 602), ruleRatio1
            //red152 green152 blue152 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1879, 596), ruleRatio1
            //red145 green145 blue145 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1869, 603), ruleRatio1
            //red150 green150 blue150 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1872, 606), ruleRatio1
            //red156 green156 blue156 blockNumber2
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1860, 605),CoordinatePoint(1863, 605), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1872, 606),CoordinatePoint(1876, 606), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1858, 612),CoordinatePoint(1856, 614), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //可以领取或者可以收集
    val isGiftMenuTipsT by lazy {
        val tag = "isGiftMenuTips"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(149, 520), ColorRuleRatioImpl.getSimple(252, 45, 65)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(133, 530), ColorRuleRatioImpl.getSimple(243, 207, 113)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(141, 530), ColorRuleRatioImpl.getSimple(244, 198, 110)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(135, 534), ColorRuleRatioImpl.getSimple(243, 204, 109)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(149, 520), ColorRuleRatioImpl.getSimple(252, 45, 65)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(154, 524), ColorRuleRatioImpl.getSimple(254, 42, 64)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = openGiftMenuArea
        }
    }
    val openGiftMenuArea by lazy { CoordinateArea(90, 507, 77, 79) }


    val isCanCollectGiftT by lazy {
        val tag = "isCanCollectGift"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(705, 737), ColorRuleRatioImpl.getSimple(210, 168, 96)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(705, 737), ColorRuleRatioImpl.getSimple(210, 168, 96)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(702, 746), ColorRuleRatioImpl.getSimple(209, 169, 97)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(700, 756), ColorRuleRatioImpl.getSimple(193, 154, 85)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(710, 760), ColorRuleRatioImpl.getSimple(194, 157, 89)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(718, 737), ColorRuleRatioImpl.getSimple(174, 29, 26)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(708, 744), ColorRuleRatioImpl.getSimple(178, 42, 28)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(711, 754), ColorRuleRatioImpl.getSimple(182, 45, 27)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(705, 755), ColorRuleRatioImpl.getSimple(171, 50, 33)
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    //领取礼物
    val openCollectGiftArea by lazy { CoordinateArea(485, 731, 252, 39) }
    val closeCollectGiftArea by lazy { CoordinateArea(1905,151,57,61)}

    //是否可以收集芯片 注意这里必须在空间站才能使用
    val isCollectChipT by lazy {
        val tag = "isCollectChipT"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1845, 156), ColorRuleRatioImpl.getSimple(250,43,63)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1811, 183), ColorRuleRatioImpl.getSimple(222,191,127)))
        pointList.add(PointRule(CoordinatePoint(1837, 184), ColorRuleRatioImpl.getSimple(223,196,129)))
        pointList.add(PointRule(CoordinatePoint(1831, 191), ColorRuleRatioImpl.getSimple(228,207,144)))
        pointList.add(PointRule(CoordinatePoint(1823, 194), ColorRuleRatioImpl.getSimple(233,210,143)))
        pointList.add(PointRule(CoordinatePoint(1845, 156), ColorRuleRatioImpl.getSimple(250,43,63)))
        pointList.add(PointRule(CoordinatePoint(1844, 163), ColorRuleRatioImpl.getSimple(248,45,65)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val collectChipMenuArea by lazy { CoordinateArea(1797,148,61,63)}


    val isCollectChipMenuT by lazy {
        val tag = "isCollectChipMenu"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1639, 942), ColorRuleRatioImpl.getSimple(226,186,125)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1639, 942), ColorRuleRatioImpl.getSimple(226,186,125)))
        pointList.add(PointRule(CoordinatePoint(1639, 961), ColorRuleRatioImpl.getSimple(230,191,132)))
        pointList.add(PointRule(CoordinatePoint(1643, 966), ColorRuleRatioImpl.getSimple(228,190,125)))
        pointList.add(PointRule(CoordinatePoint(1653, 966), ColorRuleRatioImpl.getSimple(228,190,125)))
        pointList.add(PointRule(CoordinatePoint(1633, 933), ColorRuleRatioUnImpl.getSimple( 275,175,226,146,164,94,
            1.451613F,0.96774197F,2.0930233F,1.3953489F,1.7302326F, 1.1534884F)
            //red69 green65 blue56
        ))
        pointList.add(PointRule(CoordinatePoint(1654, 973), ColorRuleRatioUnImpl.getSimple( 275,175,226,146,164,94,
            1.451613F,0.96774197F,2.0930233F,1.3953489F,1.7302326F, 1.1534884F)
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea =  CollectChipArea
        }
    }
    val CollectChipArea by lazy { CoordinateArea(1706,891,221,71)}
    val CloseCollectChipMenuArea by lazy { CoordinateArea(1920,96,62,65)}


    //这个是已经领取了
    val isHasTakeTask by lazy {
        val tag = "ishasTake"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 267,201,267,207,267,206,
            1.05F,0.86170214F,1.05F,0.86170214F,1.0636957F, 0.89265305F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 267,201,267,207,267,206,
            1.05F,0.86170214F,1.05F,0.86170214F,1.0636957F, 0.89265305F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1105, 393), ColorRuleRatioImpl.getSimple(32,61,56)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1105, 396), ruleRatio1
            //red244 green250 blue248 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1107, 422), ruleRatio1
            //red241 green245 blue246 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1110, 427), ruleRatio1
            //red246 green247 blue249 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1111, 412), ruleRatio1
            //red242 green243 blue245 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1120, 435), ruleRatio1
            //red254 green255 blue255 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1123, 415), ruleRatio1
            //red243 green247 blue246 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1128, 396), ruleRatio1
            //red245 green249 blue248 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1130, 432), ruleRatio1
            //red226 green232 blue230 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1134, 412), ruleRatio1
            //red226 green230 blue229 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1139, 409), ruleRatio1
            //red247 green251 blue250 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1145, 431), ruleRatio1
            //red226 green235 blue232 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1105, 393), ruleRatio2
            //red32 green61 blue56 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1114, 408), ruleRatio2
            //red32 green61 blue57 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1148, 431), ruleRatio2
            //red32 green63 blue58 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val hasTakeArea by lazy { CoordinateArea(816,483,766,508)}


    //打开了机遇大菜单
    val isOpenJiyuBigMenuTask by lazy {
        val tag = "isOpenJiyuBigMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 187,120,199,132,197,131,
            0.9944445F,0.79444444F,1.0093923F,0.79444444F,1.0832279F, 0.89440995F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 187,120,199,132,197,131,
            0.9944445F,0.79444444F,1.0093923F,0.79444444F,1.0832279F, 0.89440995F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(275, 38), ruleRatio1
            //red153 green172 blue168
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(282, 64), ruleRatio1
            //red171 green186 blue183
        ))
        pointList.add(PointRule(CoordinatePoint(305, 70), ruleRatio1
            //red173 green188 blue185
        ))
        pointList.add(PointRule(CoordinatePoint(254, 71), ruleRatio1
            //red173 green188 blue183
        ))
        pointList.add(PointRule(CoordinatePoint(266, 71), ruleRatio1
            //red173 green188 blue185
        ))
        pointList.add(PointRule(CoordinatePoint(285, 81), ruleRatio1
            //red183 green195 blue191
        ))
        pointList.add(PointRule(CoordinatePoint(275, 38), ruleRatio1
            //red153 green172 blue168
        ))
        pointList.add(PointRule(CoordinatePoint(291, 42), ruleRatio1
            //red153 green169 blue168
        ))
        pointList.add(PointRule(CoordinatePoint(274, 50), ruleRatio1
            //red160 green179 blue175
        ))
        pointList.add(PointRule(CoordinatePoint(287, 51), ruleRatio1
            //red158 green177 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(265, 55), ruleRatio1
            //red163 green179 blue176
        ))
        pointList.add(PointRule(CoordinatePoint(297, 56), ruleRatio1
            //red165 green181 blue178
        ))
        pointList.add(PointRule(CoordinatePoint(262, 52), ruleRatio2
            //red27 green31 blue34
        ))
        pointList.add(PointRule(CoordinatePoint(302, 71), ruleRatio2
            //red33 green38 blue41
        ))
        pointList.add(PointRule(CoordinatePoint(287, 83), ruleRatio2
            //red36 green42 blue42
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenWarehouseBigMenuTask by lazy {
        val tag = "isOpenWarehouseBigMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 196,148,207,157,203,154,
            1.0F,0.8194737F,1.0223684F,0.8194737F,1.0906076F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 196,148,207,157,203,154,
            1.0F,0.8194737F,1.0223684F,0.8194737F,1.0906076F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(257, 56), ruleRatio1
            //red166 green180 blue180 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(257, 56), ruleRatio1
            //red166 green180 blue180 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(258, 68), ruleRatio1
            //red173 green189 blue186 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(266, 78), ruleRatio1
            //red179 green194 blue189 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(269, 65), ruleRatio1
            //red171 green187 blue184 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(278, 73), ruleRatio1
            //red176 green191 blue188 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(278, 86), ruleRatio1
            //red182 green194 blue190 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(284, 74), ruleRatio1
            //red177 green192 blue187 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(291, 65), ruleRatio1
            //red172 green187 blue184 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(294, 79), ruleRatio1
            //red180 green192 blue190 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(303, 58), ruleRatio1
            //red167 green183 blue180 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(303, 69), ruleRatio1
            //red175 green190 blue187 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(255, 56), ruleRatio2
            //red40 green46 blue46 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(294, 83), ruleRatio2
            //red44 green48 blue47 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(278, 89), ruleRatio2
            //red49 green53 blue52 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOpenCaiBigMenuTask by lazy {
        val tag = "isOpenCaiBigMenu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 192,134,204,146,200,144,
            1.0113497F,0.80172414F,1.0242331F,0.80172414F,1.0897298F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 192,134,204,146,200,144,
            1.0113497F,0.80172414F,1.0242331F,0.80172414F,1.0897298F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(268, 69), ruleRatio1
            //red174 green191 blue185 blockNumber0
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(258, 71), ruleRatio1
            //red177 green189 blue187 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(268, 69), ruleRatio1
            //red174 green191 blue185 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(280, 66), ruleRatio1
            //red172 green188 blue185 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(281, 75), ruleRatio1
            //red175 green187 blue183 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(284, 81), ruleRatio1
            //red181 green196 blue191 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(300, 57), ruleRatio1
            //red166 green182 blue179 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(300, 68), ruleRatio1
            //red170 green179 blue176 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(280, 37), ruleRatio2
            //red17 green15 blue16 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(258, 67), ruleRatio2
            //red19 green18 blue16 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    //这个是左边的大图
    private val itemOffset = 465  //X 条目X轴位移
    val item1IsNormalTask by lazy {
        val tag = "item1IsNormal"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 126,74,141,88,140,88,
            0.94029856F,0.72692305F,0.95307696F,0.72692305F,1.0881817F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 55,36,75,50,74,49,
            0.79925376F,0.5590909F,0.82090914F,0.5590909F,1.1072726F, 0.8727273F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(614, 322), ruleRatio1
            //red123 green137 blue137
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(628, 320), ruleRatio1
            //red118 green132 blue132
        ))
        pointList.add(PointRule(CoordinatePoint(614, 322), ruleRatio1
            //red123 green137 blue137
        ))
        pointList.add(PointRule(CoordinatePoint(642, 323), ruleRatio1
            //red125 green137 blue137
        ))
        pointList.add(PointRule(CoordinatePoint(627, 344), ruleRatio1
            //red123 green135 blue135
        ))
        pointList.add(PointRule(CoordinatePoint(641, 356), ruleRatio1
            //red123 green139 blue138
        ))
        pointList.add(PointRule(CoordinatePoint(610, 332), ruleRatio1
            //red110 green126 blue125
        ))
        pointList.add(PointRule(CoordinatePoint(647, 333), ruleRatio1
            //red115 green131 blue130
        ))
        pointList.add(PointRule(CoordinatePoint(615, 352), ruleRatio1
            //red110 green124 blue124
        ))
        pointList.add(PointRule(CoordinatePoint(620, 359), ruleRatio1
            //red116 green132 blue131
        ))
        pointList.add(PointRule(CoordinatePoint(611, 319), ruleRatio2
            //red45 green65 blue64
        ))
        pointList.add(PointRule(CoordinatePoint(607, 329), ruleRatio2
            //red45 green65 blue64
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsNormalTaskList by lazy {
        arrayOf(
            item1IsNormalTask,
            item1IsNormalTask.copyOffset("item2IsNormal",itemOffset,0),
            item1IsNormalTask.copyOffset("item3IsNormal",itemOffset*2,0))
    }

    val item1ZeroDistanceTask by lazy {
        val tag = "item1ZeroDistance"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 159,106,164,110,162,109,
            1.0339694F,0.85645163F,1.0431373F,0.85645163F,1.077451F, 0.89285713F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(609, 495), ruleRatio1
            //red133 green137 blue136 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 2, 5, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(609, 495), ruleRatio1
            //red133 green137 blue136 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(608, 501), ruleRatio1
            //red152 green156 blue155 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(608, 507), ruleRatio1
            //red152 green157 blue153 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(612, 511), ruleRatio1
            //red120 green126 blue126 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(617, 508), ruleRatio1
            //red125 green129 blue130 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(617, 502), ruleRatio1
            //red125 green129 blue128 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(616, 496), ruleRatio1
            //red122 green126 blue125 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(609, 495),CoordinatePoint(609, 494), CompareDifferenceRuleImpl.getSimple(20,20,20)))
        pointList.add(TwoPointRule(CoordinatePoint(616, 496),CoordinatePoint(616, 494), CompareDifferenceRuleImpl.getSimple(15,15,15)))
        pointList.add(TwoPointRule(CoordinatePoint(612, 511),CoordinatePoint(612, 509), CompareDifferenceRuleImpl.getSimple(15,15,20)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }




    val IsZeroDistanceList by lazy {
        arrayOf(item1ZeroDistanceTask,
            item1ZeroDistanceTask.copyOffset("item2ZeroDistance",itemOffset,0),
            item1ZeroDistanceTask.copyOffset("item3ZeroDistance",itemOffset*2,0))
    }

    val item1OneDistanceTask by lazy {
        val tag = "itemOne1Distance"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 143,102,148,106,149,107,
            1.0423913F,0.8578125F,1.0275F,0.8578125F,1.05F, 0.8793893F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(610, 495), ruleRatio1
            //red114 green118 blue119 blockNumber1
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 2, 5, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(610, 495), ruleRatio1
            //red114 green118 blue119 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(612, 498), ruleRatio1
            //red123 green127 blue128 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(612, 501), ruleRatio1
            //red123 green129 blue129 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(612, 504), ruleRatio1
            //red123 green129 blue129 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(612, 507), ruleRatio1
            //red124 green128 blue131 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(611, 510), ruleRatio1
            //red120 green124 blue125 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(608, 511), ruleRatio1
            //red118 green122 blue123 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(615, 511), ruleRatio1
            //red120 green121 blue123 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(610, 495),CoordinatePoint(610, 494), CompareDifferenceRuleImpl.getSimple(15,15,15)))
        pointList.add(TwoPointRule(CoordinatePoint(612, 507),CoordinatePoint(614, 507), CompareDifferenceRuleImpl.getSimple(20,20,20)))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance=1
        }
    }

    val IsOneDistanceList by lazy {
        arrayOf(
            item1OneDistanceTask,
            item1OneDistanceTask.copyOffset("itemOne2Distance",itemOffset,0),
            item1OneDistanceTask.copyOffset("itemOne3Distance",itemOffset*2,0))
    }


    //pickUpTask
    val pickUpTaskArea by lazy { CoordinateArea(565,626,451,70)}
    val pickUp1ItemTask2 by lazy {
        val tag = "pickUpItem"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 234,163,252,184,249,182,
            0.9797071F,0.7696262F,0.992161F,0.7696262F,1.0757353F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(765, 650), ruleRatio1 )
            //red196 green225 blue221 blockNumber1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(765, 650), ruleRatio1
            //red196 green225 blue221 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(814, 650), ruleRatio1
            //red191 green220 blue216 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(813, 655), ruleRatio1
            //red189 green215 blue212 blockNumber7
        ))
        pointList.add(PointRule(CoordinatePoint(783, 656), ruleRatio1
            //red189 green215 blue212 blockNumber8
        ))
        pointList.add(PointRule(CoordinatePoint(771, 660), ruleRatio1
            //red190 green219 blue217 blockNumber8
        ))
        pointList.add(PointRule(CoordinatePoint(816, 659), ruleRatio1
            //red200 green220 blue218 blockNumber10
        ))
        pointList.add(PointRule(CoordinatePoint(777, 663), ruleRatio1
            //red194 green219 blue215 blockNumber11
        ))
        pointList.add(PointRule(CoordinatePoint(780, 671), ruleRatio1
            //red201 green222 blue217 blockNumber11
        ))
        pointList.add(PointRule(CoordinatePoint(815, 675), ruleRatio1
            //red200 green225 blue222 blockNumber12
        ))
        pointList.add(PointRule(CoordinatePoint(811, 664), ruleRatio1
            //red200 green220 blue218 blockNumber13
        ))
        pointList.add(TwoPointRule(CoordinatePoint(765, 650),CoordinatePoint(762, 650), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(811, 658),CoordinatePoint(811, 661), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = pickUpTaskArea
        }
    }


    val pickUp1ItemTask1 by lazy {
        val tag = "pickUpItem"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 236,175,254,190,254,188,
            0.9879747F,0.78451324F,0.99615383F,0.78451324F,1.0794393F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 61,37,109,77,103,72,
            0.5968421F,0.41538462F,0.63707864F,0.41538462F,1.152439F, 0.91F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(759, 644), ruleRatio2
            //red44 green89 blue84
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(762, 647), ruleRatio1
            //red205 green230 blue227
        ))
        pointList.add(PointRule(CoordinatePoint(777, 647), ruleRatio1
            //red204 green229 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(810, 647), ruleRatio1
            //red207 green229 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(801, 648), ruleRatio1
            //red198 green223 blue220
        ))
        pointList.add(PointRule(CoordinatePoint(816, 652), ruleRatio1
            //red197 green222 blue218
        ))
        pointList.add(PointRule(CoordinatePoint(782, 653), ruleRatio1
            //red206 green228 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(798, 655), ruleRatio1
            //red199 green219 blue217
        ))
        pointList.add(PointRule(CoordinatePoint(773, 657), ruleRatio1
            //red197 green222 blue219
        ))
        pointList.add(PointRule(CoordinatePoint(798, 663), ruleRatio1
            //red201 green223 blue221
        ))
        pointList.add(PointRule(CoordinatePoint(782, 664), ruleRatio1
            //red201 green219 blue219
        ))
        pointList.add(PointRule(CoordinatePoint(762, 667), ruleRatio1
            //red207 green227 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(771, 668), ruleRatio1
            //red197 green222 blue218
        ))
        pointList.add(PointRule(CoordinatePoint(812, 668), ruleRatio1
            //red206 green228 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(798, 674), ruleRatio1
            //red208 green230 blue227
        ))
        pointList.add(PointRule(CoordinatePoint(770, 675), ruleRatio1
            //red201 green226 blue223
        ))
        pointList.add(PointRule(CoordinatePoint(759, 644), ruleRatio2
            //red44 green89 blue84
        ))
        pointList.add(PointRule(CoordinatePoint(779, 653), ruleRatio2
            //red50 green91 blue87
        ))
        pointList.add(PointRule(CoordinatePoint(767, 672), ruleRatio2
            //red46 green95 blue89
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = pickUpTaskArea
        }
    }

    private val pickUp1ItemTask = MultiImgContainmentTask(arrayOf(pickUp1ItemTask1,pickUp1ItemTask2,))
    val pickUpItemList by lazy {
        var i =0
        val tag = "pickUpItem"
        val task = pickUp1ItemTask
        val offset = itemOffset
        arrayOf(
            task,
            task.copyOffset("$tag${++i}",offset*i,0),
            task.copyOffset("$tag${++i}",offset*i,0),
        )
    }


    val refreshTaskArea by lazy { CoordinateArea(1311,176,245,92)}
    //是否可以刷新任务
    val isCanRefreshTask by lazy {
        val tag = "isCanRefresh"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 189,135,201,142,197,140,
            1.0101266F,0.80172414F,1.0230769F,0.80172414F,1.0791667F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 189,135,201,142,197,140,
            1.0101266F,0.80172414F,1.0230769F,0.80172414F,1.0791667F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1336, 216), ruleRatio1
            //red163 green178 blue175
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1345, 209), ruleRatio1
            //red157 green173 blue170
        ))
        pointList.add(PointRule(CoordinatePoint(1354, 212), ruleRatio1
            //red159 green178 blue174
        ))
        pointList.add(PointRule(CoordinatePoint(1336, 216), ruleRatio1
            //red163 green178 blue175
        ))
        pointList.add(PointRule(CoordinatePoint(1358, 223), ruleRatio1
            //red169 green181 blue179
        ))
        pointList.add(PointRule(CoordinatePoint(1335, 224), ruleRatio1
            //red170 green185 blue182
        ))
        pointList.add(PointRule(CoordinatePoint(1342, 232), ruleRatio1
            //red176 green191 blue186
        ))
        pointList.add(PointRule(CoordinatePoint(1337, 239), ruleRatio1
            //red160 green169 blue166
        ))
        pointList.add(PointRule(CoordinatePoint(1347, 241), ruleRatio1
            //red155 green164 blue161
        ))
        pointList.add(PointRule(CoordinatePoint(1325, 196), ruleRatio2
            //red16 green18 blue17
        ))
        pointList.add(PointRule(CoordinatePoint(1321, 204), ruleRatio2
            //red17 green19 blue18
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea =refreshTaskArea
        }
    }


    //接取任务 前往的点击区域
   private val isQianWangTask1 by lazy {
        val tag = "isQianWang"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 234,181,253,201,250,198,
            0.98122275F,0.7943478F,0.9942478F,0.7943478F,1.0733334F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 59,36,109,78,102,73,
            0.590625F,0.41F,0.6346154F,0.41F,1.152439F, 0.9206897F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1745, 893), ruleRatio2
            //red46 green91 blue86
        ))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1748, 896), ruleRatio1
            //red204 green229 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(1764, 896), ruleRatio1
            //red209 green231 blue229
        ))
        pointList.add(PointRule(CoordinatePoint(1782, 896), ruleRatio1
            //red205 green230 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(1787, 902), ruleRatio1
            //red202 green228 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(1802, 902), ruleRatio1
            //red203 green228 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(1753, 906), ruleRatio1
            //red207 green227 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(1761, 907), ruleRatio1
            //red206 green228 blue225
        ))
        pointList.add(PointRule(CoordinatePoint(1744, 910), ruleRatio1
            //red206 green225 blue223
        ))
        pointList.add(PointRule(CoordinatePoint(1796, 910), ruleRatio1
            //red212 green230 blue230
        ))
        pointList.add(PointRule(CoordinatePoint(1749, 917), ruleRatio1
            //red207 green229 blue226
        ))
        pointList.add(PointRule(CoordinatePoint(1781, 920), ruleRatio1
            //red205 green227 blue224
        ))
        pointList.add(PointRule(CoordinatePoint(1796, 921), ruleRatio1
            //red205 green225 blue223
        ))
        pointList.add(PointRule(CoordinatePoint(1767, 923), ruleRatio1
            //red210 green230 blue228
        ))
        pointList.add(PointRule(CoordinatePoint(1745, 893), ruleRatio2
            //red46 green91 blue86
        ))
        pointList.add(PointRule(CoordinatePoint(1784, 917), ruleRatio2
            //red47 green89 blue85
        ))
        pointList.add(PointRule(CoordinatePoint(1764, 920), ruleRatio2
            //red44 green91 blue85
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //接取任务 前往的点击区域
   private val isQianWangTask2 by lazy {
        val tag = "isQianWang"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 233,155,253,183,250,179,
            0.977897F,0.7632353F,0.9906522F,0.7632353F,1.0807316F, 0.90398234F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1770, 903), ruleRatio1))
            //red203 green229 blue226 blockNumber1
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1770, 903), ruleRatio1
            //red203 green229 blue226 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1777, 903), ruleRatio1
            //red199 green224 blue220 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1793, 918), ruleRatio1
            //red205 green227 blue224 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1781, 906), ruleRatio1
            //red180 green206 blue203 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1748, 908), ruleRatio1
            //red206 green231 blue228 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1747, 922), ruleRatio1
            //red186 green211 blue207 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1764, 924), ruleRatio1
            //red184 green213 blue209 blockNumber6
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1751, 899),CoordinatePoint(1748, 899), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1781, 906),CoordinatePoint(1782, 903), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1764, 924),CoordinatePoint(1764, 921), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }





    val isQianWangTask = MultiImgContainmentTask(arrayOf(isQianWangTask1,isQianWangTask2))
    //点击前往区域
    val qianWangArea by lazy { CoordinateArea(1585,856,374,106)}
    //点击放弃任务
    val abandonTaskArea by lazy { CoordinateArea(1730,196,230,80)}


    val endNormalArea by lazy { CoordinateArea(2078,330,125,125)}
    //右边的正常的图片
    val isEndNormalTask by lazy {
        val tag = "isEndNormal"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 217,168,216,167,215,167,
            1.0612903F,0.89047617F,1.0724598F,0.89047617F,1.0780748F, 0.89518714F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 217,168,216,167,215,167,
            1.0612903F,0.89047617F,1.0724598F,0.89047617F,1.0780748F, 0.89518714F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2141, 386), ruleRatio1
            //red206 green206 blue204
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2159, 366), ruleRatio1
            //red194 green193 blue191
        ))
        pointList.add(PointRule(CoordinatePoint(2164, 380), ruleRatio1
            //red191 green191 blue191
        ))
        pointList.add(PointRule(CoordinatePoint(2141, 386), ruleRatio1
            //red206 green206 blue204
        ))
        pointList.add(PointRule(CoordinatePoint(2116, 389), ruleRatio1
            //red192 green192 blue190
        ))
        pointList.add(PointRule(CoordinatePoint(2126, 405), ruleRatio1
            //red202 green204 blue203
        ))
        pointList.add(PointRule(CoordinatePoint(2157, 405), ruleRatio1
            //red199 green199 blue199
        ))
        pointList.add(PointRule(CoordinatePoint(2131, 413), ruleRatio1
            //red192 green192 blue190
        ))
        pointList.add(PointRule(CoordinatePoint(2151, 413), ruleRatio1
            //red190 green190 blue190
        ))
        pointList.add(PointRule(CoordinatePoint(2138, 363), ruleRatio2
            //red27 green27 blue25
        ))
        pointList.add(PointRule(CoordinatePoint(2164, 393), ruleRatio2
            //red33 green33 blue33
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
             clickArea=endNormalArea
        }
    }



    val isEndNormalList by lazy {
        var i =0
        val tag = "isEndNormal"
        val task = isEndNormalTask
        val offset = 173
        arrayOf(
            task,
            task.copyOffset("$tag${++i}",0,offset*i),
            task.copyOffset("$tag${++i}",0,offset*i),
        )
    }



    //确定按钮
    val isConfirmDialogTask2 by lazy {
        val tag = "isConfirmDialog"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 237,177,256,191,254,190,
            0.99661016F,0.785022F,1.0055084F,0.785022F,1.078F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2121, 809), ruleRatio1))
            //red208 green233 blue229 blockNumber1
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 20, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2121, 809), ruleRatio1
            //red208 green233 blue229 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2153, 833), ruleRatio1
            //red208 green230 blue227 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(2124, 835), ruleRatio1
            //red202 green227 blue224 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(2144, 812), ruleRatio1
            //red207 green229 blue227 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(2118, 814), ruleRatio1
            //red201 green223 blue220 blockNumber6
        ))
        pointList.add(PointRule(CoordinatePoint(2131, 818), ruleRatio1
            //red210 green232 blue229 blockNumber7
        ))
        pointList.add(PointRule(CoordinatePoint(2138, 819), ruleRatio1
            //red201 green230 blue228 blockNumber8
        ))
        pointList.add(PointRule(CoordinatePoint(2143, 834), ruleRatio1
            //red208 green228 blue226 blockNumber8
        ))
        pointList.add(PointRule(CoordinatePoint(2160, 828), ruleRatio1
            //red201 green226 blue222 blockNumber9
        ))
        pointList.add(PointRule(CoordinatePoint(2107, 833), ruleRatio1
            //red201 green221 blue219 blockNumber11
        ))
        pointList.add(PointRule(CoordinatePoint(2162, 832), ruleRatio1
            //red210 green232 blue230 blockNumber12
        ))
        pointList.add(TwoPointRule(CoordinatePoint(2121, 809),CoordinatePoint(2121, 806), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(2117, 833),CoordinatePoint(2120, 833), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(2165, 836),CoordinatePoint(2165, 839), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isConfirmDialogTask1 by lazy {
        val tag = "isConfirmDialog"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 238,163,254,181,250,180,
            0.9882353F,0.7690141F,0.9972803F,0.7690141F,1.0790323F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 64,38,109,78,101,73,
            0.61586535F,0.42065218F,0.6637931F,0.42065218F,1.15F, 0.927835F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2116, 804), ruleRatio2
            //red47 green94 blue88
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 50, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2160, 806), ruleRatio1
            //red216 green238 blue236
        ))
        pointList.add(PointRule(CoordinatePoint(2102, 807), ruleRatio1
            //red199 green224 blue221
        ))
        pointList.add(PointRule(CoordinatePoint(2119, 807), ruleRatio1
            //red207 green226 blue222
        ))
        pointList.add(PointRule(CoordinatePoint(2143, 807), ruleRatio1
            //red203 green228 blue224
        ))
        pointList.add(PointRule(CoordinatePoint(2138, 817), ruleRatio1
            //red188 green217 blue213
        ))
        pointList.add(PointRule(CoordinatePoint(2131, 830), ruleRatio1
            //red216 green235 blue233
        ))
        pointList.add(PointRule(CoordinatePoint(2123, 833), ruleRatio1
            //red212 green234 blue231
        ))
        pointList.add(PointRule(CoordinatePoint(2112, 836), ruleRatio1
            //red185 green210 blue206
        ))
        pointList.add(PointRule(CoordinatePoint(2152, 836), ruleRatio1
            //red210 green230 blue228
        ))
        pointList.add(PointRule(CoordinatePoint(2168, 836), ruleRatio1
            //red211 green231 blue229
        ))
        pointList.add(PointRule(CoordinatePoint(2116, 804), ruleRatio2
            //red47 green94 blue88
        ))
        pointList.add(PointRule(CoordinatePoint(2151, 833), ruleRatio2
            //red55 green95 blue87
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isConfirmDialogTask = MultiImgContainmentTask(arrayOf(isConfirmDialogTask1,isConfirmDialogTask2))

    val confirmDialogEnsureArea by lazy { CoordinateArea(1976,761,317,118)}
    val confirmDialogCancelArea by lazy { CoordinateArea(1639,763,318,119)}


    val leftDialogArea by lazy { CoordinateArea(426,432,485,125)}
    //左边的对话框
    val isShowLeftDialogBox by lazy {
        val tag = "isShowLeftDialog"

        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 48,27,97,58,84,50,
            0.6211268F,0.41447368F,0.70000005F,0.41447368F,1.2438462F, 1.0016129F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 56,37,160,95,135,81,
            0.45652172F,0.31176472F,0.530303F,0.31176472F,1.2583333F, 1.040625F)
        val ruleRatio3 =  ColorRuleRatioImpl.getSimple( 58,47,163,138,137,116,
            0.37692308F,0.30974028F,0.44885495F,0.30974028F,1.2534883F, 1.0717556F)
        val ruleRatio4 =  ColorRuleRatioImpl.getSimple( 42,24,67,43,59,39,
            0.72413796F,0.48571432F,0.80769235F,0.48571432F,1.2115384F, 0.9574468F)
        val ruleRatio5 =  ColorRuleRatioImpl.getSimple( 48,31,108,70,92,61,
            0.4871134F,0.35816327F,0.5762195F,0.35816327F,1.242073F, 1.0216217F)
        val ruleRatio6 =  ColorRuleRatioImpl.getSimple( 33,23,65,42,58,38,
            0.5808511F,0.45F,0.6348837F,0.45F,1.1886792F, 0.98333335F)
        val ruleRatio7 =  ColorRuleRatioImpl.getSimple( 35,30,80,68,70,59,
            0.46973684F,0.3974026F,0.54090905F,0.3974026F,1.2090908F, 1.0343283F)
        val ruleRatio8 =  ColorRuleRatioImpl.getSimple( 131,99,112,92,192,161,
            1.25F,0.9699029F,0.7291666F,0.9699029F,0.62765366F, 0.5065574F)

        val ruleList = listOf(ruleRatio1,ruleRatio2,ruleRatio3,ruleRatio4,ruleRatio5,ruleRatio6,ruleRatio7,ruleRatio8)

        val correctPositionModel = null
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRules(CoordinatePoint(888, 531), ruleList
            //red61 green153 blue130
        ))
        pointList.add(PointRules(CoordinatePoint(913, 530), ruleList
            //red52 green116 blue100
        ))
        pointList.add(PointRules(CoordinatePoint(936, 531), ruleList
            //red41 green74 blue67
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val rightDialogArea by lazy { CoordinateArea(1656,345,420,143)}
    val isShowRightDialogBox by lazy {
        val tag = "isShowRightDialog"

        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 48,27,97,58,84,50,
            0.6211268F,0.41447368F,0.70000005F,0.41447368F,1.2438462F, 1.0016129F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 56,37,160,95,135,81,
            0.45652172F,0.31176472F,0.530303F,0.31176472F,1.2583333F, 1.040625F)
        val ruleRatio3 =  ColorRuleRatioImpl.getSimple( 58,47,163,138,137,116,
            0.37692308F,0.30974028F,0.44885495F,0.30974028F,1.2534883F, 1.0717556F)
        val ruleRatio4 =  ColorRuleRatioImpl.getSimple( 42,24,67,43,59,39,
            0.72413796F,0.48571432F,0.80769235F,0.48571432F,1.2115384F, 0.9574468F)
        val ruleRatio5 =  ColorRuleRatioImpl.getSimple( 48,31,108,70,92,61,
            0.4871134F,0.35816327F,0.5762195F,0.35816327F,1.242073F, 1.0216217F)
        val ruleRatio6 =  ColorRuleRatioImpl.getSimple( 33,23,65,42,58,38,
            0.5808511F,0.45F,0.6348837F,0.45F,1.1886792F, 0.98333335F)
        val ruleRatio7 =  ColorRuleRatioImpl.getSimple( 35,30,80,68,70,59,
            0.46973684F,0.3974026F,0.54090905F,0.3974026F,1.2090908F, 1.0343283F)
        val ruleRatio8 =  ColorRuleRatioImpl.getSimple( 131,99,112,92,192,161,
            1.25F,0.9699029F,0.7291666F,0.9699029F,0.62765366F, 0.5065574F)

        val ruleList = listOf(ruleRatio1,ruleRatio2,ruleRatio3,ruleRatio4,ruleRatio5,ruleRatio6,ruleRatio7,ruleRatio8)
        val correctPositionModel = null
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRules(CoordinatePoint(2025, 467), ruleList
            //red61 green153 blue130
        ))
        pointList.add(PointRules(CoordinatePoint(2048, 468), ruleList
            //red52 green116 blue100
        ))
        pointList.add(PointRules(CoordinatePoint(2071, 467), ruleList
            //red41 green74 blue67
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }






    //是否可以锁定的按钮 注意这里需要对颜色调整，会有变化范围
    val isCanLockTask by lazy {
        val tag = "isCanLock"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 144,98,155,104,152,101,
            1.0418605F,0.8007353F,1.1294118F,0.8007353F,1.1431452F, 0.9132353F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 150,121,160,127,156,119,
            1.0278169F,0.81543624F,1.0973684F,0.81543624F,1.126087F, 0.9183673F)
        val ruleRatio3 =  ColorRuleRatioImpl.getSimple( 239,201,195,162,161,134,
            1.3110498F,1.0994594F,1.596F,1.0994594F,1.3036913F, 1.0705882F)

       val ruleList =  listOf(ruleRatio1,ruleRatio2,ruleRatio3)

       val list = mutableListOf<PointRule>()

        list.add(PointRule(CoordinatePoint(1423, 676), ColorRuleImpl.getAllOver(90)
            //red128 green138 blue137
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRules(CoordinatePoint(1434, 676), ruleList
            //red116 green125 blue124
        ))
        pointList.add(PointRules(CoordinatePoint(1458, 678), ruleList
            //red128 green138 blue137
        ))
        pointList.add(PointRules(CoordinatePoint(1422, 679), ruleList
            //red126 green136 blue135
        ))
        pointList.add(PointRules(CoordinatePoint(1463, 686), ruleList
            //red126 green132 blue132
        ))
        pointList.add(PointRules(CoordinatePoint(1427, 687), ruleList
            //red122 green128 blue128
        ))
        pointList.add(PointRules(CoordinatePoint(1439, 694), ruleList
            //red130 green139 blue138
        ))
        pointList.add(PointRules(CoordinatePoint(1423, 695), ruleList
            //red119 green128 blue127
        ))
        pointList.add(PointRules(CoordinatePoint(1448, 702), ruleList
            //red116 green122 blue120
        ))
        pointList.add(PointRules(CoordinatePoint(1440, 703), ruleList
            //red116 green120 blue121
        ))
        pointList.add(PointRules(CoordinatePoint(1434, 706), ruleList
            //red129 green135 blue135
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1422, 679),CoordinatePoint(1417, 683), CompareDifferenceRuleImpl.getSimple(15,15,15)
            //red24 green24 blue26
        )
        )
        pointList.add(TwoPointRule(CoordinatePoint(1458, 678),CoordinatePoint(1455, 689), CompareDifferenceRuleImpl.getSimple(15,15,15)
            //red20 green20 blue22
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
             nErrorTolerance = 2
        }
    }
    val lockTargetArea by lazy { CoordinateArea(1391,640,96,96)}




    val bottomDeviceArea by lazy { CoordinateArea(1666,953,74,79)}
    val isBottomDeviceTask by lazy {
        val tag = "isBottomDevice"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 227,153,266,199,255,186,
            0.90059286F,0.69324327F,0.9376543F,0.69324327F,1.1315068F, 0.937037F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1704, 949), ruleRatio1
            //red213 green255 blue243
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 1,1, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1704, 949), ruleRatio1
            //red213 green255 blue243
        ))
        pointList.add(PointRule(CoordinatePoint(1706, 949), ruleRatio1
            //red204 green251 blue235
        ))
        pointList.add(PointRule(CoordinatePoint(1710, 950), ruleRatio1
            //red209 green253 blue238
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance =2
            clickArea= bottomDeviceArea
        }
    }

    val topDeviceArea by lazy { CoordinateArea(1671,843,64,68)}
    val isTopDeviceTask by lazy {
        val tag = "isTopDevice"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 229,163,267,206,255,191,
            0.9125F,0.7055085F,0.9462963F,0.7055085F,1.1406819F, 0.93333334F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1704, 835), ruleRatio1
            //red213 green254 blue240
        ))
       val correctPositionModel =CorrectPositionModel(list, tag, 1, 1, true)
        val pointList = mutableListOf<IPR>()

        pointList.add(PointRule(CoordinatePoint(1704, 835), ruleRatio1
            //red213 green254 blue240
        ))
        pointList.add(PointRule(CoordinatePoint(1706, 835), ruleRatio1
            //red206 green250 blue235
        ))
        pointList.add(PointRule(CoordinatePoint(1710, 836), ruleRatio1
            //red208 green252 blue237
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            nErrorTolerance =2
            clickArea= topDeviceArea
        }
    }


    val BottomDeviceOffset = 109
    val topDeviceList by lazy {
        var i =0
        val tag = "isTopDevice"
        val task = isTopDeviceTask
        arrayOf(
            task,
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
        )
    }

    val bottomDeviceList by lazy {
        var i =0
        val tag = "isBottomDevice"
        val task = isBottomDeviceTask
        arrayOf(
            task,
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
            task.copyOffset("$tag${++i}",BottomDeviceOffset*i,0),
        )
    }



    val isBigNormalTask by lazy {
        val tag = "isBigNormal"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 218,163,220,164,221,164,
            1.05F,0.8809524F,1.06123F,0.8809524F,1.06123F, 0.8902703F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 218,163,220,164,221,164,
            1.05F,0.8809524F,1.06123F,0.8809524F,1.06123F, 0.8902703F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1087, 565), ruleRatio1
            //red194 green195 blue197
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1087, 565), ruleRatio1
            //red194 green195 blue197
        ))
        pointList.add(PointRule(CoordinatePoint(1122, 565), ruleRatio1
            //red191 green192 blue194
        ))
        pointList.add(PointRule(CoordinatePoint(1082, 578), ruleRatio1
            //red189 green190 blue192
        ))
        pointList.add(PointRule(CoordinatePoint(1127, 579), ruleRatio1
            //red192 green193 blue195
        ))
        pointList.add(PointRule(CoordinatePoint(1103, 585), ruleRatio1
            //red203 green204 blue206
        ))
        pointList.add(PointRule(CoordinatePoint(1128, 597), ruleRatio1
            //red190 green190 blue190
        ))
        pointList.add(PointRule(CoordinatePoint(1093, 612), ruleRatio1
            //red197 green197 blue197
        ))
        pointList.add(PointRule(CoordinatePoint(1125, 599), ruleRatio2
            //red40 green42 blue41
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //这个是刚进入的 是否存在任务
    val isBigNormalList by lazy {
        var i =0
        val tag = "isBigNormal"
        val task = isBigNormalTask
        val offset = 171
        arrayOf(
            task,
            task.copyOffset("$tag${++i}",0,offset*i),
            task.copyOffset("$tag${++i}",0,offset*i),
        )
    }

    val openWarehouseItemArea by lazy { CoordinateArea(88,143,68,69)}
    val openJiYuItemArea by lazy { CoordinateArea(198,145,79,71)}
    val openCaiItemArea by lazy { CoordinateArea(322,141,71,75)}
    val isNojiYuTask by lazy {
        val tag = "isNojiYu"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 53,43,102,83,97,79,
            0.5578125F,0.44081634F,0.6016854F,0.44081634F,1.1561798F, 0.9290322F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 53,43,102,83,97,79,
            0.5578125F,0.44081634F,0.6016854F,0.44081634F,1.1561798F, 0.9290322F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1212, 810), ruleRatio1
            //red47 green94 blue88 blockNumber0
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1212, 810), ruleRatio1
            //red47 green94 blue88 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1212, 821), ruleRatio1
            //red47 green94 blue88 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1212, 833), ruleRatio1
            //red48 green95 blue89 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1212, 845), ruleRatio1
            //red48 green95 blue89 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1221, 847), ruleRatio1
            //red49 green96 blue90 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1245, 847), ruleRatio1
            //red48 green93 blue86 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1207, 810), ruleRatio2
            //red24 green33 blue32 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1207, 844), ruleRatio2
            //red25 green34 blue33 blockNumber0
        ))
        pointList.add(PointRule(CoordinatePoint(1245, 852), ruleRatio2
            //red28 green34 blue34 blockNumber0
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val goJiyuListMenuArea by lazy { CoordinateArea(1207,740,650,111)} //前往公告版
    val startJiyuBigArea by lazy { CoordinateArea(1893,512,144,154)} //这个是打开对话框
    val openJiyuBigArea by lazy { CoordinateArea(1190,531,680,119)}  //这个是打开可以进行放弃


    private val itemTopOffset = 378  //X 条目X轴位 378
    private val topItemInver =130
    val topLockTarget by lazy {
        val tag = "topLockTarget"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 199,135,187,132,185,128,
            1.1437501F,0.8333333F,1.1694611F,0.8333333F,1.0968152F, 0.8835366F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 199,135,187,132,185,128,
            1.1437501F,0.8333333F,1.1694611F,0.8333333F,1.0968152F, 0.8835366F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2184, 87), ruleRatio1
            //red173 green173 blue173
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 1, 1, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2184, 87), ruleRatio1
            //red173 green173 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(2188, 57), ruleRatio1
            //red172 green172 blue172
        ))
        pointList.add(PointRule(CoordinatePoint(2215, 40), ruleRatio1
            //red173 green173 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(2227, 42), ruleRatio1
            //red172 green172 blue172
        ))
        pointList.add(PointRule(CoordinatePoint(2189, 82), ruleRatio2
            //red27 green25 blue26
        ))
        pointList.add(PointRule(CoordinatePoint(2216, 45), ruleRatio2
            //red31 green31 blue31
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val topTargetHpTask by lazy {
        val tag = "topTargetHp"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 199,135,187,132,185,128,
            1.1437501F,0.8333333F,1.1694611F,0.8333333F,1.0968152F, 0.8835366F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2171, 104), ruleRatio1
            //red173 green173 blue173
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3 ,3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(2274, 85), ruleRatio1
            //red172 green172 blue170 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2258, 37), ruleRatio1
            //red161 green160 blue158 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2210, 22), ruleRatio1
            //red161 green165 blue166 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2168, 56), ruleRatio1
            //red172 green174 blue173 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(2171, 104), ruleRatio1
            //red162 green162 blue160 blockNumber1
        ))
        HpTaskImpl(pointList, tag, correctPositionModel)
    }

    //这个是关闭右边菜单
    val topLockTargetList1 by lazy {
        var i = 8
        val tag = "topLock1Target"
        val task = topLockTarget
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
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
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",-itemTopOffset,0),
        )
    }


    val topTargetHpList1 by lazy {
        var i = 8
        val tag = "topTargetHp1Task"
        val task = topTargetHpTask
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task.copyOffset("$tag${--i}",offset*i,0),
            task
        )
    }

    val topTargetHpList2 by lazy {
        var i = 8
        val tag = "topTargetHp2Task"
        val task = topTargetHpTask
        val offset = -topItemInver
        arrayOf(
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",offset*i-itemTopOffset,0),
            task.copyOffset("$tag${--i}",-itemTopOffset,0),
        )
    }

    fun getPositionArea(index:Int):CoordinateArea{
        return CoordinateArea(425,425+(index*75),60,62) //这个是根据2个跳的距离(左边跳转的距离)
    }

    val exitGameTask1 by lazy {
        val tag = "exitGameTask"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 233,177,253,198,249,197,
            0.9788136F,0.7929515F,0.9914163F,0.7929515F,1.0736487F, 0.90393007F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1050, 699), ruleRatio1))
        //red203 green225 blue222 blockNumber1
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1052, 690), ruleRatio1
            //red197 green223 blue220 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1050, 699), ruleRatio1
            //red203 green225 blue222 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1037, 692), ruleRatio1
            //red206 green231 blue227 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1059, 692), ruleRatio1
            //red200 green225 blue222 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1058, 695), ruleRatio1
            //red200 green225 blue222 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1044, 700), ruleRatio1
            //red208 green230 blue227 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1044, 709), ruleRatio1
            //red212 green232 blue230 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1052, 711), ruleRatio1
            //red201 green226 blue222 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1044, 718), ruleRatio1
            //red211 green233 blue230 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1059, 708), ruleRatio1
            //red210 green232 blue230 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1059, 714), ruleRatio1
            //red209 green231 blue228 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1038, 709), ruleRatio1
            //red200 green226 blue223 blockNumber8
        ))
        pointList.add(PointRule(CoordinatePoint(1034, 718), ruleRatio1
            //red199 green224 blue221 blockNumber8
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1052, 690),CoordinatePoint(1052, 687), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1044, 709),CoordinatePoint(1041, 710), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1034, 718),CoordinatePoint(1037, 718), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = CoordinateArea(1216,652,312,106)
        }
    }

    val exitGameTask2 by lazy {
        val tag = "exitGameTask"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 114,90,114,90,114,90,
            1.05F,0.9F,1.05F,0.9F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(931, 814), ruleRatio1 ) )
            //red101 green101 blue101 blockNumber1
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(931, 814), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(931, 829), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(918, 828), ruleRatio1
            //red108 green108 blue108 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(946, 829), ruleRatio1
            //red100 green100 blue100 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(916, 823), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(933, 834), ruleRatio1
            //red100 green100 blue100 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(931, 849), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(946, 851), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(917, 852), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(949, 840), ruleRatio1
            //red101 green101 blue101 blockNumber1
        ))
        pointList.add(TwoPointRule(CoordinatePoint(931, 814),CoordinatePoint(931, 812), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)))
        pointList.add(TwoPointRule(CoordinatePoint(933, 834),CoordinatePoint(934, 835), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel).apply {
            clickArea = CoordinateArea(723,770,462,131)
        }
    }

    val exitGameTask by lazy {
        MultiImgTask(arrayOf(exitGameTask1,exitGameTask2))
    }
}