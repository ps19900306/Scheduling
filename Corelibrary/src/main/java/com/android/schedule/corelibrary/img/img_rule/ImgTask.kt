package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.color_rule.ColorRuleImpl
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioUnImpl
import com.android.schedule.corelibrary.img.color_rule.ColorRuleUnImpl
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRules
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule

/**
 * 不能实列化
 */
abstract class ImgTask(
    val iprList: List<IPR>,
    protected val tag: String,
    val correctModel: CorrectPositionModel? = null
) : BasicImgTask() {

    var nErrorTolerance: Int = 0 //普通点容错
    var bErrorTolerance: Int = iprList.filter { it.getColorRule() is ColorRuleRatioUnImpl || it.getColorRule() is ColorRuleUnImpl || it is TwoPointRule }.size -1 //背景点容错
    var clickArea: ClickArea? = null //如果




    var  openArea: ClickArea? = null
    var  endArea: ClickArea? = null
    var  closeArea: ClickArea? = null


    protected fun checkImgTask(
        bitmap: Bitmap,
        offsetX: Int = 0,
        offsetY: Int = 0,
        nErrorTolerance: Int = 0,
        bErrorTolerance: Int = 0
    ): Boolean {
        var normalErrorCount = 0    //普通点错误容忍度
        var backgroundErrorCount = 0
        iprList.forEach {
            if (!it.checkIpr(bitmap, offsetX, offsetY)) {
                if (it.getColorRule() is ColorRuleRatioImpl || it is PointRules) {
                    normalErrorCount++
                    if (normalErrorCount > nErrorTolerance) {
                        return false
                    }
                } else if (it.getColorRule() is ColorRuleImpl || it.getColorRule() is ColorRuleUnImpl) {
                    backgroundErrorCount++
                    if (backgroundErrorCount > bErrorTolerance) {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        //智斗都符合的清空才记录修正点
        if (normalErrorCount == 0) {
            correctModel?.let {
                it.correctCoordinate(
                    offsetX - it.supplementalValueX,
                    offsetY - it.supplementalValueY
                )
            }
        }
        return true
    }

    //这里有补充值
    override fun getOffsetX(): Int {
        return correctModel?.getOffsetXSupple() ?: 0
    }

    override fun getOffsetY(): Int {
        return correctModel?.getOffsetYSupple() ?: 0
    }

    //这里没有补充值
    fun getOffX(): Int {
        return correctModel?.offsetX ?: 0
    }

    //这里没有补充值点
    fun getOffY(): Int {
        return correctModel?.offsetY ?: 0
    }





}