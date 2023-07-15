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
   protected val iprList: List<IPR>,protected val tag: String,protected val correctModel: CorrectPositionModel? = null
) : BasicImgTask() {

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
                //Timber.d("${it.getCoordinatePoint()}");
                if (it.getColorRule() is ColorRuleRatioImpl || it.getColorRule() is ColorRuleImpl) {
                    normalErrorCount++
                    if (normalErrorCount > nErrorTolerance) {
                        return false
                    }
                } else if (it.getColorRule() is ColorRuleRatioUnImpl || it.getColorRule() is ColorRuleUnImpl) {
                    backgroundErrorCount++
                    if (backgroundErrorCount > bErrorTolerance) {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }

    fun getOffsetX(): Int {
        return correctModel?.getOffsetXSupple()?:0
    }

    fun getOffsetY(): Int {
        return correctModel?.getOffsetYSupple()?:0
    }
}