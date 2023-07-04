package com.nwq.function.corelib.excuter.star_wars

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.task.CorrectPositionModel
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 */

object StarWarEnvironment {


    val isLoadingGameTask by lazy {
        val tag = "isLoadingGame"
        val list = mutableListOf<PointRule>()
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1735, 441), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1726, 470), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1792, 470), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1801, 479), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1742, 482), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1728, 489), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1784, 510), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1738, 512), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1724, 519), ColorRuleRatioImpl.getSimple(61,62,57)))
        pointList.add(PointRule(CoordinatePoint(1790, 430), ColorRuleRatioImpl.getSimple(231,0,18)))
        pointList.add(PointRule(CoordinatePoint(1798, 435), ColorRuleRatioImpl.getSimple(232,0,18)))
        pointList.add(PointRule(CoordinatePoint(1788, 438), ColorRuleRatioImpl.getSimple(231,0,18)))
        pointList.add(PointRule(CoordinatePoint(1803, 443), ColorRuleRatioImpl.getSimple(231,0,18)))
        pointList.add(PointRule(CoordinatePoint(1786, 448), ColorRuleRatioImpl.getSimple(231,0,18)))
        pointList.add(PointRule(CoordinatePoint(1794, 449), ColorRuleRatioImpl.getSimple(231,0,18)))
        pointList.add(PointRule(CoordinatePoint(1732, 438), ColorRuleRatioImpl.getSimple(255,255,255)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

}