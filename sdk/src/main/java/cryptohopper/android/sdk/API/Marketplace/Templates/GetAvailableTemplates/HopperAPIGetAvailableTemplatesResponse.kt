//
//  HopperAPIGetAvailableTemplatesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAvailableTemplatesResponse (
        @SerializedName("data") val data: HopperAPIGetAvailableTemplatesData?
)

data class HopperAPIGetAvailableTemplatesData (
        @SerializedName("template") val templates: List<MarketplaceTemplate>?
)
