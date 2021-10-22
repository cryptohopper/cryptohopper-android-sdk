package cryptohopper.android.sdk.API.User.General.GetMobileNotifications

import com.google.gson.annotations.SerializedName

data class HopperAPIUpdateGetMobileNotificationResponse (
    @SerializedName("data") val notifications: Map<String,String>?
)

