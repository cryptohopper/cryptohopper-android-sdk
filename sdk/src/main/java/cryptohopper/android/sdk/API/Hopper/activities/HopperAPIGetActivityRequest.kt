package cryptohopper.android.sdk.API.Hopper.activities

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetActivityRequest : HopperAPIRequest<HopperAPIGetActivityResponse> {

    constructor(hopperId: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/activity")
    }
}
