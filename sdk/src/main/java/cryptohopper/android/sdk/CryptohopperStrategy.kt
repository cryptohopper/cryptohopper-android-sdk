
class CryptohopperStrategy {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Strategies
        ///
        fun getStrategies(callback : (List<Strategy>?, HopperError?) -> Unit) {
            HopperAPIGetStrategiesRequest("").request({ data ->
                    callback(data.data?.strategies,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun getStrategy(strategyId : Int,callback : (MarketStrategy?, HopperError?) -> Unit) {
            HopperAPIGetStrategyRequest( strategyId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Update Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun createStrategy(strategyId : Int,name : String,description : String, image : String, minBuys : Int , minSells : Int,callback : (String?, HopperError?) -> Unit) {
            HopperAPICrateStrategyRequest( strategyId,  name,  description,  image,  minBuys,  minSells).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Update Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun updateStrategy(strategyId : Int,name : String,description : String, image : String, minBuys : Int , minSells : Int,callback : (String?, HopperError?) -> Unit) {
            HopperAPIUpdateStrategyRequest( strategyId,  name,  description,  image,  minBuys,  minSells).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Delete Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun deleteStrategy(strategyId : Int,callback : (String?, HopperError?) -> Unit) {
            HopperAPIDeleteStrategyRequest( strategyId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Change Image Of Strategy
        ///
        ///- Parameter strategyId: (required) strategy id
        fun changeImageOfStrategy(strategyId : Int,image : String,callback : (String?, HopperError?) -> Unit) {
            HopperAPIChangeImageOfStrategyRequest( strategyId, image).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        // ------------- Market ----------------------------------------


        /// Get Market Strategies
        ///
        fun getMarketStrategies(callback : (List<Strategy>?, HopperError?) -> Unit) {
            HopperAPIGetMarketStrategiesRequest("").request({ data ->
                    callback(data.data?.strategies,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Market Strategy
        ///
        fun getMarketStrategy(strategyId: Int, callback : (Strategy?, HopperError?) -> Unit) {
            HopperAPIGetMarketStrategyRequest( strategyId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Market Strategies
        ///
        fun deleteMarketStrategy(strategyId : Int,callback : (String?, HopperError?) -> Unit) {
            HopperAPIDeleteMarketStrategyRequest( strategyId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

    }

}