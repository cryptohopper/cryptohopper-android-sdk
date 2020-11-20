//
//  HopperOrder.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperOrder (
    @SerializedName("id") val id: String?,
    @SerializedName("pair") val pair: String?,
    @SerializedName("order_type") val orderType: String?,
    @SerializedName("order_id") val orderId: String?,
    @SerializedName("order_trigger") val orderTrigger: String?,
    @SerializedName("amount") val amount: String?,
    @SerializedName("rate") val rate: String?,
    @SerializedName("ta_values") val taValues: String?,
    @SerializedName("percentage_profit") val percentageProfit: Double?,
    @SerializedName("hold") val hold: Int?,
    @SerializedName("sold") val sold: Int?,
    @SerializedName("open_time") val openTime: String?,
    @SerializedName("close_time") val closeTime: String?,
    @SerializedName("bundled") val bundled: Int?,
    @SerializedName("market_order") val marketOrder: Int?,
    @SerializedName("cost") val cost: Double?,
    @SerializedName("date") val date: String?
)
