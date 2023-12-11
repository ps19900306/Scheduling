package com.android.system.talker.ui

import android.os.Bundle

class UserIdArgs(var userId: Long = -1L) {


    constructor(bundle: Bundle) : this(userId = bundle.getLong("userId", -1))

    fun toBundle(): Bundle {
        return Bundle().apply {
            putLong("userId", userId)
        }
    }
}