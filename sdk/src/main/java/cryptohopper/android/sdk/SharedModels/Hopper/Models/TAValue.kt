package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class TAValue (
        @SerializedName("settings") val settings : Map<String,String>?,
        @SerializedName("strategy") val strategy : String?,
        @SerializedName("coin") val coin : String?,
        @SerializedName("strategy_type") val strategyType : String?,
        @SerializedName("strategy_id") val strategyId : String?,
        @SerializedName("values") val values : Object?,
        @SerializedName("signals") val signals : Object?,
        @SerializedName("indicators") val indicators : List<TAIndicator>?
)

data class TASettings (
        @SerializedName("advanced_ta_ema_disabled") val advanced_ta_ema_disabled : String?,
        @SerializedName("advanced_ta_sma_disabled") val advanced_ta_sma_disabled : String?,
        @SerializedName("advanced_ta_kama_disabled") val advanced_ta_kama_disabled : String?,
        @SerializedName("advanced_ta_candle_size") val advanced_ta_candle_size : String?,
        @SerializedName("advanced_ta_bbands_period") val advanced_ta_bbands_period : String?,
        @SerializedName("advanced_ta_bbands_dev_low") val advanced_ta_bbands_dev_low : String?,
        @SerializedName("advanced_ta_bbands_dev_up") val advanced_ta_bbands_dev_up : String?,
        @SerializedName("advanced_ta_bbands_matype") val advanced_ta_bbands_matype : String?,
        @SerializedName("advanced_ta_bbands_necessary") val advanced_ta_bbands_necessary : String?,
        @SerializedName("advanced_ta_stoch_disabled") val advanced_ta_stoch_disabled : String?,
        @SerializedName("advanced_ta_stochrsi_disabled") val advanced_ta_stochrsi_disabled : String?,
        @SerializedName("advanced_ta_rsi_period") val advanced_ta_rsi_period : String?,
        @SerializedName("advanced_ta_rsi_overbought") val advanced_ta_rsi_overbought : String?,
        @SerializedName("advanced_ta_rsi_oversold") val advanced_ta_rsi_oversold : String?,
        @SerializedName("advanced_ta_rsi_necessary") val advanced_ta_rsi_necessary : String?,
        @SerializedName("advanced_ta_macd_disabled") val advanced_ta_macd_disabled : String?
)

data class TAIndicator (

        @SerializedName("config") val config : TAIndicatorConfig?,
        @SerializedName("chartperiod") val chartPeriod : String?,
        @SerializedName("type") val type : String?,
        @SerializedName("name") val name : String?
)

data class TAIndicatorConfig (
        @SerializedName("candle_value") val candleValue : String?,
        @SerializedName("period") val period : Int?,
        @SerializedName("fast_k") val fastK : Int?,
        @SerializedName("fast_d") val fastD : Int?,
        @SerializedName("fast_d_matype") val fastDMatype : String?,
        @SerializedName("keep_signal") val keepSignal : Int?
)