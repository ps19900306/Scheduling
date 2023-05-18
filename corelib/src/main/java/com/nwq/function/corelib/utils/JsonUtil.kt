package com.nwq.function.corelib.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
create by: 86136
create time: 2020/10/21 16:51
Function description:
 */

object JsonUtil {

    val gson = Gson()

    fun objectToString(obj: Any): String {
        return gson.toJson(obj)
    }

    inline fun <reified T> anyToJsonObject(any: Any?): T? {
        if (any == null)
            return null
        return try {
            val dataStr =
                if (any is String)
                    any
                else
                    gson.toJson(any)
            val token = object : TypeToken<T>() {}.type
            gson.fromJson<T>(dataStr, token)
        } catch (e: Exception) {
            null
        }
    }
}