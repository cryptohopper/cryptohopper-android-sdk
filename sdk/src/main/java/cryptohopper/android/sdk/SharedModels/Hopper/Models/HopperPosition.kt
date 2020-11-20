//
//  HopperPosition.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import java.util.*
import com.google.gson.annotations.SerializedName

data class HopperPosition (
    @SerializedName("id") val id: String?,
    @SerializedName("pair") val pair: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("amount") val amount: String?,
    @SerializedName("rate") val rate: String?,
    @SerializedName("buy_id") val buyId: String?,
    @SerializedName("order_id") val orderId: String?,
    @SerializedName("sell_id") val sellId: String?,
    @SerializedName("buy_trigger") val buyTrigger: String?,
    @SerializedName("sell_trigger") val sellTrigger: String?,
    @SerializedName("ta_values") val taValues: String?,
    @SerializedName("percentage_profit") val percentageProfit: String?,
    @SerializedName("stop_loss") val stopLoss: String?,
    @SerializedName("stop_loss_percentage") val stopLossPercentage: String?,
    @SerializedName("sell_rate") val sellRate: String?,
    @SerializedName("trailing_percentage") val trailingPercentage: String?,
    @SerializedName("trailing_arm") val trailingArm: String?,
    @SerializedName("trailing_arm_percentage") val trailingArmPercentage: String?,
    @SerializedName("buy_time") val buyTime: String?,
    @SerializedName("sell_time") val sellTime: String?,
    @SerializedName("auto_close_time") val autoCloseTime: String?,
    @SerializedName("hold") val hold: String?,
    @SerializedName("sold") val sold: String?,
    @SerializedName("cost") val cost: String?
)
