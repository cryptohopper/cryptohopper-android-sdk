package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class HopperOutput (
        @SerializedName("log_type") val logType: String?,
        @SerializedName("log_output") val logOutput: String?,
        @SerializedName("log_time") val logTime: Double?
)