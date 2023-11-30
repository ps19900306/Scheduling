package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
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


    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        val result = if (correctModel == null) {
            checkImgTask(
                bitmap = bitmap,
                nE = nErrorTolerance,
                bE= bErrorTolerance
            )
        } else {
            optClickTasks(bitmap, correctModel)
        }
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


    //根据偏差值构造新的找寻任务
    fun copyOffset(tag: String, offsetX: Int, offsetY: Int): ImgTaskImpl1 {
        val cList = mutableListOf<PointRule>()
        correctModel?.pointList?.let {
            cList.addAll(it)
        }
        val newCorrectModel = CorrectPositionModel(
            cList, tag, correctModel?.xRange ?: 3, correctModel?.yRange ?: 3,
            correctModel?.everyRevalidation ?: false
        )
        newCorrectModel.supplementalValueX = offsetX
        newCorrectModel.supplementalValueY = offsetY

        val coordinateArea = if (clickArea != null) {
            ClickArea(
                clickArea!!.x + offsetX,
                clickArea!!.y + offsetY,
                clickArea!!.width,
                clickArea!!.height
            )
        } else {
            null
        }

        return ImgTaskImpl1(iprList, tag, newCorrectModel).apply {
            this.clickArea = coordinateArea
            this.nErrorTolerance = nErrorTolerance
            this.bErrorTolerance = bErrorTolerance
        }
    }
}