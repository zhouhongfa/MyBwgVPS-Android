package com.fg716

import android.content.Context
import android.content.Intent
import android.content.RestrictionsManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class VpsSetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vpssetup)

        val myRestrictionsMgr = getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
//
        var appRestrictions = myRestrictionsMgr.applicationRestrictions
//
//        var parcelables = appRestrictions.getParcelableArray("vps_configuration_list")

        Log.d("TAG", "test")
//        Log.d("TAG", parcelables.size.toString())


    }

    companion object {

        fun getStartActivityIntent(context: Context) = Intent(context, VpsSetupActivity::class.java)
    }

    override fun onBackPressed() {
        startActivity(MainActivity.getStartActivityIntent(this))
        finish()
    }
}
