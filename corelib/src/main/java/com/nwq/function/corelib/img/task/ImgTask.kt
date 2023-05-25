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
            !it.checkIpr(bitmap, offsetX, offsetY)
        }
        return hasFailedPoint == null
    }




}