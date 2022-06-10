import cryptohopper.android.sdk.API.apiv2.exchange.HopperAPIV2GetTradingPairOfExchangeRequest
import cryptohopper.android.sdk.API.apiv2.exchange.allv2exchange.HopperAPIV2GetAllExchangesRequest
import cryptohopper.android.sdk.API.apiv2.exchange.allv2exchange.V2Exchange
import cryptohopper.android.sdk.API.apiv2.exchange.getexchange.V2Pair
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Exchange {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Exchanges
        fun getAllExchanges(callback: (List<V2Exchange>?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetAllExchangesRequest().request<List<V2Exchange>>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Exchange market
        fun getExchangeMarkets(exchangeId: Int, callback: (V2Pair?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetTradingPairOfExchangeRequest(exchangeId).request<V2Pair>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}