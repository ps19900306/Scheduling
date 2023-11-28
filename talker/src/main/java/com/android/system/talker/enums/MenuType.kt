package com.android.system.talker.enums

import androidx.annotation.IntDef

@IntDef(
    MenuType.UNSET,
    MenuType.WAREHOUSE,
    MenuType.TASK,
    MenuType.PLANETARY_MINE,
    MenuType.AGREEMENT,
    MenuType.GAME_ACTIVITY,
)
annotation class MenuType {

    companion object {
        const val UNSET = -1//未设置
        const val WAREHOUSE = 0//仓库
        const val TASK = 1 //际遇任务
        const val PLANETARY_MINE = 2 //  行星矿
        const val AGREEMENT = 3 //合作协议
        const val GAME_ACTIVITY = 4 //游戏活动
    }
}