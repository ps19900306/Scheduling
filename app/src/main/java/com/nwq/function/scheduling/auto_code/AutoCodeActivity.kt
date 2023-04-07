package com.nwq.function.scheduling.auto_code

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.scheduling.databinding.ActivityAutoCodeBinding

class AutoCodeActivity : AppCompatActivity() {

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAutoCodeBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
    }
}