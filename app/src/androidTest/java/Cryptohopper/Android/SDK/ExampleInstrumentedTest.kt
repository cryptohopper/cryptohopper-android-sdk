package Cryptohopper.Android.SDK

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //assertEquals("Cryptohopper.Android.SDK", appContext.packageName)

        CryptoHopperConfig.configure(appContext,"lMRj9sd1gwWy4NxWUSG1MkBFc0yaf6mATeU2G73XE0vIN3EHVkJHFlnSmW3mobile9000",
                HopperAPIEnvironment.Production)

    }
}