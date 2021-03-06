//
//  HopperAPIGetPrecisionForCurrenciesOfExchangeResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetPrecisionForCurrenciesOfExchangeResponse (
        @SerializedName("data") val precisions: Map<String,String>?
)