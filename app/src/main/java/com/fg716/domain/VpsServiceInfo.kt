package com.fg716.domain

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.Reader

//getServiceInfo接口返回值对象

data class VpsServiceInfo(
        @SerializedName("vm_type") val vmType: String,
        @SerializedName("hostname") val hostname: String,
        @SerializedName("node_ip") val nodeIp: String,
        @SerializedName("node_alias") val nodeAlias: String,
        @SerializedName("node_location") val nodeLocation: String,
        @SerializedName("location_ipv6_ready") val locationIpv6Ready: Boolean,
        @SerializedName("plan") val plan: String,
        @SerializedName("plan_disk") val planDisk: Long,
        @SerializedName("plan_ram") val planRam: Long,
        @SerializedName("plan_swap") val planSwap: Long,
        @SerializedName("os") val os: String,
        @SerializedName("email") val email: String,
        @SerializedName("plan_monthly_data") val planMonthlyData: Long,
        @SerializedName("data_counter") val dataCounter: Long,
        @SerializedName("monthly_data_multiplier") val monthlyDataMultiplier: String,
        @SerializedName("data_next_reset") val dataNextReset: Long,
        @SerializedName("ip_addresses") val ipAddresses: Array<String>,
        @SerializedName("plan_max_ipv6s") val planMaxIpv6s: Long,
        @SerializedName("rdns_api_available") val rdnsApiAvailable: Boolean,
        @SerializedName("ptr") val ptr: JsonObject,
        @SerializedName("suspended") val suspended: Boolean
) {
    class Deserializer : ResponseDeserializable<VpsServiceInfo> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, VpsServiceInfo::class.java)
    }

    class ListDeserializer : ResponseDeserializable<List<VpsServiceInfo>> {
        override fun deserialize(reader: Reader): List<VpsServiceInfo> {
            val type = object : TypeToken<List<VpsServiceInfo>>() {}.type
            return Gson().fromJson(reader, type)
        }
    }
}

