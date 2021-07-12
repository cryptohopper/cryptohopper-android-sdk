//
//  HopperSubscription.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import java.util.*
import com.google.gson.annotations.SerializedName

data class HopperSubscription (
    @SerializedName("hopper_id") val hopperId: Int?,
    @SerializedName("subscription_id") val subscriptionId: Int?,
    @SerializedName("start_time") val startTime: String?,
    @SerializedName("end_time") val endTime: String?,
    @SerializedName("subscription_status") val subscriptionStatus: String?,
    @SerializedName("auto_renewal") val autoRenewal: String?,
    @SerializedName("plan_name") val planName: String?,
    @SerializedName("plan_description") val planDescription: String?,
    @SerializedName("payment_term") val paymentTerm: String?,
    @SerializedName("payment_method_id") val paymentMethodId: String?
)