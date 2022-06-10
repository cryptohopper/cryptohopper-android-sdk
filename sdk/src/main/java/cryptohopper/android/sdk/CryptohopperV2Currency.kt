import cryptohopper.android.sdk.API.apiv2.currencies.HopperAPIV2GetAllCurrenciesRequest
import cryptohopper.android.sdk.API.apiv2.currencies.V2Currency
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Currency {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Currencies
        fun getCurrencies(callback: (List<V2Currency>?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetAllCurrenciesRequest().request<List<V2Currency>>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}