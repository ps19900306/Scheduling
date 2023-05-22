package com.nwq.function.corelib.img.task


import android.graphics.Bitmap
import com.nwq.function.corelib.img.pcheck.IPR

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
固定点找图，成功后会记录偏差值，以优化流程
 */
class ImgTaskImpl1(
    iprList: List<IPR>,
    tag: String,
    correctModel: CorrectModel? = null
) : ImgTask(iprList, tag,correctModel) {
    override suspend fun verificationRule(bitmap: Bitmap): Boolean {
        TODO("Not yet implemented")
    }

}