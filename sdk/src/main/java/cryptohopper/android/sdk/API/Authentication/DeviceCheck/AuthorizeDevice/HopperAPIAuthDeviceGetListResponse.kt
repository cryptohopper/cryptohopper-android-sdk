package cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice

import com.google.gson.annotations.SerializedName

data class HopperAPIAuthDeviceGetListResponse(
    @SerializedName("data") val data : List<HopperAPIAuthDeviceGetListModel>?
)

data class HopperAPIAuthDeviceGetListModel(
    @SerializedName("id") val id : Int?,
    @SerializedName("name") val name : String?,
    @SerializedName("location") val location : String?,
    @SerializedName("ipAddress") val ipAddress : String?,
    @SerializedName("platform") val platform : String?,
    @SerializedName("state") val state : Int?,
    @SerializedName("deviceId") val deviceId : String?,
    @SerializedName("lastActivity") val lastActivity : Double?,
    @SerializedName("createdAt") val createdAt : Double?,
    @SerializedName("deletedAt") val deletedAt : Double?,
    @SerializedName("expiration") val expiration : Double?,
    @SerializedName("revokedAt") val revokedAt : Double?,
)
