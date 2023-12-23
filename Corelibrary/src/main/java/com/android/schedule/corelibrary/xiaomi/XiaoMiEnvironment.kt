package com.android.schedule.corelibrary.xiaomi

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

class XiaoMiEnvironment {

    val clickArea by lazy {
        ClickArea(468, 2002, 142, 119, false)
    }

    val isHomeGameCenterTask by lazy {
        val tag = "isHomeGameCenter"
        val list = mutableListOf<PointRule>()
        list.add(
            PointRule(CoordinatePoint(560, 2040), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, true)
        val pointList = mutableListOf<IPR>()
        pointList.add(
            PointRule(CoordinatePoint(561, 2044), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:12 blockNumber: 0  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(561, 2044),
                CoordinatePoint(561, 2048),
                CompareDifferenceRuleImpl.getSimple(10, -30, -40)
            ) // sequenceNumber:12sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(
            PointRule(CoordinatePoint(550, 2050), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(551, 2055), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:12 blockNumber: 1  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(551, 2055),
                CoordinatePoint(551, 2058),
                CompareDifferenceRuleImpl.getSimple(10, -30, -40)
            ) // sequenceNumber:12sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(
            PointRule(CoordinatePoint(571, 2050), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(572, 2055), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:12 blockNumber: 2  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(572, 2055),
                CoordinatePoint(572, 2058),
                CompareDifferenceRuleImpl.getSimple(10, -30, -40)
            ) // sequenceNumber:12sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(
            PointRule(CoordinatePoint(561, 2060), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:0 blockNumber: 3  positionType:2
        )
        pointList.add(
            PointRule(CoordinatePoint(561, 2065), ColorRuleRatioImpl.getSimple(255, 128, 77))
            // sequenceNumber:13 blockNumber: 3  positionType:2
        )
        pointList.add(
            TwoPointRule(
                CoordinatePoint(561, 2065),
                CoordinatePoint(561, 2068),
                CompareDifferenceRuleImpl.getSimple(10, -30, -40)
            ) // sequenceNumber:13sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isFuLiGrayTask by lazy {
        val tag = "isFuLiGray"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(739, 2225), ColorRuleRatioImpl.getSimple(46,46,46))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(729, 2232), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(735, 2232), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(724, 2226), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(743, 2234), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(725, 2233), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(751, 2234), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(714, 2234), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(758, 2234), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(706, 2234), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(759, 2241), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(704, 2236), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(757, 2249), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(706, 2248), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(756, 2257), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 2252), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(756, 2265), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 2260), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(756, 2273), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 2268), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(755, 2281), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 2276), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(746, 2284), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(709, 2282), ColorRuleRatioImpl.getSimple(47,47,47))
            // sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(738, 2284), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(723, 2284), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:110 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(739, 2225),CoordinatePoint(739, 2223), CompareDifferenceRuleImpl.getSimple(-15,-15,-15)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(706, 2248),CoordinatePoint(707, 2246), CompareDifferenceRuleImpl.getSimple(-15,-15,-15)) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(731, 2251), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(731, 2255), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(731, 2267), ColorRuleRatioImpl.getSimple(48,48,48))
            // sequenceNumber:20 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2251),CoordinatePoint(729, 2251), CompareDifferenceRuleImpl.getSimple(-15,-15,-15)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2255),CoordinatePoint(729, 2255), CompareDifferenceRuleImpl.getSimple(-15,-15,-15)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2267),CoordinatePoint(729, 2267), CompareDifferenceRuleImpl.getSimple(-15,-15,-15)) // sequenceNumber:20sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val guanGaoCloseArea by lazy {
        ClickArea(517,1733,47,51,false)}

    val isGuanGaoCloseTask by lazy {
        val tag = "isGuanGaoClose"
        val pr  = PointRule(CoordinatePoint(524, 1745), ColorRuleRatioImpl.getSimple(222,222,222))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val findArea = CoordinateArea(52,245,982,1923)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(530, 1751), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(528, 1749), ColorRuleRatioImpl.getSimple(223,223,223))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(542, 1756), ColorRuleRatioImpl.getSimple(221,220,221))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(536, 1757), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(550, 1748), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(531, 1767), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(554, 1745), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(524, 1774), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(547, 1751), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(529, 1769), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(541, 1762), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(540, 1761), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:48 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(549, 1770), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(547, 1768), ColorRuleRatioImpl.getSimple(222,222,222))
            // sequenceNumber:56 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(553, 1774), ColorRuleRatioImpl.getSimple(224,224,224))
            // sequenceNumber:63 blockNumber: 0  positionType:3
        )
        pointList.add(TwoPointRule(CoordinatePoint(524, 1745),CoordinatePoint(524, 1742), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(550, 1748),CoordinatePoint(550, 1745), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(529, 1769),CoordinatePoint(529, 1766), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:40sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(553, 1774),CoordinatePoint(553, 1770), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:63sequenceNumber blockNumber: $0  positionType:$0
        )
        FindImgTask(pr, findArea,pointList, tag)
    }

    val fuLiArea by lazy {
        ClickArea(694,2214,79,86,false)}

    val isFuLiUnSelectTask by lazy {
        val tag = " isFuLiUnSelect"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(724, 2226), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(728, 2231), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(728, 2231), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(738, 2225), ColorRuleRatioImpl.getSimple(124,124,124))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(735, 2233), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(716, 2233), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(743, 2233), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(708, 2233), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:24 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(751, 2233), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:32 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(705, 2235), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(759, 2236), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:40 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(705, 2243), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(759, 2247), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(707, 2253), ColorRuleRatioImpl.getSimple(121,121,121))
            // sequenceNumber:48 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(756, 2252), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:56 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 2261), ColorRuleRatioImpl.getSimple(121,121,121))
            // sequenceNumber:56 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(756, 2260), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:64 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 2269), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(756, 2268), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:72 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(707, 2277), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(756, 2276), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:80 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(713, 2283), ColorRuleRatioImpl.getSimple(118,118,118))
            // sequenceNumber:80 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(748, 2283), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:88 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(721, 2283), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:88 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(735, 2283), ColorRuleRatioImpl.getSimple(119,119,119))
            // sequenceNumber:101 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(724, 2226),CoordinatePoint(724, 2223), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(759, 2247),CoordinatePoint(757, 2245), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(735, 2283),CoordinatePoint(735, 2280), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:101sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(731, 2250), ColorRuleRatioImpl.getSimple(124,124,124))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(731, 2256), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(731, 2267), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:19 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2250),CoordinatePoint(731, 2248), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2256),CoordinatePoint(728, 2256), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(731, 2267),CoordinatePoint(728, 2267), CompareDifferenceRuleImpl.getSimple(-30,-30,-30)) // sequenceNumber:19sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isFuLiSelectTask by lazy {
        val tag = "isFuLiSelect"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(724, 2225), ColorRuleRatioImpl.getSimple(28,200,190))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(727, 2233), ColorRuleRatioImpl.getSimple(15,198,185))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(729, 2232), ColorRuleRatioImpl.getSimple(23,195,184))
            // sequenceNumber:8 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(715, 2233), ColorRuleRatioImpl.getSimple(19,199,185))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(737, 2226), ColorRuleRatioImpl.getSimple(13,195,185))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(736, 2231), ColorRuleRatioImpl.getSimple(22,193,188))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(707, 2233), ColorRuleRatioImpl.getSimple(18,198,184))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(744, 2233), ColorRuleRatioImpl.getSimple(17,196,186))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(704, 2235), ColorRuleRatioImpl.getSimple(18,198,183))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(752, 2233), ColorRuleRatioImpl.getSimple(14,199,185))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(704, 2241), ColorRuleRatioImpl.getSimple(19,198,188))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(759, 2236), ColorRuleRatioImpl.getSimple(15,193,190))
            // sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(708, 2249), ColorRuleRatioImpl.getSimple(18,196,190))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(759, 2241), ColorRuleRatioImpl.getSimple(18,194,191))
            // sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(708, 2257), ColorRuleRatioImpl.getSimple(16,195,189))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(755, 2249), ColorRuleRatioImpl.getSimple(21,193,197))
            // sequenceNumber:56 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(708, 2265), ColorRuleRatioImpl.getSimple(20,192,193))
            // sequenceNumber:64 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(752, 2255), ColorRuleRatioImpl.getSimple(19,191,195))
            // sequenceNumber:64 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(708, 2273), ColorRuleRatioImpl.getSimple(23,190,197))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(754, 2265), ColorRuleRatioImpl.getSimple(18,193,196))
            // sequenceNumber:72 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(712, 2279), ColorRuleRatioImpl.getSimple(22,189,196))
            // sequenceNumber:80 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(753, 2273), ColorRuleRatioImpl.getSimple(20,190,195))
            // sequenceNumber:80 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(717, 2280), ColorRuleRatioImpl.getSimple(22,189,196))
            // sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(750, 2279), ColorRuleRatioImpl.getSimple(19,188,197))
            // sequenceNumber:88 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(725, 2280), ColorRuleRatioImpl.getSimple(23,190,197))
            // sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(743, 2280), ColorRuleRatioImpl.getSimple(19,188,197))
            // sequenceNumber:96 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(733, 2280), ColorRuleRatioImpl.getSimple(19,187,194))
            // sequenceNumber:104 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(724, 2225),CoordinatePoint(724, 2221), CompareDifferenceRuleImpl.getSimple(-50,-15,-15)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(759, 2241),CoordinatePoint(764, 2241), CompareDifferenceRuleImpl.getSimple(-50,-20,-20)) // sequenceNumber:48sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(733, 2280),CoordinatePoint(733, 2285), CompareDifferenceRuleImpl.getSimple(-50,-20,-20)) // sequenceNumber:104sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(736, 2268), ColorRuleRatioImpl.getSimple(20,189,201))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(736, 2268),CoordinatePoint(732, 2267), CompareDifferenceRuleImpl.getSimple(-50,-20,-15)) // sequenceNumber:0sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

    val changWankaArea by lazy {
        ClickArea(201,226,151,43,false)}
    val isChangWankaTask by lazy {
        val tag = "isChangWanka"
        val pr  = PointRule(CoordinatePoint(329, 233), ColorRuleRatioImpl.getSimple(230,170,74))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(29,157,996,393)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(328, 236), ColorRuleRatioImpl.getSimple(238,172,83))
            // sequenceNumber:5 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(328, 236),CoordinatePoint(326, 236), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:5sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(272, 235), ColorRuleRatioImpl.getSimple(233,154,78))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(278, 235), ColorRuleRatioImpl.getSimple(246,168,76))
            // sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(278, 235),CoordinatePoint(278, 232), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(301, 235), ColorRuleRatioImpl.getSimple(240,166,79))
            // sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(306, 235), ColorRuleRatioImpl.getSimple(242,165,68))
            // sequenceNumber:7 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(306, 235),CoordinatePoint(306, 232), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:7sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(333, 237), ColorRuleRatioImpl.getSimple(243,168,72))
            // sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(338, 237), ColorRuleRatioImpl.getSimple(240,167,71))
            // sequenceNumber:7 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(338, 237),CoordinatePoint(338, 234), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:7sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(277, 243), ColorRuleRatioImpl.getSimple(235,166,71))
            // sequenceNumber:0 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(282, 245), ColorRuleRatioImpl.getSimple(225,172,76))
            // sequenceNumber:8 blockNumber: 26  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(277, 257), ColorRuleRatioImpl.getSimple(239,175,78))
            // sequenceNumber:20 blockNumber: 26  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(282, 245),CoordinatePoint(284, 245), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $26  positionType:$26
        )
        pointList.add(PointRule(CoordinatePoint(303, 243), ColorRuleRatioImpl.getSimple(248,165,72))
            // sequenceNumber:0 blockNumber: 28  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(306, 243), ColorRuleRatioImpl.getSimple(240,171,76))
            // sequenceNumber:5 blockNumber: 28  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(306, 243),CoordinatePoint(306, 240), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:5sequenceNumber blockNumber: $28  positionType:$28
        )
        pointList.add(PointRule(CoordinatePoint(319, 244), ColorRuleRatioImpl.getSimple(241,164,78))
            // sequenceNumber:0 blockNumber: 34  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(325, 244), ColorRuleRatioImpl.getSimple(242,167,80))
            // sequenceNumber:8 blockNumber: 34  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(325, 244),CoordinatePoint(325, 242), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $34  positionType:$34
        )
        pointList.add(PointRule(CoordinatePoint(331, 244), ColorRuleRatioImpl.getSimple(248,167,72))
            // sequenceNumber:0 blockNumber: 35  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(340, 244), ColorRuleRatioImpl.getSimple(238,157,70))
            // sequenceNumber:11 blockNumber: 35  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(340, 244),CoordinatePoint(340, 241), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:11sequenceNumber blockNumber: $35  positionType:$35
        )
        pointList.add(PointRule(CoordinatePoint(259, 247), ColorRuleRatioImpl.getSimple(245,170,86))
            // sequenceNumber:0 blockNumber: 41  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(259, 250), ColorRuleRatioImpl.getSimple(237,168,73))
            // sequenceNumber:5 blockNumber: 41  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(259, 250),CoordinatePoint(256, 250), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:5sequenceNumber blockNumber: $41  positionType:$41
        )
        pointList.add(PointRule(CoordinatePoint(291, 247), ColorRuleRatioImpl.getSimple(236,175,75))
            // sequenceNumber:0 blockNumber: 43  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(291, 250), ColorRuleRatioImpl.getSimple(234,174,85))
            // sequenceNumber:5 blockNumber: 43  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(291, 250),CoordinatePoint(289, 250), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:5sequenceNumber blockNumber: $43  positionType:$43
        )
        pointList.add(PointRule(CoordinatePoint(271, 248), ColorRuleRatioImpl.getSimple(233,167,84))
            // sequenceNumber:0 blockNumber: 45  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(267, 253), ColorRuleRatioImpl.getSimple(241,175,79))
            // sequenceNumber:8 blockNumber: 45  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(267, 253),CoordinatePoint(267, 256), CompareDifferenceRuleImpl.getSimple(-10,-20,-40)) // sequenceNumber:8sequenceNumber blockNumber: $45  positionType:$45
        )
        pointList.add(PointRule(CoordinatePoint(293, 248), ColorRuleRatioImpl.getSimple(242,164,74))
            // sequenceNumber:0 blockNumber: 46  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(294, 253), ColorRuleRatioImpl.getSimple(237,162,67))
            // sequenceNumber:7 blockNumber: 46  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(294, 253),CoordinatePoint(295, 251), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:7sequenceNumber blockNumber: $46  positionType:$46
        )
        pointList.add(PointRule(CoordinatePoint(300, 249), ColorRuleRatioImpl.getSimple(247,190,89))
            // sequenceNumber:0 blockNumber: 49  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(300, 255), ColorRuleRatioImpl.getSimple(247,180,70))
            // sequenceNumber:8 blockNumber: 49  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(300, 255),CoordinatePoint(303, 255), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $49  positionType:$49
        )
        pointList.add(PointRule(CoordinatePoint(333, 250), ColorRuleRatioImpl.getSimple(236,173,85))
            // sequenceNumber:0 blockNumber: 53  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(340, 253), ColorRuleRatioImpl.getSimple(242,174,72))
            // sequenceNumber:8 blockNumber: 53  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(340, 253),CoordinatePoint(340, 251), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $53  positionType:$53
        )
        pointList.add(PointRule(CoordinatePoint(313, 251), ColorRuleRatioImpl.getSimple(216,172,78))
            // sequenceNumber:0 blockNumber: 56  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(310, 256), ColorRuleRatioImpl.getSimple(247,162,81))
            // sequenceNumber:8 blockNumber: 56  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(310, 256),CoordinatePoint(310, 253), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:8sequenceNumber blockNumber: $56  positionType:$56
        )
        pointList.add(PointRule(CoordinatePoint(330, 252), ColorRuleRatioImpl.getSimple(242,166,71))
            // sequenceNumber:0 blockNumber: 58  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(330, 256), ColorRuleRatioImpl.getSimple(240,171,74))
            // sequenceNumber:6 blockNumber: 58  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(330, 256),CoordinatePoint(332, 256), CompareDifferenceRuleImpl.getSimple(-10,-20,-30)) // sequenceNumber:6sequenceNumber blockNumber: $58  positionType:$58
        )
        FindImgTask(pr, findArea,pointList, tag)
    }

}