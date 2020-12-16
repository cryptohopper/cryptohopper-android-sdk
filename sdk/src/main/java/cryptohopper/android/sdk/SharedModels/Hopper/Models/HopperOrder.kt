//
//  HopperOrder.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.TAValue

data class HopperOrder (
        @SerializedName("id") val id: String?,
        @SerializedName("pair") val pair: String?,
        @SerializedName("order_type") val orderType: String?,
        @SerializedName("order_id") val orderId: String?,
        @SerializedName("order_trigger") val orderTrigger: String?,
        @SerializedName("amount") val amount: String?,
        @SerializedName("rate") val rate: String?,
        @SerializedName("ta_values") val taValues: TAValue?,
        @SerializedName("percentage_profit") val percentageProfit: String?,
        @SerializedName("hold") val hold: String?,
        @SerializedName("sold") val sold: String?,
        @SerializedName("open_time") val openTime: String?,
        @SerializedName("close_time") val closeTime: String?,
        @SerializedName("bundled") val bundled: String?,
        @SerializedName("market_order") val marketOrder: Int?,
        @SerializedName("cost") val cost: String?,
        @SerializedName("date") val date: String?
)
