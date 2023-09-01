package com.android.schedule.corelibrary.exhaustion

/**
create by: 86136
create time: 2023/9/1 9:25
Function description:
这个是基础类也是
 */
open class BasicExhaustion {

    open fun updateStatus() {

    }

    open fun whetherToRest(): Long {
        return 0L
    }

    open fun getOptStatusType(): Int {
        return OptStatusType.PRECISION
    }

    open fun getClickDuration(): Long {
        return ((Math.random() * 2 + 1) * 40).toLong()
    }

    open fun getClickInterval(): Long {
        return ((Math.random() * 2 + 1) * 400).toLong()
    }

    open fun getRestTime(): Long {
        return 0L
    }

    open fun onRestComplete() {}
}