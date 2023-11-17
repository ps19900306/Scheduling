package com.android.system.talker.im.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.system.talker.R
import com.android.system.talker.databinding.ActivityImmanagerBinding
import com.google.android.material.snackbar.Snackbar
import com.tencent.imsdk.v2.V2TIMManager


class IMmanagerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityImmanagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImmanagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_immanager)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


        val loginUser = V2TIMManager.getInstance().loginUser

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "$loginUser", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_immanager)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}