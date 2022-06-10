package Cryptohopper.Android.SDK.market

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import CryptohopperMarketplace
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MarketPlaceInstrumentedTest {

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
            userAgent = userAgent
        ) { _, _ ->

        }
    }

    //******************* Positive cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getHomePage_Endpoint_is_called_with_correct_token_then_it_must_return_market_places() {
        CryptohopperMarketplace.getHomePage { response, error ->
            Assert.assertNotNull(response)
            Assert.assertNull(error)

            Assert.assertNotNull(response?.featuredHome)
            Assert.assertNotNull(response?.homeEditorsPick)
            Assert.assertNotNull(response?.homeTopSignals)
            Assert.assertNotNull(response?.homeBestRatedStrategies)
            Assert.assertNotNull(response?.homeBestRatedTemplates)
            Assert.assertNotNull(response?.homeBestRatedSignals)


            Assert.assertNotNull(response?.featuredHome?.get(0)?.id)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.itemType)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.logo)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.name)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.description)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.rating)
            Assert.assertNotNull(response?.featuredHome?.get(0)?.price)
        }
    }

    @Test
    fun when_the_given_downloadItem_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.downloadItem(
                marketPlaces?.featuredHome?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableSignals_Endpoint_is_called_with_correct_token_then_it_must_return_available_signals() {
        CryptohopperMarketplace.getAvailableSignals { response, error ->
            Assert.assertNotNull(response)
            Assert.assertNull(error)

            Assert.assertNotNull(response?.get(0)?.id)
            Assert.assertNotNull(response?.get(0)?.signalId)
            Assert.assertNotNull(response?.get(0)?.planId)
            Assert.assertNotNull(response?.get(0)?.name)
            Assert.assertNotNull(response?.get(0)?.description)
            Assert.assertNotNull(response?.get(0)?.logo)
            Assert.assertNotNull(response?.get(0)?.type)
            Assert.assertNotNull(response?.get(0)?.featureImage)
            Assert.assertNotNull(response?.get(0)?.subscriptionFeeCurrency)
            Assert.assertNotNull(response?.get(0)?.subscription_fee)
            Assert.assertNotNull(response?.get(0)?.exchanges)
            Assert.assertNotNull(response?.get(0)?.rating)
            Assert.assertNotNull(response?.get(0)?.totalVotes)
            Assert.assertNotNull(response?.get(0)?.sellerId)
            Assert.assertNotNull(response?.get(0)?.sellerName)
            Assert.assertNotNull(response?.get(0)?.sellerLogo)
            Assert.assertNotNull(response?.get(0)?.reviews)
        }
    }

    @Test
    fun when_the_given_getReview_Endpoint_is_called_with_correct_token_then_it_must_return_review() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getReview(
                signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { review, error ->
                Assert.assertNotNull(review)
                Assert.assertNull(error)
                Assert.assertNotNull(review?.id)
                Assert.assertNotNull(review?.itemId)
                Assert.assertNotNull(review?.itemType)
                Assert.assertNotNull(review?.replyTo)
                Assert.assertNotNull(review?.reviewName)
                Assert.assertNotNull(review?.review)
                Assert.assertNotNull(review?.rating)
            }
        }
    }

    @Test
    fun when_the_given_updateReview_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.updateReview(
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { review, error ->
                Assert.assertNotNull(review)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_saveMarketReview_Endpoint_is_called_with_correct_token_and_data_then_it_must_return_response() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->
                CryptohopperMarketplace.saveMarketReview(
                    marketplaceId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    marketItemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review",
                    rating = 5,
                    replyTo = signals?.get(0)?.reviews?.data?.get(0)?.replyTo?.toInt() ?: 0
                ) { review, error ->
                    Assert.assertNotNull(review)
                    Assert.assertNull(error)
                }
            }
        }
    }

    @Test
    fun when_the_given_replyMarketReview_Endpoint_is_called_with_correct_token_and_data_then_it_must_return_response() {
        CryptohopperMarketplace.getHomePage { marketPlaces, _ ->
            CryptohopperMarketplace.getAvailableSignals { signals, _ ->
                CryptohopperMarketplace.replyMarketReview(
                    reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0,
                    itemId = marketPlaces?.featuredHome?.get(0)?.id?.toInt() ?: 0,
                    itemType = marketPlaces?.featuredHome?.get(0)?.itemType ?: "",
                    reviewName = "Test review",
                    review = "Test CH review"
                ) { review, error ->
                    Assert.assertNotNull(review)
                    Assert.assertNull(error)
                }
            }
        }
    }

    @Test
    fun when_the_given_getSignal_Endpoint_is_called_with_correct_token_then_it_must_return_available_signal() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignal(signals?.get(0)?.id?.toInt() ?: 0) { signal, error ->
                Assert.assertNotNull(signal)
                Assert.assertNull(error)

                Assert.assertNotNull(signal?.id)
                Assert.assertNotNull(signal?.signalId)
                Assert.assertNotNull(signal?.planId)
                Assert.assertNotNull(signal?.name)
                Assert.assertNotNull(signal?.description)
                Assert.assertNotNull(signal?.logo)
                Assert.assertNotNull(signal?.type)
                Assert.assertNotNull(signal?.featureImage)
                Assert.assertNotNull(signal?.subscriptionFeeCurrency)
                Assert.assertNotNull(signal?.subscription_fee)
                Assert.assertNotNull(signal?.exchanges)
                Assert.assertNotNull(signal?.rating)
                Assert.assertNotNull(signal?.totalVotes)
                Assert.assertNotNull(signal?.sellerId)
                Assert.assertNotNull(signal?.sellerName)
                Assert.assertNotNull(signal?.sellerLogo)
                Assert.assertNotNull(signal?.reviews)
            }
        }
    }

    @Test
    fun when_the_given_getSignalDistribution_Endpoint_is_called_with_correct_token_then_it_must_return_available_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalDistribution(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { distribution, error ->
                Assert.assertNotNull(distribution)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalChartData_Endpoint_is_called_with_correct_token_then_it_must_return_available_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalChartData(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalPerformance_Endpoint_is_called_with_correct_token_then_it_must_return_available_signal_performance() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalPerformance(
                signals?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)

                Assert.assertNotNull(response?.get(0)?.id)
                Assert.assertNotNull(response?.get(0)?.signalId)
                Assert.assertNotNull(response?.get(0)?.exchange)
                Assert.assertNotNull(response?.get(0)?.baseCurrency)
                Assert.assertNotNull(response?.get(0)?.currency)
                Assert.assertNotNull(response?.get(0)?.market)
                Assert.assertNotNull(response?.get(0)?.signalRate)
                Assert.assertNotNull(response?.get(0)?.result5min)
                Assert.assertNotNull(response?.get(0)?.result15min)
                Assert.assertNotNull(response?.get(0)?.resultHighest)
            }
        }
    }

    @Test
    fun when_the_given_getOneReviewForSignal_Endpoint_is_called_with_correct_token_then_it_must_return_available_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getOneReviewForSignal(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewId = signals?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getMarketplaceSeller_Endpoint_is_called_with_correct_token_then_it_must_return_available_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getMarketplaceSeller(
                sellerId = signals?.get(0)?.sellerId ?: ""
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_postSignalReview_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.postSignalReview(
                signalId = signals?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getSignalStats_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getAvailableSignals { signals, _ ->
            CryptohopperMarketplace.getSignalStats(
                signalId = signals?.get(0)?.id?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableStrategies_Endpoint_is_called_with_correct_token_then_it_must_return_strategies() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, error ->
            Assert.assertNotNull(strategies)
            Assert.assertNull(error)

            Assert.assertNotNull(strategies?.get(0)?.id)
            Assert.assertNotNull(strategies?.get(0)?.itemId)
            Assert.assertNotNull(strategies?.get(0)?.type)
            Assert.assertNotNull(strategies?.get(0)?.name)
            Assert.assertNotNull(strategies?.get(0)?.logo)
            Assert.assertNotNull(strategies?.get(0)?.featureImage)
            Assert.assertNotNull(strategies?.get(0)?.rating)
            Assert.assertNotNull(strategies?.get(0)?.totalVotes)
            Assert.assertNotNull(strategies?.get(0)?.priceId)
            Assert.assertNotNull(strategies?.get(0)?.baseCurrency)
            Assert.assertNotNull(strategies?.get(0)?.description)
            Assert.assertNotNull(strategies?.get(0)?.sellerName)
            Assert.assertNotNull(strategies?.get(0)?.sellerLogo)
        }
    }

    @Test
    fun when_the_given_getStrategy_Endpoint_is_called_with_correct_token_then_it_must_return_strategy() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.getStrategy(
                strategies?.get(0)?.id?.toInt() ?: 0
            ) { strategy, error ->
                Assert.assertNotNull(strategy)
                Assert.assertNull(error)

                Assert.assertNotNull(strategy?.id)
                Assert.assertNotNull(strategy?.itemId)
                Assert.assertNotNull(strategy?.type)
                Assert.assertNotNull(strategy?.name)
                Assert.assertNotNull(strategy?.logo)
                Assert.assertNotNull(strategy?.featureImage)
                Assert.assertNotNull(strategy?.rating)
                Assert.assertNotNull(strategy?.totalVotes)
                Assert.assertNotNull(strategy?.priceId)
                Assert.assertNotNull(strategy?.baseCurrency)
                Assert.assertNotNull(strategy?.description)
                Assert.assertNotNull(strategy?.sellerName)
                Assert.assertNotNull(strategy?.sellerLogo)
            }
        }
    }

    @Test
    fun when_the_given_getOneStrategyReview_Endpoint_is_called_with_correct_token_then_it_must_return_review() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.getOneStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewId = strategies?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { review, error ->
                Assert.assertNotNull(review)
                Assert.assertNull(error)

                Assert.assertNotNull(review?.id)
                Assert.assertNotNull(review?.itemId)
                Assert.assertNotNull(review?.itemType)
                Assert.assertNotNull(review?.replyTo)
                Assert.assertNotNull(review?.reviewName)
                Assert.assertNotNull(review?.review)
                Assert.assertNotNull(review?.rating)
            }
        }
    }

    @Test
    fun when_the_given_postStrategyReview_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getAvailableStrategies { strategies, _ ->
            CryptohopperMarketplace.postStrategyReview(
                strategyId = strategies?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { review, error ->
                Assert.assertNotNull(review)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAvailableTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {
        CryptohopperMarketplace.getAvailableTemplates { templates, error ->
            Assert.assertNotNull(templates)
            Assert.assertNull(error)

            Assert.assertNotNull(templates?.get(0)?.id)
            Assert.assertNotNull(templates?.get(0)?.itemId)
            Assert.assertNotNull(templates?.get(0)?.type)
            Assert.assertNotNull(templates?.get(0)?.name)
            Assert.assertNotNull(templates?.get(0)?.logo)
            Assert.assertNotNull(templates?.get(0)?.featureImage)
            Assert.assertNotNull(templates?.get(0)?.rating)
            Assert.assertNotNull(templates?.get(0)?.totalVotes)
            Assert.assertNotNull(templates?.get(0)?.sales)
            Assert.assertNotNull(templates?.get(0)?.priceId)
            Assert.assertNotNull(templates?.get(0)?.exchange)
            Assert.assertNotNull(templates?.get(0)?.baseCurrency)
            Assert.assertNotNull(templates?.get(0)?.version)
            Assert.assertNotNull(templates?.get(0)?.updated)
            Assert.assertNotNull(templates?.get(0)?.updateInfo)
            Assert.assertNotNull(templates?.get(0)?.description)
            Assert.assertNotNull(templates?.get(0)?.price)
            Assert.assertNotNull(templates?.get(0)?.sellerId)
            Assert.assertNotNull(templates?.get(0)?.sellerName)
            Assert.assertNotNull(templates?.get(0)?.sellerLogo)
        }
    }

    @Test
    fun when_the_given_getMarketTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_template() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.getMarketTemplate(
                templates?.get(0)?.id?.toInt() ?: 0
            ) { template, error ->
                Assert.assertNotNull(template)
                Assert.assertNull(error)

                Assert.assertNotNull(template?.id)
                Assert.assertNotNull(template?.itemId)
                Assert.assertNotNull(template?.type)
                Assert.assertNotNull(template?.name)
                Assert.assertNotNull(template?.logo)
                Assert.assertNotNull(template?.featureImage)
                Assert.assertNotNull(template?.rating)
                Assert.assertNotNull(template?.totalVotes)
                Assert.assertNotNull(template?.sales)
                Assert.assertNotNull(template?.priceId)
                Assert.assertNotNull(template?.exchange)
                Assert.assertNotNull(template?.baseCurrency)
                Assert.assertNotNull(template?.version)
                Assert.assertNotNull(template?.updated)
                Assert.assertNotNull(template?.updateInfo)
                Assert.assertNotNull(template?.description)
                Assert.assertNotNull(template?.price)
                Assert.assertNotNull(template?.sellerId)
                Assert.assertNotNull(template?.sellerName)
                Assert.assertNotNull(template?.sellerLogo)
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplateReview_Endpoint_is_called_with_correct_token_then_it_must_return_template_review() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.getOneTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewId = templates?.get(0)?.reviews?.data?.get(0)?.id?.toInt() ?: 0
            ) { review, error ->
                Assert.assertNotNull(review)
                Assert.assertNull(error)

                Assert.assertNotNull(review?.id)
                Assert.assertNotNull(review?.itemId)
                Assert.assertNotNull(review?.review)
                Assert.assertNotNull(review?.reviewName)
                Assert.assertNotNull(review?.rating)
                Assert.assertNotNull(review?.itemType)
            }
        }
    }

    @Test
    fun when_the_given_postTemplateReview_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperMarketplace.getAvailableTemplates { templates, _ ->
            CryptohopperMarketplace.postTemplateReview(
                templateId = templates?.get(0)?.id?.toInt() ?: 0,
                reviewName = "Test review",
                review = "Test CH review",
                rating = 5
            ) { template, error ->
                Assert.assertNotNull(template)
                Assert.assertNull(error)
            }
        }
    }
}