package cryptohopper.android.sdk.API.User.General.RegisterUser

import com.google.gson.annotations.SerializedName

data class HopperAPIRegisterUserResponse (
        @SerializedName("data") val data: HopperRegisterData?,
        @SerializedName("status") val status: Int?,
        @SerializedName("error") val error: Int?,
        @SerializedName("code") val code: Int?,
        @SerializedName("message") val message: String?
)

data class HopperRegisterData (
        @SerializedName("user_id") val userId: String?,
        @SerializedName("message") val message: String?,
        @SerializedName("user_activation_needed") val userActivationNeeded: String?
)