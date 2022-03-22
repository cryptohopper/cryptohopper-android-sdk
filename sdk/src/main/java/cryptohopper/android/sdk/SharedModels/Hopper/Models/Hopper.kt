//
//  Hopper.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Enums.HopperBotType

data class Hopper (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("base_currency") val baseCurrency: String?,
    @SerializedName("buying_enabled") val buyingEnabled: Int?,
    @SerializedName("selling_enabled") val sellingEnabled: Int?,
    @SerializedName("enabled") val enabled: Int?,
    @SerializedName("error_message") val errorMessage: String?,
    @SerializedName("config_error") val configError: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("start_balance") val startBalance: String?,
    @SerializedName("subscription_id") val subscriptionId : String?,
    @SerializedName("start_time") val statTime : String?,
    @SerializedName("end_time") val endTime : String?,
    @SerializedName("subscription_status") val subscriptionStatus : String?,
    @SerializedName("auto_renewal") val autoRenewal : String?,
    @SerializedName("subscription") val subscription : String?,
    @SerializedName("plan_name") val planName : String?,
    @SerializedName("plan_description") val planDescription : String?,
    @SerializedName("product_id") val productId : String?,
    @SerializedName("last_loaded_config") val lastLoadedConfig : Boolean?,
    @SerializedName("image") val image : String?,
    @SerializedName("set_default") val setDefault : String?,
    @SerializedName("last_signal") val lastSignal : String?,
    @SerializedName("last_signal_encoding") val lastSignalEncoding : String?,
    @SerializedName("total_cur") val totalCurrency : String?,
    @SerializedName("bot_type") val botType : HopperBotType?,
    @SerializedName("user_id") val userId : String?,
    @SerializedName("allowedCoins") val allowedCoins : List<String>?,
    @SerializedName("paper_trading") val paperTrading : Int?,
    @SerializedName("open_positions_count") val openPositionCount : String?
)


