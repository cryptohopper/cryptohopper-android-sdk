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
import kotlinx.coroutines.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before

@DelicateCoroutinesApi
@RunWith(AndroidJUnit4::class)
class HopperInstrumentedTest {

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

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getAllHoppers_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_list() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, error ->
            Assert.assertNull(error)
            Assert.assertNotNull(hoppers)

            hoppers?.forEach {
                Assert.assertNotNull(it.id)
                Assert.assertNotNull(it.name)
                Assert.assertNotNull(it.baseCurrency)
                Assert.assertNotNull(it.buyingEnabled)
                Assert.assertNotNull(it.sellingEnabled)
                Assert.assertNotNull(it.enabled)
                Assert.assertNotNull(it.created)
                Assert.assertNotNull(it.startBalance)
                Assert.assertNotNull(it.subscriptionId)
                Assert.assertNotNull(it.statTime)
                Assert.assertNotNull(it.endTime)
                Assert.assertNotNull(it.subscriptionStatus)
                Assert.assertNotNull(it.autoRenewal)
                Assert.assertNotNull(it.subscription)
                Assert.assertNotNull(it.planName)
                Assert.assertNotNull(it.planDescription)
                Assert.assertNotNull(it.productId)
                Assert.assertNotNull(it.image)
                Assert.assertNotNull(it.userId)
                Assert.assertNotNull(it.paperTrading)
                Assert.assertNotNull(it.openPositionCount)
            }
        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_specific_hopper() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { hopper, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(hopper)

                        hopper?.let {
                            Assert.assertNotNull(it.id)
                            Assert.assertNotNull(it.name)
                            Assert.assertNotNull(it.baseCurrency)
                            Assert.assertNotNull(it.buyingEnabled)
                            Assert.assertNotNull(it.sellingEnabled)
                            Assert.assertNotNull(it.enabled)
                            Assert.assertNotNull(it.created)
                            Assert.assertNotNull(it.startBalance)
                            Assert.assertNotNull(it.subscriptionId)
                            Assert.assertNotNull(it.statTime)
                            Assert.assertNotNull(it.endTime)
                            Assert.assertNotNull(it.subscriptionStatus)
                            Assert.assertNotNull(it.autoRenewal)
                            Assert.assertNotNull(it.subscription)
                            Assert.assertNotNull(it.planName)
                            Assert.assertNotNull(it.planDescription)
                            Assert.assertNotNull(it.productId)
                            Assert.assertNotNull(it.image)
                            Assert.assertNotNull(it.userId)
                            Assert.assertNotNull(it.paperTrading)
                            Assert.assertNotNull(it.openPositionCount)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_createHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_hopperId() {
        CryptohopperHopper.createHopper(
            name = API_USER, null, null, null, null
        ) { hopperId, error ->
            Assert.assertNotNull(hopperId)
            Assert.assertNull(error)
        }
    }

    @Test
    fun when_the_given_updateHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.updateHopper(
                        hoppers?.get(0)?.id ?: "",
                        API_USER, null, null, null
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.deleteHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_changeHopperImage_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.changeHopperImage(
                        hoppers?.get(0)?.id ?: "",
                        "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=height:120/https://www.filepicker.io/api/file/KZ1vBabDRwjKCnY7qCCc"
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_resetHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.resetHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_setHopperAsDefault_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.setHopperAsDefault(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperBuying_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperBuying(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperPapertrading_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperPapertrading(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperSelling_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperSelling(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopper(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperBuying_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperBuying(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperPapertrading_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperPapertrading(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperSelling_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperSelling(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_getHopperMostTradedCurrency_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_hopperTradedCurrency() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { trendings, _ ->
                async {
                    CryptohopperHopper.getHopperMostTradedCurrency(
                        trendings?.get(0)?.id ?: ""
                    ) { hopperTradedCurrency, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(hopperTradedCurrency)

                        hopperTradedCurrency?.forEach {
                            Assert.assertNotNull(it.tradeAmount)
                            Assert.assertNotNull(it.currency)
                            Assert.assertNotNull(it.profit)
                            Assert.assertNotNull(it.averageHoldingTimeInHours)
                        }
                    }
                }
            }
        }
    }

    fun when_the_given_enableHopperPanic_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.enableHopperPanic(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    fun when_the_given_disableHopperPanic_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.disableHopperPanic(
                        hoppers?.get(0)?.id ?: ""
                    ) { data, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(data)
                    }
                }
            }
        }
    }

    // ------------- ORDER ----------------------------------------

    @Test
    fun when_the_given_getAllOpenOrders_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_order_list() {
        GlobalScope.launch {
            CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
                async {
                    CryptohopperHopper.getAllOpenOrders(
                        hoppers?.get(0)?.id ?: ""
                    ) { orders, error ->
                        Assert.assertNull(error)
                        Assert.assertNotNull(orders)

                        orders?.forEach {
                            Assert.assertNotNull(it.id)
                            Assert.assertNotNull(it.pair)
                            Assert.assertNotNull(it.orderType)
                            Assert.assertNotNull(it.orderId)
                            Assert.assertNotNull(it.orderTrigger)
                            Assert.assertNotNull(it.amount)
                            Assert.assertNotNull(it.rate)
                            Assert.assertNotNull(it.taValues)
                            Assert.assertNotNull(it.percentageProfit)
                            Assert.assertNotNull(it.hold)
                            Assert.assertNotNull(it.sold)
                            Assert.assertNotNull(it.openTime)
                            Assert.assertNotNull(it.closeTime)
                            Assert.assertNotNull(it.bundled)
                            Assert.assertNotNull(it.marketOrder)
                            Assert.assertNotNull(it.cost)
                            Assert.assertNotNull(it.date)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getOneOpenOrder_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_order_list() {
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
                            ) { order, error ->
                                Assert.assertNull(error)
                                Assert.assertNotNull(orders)
                                order?.let {
                                    Assert.assertNotNull(it.id)
                                    Assert.assertNotNull(it.pair)
                                    Assert.assertNotNull(it.orderType)
                                    Assert.assertNotNull(it.orderId)
                                    Assert.assertNotNull(it.orderTrigger)
                                    Assert.assertNotNull(it.amount)
                                    Assert.assertNotNull(it.rate)
                                    Assert.assertNotNull(it.taValues)
                                    Assert.assertNotNull(it.percentageProfit)
                                    Assert.assertNotNull(it.hold)
                                    Assert.assertNotNull(it.sold)
                                    Assert.assertNotNull(it.openTime)
                                    Assert.assertNotNull(it.closeTime)
                                    Assert.assertNotNull(it.bundled)
                                    Assert.assertNotNull(it.marketOrder)
                                    Assert.assertNotNull(it.cost)
                                    Assert.assertNotNull(it.date)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}