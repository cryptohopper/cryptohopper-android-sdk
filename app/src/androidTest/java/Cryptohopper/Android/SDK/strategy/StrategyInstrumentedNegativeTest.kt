package Cryptohopper.Android.SDK.strategy

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.StringGenerator
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class StrategyInstrumentedNegativeTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )
        callAuthenticationWithMockDetails()
    }

    private fun callAuthenticationWithMockDetails() {
        val username = StringGenerator.getRandomString()
        val userAgent = Aes256.encrypt(username, Const.API_AGENT)
        CryptohopperAuth.login(
            username = username,
            password = StringGenerator.getRandomString(),
            verificationCode = null,
            userAgent = userAgent
        ) { _, _ ->

        }
    }

    //******************* negative cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {
        CryptohopperStrategy.getStrategies { response, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(response)
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_Strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_updateStrategy_Endpoint_is_called_with_correct_token_then_it_update_strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.updateStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                name = "CH_TEST_STRATEGY",
                description = "CH_TEST_STRATEGY",
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg",
                minBuys = 1,
                minSells = 1
            ) { _, _ ->
                CryptohopperStrategy.getStrategy(
                    strategies?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNotNull(error)
                    Assert.assertNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_changeImageOfStrategy_Endpoint_is_called_with_correct_token_then_it_update_image() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.changeImageOfStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_deleteStrategy_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.deleteStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {
        CryptohopperStrategy.getMarketStrategies { response, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(response)
        }
    }

    @Test
    fun when_the_given_getMarketStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_marketStrategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->
            CryptohopperStrategy.getMarketStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->
            CryptohopperStrategy.deleteMarketStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }
}