package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
范围找图，成功后会记录偏差值，以完成后续操作
 */

class ImgTaskImpl2(
    iprList: List<IPR>, tag: String,val findArea: CoordinateArea //初始图片的寻找范围
) : ImgTask(iprList,tag) {

    private var correctArea = false

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