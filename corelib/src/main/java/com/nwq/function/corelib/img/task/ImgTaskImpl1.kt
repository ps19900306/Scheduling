package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.IPR
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
固定点找图，成功后会记录偏差值，以优化流程
 */
open class ImgTaskImpl1(
    iprList: List<IPR>,
    tag: String,
    correctModel: CorrectPositionModel? = null
) : ImgTask(iprList, tag, correctModel) {

    override suspend fun verificationRule(bitmap: Bitmap): Boolean {
        val result = if (correctModel == null) {
            checkImgTask(bitmap)
        } else {
            optClickTasks(bitmap, correctModel)
        }
        Timber.d("$tag:$result   NWQ_ 2023/5/26");
        return result
    }

    suspend fun optClickTasks(
        bitmap: Bitmap, correctModel: CorrectPositionModel
    ): Boolean = suspendCoroutine {
        correctModel.check(bitmap = bitmap, next = { x, y, end ->
            if (end) {
                it.resume(false)
                false
            } else {
                val result = checkImgTask(bitmap, x, y)
                if (result) {
                    it.resume(true)
                    true
                } else {
                    false
                }
            }
        })
    }


}