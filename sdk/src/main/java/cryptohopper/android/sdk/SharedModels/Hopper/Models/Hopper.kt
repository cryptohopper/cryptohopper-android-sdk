//
//  Hopper.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

data class Hopper (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("exchange") val exchange: HopperConfigExchange?,
    @SerializedName("base_currency") val baseCurrency: String?,
    @SerializedName("buying_enabled") val buyingEnabled: Int?,
    @SerializedName("selling_enabled") val sellingEnabled: Int?,
    @SerializedName("enabled") val enabled: Int?,
    @SerializedName("error_message") val errorMessage: String?,
    @SerializedName("config_error") val configError: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("start_balance") val startBalance: String?
)


