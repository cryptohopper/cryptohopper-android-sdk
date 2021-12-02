package Cryptohopper.Android.SDK

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
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class AuthInstrumentedTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )
    }

    @Test
    fun when_the_given_login_Endpoint_is_called_with_correct_details_then_it_must_be_successful() {
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

    @Test
    fun when_the_given_login_Endpoint_is_called_with_incorrect_details_then_it_must_not_be_successful() {
        val userAgent = Aes256.encrypt(StringGenerator.getRandomString(), StringGenerator.getRandomString())
        CryptohopperAuth.login(
            username = StringGenerator.getRandomString(),
            password = StringGenerator.getRandomString(),
            verificationCode = null,
            userAgent = userAgent
        ) { result, error ->
            Assert.assertNull(result)
            Assert.assertNotNull(error)
            Assert.assertEquals(HopperError.UNAUTHORIZED, error?.error)
            Assert.assertEquals(401, error?.errCode)
        }
    }

    @Test
    fun when_the_given_loginWithCode_Endpoint_is_called_with_forbidden_data_then_it_must_not_be_successful() {
        val userAgent = Aes256.encrypt(StringGenerator.getRandomString(), StringGenerator.getRandomString())
        CryptohopperAuth.loginWithCode(
            code = StringGenerator.getRandomString(),
            userAgent = userAgent
        ) { result, _ ->
            Assert.assertNotNull(result)
        }
    }

    @Test
    fun when_the_given_logout_fun_is_called_then_the_session_must_be_deleted() {
        CryptohopperAuth.logout()
        Assert.assertNull(HopperAPISessionManager.shared.session?.accessToken)
        Assert.assertFalse(HopperAPISessionManager.shared.hasSession)
    }

    @Test
    fun when_the_given_login_EndPoint_is_called_then_the_session_must_be_null() {
        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
        CryptohopperAuth.login(
            username = API_USER,
            password = API_PASSWORD,
            verificationCode = null,
            userAgent = userAgent
        ) { _, _ ->
            Assert.assertTrue(CryptohopperAuth.isAuthenticated())
            Assert.assertTrue(HopperAPISessionManager.shared.hasSession)
        }
    }
}