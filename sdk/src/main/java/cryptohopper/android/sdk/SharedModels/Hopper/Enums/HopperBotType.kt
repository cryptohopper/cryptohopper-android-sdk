package cryptohopper.android.sdk.SharedModels.Hopper.Enums


import com.google.gson.annotations.SerializedName

enum class HopperBotType(val rawValue: String) {
    @SerializedName("0") DEFAULT_HOPPER("0"),
    @SerializedName("1") EXCHANGE_ARBITRAGE_HOPPER("1"),
    @SerializedName("2") MARKET_MAKER_HOPPER("2"),
    @SerializedName("3") MANUAL_TRADING_HOPPER("3"),
    @SerializedName("4") MANAGED_HOPPER("4"),
    @SerializedName("5") MARGIN_AND_FUTURES_HOPPER("5"),
    @SerializedName("6") INDEX_FUND_HOPPER("6"),
    @SerializedName("7") COPY_TRADING_HOPPER("7"),
    @SerializedName("8") TOURNAMENT_HOPPER("8"),
    @SerializedName("9") MINING_MANAGER_HOPPER("9"),
    @SerializedName("10") FUND_MANAGER_HOPPER("10")
}