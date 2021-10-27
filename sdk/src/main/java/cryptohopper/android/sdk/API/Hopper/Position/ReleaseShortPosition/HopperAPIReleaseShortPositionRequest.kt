package cryptohopper.android.sdk.API.Hopper.Position.ReleaseShortPosition

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIReleaseShortPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,positionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/short/release/$positionId")
    }

}
