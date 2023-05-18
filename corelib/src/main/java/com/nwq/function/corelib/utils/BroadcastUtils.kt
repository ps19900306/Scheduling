package com.nwq.function.corelib.utils

import android.content.Intent
import androidx.core.net.toUri

/**
create by: 86136
create time: 2023/3/10 16:05
Function description:
 */

object BroadcastUtils {

    const val KEY_CMD = "key_cmd"
    const val KEY_X = "key_x"
    const val KEY_Y = "key_y"
    const val KEY_WITH = "key_with"
    const val KEY_HEIGHT = "key_height"

    const val CMD_COLOR = 1

    fun sendTaKeColor(x: Int?, y: Int?, with: Int?, height: Int?): Intent {
        val intent = Intent("schedule.cmd")
        intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
        intent.putExtra(KEY_CMD, CMD_COLOR)
        intent.putExtra(KEY_X, x ?: 0)
        intent.putExtra(KEY_Y, y ?: 0)
        intent.putExtra(KEY_WITH, with ?: 0)
        intent.putExtra(KEY_HEIGHT, height ?: 0)
        return intent
    }


}