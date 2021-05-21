package cryptohopper.android.sdk.API.Hopper.Balance.EditStartBalance

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIEditStartBalanceRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,balance : Double) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/startbalance")
        this.addBodyItem("start_balance", balance)
    }

}
