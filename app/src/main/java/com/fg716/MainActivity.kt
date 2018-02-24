package com.fg716

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vpsInfoSetup = findViewById<Button>(R.id.vps_info_setup)
        vpsInfoSetup.setOnClickListener { vpsInfoSetupL() }
    }

    private fun vpsInfoSetupL() {
        startActivity(VpsSetupActivity.getStartActivityIntent(this))
        finish()
    }

    companion object {
        fun getStartActivityIntent(context: Context) = Intent(context,MainActivity::class.java)
    }

}
