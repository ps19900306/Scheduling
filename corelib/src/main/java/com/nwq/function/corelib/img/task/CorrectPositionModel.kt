package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.PointRule

class CorrectPositionModel(
    val pointList: List<PointRule>,
    val xRange: Int = 0, //初始图片的寻找范围， 必须有一个大于零
    val yRange: Int = 0, //初始图片的寻找范围，必须有一个大于零
    var everyRevalidation: Boolean = !(xRange == 0 && yRange == 0) // 每次都重复验证
) {

    constructor(iprList: List<PointRule>, range: Int) : this(iprList, range, range)

    protected var offsetX: Int = 0 //发现图片成功的时候X偏差值
    protected var offsetY: Int = 0 //发现图片成功的时候Y偏差值
    protected var hasCorrect = false

    init {
        if (xRange == 0 && yRange == 0) {
            hasCorrect = true
        }
    }


    fun isCorrect(): Boolean {
        return hasCorrect
    }


    fun correctCoordinate(ofsX: Int, ofsY: Int) {
        if (!hasCorrect) {
            hasCorrect = true
            offsetX = ofsX
            offsetY = ofsY
        }
    }


    suspend fun check(bitmap: Bitmap) {
        if (hasCorrect && !everyRevalidation) {

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
                pixels.forEachIndexed { index, colorInt ->
                    if (pointList[0].rule.optInt(colorInt)) {
                        if (width > 1 && height > 1) {
                            val offsetX = startX + index % width - pointList[0].getCoordinatePoint().xI
                            val offsetY = startY + index / width - pointList[0].getCoordinatePoint().yI
                        } else if (width > 1 && height == 1) {
                            val offsetX = startX + index - pointList[0].getCoordinatePoint().xI
                            val offsetY = 0
                        } else if (width == 1 && height > 1) {
                            val offsetX = 0
                            val offsetY = startY + index - pointList[0].getCoordinatePoint().yI
                        } else {
                            val offsetX = 0
                            val offsetY = 0
                        }
                    }
                }
            }
        }
    }


}