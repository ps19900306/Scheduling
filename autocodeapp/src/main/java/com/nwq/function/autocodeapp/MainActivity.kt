package com.nwq.function.autocodeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var starX = 1F
    private var starY = 1F
    private var midleX = 1F
    private var midleY = 1F

    private var startTime = 0L
    private var midleTime = 0L


    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            starX = ev.x
            starY = ev.y
            midleX = ev.x
            midleY = ev.y
            startTime = System.currentTimeMillis()
            Log.i(
                "NWQ_InterVel",
                "InterVel:${startTime - midleTime}"
            )
            midleTime = startTime
        } else if (ev.action == MotionEvent.ACTION_MOVE) {

            val time = System.currentTimeMillis()
            Log.i(
                "NWQ_Move",
                "mX:${ev.x - midleX} mY:${ev.y - midleY},mTime:${time - midleTime}"
                //allX:${ev.x - starX} allY:${ev.y - starY},allTime:${time - startTime}
            )
            midleX = ev.x
            midleY = ev.y
            midleTime = System.currentTimeMillis()
        } else if (ev.action == MotionEvent.ACTION_UP) {
            val time = System.currentTimeMillis()
            Log.i(
                "NWQ_UP",
                "allX:${ev.x - starX} allY:${ev.y - starY},allTime:${time - startTime} mX:${ev.x - midleX} mY:${ev.y - midleY},mTime:${time - midleTime}"
            )
            midleTime = System.currentTimeMillis()
        }
        return super.onTouchEvent(ev)
    }
}