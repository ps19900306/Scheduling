package com.nwq.function.scheduling.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.scheduling.databinding.ActivitySettingModelBinding

class SettingModelActivity : AppCompatActivity() {

    lateinit var bind: ActivitySettingModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySettingModelBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
    }
    

}