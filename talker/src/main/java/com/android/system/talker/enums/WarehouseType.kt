package com.android.system.talker.enums

import androidx.annotation.IntDef

@IntDef(
    WarehouseType.UNKNOWN,
    WarehouseType.STATION_GOODS,
    WarehouseType.STATION_SHIPS,
    WarehouseType.SHIP_CABIN,
    WarehouseType.SHIP_SPECIAL,
)
annotation class WarehouseType {

    companion object {
        const val UNKNOWN = 0
        const val STATION_GOODS =1
        const val STATION_SHIPS = 2
        const val SHIP_CABIN = 3
        const val SHIP_SPECIAL = 4

    }
}