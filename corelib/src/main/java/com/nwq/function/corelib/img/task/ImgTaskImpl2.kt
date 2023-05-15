package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
范围找图，成功后会记录偏差值，以完成后续操作
 */

class ImgTaskImpl2(
    pointList: List<CoordinatePoint>,
    ruleList: List<ColorIdentificationRule>,
    val findArea: CoordinateArea //初始图片的寻找范围
) : ImgTask(pointList, ruleList) {

    private var hasCorrect = false

    fun isCorrect(): Boolean {
        return hasCorrect
    }

    var offsetX: Int = 0 //发现图片成功的时候X偏差值
    var offsetY: Int = 0 //发现图片成功的时候Y偏差值


    //这里是为了修正寻找的区域防止下标越界
    fun correctArea(imgWidth: Int, imgHeight: Int) {
        if (!hasCorrect) {
            hasCorrect = true
            var maxX = 0
            var maxY = 0
            var minX = Int.MAX_VALUE
            var minY = Int.MAX_VALUE
            var firstX = pointList[0].xI
            var firstY = pointList[0].yI
            pointList.forEach {
                if (it.xI > maxX) {
                    maxX = it.xI
                }
                if (it.xI < minX) {
                    minX = it.xI
                }
                if (it.yI > maxY) {
                    maxY = it.yI
                }
                if (it.yI < minY) {
                    minY = it.yI
                }
            }
            val minOfx = findArea.x - (firstX - minX)
            if (minOfx < 0) {
                findArea.x -= minOfx
            }
            val maxOfx = findArea.x + findArea.with + (maxX - firstX)
            if (maxOfx > imgWidth) {
                findArea.with -= maxOfx - imgWidth
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


}