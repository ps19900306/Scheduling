package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.BasicTask
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
 * 不能实列化
 */
abstract class ImgTask(
    val iprList: List<IPR>, val tag: String,val correctModel: CorrectModel? = null
) : BasicTask {

   suspend abstract fun verificationRule(bitmap: Bitmap):Boolean

}