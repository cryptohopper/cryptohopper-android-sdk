package cryptohopper.android.sdk.API.Purchase.IAP

import HopperAPIRequest
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIIAPPurchaseRequest: HopperAPIRequest<HopperAPIPurchaseResponse> {

    constructor(planId: String?,marketplaceId : String?,hopperId : String?,transactionId:String, isSandbox: Boolean = false) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/app/mobile/iap")

        addBodyItem("platform", "android")

        if(planId != null){
            addBodyItem( "plan_id",  planId)
        }

        if(marketplaceId != null){
            addBodyItem( "marketplace_id",  marketplaceId)
        }

        if(hopperId != null){
            addBodyItem( "hopper_id",  hopperId)
        }

        if(isSandbox){
            addBodyItem("hopper_id","1")
        }

        addBodyItem( "transaction_id",  transactionId)
    }

}