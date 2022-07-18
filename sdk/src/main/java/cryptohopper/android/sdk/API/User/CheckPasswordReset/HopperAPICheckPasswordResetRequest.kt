package cryptohopper.android.sdk.API.User.CheckPasswordReset

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPICheckPasswordResetRequest: HopperAPIRequest<HopperAPICheckPasswordResetResponse> {

    constructor(data: String){
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/user/requirepasswordreset")
    }
}