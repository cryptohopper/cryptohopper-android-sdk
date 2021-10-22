package cryptohopper.android.sdk.API.User.General.GetMobileNotifications

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateGetMobileNotificationRequest: HopperAPIRequest<HopperAPIUpdateGetMobileNotificationResponse> {

    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/user/mobilepushnotifications")
    }

}