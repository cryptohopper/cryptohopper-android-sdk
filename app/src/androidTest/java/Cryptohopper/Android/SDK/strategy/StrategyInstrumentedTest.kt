package Cryptohopper.Android.SDK.strategy

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
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
class StrategyInstrumentedTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )
        callAuthenticationWithAccurateDetails()
    }

    private fun callAuthenticationWithAccurateDetails() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = API_USER,
            password = API_PASSWORD,
            verificationCode = null,
            userAgent = userAgent,
            "",
            "Android"
        ) { _, _ ->

        }
    }

    //******************* Positive cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {
        CryptohopperStrategy.getStrategies { strategies, error ->
            Assert.assertNotNull(strategies)
            Assert.assertNull(error)

            Assert.assertNotNull(strategies?.get(0)?.id)
            Assert.assertNotNull(strategies?.get(0)?.type)
            Assert.assertNotNull(strategies?.get(0)?.itemId)
            Assert.assertNotNull(strategies?.get(0)?.name)
            Assert.assertNotNull(strategies?.get(0)?.createdDate)
            Assert.assertNotNull(strategies?.get(0)?.logo)
            Assert.assertNotNull(strategies?.get(0)?.createdDate)
            Assert.assertNotNull(strategies?.get(0)?.price)
            Assert.assertNotNull(strategies?.get(0)?.priceCurrency)
            Assert.assertNotNull(strategies?.get(0)?.hiddenConfiguration)
            Assert.assertNotNull(strategies?.get(0)?.rating)
            Assert.assertNotNull(strategies?.get(0)?.sales)
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_Strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)

                Assert.assertNotNull(strategy?.id)
                Assert.assertNotNull(strategy?.type)
                Assert.assertNotNull(strategy?.itemId)
                Assert.assertNotNull(strategy?.name)
                Assert.assertNotNull(strategy?.logo)
                Assert.assertNotNull(strategy?.price)
                Assert.assertNotNull(strategy?.priceCurrency)
                Assert.assertNotNull(strategy?.hiddenConfiguration)
                Assert.assertNotNull(strategy?.rating)
                Assert.assertNotNull(strategy?.sales)

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
                ) { strategy, error ->
                    Assert.assertNotNull(strategy)
                    Assert.assertNull(error)
                    Assert.assertNotNull(strategy?.logo)
                    Assert.assertEquals(
                        strategy?.logo,
                        "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
                    )
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
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_deleteStrategy_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->
            CryptohopperStrategy.deleteStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {
        CryptohopperStrategy.getMarketStrategies { strategies, error ->
            Assert.assertNotNull(strategies)
            Assert.assertNull(error)

            Assert.assertNotNull(strategies?.get(0)?.id)
            Assert.assertNotNull(strategies?.get(0)?.type)
            Assert.assertNotNull(strategies?.get(0)?.itemId)
            Assert.assertNotNull(strategies?.get(0)?.name)
            Assert.assertNotNull(strategies?.get(0)?.createdDate)
            Assert.assertNotNull(strategies?.get(0)?.logo)
            Assert.assertNotNull(strategies?.get(0)?.createdDate)
            Assert.assertNotNull(strategies?.get(0)?.price)
            Assert.assertNotNull(strategies?.get(0)?.priceCurrency)
            Assert.assertNotNull(strategies?.get(0)?.hiddenConfiguration)
            Assert.assertNotNull(strategies?.get(0)?.rating)
            Assert.assertNotNull(strategies?.get(0)?.sales)
        }
    }

    @Test
    fun when_the_given_getMarketStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_marketStrategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->
            CryptohopperStrategy.getMarketStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)

                Assert.assertNotNull(strategy?.id)
                Assert.assertNotNull(strategy?.type)
                Assert.assertNotNull(strategy?.itemId)
                Assert.assertNotNull(strategy?.name)
                Assert.assertNotNull(strategy?.logo)
                Assert.assertNotNull(strategy?.price)
                Assert.assertNotNull(strategy?.priceCurrency)
                Assert.assertNotNull(strategy?.hiddenConfiguration)
                Assert.assertNotNull(strategy?.rating)
                Assert.assertNotNull(strategy?.sales)

            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->
            CryptohopperStrategy.deleteMarketStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)
            }
        }
    }
}