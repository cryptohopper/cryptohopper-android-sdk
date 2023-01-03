import cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP.HopperAPIGetExchangeWhitelistIPRequest
import cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP.HopperAPIGetExchangeWhitelistIPResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError
import java.util.*

class CryptohopperExchange {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get User Profile
        ///
        fun getUserProfile(callback: (UserProfile?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserProfileRequest("").request<HopperAPIGetUserProfileResponse>({ data ->
                callback(data.userProfile, null)
            }, { error ->
                callback(null, error)
            })
        }

        // ------------- GENERAL ----------------------------------------

        /// Get Exchanges
        ///
        fun getExchanges(callback: (List<Exchange>?, HopperAPIError?) -> Unit) {
            HopperAPIGetExchangeRequest("").request<HopperAPIGetExchangeResponse>({ data ->
                callback(data.exchanges, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Exchanges with Details
        ///
        fun getExchangeDetails(callback: (List<Exchange>?, HopperAPIError?) -> Unit) {
            HopperAPIGetExchangeDetailsRequest("").request<HopperAPIGetExchangeDetailsResponse>({ data ->
                callback(data.exchanges, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Exchanges IP Whitelist
        ///
        fun getExchangeWhitelistIps(exchangeKey: String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIGetExchangeWhitelistIPRequest(exchange = exchangeKey).request<HopperAPIGetExchangeWhitelistIPResponse>({ data ->
                callback(data.data?.ips, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Exchange Forex Rates
        ///
        fun getExchangeForexRates(callback: (List<ExchangeForexRates>?, HopperAPIError?) -> Unit) {
            HopperAPIGetExchangeForexRatesRequest("").request<HopperAPIGetExchangeForexRatesResponse>(
                { data ->
                    callback(data.forexRates, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Base Currencies From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getBaseCurrenciesFromExchange(
            exchange: String,
            callback: (Map<String, Map<String, String>>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetBaseCurrenciesFromExchangeRequest(exchange).request<HopperAPIGetBaseCurrenciesFromExchangeResponse>(
                { data ->
                    callback(data.baseCurrencies, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Base Currency From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        fun getBaseCurrencyFromExchange(
            exchange: String,
            currency: String,
            callback: (Map<String, String>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetBaseCurrencyFromExchangeRequest(
                exchange,
                currency
            ).request<HopperAPIGetBaseCurrencyFromExchangeResponse>({ data ->
                callback(data.baseCurrencies, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Candles From Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) pair
        ///- Parameter timeFrame: (required) time frame
        ///- Parameter startDate: (required) start date
        ///- Parameter endDate: (required) end date
        fun getCandlesFromExchange(
            exchange: String,
            pair: String,
            timeFrame: CandleTimeFrame,
            startDate: Date,
            endDate: Date,
            callback: (List<Candle>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetCandlesFromExchangeRequest(
                exchange,
                pair,
                timeFrame,
                startDate,
                endDate
            ).request<HopperAPIGetCandlesFromExchangeResponse>({ data ->
                callback(data.candles, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Available Currencies For Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getAvailableCurrenciesForExchange(
            exchange: String,
            callback: (Map<String, ExchangeCurrencyDetail>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetAvailableCurrenciesOfExchangeRequest(exchange).request<HopperAPIGetAvailableCurrenciesOfExchangeResponse>(
                { data ->
                    callback(data.currencies, null)
                },
                { error ->
                    callback(null, error)
                })
        }


        /// Get Precision For Currencies Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getPrecisionForCurrenciesOfExchange(
            exchange: String,
            callback: (Map<String, String>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetPrecisionForCurrenciesOfExchangeRequest(exchange).request<HopperAPIGetPrecisionForCurrenciesOfExchangeResponse>(
                { data ->
                    callback(data.precisions, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Single Currency Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter coin: (required) exchange
        fun getSingleCurrencyOfExchange(
            exchange: String,
            coin: String,
            callback: (ExchangeCurrencyDetail?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetSingleCurrencyOfExchangeRequest(
                exchange,
                coin
            ).request<HopperAPIGetSingleCurrencyOfExchangeResponse>({ data ->
                callback(data.detail, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Precision For Currency Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        fun getPrecisionForCurrencyOfExchange(
            exchange: String,
            currency: String,
            callback: (Map<String, Int>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetPrecisionForCurrencyOfExchangeRequest(
                exchange,
                currency
            ).request<HopperAPIGetPrecisionForCurrencyOfExchangeResponse>({ data ->
                callback(data.precision, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Trading Pair Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter currency: (required) currency
        ///- Parameter baseCurrency: (required) baseCurrency
        fun getTradingPairOfExchange(
            exchange: String,
            currency: String,
            baseCurrency: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetTradingPairOfExchangeRequest(
                exchange,
                currency,
                baseCurrency
            ).request<HopperAPIGetTradingPairOfExchangeResponse>({ data ->
                callback(data.pairCode, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Markets Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getMarketsOfExchange(
            exchange: String,
            callback: (List<String>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetMarketsOfExchangeRequest(exchange).request<HopperAPIGetMarketsOfExchangeResponse>(
                { data ->
                    callback(data.pairs, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Price And Amount Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter market: (required) market
        fun getPriceAndAmountOfExchange(
            exchange: String,
            market: String,
            callback: (Map<String, String>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetPriceAndAmountOfExchangeRequest(
                exchange,
                market
            ).request<HopperAPIGetPriceAndAmountOfExchangeResponse>({ data ->
                callback(data.decimals, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get All Tickers Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getAllTickersOfExchange(
            exchange: String,
            callback: (Map<String, Ticker>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetAllTickerOfExchangeRequest(exchange).request<HopperAPIGetAllTickerOfExchangeResponse>(
                { data ->
                    callback(data.pairTickers, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get Exchange Ticker Pair
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) market
        fun getExchangeTickerPair(
            exchange: String,
            pair: String,
            callback: (Ticker?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetExchangeTickerPairRequest(
                exchange,
                pair
            ).request<HopperAPIGetExchangeTickerPairResponse>({ data ->
                callback(data.ticker, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Pair Order Book Of Exchange
        ///
        ///- Parameter exchange: (required) exchange
        ///- Parameter pair: (required) market
        ///- Parameter depth: (required) depth
        fun getPairOrderBookOfExchange(
            exchange: String,
            pair: String,
            depth: Int,
            callback: (HopperAPIGetPairOrderBookOfExchangeData?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetPairOrderBookOfExchangeRequest(
                exchange,
                pair,
                depth
            ).request<HopperAPIGetPairOrderBookOfExchangeResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}