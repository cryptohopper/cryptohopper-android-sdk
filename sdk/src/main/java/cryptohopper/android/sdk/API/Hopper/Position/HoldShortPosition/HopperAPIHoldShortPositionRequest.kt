package cryptohopper.android.sdk.API.Hopper.Position.HoldShortPosition

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIHoldShortPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,positionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/short/hold/$positionId")
    }

}