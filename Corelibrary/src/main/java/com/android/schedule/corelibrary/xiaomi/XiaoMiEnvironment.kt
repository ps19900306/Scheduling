package com.android.schedule.corelibrary.xiaomi

import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule

object XiaoMiEnvironment {

    //这个是又顶部向底部滑动
    val bottomToTop by lazy {
        ClickTask(listOf(CoordinatePoint(511, 335 + 1894), CoordinatePoint(511, 335)), 0, 2000)
    }

    //這個華東更小且更慢
    val bottomToTopCenter by lazy {
        ClickTask(listOf(CoordinatePoint(508, 1157 + 499), CoordinatePoint(508, 1157)), 0, 2000)
    }

    val homeGameCenterArea by lazy {
        ClickArea(483, 2148, 118, 117, false)
    }

    //这个在主界面時候的游戏中心
    val isHomeGameCenterTask by lazy {
        val tag = "isHomeGameCenter"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(561, 2182), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(561, 2186), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:10 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(561, 2186),
                CoordinatePoint(561, 2190),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 2192), ColorRuleRatioImpl.getSimple(255, 128, 78))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 2196), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:11 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(551, 2196),
                CoordinatePoint(551, 2200),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(572, 2192), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(571, 2196), ColorRuleRatioImpl.getSimple(255, 128, 78))
            // sequenceNumber:11 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(571, 2196),
                CoordinatePoint(571, 2200),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(562, 2202), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(562, 2207), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:11 blockNumber: 3  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(562, 2207),
                CoordinatePoint(562, 2210),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val homeGameCenter2Area by lazy { ClickArea(483, 2011, 115, 101, false) }
    val isHomeGameCenter2Task by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(561, 2040), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(561, 2044), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:10 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(561, 2044),
                CoordinatePoint(561, 2048),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 2050), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 2054), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:11 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(551, 2054),
                CoordinatePoint(551, 2058),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(572, 2050), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(571, 2054), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:11 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(571, 2054),
                CoordinatePoint(571, 2058),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(562, 2060), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(562, 2065), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:11 blockNumber: 3  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(562, 2065),
                CoordinatePoint(562, 2068),
                CompareDifferenceRuleImpl.getSimple(0, -30, -40)
            ) // sequenceNumber:11sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val showCloseArea by lazy {
        ClickArea(513, 1733, 55, 54, false)
    }
    val isShowCloseTask by lazy {
        val tag = "isShowClose"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            235,
            185,
            235,
            195,
            235,
            195,
            1.0547727F,
            0.8465753F,
            1.05F,
            0.8427273F,
            1.0547727F,
            0.8465753F
        )
        val pr = PointRule(CoordinatePoint(538, 1718), colorRule1)
        //red224,green224,blue224 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(59, 391, 953, 1777)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(530, 1719), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(546, 1719), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(526, 1720), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(554, 1721), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(542, 1718), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(518, 1724), colorRule1)
            //red221,green220,blue221 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(562, 1725), colorRule1)
            //red224,green224,blue224 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(510, 1730), colorRule1)
            //red222,green222,blue222 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(570, 1731), colorRule1)
            //red224,green224,blue224 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(504, 1737), colorRule1)
            //red223,green223,blue223 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(576, 1739), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(500, 1745), colorRule1)
            //red223,green223,blue223 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(579, 1746), colorRule1)
            //red223,green223,blue223 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(498, 1753), colorRule1)
            //red206,green219,blue220 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(581, 1754), colorRule1)
            //red206,green219,blue220 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(497, 1761), colorRule1)
            //red206,green219,blue220 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(582, 1762), colorRule1)
            //red212,green220,blue221 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(498, 1770), colorRule1)
            //red224,green224,blue224 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(580, 1771), colorRule1)
            //red223,green223,blue223 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(501, 1778), colorRule1)
            //red224,green224,blue224 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(577, 1779), colorRule1)
            //red224,green224,blue224 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(506, 1786), colorRule1)
            //red224,green224,blue224 sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(571, 1788), colorRule1)
            //red224,green224,blue224 sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(512, 1793), colorRule1)
            //red221,green220,blue221 sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(563, 1795), colorRule1)
            //red224,green224,blue224 sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(523, 1799), colorRule1)
            //red223,green223,blue223 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(553, 1800), colorRule1)
            //red223,green223,blue223 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(531, 1802), colorRule1)
            //red224,green224,blue224 sequenceNumber:112 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(543, 1802), colorRule1)
            //red224,green224,blue224 sequenceNumber:112 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(537, 1803), colorRule1)
            //red224,green224,blue224 sequenceNumber:120 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(538, 1718),
                CoordinatePoint(538, 1716),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(581, 1754),
                CoordinatePoint(579, 1754),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(537, 1803),
                CoordinatePoint(537, 1805),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:120sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(548, 1769), colorRule1)
            //red224,green224,blue224 sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(540, 1759), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(553, 1774), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(547, 1751), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(545, 1766), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(553, 1745), colorRule1)
            //red223,green223,blue223 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(536, 1762), colorRule1)
            //red224,green224,blue224 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(549, 1749), colorRule1)
            //red224,green224,blue224 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(528, 1770), colorRule1)
            //red217,green217,blue217 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(541, 1757), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(525, 1774), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(529, 1750), colorRule1)
            //red224,green224,blue224 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(532, 1766), colorRule1)
            //red224,green224,blue224 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(524, 1745), colorRule1)
            //red222,green222,blue222 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(535, 1756), colorRule1)
            //red223,green223,blue223 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(528, 1749), colorRule1)
            //red223,green223,blue223 sequenceNumber:63 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(548, 1769),
                CoordinatePoint(548, 1765),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(528, 1770),
                CoordinatePoint(528, 1767),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }


    val fuLiUnSelectArea by lazy {
        ClickArea(694, 2214, 79, 86, false)
    }

    val isFuLiUnSelectTask by lazy {
        val tag = " isFuLiUnSelect"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(724, 2226), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 10, 10, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(728, 2231), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(728, 2231), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(738, 2225), ColorRuleRatioImpl.getSimple(124, 124, 124))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(735, 2233), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(716, 2233), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(743, 2233), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(708, 2233), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(751, 2233), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(705, 2235), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(759, 2236), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:40 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(705, 2243), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(759, 2247), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(707, 2253), ColorRuleRatioImpl.getSimple(121, 121, 121))
            // sequenceNumber:48 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 2252), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:56 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(707, 2261), ColorRuleRatioImpl.getSimple(121, 121, 121))
            // sequenceNumber:56 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 2260), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:64 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(707, 2269), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 2268), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:72 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(707, 2277), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 2276), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:80 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(713, 2283), ColorRuleRatioImpl.getSimple(118, 118, 118))
            // sequenceNumber:80 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(748, 2283), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:88 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(721, 2283), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:88 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(735, 2283), ColorRuleRatioImpl.getSimple(119, 119, 119))
            // sequenceNumber:101 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(724, 2226),
                CoordinatePoint(724, 2223),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(759, 2247),
                CoordinatePoint(757, 2245),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(735, 2283),
                CoordinatePoint(735, 2280),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:101sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(731, 2250), ColorRuleRatioImpl.getSimple(124, 124, 124))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(731, 2256), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(731, 2267), ColorRuleRatioImpl.getSimple(120, 120, 120))
            // sequenceNumber:19 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(731, 2250),
                CoordinatePoint(731, 2248),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(731, 2256),
                CoordinatePoint(728, 2256),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(731, 2267),
                CoordinatePoint(728, 2267),
                CompareDifferenceRuleImpl.getSimple(-30, -30, -30)
            ) // sequenceNumber:19sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isFuLiSelectTask by lazy {
        val tag = "isFuLiSelect"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            22,
            15,
            207,
            166,
            208,
            165,
            0.1142487F,
            0.07766497F,
            0.115445025F,
            0.08140703F,
            1.1241847F,
            0.8454546F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(725, 2226), colorRule1)
            //red20,green197,blue187 sequenceNumber:0 blockNumber: 3  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(724, 2234), colorRule1)
            //red17,green197,blue186 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(728, 2232), colorRule1)
            //red18,green197,blue184 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(716, 2235), colorRule1)
            //red19,green198,blue186 sequenceNumber:16 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(718, 2236), colorRule1)
            //red18,green197,blue184 sequenceNumber:16 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(708, 2234), colorRule1)
            //red19,green198,blue185 sequenceNumber:24 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(718, 2244), colorRule1)
            //red18,green196,blue190 sequenceNumber:24 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(705, 2236), colorRule1)
            //red19,green198,blue186 sequenceNumber:32 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(712, 2247), colorRule1)
            //red18,green196,blue190 sequenceNumber:32 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(723, 2252), colorRule1)
            //red18,green194,blue191 sequenceNumber:32 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(721, 2256), colorRule1)
            //red18,green193,blue193 sequenceNumber:32 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(705, 2241), colorRule1)
            //red19,green198,blue188 sequenceNumber:40 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(708, 2246), colorRule1)
            //red18,green196,blue189 sequenceNumber:40 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(731, 2248), colorRule1)
            //red18,green194,blue190 sequenceNumber:40 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(724, 2255), colorRule1)
            //red18,green193,blue193 sequenceNumber:40 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(714, 2258), colorRule1)
            //red18,green194,blue191 sequenceNumber:40 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(741, 2248), colorRule1)
            //red20,green193,blue191 sequenceNumber:48 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(740, 2253), colorRule1)
            //red18,green192,blue191 sequenceNumber:48 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(721, 2259), colorRule1)
            //red19,green193,blue193 sequenceNumber:48 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(725, 2263), colorRule1)
            //red20,green191,blue195 sequenceNumber:48 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(708, 2262), colorRule1)
            //red18,green194,blue191 sequenceNumber:48 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(747, 2243), colorRule1)
            //red18,green194,blue191 sequenceNumber:56 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(740, 2261), colorRule1)
            //red20,green190,blue194 sequenceNumber:56 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(713, 2260), colorRule1)
            //red18,green194,blue191 sequenceNumber:56 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(709, 2262), colorRule1)
            //red20,green192,blue192 sequenceNumber:56 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(753, 2240), colorRule1)
            //red19,green195,blue192 sequenceNumber:64 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(737, 2269), colorRule1)
            //red19,green190,blue199 sequenceNumber:64 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(753, 2239), colorRule1)
            //red19,green195,blue192 sequenceNumber:72 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(735, 2279), colorRule1)
            //red19,green187,blue194 sequenceNumber:72 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(759, 2240), colorRule1)
            //red18,green194,blue191 sequenceNumber:80 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(727, 2282), colorRule1)
            //red20,green186,blue198 sequenceNumber:80 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(734, 2280), colorRule1)
            //red18,green185,blue193 sequenceNumber:80 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(755, 2246), colorRule1)
            //red21,green194,blue194 sequenceNumber:88 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(719, 2281), colorRule1)
            //red20,green187,blue196 sequenceNumber:88 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(743, 2280), colorRule1)
            //red19,green188,blue197 sequenceNumber:88 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(752, 2250), colorRule1)
            //red19,green190,blue193 sequenceNumber:96 blockNumber: 3  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(756, 2254), colorRule1)
            //red18,green192,blue199 sequenceNumber:96 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(711, 2281), colorRule1)
            //red20,green188,blue196 sequenceNumber:96 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(749, 2279), colorRule1)
            //red19,green188,blue197 sequenceNumber:96 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(753, 2267), colorRule1)
            //red18,green191,blue195 sequenceNumber:109 blockNumber: 3  positionType:3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(725, 2226),
                CoordinatePoint(721, 2226),
                CompareDifferenceRuleImpl.getSimple(-50, -15, -15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(708, 2262),
                CoordinatePoint(703, 2262),
                CompareDifferenceRuleImpl.getSimple(-50, -20, -20)
            ) // sequenceNumber:48sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(740, 2231), colorRule1)
            //red21,green193,blue191 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(743, 2232), colorRule1)
            //red20,green196,blue187 sequenceNumber:5 blockNumber: 6  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(740, 2231),
                CoordinatePoint(741, 2228),
                CompareDifferenceRuleImpl.getSimple(-50, -15, -15)
            ) // sequenceNumber:0sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(743, 2232),
                CoordinatePoint(743, 2228),
                CompareDifferenceRuleImpl.getSimple(-50, -15, -20)
            ) // sequenceNumber:5sequenceNumber blockNumber: $6  positionType:$6
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val changWankaArea by lazy {
        ClickArea(201, 188, 149, 47, false)
    }
    val isChangWankaTask by lazy {
        val tag = "isChangWanka"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            194,
            199,
            138,
            93,
            60,
            1.6009259F,
            1.1302326F,
            3.7367647F,
            2.477647F,
            2.7F,
            1.7769231F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(329, 196), colorRule1)
            //red230,green170,blue74 sequenceNumber:0 blockNumber: 0  positionType:0
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(328, 199), colorRule1)
            //red238,green172,blue83 sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(328, 199),
                CoordinatePoint(326, 199),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(272, 198), colorRule1)
            //red233,green154,blue78 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(278, 198), colorRule1)
            //red246,green168,blue76 sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(278, 198),
                CoordinatePoint(278, 195),
                CompareDifferenceRuleImpl.getSimple(0, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(301, 198), colorRule1)
            //red240,green166,blue79 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(306, 198), colorRule1)
            //red242,green165,blue68 sequenceNumber:7 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(306, 198),
                CoordinatePoint(306, 195),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(333, 200), colorRule1)
            //red243,green168,blue72 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(338, 200), colorRule1)
            //red240,green167,blue71 sequenceNumber:7 blockNumber: 11  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(338, 200),
                CoordinatePoint(338, 197),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(
            PointRule(CoordinatePoint(277, 206), colorRule1)
            //red235,green166,blue71 sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(282, 208), colorRule1)
            //red225,green172,blue76 sequenceNumber:8 blockNumber: 26  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(277, 220), colorRule1)
            //red239,green175,blue78 sequenceNumber:20 blockNumber: 26  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(282, 208),
                CoordinatePoint(284, 208),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(
            PointRule(CoordinatePoint(303, 206), colorRule1)
            //red248,green165,blue72 sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(306, 206), colorRule1)
            //red240,green171,blue76 sequenceNumber:5 blockNumber: 28  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(306, 206),
                CoordinatePoint(306, 203),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(
            PointRule(CoordinatePoint(319, 207), colorRule1)
            //red241,green164,blue78 sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(325, 207), colorRule1)
            //red242,green167,blue80 sequenceNumber:8 blockNumber: 34  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(325, 207),
                CoordinatePoint(325, 205),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(
            PointRule(CoordinatePoint(331, 207), colorRule1)
            //red248,green167,blue72 sequenceNumber:0 blockNumber: 35  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(340, 207), colorRule1)
            //red238,green157,blue70 sequenceNumber:11 blockNumber: 35  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(340, 207),
                CoordinatePoint(340, 204),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:11sequenceNumber blockNumber: $35  positionType:$35
        )
        pointList.add(
            PointRule(CoordinatePoint(259, 210), colorRule1)
            //red245,green170,blue86 sequenceNumber:0 blockNumber: 41  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(259, 213), colorRule1)
            //red237,green168,blue73 sequenceNumber:5 blockNumber: 41  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(259, 213),
                CoordinatePoint(256, 213),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $41  positionType:$41
        )
        pointList.add(
            PointRule(CoordinatePoint(291, 210), colorRule1)
            //red236,green175,blue75 sequenceNumber:0 blockNumber: 43  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(291, 213), colorRule1)
            //red234,green174,blue85 sequenceNumber:5 blockNumber: 43  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(291, 213),
                CoordinatePoint(289, 213),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:5sequenceNumber blockNumber: $43  positionType:$43
        )
        pointList.add(
            PointRule(CoordinatePoint(271, 211), colorRule1)
            //red233,green167,blue84 sequenceNumber:0 blockNumber: 45  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(267, 216), colorRule1)
            //red241,green175,blue79 sequenceNumber:8 blockNumber: 45  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(267, 216),
                CoordinatePoint(267, 219),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $45  positionType:$45
        )
        pointList.add(
            PointRule(CoordinatePoint(293, 211), colorRule1)
            //red242,green164,blue74 sequenceNumber:0 blockNumber: 46  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(294, 216), colorRule1)
            //red237,green162,blue67 sequenceNumber:7 blockNumber: 46  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(294, 216),
                CoordinatePoint(295, 214),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:7sequenceNumber blockNumber: $46  positionType:$46
        )
        pointList.add(
            PointRule(CoordinatePoint(300, 212), colorRule1)
            //red247,green190,blue89 sequenceNumber:0 blockNumber: 49  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(300, 218), colorRule1)
            //red247,green180,blue70 sequenceNumber:8 blockNumber: 49  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(300, 218),
                CoordinatePoint(303, 218),
                CompareDifferenceRuleImpl.getSimple(0, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $49  positionType:$49
        )
        pointList.add(
            PointRule(CoordinatePoint(333, 213), colorRule1)
            //red236,green173,blue85 sequenceNumber:0 blockNumber: 53  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(340, 216), colorRule1)
            //red242,green174,blue72 sequenceNumber:8 blockNumber: 53  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(340, 216),
                CoordinatePoint(340, 214),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $53  positionType:$53
        )
        pointList.add(
            PointRule(CoordinatePoint(313, 214), colorRule1)
            //red216,green172,blue78 sequenceNumber:0 blockNumber: 56  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(310, 219), colorRule1)
            //red247,green162,blue81 sequenceNumber:8 blockNumber: 56  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(310, 219),
                CoordinatePoint(310, 216),
                CompareDifferenceRuleImpl.getSimple(0, -20, -30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $56  positionType:$56
        )
        pointList.add(
            PointRule(CoordinatePoint(330, 215), colorRule1)
            //red242,green166,blue71 sequenceNumber:0 blockNumber: 58  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(330, 219), colorRule1)
            //red240,green171,blue74 sequenceNumber:6 blockNumber: 58  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(330, 219),
                CoordinatePoint(332, 219),
                CompareDifferenceRuleImpl.getSimple(-10, -20, -30)
            ) // sequenceNumber:6sequenceNumber blockNumber: $58  positionType:$58
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isIsIntoVipTask by lazy {
        val tag = "isIsIntoVip"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            247,
            212,
            247,
            212,
            248,
            212,
            1.05F,
            0.9F,
            1.05F,
            0.8962025F,
            1.05F,
            0.9F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(334, 146), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 10, 10, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(341, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(329, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(348, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(321, 157), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(355, 161), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(317, 160), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(325, 155), colorRule1)
            //red236,green236,blue237 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(335, 146), colorRule1)
            //red236,green236,blue236 sequenceNumber:45 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(321, 157),
                CoordinatePoint(321, 154),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 145), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(436, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(436, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(444, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 158), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(452, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(426, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(418, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(440, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(448, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 173), colorRule1)
            //red236,green236,blue236 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(456, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:72 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 181), colorRule1)
            //red236,green236,blue236 sequenceNumber:72 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 185), colorRule1)
            //red236,green236,blue236 sequenceNumber:80 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(435, 177), colorRule1)
            //red236,green236,blue236 sequenceNumber:88 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(440, 164),
                CoordinatePoint(440, 161),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:56sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(374, 148), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(378, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(373, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(386, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(376, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(394, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(384, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(399, 148), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(392, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(399, 155), colorRule1)
            //red236,green236,blue236 sequenceNumber:39 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(394, 147),
                CoordinatePoint(394, 145),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(325, 162), colorRule1)
            //red236,green236,blue237 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(330, 162), colorRule1)
            //red236,green236,blue237 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(338, 162), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(345, 162), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 3  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(338, 162),
                CoordinatePoint(338, 164),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(372, 166), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 4  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(376, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(371, 170), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(384, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(371, 177), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(392, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(401, 166), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 4  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(401, 170), colorRule1)
            //red236,green236,blue236 sequenceNumber:40 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(401, 175), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(401, 167), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 4  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(392, 165),
                CoordinatePoint(392, 162),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(386, 171), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(393, 181), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(377, 184), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(401, 185), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(367, 187), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(377, 184),
                CoordinatePoint(377, 181),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(316, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:0 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(321, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(330, 173), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(330, 173), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(337, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(322, 184), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(345, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(321, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:32 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(353, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:40 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(333, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:40 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(337, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:48 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(346, 184), colorRule1)
            //red236,green236,blue237 sequenceNumber:56 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(349, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:64 blockNumber: 6  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(326, 179), colorRule1)
            //red236,green236,blue237 sequenceNumber:72 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(344, 179), colorRule1)
            //red236,green236,blue237 sequenceNumber:72 blockNumber: 6  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(321, 185),
                CoordinatePoint(317, 185),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            PointRule(CoordinatePoint(441, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(446, 175), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(453, 179), colorRule1)
            //red236,green236,blue236 sequenceNumber:17 blockNumber: 7  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(446, 175),
                CoordinatePoint(446, 172),
                CompareDifferenceRuleImpl.getSimple(30, 30, 30)
            ) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isOnceDailyTask by lazy {
        val tag = "isOnceDaily"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            226,
            255,
            212,
            255,
            208,
            1.1211864F,
            0.9F,
            1.1405172F,
            0.9F,
            1.0681034F,
            0.9F
        )
        val pr = PointRule(CoordinatePoint(144, 1151), colorRule1)
        //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(101, 246, 714, 1372)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(149, 1151), colorRule1)
            //red254,green249,blue248 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(158, 1151), colorRule1)
            //red254,green249,blue248 sequenceNumber:17 blockNumber: 0  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(149, 1151),
                CoordinatePoint(149, 1150),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(254, 1149), colorRule1)
            //red253,green241,blue239 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(252, 1155), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(257, 1153), colorRule1)
            //red253,green243,blue241 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(262, 1157), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(257, 1153),
                CoordinatePoint(257, 1152),
                CompareDifferenceRuleImpl.getSimple(10, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1150), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(192, 1154), colorRule1)
            //red252,green238,blue235 sequenceNumber:6 blockNumber: 2  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(192, 1154),
                CoordinatePoint(192, 1152),
                CompareDifferenceRuleImpl.getSimple(10, 40, 40)
            ) // sequenceNumber:6sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(169, 1152), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(174, 1151), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(169, 1160), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(182, 1151), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(169, 1169), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(175, 1160), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(174, 1169), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(182, 1161), colorRule1)
            //red252,green237,blue234 sequenceNumber:24 blockNumber: 3  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(182, 1170), colorRule1)
            //red254,green249,blue248 sequenceNumber:33 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(169, 1169),
                CoordinatePoint(167, 1169),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 1151), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(207, 1151), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(206, 1155), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(211, 1163), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(206, 1155),
                CoordinatePoint(206, 1157),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(
            PointRule(CoordinatePoint(245, 1151), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(246, 1154), colorRule1)
            //red255,green252,blue252 sequenceNumber:5 blockNumber: 5  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(246, 1154),
                CoordinatePoint(244, 1154),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(
            PointRule(CoordinatePoint(143, 1156), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(149, 1156), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(139, 1162), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(144, 1162), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1161), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(145, 1168), colorRule1)
            //red254,green252,blue251 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1167), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1167), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(150, 1171), colorRule1)
            //red255,green254,blue254 sequenceNumber:31 blockNumber: 6  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(157, 1161),
                CoordinatePoint(155, 1160),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:16sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(
            PointRule(CoordinatePoint(256, 1157), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(255, 1163), colorRule1)
            //red254,green246,blue244 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(256, 1163), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(249, 1170), colorRule1)
            //red254,green252,blue251 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(256, 1163),
                CoordinatePoint(254, 1162),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(
            PointRule(CoordinatePoint(207, 1159), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(202, 1170), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 10  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(202, 1170),
                CoordinatePoint(202, 1168),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:13sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(
            PointRule(CoordinatePoint(217, 1159), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1159), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(236, 1159), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 11  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(223, 1159),
                CoordinatePoint(223, 1157),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:8sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(
            PointRule(CoordinatePoint(192, 1161), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(198, 1162), colorRule1)
            //red253,green243,blue241 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1169), colorRule1)
            //red252,green236,blue232 sequenceNumber:15 blockNumber: 12  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(198, 1162),
                CoordinatePoint(198, 1159),
                CompareDifferenceRuleImpl.getSimple(10, 40, 40)
            ) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(
            PointRule(CoordinatePoint(247, 1161), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(245, 1168), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 13  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(245, 1168),
                CoordinatePoint(243, 1168),
                CompareDifferenceRuleImpl.getSimple(10, 40, 50)
            ) // sequenceNumber:9sequenceNumber blockNumber: $13  positionType:$13
        )
        FindImgTask(pr, findArea, pointList, tag)

    }

    val is3DiscountArea by lazy {
        ClickArea(137,1416,129,50,false)
    }

    val is3DiscountTask by lazy {
        val tag = "is3Discount"
        val colorRule1 = ColorRuleRatioImpl.getSimple(
            255,
            226,
            231,
            198,
            165,
            142,
            1.2027272F,
            1.0309091F,
            1.6746836F,
            1.435443F,
            1.4620253F,
            1.2531645F
        )
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(168, 1245), colorRule1)
            //red252,green220,blue158 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(171, 1249), colorRule1)
            //red252,green220,blue158 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(176, 1257), colorRule1)
            //red252,green220,blue158 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(185, 1253), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(170, 1263), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(189, 1245), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(177, 1263), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 1248), colorRule1)
            //red252,green220,blue158 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 1272), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(182, 1258), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(170, 1272), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(184, 1263), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 1279), colorRule1)
            //red252,green220,blue158 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(179, 1272), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(180, 1272), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(187, 1272), colorRule1)
            //red252,green220,blue158 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(168, 1245),
                CoordinatePoint(168, 1242),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(179, 1272),
                CoordinatePoint(176, 1270),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:72sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(209, 1245), colorRule1)
            //red252,green220,blue158 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(214, 1245), colorRule1)
            //red252,green220,blue158 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1246), colorRule1)
            //red252,green220,blue158 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(225, 1247), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(219, 1255), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(215, 1260), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(224, 1262), colorRule1)
            //red252,green220,blue158 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(228, 1266), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(228, 1274), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(225, 1278), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(213, 1278), colorRule1)
            //red252,green220,blue158 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(211, 1277), colorRule1)
            //red252,green220,blue158 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(209, 1245),
                CoordinatePoint(209, 1243),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(224, 1262),
                CoordinatePoint(224, 1259),
                CompareDifferenceRuleImpl.getSimple(10, 30, 30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val is3DiscountFastArea by lazy {
        ClickArea(133, 1772, 156, 47, false)
    }
    val is3DiscountFastTask by lazy {
        val tag = "is3DiscountFast"
        val pr = PointRule(CoordinatePoint(217, 1520), ColorRuleRatioImpl.getSimple(228, 79, 47))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(38, 1295, 999, 642)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(221, 1520), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(217, 1523), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(229, 1520), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1523), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(237, 1520), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(226, 1533), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:24 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(237, 1524), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:32 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(224, 1536), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:32 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(229, 1530), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:40 blockNumber: 0  positionType:4
        )
        pointList.add(
            PointRule(CoordinatePoint(231, 1538), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:40 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(236, 1538), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(236, 1544), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(240, 1542), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(231, 1554), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(239, 1550), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(220, 1551), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(232, 1556), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(216, 1551), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1557), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:83 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(217, 1520),
                CoordinatePoint(214, 1520),
                CompareDifferenceRuleImpl.getSimple(-10, -30, -30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(231, 1538),
                CoordinatePoint(230, 1542),
                CompareDifferenceRuleImpl.getSimple(-10, -40, -30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(184, 1533), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(187, 1534), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 1538), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(196, 1539), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(186, 1546), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(198, 1534), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(191, 1552), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(198, 1536), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(196, 1545), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:40 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(192, 1556), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1552), ColorRuleRatioImpl.getSimple(228, 79, 47))
            // sequenceNumber:51 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(184, 1533),
                CoordinatePoint(182, 1533),
                CompareDifferenceRuleImpl.getSimple(-10, -30, -30)
            ) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(198, 1534),
                CoordinatePoint(195, 1534),
                CompareDifferenceRuleImpl.getSimple(-10, -30, -30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(195, 1552),
                CoordinatePoint(196, 1549),
                CompareDifferenceRuleImpl.getSimple(-10, -30, -30)
            ) // sequenceNumber:51sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea, pointList, tag)
    }

    val is3DiscountFastVTask by lazy {
        val tag = "is3DiscountFastV"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(157, 1657), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(160, 1661), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(153, 1661), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1662), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(153, 1673), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1674), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(161, 1674), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(157, 1678), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(166, 1666), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(172, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:44 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(170, 1673), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(171, 1668), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(172, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:44 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(161, 1674),
                CoordinatePoint(159, 1672),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1657), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(227, 1660), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1666), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(231, 1660), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(213, 1668), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(227, 1668), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1671), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(235, 1668), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:40 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(223, 1679), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:40 blockNumber: 1  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(233, 1676), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:59 blockNumber: 1  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(227, 1668),
                CoordinatePoint(227, 1670),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:32sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(247, 1657), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:0 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(243, 1661), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(
            PointRule(CoordinatePoint(254, 1661), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(254, 1661), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(243, 1667), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(262, 1657), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(261, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(254, 1666), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(249, 1668), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(262, 1667), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(244, 1673), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(251, 1675), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:40 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(264, 1673), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:48 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(261, 1677), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:56 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(253, 1673), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:56 blockNumber: 2  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(255, 1681), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:64 blockNumber: 2  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(249, 1668),
                CoordinatePoint(249, 1664),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:24sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(183, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(188, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(186, 1667), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:8 blockNumber: 3  positionType:3
        )
        pointList.add(
            PointRule(CoordinatePoint(186, 1670), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(183, 1678), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:24 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(190, 1678), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:32 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1674), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:40 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1667), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:48 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(195, 1667), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:48 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(201, 1671), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:56 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(203, 1666), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:56 blockNumber: 3  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(202, 1679), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:64 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(206, 1674), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:75 blockNumber: 3  positionType:0
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(195, 1674),
                CoordinatePoint(192, 1674),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:40sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(
            PointRule(CoordinatePoint(194, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:0 blockNumber: 4  positionType:1
        )
        pointList.add(
            PointRule(CoordinatePoint(204, 1659), ColorRuleRatioImpl.getSimple(250, 229, 183))
            // sequenceNumber:13 blockNumber: 4  positionType:1
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(204, 1659),
                CoordinatePoint(204, 1661),
                CompareDifferenceRuleImpl.getSimple(10, 40, 30)
            ) // sequenceNumber:13sequenceNumber blockNumber: $4  positionType:$4
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

}