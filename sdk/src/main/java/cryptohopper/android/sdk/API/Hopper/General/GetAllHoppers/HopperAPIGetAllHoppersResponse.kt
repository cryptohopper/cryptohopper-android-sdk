//
//  HopperAPIHopperResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAllHoppersResponse (
        @SerializedName("data") val data: HopperAPIGetAllHoppersData?
)

data class HopperAPIGetAllHoppersData (
        @SerializedName("hoppers") val hoppers: List<Hopper>?
)

