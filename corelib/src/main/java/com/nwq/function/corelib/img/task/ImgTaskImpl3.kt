package com.nwq.function.corelib.img.task


import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.IPR

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
这个用于判断进度条血条的
 */
class ImgTaskImpl3(
    iprList: List<IPR>, tag: String, correctModel: CorrectPositionModel? = null
) : ImgTask(iprList, tag, correctModel) {

    override suspend fun verificationRule(bitmap: Bitmap): Boolean {
        TODO("Not yet implemented")
    }

}