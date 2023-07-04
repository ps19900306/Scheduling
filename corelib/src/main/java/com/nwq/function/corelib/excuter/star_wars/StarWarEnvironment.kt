package com.nwq.function.corelib.excuter.star_wars

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


    val isLoadingGameTask by lazy {
        val tag = "isLoadingGame"
        val list = mutableListOf<PointRule>(PointRule(CoordinatePoint(1735, 441), ColorRuleRatioImpl.getSimple(61,62,57)))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
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

    val isUpdateGameTask by lazy {
        val tag = "isUpdateGame"
        val list = mutableListOf<PointRule>(PointRule(CoordinatePoint(1350, 701), ColorRuleRatioImpl.getSimple(200,225,222)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1381, 701), ColorRuleRatioImpl.getSimple(184,210,207)))
        pointList.add(PointRule(CoordinatePoint(1335, 703), ColorRuleRatioImpl.getSimple(191,211,210)))
        pointList.add(PointRule(CoordinatePoint(1373, 722), ColorRuleRatioImpl.getSimple(226,242,239)))
        pointList.add(PointRule(CoordinatePoint(1361, 727), ColorRuleRatioImpl.getSimple(210,232,229)))
        pointList.add(PointRule(CoordinatePoint(1353, 728), ColorRuleRatioImpl.getSimple(183,212,208)))
        pointList.add(PointRule(CoordinatePoint(1390, 729), ColorRuleRatioImpl.getSimple(189,214,211)))
        pointList.add(PointRule(CoordinatePoint(1347, 698), ColorRuleRatioImpl.getSimple(43,90,84)))
        pointList.add(PointRule(CoordinatePoint(1332, 700), ColorRuleRatioImpl.getSimple(47,92,87)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }


    val isAnnouncementTask by lazy {
        val tag = "isAnnouncement"
        val list = mutableListOf<PointRule>(PointRule(CoordinatePoint(1292, 119), ColorRuleRatioImpl.getSimple(252,254,253)))
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1276, 121), ColorRuleRatioImpl.getSimple(244,246,245)))
        pointList.add(PointRule(CoordinatePoint(1280, 128), ColorRuleRatioImpl.getSimple(254,254,254)))
        pointList.add(PointRule(CoordinatePoint(1308, 128), ColorRuleRatioImpl.getSimple(255,255,255)))
        pointList.add(PointRule(CoordinatePoint(1276, 142), ColorRuleRatioImpl.getSimple(250,252,251)))
        pointList.add(PointRule(CoordinatePoint(1298, 142), ColorRuleRatioImpl.getSimple(251,251,251)))
        pointList.add(PointRule(CoordinatePoint(1276, 152), ColorRuleRatioImpl.getSimple(254,254,254)))
        pointList.add(PointRule(CoordinatePoint(1307, 155), ColorRuleRatioImpl.getSimple(255,255,255)))
        pointList.add(PointRule(CoordinatePoint(1292, 168), ColorRuleRatioImpl.getSimple(252,254,253)))
        pointList.add(PointRule(CoordinatePoint(1305, 169), ColorRuleRatioImpl.getSimple(222,224,223)))
        pointList.add(PointRule(CoordinatePoint(1274, 170), ColorRuleRatioImpl.getSimple(251,251,251)))
        pointList.add(PointRule(CoordinatePoint(1289, 116), ColorRuleRatioUnImpl.getSimple( 289,189,290,190,292,192,
            1.195F,0.7966667F,1.185124F,0.79008263F,1.1900827F, 0.7933884F)
            //red32 green35 blue40
        ))
        pointList.add(PointRule(CoordinatePoint(1302, 171), ColorRuleRatioUnImpl.getSimple( 289,189,290,190,292,192,
            1.195F,0.7966667F,1.185124F,0.79008263F,1.1900827F, 0.7933884F)
            //red52 green56 blue59
        ))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

}