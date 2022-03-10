//
//  HopperAPIGetHoldPositionsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetHoldPositionsResponse(
    @SerializedName("data") val data: List<HopperPosition>?
)