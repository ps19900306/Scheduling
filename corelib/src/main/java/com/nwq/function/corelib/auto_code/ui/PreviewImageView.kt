package com.nwq.function.corelib.auto_code.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
create by: 86136
create time: 2023/5/22 14:51
Function description:
 */

class PreviewImageView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor (context: Context) : this(context, null)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}