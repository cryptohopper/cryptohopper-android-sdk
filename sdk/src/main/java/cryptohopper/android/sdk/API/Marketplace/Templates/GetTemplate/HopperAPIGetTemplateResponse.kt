//
//  HopperAPIGetTemplateResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetTemplateResponse (
        @SerializedName("data") val data: MarketplaceTemplate?
)