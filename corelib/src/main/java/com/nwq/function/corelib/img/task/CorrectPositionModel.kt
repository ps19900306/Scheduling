package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import android.text.TextUtils
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.utils.JsonUtil
import com.nwq.function.corelib.utils.sp.SP
import com.nwq.function.corelib.utils.sp.SPRepoPrefix

open class CorrectPositionModel(
    val pointList: List<PointRule>,
    val tag: String,
    val xRange: Int = 0, //初始图片的寻找范围， 必须有一个大于零
    val yRange: Int = 0, //初始图片的寻找范围，必须有一个大于零
    var everyRevalidation: Boolean = !(xRange == 0 && yRange == 0) // 每次都重复验证
) {

    constructor(pointList: List<PointRule>, tag: String, range: Int) : this(
        pointList,
        tag,
        range,
        range
    )

     var offsetX: Int = 0 //发现图片成功的时候X偏差值
     var offsetY: Int = 0 //发现图片成功的时候Y偏差值
    protected var hasCorrect = false


    init {
        if (xRange == 0 && yRange == 0) {
            hasCorrect = true
        } else if (!everyRevalidation) {
            val spStr by SPRepoPrefix.getNowSPRepo().getRecordImgTaskDeviation(tag)
            if (!TextUtils.isEmpty(spStr)) {
                JsonUtil.anyToJsonObject<OffsetRecord>(spStr)?.let {
                    correctCoordinate(it.offsetX, it.offsetY, false)
                }
            }
        }
    }


    fun isCorrect(): Boolean {
        return hasCorrect
    }


    private fun correctCoordinate(ofsX: Int, ofsY: Int, record: Boolean = true) {
        hasCorrect = true
        offsetX = ofsX
        offsetY = ofsY
        if (record) {
            JsonUtil.objectToString(OffsetRecord(ofsX, ofsY)).let {
                var spStr by SPRepoPrefix.getNowSPRepo().getRecordImgTaskDeviation(tag)
                spStr = it
            }
        }
    }

    //这个next可能会被多次调用
    fun check(bitmap: Bitmap, next: (ofsX: Int, ofsY: Int, end: Boolean) -> Boolean) {
        if (hasCorrect && !everyRevalidation) {
            next(offsetX, offsetY, true)
        } else {
            if (xRange > 0 || yRange > 0) {
                val width = if (xRange > 0) {
                    xRange * 2 + 1
                } else {
                    1
                }
                val height = if (yRange > 0) {
                    yRange * 2 + 1
                } else {
                    1
                }
                val size = width * height
                val startX = pointList[0].getCoordinatePoint().xI - xRange
                val startY = pointList[0].getCoordinatePoint().yI - yRange
                val pixels = IntArray(size)
                bitmap.getPixels(
                    pixels,
                    0,
                    width,
                    startX,
                    startY,
                    width,
                    1
                )
                var hasFind = false
                pixels.forEachIndexed { index, colorInt ->
                    if (pointList[0].rule.optInt(colorInt)) {
                        var ofsX = 0
                        var ofsY = 0
                        if (width > 1 && height > 1) {
                            ofsX =
                                startX + index % width - pointList[0].getCoordinatePoint().xI
                            ofsY =
                                startY + index / width - pointList[0].getCoordinatePoint().yI
                        } else if (width > 1 && height == 1) {
                            ofsX = startX + index - pointList[0].getCoordinatePoint().xI
                            ofsY = 0
                        } else if (width == 1 && height > 1) {
                            ofsX = 0
                            ofsY = startY + index - pointList[0].getCoordinatePoint().yI
                        }

                        if (pointList.size > 1) {
                            //找不符合规则的点 只要有则去除
                            val hasFailedPoint = pointList.find {
                                val colorInt =
                                    bitmap.getPixel(it.point.xI + ofsX, it.point.yI + ofsY)
                                !it.rule.optInt(colorInt)
                            }
                            if (hasFailedPoint == null) {
                                if (next.invoke(ofsX, ofsY, false)) {
                                    hasFind = true
                                    correctCoordinate(ofsX, ofsY)
                                    return@forEachIndexed
                                }
                            }
                        } else {
                            if (next.invoke(ofsX, ofsY, false)) {
                                correctCoordinate(ofsX, ofsY)
                                return@forEachIndexed
                            }
                        }
                    }
                }
                next.invoke(0, 0, true)
            }
        }
    }
}