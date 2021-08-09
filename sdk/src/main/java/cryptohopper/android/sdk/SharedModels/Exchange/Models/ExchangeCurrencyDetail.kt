//
//  ExchangeCurrencyDetail.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class ExchangeCurrencyDetail (
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?
//    @SerializedName("txFee") val txFee: String?,
//    @SerializedName("minConf") val minConf: String?,
//    @SerializedName("depositAddress") val depositAddress: String?,
//    @SerializedName("disabled") val disabled: Int?,
//    @SerializedName("delisted") val delisted: Int?,
//    @SerializedName("frozen") val frozen: Int?,
//    @SerializedName("notice") val notice: String?
)