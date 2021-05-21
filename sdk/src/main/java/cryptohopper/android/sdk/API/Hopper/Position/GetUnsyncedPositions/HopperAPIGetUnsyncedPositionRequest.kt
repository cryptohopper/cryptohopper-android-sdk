package cryptohopper.android.sdk.API.Hopper.Position.GetUnsyncedPositions

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetUnsyncedPositionRequest: HopperAPIRequest<HopperAPIGetUnsyncedPositionResponse> {

    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/sync")
    }

}
