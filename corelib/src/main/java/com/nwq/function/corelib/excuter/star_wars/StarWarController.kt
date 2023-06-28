package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.excuter.BaseController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/6/28 14:52
Function description:
 */

abstract class StarWarController(acService: AccessibilityService) : BaseController(acService) {


    override fun startWork() {
        GlobalScope.launch(Dispatchers.Default) {
            intoGame()
        }
    }

    private suspend fun intoGame(): Boolean {

        return true
    }
}