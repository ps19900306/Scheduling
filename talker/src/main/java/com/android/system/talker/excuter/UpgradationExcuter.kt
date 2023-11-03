package com.android.system.talker.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule

class UpgradationExcuter(acService: AccessibilityService,
                         onEnd: () -> Unit,):TurnBaseController(acService,onEnd) {


    override fun start() {

    }

    override fun end() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }


    val isOpenTask by lazy {
        val tag = "isOpen"
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 245,180,233,177,210,148,
            1.1140845F,0.9F,1.404142F,0.9F,1.3385965F, 0.99450004F)
        val list = mutableListOf<PointRule>()
        list.add(PointRule(
            CoordinatePoint(1666, 791), ruleRatio1
            //red223 green219 blue192 blockNumber2
        ))
        val correctPositionModel = CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(1700, 790), ruleRatio1
            //red222 green221 blue200 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1696, 799), ruleRatio1
            //red214 green208 blue176 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1705, 799), ruleRatio1
            //red223 green220 blue187 blockNumber1
        ))
        pointList.add(PointRule(CoordinatePoint(1666, 791), ruleRatio1
            //red223 green219 blue192 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1673, 797), ruleRatio1
            //red216 green207 blue178 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1665, 801), ruleRatio1
            //red213 green210 blue175 blockNumber2
        ))
        pointList.add(PointRule(CoordinatePoint(1683, 791), ruleRatio1
            //red223 green221 blue196 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1689, 798), ruleRatio1
            //red220 green214 blue180 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1680, 800), ruleRatio1
            //red212 green209 blue176 blockNumber3
        ))
        pointList.add(PointRule(CoordinatePoint(1703, 805), ruleRatio1
            //red226 green218 blue171 blockNumber4
        ))
        pointList.add(PointRule(CoordinatePoint(1671, 806), ruleRatio1
            //red225 green214 blue169 blockNumber5
        ))
        pointList.add(PointRule(CoordinatePoint(1679, 807), ruleRatio1
            //red226 green215 blue170 blockNumber5
        ))
        pointList.add(TwoPointRule(CoordinatePoint(1683, 791),CoordinatePoint(1683, 794), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        pointList.add(TwoPointRule(CoordinatePoint(1700, 790),CoordinatePoint(1699, 794), CompareDifferenceRuleImpl.getSimple(30,30,30)))
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }

}
