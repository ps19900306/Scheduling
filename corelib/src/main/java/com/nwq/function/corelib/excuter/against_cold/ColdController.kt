package com.nwq.function.corelib.excuter.against_cold

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.excuter.star_wars.StarWarController

/**
create by: 86136
create time: 2023/6/30 14:36
Function description:
 */

class ColdController(acService: AccessibilityService, endLister: EndLister?=null) : StarWarController(acService,endLister) {
    override suspend fun generalControlMethod() {
        TODO("Not yet implemented")
    }

}