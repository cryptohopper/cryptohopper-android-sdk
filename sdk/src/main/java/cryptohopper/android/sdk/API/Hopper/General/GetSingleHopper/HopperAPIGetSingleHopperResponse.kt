//
//  HopperAPIGetSingleHopperResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetSingleHopperResponse (
        @SerializedName("data") val data: HopperAPIGetSingleHopperData?
)

data class HopperAPIGetSingleHopperData (
        @SerializedName("hopper") val hopper: Hopper?
)


