package cryptohopper.android.sdk

import HopperError
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseRequest
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseResponse

class CryptohopperPurchase {

    companion object {

        /// Purchase Anything
        ///
        fun purchase(planId: String?,marketplaceId: String?,hopperId: String?,receipt: String, callback : (HopperAPIPurchaseResponse?, HopperError?) -> Unit) {
            HopperAPIPurchaseRequest(planId,marketplaceId,hopperId,receipt).request<HopperAPIPurchaseResponse>({ data ->
                callback(data,null)
            } , { error ->
                callback(null,error)
            })
        }

    }

}