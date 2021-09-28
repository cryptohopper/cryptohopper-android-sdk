//
//  HopperConfigAPIConfig.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperConfigAPIConfig (
    @SerializedName("api_key") var apiKey: String?,
    @SerializedName("api_secret") var apiSecret: String?,
    @SerializedName("kraken_extra_key") var krakenExtraKey: String?,
    @SerializedName("kraken_private_extra_key") var krakenPrivateExtraKey: String?,
    @SerializedName("gdax_api_passphrase") var gdaxApiPassphrase: String?,
    @SerializedName("gdax_post_only") var gdaxPostOnly: String?
) {
    constructor(): this(null,null,null,null,null,null) {

    }
}
