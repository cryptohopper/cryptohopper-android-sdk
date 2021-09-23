//
//  HopperConfigAPIConfig.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperConfigAPIConfig (
    @SerializedName("api_key") val apiKey: String?,
    @SerializedName("api_secret") val apiSecret: String?,
    @SerializedName("kraken_extra_key") val krakenExtraKey: String?,
    @SerializedName("kraken_private_extra_key") val krakenPrivateExtraKey: String?,
    @SerializedName("gdax_api_passphrase") val gdaxApiPassphrase: String?,
    @SerializedName("gdax_post_only") val gdaxPostOnly: String?
) {
    constructor(): this(null,null,null,null,null,null) {

    }
}
