package Cryptohopper.Android.SDK.template

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
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
class TemplateInstrumentedNegativeTest {

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

    //******************* negative cases ***************************

    // ------------- GENERAL ----------------------------------------

    @Test
    fun when_the_given_getTemplates_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_templates() {
        CryptohopperTemplate.getTemplates { templates, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(templates)
        }
    }

    @Test
    fun when_the_given_getBasicTemplates_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_templates() {
        CryptohopperTemplate.getBasicTemplates { templates, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(templates)
        }
    }

    @Test
    fun when_the_given_getBasicTemplateForExchange_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_templates() {

        CryptohopperExchange.getExchangeDetails { exchanges, _ ->

            CryptohopperTemplate.getBasicTemplateForExchange(
                exchanges?.get(0)?.exchangeKey ?: ""
            ) { templates, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(templates)
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->
            Assert.assertNotNull(templates)

            CryptohopperTemplate.getOneTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { template, error ->

                Assert.assertNotNull(error)
                Assert.assertNull(template)
            }
        }
    }

    @Test
    fun when_the_given_saveTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperTemplate.saveTemplate(
                hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                saveAs = 1,
                name = "CH-Test Template",
                description = "CH-Test Template by Test User"
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_loadTemplateIntoHopper_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperTemplate.getTemplates { templates, _ ->
                CryptohopperTemplate.loadTemplateIntoHopper(
                    hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                    templateId = templates?.get(0)?.templateId?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNotNull(error)
                    Assert.assertNull(response)
                }
            }
        }
    }

    @Test
    fun when_the_given_changeImageOfTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->

            CryptohopperTemplate.changeImageOfTemplate(
                templateId = templates?.get(0)?.templateId?.toInt() ?: 0,
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_getMarketTemplates_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_templates() {
        CryptohopperTemplate.getMarketTemplates { response, error ->
            Assert.assertNotNull(error)
            Assert.assertNull(response)
        }
    }

    @Test
    fun when_the_given_getOneMarketTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_template_details() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->
            CryptohopperTemplate.getOneMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }

    @Test
    fun when_the_given_deleteMarketTemplate_Endpoint_is_called_with_incorrect_token_then_it_must_not_return_response() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->
            CryptohopperTemplate.deleteMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { response, error ->
                Assert.assertNotNull(error)
                Assert.assertNull(response)
            }
        }
    }
}