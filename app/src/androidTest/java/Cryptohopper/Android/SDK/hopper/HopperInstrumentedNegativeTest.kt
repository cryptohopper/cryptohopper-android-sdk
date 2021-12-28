package Cryptohopper.Android.SDK.exchange

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
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
class HopperInstrumentedNegativeTest {

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

    //******************* Negative cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getAllHoppers_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperHopper.getAllHoppers(null, null, null) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_createHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        CryptohopperHopper.createHopper(
            name = API_USER, null, null, null, null
        ) { _, error ->
            Assert.assertNotNull(error)
        }
    }

    @Test
    fun when_the_given_updateHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.updateHopper(
                        hoppers?.get(0)?.id ?: "",
                        API_USER, null, null, null
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.deleteHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_changeHopperImage_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.changeHopperImage(
                        hoppers?.get(0)?.id ?: "",
                        "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=height:120/https://www.filepicker.io/api/file/KZ1vBabDRwjKCnY7qCCc"
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_resetHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.resetHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_setHopperAsDefault_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.setHopperAsDefault(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperBuying_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperBuying(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperPapertrading_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperPapertrading(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperSelling_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperSelling(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperBuying_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperBuying(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperPapertrading_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperPapertrading(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperSelling_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperSelling(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_getHopperMostTradedCurrency_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { trendings, _ ->
                async {
                    CryptohopperHopper.getHopperMostTradedCurrency(
                        trendings?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperPanic_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperPanic(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperPanic_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperPanic(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    // ------------- ORDER ----------------------------------------

    @Test
    fun when_the_given_getAllOpenOrders_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getOneOpenOrder_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { orders, _ ->
                        async {
                            CryptohopperHopper.getOneOpenOrder(
                                hoppers?.get(0)?.id ?: "",
                                orders?.get(0)?.id ?: ""
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }
}