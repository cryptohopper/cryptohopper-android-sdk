package Cryptohopper.Android.SDK.exchange

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.Const.V2_KEY
import Cryptohopper.Android.SDK.helper.Const.V2_VALUE
import CryptohopperExchange
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.BuildConfig
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExchangeInstrumentedTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production,
            V2_KEY,
            V2_VALUE
        )

        callAuthenticationWithAccurateDetails()
    }

    private fun callAuthenticationWithAccurateDetails() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = Cryptohopper.Android.SDK.BuildConfig.API_EMAIL,
            password = Cryptohopper.Android.SDK.BuildConfig.API_PASSWORD,
            verificationCode = "",
            userAgent = Cryptohopper.Android.SDK.BuildConfig.API_AGENT,
            "",
            "Android"
        ) { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
            Assert.assertEquals("Successfully Logged In", result)
        }
    }

    //******************* Positive cases ***************************

    @Test
    fun when_the_given_getUserProfile_Endpoint_is_called_with_correct_token_then_it_must_return_profile_details() {
        CryptohopperExchange.getUserProfile { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)

            Assert.assertNotNull(result?.name!!)
            Assert.assertNotNull(result.username)
            Assert.assertNotNull(result.email)
            Assert.assertNotNull(result.website)
            Assert.assertNotNull(result.country)
            Assert.assertNotNull(result.city)
            Assert.assertNotNull(result.phone)
            Assert.assertNotNull(result.region)
        }
    }

    @Test
    fun when_the_given_getExchanges_Endpoint_is_called_with_correct_token_then_it_must_return_list() {
        CryptohopperExchange.getExchanges { result, error ->
            Assert.assertNotNull(result)
            Assert.assertTrue(result?.javaClass?.name == "java.util.ArrayList")
        }
    }

    @Test
    fun v2_exchanges_error_must_return_null() {
        CryptohopperV2Exchange.getAllExchanges { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
        }
    }

    @Test
    fun v2_signals_error_must_return_null() {
        CryptohopperV2Signal.getSignals("binance") { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
        }
    }

    @Test
    fun when_the_given_getExchangeDetails_Endpoint_is_called_with_correct_token_then_it_must_return_list() {
        CryptohopperExchange.getExchangeDetails { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
            Assert.assertTrue(result?.javaClass?.name == "java.util.ArrayList")
            Assert.assertFalse(result?.javaClass?.name == "java.util.Object")

            if (result.isNullOrEmpty()) {
                Assert.assertNotNull(result?.get(0)?.exchangeKey)
                Assert.assertNotNull(result?.get(0)?.name)
                Assert.assertNotNull(result?.get(0)?.description)
                Assert.assertNotNull(result?.get(0)?.logo)
                Assert.assertNotNull(result?.get(0)?.apiLink)
                Assert.assertNotNull(result?.get(0)?.defaultBaseCurrency)
            }
        }
    }

    @Test
    fun when_the_given_getExchangeForexRates_Endpoint_is_called_with_correct_token_then_it_must_return_list() {
        CryptohopperExchange.getExchangeForexRates { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
            Assert.assertTrue(result?.javaClass?.name == "java.util.ArrayList")
            Assert.assertFalse(result?.javaClass?.name == "java.util.Object")
            if (result.isNullOrEmpty()) {
                Assert.assertNotNull(result?.get(0)?.currency)
                Assert.assertNotNull(result?.get(0)?.quoteCurrency)
                Assert.assertNotNull(result?.get(0)?.exchangeRate)
            }
        }
    }

    @Test
    fun when_the_given_getBaseCurrenciesFromExchange_Endpoint_is_called_with_the_correct_exchangeKey_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getBaseCurrenciesFromExchange(it.exchangeKey!!) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)
                }
            }
        }
    }


    @Test
    fun when_the_given_getBaseCurrencyFromExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getBaseCurrencyFromExchange(
                    it.exchangeKey!!,
                    it.defaultBaseCurrency!!
                ) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)
                }
            }
        }
    }

    @Test
    fun when_the_given_getAvailableCurrenciesForExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getAvailableCurrenciesForExchange(it.exchangeKey!!) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)
                }
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrenciesOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getPrecisionForCurrenciesOfExchange(it.exchangeKey!!) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)
                }
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrencyOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getPrecisionForCurrencyOfExchange(
                    it.exchangeKey!!,
                    "btc"
                ) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)
                }
            }
        }
    }

    @Test
    fun when_the_given_getSingleCurrencyOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getSingleCurrencyOfExchange(
                    it.exchangeKey!!,
                    it.defaultBaseCurrency!!
                ) { baseCurrencies, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(baseCurrencies)

                    Assert.assertNotNull(baseCurrencies?.id)
                    Assert.assertNotNull(baseCurrencies?.name)
                }
            }
        }
    }

    @Test
    fun when_the_given_getTradingPairOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getTradingPairOfExchange(
                    it.exchangeKey!!,
                    "btc",
                    it.defaultBaseCurrency!!
                ) { pairCode, baseCurrenciesError ->
                    Assert.assertNull(baseCurrenciesError)
                    Assert.assertNotNull(pairCode)
                }
            }
        }
    }

    @Test
    fun when_the_given_getMarketsOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            result?.forEach {
                CryptohopperExchange.getMarketsOfExchange(
                    it.exchangeKey!!
                ) { markets, marketError ->
                    Assert.assertNull(marketError)
                    Assert.assertNotNull(markets)

                    if (markets?.isNotEmpty() == true)
                        Assert.assertNotNull(markets[0])
                }
            }
        }
    }

    @Test
    fun when_the_given_getPriceAndAmountOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            CryptohopperExchange.getMarketsOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { markets, _ ->
                CryptohopperExchange.getPriceAndAmountOfExchange(
                    result?.get(0)?.exchangeKey ?: "",
                    markets?.get(0) ?: ""
                ) { exchangeAmountResponse, exchangeAmountError ->
                    Assert.assertNull(exchangeAmountError)
                    Assert.assertNotNull(exchangeAmountResponse)
                }
            }
        }
    }

    @Test
    fun when_the_given_getAllTickersOfExchange_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            CryptohopperExchange.getAllTickersOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { pairTickers, pairTickersError ->
                Assert.assertNull(pairTickersError)
                Assert.assertNotNull(pairTickers)
            }
        }
    }

    @Test
    fun when_the_given_getExchangeTickerPair_Endpoint_is_called_with_the_correct_data_then_it_must_return_response() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            CryptohopperExchange.getAllTickersOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { pairTickers, _ ->
                CryptohopperExchange.getExchangeTickerPair(
                    result?.get(0)?.exchangeKey ?: "",
                    pairTickers?.values?.toTypedArray()?.get(0)?.currencyPair.toString()
                ) { ticker, pairTickersError ->
                    Assert.assertNull(pairTickersError)
                    Assert.assertNotNull(ticker)
                }
            }
        }
    }
}