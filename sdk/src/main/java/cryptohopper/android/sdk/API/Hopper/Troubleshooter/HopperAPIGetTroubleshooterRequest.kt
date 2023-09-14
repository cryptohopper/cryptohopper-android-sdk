package cryptohopper.android.sdk.API.Hopper.Troubleshooter

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTroubleshooterRequest : HopperAPIRequest<HopperAPITroubleshooterAPIResponse> {

    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/troubleshooter")
    }

}