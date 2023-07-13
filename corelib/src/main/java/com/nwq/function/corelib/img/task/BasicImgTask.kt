package com.nwq.function.corelib.img.task

import android.graphics.Bitmap
import com.nwq.function.corelib.baseIf.BasicTask

/**
create by: 86136
create time: 2023/7/4 10:59
Function description:
 */

abstract class BasicImgTask(): BasicTask {
    //验证是否符合规则
    abstract suspend fun verificationRule(bitmap: Bitmap?): Boolean
}