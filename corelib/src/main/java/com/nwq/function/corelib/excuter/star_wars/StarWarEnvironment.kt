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
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, true)
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
        arrayOf(item1IsNormalTask,
            item1IsNormalTask.copyOffset("item2IsNormal",itemOffset,0),
            item1IsNormalTask.copyOffset("item3IsNormal",itemOffset*2,0))
    }

    val item1ZeroDistanceTask by lazy {
        val tag = "item1ZeroDistance"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 155,103,161,108,161,108,
            1.0191176F,0.8386364F,1.0116788F,0.8386364F,1.0580152F, 0.8780488F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 155,103,161,108,161,108,
            1.0191176F,0.8386364F,1.0116788F,0.8386364F,1.0580152F, 0.8780488F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(606, 492), ColorRuleRatioImpl.getSimple(49,53,56)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(609, 495), ruleRatio1
            //red129 green133 blue134
        ))
        pointList.add(PointRule(CoordinatePoint(616, 496), ruleRatio1
            //red116 green122 blue122
        ))
        pointList.add(PointRule(CoordinatePoint(608, 501), ruleRatio1
            //red147 green153 blue153
        ))
        pointList.add(PointRule(CoordinatePoint(617, 502), ruleRatio1
            //red120 green126 blue126
        ))
        pointList.add(PointRule(CoordinatePoint(608, 507), ruleRatio1
            //red147 green153 blue153
        ))
        pointList.add(PointRule(CoordinatePoint(617, 508), ruleRatio1
            //red120 green126 blue126
        ))
        pointList.add(PointRule(CoordinatePoint(612, 512), ruleRatio1
            //red131 green137 blue137
        ))
        pointList.add(PointRule(CoordinatePoint(606, 492), ruleRatio2
            //red49 green53 blue56
        ))
        pointList.add(PointRule(CoordinatePoint(613, 493), ruleRatio2
            //red49 green53 blue56
        ))
        pointList.add(PointRule(CoordinatePoint(611, 509), ruleRatio2
            //red55 green59 blue62
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsZeroDistanceList by lazy {
        arrayOf(item1ZeroDistanceTask,
            item1ZeroDistanceTask.copyOffset("item2ZeroDistance",itemOffset,0),
            item1ZeroDistanceTask.copyOffset("item3ZeroDistance",itemOffset*2,0))
    }

    val item1OneDistanceTask by lazy {
        val tag = "item2OneDistance"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 151,117,157,122,157,122,
            1.0197841F,0.8602941F,1.0125F,0.8602941F,1.05F, 0.89357144F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 69,45,73,47,74,49,
            1.0333333F,0.8169231F,1.0015385F,0.8169231F,1.05F, 0.83793104F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(1076, 495), ruleRatio1
            //red130 green136 blue136
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1076, 495), ruleRatio1
            //red130 green136 blue136
        ))
        pointList.add(PointRule(CoordinatePoint(1076, 501), ruleRatio1
            //red137 green143 blue143
        ))
        pointList.add(PointRule(CoordinatePoint(1076, 507), ruleRatio1
            //red137 green143 blue143
        ))
        pointList.add(PointRule(CoordinatePoint(1073, 512), ruleRatio1
            //red134 green140 blue140
        ))
        pointList.add(PointRule(CoordinatePoint(1079, 512), ruleRatio1
            //red135 green139 blue140
        ))
        pointList.add(PointRule(CoordinatePoint(1073, 492), ruleRatio2
            //red51 green55 blue56
        ))
        pointList.add(PointRule(CoordinatePoint(1073, 504), ruleRatio2
            //red52 green56 blue59
        ))
        pointList.add(PointRule(CoordinatePoint(1079, 509), ruleRatio2
            //red58 green62 blue63
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val IsOneDistanceList by lazy {
        arrayOf(
            item1OneDistanceTask.copyOffset("item1OneDistance",-itemOffset,0),
            item1OneDistanceTask,
            item1OneDistanceTask.copyOffset("item3OneDistance",itemOffset,0))
    }


    val pickUp1ItemTask by lazy {
        val tag = "pickUp1Item"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 236,175,254,190,254,188,
            0.9879747F,0.78451324F,0.99615383F,0.78451324F,1.0794393F, 0.9F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 61,37,109,77,103,72,
            0.5968421F,0.41538462F,0.63707864F,0.41538462F,1.152439F, 0.91F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(759, 644), ruleRatio2
            //red44 green89 blue84
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 20, true)
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
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    //pickUpTask
    val pickUpTaskArea by lazy { CoordinateArea(565,626,451,70)}

    val pickUpItemList by lazy {
        arrayOf(
            pickUp1ItemTask,
            pickUp1ItemTask.copyOffset("pickUp2Item",itemOffset,0),
            pickUp1ItemTask.copyOffset("pickUp3Item",itemOffset*2,0))
    }


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
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val refreshTaskArea by lazy { CoordinateArea(1311,176,245,92)}

    private val itemTopOffset = 378  //X 条目X轴位 378
    private val topItemInver =130

    val topLockTarget by lazy {
        val tag = "pickUp1Item"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 199,135,187,132,185,128,
            1.1437501F,0.8333333F,1.1694611F,0.8333333F,1.0968152F, 0.8835366F)
        val ruleRatio2 =  ColorRuleRatioUnImpl.getSimple( 199,135,187,132,185,128,
            1.1437501F,0.8333333F,1.1694611F,0.8333333F,1.0968152F, 0.8835366F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(2184, 87), ruleRatio1
            //red173 green173 blue173
        ))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, true)
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
        pointList.add(PointRule(CoordinatePoint(2244, 49), ruleRatio1
            //red173 green173 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(2249, 96), ruleRatio1
            //red174 green174 blue172
        ))
        pointList.add(PointRule(CoordinatePoint(2253, 65), ruleRatio1
            //red173 green173 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(2256, 78), ruleRatio1
            //red173 green173 blue173
        ))
        pointList.add(PointRule(CoordinatePoint(2189, 82), ruleRatio2
            //red27 green25 blue26
        ))
        pointList.add(PointRule(CoordinatePoint(2216, 45), ruleRatio2
            //red31 green31 blue31
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val topLockTargetList by lazy {
        arrayOf(
            topLockTarget.copyOffset("pickUp8Item",-topItemInver*7,0),
            topLockTarget.copyOffset("pickUp7Item",-topItemInver*6,0),
            topLockTarget.copyOffset("pickUp6Item",-topItemInver*5,0),
            topLockTarget.copyOffset("pickUp5Item",-topItemInver*4,0),
            topLockTarget.copyOffset("pickUp4Item",-topItemInver*3,0),
            topLockTarget.copyOffset("pickUp3Item",-topItemInver*2,0),
            topLockTarget.copyOffset("pickUp2Item",-topItemInver,0),
            topLockTarget,
        )
    }

    val topLockTargetList2 by lazy {
        arrayOf(
            topLockTarget.copyOffset("pickUp8ItemO",-topItemInver*7 -itemTopOffset,0),
            topLockTarget.copyOffset("pickUp7ItemO",-topItemInver*6-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp6ItemO",-topItemInver*5-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp5ItemO",-topItemInver*4-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp4ItemO",-topItemInver*3-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp3ItemO",-topItemInver*2-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp2ItemO",-topItemInver-itemTopOffset,0),
            topLockTarget.copyOffset("pickUp1ItemO",-itemTopOffset,0),
        )
    }

}