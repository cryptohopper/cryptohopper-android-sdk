package cryptohopper.android.sdk.API.Hopper.Position.MoveReservedPositionToOpen

import cryptohopper.android.sdk.API.Hopper.General.GetAssets.HopperAPIGetAssetsResponse
import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIMoveReservedPositionToOpenRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String , positionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/reserved/$positionId/movetopositions")
    }

}