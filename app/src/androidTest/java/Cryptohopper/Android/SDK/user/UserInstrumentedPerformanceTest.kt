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
import CryptohopperUser
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import kotlin.random.Random

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserInstrumentedPerformanceTest {
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
    fun when_the_given_getUserProfile_Endpoint_is_called_with_correct_token_then_it_must_return_profile_details() {
        callAuthenticationWithAccurateDetails()
        GlobalScope.launch {
            async {
                timeLapsCalculator.startTimer()
                CryptohopperUser.getUserProfile { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime >= timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_forgetPassword_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_data() {
        timeLapsCalculator.startTimer()
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperUser.forgetPassword(
            email = Const.API_EMAIL,
            userAgent = userAgent
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime >= timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_updateUserProfile_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_data() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.updateUserProfile(
            name = "Dawar Malik",
            addressOne = "124, Avery court",
            addressTwo = "Gzira-II, Malta",
            city = "Gzira",
            region = "Malta",
            country = "Malta",
            postalCode = "GZ-1043",
            phone = "+35699957661",
            website = "www.github.com/malikdawar"
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime >= timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getAvailableCredits_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getAvailableCredits { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getMobilePushNotificationPrefs_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getMobilePushNotificationPrefs { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_updateMobilePushNotificationPrefs_Endpoint_is_called_with_correct_param_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.updateMobilePushNotificationPrefs(HashMap<String, String>().also {
            it["Trigger"] = "on_trigger"
        }) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserEmail_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserEmail { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_changeEmail_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.changeEmail(Const.API_EMAIL) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserId_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserId { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserNotifications_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_list() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserNotifications { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_enableMobilePushNotification_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.enableMobilePushNotification(
            enableAll = Random.nextBoolean(),
            listOf()
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime >= timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_changePassword_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.changePassword(
            API_PASSWORD
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserPurchases_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserPurchases { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_resendActivationEmail_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.resendActivationEmail(
            email = Const.API_EMAIL,
            username = API_USER
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserTransactions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserTransactions { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getUserMetadata_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getUserMetadata { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    // ------------- Subscription ----------------------------------------

    @Test
    fun when_the_given_getAllUserSubscriptions_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getAllUserSubscriptions { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        GlobalScope.launch {
            CryptohopperUser.getAllUserSubscriptions { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getAllSubscriptionPlans_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        CryptohopperUser.getAllSubscriptionPlans { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getOneSubscriptionPlan_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        timeLapsCalculator.startTimer()
        GlobalScope.launch {
            CryptohopperUser.getAllSubscriptionPlans { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }
}