package com.nwq.function.corelib.img.task


import android.graphics.Bitmap
import com.nwq.function.scheduling.executer.img.pcheck.IPR
import com.nwq.function.scheduling.executer.img.task.CorrectPositionModel
import com.nwq.function.scheduling.executer.img.task.ImgTask
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
 */
open class ImgTaskImpl3(
    iprList: List<IPR>, tag: String, correctModel: CorrectPositionModel? = null
) : ImgTask(iprList, tag, correctModel) {



    suspend fun verificationRule(bitmap: Bitmap?,offest:Int): Boolean {
        if(bitmap == null)
            return  false
        val result = if (correctModel == null) {
            checkImgTask(
                bitmap = bitmap,
                nErrorTolerance = nErrorTolerance,
                bErrorTolerance = bErrorTolerance
            )
        } else {
            optClickTasks(bitmap, correctModel)
        }
        Timber.d("$tag:$result   NWQ_ 2023/5/26");
        return result
    }

    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if(bitmap == null)
            return  false
        val result = if (correctModel == null) {
            checkImgTask(
                bitmap = bitmap,
                nErrorTolerance = nErrorTolerance,
                bErrorTolerance = bErrorTolerance
            )
        } else {
            optClickTasks(bitmap, correctModel)
        }
        Timber.d("$tag:$result   NWQ_ 2023/5/26");
        return result
    }

    protected suspend fun optClickTasks(
        bitmap: Bitmap, correctModel: CorrectPositionModel
    ): Boolean = suspendCoroutine {
        correctModel.check(bitmap = bitmap, next = { x, y, end ->
            if (end) {
                if (correctModel.isCorrect()) {
                    val result = checkImgTask(bitmap, x, y, nErrorTolerance, bErrorTolerance)
                    it.resume(result)
                } else {
                    it.resume(false)
                }
                false
            } else {
                val result = checkImgTask(bitmap, x, y, nErrorTolerance, bErrorTolerance)
                if (result) {
                    it.resume(true)
                    true
                } else {
                    false
                }
            }
        })
    }


    fun clearCorrect() {
        correctModel?.clearCorrect()
    }

}