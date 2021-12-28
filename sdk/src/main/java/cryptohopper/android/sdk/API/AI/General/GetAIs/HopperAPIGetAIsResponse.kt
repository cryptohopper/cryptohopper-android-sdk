package cryptohopper.android.sdk.API.AI.General.GetAIs

/**
 * HopperAPIGetAIsResponse.kt
 * @author Malik Dawar
 */

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAIsResponse(
    @SerializedName("data")
    val data: List<HopperAPIGetAIsDataItem>?
)

data class HopperAPIGetAIsDataItem(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("logo")
    val logo: String? = null,
    @SerializedName("created_date")
    val createdDate: String? = null
)
