package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.baseIf.BasicTask
import com.nwq.function.corelib.img.pcheck.*
import com.nwq.function.corelib.img.rule.ColorRuleImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioUnImpl
import com.nwq.function.corelib.img.rule.ColorRuleUnImpl
import timber.log.Timber

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

    var clickArea: CoordinateArea? = null //如果

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
    fun getOffsetX(): Int {
        return correctModel?.getOffsetXSupple() ?: 0
    }

    fun getOffsetY(): Int {
        return correctModel?.getOffsetYSupple() ?: 0
    }

    //这里只修正相对偏差值 不修正补充的
    fun getOfsArea(): CoordinateArea? {
        clickArea?.let {
            it.offsetX = getOffX()
            it.offsetY = getOffY()
        }
        return clickArea
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