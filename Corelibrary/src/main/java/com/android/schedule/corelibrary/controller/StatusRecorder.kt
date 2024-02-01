package com.android.schedule.corelibrary.controller

import com.android.schedule.corelibrary.utils.L

class StatusRecorder(
    val tag: String,
    val trustThresholds: Int,
    val errorThreshold: Int,
    val isOpen: suspend () -> Boolean
) {
    var lastTrueCount = 0
    var lastfalseCount = 0

    var lastStatus = false

     fun clearUp() {
        lastTrueCount = 0
        lastfalseCount = 0
    }


    fun isOpenTrustThresholds(): Boolean {
        val result = if (lastStatus) {
            return lastTrueCount >= trustThresholds
        } else {
            false
        }
        L.d("$tag isOpenTrustThresholds result:$result")
        return result
    }

    fun isCloseTrustThresholds(): Boolean {
        val result = if (!lastStatus) {
            return lastfalseCount >= trustThresholds
        } else {
            false
        }
        L.d("$tag isCloseTrustThresholds result:$result")
        return result
    }

    fun isOpenErrorThresholds(): Boolean {
        val result = if (lastStatus) {
            return lastTrueCount >= errorThreshold
        } else {
            false
        }
        L.d("$tag isOpenErrorThresholds result:$result")
        return result
    }

    fun isCloseErrorThresholds(): Boolean {
        val result = if (!lastStatus) {
            return lastfalseCount >= errorThreshold
        } else {
            false
        }
        L.d("$tag isCloseErrorThresholds result:$result")
        return result
    }


    suspend fun updateInfo() {
        if (isOpen.invoke()) {
            // L.d("$tag true")
            if (lastStatus) {
                lastTrueCount++
            } else {
                lastStatus = true
                lastTrueCount = 1
            }
        } else {
            //  L.d("$tag false")
            if (lastStatus) {
                lastStatus = false
                lastfalseCount = 1
            } else {
                lastfalseCount++
            }
        }
    }
}