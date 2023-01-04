package Cryptohopper.Android.SDK.exchange

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import CryptohopperHopper
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
            userAgent = userAgent,
            "",
            "Android"
        ) { _, _ ->

        }
    }

    //******************* Positive cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getAllHoppers_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_list() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, error ->
            Assert.assertNotNull(hoppers)
            Assert.assertNull(error)

            Assert.assertNotNull(hoppers?.size)
            Assert.assertNotNull(hoppers?.get(0)?.id)
            Assert.assertNotNull(hoppers?.get(0)?.id)
            Assert.assertNotNull(hoppers?.get(0)?.name)
            Assert.assertNotNull(hoppers?.get(0)?.botType)
            Assert.assertNotNull(hoppers?.get(0)?.baseCurrency)

        }
    }

    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_specific_hopper() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getHopper(
                hoppers?.get(0)?.id ?: ""
            ) { hopper, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(hopper)

                Assert.assertNotNull(hopper?.id)
                Assert.assertNotNull(hopper?.name)
                Assert.assertNotNull(hopper?.botType)
                Assert.assertNotNull(hopper?.baseCurrency)
                Assert.assertNotNull(hopper?.userId)
            }
        }
    }

    @Test
    fun when_the_given_createHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_hopperId() {
        CryptohopperHopper.createHopper(
            name = API_USER, 1, null, null, null
        ) { response, error ->
            Assert.assertNotNull(response)
            Assert.assertNotNull(response?.id)
            Assert.assertNull(error)
        }
    }

    @Test
    fun when_the_given_updateHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.updateHopper(
                hoppers?.get(0)?.id ?: "",
                API_USER, null, null, null
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_deleteHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.deleteHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                //verify if the hoppers are DELETED or not
                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        Assert.assertFalse(it.id != hoppers?.get(0)?.id)
                    }
                }
            }
        }
    }


    @Test
    fun when_the_given_changeHopperImage_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.changeHopperImage(
                hoppers?.get(0)?.id ?: "",
                "https://cdn.cryptohopper.com/images/hoppers/binance.jpg"
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                //verify if the hoppers image updated or not
                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.image == "https://cdn.cryptohopper.com/images/hoppers/binance.jpg")
                        }
                    }
                }
            }
        }
    }


    @Test
    fun when_the_given_disableHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.disableHopper(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.enabled != 1)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_resetHopper_Endpoint_is_called_with_correct_id_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.resetHopper(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_setHopperAsDefault_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.setHopperAsDefault(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_disableHopperBuying_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.disableHopperBuying(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.buyingEnabled != 1)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_disableHopperPapertrading_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.disableHopperPapertrading(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.paperTrading != 1)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_disableHopperSelling_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.disableHopperSelling(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_enableHopper_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.enableHopper(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_enableHopperBuying_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.enableHopperBuying(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_enableHopperPaperTrading_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.enableHopperPapertrading(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.paperTrading == 1)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_enableHopperSelling_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.enableHopperSelling(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)

                CryptohopperHopper.getAllHoppers(null, null, null) { hopperList, _ ->
                    hopperList?.forEach {
                        if (it.id == hoppers?.get(0)?.id) {
                            Assert.assertTrue(it.sellingEnabled == 1)
                        }
                    }
                }
            }
        }
    }


    @Test
    fun when_the_given_getHopperMostTradedCurrency_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_hopperTradedCurrency() {
        CryptohopperHopper.getAllHoppers(null, null, null) { trendings, _ ->
            CryptohopperHopper.getHopperMostTradedCurrency(
                trendings?.get(0)?.id ?: ""
            ) { hopperTradedCurrency, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(hopperTradedCurrency)
            }
        }
    }

    @Test
    fun when_the_given_enableHopperPanic_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.enableHopperPanic(
                hoppers?.get(0)?.id ?: "",
                false
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    @Test
    fun when_the_given_disableHopperPanic_Endpoint_is_called_with_correct_params_and_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.disableHopperPanic(
                hoppers?.get(0)?.id ?: ""
            ) { data, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(data)
            }
        }
    }

    // ------------- ORDER ----------------------------------------

    @Test
    fun when_the_given_getAllOpenOrders_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_order_list() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(orders)

                Assert.assertNotNull(orders?.size)
                Assert.assertNotNull(orders?.get(0)?.id)
                Assert.assertNotNull(orders?.get(0)?.orderType)
                Assert.assertNotNull(orders?.get(0)?.orderId)
                Assert.assertNotNull(orders?.get(0)?.amount)
                Assert.assertNotNull(orders?.get(0)?.rate)
                Assert.assertNotNull(orders?.get(0)?.percentageProfit)
            }
        }
    }

    @Test
    fun when_the_given_getOneOpenOrder_Endpoint_is_called_with_correct_token_then_it_must_return_hopper_order_list() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->
                CryptohopperHopper.getOneOpenOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id ?: ""
                ) { order, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(order)

                    Assert.assertNotNull(order?.id)
                    Assert.assertNotNull(order?.orderType)
                    Assert.assertNotNull(order?.orderId)
                    Assert.assertNotNull(order?.amount)
                    Assert.assertNotNull(order?.rate)
                    Assert.assertNotNull(order?.percentageProfit)
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteMultipleOrders_Endpoint_is_called_with_correct_details_then_it_must_create_an_order() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->
                CryptohopperHopper.deleteMultipleOrders(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id?.toInt() ?: 0
                ) { order, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(order)
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteAllOpenOrders_Endpoint_is_called_with_correct_token_then_it_must_rreturn_response_successt() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.deleteAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }

    @Test
    fun when_the_given_getUnsyncedPositions_Endpoint_is_called_with_correct_token_then_it_must_rreturn_response_successt() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getUnsyncedPositions(
                hoppers?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)

                Assert.assertNotNull(response?.unsyned?.size)
                Assert.assertNotNull(response?.unsyned?.get(0)?.pair)
                Assert.assertNotNull(response?.unsyned?.get(0)?.currency)
                Assert.assertNotNull(response?.unsyned?.get(0)?.amount)
                Assert.assertNotNull(response?.unsyned?.get(0)?.rate)
            }
        }
    }

    @Test
    fun when_the_given_getHoldPositions_Endpoint_is_called_with_correct_token_then_it_must_rreturn_response_successt() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getHoldPositions(
                hoppers?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }

    @Test
    fun when_the_given_cancelTsbOrder_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->
                CryptohopperHopper.cancelTsbOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id?.toInt() ?: 0
                ) { order, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(order)
                }
            }
        }
    }

    @Test
    fun when_the_given_cancelOrder_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->
                CryptohopperHopper.cancelOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id?.toInt() ?: 0
                ) { order, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(order)
                }
            }
        }
    }

    @Test
    fun when_the_given_depositPaperTradingAccount_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.depositPapertradingAccount(
                hoppers?.get(0)?.id ?: "",
                "btc",
                0.0
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }

    @Test
    fun when_the_given_withdrawPapertTradingAccount_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.withdrawPapertradingAccount(
                hoppers?.get(0)?.id ?: "",
                "btc",
                0.0
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }


    @Test
    fun when_the_given_resetPaperTradingAccount_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.resetPapertradingAccount(
                hoppers?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }

    @Test
    fun when_the_given_getAllPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(positions)

                Assert.assertNotNull(positions?.size)
                Assert.assertNotNull(positions?.get(0)?.orderId)
                Assert.assertNotNull(positions?.get(0)?.id)
                Assert.assertNotNull(positions?.get(0)?.pair)
                Assert.assertNotNull(positions?.get(0)?.currency)
                Assert.assertNotNull(positions?.get(0)?.amount)
                Assert.assertNotNull(positions?.get(0)?.rate)
            }
        }
    }


    @Test
    fun when_the_given_getOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.getOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                    Assert.assertNotNull(response?.orderId)
                    Assert.assertNotNull(response?.id)
                    Assert.assertNotNull(response?.pair)
                    Assert.assertNotNull(response?.currency)
                    Assert.assertNotNull(response?.amount)
                    Assert.assertNotNull(response?.rate)
                }
            }
        }
    }

    @Test
    fun when_the_given_closeOneShortPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.closeOneShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_closeMultipleShortPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.closeMultipleShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_deleteMultipleShortPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.deleteMultipleShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }


    @Test
    fun when_the_given_deleteOneShortPosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.deleteOneShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_holdShortPosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.holdShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_holdOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.holdOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }


    @Test
    fun when_the_given_getReleasePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getReleasePositions(
                hoppers?.get(0)?.id ?: ""
            ) { response, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(response)
            }
        }
    }

    @Test
    fun when_the_given_releaseOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.releaseOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_releaseShortPosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.releaseShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }


    @Test
    fun when_the_given_releaseReservedPosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.releaseReservedPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_removeOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.removeOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_removeMultiplePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.removeMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_deletePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.deletePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_sellMultiplePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.sellMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf(),
                    false
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_sellOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.sellOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0,
                    false
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_takeProfit_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.takeProfit(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf(),
                    5
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_splitMultiplePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.splitMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_splitOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.splitOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_getShortPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getShortPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(positions)
            }
        }
    }

    @Test
    fun when_the_given_getAssets_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAssets(
                hoppers?.get(0)?.id ?: "",
                Random.nextBoolean()
            ) { assets, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(assets)
            }
        }
    }

    @Test
    fun when_the_given_getReservedPositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getReservedPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(positions)
            }
        }
    }

    @Test
    fun when_the_shortMultiplePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.shortMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_shortOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.shortOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_dcaOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.dcaOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0,
                    false
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_moveMultiplePositions_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.moveMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_moveOnePosition_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.moveOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_moveReservedPositionToOpen_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->
                CryptohopperHopper.moveReservedPositionToOpen(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_getSignalsInHopper_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(signals)
            }
        }
    }

    @Test
    fun when_the_getSignalById_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->
                CryptohopperHopper.getSignalById(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_subscribeToSignal_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->
                CryptohopperHopper.subscribeToSignal(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_unsubscribeFromSignal_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->
                CryptohopperHopper.unsubscribeFromSignal(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_getLastSignal_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getLastSignal(
                hoppers?.get(0)?.id ?: ""
            ) { signal, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(signal)
            }
        }
    }

    @Test
    fun when_the_getHopperStats_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getHopperStats(
                hoppers?.get(0)?.id ?: ""
            ) { stats, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(stats)
            }
        }
    }

    @Test
    fun when_the_getDashboardStats_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getDashboardStats(
                hoppers?.get(0)?.id ?: ""
            ) { stats, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(stats)
            }
        }
    }

    @Test
    fun when_the_resetHopperStats_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.resetHopperStats(
                hoppers?.get(0)?.id ?: ""
            ) { stats, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(stats)
            }
        }
    }

    @Test
    fun when_the_getSubscription_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSubscription(
                hoppers?.get(0)?.id ?: ""
            ) { subscription, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(subscription)

                Assert.assertNotNull(subscription?.hopperId)
                Assert.assertNotNull(subscription?.subscriptionId)
                Assert.assertNotNull(subscription?.subscriptionStatus)
                Assert.assertNotNull(subscription?.planName)
                Assert.assertNotNull(subscription?.planDescription)
                Assert.assertNotNull(subscription?.paymentTerm)
                Assert.assertNotNull(subscription?.paymentMethodId)
            }
        }
    }

    @Test
    fun when_the_reAssignSubscription_Endpoint_is_called_with_correct_details_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getSubscription(
                hoppers?.get(0)?.id ?: ""
            ) { subscription, _ ->
                CryptohopperHopper.reAssignSubscription(
                    subscription?.hopperId.toString(),
                    subscription?.subscriptionId ?: "",
                ) { assignedSubscription, error ->
                    Assert.assertNull(error)
                    Assert.assertNotNull(assignedSubscription)
                }
            }
        }
    }

    @Test
    fun when_the_getHopperActivityById_Endpoint_is_called_with_correct_details_then_it_return_hopper_activity() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperHopper.getHopperActivityById(
                hoppers?.get(0)?.id ?: ""
            ) { activity, error ->
                Assert.assertNull(error)
                Assert.assertNotNull(activity)
                Assert.assertNotNull(activity?.task)
                Assert.assertNotNull(activity?.start)
                Assert.assertNotNull(activity?.time)
            }
        }
    }
}