package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinateArea
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
    iprList: List<IPR>, tag: String, correctModel: CorrectPositionModel? = null
) : ImgTask(iprList, tag, correctModel) {


    var nErrorTolerance: Int = 0 //普通点容错
    var bErrorTolerance: Int = 2 //背景点容错

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