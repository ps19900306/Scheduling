package com.nwq.function.scheduling

import android.app.Application
import com.nwq.function.scheduling.utils.sp.SP
import timber.log.Timber

/**
create by: 86136
create time: 2023/3/3 11:20
Function description:
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SP.init(this, "nwq_schedule")
        //Timber.plant(Timber.DebugTree())
    }
}