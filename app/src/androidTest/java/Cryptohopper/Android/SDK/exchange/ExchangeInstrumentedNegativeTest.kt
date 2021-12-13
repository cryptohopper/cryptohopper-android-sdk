package Cryptohopper.Android.SDK.exchange

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import Cryptohopper.Android.SDK.helper.StringGenerator
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ExchangeInstrumentedNegativeTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )

        if (Const.isUserLoggedIn.not()) {
            callAuthenticationWithMockDetails()
            Const.isUserLoggedIn = true
        }
    }


    private fun callAuthenticationWithMockDetails() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = StringGenerator.getRandomString(),
            password = StringGenerator.getRandomString(),
            verificationCode = null,
            userAgent = userAgent
        ) { result, error ->
            Assert.assertNull(result)
            Assert.assertNotNull(error)
        }
    }

    //******************* Negative cases ***************************

    @Test
    fun when_the_given_getUserProfile_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperExchange.getUserProfile { result, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(result)

            Assert.assertNull(result?.name)
            Assert.assertNull(result?.username)
            Assert.assertNull(result?.email)
            Assert.assertNull(result?.website)
            Assert.assertNull(result?.country)
            Assert.assertNull(result?.city)
            Assert.assertNull(result?.phone)
            Assert.assertNull(result?.region)
        }
    }

    @Test
    fun when_the_given_getExchanges_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperExchange.getExchanges { result, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(result)
        }
    }

    @Test
    fun when_the_given_getExchangeDetails_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperExchange.getExchangeDetails { result, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(result)
            Assert.assertTrue(result?.javaClass?.name != "java.util.ArrayList")
        }
    }

    @Test
    fun when_the_given_getExchangeForexRates_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperExchange.getExchangeForexRates { result, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(result)
            Assert.assertNull(result?.get(0)?.currency)
            Assert.assertNull(result?.get(0)?.quoteCurrency)
            Assert.assertNull(result?.get(0)?.exchangeRate)
        }
    }

    @Test
    fun when_the_given_getBaseCurrenciesFromExchange_Endpoint_is_called_with_the_incorrect_exchangeKey_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getBaseCurrenciesFromExchange(
                            it.exchangeKey ?: ""
                        ) { baseCurrencies, baseCurrenciesError ->
                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getBaseCurrencyFromExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getBaseCurrencyFromExchange(
                            it.exchangeKey ?: "",
                            it.defaultBaseCurrency ?: ""
                        ) { baseCurrencies, baseCurrenciesError ->
                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getAvailableCurrenciesForExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getAvailableCurrenciesForExchange(
                            it.exchangeKey ?: "",
                        ) { baseCurrencies, baseCurrenciesError ->

                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrenciesOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getPrecisionForCurrenciesOfExchange(
                            it.exchangeKey ?: "",
                        ) { baseCurrencies, baseCurrenciesError ->

                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrencyOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getPrecisionForCurrencyOfExchange(
                            it.exchangeKey ?: "",
                            "btc"
                        ) { baseCurrencies, baseCurrenciesError ->

                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getSingleCurrencyOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getSingleCurrencyOfExchange(
                            it.exchangeKey ?: "",
                            it.defaultBaseCurrency ?: "",
                        ) { baseCurrencies, baseCurrenciesError ->

                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(baseCurrencies)

                            Assert.assertNull(baseCurrencies?.id)
                            Assert.assertNull(baseCurrencies?.name)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getTradingPairOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getTradingPairOfExchange(
                            it.exchangeKey ?: "",
                            "btc",
                            it.defaultBaseCurrency ?: ""
                        ) { pairCode, baseCurrenciesError ->

                            Assert.assertNotNull(baseCurrenciesError)
                            Assert.assertNull(pairCode)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getMarketsOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getMarketsOfExchange(
                            it.exchangeKey ?: ""
                        ) { markets, marketError ->

                            Assert.assertNotNull(marketError)
                            Assert.assertNull(markets)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getPriceAndAmountOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                async {
                    CryptohopperExchange.getMarketsOfExchange(
                        result?.get(0)?.exchangeKey ?: ""
                    ) { markets, _ ->
                        async {
                            CryptohopperExchange.getPriceAndAmountOfExchange(
                                result?.get(0)?.exchangeKey ?: "",
                                markets?.get(0) ?: ""
                            ) { exchangeAmountResponse, exchangeAmountError ->

                                Assert.assertNotNull(exchangeAmountError)
                                Assert.assertNull(exchangeAmountResponse)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getAllTickersOfExchange_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                async {
                    CryptohopperExchange.getAllTickersOfExchange(
                        result?.get(0)?.exchangeKey ?: ""
                    ) { pairTickers, pairTickersError ->
                        Assert.assertNotNull(pairTickersError)
                        Assert.assertNull(pairTickers)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getExchangeTickerPair_Endpoint_is_called_with_the_incorrect_data_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                async {
                    CryptohopperExchange.getAllTickersOfExchange(
                        result?.get(0)?.exchangeKey ?: ""
                    ) { pairTickers, _ ->
                        async {
                            CryptohopperExchange.getExchangeTickerPair(
                                result?.get(0)?.exchangeKey ?: "",
                                pairTickers?.values?.toTypedArray()?.get(0)?.currencyPair.toString()
                            ) { ticker, pairTickersError ->

                                Assert.assertNotNull(pairTickersError)
                                Assert.assertNull(ticker)
                            }
                        }
                    }
                }
            }
        }
    }
}