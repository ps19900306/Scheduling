package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap

/**
create by: 86136
create time: 2023/7/4 10:59
Function description:
 */

abstract class BasicImgTask {
    //验证是否符合规则
    abstract suspend fun verificationRule(bitmap: Bitmap?): Boolean
}