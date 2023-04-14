package com.nwq.function.scheduling

import android.app.Application
import com.nwq.function.scheduling.utils.ContextUtil
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
        ContextUtil.context = this
        Timber.plant(Timber.DebugTree())
//
//        if (!FileUtils.orcExists()) {
//            Timber.d("拷贝文件 onCreate App NWQ_ 2023/3/29");
//            FileUtils.copyOrcFile(assets.open(FileUtils.languageAllName))
//        } else {
//            Timber.d("文件已经存在 onCreate App NWQ_ 2023/3/29");
//        }
    }
}