package cryptohopper.android.sdk.API.Hopper.Position.SyncPosition

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPISyncPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,currency : String,amount: Double,rate : Double) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/sync")
        this.addBodyItem( "currency",  currency)
        this.addBodyItem( "amount",  amount)
        this.addBodyItem( "rate",  rate)
    }

}