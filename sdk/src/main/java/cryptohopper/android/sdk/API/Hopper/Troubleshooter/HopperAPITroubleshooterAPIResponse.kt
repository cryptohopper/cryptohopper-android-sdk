package cryptohopper.android.sdk.API.Hopper.Troubleshooter

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.TroubleshooterItem

data class HopperAPITroubleshooterAPIResponse(
    @SerializedName("data") val data: HopperAPITroubleshooterData?
)

data class HopperAPITroubleshooterData(
    @SerializedName("troubleshooter") val troubleshooter: List<TroubleshooterItem>?
)
