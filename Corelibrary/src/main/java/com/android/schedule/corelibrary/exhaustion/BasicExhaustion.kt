package com.android.schedule.corelibrary.exhaustion

/**
create by: 86136
create time: 2023/9/1 9:25
Function description:
 */

abstract class BasicExhaustion {

    open fun updateStatus() {

    }

    open fun whetherToRest(){

    }

    fun getOptStatusType(): Int {
        return OptStatusType.PRECISION
    }
}