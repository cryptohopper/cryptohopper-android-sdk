package Cryptohopper.Android.SDK.exchange

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.StringGenerator
import CryptohopperUser
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
class UserInstrumentedNegativeTest {

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
        ) { result, error ->
            Assert.assertNull(result)
            Assert.assertNotNull(error)
        }
    }
    //******************* Negative cases ***************************

    @Test
    fun when_the_given_getUserProfile_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserProfile { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_forgetPassword_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperUser.forgetPassword(
            email = Const.API_EMAIL,
            userAgent = userAgent
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_updateUserProfile_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
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
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getAvailableCredits_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getAvailableCredits { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getMobilePushNotificationPrefs_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getMobilePushNotificationPrefs { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_updateMobilePushNotificationPrefs_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.updateMobilePushNotificationPrefs(HashMap<String, String>().also {
            it["Trigger"] = "on_trigger"
        }) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserEmail_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserEmail { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_changeEmail_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.changeEmail(Const.API_EMAIL) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserId_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserId { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserNotifications_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserNotifications { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_enableMobilePushNotification_Endpoint_is_called_incorrect_details_then_it_must_error() {
        CryptohopperUser.enableMobilePushNotification(
            enableAll = Random.nextBoolean(),
            listOf()
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_changePassword_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.changePassword(
            API_PASSWORD
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserPurchases_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserPurchases { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_resendActivationEmail_Endpoint_is_called_incorrect_details_then_it_must_error() {
        CryptohopperUser.resendActivationEmail(
            email = Const.API_EMAIL,
            username = API_USER
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserTransactions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserTransactions { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getUserMetadata_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getUserMetadata { _, error ->
            Assert.assertNotNull(error)
        }
    }

    // ------------- Subscription ----------------------------------------

    @Test
    fun when_the_given_getAllUserSubscriptions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getAllUserSubscriptions { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getAllUserSubscriptions { subscriptions, _ ->
            CryptohopperUser.getOneUserSubscriptions(
                subscriptions?.get(0)?.subscriptionId?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }

    @Test
    fun when_the_given_getAllSubscriptionPlans_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getAllSubscriptionPlans { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getOneSubscriptionPlan_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperUser.getAllSubscriptionPlans { subscriptions, _ ->
            CryptohopperUser.getOneSubscriptionPlan(
                subscriptions?.get(0)?.planId?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }
}