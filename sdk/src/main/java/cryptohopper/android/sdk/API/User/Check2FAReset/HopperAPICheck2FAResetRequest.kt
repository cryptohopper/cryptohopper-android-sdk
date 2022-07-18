package cryptohopper.android.sdk.API.User.Check2FAReset

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPICheck2FAResetRequest :  HopperAPIRequest<HopperAPICheck2FAResetResponse> {

    constructor(data: String){
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/user/require2fareset")
    }
}