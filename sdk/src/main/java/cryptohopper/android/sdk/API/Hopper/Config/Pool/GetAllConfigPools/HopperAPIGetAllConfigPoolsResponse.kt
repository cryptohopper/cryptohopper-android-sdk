//
//  HopperAPIGetAllConfigPoolsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//


import com.google.gson.annotations.SerializedName

data class HopperAPIGetAllConfigPoolsResponse (
        @SerializedName("data") val data: List<HopperConfigPool>?
)