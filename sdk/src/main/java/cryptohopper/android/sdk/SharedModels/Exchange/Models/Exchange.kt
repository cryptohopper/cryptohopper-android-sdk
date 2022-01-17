//
//  Exchange.swift
//  Cryptohopper-Android-SDK
//  Created by Kaan Baris Bayrak
//

import com.google.gson.annotations.SerializedName

data class Exchange (
    @SerializedName("exchange_key") val exchangeKey: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("website_link") val websiteLink: String?,
    @SerializedName("signup_link") val signupLink: String?,
    @SerializedName("tutorial_link") val tutorialLink: String?,
    @SerializedName("api_link") val apiLink: String?,
    @SerializedName("extra_links") val extraLinks: List<Map<String,String>>?,
    @SerializedName("base_currencies") val baseCurrencies: String?,
    @SerializedName("default_base_cur") val defaultBaseCurrency: String?,
    @SerializedName("api_config_fields") val apiConfigFields: List<String>?,
    @SerializedName("exchange_status") val exchangeStatus: String?,
    @SerializedName("uptime_1h") val uptimeOneHour: String?,
    @SerializedName("uptime_1w") val uptimeOneWeek: String?,
    @SerializedName("uptime_1m") val uptimeOneMonth: String?,
    @SerializedName("premium_partner") val preiumPartner: String?,
    @SerializedName("maintenance") val maintence: Int?,
    @SerializedName("maintenance_message") val maintanceMessage: String?,
    @SerializedName("optional_config_fields") val optionalConfigFields: List<String>?
)
