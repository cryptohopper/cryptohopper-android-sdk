package cryptohopper.android.sdk.API.Hopper.General.GetAssets

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAssetsResponse (
    @SerializedName("data") val data: Map<String,String>?
)