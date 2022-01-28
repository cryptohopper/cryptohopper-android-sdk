package Cryptohopper.Android.SDK.market

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.StringGenerator
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before


@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class MarketPlaceInstrumentedNegativeTest {

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

    //******************* Positive cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getHomePage_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getHomePage { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_downloadItem_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.downloadItem(
                marketPlaces?.featuredHome?.get(0)?.id ?: ""
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableSignals_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getReview(
                signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_updateReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.updateReview(
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_saveMarketReview_Endpoint_is_called_with_incorrect_token_and_data_then_it_must_return_error() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->
                CryptohopperMarketplace.saveMarketReview(
                    marketplaceId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    marketItemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review",
                    rating = 5,
                    replyTo = signals?.get(0)?.reviews?.data?.get(0)?.replyTo?.toInt() ?: 0
                ) { _, error ->
                    Assert.assertNotNull(error)
                }
            }
        }
    }

    @Test
    fun when_the_given_replyMarketReview_Endpoint_is_called_with_incorrect_token_and_data_then_it_must_return_error() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->
                CryptohopperMarketplace.replyMarketReview(
                    reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                    itemId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    itemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review"
                ) { _, error ->
                    Assert.assertNotNull(error)
                }
            }
        }
    }

    @Test
    fun when_the_given_getSignal_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignal(signals?.get(0)?.id?.toInt() ?: 0) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalDistribution_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalDistribution(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalChartData_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalChartData(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalPerformance_Endpoint_is_called_with_incorrect_token_then_it_must_return_available_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalPerformance(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getOneReviewForSignal_Endpoint_is_called_with_incorrect_token_then_it_must_return_available_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getOneReviewForSignal(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getMarketplaceSeller_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getMarketplaceSeller(
                sellerId = signals?.get(0)?.sellerId ?: ""
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_postSignalReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.postSignalReview(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalStats_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalStats(
                signalId = signals?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableStrategies_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableStrategies { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getOneStrategyReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.getOneStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewId = strategies?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_postStrategyReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.postStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableTemplates_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableTemplates { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getMarketTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.getMarketTemplate(
                templates?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplateReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.getOneTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewId = templates?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_postTemplateReview_Endpoint_is_called_with_incorrect_token_then_it_must_return_error() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.postTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }
}