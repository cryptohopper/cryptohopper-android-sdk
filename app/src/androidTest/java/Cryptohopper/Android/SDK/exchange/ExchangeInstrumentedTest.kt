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
import HopperAPISessionManager
import android.util.Log
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ExchangeInstrumentedTest {

    private var shouldExecuteNegativeCase: Boolean = false

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )

        if (shouldExecuteNegativeCase.not())
            callAuthenticationWithAccurateDetails()
        else
            callAuthenticationWithMockDetails()

        shouldExecuteNegativeCase = false
    }

    private fun callAuthenticationWithAccurateDetails() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = API_USER,
            password = API_PASSWORD,
            verificationCode = null,
            userAgent = userAgent
        ) { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
            Assert.assertEquals("Successfully Logged In", result)
        }
    }

    private fun callAuthenticationWithMockDetails() {
        val userAgent =
            Aes256.encrypt(StringGenerator.getRandomString(), StringGenerator.getRandomString())
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
        GlobalScope.launch {
            CryptohopperExchange.getExchangeDetails { result, _ ->
                result?.forEach {
                    async {
                        CryptohopperExchange.getBaseCurrenciesFromExchange(it.exchangeKey!!) { baseCurrencies, baseCurrenciesError ->
                            Assert.assertNull(baseCurrenciesError)
                            Assert.assertNotNull(baseCurrencies)
                        }
                    }
                }
            }
        }
    }
}