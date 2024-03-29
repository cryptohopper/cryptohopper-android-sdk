package cryptohopper.android.sdk.API.Hopper.General.GetIPWhitelist

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetHopperWhitelistIPRequest : HopperAPIRequest<HopperAPIGetHopperWhitelistIPResponse> {

    constructor(hopperId : Int, exchange: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/ipwhitelist")
        addQueryItem("exchange", exchange)
    }
}