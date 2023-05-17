package com.nwq.function.corelib.auto_code

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

/**
create by: 86136
create time: 2023/5/16 9:41
Function description:
 */

class FeatureCoordinatePoint(
    val x: Int,
    val y: Int,
    val red: Int,
    val green: Int,
    val blue: Int
) {

    companion object {
        const val NONE = 1
        const val INTERNAL_TYPE = 2
        const val BOUNDARY_TYPE = 4
    }


    constructor(x: Int, y: Int, colorInt: Int) : this(
        x,
        y,
        colorInt.red,
        colorInt.green,
        colorInt.blue
    )

    var isIdentificationKey = false //是否作为识别的关键点

    //这里又来排顺序的
    var hasContinuousSet = false //是否被设置
    var hasFindRound = false     //是否被找寻
    var startX = 0
    var startY = 0
    var sequenceNumber = 0


    fun setStartPosition() {
        hasContinuousSet = true
        hasFindRound = true
        startX = x
        startY = x
        sequenceNumber = 0
    }

    var previousPoint: FeatureCoordinatePoint? = null

    fun continuePath(p: FeatureCoordinatePoint): FeatureCoordinatePoint? {
        if (!hasContinuousSet) {
            previousPoint = p
            hasContinuousSet = true
            startX = p.startY
            startY = p.startY
            sequenceNumber = p.sequenceNumber + 1
        }
        return if (hasFindRound) {
            null
        } else {
            hasFindRound = true
            this
        }
    }


    var positionType: Int = NONE //是否是在组的边界点上

    fun hasJudeType(): Boolean {
        return positionType != NONE
    }

    fun setBoundary() {
        positionType = BOUNDARY_TYPE
    }

    fun setInternal() {
        positionType = INTERNAL_TYPE
    }


}