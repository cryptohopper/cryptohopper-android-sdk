package cryptohopper.android.sdk.API.Hopper.Position.ReleaseReservePosition

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIReleaseReservedPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,positionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/reserved/$positionId/release")
    }

}