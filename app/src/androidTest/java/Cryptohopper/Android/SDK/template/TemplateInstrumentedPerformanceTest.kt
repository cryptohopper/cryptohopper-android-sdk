package Cryptohopper.Android.SDK.template

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
import Cryptohopper.Android.SDK.helper.TimeLapsCalculator
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.mervick.aes_everywhere.Aes256
import cryptohopper.android.sdk.CryptohopperAuth
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class TemplateInstrumentedPerformanceTest {

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

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {

        timeLapsCalculator.startTimer()
        CryptohopperTemplate.getTemplates { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getBasicTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {

        timeLapsCalculator.startTimer()
        CryptohopperTemplate.getBasicTemplates { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getBasicTemplateForExchange_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {
        CryptohopperExchange.getExchangeDetails { exchanges, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.getBasicTemplateForExchange(
                exchanges?.get(0)?.exchangeKey ?: ""
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.getOneTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_saveTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.saveTemplate(
                hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                saveAs = 1,
                name = "CH-Test Template",
                description = "CH-Test Template by Test User"
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_loadTemplateIntoHopper_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperTemplate.getTemplates { templates, _ ->

                timeLapsCalculator.startTimer()
                CryptohopperTemplate.loadTemplateIntoHopper(
                    hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                    templateId = templates?.get(0)?.templateId?.toInt() ?: 0
                ) { _, _ ->
                    Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
                }
            }
        }
    }

    @Test
    fun when_the_given_changeImageOfTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.changeImageOfTemplate(
                templateId = templates?.get(0)?.templateId?.toInt() ?: 0,
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_getMarketTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {

        timeLapsCalculator.startTimer()
        CryptohopperTemplate.getMarketTemplates { _, _ ->
            Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
        }
    }

    @Test
    fun when_the_given_getOneMarketTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_template_details() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.getOneMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }

    @Test
    fun when_the_given_deleteMarketTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->

            timeLapsCalculator.startTimer()
            CryptohopperTemplate.deleteMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { _, _ ->
                Assert.assertTrue(TimeLapsCalculator.estimatedAPiResponseTime > timeLapsCalculator.getApiResponseTime())
            }
        }
    }
}