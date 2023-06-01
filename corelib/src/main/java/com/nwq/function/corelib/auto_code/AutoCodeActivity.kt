package com.nwq.function.corelib.auto_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.nwq.function.corelib.R
import timber.log.Timber

class AutoCodeActivity : AppCompatActivity() {

    companion object {
        val normal_Mode = 1   //普通模式

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_code)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val params = window.attributes
        params.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        window.attributes = params
    }






    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(ev)
    }
}