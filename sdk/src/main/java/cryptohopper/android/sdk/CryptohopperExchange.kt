import java.util.*

class CryptohopperExchange {

    companion object {

        // ------------- GENERAL ----------------------------------------


        /// Get User Profile
        ///
        fun getUserProfile(callback: (UserProfile?, HopperError?) -> Unit) {
            HopperAPIGetUserProfileRequest("").request({ data ->
                callback(data.userProfile,null)
            } ,{ error ->
                callback(null,error)
            })
        }

        // ------------- GENERAL ----------------------------------------

        /// Get Exchanges
        ///
        fun getExchanges(callback : (List<Exchange>?, HopperError?) -> Unit) {
            HopperAPIGetExchangeRequest("").request({ data ->
                    callback(data.exchanges,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Exchanges with Details
        ///
        fun getExchangeDetails(callback : (List<Exchange>?, HopperError?) -> Unit) {
            HopperAPIGetExchangeDetailsRequest("").request({ data ->
                    callback(data.exchanges,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Exchange Forex Rates
        ///
        fun getExchangeForexRates(callback : (List<ExchangeForexRates>?, HopperError?) -> Unit) {
            HopperAPIGetExchangeForexRatesRequest("").request({ data ->
                    callback(data.forexRates,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Base Currencies From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getBaseCurrenciesFromExchange(exchange : String,callback : (Map<String,Map<String,Ticker>>?, HopperError?) -> Unit) {
            HopperAPIGetBaseCurrenciesFromExchangeRequest(exchange).request({ data ->
                    callback(data.baseCurrencies,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Base Currency From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        fun getBaseCurrencyFromExchange(exchange : String,currency : String,callback : (Map<String,String>?, HopperError?) -> Unit) {
            HopperAPIGetBaseCurrencyFromExchangeRequest( exchange,  currency).request({ data ->
                    callback(data.baseCurrencies,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Candles From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) pair
        ///- Parameter timeFrame: (required) time frame
        ///- Parameter startDate: (required) start date
        ///- Parameter endDate: (required) end date
        fun getCandlesFromExchange(exchange : String, pair : String, timeFrame : CandleTimeFrame, startDate : Date, endDate : Date, callback : (List<Candle>?, HopperError?) -> Unit) {
            HopperAPIGetCandlesFromExchangeRequest( exchange,  pair,  timeFrame,  startDate,  endDate).request({ data ->
                    callback(data.candles,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Available Currencies For Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getAvailableCurrenciesForExchange(exchange : String,callback : (Map<String,ExchangeCurrencyDetail>?, HopperError?) -> Unit) {
            HopperAPIGetAvailableCurrenciesOfExchangeRequest( exchange).request({ data ->
                    callback(data.currencies,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Precision For Currencies Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getPrecisionForCurrenciesOfExchange(exchange : String,callback : (Map<String,String>?, HopperError?) -> Unit) {
            HopperAPIGetPrecisionForCurrenciesOfExchangeRequest( exchange).request({ data ->
                    callback(data.precisions,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Single Currency Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter coin: (required) exchange
        fun getSingleCurrencyOfExchange(exchange : String,coin : String,callback : (ExchangeCurrencyDetail?, HopperError?) -> Unit) {
            HopperAPIGetSingleCurrencyOfExchangeRequest( exchange,  coin).request({ data ->
                    callback(data.detail,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Precision For Currency Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        fun getPrecisionForCurrencyOfExchange(exchange : String,currency: String,callback : (Map<String,Int>?, HopperError?) -> Unit) {
            HopperAPIGetPrecisionForCurrencyOfExchangeRequest( exchange,  currency).request({ data ->
                    callback(data.precision,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Trading Pair Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        ///- Parameter baseCurrency: (required) baseCurrency
        fun getTradingPairOfExchange(exchange : String,currency : String,baseCurrency : String,callback : (String?, HopperError?) -> Unit) {
            HopperAPIGetTradingPairOfExchangeRequest( exchange,  currency,  baseCurrency).request({ data ->
                    callback(data.pairCode,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Markets Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getMarketsOfExchange(exchange : String,callback : (List<String>?, HopperError?) -> Unit) {
            HopperAPIGetMarketsOfExchangeRequest( exchange).request({ data ->
                    callback(data.pairs,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Price And Amount Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter market: (required) market
        fun getPriceAndAmountOfExchange(exchange : String,market : String,callback : (Map<String,String>?, HopperError?) -> Unit) {
            HopperAPIGetPriceAndAmountOfExchangeRequest( exchange,  market).request({ data ->
                    callback(data.decimals,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get All Tickers Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getAllTickersOfExchange(exchange : String,callback : (Map<String,Ticker>?, HopperError?) -> Unit) {
            HopperAPIGetAllTickerOfExchangeRequest( exchange).request({ data ->
                    callback(data.pairTickers,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Exchange Ticker Pair
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) market
        fun getExchangeTickerPair(exchange : String,pair : String,callback : (Ticker?, HopperError?) -> Unit) {
            HopperAPIGetExchangeTickerPairRequest( exchange, pair).request({ data ->
                    callback(data.ticker,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get Pair Order Book Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) market
        ///- Parameter depth: (required) depth
        fun getPairOrderBookOfExchange(exchange : String,pair : String,depth : Int,callback : (HopperAPIGetPairOrderBookOfExchangeData?, HopperError?) -> Unit) {
            HopperAPIGetPairOrderBookOfExchangeRequest( exchange, pair, depth).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }


    }

}