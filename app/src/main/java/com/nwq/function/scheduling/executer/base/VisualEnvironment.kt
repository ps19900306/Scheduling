package com.nwq.function.scheduling.executer.base

import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule
import com.nwq.function.scheduling.core_code.img.PointColorVerification

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
        return PointColorVerification.CoordinateRule(Coordinate(x.toFloat(), y.toFloat()), rule, range)
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
        return PointColorVerification.CoordinateColor(Coordinate(x.toFloat(), y.toFloat()), colorRule, tolerance, range)
    }
}