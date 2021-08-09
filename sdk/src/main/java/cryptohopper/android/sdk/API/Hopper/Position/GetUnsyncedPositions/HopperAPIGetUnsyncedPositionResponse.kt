package cryptohopper.android.sdk.API.Hopper.Position.GetUnsyncedPositions

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.HopperUnsynedPosition

data class HopperAPIGetUnsyncedPositionResponse (
        @SerializedName("data") val data: HopperAPIGetUnsyncedPositionResponseData?
)

data class HopperAPIGetUnsyncedPositionResponseData (
        @SerializedName("unsynced") val unsyned: List<HopperUnsynedPosition>?,
        @SerializedName("dust") val dust: List<HopperUnsynedPosition>?
)
