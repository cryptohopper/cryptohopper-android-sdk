import cryptohopper.android.sdk.API.AI.General.GetAIs.HopperAPIGetAIsDataItem
import cryptohopper.android.sdk.API.AI.General.GetAIs.HopperAPIGetAIsResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

/**
 * CryptoHopperAIs.kt
 * @author Malik Dawar
 */

object CryptoHopperAIs {

    /**
     * fun getHopperAIs, to get the list of all the hopper AIs
     * @return lambda as, callback: (HopperAPIGetAIsResponse?, HopperAPIError?) -> Unit
     * @author Malik Dawar
     */
    fun getHopperAIs(callback: (List<HopperAPIGetAIsDataItem>?, HopperAPIError?) -> Unit) {
        HopperAPIGetAIsRequest().request<HopperAPIGetAIsResponse>({ hopperAIs ->
            callback.invoke(hopperAIs.data, null)
        }, { error ->
            callback.invoke(null, error)
        })
    }
}
