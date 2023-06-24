package com.nwq.function.corelib.auto_code.ui.data

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

/**
create by: 86136
create time: 2023/5/16 9:41
Function description:
 */

class FeatureCoordinatePoint(
    val x: Int, val y: Int, val red: Int, val green: Int, val blue: Int
) {

    companion object {
        const val NONE = 1
        const val INTERNAL_TYPE = 2
        const val BOUNDARY_TYPE = 4
    }

    constructor(colorInt: Int) : this(
        0, 0, colorInt.red, colorInt.green, colorInt.blue
    )

    constructor(x: Int, y: Int, colorInt: Int) : this(
        x, y, colorInt.red, colorInt.green, colorInt.blue
    )


    var isIdentificationKey = false //是否作为识别的关键点
    var mFeaturePointKey: FeaturePointKey? = null
    var mOriginalPointKey: FeaturePointKey? = null //如果进行了合并，这个是原来的的值
    var mDirectorPointKey: FeaturePointKey? = null //如果进行了取背景色这个是 进行取背景色的色值

    //这里又来排顺序的
    var hasContinuousSet = false //是否被设置 边界点或者内部点
    var hasFindRound = false     //是否被找寻 向四周寻找
    var startX = 0
    var startY = 0
    var sequenceNumber = 0  //这个是进行排序使用的


    fun setStartPosition() {
        hasContinuousSet = true
        hasFindRound = true
        startX = x
        startY = x
        sequenceNumber = 0
    }

    var previousPoint: FeatureCoordinatePoint? = null
    var isAdd = false

    fun continuePath(p: FeatureCoordinatePoint): FeatureCoordinatePoint? {
        if (!hasContinuousSet) { //如果没有被设置则进行设置
            previousPoint = p
            hasContinuousSet = true
            startX = p.startY
            startY = p.startY
            sequenceNumber = p.sequenceNumber + 1
        }
        return if (hasFindRound) {
            null
        } else if (isBoundary()) {
            hasFindRound = true
            this
        } else {
            null
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

    fun isInternal(): Boolean {
        return positionType == INTERNAL_TYPE
    }


    fun isBoundary(): Boolean {
        return positionType == BOUNDARY_TYPE
    }
}