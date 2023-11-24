package com.android.system.talker.enums

import androidx.annotation.IntDef

@IntDef(
    ShipType.UNKNOWN,
    ShipType.MINING_SHIP,
    ShipType.VEGETABLE_SHIP,
    ShipType.TASK_SHIP,
    ShipType.ABNORMAL_SHIP,
)
annotation class ShipType {

    companion object {
        const val UNKNOWN = 0
        const val MINING_SHIP = 1
        const val VEGETABLE_SHIP = 2
        const val TASK_SHIP = 3
        const val ABNORMAL_SHIP = 4
    }
}


