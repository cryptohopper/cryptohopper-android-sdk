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
import kotlin.random.Random

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

    /////dawar

    @Test
    fun when_the_given_deleteMultipleOrders_Endpoint_is_called_with_incorrect_details_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { orders, _ ->
                        async {
                            CryptohopperHopper.deleteMultipleOrders(
                                hoppers?.get(0)?.id ?: "",
                                orders?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteAllOpenOrders_Endpoint_is_called_with_incorrect_details_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.deleteAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getUnsyncedPositions_Endpoint_is_called_with_incorrect_details_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getUnsyncedPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getHoldPositions_Endpoint_is_called_with_incorrect_details_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getHoldPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_cancelTsbOrder_Endpoint_is_called_with_incorrect_details_then_it_must_return_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { orders, _ ->
                        async {
                            CryptohopperHopper.cancelTsbOrder(
                                hoppers?.get(0)?.id ?: "",
                                orders?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_cancelOrder_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { orders, _ ->
                        async {
                            CryptohopperHopper.cancelOrder(
                                hoppers?.get(0)?.id ?: "",
                                orders?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_depositPapertradingAccount_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.depositPapertradingAccount(
                        hoppers?.get(0)?.id ?: "",
                        "btc",
                        0.0
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_withdrawPapertradingAccount_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.withdrawPapertradingAccount(
                        hoppers?.get(0)?.id ?: "",
                        "btc",
                        0.0
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_resetPapertradingAccount_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.resetPapertradingAccount(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getAllPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.getOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_closeOneShortPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.closeOneShortPositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_closeMultipleShortPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.closeMultipleShortPositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteMultipleShortPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.deleteMultipleShortPositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteOneShortPosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.deleteOneShortPosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_holdShortPosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.holdShortPosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_holdOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.holdOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getReleasePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getReleasePositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_releaseOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.releaseOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_releaseShortPosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.releaseShortPosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_releaseReservedPosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.releaseReservedPosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_removeOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.removeOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_removeMultiplePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.removeMultiplePositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deletePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.deletePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_sellMultiplePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.sellMultiplePositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_sellOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.sellOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_takeProfit_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.takeProfit(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf(),
                                5
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_splitMultiplePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.splitMultiplePositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_splitOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.splitOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getShortPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getShortPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getAssets_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAssets(
                        hoppers?.get(0)?.id ?: "",
                        Random.nextBoolean()
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getReservedPositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getReservedPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_shortMultiplePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.shortMultiplePositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_shortOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.shortOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_dcaOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.dcaOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_moveMultiplePositions_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.moveMultiplePositions(
                                hoppers?.get(0)?.id ?: "",
                                positions?.map {
                                    it.id?.toInt() ?: 0
                                } ?: arrayListOf()
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_moveOnePosition_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.moveOnePosition(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_moveReservedPositionToOpen_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllPositions(
                        hoppers?.get(0)?.id ?: ""
                    ) { positions, _ ->
                        async {
                            CryptohopperHopper.moveReservedPositionToOpen(
                                hoppers?.get(0)?.id ?: "",
                                positions?.get(0)?.id?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getSignalsInHopper_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSignalsInHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getSignalById_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSignalsInHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { signals, _ ->
                        async {
                            CryptohopperHopper.getSignalById(
                                hoppers?.get(0)?.id ?: "",
                                signals?.get(0)?.signalId?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_subscribeToSignal_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSignalsInHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { signals, _ ->
                        async {
                            CryptohopperHopper.subscribeToSignal(
                                hoppers?.get(0)?.id ?: "",
                                signals?.get(0)?.signalId?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_unsubscribeFromSignal_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSignalsInHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { signals, _ ->
                        async {
                            CryptohopperHopper.unsubscribeFromSignal(
                                hoppers?.get(0)?.id ?: "",
                                signals?.get(0)?.signalId?.toInt() ?: 0
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getLastSignal_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getLastSignal(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getHopperStats_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getHopperStats(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getDashboardStats_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getDashboardStats(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_resetHopperStats_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.resetHopperStats(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getSubscription_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSubscription(
                        hoppers?.get(0)?.id ?: ""
                    ) { _, error ->
                        Assert.assertNotNull(error)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_reAssignSubscription_Endpoint_is_called_with_incorrect_details_then_it_must_error() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getSubscription(
                        hoppers?.get(0)?.id ?: ""
                    ) { subscription, _ ->
                        async {
                            CryptohopperHopper.reAssignSubscription(
                                subscription?.hopperId.toString(),
                                subscription?.subscriptionId ?: "",
                            ) { _, error ->
                                Assert.assertNotNull(error)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_getHopperActivityById_Endpoint_is_called_with_incorrect_details_then_it_shouldnot_return_hopper_activity() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getHopperActivityById(
                hoppers?.get(0)?.id ?: ""
            ) { _, error ->
                Assert.assertNotNull(error)
            }
        }
    }
}