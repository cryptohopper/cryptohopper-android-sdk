package cryptohopper.android.sdk.API.Purchase.General

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIPurchaseRequest: HopperAPIRequest<HopperAPIPurchaseResponse> {

    constructor(planId: String?,marketplaceId : String?,hopperId : String?,receipt:String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/mobile/receipt")

        addBodyItem("platform", "android")

        if(planId != null){
            addBodyItem( "plan_id",  planId!!)
        }

        if(marketplaceId != null){
            addBodyItem( "marketplace_id",  marketplaceId!!)
        }

        if(hopperId != null){
            addBodyItem( "hopper_id",  hopperId!!)
        }

        addBodyItem( "receipt",  receipt)
    }

}
