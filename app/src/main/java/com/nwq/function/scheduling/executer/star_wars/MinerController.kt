package com.nwq.function.scheduling.executer.star_wars

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController

/**
create by: 86136
create time: 2023/3/16 18:00
Function description:
 */

class MinerController(p: AccessibilityHelper, c: () -> Boolean) : TravelController(p, c) {



    override suspend fun generalControlMethod() {

    }

}