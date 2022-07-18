package cryptohopper.android.sdk.API.User.CheckPasswordReset

import com.google.gson.annotations.SerializedName

data class HopperAPICheckPasswordResetResponse(
    @SerializedName("data") val data : Boolean?
)
