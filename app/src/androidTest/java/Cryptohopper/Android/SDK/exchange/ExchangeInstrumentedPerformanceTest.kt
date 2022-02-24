package Cryptohopper.Android.SDK.exchange

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.TimeLapsCalculator
import CryptohopperExchange
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ExchangeInstrumentedPerformanceTest {
    private val timeLapsCalculator = TimeLapsCalculator()

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )

        timeLapsCalculator.resetTimer()
        callAuthenticationWithAccurateDetails()
    }

    private fun callAuthenticationWithAccurateDetails() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = API_USER,
            password = API_PASSWORD,
            verificationCode = null,
            userAgent = userAgent
        ) { _, _ ->

        }
    }

    //******************* Positive cases ***************************

    @Test
    fun when_the_given_getUserProfile_Endpoint_is_called_with_correct_token_then_measure_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperExchange.getUserProfile { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getExchanges_Endpoint_is_called_with_correct_token_then_measure_response_timet() {

        timeLapsCalculator.startTimer()
        CryptohopperExchange.getExchanges { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getExchangeDetails_Endpoint_is_called_with_correct_token_then_measure_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperExchange.getExchangeDetails { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getExchangeForexRates_Endpoint_is_called_with_correct_token_then_measure_response_time() {
        timeLapsCalculator.startTimer()
        CryptohopperExchange.getExchangeForexRates { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getBaseCurrenciesFromExchange_Endpoint_is_called_with_the_correct_exchangeKey_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getBaseCurrenciesFromExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getBaseCurrencyFromExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getBaseCurrencyFromExchange(
                result?.get(0)?.exchangeKey ?: "",
                result?.get(0)?.defaultBaseCurrency ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getAvailableCurrenciesForExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getAvailableCurrenciesForExchange(
                result?.get(0)?.exchangeKey ?: "",
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrenciesOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getPrecisionForCurrenciesOfExchange(
                result?.get(0)?.exchangeKey ?: "",
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getPrecisionForCurrencyOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getPrecisionForCurrencyOfExchange(
                result?.get(0)?.exchangeKey ?: "",
                "btc"
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getSingleCurrencyOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getSingleCurrencyOfExchange(
                result?.get(0)?.exchangeKey ?: "",
                result?.get(0)?.defaultBaseCurrency ?: "",
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getTradingPairOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getTradingPairOfExchange(
                result?.get(0)?.exchangeKey ?: "",
                "btc",
                result?.get(0)?.defaultBaseCurrency ?: "",
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getMarketsOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getMarketsOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getPriceAndAmountOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            CryptohopperExchange.getMarketsOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { markets, _ ->
                timeLapsCalculator.startTimer()
                CryptohopperExchange.getPriceAndAmountOfExchange(
                    result?.get(0)?.exchangeKey ?: "",
                    markets?.get(0) ?: ""
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_getAllTickersOfExchange_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperExchange.getAllTickersOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getExchangeTickerPair_Endpoint_is_called_with_the_correct_data_then_measure_response_time() {
        CryptohopperExchange.getExchangeDetails { result, _ ->
            CryptohopperExchange.getAllTickersOfExchange(
                result?.get(0)?.exchangeKey ?: ""
            ) { pairTickers, _ ->
                timeLapsCalculator.startTimer()
                CryptohopperExchange.getExchangeTickerPair(
                    result?.get(0)?.exchangeKey ?: "",
                    pairTickers?.values?.toTypedArray()?.get(0)?.currencyPair.toString()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }
}