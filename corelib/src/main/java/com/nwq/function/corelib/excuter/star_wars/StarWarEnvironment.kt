package com.nwq.function.corelib.excuter.star_wars

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioUnImpl
import com.nwq.function.corelib.img.task.CorrectPositionModel
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 */

object StarWarEnvironment {

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
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(844, 347), ColorRuleRatioImpl.getSimple(57, 58, 60)))
        val correctPositionModel = CorrectPositionModel(list, tag, 10, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(844, 347), ColorRuleRatioImpl.getSimple(57, 58, 60)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(861, 347), ColorRuleRatioImpl.getSimple(60, 61, 63)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(852, 356), ColorRuleRatioImpl.getSimple(56, 57, 59)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(841, 348), ColorRuleRatioUnImpl.getSimple(
                    79,
                    49,
                    80,
                    50,
                    82,
                    52,
                    1.1815385F,
                    0.7876923F,
                    1.1462687F,
                    0.7641791F,
                    1.1641792F,
                    0.7761194F
                )
                //red15 green16 blue18
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(864, 349), ColorRuleRatioUnImpl.getSimple(
                    79,
                    49,
                    80,
                    50,
                    82,
                    52,
                    1.1815385F,
                    0.7876923F,
                    1.1462687F,
                    0.7641791F,
                    1.1641792F,
                    0.7761194F
                )
                //red15 green16 blue18
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(849, 356), ColorRuleRatioUnImpl.getSimple(
                    79,
                    49,
                    80,
                    50,
                    82,
                    52,
                    1.1815385F,
                    0.7876923F,
                    1.1462687F,
                    0.7641791F,
                    1.1641792F,
                    0.7761194F
                )
                //red16 green17 blue19
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val updateGameArea by lazy { CoordinateArea(1206, 662, 315, 106) }


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

    //开启左边位置菜单
    val isOpenPositionMenuT by lazy {
        val tag = "isOpenPosition"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(467, 294), ColorRuleRatioImpl.getSimple(139, 148, 147)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(467, 294), ColorRuleRatioImpl.getSimple(139, 148, 147)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(476, 297), ColorRuleRatioImpl.getSimple(146, 149, 154)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(472, 303), ColorRuleRatioImpl.getSimple(155, 160, 164)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(478, 304), ColorRuleRatioImpl.getSimple(162, 167, 171)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(464, 295), ColorRuleRatioUnImpl.getSimple(
                    174,
                    104,
                    183,
                    113,
                    182,
                    112,
                    1.127027F,
                    0.75135136F,
                    1.1346939F,
                    0.7564626F,
                    1.2081633F,
                    0.80544215F
                )
                //red49 green49 blue47
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(469, 305), ColorRuleRatioUnImpl.getSimple(
                    174,
                    104,
                    183,
                    113,
                    182,
                    112,
                    1.127027F,
                    0.75135136F,
                    1.1346939F,
                    0.7564626F,
                    1.2081633F,
                    0.80544215F
                )
                //red42 green44 blue43
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //关闭左边位置菜单
    val isClosePositionMenuT by lazy {
        val tag = "isClosePositionMenuT"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(116, 282), ColorRuleRatioImpl.getSimple(124, 124, 124)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(124, 303), ColorRuleRatioImpl.getSimple(157, 162, 166)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(120, 309), ColorRuleRatioImpl.getSimple(153, 161, 164)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(116, 282), ColorRuleRatioImpl.getSimple(124, 124, 124)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(127, 284), ColorRuleRatioImpl.getSimple(125, 125, 125)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(111, 290), ColorRuleRatioImpl.getSimple(132, 132, 132)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(126, 294), ColorRuleRatioImpl.getSimple(141, 142, 144)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(115, 300), ColorRuleRatioImpl.getSimple(145, 155, 156)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(113, 279), ColorRuleRatioUnImpl.getSimple(
                    185,
                    115,
                    193,
                    113,
                    200,
                    120,
                    1.1764706F,
                    0.78431374F,
                    1.125F,
                    0.75F,
                    1.1475F,
                    0.76500005F
                )
                //red35 green36 blue38
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(123, 291), ColorRuleRatioUnImpl.getSimple(
                    185,
                    115,
                    193,
                    113,
                    200,
                    120,
                    1.1764706F,
                    0.78431374F,
                    1.125F,
                    0.75F,
                    1.1475F,
                    0.76500005F
                )
                //red35 green41 blue41
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(117, 310), ColorRuleRatioUnImpl.getSimple(
                    185,
                    115,
                    193,
                    113,
                    200,
                    120,
                    1.1764706F,
                    0.78431374F,
                    1.125F,
                    0.75F,
                    1.1475F,
                    0.76500005F
                )
                //red41 green45 blue46
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openPositionArea by lazy { CoordinateArea(85, 258, 71, 74) }

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
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2231, 603), ColorRuleRatioImpl.getSimple(158, 158, 158)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(2231, 603), ColorRuleRatioImpl.getSimple(158, 158, 158)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2248, 604), ColorRuleRatioImpl.getSimple(159, 159, 159)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2264, 606), ColorRuleRatioImpl.getSimple(163, 163, 163)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2258, 610), ColorRuleRatioImpl.getSimple(169, 169, 169)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2235, 611), ColorRuleRatioImpl.getSimple(167, 167, 167)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2246, 615), ColorRuleRatioImpl.getSimple(177, 177, 177)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(2255, 607), ColorRuleRatioUnImpl.getSimple(
                    198, 118, 198, 118, 198, 118, 1.2F, 0.8F, 1.2F, 0.8F, 1.2F, 0.8F
                )
                //red28 green28 blue28
            )
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }
    val openEyeMenuArea by lazy { CoordinateArea(2211, 570, 75, 71) }

    val isOpenEyeMenuT by lazy {
        val tag = "isOpenEyeMenu"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1876, 608), ColorRuleRatioImpl.getSimple(26, 26, 26)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(
                CoordinatePoint(1854, 603), ColorRuleRatioImpl.getSimple(158, 158, 158)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1884, 603), ColorRuleRatioImpl.getSimple(156, 156, 156)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1870, 605), ColorRuleRatioImpl.getSimple(159, 159, 159)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1859, 607), ColorRuleRatioImpl.getSimple(164, 164, 164)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1886, 607), ColorRuleRatioImpl.getSimple(163, 163, 163)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1879, 611), ColorRuleRatioImpl.getSimple(168, 168, 168)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1868, 615), ColorRuleRatioImpl.getSimple(177, 177, 177)
            )
        )
        pointList.add(
            PointRule(
                CoordinatePoint(1876, 608), ColorRuleRatioUnImpl.getSimple(
                    197, 117, 197, 117, 197, 117, 1.2F, 0.8F, 1.2F, 0.8F, 1.2F, 0.8F
                )
                //red26 green26 blue26
            )
        )
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



    val item1IsNormalTask by lazy {
        val tag = "item1IsNormal"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 126,74,141,88,140,88,
            0.94029856F,0.72692305F,0.95307696F,0.72692305F,1.0881817F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(611, 319), ColorRuleRatioImpl.getSimple(45,65,64)))
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
        pointList.add(PointRule(CoordinatePoint(624, 351), ruleRatio1
            //red92 green111 blue109
        ))
        pointList.add(PointRule(CoordinatePoint(620, 359), ruleRatio1
            //red116 green132 blue131
        ))
        pointList.add(PointRule(CoordinatePoint(611, 319), ColorRuleRatioImpl.getSimple(45,65,64)))
        pointList.add(PointRule(CoordinatePoint(644, 330), ColorRuleRatioImpl.getSimple(54,74,73)))
        pointList.add(PointRule(CoordinatePoint(618, 356), ColorRuleRatioImpl.getSimple(54,72,72)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }





}