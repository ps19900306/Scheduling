package com.android.system.talker.enums

import androidx.annotation.IntDef
import androidx.lifecycle.viewmodel.CreationExtras

@IntDef(
    ShipType.UNKNOWN,
    ShipType.NULL_SHIP,
    ShipType.MINING_SHIP,
    ShipType.VEGETABLE_SHIP,
    ShipType.TASK_SHIP,
    ShipType.ABNORMAL_SHIP,
)
annotation class ShipType {

    companion object {
        const val UNKNOWN = -1
        const val NULL_SHIP = 0
        const val MINING_SHIP = 1
        const val VEGETABLE_SHIP = 2
        const val TASK_SHIP = 3
        const val ABNORMAL_SHIP = 4
    }
}


