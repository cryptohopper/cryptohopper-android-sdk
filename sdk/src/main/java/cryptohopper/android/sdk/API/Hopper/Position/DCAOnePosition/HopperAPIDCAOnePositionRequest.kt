package cryptohopper.android.sdk.API.Hopper.Position.DCAOnePosition

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIDCAOnePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,positionId : Int, marketOrder : Boolean) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/dca/$positionId")
        if(marketOrder){
            addBodyItem("market_order", 1)
        }else{
            addBodyItem("market_order", 0)
        }
    }

}
