package cryptohopper.android.sdk.API.User.General.UpdateMobilePushNotification

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

internal class HopperAPIUpdatePushNotificationRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(
        permissions : Map<String,String>
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user/mobilepushnotifications")

        var arr = mutableMapOf<String,Any>()
        for ((k, v) in permissions) {
            arr[k] = v
        }
        addBodyItem("settings",arr)
    }

}