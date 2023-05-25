package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.BasicTask
import com.nwq.function.corelib.img.pcheck.*

/**
 * 不能实列化
 */
abstract class ImgTask(
    val iprList: List<IPR>, val tag: String, val correctModel: CorrectPositionModel? = null
) : BasicTask {

    abstract suspend fun verificationRule(bitmap: Bitmap): Boolean


    protected fun checkImgTask(bitmap: Bitmap, offsetX: Int = 0, offsetY: Int = 0): Boolean {
        val hasFailedPoint = iprList.find {
            !checkIpr(bitmap, it, offsetX, offsetY)
        }
        return hasFailedPoint == null
    }

    //这里是验证规则的地方
    protected fun checkIpr(bitmap: Bitmap, ipr: IPR, offsetX: Int = 0, offsetY: Int = 0): Boolean {
        when (ipr) {
            is PointRule -> {
                val intColor = bitmap.getPixel(ipr.point.xI + offsetX, ipr.point.yI + offsetY)
                return ipr.rule.optInt(intColor)
            }
            is PointRules -> {
                val intColor = bitmap.getPixel(ipr.point.xI + offsetX, ipr.point.yI + offsetY)
                return ipr.rule.find { it.optInt(intColor) } != null
            }
            is PointsRule -> {
                return ipr.points.find { point ->
                    val intColor = bitmap.getPixel(point.xI + offsetX, point.yI + offsetY)
                    ipr.rule.optInt(intColor)
                } != null
            }
            is TwoAreaRule -> {
                return false
            }
            is TwoPointRule -> {
                val intColor1 = bitmap.getPixel(ipr.point1.xI + offsetX, ipr.point1.yI + offsetY)
                val intColor2 = bitmap.getPixel(ipr.point2.xI + offsetX, ipr.point2.yI + offsetY)
                return ipr.rule.optInt(intColor1, intColor2)
            }
            else -> {
                return false
            }
        }
    }


}