package com.android.system.talker.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.talker.databinding.ActivityMainBinding
import com.android.system.talker.im.ui.IMmanagerActivity
import com.system.android.myimdemoapplication.LoginUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        LoginUtil.init(this)
        binding.button.singleClick {
            LoginUtil.loginIm(binding.userName.text.toString()) {
                val intent = Intent(this@MainActivity, IMmanagerActivity::class.java)
                this@MainActivity.startActivity(intent)
            }
        }
    }


}