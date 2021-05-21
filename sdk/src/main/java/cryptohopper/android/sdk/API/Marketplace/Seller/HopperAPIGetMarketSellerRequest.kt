package cryptohopper.android.sdk.API.Marketplace.Seller

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetMarketSellerRequest: HopperAPIRequest<HopperAPIGetMarketSellerResponse> {

    constructor(id: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/seller/$id")
    }

}