package com.fg716

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.fg716.activity.VpsServiceInfoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appSettings = findViewById<Button>(R.id.app_settings)
        appSettings.setOnClickListener { appSettings() }

        val vpsInfo = findViewById<Button>(R.id.vps_info)
        vpsInfo.setOnClickListener { vpsInfo() }
    }


    //设置按钮事件
    private fun appSettings() {
        startActivity(SettingsActivity.getStartActivityIntent(this))
//        finish()
    }

    //vps info 按钮点击事件
    private fun vpsInfo() {


//an extension over string (support GET, PUT, POST, DELETE with httpGet(), httpPut(), httpPost(), httpDelete())

//        "https://api.64clouds.com/v1/getServiceInfo?veid=823865&api_key=private_FbtNTo3CXaCIPnvW6EH0U2kN".httpGet().responseJson { request, response, result ->
//            when(result){
//                is Result.Success->{
//                    Log.d("zhf",result.getAs())
//                }
//            }
//
//        }.


//        "https://api.64clouds.com/v1/getServiceInfo?veid=823865&api_key=private_FbtNTo3CXaCIPnvW6EH0U2kN".httpGet().responseString { request, response, result ->
//            //do something with response
//            when (result) {
//                is Result.Failure -> {
//                    Log.d("zhf","fail")
//                }
//                is Result.Success -> {
//                    Log.d("zhf",result.getAs())
//                }
//            }
//        }


        startActivity(VpsServiceInfoActivity.getStartActivityIntent(this))
    }

    companion object {
        fun getStartActivityIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

}
