package com.android.system.calendar.excuter.nomarl

import android.graphics.Bitmap
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.expand.inArea
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
import kotlin.math.abs

class FindMerchantDestination(val findImgTask: FindImgTask) : BasicImgTask() {

    private val list by lazy {

        val ls = mutableListOf<MerchantLocationUnit>()
        //这里是第一行
        ls.add(
            MerchantLocationUnit(
                1,
                1,
                1,
                3,
                CoordinatePoint(310, 362),
                ClickArea(310, 282, 91, 93, false)
            )
        )//缥缈峰
        ls.add(
            MerchantLocationUnit(
                1,
                2,
                2,
                2,
                CoordinatePoint(379, 199),
                ClickArea(380, 131, 78, 85, false)
            )
        )//擂鼓山
        ls.add(
            MerchantLocationUnit(
                1,
                3,
                3,
                1,
                CoordinatePoint(574, 179),
                ClickArea(565, 134, 102, 63, false)
            )
        )//贺南山

        //这里是第二行
        ls.add(
            MerchantLocationUnit(
                2,
                1,
                1,
                2,
                CoordinatePoint(662, 460),
                ClickArea(659, 383, 96, 86, false)
            )
        )//杏子林
        ls.add(
            MerchantLocationUnit(
                2,
                2,
                2,
                1,
                CoordinatePoint(849, 439),
                ClickArea(847, 354, 86, 97, false)
            )
        )//会龙岭


        //这个是第三行
        ls.add(
            MerchantLocationUnit(
                3,
                1,
                1,
                5,
                CoordinatePoint(722, 576),
                ClickArea(714, 500, 96, 86, false)
            )
        )//镜湖
        ls.add(
            MerchantLocationUnit(
                3,
                2,
                2,
                4,
                CoordinatePoint(1011, 399),
                ClickArea(1011, 322, 84, 88, false)
            )
        )//画眉岛
        ls.add(
            MerchantLocationUnit(
                3,
                3,
                3,
                3,
                CoordinatePoint(940, 569),
                ClickArea(933, 487, 97, 96, false)
            )
        )//太湖
        ls.add(
            MerchantLocationUnit(
                3,
                4,
                4,
                2,
                CoordinatePoint(895, 289),
                ClickArea(898, 205, 78, 96, false)
            )
        )//少室山


        ls
    }

    //223  145
    //204  112

    var resultMerchantLocation: MerchantLocationUnit? = null

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        val resultList = mutableListOf<MerchantLocationUnit>()
        var maxD = 0
        list.forEach {
            val colorInt = bitmap.getPixel(it.coordinatePoint.xI, it.coordinatePoint.yI)
            val nowD = colorInt.red - colorInt.green - colorInt.blue
            if (nowD > maxD) {
                resultList.clear()
                resultList.add(it)
                maxD = nowD
            } else if (nowD == maxD) {
                resultList.add(it)
            }
        }
        if (resultList.size > 1) {
            if (findImgTask.verificationRule(bitmap)) {
                val nowLocationPoint = findImgTask.getFindPoint()
                if (nowLocationPoint == null) {
                    resultMerchantLocation = resultList.get(0)
                } else {

                    var tempLocationUnit = list.find {
                        nowLocationPoint.inArea(it.clickArea)
                    }

                    val nowLocationUnit = if (tempLocationUnit == null) {
                        list.sortBy {
                            abs(it.coordinatePoint.xI - nowLocationPoint.xI) + abs(it.coordinatePoint.yI - nowLocationPoint.yI)
                        }
                        list[0]
                    } else {
                        tempLocationUnit
                    }

                    resultList.sortBy {
                        if (nowLocationUnit.rowNumber == it.rowNumber) {
                            abs(nowLocationUnit.rowNumber - it.columnNumber)
                        } else {
                            val leftD = nowLocationUnit.LeftDistance + it.LeftDistance
                            val rightD = nowLocationUnit.RightDistance + it.RightDistance
                            Math.min(leftD, rightD)
                        }
                    }


                    resultMerchantLocation = resultList.get(0)
                }
            } else {
                resultMerchantLocation = resultList.get(0)
            }
            return true
        } else if (resultList.size == 1) {
            resultMerchantLocation = resultList.get(0)
            return true
        } else {
            return false
        }
    }
}


class MerchantLocationUnit(
    val rowNumber: Int,
    val columnNumber: Int,
    val LeftDistance: Int,
    val RightDistance: Int,
    val coordinatePoint: CoordinatePoint,
    val clickArea: ClickArea
)