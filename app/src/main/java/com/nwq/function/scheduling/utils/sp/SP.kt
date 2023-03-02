package com.nwq.function.scheduling.utils.sp


import android.content.Context
import android.content.SharedPreferences
import com.tencent.mmkv.MMKV
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class SP<T>(private val key: String, private val default: T) : ReadWriteProperty<Any?, T> {
    companion object {
        lateinit var app: Context
        lateinit var name: String
        lateinit var preferences: MMKV

        fun init(app: Context, name: String) {
            Companion.app = app
            Companion.name = name
            val rootDir = MMKV.initialize(app)
            preferences = MMKV.mmkvWithID(name)
            // 迁移旧数据
            if (preferences.count() == 0L) {
                val oldMan: SharedPreferences = preference
                preferences.importFromSharedPreferences(oldMan)
                oldMan.edit().clear().apply()
            }
        }

        fun <T> getValue(key: String, default: T): T {
            return with(preferences) {
                val value = when (default) {
                    is String -> getString(key, default)
                    is Int -> getInt(key, default)
                    is Long -> getLong(key, default)
                    is Float -> getFloat(key, default)
                    is Boolean -> getBoolean(key, default)
                    else -> throw IllegalArgumentException("This type of data can not be get! ")
                }
                value as T
            }
        }

        private val preference: SharedPreferences by lazy {
            app.getSharedPreferences(
                name,
                Context.MODE_PRIVATE
            )
        }

        fun clear() {
            preference.edit().clear().apply()
            preferences.edit().clear().apply()
        }
    }

    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    override fun getValue(thisRef: Any?, property: KProperty<*>): T =
        with(preferences) {
            val value = when (default) {
                is String -> getString(key, default)
                is Int -> getInt(key, default)
                is Long -> getLong(key, default)
                is Float -> getFloat(key, default)
                is Boolean -> getBoolean(key, default)
                else -> throw IllegalArgumentException("This type of data can not be get! ")
            }
            value as T
        }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        with(preferences.edit()) {
            when (default) {
                is String -> putString(key, value as String)
                is Int -> putInt(key, value as Int)
                is Long -> putLong(key, value as Long)
                is Float -> putFloat(key, value as Float)
                is Boolean -> putBoolean(key, value as Boolean)
                else -> throw IllegalArgumentException("This type of data can not be saved! ")
            }.apply()
        }
}