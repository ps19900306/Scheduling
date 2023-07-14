package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import android.graphics.Color
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule

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

    private var findImgPoint: CoordinatePoint? = null //找到图片后的点

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
        if(bitmap==null)
            return false
        return findImgByColor(bitmap, findArea)
    }


    private fun findImgByColor(bitmap: Bitmap, area: CoordinateArea): Boolean {
        val pixels = IntArray(area.width * area.height)
        bitmap.getPixels(
            pixels,
            0,
            area.width,
            area.x,
            area.y,
            area.width,
            area.width
        )
        pixels.forEachIndexed { offset, colorInt ->
            if (pr.rule.optInt(colorInt)) {
                findPoint(area, offset).let {
                    if (checkImgTask(bitmap, it.xI - pr.point.xI, it.yI - pr.point.yI)) {
                        findImgPoint = it
                        return true
                    }
                }
            }
        }
        return false
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




}