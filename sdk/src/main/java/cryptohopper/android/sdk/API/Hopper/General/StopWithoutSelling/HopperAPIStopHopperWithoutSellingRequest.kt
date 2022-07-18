package cryptohopper.android.sdk.API.Hopper.General.StopWithoutSelling

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIStopHopperWithoutSellingRequest : HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String ) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/stop")
    }
}