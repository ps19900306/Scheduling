package com.nwq.function.scheduling.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.scheduling.R
import com.nwq.function.scheduling.databinding.ActivityGetColorBinding
import com.nwq.function.scheduling.utils.BroadcastUtils
import com.nwq.function.scheduling.utils.singleClick
import java.util.zip.Inflater

class GetColorActivity : AppCompatActivity() {

    lateinit var bind: ActivityGetColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityGetColorBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        bind.okBtn.singleClick {
            val x = bind.xEdit.text.toString().toIntOrNull()
            val y = bind.yEdit.text.toString().toIntOrNull()
            val width = bind.widthEdit.text.toString().toIntOrNull()
            val height = bind.heightEdit.text.toString().toIntOrNull()
            BroadcastUtils.sendTaKeColor(x,y,width,height)
        }
    }


}