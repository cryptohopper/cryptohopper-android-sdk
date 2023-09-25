package cryptohopper.android.sdk.API.Hopper.Troubleshooter

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTroubleshooterRequest : HopperAPIRequest<HopperAPITroubleshooterAPIResponse> {

    constructor(
        hopperId : String,
        platform : String,
        lang : String
    ) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/troubleshooter")
        addQueryItem("platform", platform)
        addQueryItem("lang", lang)
    }

}