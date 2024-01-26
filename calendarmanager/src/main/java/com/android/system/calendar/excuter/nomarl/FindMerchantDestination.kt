package com.android.system.calendar.excuter.nomarl

import android.graphics.Bitmap
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask

class FindMerchantDestination : BasicImgTask() {

    private val list by lazy {
        var count = 0
        val ls = mutableListOf<MerchantLocationUnit>()
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(1011, 399),
                ClickArea(1011, 322, 84, 88, false)
            )
        )//画眉岛
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(940, 569),
                ClickArea(933, 487, 97, 96, false)
            )
        )//太湖
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(849, 439),
                ClickArea(847, 354, 86, 97, false)
            )
        )//会龙岭
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(722, 576),
                ClickArea(714, 500, 96, 86, false)
            )
        )//镜湖
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(662, 460),
                ClickArea(659, 383, 96, 86, false)
            )
        )//杏子林
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(895, 289),
                ClickArea(898, 205, 78, 96, false)
            )
        )//少室山
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(310, 362),
                ClickArea(310, 282, 91, 93, false)
            )
        )//缥缈峰
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(574, 179),
                ClickArea(565, 134, 102, 63, false)
            )
        )//贺南山
        ls.add(
            MerchantLocationUnit(
                ++count,
                CoordinatePoint(379, 199),
                ClickArea(380, 131, 78, 85, false)
            )
        )//擂鼓山
        ls
    }

    //223  145
    //204  112

    var resultMerchantLocation: MerchantLocationUnit? = null

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        var result: MerchantLocationUnit? = null
        var maxD = 0
        list.forEach {
            val colorInt = bitmap.getPixel(it.coordinatePoint.xI, it.coordinatePoint.yI)
            val nowD = colorInt.red - colorInt.green - colorInt.blue
            if (nowD > maxD) {
                result = it
                maxD = nowD
            }
        }
        resultMerchantLocation = result
        return result != null
    }
}


class MerchantLocationUnit(
    val number: Int,
    val coordinatePoint: CoordinatePoint,
    val clickArea: ClickArea
)