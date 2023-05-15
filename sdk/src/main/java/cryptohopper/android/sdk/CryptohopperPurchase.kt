package cryptohopper.android.sdk

import HopperError
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseRequest
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseResponse
import cryptohopper.android.sdk.API.Purchase.IAP.HopperAPIIAPPurchaseRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperPurchase {

    companion object {

        /// Purchase Anything
        ///
        fun purchase(planId: String?,marketplaceId: String?,hopperId: String?,receipt: String, callback : (HopperAPIPurchaseResponse?, HopperAPIError?) -> Unit) {
            HopperAPIPurchaseRequest(planId,marketplaceId,hopperId,receipt).request<HopperAPIPurchaseResponse>({ data ->
                callback(data,null)
            } , { error ->
                callback(null,error)
            })
        }

        fun purchaseIAP(planId: String?,marketplaceId: String?,hopperId: String?,transactionId: String,isSandBox : Boolean = false, callback : (HopperAPIPurchaseResponse?, HopperAPIError?) -> Unit) {
            HopperAPIIAPPurchaseRequest(planId,marketplaceId,hopperId,transactionId,isSandBox).request<HopperAPIPurchaseResponse>({ data ->
                callback(data,null)
            } , { error ->
                callback(null,error)
            })
        }

    }

}