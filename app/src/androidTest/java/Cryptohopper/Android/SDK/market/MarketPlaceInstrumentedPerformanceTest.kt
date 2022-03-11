package Cryptohopper.Android.SDK.exchange

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
class MarketPlaceInstrumentedPerformanceTest {

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

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getHomePage_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperMarketplace.getHomePage { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_downloadItem_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.downloadItem(
                marketPlaces?.featuredHome?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getAvailableSignals_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperMarketplace.getAvailableSignals { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getReview(
                signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_updateReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.updateReview(
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_saveMarketReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperMarketplace.saveMarketReview(
                    marketplaceId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    marketItemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review",
                    rating = 5,
                    replyTo = signals?.get(0)?.reviews?.data?.get(0)?.replyTo?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_replyMarketReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperMarketplace.replyMarketReview(
                    reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                    itemId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    itemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review"
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_getSignal_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getSignal(signals?.get(0)?.id?.toInt() ?: 0) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getSignalDistribution_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getSignalDistribution(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getSignalChartData_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getSignalChartData(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getSignalPerformance_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getSignalPerformance(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getOneReviewForSignal_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getOneReviewForSignal(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getMarketplaceSeller_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getMarketplaceSeller(
                sellerId = signals?.get(0)?.sellerId ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_postSignalReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.postSignalReview(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getSignalStats_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getSignalStats(
                signalId = signals?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getAvailableStrategies_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperMarketplace.getAvailableStrategies { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getOneStrategyReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getOneStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewId = strategies?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_postStrategyReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.postStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getAvailableTemplates_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperMarketplace.getAvailableTemplates { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getMarketTemplate_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getMarketTemplate(
                templates?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplateReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.getOneTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewId = templates?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_postTemplateReview_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperMarketplace.postTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }
}