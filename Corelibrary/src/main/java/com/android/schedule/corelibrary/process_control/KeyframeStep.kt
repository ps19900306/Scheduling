package com.android.schedule.corelibrary.process_control

//number 这个是进入的序列号
//nextOpt 是如果进入后续操作
class KeyframeStep(
    number: Int,
    val foundCheck: suspend () -> Boolean,
    val nextOpt: suspend () -> Unit,
    val isStart: Boolean = false
) {

}