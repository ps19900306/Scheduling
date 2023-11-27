package com.android.schedule.corelibrary.controller

import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.img.img_rule.BasicImgTask

data class TaskOperation(
    val pTask: BasicImgTask? = null,//前置图片
    val clickArea: ClickArea? = null,//点击区域
    val eTask: BasicImgTask?=null,//结束图片，出现这样的情况结束
    val endClickArea: ClickArea? = null,//结束的店家
)