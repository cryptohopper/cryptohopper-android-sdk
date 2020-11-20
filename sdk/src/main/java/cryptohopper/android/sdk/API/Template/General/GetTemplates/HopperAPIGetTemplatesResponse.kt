//
//  HopperAPIGetTemplatesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetTemplatesResponse (
        @SerializedName("data") val data: HopperAPIGetTemplatesData?
)

data class HopperAPIGetTemplatesData (
        @SerializedName("templates") val templates: List<Template>?
)