package Cryptohopper.Android.SDK.strategy

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.TimeLapsCalculator
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
class StrategyInstrumentedPerformanceTest {

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
            userAgent = userAgent,
            "",
            "Android"
        ) { _, _ ->

        }
    }

    // ------------- GENERAL ----------------------------------------

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {

        timeLapsCalculator.startTimer()
        CryptohopperStrategy.getStrategies { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_Strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperStrategy.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
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

                timeLapsCalculator.startTimer()
                CryptohopperStrategy.getStrategy(
                    strategies?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_changeImageOfStrategy_Endpoint_is_called_with_correct_token_then_it_update_image() {
        CryptohopperStrategy.getStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperStrategy.changeImageOfStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_deleteStrategy_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperStrategy.deleteStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_Strategies() {

        timeLapsCalculator.startTimer()
        CryptohopperStrategy.getMarketStrategies { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getMarketStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_marketStrategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperStrategy.getMarketStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getMarketStrategies_Endpoint_is_called_with_correct_token_then_it_delete_strategy() {
        CryptohopperStrategy.getMarketStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperStrategy.deleteMarketStrategy(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }
}