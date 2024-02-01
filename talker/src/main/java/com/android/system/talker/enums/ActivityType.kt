package com.android.system.talker.enums

import androidx.annotation.IntDef

@IntDef(
    ActivityType.LOGIN_GIFT,
)
annotation class ActivityType {

    companion object {
        const val LOGIN_GIFT =1 //这个是每日登录的礼物
        const val CHENG_NIAN_LI =2//成年里
    }
}