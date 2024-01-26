package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.utils.L


/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
范围找图，成功后会记录偏差值，以完成后续操作
 */
open class FindImgTask(
    val pr: PointRule, //这个是识别到第一个点的     这个点选取很关键
    val findArea: CoordinateArea, //初始图片的寻找范围
    iprList: List<IPR>, tag: String,
) : ImgTask(iprList, tag) {

    private var correctArea = false
    protected var findImgPoint: CoordinatePoint? = null //找到图片后的点 这个坐标是基于整个图片的


    override fun logColor(bitmap: Bitmap) {
        val pX = pr.point.xI
        val pY = pr.point.yI
        val intColor = bitmap.getPixel(pX, pY)
        L.d("frist x:$pX y:$pY alpha:${intColor.alpha}  red:${intColor.red} green:${intColor.green} blue:${intColor.blue}")
        super.logColor(bitmap)
    }

    //这里是为了修正寻找的区域防止下标越界
    fun correctArea(imgWidth: Int, imgHeight: Int) {
        if (!correctArea) {
            correctArea = true
            var maxX = 0
            var maxY = 0
            var minX = Int.MAX_VALUE
            var minY = Int.MAX_VALUE
            var firstX = iprList[0].getCoordinatePoint().xI
            var firstY = iprList[0].getCoordinatePoint().yI
            iprList.forEach {
                if (it.getCoordinatePoint().xI > maxX) {
                    maxX = it.getCoordinatePoint().xI
                }
                if (it.getCoordinatePoint().xI < minX) {
                    minX = it.getCoordinatePoint().xI
                }
                if (it.getCoordinatePoint().yI > maxY) {
                    maxY = it.getCoordinatePoint().yI
                }
                if (it.getCoordinatePoint().yI < minY) {
                    minY = it.getCoordinatePoint().yI
                }
            }
            val minOfx = findArea.x - (firstX - minX)
            if (minOfx < 0) {
                findArea.x -= minOfx
            }
            val maxOfx = findArea.x + findArea.width + (maxX - firstX)
            if (maxOfx > imgWidth) {
                findArea.width -= maxOfx - imgWidth
            }
            val minOfy = findArea.y - (firstY - minY)
            if (minOfy < 0) {
                findArea.y -= minOfy
            }
            val maxOfy = findArea.y + findArea.height + (maxY - firstY)
            if (maxOfy > imgHeight) {
                findArea.height -= maxOfy - imgHeight
            }
        }
    }

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null) {
            return false
        }

        return findImgByColor(bitmap, findArea)
    }


    protected fun findImgByColor(bitmap: Bitmap, area: CoordinateArea): Boolean {
        //这里修正图片是为了保证不月觉
//        if(!correctArea)
//            correctArea(bitmap.width,bitmap.height)
        val pixels = IntArray(area.width * area.height)
        bitmap.getPixels(
            pixels,
            0,
            area.width,
            area.x,
            area.y,
            area.width,
            area.height
        )
        pixels.forEachIndexed { offset, colorInt ->
            if (pr.rule.optInt(colorInt)) {
                findPoint(area, offset).let {
                    if (!needIgnoredPoint(it) && checkImgTask(
                            bitmap,
                            it.xI - pr.point.xI,
                            it.yI - pr.point.yI
                        )
                    ) {
                        setImgKeyPoint(it)
                        return true
                    }
                }
            }
        }
        return false
    }


    override fun getOffsetX(): Int {
        return (findImgPoint?.xI ?: pr.point.xI) - pr.point.xI
    }

    override fun getOffsetY(): Int {
        return (findImgPoint?.yI ?: pr.point.yI) - pr.point.yI
    }

    private fun findPoint(area: CoordinateArea, offset: Int): CoordinatePoint {
        return if (area.width > 1 && area.height > 1) {
            val x = area.x + offset % area.width
            val y = area.y + offset / area.width
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else if (area.width > 1 && area.height == 1) {
            val x = area.x + offset
            val y = area.y
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else if (area.width == 1 && area.height > 1) {
            val x = area.x
            val y = area.y + offset
            CoordinatePoint(x.toFloat(), y.toFloat())
        } else {
            CoordinatePoint(area.x, area.y)
        }
    }


    protected open fun needIgnoredPoint(coordinatePoint: CoordinatePoint): Boolean {
        return false
    }

    protected open fun setImgKeyPoint(coordinatePoint: CoordinatePoint) {
        findImgPoint = coordinatePoint
    }

}