package com.fg716.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.fg716.R
import com.fg716.domain.VpsServiceInfo
import com.github.kittinunf.fuel.httpGet

class VpsServiceInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //获取数据并赋值
        setData()

        //显示
        setContentView(R.layout.activity_vps_service_info)

    }

    private fun setData() {
        //获取数据
        "https://api.64clouds.com/v1/getServiceInfo?veid=823865&api_key=private_FbtNTo3CXaCIPnvW6EH0U2kN".httpGet()
                .responseObject(VpsServiceInfo.Deserializer()) { request, _, result ->
                    Log.d("zhf", request.toString())
                    result.fold(success = {
                        //解析成功，给tableRow 赋值
                        var vsiVmType = findViewById<TextView>(R.id.vsiVmType)
                        vsiVmType.setText(it.vmType)
                        var vsiHostname = findViewById<TextView>(R.id.vsiHostname)
                        vsiHostname.setText(it.hostname)
                        var vsiNodeIp = findViewById<TextView>(R.id.vsiNodeIp)
                        vsiNodeIp.setText(it.nodeIp)
                        var vsiNodeAlias = findViewById<TextView>(R.id.vsiNodeAlias)
                        vsiNodeAlias.setText(it.nodeAlias)
                        var vsiNodeLocation = findViewById<TextView>(R.id.vsiNodeLocation)
                        vsiNodeLocation.setText(it.nodeLocation)
                        var vsiLocationIpv6Ready = findViewById<TextView>(R.id.vsiLocationIpv6Ready)
                        vsiLocationIpv6Ready.setText(it.locationIpv6Ready.toString())
                        var vsiPlan = findViewById<TextView>(R.id.vsiPlan)
                        vsiPlan.setText(it.plan)
                        var vsiPlanMonthlyData = findViewById<TextView>(R.id.vsiPlanMonthlyData)
                        vsiPlanMonthlyData.setText(it.planMonthlyData.toString())
                        var vsiMonthlyDataMultiplier = findViewById<TextView>(R.id.vsiMonthlyDataMultiplier)
                        vsiMonthlyDataMultiplier.setText(it.monthlyDataMultiplier.toString())
                        var vsiPlanDisk = findViewById<TextView>(R.id.vsiPlanDisk)
                        vsiPlanDisk.setText(it.planDisk.toString())
                        var vsiPlanRam = findViewById<TextView>(R.id.vsiPlanRam)
                        vsiPlanRam.setText(it.planRam.toString())
                        var vsiPlanSwap = findViewById<TextView>(R.id.vsiPlanSwap)
                        vsiPlanSwap.setText(it.planSwap.toString())
                        var vsiPlanMaxIpv6s = findViewById<TextView>(R.id.vsiPlanMaxIpv6s)
                        vsiPlanMaxIpv6s.setText(it.planMaxIpv6s.toString())
                        var vsiOs = findViewById<TextView>(R.id.vsiOs)
                        vsiOs.setText(it.os)
                        var vsiEmail = findViewById<TextView>(R.id.vsiEmail)
                        vsiEmail.setText(it.email)
                        var vsiDataCounter = findViewById<TextView>(R.id.vsiDataCounter)
                        vsiDataCounter.setText(it.dataCounter.toString())
                        var vsiDataNextReset = findViewById<TextView>(R.id.vsiDataNextReset)
                        vsiDataNextReset.setText(it.dataNextReset.toString())

                        var vsiIpAddresses = findViewById<TextView>(R.id.vsiIpAddresses)
                        vsiIpAddresses.setText(it.ipAddresses[0]?:null)

                        var vsiRdnsApiAvailiable = findViewById<TextView>(R.id.vsiRdnsApiAvailable)
                        vsiRdnsApiAvailiable.setText(it.rdnsApiAvailable.toString())
                        var vsiPtr = findViewById<TextView>(R.id.vsiPtr)
                        vsiPtr.setText(it.ptr.toString())
                        var vsiSuspended = findViewById<TextView>(R.id.vsiSuspended)
                        vsiSuspended.setText(it.suspended.toString())

                        Log.d("zhf", it.toString())
                    }, failure = {
                        Log.d("zhf", it.message)
                    })
                }
    }


    companion object {
        fun getStartActivityIntent(context: Context) = Intent(context, VpsServiceInfoActivity::class.java)
    }
}
