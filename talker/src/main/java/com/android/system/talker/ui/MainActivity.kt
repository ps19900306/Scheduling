package com.android.system.talker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.R
import com.android.system.talker.databinding.ActivityImmanagerBinding
import com.android.system.talker.databinding.ActivityMainBinding
import com.android.system.talker.im.ui.IMmanagerActivity
import com.system.android.myimdemoapplication.IMTest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        IMTest.init(this)
        binding.button.singleClick {
            IMTest.loginIm(binding.userName.text.toString()) {
                val intent = Intent(this@MainActivity, IMmanagerActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
        }
    }


}