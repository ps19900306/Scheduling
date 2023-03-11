package com.nwq.function.scheduling.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.scheduling.databinding.ActivityGetColorBinding
import com.nwq.function.scheduling.databinding.ActivitySetRoleInfo2Binding
import com.nwq.function.scheduling.utils.BroadcastUtils
import com.nwq.function.scheduling.utils.singleClick

class SetRoleInfoActivity2 : AppCompatActivity() {

    lateinit var bind: ActivitySetRoleInfo2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySetRoleInfo2Binding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        initView()
    }

    fun initView(){

    }

}