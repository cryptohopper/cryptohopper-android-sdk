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
import CryptohopperUser
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import kotlin.random.Random

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class UserInstrumentedTest {

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
        ) { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
        }
    }

    //******************* Positive cases ***************************

    @Test
    fun when_the_given_getUserProfile_Endpoint_is_called_with_correct_token_then_it_must_return_profile_details() {
        CryptohopperUser.getUserProfile { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)

            Assert.assertNotNull(result?.name!!)
            Assert.assertNotNull(result.username)
            Assert.assertNotNull(result.email)
            Assert.assertNotNull(result.country)
            Assert.assertNotNull(result.phone)
        }
    }

    @Test
    fun when_the_given_forgetPassword_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_data() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperUser.forgetPassword(
            email = Const.API_EMAIL,
            userAgent = userAgent
        ) { data, _ ->
            Assert.assertNotNull(data)
        }
    }

    @Test
    fun when_the_given_updateUserProfile_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_data() {
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
        ) { data, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(data)
        }
    }

    @Test
    fun when_the_given_getAvailableCredits_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperUser.getAvailableCredits { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
        }
    }

    @Test
    fun when_the_given_getMobilePushNotificationPrefs_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperUser.getMobilePushNotificationPrefs { result, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(result)
        }
    }

    @Test
    fun when_the_given_updateMobilePushNotificationPrefs_Endpoint_is_called_with_correct_param_then_it_must_return_response() {
        CryptohopperUser.updateMobilePushNotificationPrefs(HashMap<String, String>().also {
            it["Trigger"] = "on_trigger"
        }) { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_getUserEmail_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperUser.getUserEmail { email, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(email)
        }
    }

    @Test
    fun when_the_given_changeEmail_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_response() {
        CryptohopperUser.changeEmail(Const.API_EMAIL) { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_getUserId_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_response() {
        CryptohopperUser.getUserId { UserId, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(UserId)
        }
    }

    @Test
    fun when_the_given_getUserNotifications_Endpoint_is_called_with_correct_token_and_email_then_it_must_return_list() {
        CryptohopperUser.getUserNotifications { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_enableMobilePushNotification_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperUser.enableMobilePushNotification(
            enableAll = Random.nextBoolean(),
            listOf()
        ) { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_changePassword_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperUser.changePassword(
            API_PASSWORD
        ) { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_getUserPurchases_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperUser.getUserPurchases { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_resendActivationEmail_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperUser.resendActivationEmail(
            email = Const.API_EMAIL,
            username = API_USER
        ) { response, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun when_the_given_getUserTransactions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperUser.getUserTransactions { transactions, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(transactions)

            if (transactions?.isNullOrEmpty()?.not() == true) {
                Assert.assertNotNull(transactions[0].id)
            }
        }
    }

    @Test
    fun when_the_given_getUserMetadata_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperUser.getUserMetadata { metadata, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(metadata)

            Assert.assertNotNull(metadata?.id)
        }
    }

    // ------------- Subscription ----------------------------------------

    @Test
    fun when_the_given_getAllUserSubscriptions_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperUser.getAllUserSubscriptions { subscriptions, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(subscriptions)
        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperUser.getAllUserSubscriptions { subscriptions, _ ->
                async {
                    CryptohopperUser.getOneUserSubscriptions(
                        subscriptions?.get(0)?.subscriptionId?.toInt() ?: 0
                    ) { userSubscription, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(userSubscription)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getAllSubscriptionPlans_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperUser.getAllSubscriptionPlans { subscriptions, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(subscriptions)
        }
    }

    @Test
    fun when_the_given_getOneSubscriptionPlan_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperUser.getAllSubscriptionPlans { subscriptions, _ ->
                async {
                    CryptohopperUser.getOneSubscriptionPlan(
                        subscriptions?.get(0)?.planId?.toInt() ?: 0
                    ) { subscriptionPlan, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(subscriptionPlan)
                    }
                }
            }
        }
    }
}