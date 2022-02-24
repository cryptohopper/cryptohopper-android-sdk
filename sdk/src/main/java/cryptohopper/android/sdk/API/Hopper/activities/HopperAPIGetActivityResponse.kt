package cryptohopper.android.sdk.API.Hopper.activities//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetActivityResponse(
    @SerializedName("data") val data: HopperAPIGetActivityData?
)

data class HopperAPIGetActivityData(
    @SerializedName("task") val task: String?,
    @SerializedName("start") val start: Int?,
    @SerializedName("time") val time: String?
)