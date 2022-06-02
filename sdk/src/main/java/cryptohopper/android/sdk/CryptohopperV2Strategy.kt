import cryptohopper.android.sdk.API.apiv2.strategies.getstrategies.HopperAPIV2GetAllBuiltinStrategiesRequest
import cryptohopper.android.sdk.API.apiv2.strategies.getstrategies.V2Strategy
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Strategy {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Strategies
        fun getBuiltinStrategies(callback: (List<V2Strategy>?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetAllBuiltinStrategiesRequest().request<List<V2Strategy>>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}