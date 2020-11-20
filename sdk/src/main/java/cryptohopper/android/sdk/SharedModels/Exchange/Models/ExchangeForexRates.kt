//
//  ExchangeForexRates.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class ExchangeForexRates (
    @SerializedName("quoteCurrency") val quoteCurrency: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("exchange_rate") val exchangeRate: String?
)