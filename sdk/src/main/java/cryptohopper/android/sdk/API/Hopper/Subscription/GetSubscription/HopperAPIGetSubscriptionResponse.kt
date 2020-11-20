//
//  HopperAPIGetSubscriptionResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetSubscriptionResponse (
        @SerializedName("data") val data: HopperAPIGetSubscriptionData?
)

data class HopperAPIGetSubscriptionData (
        @SerializedName("subscription") val subscription: HopperSubscription?
)