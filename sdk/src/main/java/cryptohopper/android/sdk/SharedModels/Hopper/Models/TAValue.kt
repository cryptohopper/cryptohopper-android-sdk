package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class TAValue (
        @SerializedName("strategy") val strategy : String?,
        @SerializedName("coin") val coin : String?,
        @SerializedName("strategy_type") val strategyType : String?,
        @SerializedName("strategy_id") val strategyId : String?,
        @SerializedName("values") val values : List<Double>?,
        @SerializedName("signals") val signals : List<String>?,
        @SerializedName("indicators") val indicators : List<TAIndicator>?
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