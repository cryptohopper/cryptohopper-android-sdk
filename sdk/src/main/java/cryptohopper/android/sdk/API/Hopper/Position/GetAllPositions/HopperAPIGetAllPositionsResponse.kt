//
//  HopperAPIGetAllPositionsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAllPositionsResponse (
        @SerializedName("data") val data: List<HopperPosition>?
)
