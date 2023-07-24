package com.nwq.function.corelib.img.task


import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import timber.log.Timber
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
        val x = correctModel?.getOffsetXSupple() ?: 0
        val y = correctModel?.getOffsetYSupple() ?: 0
        iprList.forEachIndexed { index, ipr ->
            if (!ipr.checkIpr(bitmap, x, y)) {
                lastP = index
                return true
            }
        }
        return false
    }

    fun getNowPercent(): Int {
        val percent = (((iprList.size - lastP) * 100F) / iprList.size).toInt()
        Timber.d("percent getNowPercent HpTaskImpl NWQ_ 2023/7/24");
        return percent
    }


    //这里传递对应血条的判断
    fun copyHpOffset(tag: String, correctModel: CorrectPositionModel?): HpTaskImpl {
        return HpTaskImpl(iprList, tag, correctModel)
    }

}