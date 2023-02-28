package com.nwq.function.scheduling


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.net.toUri
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {

            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            sendBroadcast(intent);
            lifecycle
        }
    }
}