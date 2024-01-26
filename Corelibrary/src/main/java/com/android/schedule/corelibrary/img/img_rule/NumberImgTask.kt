package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule

class NumberImgTask(
    val pr: PointRule, //这个是识别到第一个点的,
    iprList: List<IPR>, tag: String, val width: Int = 0, val height: Int = 0
) : ImgTask(iprList, tag) {


    var numberCount = tag.toIntOrNull() ?: 0

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        //这里不能使用
        return true
    }

    private var findImgPoint: CoordinatePoint? = null //找到图片后的点 这个坐标是基于整个图片的

    fun checkImg(
        bitmap: Bitmap,
        colorInt: Int,
        getPoint: () -> CoordinatePoint
    ): Boolean {
        if (pr.rule.optInt(colorInt)) {
            getPoint().let {
                if (checkImgTask(bitmap, it.xI - pr.point.xI, it.yI - pr.point.yI)) {
                    findImgPoint = it
                    return true
                }
            }
        }
        return false
    }

}