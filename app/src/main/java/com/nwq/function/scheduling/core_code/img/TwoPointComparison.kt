package com.nwq.function.scheduling.core_code.img

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

/**
create by: 86136
create time: 2023/3/2 10:49
Function description:
这个是能用于发现边框等
 */

interface TwoPointComparison {

    fun optInt(
        point1Color: Int,
        point2Color: Int,
    ): Boolean {
        return verificationRule(
            point1Color.red,
            point1Color.green,
            point1Color.blue,
            point2Color.red,
            point2Color.green,
            point2Color.blue
        )
    }

    fun verificationRule(
        red: Int, green: Int, blue: Int, red2: Int, green2: Int, blue2: Int
    ): Boolean
}