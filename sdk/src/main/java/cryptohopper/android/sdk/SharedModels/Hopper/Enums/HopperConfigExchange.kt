//
//  HopperConfigExchange.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

enum class HopperConfigExchange(val rawValue: String) {
    @SerializedName("poloniex") POLONIEX("poloniex"),
    @SerializedName("kraken") KRAKEN("kraken"),
    @SerializedName("bittrex") BITTREX("bittrex"),
    @SerializedName("gdax") GDAX("gdax"),
    @SerializedName("binance") BINANCE("binance"),
    @SerializedName("cryptopia") CRYPTOPIA("cryptopia"),
    @SerializedName("bitfinex") BITFINEX("bitfinex"),
    @SerializedName("kucoin") KUCOIN("kucoin"),
    @SerializedName("cexio") CEXIO("cexio"),
    @SerializedName("hitbtc") HITBTC("hitbtc"),
    @SerializedName("huobi") HOUBI("huobi"),
    @SerializedName("bitpanda") BITPANDA("bitpanda"),
    @SerializedName("kraken2") KRAKEN2("kraken2"),
    @SerializedName("binanceus") BINANCEUS("binanceus"),
    @SerializedName("bitvavo") BITVAVO("bitvavo"),
    @SerializedName("okex") OKEX("okex")
}
