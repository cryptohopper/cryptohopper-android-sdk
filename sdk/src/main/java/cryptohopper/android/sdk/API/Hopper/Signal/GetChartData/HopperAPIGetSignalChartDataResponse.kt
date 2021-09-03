package cryptohopper.android.sdk.API.Hopper.Signal.GetChartData

import com.google.gson.annotations.SerializedName

data class HopperAPIGetSignalChartDataResponse (
    @SerializedName("data") val data: Map<String,List<SignalChartData?>>?
)

data class SignalChartData (
    @SerializedName("signal_time") val signalTime: String?,
    @SerializedName("result_sum") val resultSum: String?,
    @SerializedName("result_sum_perct") val resultSumPerct: String?
)