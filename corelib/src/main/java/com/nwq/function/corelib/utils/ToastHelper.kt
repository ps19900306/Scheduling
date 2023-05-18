package com.nwq.function.corelib.utils

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.StringRes

/**
create by: 86136
create time: 2023/4/14 19:48
Function description:
 */

object ToastHelper {
    const val NO_RESOURCE_ID = 0
    private const val DEFAULT_TOAST_DURATION = 0
    private var sToast: Toast? = null
    private val sHandler = Handler(Looper.getMainLooper())
    private var isJumpWhenMore = false

    private fun ToastHelper() {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    fun init(isJumpWhenMore: Boolean) {
        ToastHelper.isJumpWhenMore = isJumpWhenMore
    }

    fun showShortToastSafe(text: CharSequence?) {
        sHandler.post { showToast(text, Toast.LENGTH_SHORT) }
    }

    fun showShortToastSafe(@StringRes resId: Int) {
        sHandler.post { showToast(resId, Toast.LENGTH_SHORT) }
    }

    fun showShortToastSafe(@StringRes resId: Int, vararg args: Any?) {
        sHandler.post { showToast(resId, Toast.LENGTH_SHORT, *args) }
    }

    fun showShortToastSafe(format: String?, vararg args: Any?) {
        sHandler.post { showToast(format, Toast.LENGTH_SHORT, *args) }
    }

    fun showLongToastSafe(text: CharSequence?) {
        sHandler.post { showToast(text, Toast.LENGTH_LONG) }
    }

    fun showLongToastSafe(@StringRes resId: Int) {
        sHandler.post { showToast(resId, Toast.LENGTH_LONG) }
    }

    fun showLongToastSafe(@StringRes resId: Int, vararg args: Any?) {
        sHandler.post { showToast(resId, Toast.LENGTH_LONG, *args) }
    }

    fun showLongToastSafe(format: String?, vararg args: Any?) {
        sHandler.post { showToast(format, Toast.LENGTH_LONG, *args) }
    }

    fun showShortToast(text: CharSequence?) {
        showToast(text, Toast.LENGTH_SHORT)
    }

    fun showShortToast(@StringRes resId: Int) {
        showToast(resId, Toast.LENGTH_SHORT)
    }

    fun showShortToast(@StringRes resId: Int, vararg args: Any?) {
        showToast(resId, Toast.LENGTH_SHORT, *args)
    }

    fun showShortToast(format: String?, vararg args: Any?) {
        showToast(format, Toast.LENGTH_SHORT, *args)
    }

    fun showLongToast(text: CharSequence?) {
        showToast(text, Toast.LENGTH_LONG)
    }

    fun showLongToast(@StringRes resId: Int) {
        showToast(resId, Toast.LENGTH_LONG)
    }

    fun showLongToast(@StringRes resId: Int, vararg args: Any?) {
        showToast(resId, Toast.LENGTH_LONG, *args)
    }

    fun showLongToast(format: String?, vararg args: Any?) {
        showToast(format, Toast.LENGTH_LONG, *args)
    }

    fun showToast(@StringRes resId: Int, duration: Int) {
        showToast(ContextUtil.context.getResources().getText(resId).toString(), duration)
    }

    fun showToast(@StringRes resId: Int) {
        showToast(ContextUtil.context.getResources().getText(resId).toString(), Toast.LENGTH_SHORT)
    }

    fun showToast(@StringRes resId: Int, duration: Int, vararg args: Any?) {
        showToast(
            java.lang.String.format(
                ContextUtil.context.getResources().getString(resId),
                args
            ), duration
        )
    }

    fun showToast(format: String?, duration: Int, vararg args: Any?) {
        showToast(String.format(format!!, *args), duration)
    }

    fun showToast(text: CharSequence?) {
        showToast(text, Toast.LENGTH_SHORT)
    }

    fun showToast(text: CharSequence?, duration: Int) {
        if (isJumpWhenMore) {
            cancelToast()
        }
        if (sToast != null) {
            sToast!!.cancel()
        }
        sToast = Toast.makeText(ContextUtil.context, "", duration)
        sToast?.setText(text)
        sToast?.show()
    }

    fun cancelToast() {
        if (sToast != null) {
            sToast!!.cancel()
            sToast = null
        }
    }
}