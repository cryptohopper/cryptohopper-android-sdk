import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperStrategy {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Strategies
        ///
        fun getStrategies(callback: (List<Strategy>?, HopperAPIError?) -> Unit) {
            HopperAPIGetStrategiesRequest("").request<HopperAPIGetStrategiesResponse>({ data ->
                callback(data.data?.strategies, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun getStrategy(strategyId: Int, callback: (MarketStrategy?, HopperAPIError?) -> Unit) {
            HopperAPIGetStrategyRequest(strategyId).request<HopperAPIGetStrategyResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Update Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun createStrategy(
            strategyId: Int,
            name: String,
            description: String,
            image: String,
            minBuys: Int,
            minSells: Int,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPICrateStrategyRequest(
                strategyId,
                name,
                description,
                image,
                minBuys,
                minSells
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Update Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun updateStrategy(
            strategyId: Int,
            name: String,
            description: String,
            image: String,
            minBuys: Int,
            minSells: Int,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIUpdateStrategyRequest(
                strategyId,
                name,
                description,
                image,
                minBuys,
                minSells
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Delete Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun deleteStrategy(strategyId: Int, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIDeleteStrategyRequest(strategyId).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Change Image Of Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun changeImageOfStrategy(
            strategyId: Int,
            image: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIChangeImageOfStrategyRequest(
                strategyId,
                image
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        // ------------- Market ----------------------------------------


        /// Get Market Strategies
        ///
        fun getMarketStrategies(callback: (List<Strategy>?, HopperAPIError?) -> Unit) {
            HopperAPIGetMarketStrategiesRequest("").request<HopperAPIGetMarketStrategiesResponse>({ data ->
                callback(data.data?.strategies, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Market Strategy
        ///
        fun getMarketStrategy(strategyId: Int, callback: (Strategy?, HopperAPIError?) -> Unit) {
            HopperAPIGetMarketStrategyRequest(strategyId).request<HopperAPIGetMarketStrategyResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Market Strategies
        ///
        fun deleteMarketStrategy(strategyId: Int, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIDeleteMarketStrategyRequest(strategyId).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

    }

}