package com.android.schedule.corelibrary.img.img_rule


import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
这个用于判断进度条血条的
 */
open class HpTaskImpl(
    iprList: List<IPR>, tag: String, correctModel: CorrectPositionModel? = null
) : ImgTask(iprList, tag, correctModel) {


    var lastP = iprList.size

    //如果是满血返回false 不是返回true
    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null)
            return false
        if (correctModel?.isCorrect() == true) {
            val x = correctModel.getOffsetXSupple()
            val y = correctModel.getOffsetYSupple()
            iprList.forEachIndexed { index, ipr ->
                if (ipr.checkIpr(bitmap, x, y)) {
                    lastP = index
                    return index != 0
                }
            }
        } else {
            correctModel?.let {
                optClickTasks(bitmap, correctModel)
            }
            val x = correctModel?.getOffsetXSupple() ?: 0
            val y = correctModel?.getOffsetYSupple() ?: 0
            iprList.forEachIndexed { index, ipr ->
                if (ipr.checkIpr(bitmap, x, y)) {
                    lastP = index
                    return index != 0
                }
            }
        }
        lastP = iprList.size
        return true
    }


    protected suspend fun optClickTasks(
        bitmap: Bitmap, correctModel: CorrectPositionModel
    ): Boolean = suspendCoroutine {
        correctModel.check(bitmap = bitmap, next = { x, y, end ->
            if (end) {
                if (correctModel.isCorrect()) {
                    val result = checkImgTask(bitmap, x, y, 0, 0)
                    it.resume(result)
                } else {
                    it.resume(false)
                }
                false
            } else {
                val result = checkImgTask(bitmap, x, y, 0, 0)
                if (result) {
                    it.resume(true)
                    true
                } else {
                    false
                }
            }
        })
    }


    fun getNowPercent(): Int {
        val percent = (((iprList.size - lastP) * 100F) / iprList.size).toInt()
//        Timber.d("getNowPercent $percent  needOpenReducer NWQ_ 2023/7/24");
        return percent
    }

    //根据偏差值构造新的找寻任务
    fun copyOffset(tag: String, offsetX: Int, offsetY: Int): HpTaskImpl {
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
            CoordinateArea(
                clickArea!!.x + offsetX,
                clickArea!!.y + offsetY,
                clickArea!!.width,
                clickArea!!.height
            )
        } else {
            null
        }
        return HpTaskImpl(iprList, tag, newCorrectModel).apply {
            this.clickArea = coordinateArea
        }
    }

}