package Cryptohopper.Android.SDK.exchange

import CryptoHopperConfig
import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.TimeLapsCalculator
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
class HopperInstrumentedPerformanceTest {

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

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getAllHoppers_Endpoint_is_called_then_validate_the_response_time() {

        timeLapsCalculator.startTimer()
        CryptohopperHopper.getAllHoppers(null, null, null) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }


    @Test
    fun when_the_given_getOneUserSubscriptions_Endpoint_is_called_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_createHopper_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {
        timeLapsCalculator.startTimer()
        CryptohopperHopper.createHopper(
            name = API_USER, null, null, null, null
        ) { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_updateHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.updateHopper(
                hoppers?.get(0)?.id ?: "",
                API_USER, null, null, null
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_deleteHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.deleteHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_changeHopperImage_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.changeHopperImage(
                hoppers?.get(0)?.id ?: "",
                "https://process.fs.teachablecdn.com/ADNupMnWyR7kCWRvm76Laz/resize=height:120/https://www.filepicker.io/api/file/KZ1vBabDRwjKCnY7qCCc"
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_disableHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.disableHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_resetHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.resetHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_setHopperAsDefault_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.setHopperAsDefault(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_disableHopperBuying_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.disableHopperBuying(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_disableHopperPapertrading_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.disableHopperPapertrading(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_disableHopperSelling_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.disableHopperSelling(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_enableHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.enableHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_enableHopperBuying_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.enableHopperBuying(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_enableHopperPapertrading_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.enableHopperPapertrading(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_enableHopperSelling_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.enableHopperSelling(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getHopperMostTradedCurrency_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { trendings, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getHopperMostTradedCurrency(
                trendings?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_enableHopperPanic_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.enableHopperPanic(
                hoppers?.get(0)?.id ?: "",
                false
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_disableHopperPanic_Endpoint_is_called_with_correct_params_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.disableHopperPanic(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


// ------------- ORDER ----------------------------------------

    @Test
    fun when_the_given_getAllOpenOrders_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getOneOpenOrder_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.getOneOpenOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id ?: ""
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_deleteAllOpenOrders_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.deleteAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getUnsyncedPositions_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getUnsyncedPositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getHoldPositions_Endpoint_is_called_with_correct_token_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getHoldPositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_cancelTsbOrder_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.cancelTsbOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_cancelOrder_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllOpenOrders(
                hoppers?.get(0)?.id ?: ""
            ) { orders, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.cancelOrder(
                    hoppers?.get(0)?.id ?: "",
                    orders?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_depositPapertradingAccount_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.depositPapertradingAccount(
                hoppers?.get(0)?.id ?: "",
                "btc",
                0.0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_withdrawPapertradingAccount_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.withdrawPapertradingAccount(
                hoppers?.get(0)?.id ?: "",
                "btc",
                0.0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_resetPapertradingAccount_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.resetPapertradingAccount(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getAllPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.getOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_closeOneShortPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.closeOneShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_closeMultipleShortPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.closeMultipleShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_deleteMultipleShortPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.deleteMultipleShortPositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_deleteOneShortPosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.deleteOneShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_holdShortPosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.holdShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_holdOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.holdOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_getReleasePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getReleasePositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_releaseOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.releaseOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_releaseShortPosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.releaseShortPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_releaseReservedPosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.releaseReservedPosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_removeOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.removeOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_removeMultiplePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.removeMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_deletePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.deletePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_sellMultiplePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.sellMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_sellOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.sellOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_takeProfit_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.takeProfit(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf(),
                    5
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_splitMultiplePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.splitMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_splitOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.splitOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_given_getShortPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getShortPositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getAssets_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getAssets(
                hoppers?.get(0)?.id ?: "",
                Random.nextBoolean()
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_given_getReservedPositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getReservedPositions(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_shortMultiplePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.shortMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_shortOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.shortOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_dcaOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.dcaOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_moveMultiplePositions_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.moveMultiplePositions(
                    hoppers?.get(0)?.id ?: "",
                    positions?.map {
                        it.id?.toInt() ?: 0
                    } ?: arrayListOf()
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_moveOnePosition_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.moveOnePosition(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_moveReservedPositionToOpen_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getAllPositions(
                hoppers?.get(0)?.id ?: ""
            ) { positions, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.moveReservedPositionToOpen(
                    hoppers?.get(0)?.id ?: "",
                    positions?.get(0)?.id?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_getSignalsInHopper_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_getSignalById_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.getSignalById(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_subscribeToSignal_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.subscribeToSignal(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_unsubscribeFromSignal_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getSignalsInHopper(
                hoppers?.get(0)?.id ?: ""
            ) { signals, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.unsubscribeFromSignal(
                    hoppers?.get(0)?.id ?: "",
                    signals?.get(0)?.signalId?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_getLastSignal_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getLastSignal(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_getHopperStats_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getHopperStats(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_getDashboardStats_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getDashboardStats(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_resetHopperStats_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.resetHopperStats(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_getSubscription_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperHopper.getSubscription(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }


    @Test
    fun when_the_reAssignSubscription_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {

        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperHopper.getSubscription(
                hoppers?.get(0)?.id ?: ""
            ) { subscription, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperHopper.reAssignSubscription(
                    subscription?.hopperId.toString(),
                    subscription?.subscriptionId ?: "",
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }


    @Test
    fun when_the_getHopperActivityById_Endpoint_is_called_with_correct_details_then_validate_the_response_time() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            timeLapsCalculator.startTimer()
            CryptohopperHopper.getHopperActivityById(
                hoppers?.get(0)?.id ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }
}
