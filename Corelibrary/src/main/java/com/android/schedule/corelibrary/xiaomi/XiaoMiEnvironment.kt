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
    val  bottomToTop by lazy {
        ClickTask(listOf(CoordinatePoint(511,335+1894),CoordinatePoint(511,335)),0,2000)
    }

    //這個華東更小且更慢
    val bottomToTopCenter by lazy {
        ClickTask(listOf(CoordinatePoint(508, 1157 + 499), CoordinatePoint(508, 1157)), 0, 2000)
    }

    val homeGameCenterArea by lazy {
        ClickArea(483,2148,118,117,false)}
    //这个在主界面時候的游戏中心
    val isHomeGameCenterTask by lazy {
        val tag = "isHomeGameCenter"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(561, 2182), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(561, 2186), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:10 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(561, 2186),CoordinatePoint(561, 2190), CompareDifferenceRuleImpl.getSimple(10,-30,-40)) // sequenceNumber:10sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(551, 2192), ColorRuleRatioImpl.getSimple(255,128,78))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(551, 2196), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:11 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(551, 2196),CoordinatePoint(551, 2200), CompareDifferenceRuleImpl.getSimple(10,-30,-40)) // sequenceNumber:11sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(572, 2192), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(571, 2196), ColorRuleRatioImpl.getSimple(255,128,78))
            // sequenceNumber:11 blockNumber: 2  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(571, 2196),CoordinatePoint(571, 2200), CompareDifferenceRuleImpl.getSimple(10,-30,-40)) // sequenceNumber:11sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(562, 2202), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:0 blockNumber: 3  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(562, 2207), ColorRuleRatioImpl.getSimple(255,128,77))
            // sequenceNumber:11 blockNumber: 3  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(562, 2207),CoordinatePoint(562, 2210), CompareDifferenceRuleImpl.getSimple(10,-30,-40)) // sequenceNumber:11sequenceNumber blockNumber: $3  positionType:$3
        )
        ImgTaskImpl1(pointList, tag, null)
    }





    val showCloseArea by lazy {
        ClickArea(513,1733,55,54,false)}
    val isShowCloseTask by lazy {
        val tag = "isShowClose"
        val colorRule1=ColorRuleRatioImpl.getSimple(235,185,235,195,235,195,1.0547727F,0.8465753F,1.05F,0.8427273F,1.0547727F, 0.8465753F)
        val pr  = PointRule(CoordinatePoint(538, 1718), colorRule1)
        //red224,green224,blue224 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(59,391,953,1777)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(530, 1719), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(546, 1719), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(526, 1720), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(554, 1721), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(542, 1718), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(518, 1724), colorRule1)
            //red221,green220,blue221 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(562, 1725), colorRule1)
            //red224,green224,blue224 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(510, 1730), colorRule1)
            //red222,green222,blue222 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(570, 1731), colorRule1)
            //red224,green224,blue224 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(504, 1737), colorRule1)
            //red223,green223,blue223 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(576, 1739), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(500, 1745), colorRule1)
            //red223,green223,blue223 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(579, 1746), colorRule1)
            //red223,green223,blue223 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(498, 1753), colorRule1)
            //red206,green219,blue220 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(581, 1754), colorRule1)
            //red206,green219,blue220 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(497, 1761), colorRule1)
            //red206,green219,blue220 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(582, 1762), colorRule1)
            //red212,green220,blue221 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(498, 1770), colorRule1)
            //red224,green224,blue224 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(580, 1771), colorRule1)
            //red223,green223,blue223 sequenceNumber:72 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(501, 1778), colorRule1)
            //red224,green224,blue224 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(577, 1779), colorRule1)
            //red224,green224,blue224 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(506, 1786), colorRule1)
            //red224,green224,blue224 sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(571, 1788), colorRule1)
            //red224,green224,blue224 sequenceNumber:88 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(512, 1793), colorRule1)
            //red221,green220,blue221 sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(563, 1795), colorRule1)
            //red224,green224,blue224 sequenceNumber:96 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(523, 1799), colorRule1)
            //red223,green223,blue223 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(553, 1800), colorRule1)
            //red223,green223,blue223 sequenceNumber:104 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(531, 1802), colorRule1)
            //red224,green224,blue224 sequenceNumber:112 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(543, 1802), colorRule1)
            //red224,green224,blue224 sequenceNumber:112 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(537, 1803), colorRule1)
            //red224,green224,blue224 sequenceNumber:120 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(538, 1718),CoordinatePoint(538, 1716), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(581, 1754),CoordinatePoint(579, 1754), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:56sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(537, 1803),CoordinatePoint(537, 1805), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:120sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(548, 1769), colorRule1)
            //red224,green224,blue224 sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(540, 1759), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(553, 1774), colorRule1)
            //red224,green224,blue224 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(547, 1751), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(545, 1766), colorRule1)
            //red224,green224,blue224 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(553, 1745), colorRule1)
            //red223,green223,blue223 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(536, 1762), colorRule1)
            //red224,green224,blue224 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(549, 1749), colorRule1)
            //red224,green224,blue224 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(528, 1770), colorRule1)
            //red217,green217,blue217 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(541, 1757), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(525, 1774), colorRule1)
            //red224,green224,blue224 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(529, 1750), colorRule1)
            //red224,green224,blue224 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(532, 1766), colorRule1)
            //red224,green224,blue224 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(524, 1745), colorRule1)
            //red222,green222,blue222 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(535, 1756), colorRule1)
            //red223,green223,blue223 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(528, 1749), colorRule1)
            //red223,green223,blue223 sequenceNumber:63 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(548, 1769),CoordinatePoint(548, 1765), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(528, 1770),CoordinatePoint(528, 1767), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:32sequenceNumber blockNumber: $1  positionType:$1
        )
        FindImgTask(pr, findArea,pointList, tag)
    }


    val fuLiUnSelectArea by lazy {
        ClickArea(694,2214,79,86,false)}

    val isFuLiUnSelectTask by lazy {
        val tag = " isFuLiUnSelect"
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(724, 2226), ColorRuleRatioImpl.getSimple(120,120,120))
            // sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 10, 10, true)
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


    val isIsIntoVipTask by lazy {
        val tag = "isIsIntoVip"
        val colorRule1=ColorRuleRatioImpl.getSimple(247,212,247,212,248,212,1.05F,0.9F,1.05F,0.8962025F,1.05F, 0.9F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(334, 146), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 0  positionType:2
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 10, 10, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(341, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(329, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(348, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(321, 157), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(355, 161), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(317, 160), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(325, 155), colorRule1)
            //red236,green236,blue237 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(335, 146), colorRule1)
            //red236,green236,blue236 sequenceNumber:45 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(321, 157),CoordinatePoint(321, 154), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(435, 145), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(436, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(436, 151), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(444, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 158), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(452, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(426, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(418, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(440, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(448, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 173), colorRule1)
            //red236,green236,blue236 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(456, 164), colorRule1)
            //red236,green236,blue236 sequenceNumber:72 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 181), colorRule1)
            //red236,green236,blue236 sequenceNumber:72 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 185), colorRule1)
            //red236,green236,blue236 sequenceNumber:80 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(435, 177), colorRule1)
            //red236,green236,blue236 sequenceNumber:88 blockNumber: 1  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(440, 164),CoordinatePoint(440, 161), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:56sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(374, 148), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(378, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(373, 152), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(386, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(376, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(394, 147), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(384, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(399, 148), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(392, 156), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 2  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(399, 155), colorRule1)
            //red236,green236,blue236 sequenceNumber:39 blockNumber: 2  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(394, 147),CoordinatePoint(394, 145), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(325, 162), colorRule1)
            //red236,green236,blue237 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(330, 162), colorRule1)
            //red236,green236,blue237 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(338, 162), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(345, 162), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 3  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(338, 162),CoordinatePoint(338, 164), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(372, 166), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(376, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(371, 170), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(384, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(371, 177), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(392, 165), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(401, 166), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 4  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(401, 170), colorRule1)
            //red236,green236,blue236 sequenceNumber:40 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(401, 175), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(401, 167), colorRule1)
            //red236,green236,blue236 sequenceNumber:56 blockNumber: 4  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(392, 165),CoordinatePoint(392, 162), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(386, 171), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(393, 181), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(377, 184), colorRule1)
            //red236,green236,blue236 sequenceNumber:16 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(401, 185), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(367, 187), colorRule1)
            //red236,green236,blue236 sequenceNumber:24 blockNumber: 5  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(385, 178), colorRule1)
            //red236,green236,blue236 sequenceNumber:48 blockNumber: 5  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(377, 184),CoordinatePoint(377, 181), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(316, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:0 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(321, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:8 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(330, 173), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(330, 173), colorRule1)
            //red236,green236,blue237 sequenceNumber:16 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(337, 172), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(322, 184), colorRule1)
            //red236,green236,blue237 sequenceNumber:24 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(345, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:32 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(321, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:32 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(353, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:40 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(333, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:40 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(337, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:48 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(346, 184), colorRule1)
            //red236,green236,blue237 sequenceNumber:56 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(349, 185), colorRule1)
            //red236,green236,blue237 sequenceNumber:64 blockNumber: 6  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(326, 179), colorRule1)
            //red236,green236,blue237 sequenceNumber:72 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(344, 179), colorRule1)
            //red236,green236,blue237 sequenceNumber:72 blockNumber: 6  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(321, 185),CoordinatePoint(317, 185), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:32sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(441, 172), colorRule1)
            //red236,green236,blue236 sequenceNumber:0 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(446, 175), colorRule1)
            //red236,green236,blue236 sequenceNumber:8 blockNumber: 7  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(453, 179), colorRule1)
            //red236,green236,blue236 sequenceNumber:17 blockNumber: 7  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(446, 175),CoordinatePoint(446, 172), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $7  positionType:$7
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }



    val isOnceDailyTask by lazy {
        val tag = "isOnceDaily"
        val colorRule1=ColorRuleRatioImpl.getSimple(255,226,255,212,255,208,1.1211864F,0.9F,1.1405172F,0.9F,1.1211864F, 0.9F)
        val pr  = PointRule(CoordinatePoint(144, 1665), colorRule1)
        //red255,green255,blue255 sequenceNumber:0 blockNumber: 0  positionType:1
        val findArea = CoordinateArea(94,250,684,1559)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(149, 1665), colorRule1)
            //red254,green249,blue248 sequenceNumber:8 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(158, 1665), colorRule1)
            //red254,green249,blue248 sequenceNumber:17 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(149, 1665),CoordinatePoint(149, 1664), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(254, 1663), colorRule1)
            //red253,green241,blue239 sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(252, 1669), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(257, 1667), colorRule1)
            //red253,green243,blue241 sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(262, 1671), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(257, 1667),CoordinatePoint(257, 1666), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(195, 1664), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(192, 1668), colorRule1)
            //red252,green238,blue235 sequenceNumber:6 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(192, 1668),CoordinatePoint(192, 1666), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:6sequenceNumber blockNumber: $2  positionType:$2
        )
        pointList.add(PointRule(CoordinatePoint(169, 1666), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(174, 1665), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(169, 1674), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(182, 1665), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(169, 1683), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(175, 1674), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(174, 1683), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(182, 1675), colorRule1)
            //red252,green237,blue234 sequenceNumber:24 blockNumber: 3  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(182, 1684), colorRule1)
            //red254,green249,blue248 sequenceNumber:33 blockNumber: 3  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(169, 1683),CoordinatePoint(167, 1683), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $3  positionType:$3
        )
        pointList.add(PointRule(CoordinatePoint(201, 1665), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(207, 1665), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(206, 1669), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 4  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(211, 1677), colorRule1)
            //red255,green255,blue255 sequenceNumber:20 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(206, 1669),CoordinatePoint(206, 1671), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(245, 1665), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 5  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(246, 1668), colorRule1)
            //red255,green252,blue252 sequenceNumber:5 blockNumber: 5  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(246, 1668),CoordinatePoint(244, 1668), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:5sequenceNumber blockNumber: $5  positionType:$5
        )
        pointList.add(PointRule(CoordinatePoint(143, 1670), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(149, 1670), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(139, 1676), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(144, 1676), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(157, 1675), colorRule1)
            //red255,green255,blue255 sequenceNumber:16 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(145, 1682), colorRule1)
            //red254,green252,blue251 sequenceNumber:16 blockNumber: 6  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(157, 1681), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(157, 1681), colorRule1)
            //red255,green255,blue255 sequenceNumber:24 blockNumber: 6  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(150, 1685), colorRule1)
            //red255,green254,blue254 sequenceNumber:31 blockNumber: 6  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(157, 1675),CoordinatePoint(155, 1674), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $6  positionType:$6
        )
        pointList.add(PointRule(CoordinatePoint(256, 1671), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(255, 1677), colorRule1)
            //red254,green246,blue244 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(256, 1677), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 8  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(249, 1684), colorRule1)
            //red254,green252,blue251 sequenceNumber:15 blockNumber: 8  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(256, 1677),CoordinatePoint(254, 1676), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $8  positionType:$8
        )
        pointList.add(PointRule(CoordinatePoint(207, 1673), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 10  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(202, 1684), colorRule1)
            //red255,green255,blue255 sequenceNumber:13 blockNumber: 10  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(202, 1684),CoordinatePoint(202, 1682), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:13sequenceNumber blockNumber: $10  positionType:$10
        )
        pointList.add(PointRule(CoordinatePoint(217, 1673), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(223, 1673), colorRule1)
            //red255,green255,blue255 sequenceNumber:8 blockNumber: 11  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(236, 1673), colorRule1)
            //red255,green255,blue255 sequenceNumber:21 blockNumber: 11  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(223, 1673),CoordinatePoint(223, 1671), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $11  positionType:$11
        )
        pointList.add(PointRule(CoordinatePoint(192, 1675), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(198, 1676), colorRule1)
            //red253,green243,blue241 sequenceNumber:8 blockNumber: 12  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(195, 1683), colorRule1)
            //red252,green236,blue232 sequenceNumber:15 blockNumber: 12  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(198, 1676),CoordinatePoint(198, 1673), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $12  positionType:$12
        )
        pointList.add(PointRule(CoordinatePoint(247, 1675), colorRule1)
            //red255,green255,blue255 sequenceNumber:0 blockNumber: 13  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(245, 1682), colorRule1)
            //red255,green255,blue255 sequenceNumber:9 blockNumber: 13  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(245, 1682),CoordinatePoint(243, 1682), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:9sequenceNumber blockNumber: $13  positionType:$13
        )
        FindImgTask(pr, findArea,pointList, tag)
    }

    val is3DiscountArea by lazy {
        ClickArea(135,1926,135,58,false)}

    val is3DiscountTask by lazy {
        val tag = "is3Discount"
        val colorRule1=ColorRuleRatioImpl.getSimple(264,226,231,198,165,142,1.2027272F,1.0309091F,1.6746836F,1.435443F,1.2027272F, 1.0309091F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(CoordinatePoint(168, 1759), colorRule1)
            //red252,green220,blue158 sequenceNumber:0 blockNumber: 0  positionType:1
        )
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(171, 1763), colorRule1)
            //red252,green220,blue158 sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(176, 1771), colorRule1)
            //red252,green220,blue158 sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(185, 1767), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(170, 1777), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(189, 1759), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(177, 1777), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(188, 1762), colorRule1)
            //red252,green220,blue158 sequenceNumber:40 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(179, 1786), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(182, 1772), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(170, 1786), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(184, 1777), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(179, 1793), colorRule1)
            //red252,green220,blue158 sequenceNumber:64 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(179, 1786), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(180, 1786), colorRule1)
            //red252,green220,blue158 sequenceNumber:72 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(187, 1786), colorRule1)
            //red252,green220,blue158 sequenceNumber:80 blockNumber: 0  positionType:1
        )
        pointList.add(TwoPointRule(CoordinatePoint(168, 1759),CoordinatePoint(168, 1756), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(179, 1786),CoordinatePoint(176, 1784), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:72sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(209, 1759), colorRule1)
            //red252,green220,blue158 sequenceNumber:0 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(214, 1759), colorRule1)
            //red252,green220,blue158 sequenceNumber:8 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(223, 1760), colorRule1)
            //red252,green220,blue158 sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(225, 1761), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 1  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(219, 1769), colorRule1)
            //red252,green220,blue158 sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(215, 1774), colorRule1)
            //red252,green220,blue158 sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(224, 1776), colorRule1)
            //red252,green220,blue158 sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(228, 1780), colorRule1)
            //red252,green220,blue158 sequenceNumber:48 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(228, 1788), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(225, 1792), colorRule1)
            //red252,green220,blue158 sequenceNumber:56 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(213, 1792), colorRule1)
            //red252,green220,blue158 sequenceNumber:64 blockNumber: 1  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(211, 1791), colorRule1)
            //red252,green220,blue158 sequenceNumber:76 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(209, 1759),CoordinatePoint(209, 1757), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(TwoPointRule(CoordinatePoint(224, 1776),CoordinatePoint(224, 1773), CompareDifferenceRuleImpl.getSimple(10,30,30)) // sequenceNumber:40sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


}