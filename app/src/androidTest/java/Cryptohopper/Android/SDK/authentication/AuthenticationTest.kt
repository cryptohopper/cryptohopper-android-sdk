package Cryptohopper.Android.SDK.authentication

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.StringGenerator
import CryptohopperUser
import android.util.Log
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
class AuthenticationTest {

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        CryptoHopperConfig.configure(
            appContext, API_KEY,
            HopperAPIEnvironment.Production
        )

    }

    //******************* Negative cases ***************************

//    @Test
//    fun two_f_a_code_required_test(){
//        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
//        CryptohopperAuth.login(
//            username = API_USER,
//            password = API_PASSWORD,
//            verificationCode = null,
//            userAgent = userAgent
//        ) { _, error ->
//            Assert.assertNotNull(error)
//        }
//    }
//
//    @Test
//    fun two_f_a_code_not_null_test(){
//        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
//        CryptohopperAuth.login(
//            username = API_USER,
//            password = API_PASSWORD,
//            verificationCode = null,
//            userAgent = userAgent
//        ) { _, error ->
//            Assert.assertNotNull(error?.errCode)
//        }
//    }
//
//    @Test
//    fun two_f_a_code_missing_test(){
//        val userAgent = Aes256.encrypt(API_USER, Const.API_AGENT)
//        CryptohopperAuth.login(
//            username = API_USER,
//            password = API_PASSWORD,
//            verificationCode = null,
//            userAgent = userAgent
//        ) { _, error ->
//            Log.i("endpointcheck",error?.errCode.toString())
//            Assert.assertEquals(HopperError.ENDPOINT_FORBIDDEN, error?.errCode)
//        }
//    }

}