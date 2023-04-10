package com.nwq.function.scheduling.executer.base

import android.telecom.CallRedirectionService
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule
import com.nwq.function.scheduling.core_code.img.PointColorVerification
import com.nwq.function.scheduling.executer.star_wars.rule.SimpleComparisonRule
import com.nwq.function.scheduling.executer.star_wars.rule.SimpleRule

/**
create by: 86136
create time: 2023/2/28 10:37
Function description:
所有需要进行图片判断的方法都需要放到这个里面
 */

abstract class VisualEnvironment(val helper: AccessibilityHelper) {

    protected val screenBitmap
        get() = helper.screenBitmap!!

    fun verificationTask(
        x: Float,
        y: Float,
        rule: ColorIdentificationRule,
        range: Int = 0,
    ): PointColorVerification {
        return PointColorVerification.CoordinateRule(Coordinate(x, y), rule, range)
    }

    fun verificationTask(
        x: Int,
        y: Int,
        rule: ColorIdentificationRule,
        range: Int = 0,
    ): PointColorVerification {
        return PointColorVerification.CoordinateRule(
            Coordinate(x.toFloat(), y.toFloat()),
            rule,
            range
        )
    }


    fun verificationTask(
        x: Float,
        y: Float,
        colorRule: String,
        tolerance: Int = 5,
        range: Int = 0,
    ): PointColorVerification {
        return PointColorVerification.CoordinateColor(Coordinate(x, y), colorRule, tolerance, range)
    }

    fun verificationTask(
        x: Int,
        y: Int,
        colorRule: String,
        tolerance: Int = 5,
        range: Int = 0,
    ): PointColorVerification {
        return PointColorVerification.CoordinateColor(
            Coordinate(x.toFloat(), y.toFloat()),
            colorRule,
            tolerance,
            range
        )
    }


    fun buildSinglePointTask(
        x1: Int,
        y1: Int,
        red1: Int,
        green1: Int,
        blue1: Int,
        range: Int = 1
    ): PointColorVerification {
        return PointColorVerification.CoordinateRule(
            Coordinate(x1, y1),
            SimpleRule.getSimple(red1, green1, blue1),
            range
        )
    }


    fun buildTwoPointTask(
        x1: Int,
        y1: Int,
        red1: Int,
        green1: Int,
        blue1: Int,
        x2: Int,
        y2: Int,
        red2: Int,
        green2: Int,
        blue2: Int,
    ): PointColorVerification {
        return PointColorVerification.TwoPointTask(
            Coordinate(x1, y1), Coordinate(x2, y2),
            SimpleComparisonRule.getSimpleComparison(red1, green1, blue1, red2, green2, blue2)
        )
    }
}