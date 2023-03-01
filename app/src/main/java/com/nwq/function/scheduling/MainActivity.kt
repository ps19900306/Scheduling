package com.nwq.function.scheduling


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.net.toUri
import com.nwq.function.scheduling.utils.log.L
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent =Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            sendBroadcast(intent);
            L.i("sendBroadcast", "onCreate", "MainActivity", "nwq", "2023/3/1");
        }
    }
}