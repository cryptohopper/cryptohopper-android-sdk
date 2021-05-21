package cryptohopper.android.sdk.API.Hopper.General.CreateHopper

import com.google.gson.annotations.SerializedName

data class HopperAPICreateHopperResponse (
        @SerializedName("data") val data: HopperAPICreateHopperModel?
)

data class HopperAPICreateHopperModel (
        @SerializedName("id") val id: Int?
)
