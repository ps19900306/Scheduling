package com.nwq.function.scheduling.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.net.toUri
import com.nwq.function.scheduling.R
import com.nwq.function.scheduling.databinding.ActivityMainBinding
import com.nwq.function.scheduling.utils.singleClick
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).singleClick {
            val intent = Intent("schedule.cmd")
            intent.setDataAndType("schedule.cmd".toUri(), "cmd/int")
            sendBroadcast(intent);
        }
    }
}