package Cryptohopper.Android.SDK.template

import Cryptohopper.Android.SDK.helper.Const
import Cryptohopper.Android.SDK.helper.Const.API_KEY
import Cryptohopper.Android.SDK.helper.Const.API_PASSWORD
import Cryptohopper.Android.SDK.helper.Const.API_USER
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
class TemplateInstrumentedTest {

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
    fun when_the_given_getTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {
        CryptohopperTemplate.getTemplates { templates, error ->
            Assert.assertNotNull(templates)
            Assert.assertNull(error)

            Assert.assertNotNull(templates?.get(0)?.templateId)
            Assert.assertNotNull(templates?.get(0)?.type)
            Assert.assertNotNull(templates?.get(0)?.itemId)
            Assert.assertNotNull(templates?.get(0)?.name)
            Assert.assertNotNull(templates?.get(0)?.description)
            Assert.assertNotNull(templates?.get(0)?.logo)
            Assert.assertNotNull(templates?.get(0)?.exchange)
            Assert.assertNotNull(templates?.get(0)?.baseCurrency)
            Assert.assertNotNull(templates?.get(0)?.currencies)
            Assert.assertNotNull(templates?.get(0)?.hiddenConfig)
            Assert.assertNotNull(templates?.get(0)?.hasTriggers)
            Assert.assertNotNull(templates?.get(0)?.hasConfigPool)
            Assert.assertNotNull(templates?.get(0)?.hasSignals)
            Assert.assertNotNull(templates?.get(0)?.createdDate)
            Assert.assertNotNull(templates?.get(0)?.price)
            Assert.assertNotNull(templates?.get(0)?.priceCurrency)
        }
    }

    @Test
    fun when_the_given_getBasicTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {
        CryptohopperTemplate.getBasicTemplates { templates, error ->
            Assert.assertNotNull(templates)
            Assert.assertNull(error)

            Assert.assertNotNull(templates?.get(0)?.id)
            Assert.assertNotNull(templates?.get(0)?.baseCurrency)
            Assert.assertNotNull(templates?.get(0)?.name)
            Assert.assertNotNull(templates?.get(0)?.image)
            Assert.assertNotNull(templates?.get(0)?.coins)
            Assert.assertNotNull(templates?.get(0)?.botType)
        }
    }

    @Test
    fun when_the_given_getBasicTemplateForExchange_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {

        CryptohopperExchange.getExchangeDetails { exchanges, _ ->

            CryptohopperTemplate.getBasicTemplateForExchange(
                exchanges?.get(0)?.exchangeKey ?: ""
            ) { templates, error ->
                Assert.assertNotNull(templates)
                Assert.assertNull(error)

                Assert.assertNotNull(templates?.get(0)?.id)
                Assert.assertNotNull(templates?.get(0)?.baseCurrency)
                Assert.assertNotNull(templates?.get(0)?.name)
                Assert.assertNotNull(templates?.get(0)?.image)
                Assert.assertNotNull(templates?.get(0)?.coins)
                Assert.assertNotNull(templates?.get(0)?.botType)
            }
        }
    }

    @Test
    fun when_the_given_getOneTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->
            Assert.assertNotNull(templates)

            CryptohopperTemplate.getOneTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { template, error ->

                Assert.assertNotNull(template)
                Assert.assertNull(error)

                Assert.assertTrue(template?.templateId == templates?.get(0)?.templateId)
                Assert.assertNotNull(template?.templateId)
                Assert.assertNotNull(template?.baseCurrency)
                Assert.assertNotNull(template?.name)
                Assert.assertNotNull(template?.itemId)
                Assert.assertNotNull(template?.type)
                Assert.assertNotNull(template?.description)
                Assert.assertNotNull(template?.logo)
                Assert.assertNotNull(template?.exchange)
                Assert.assertNotNull(template?.baseCurrency)
                Assert.assertNotNull(template?.currencies)
                Assert.assertNotNull(template?.hiddenConfig)
                Assert.assertNotNull(template?.hasTriggers)
            }
        }
    }

    @Test
    fun when_the_given_saveTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->

            CryptohopperTemplate.saveTemplate(
                hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                saveAs = 1,
                name = "CH-Test Template",
                description = "CH-Test Template by Test User"
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)
            }
        }
    }

    @Test
    fun when_the_given_loadTemplateIntoHopper_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperHopper.getAllHoppers(null, null, null) { hoppers, _ ->
            CryptohopperTemplate.getTemplates { templates, _ ->
                CryptohopperTemplate.loadTemplateIntoHopper(
                    hopperId = hoppers?.get(0)?.id?.toInt() ?: 0,
                    templateId = templates?.get(0)?.templateId?.toInt() ?: 0
                ) { response, error ->
                    Assert.assertNotNull(response)
                    Assert.assertNull(error)
                }
            }
        }
    }

    @Test
    fun when_the_given_changeImageOfTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_available_template_details() {
        CryptohopperTemplate.getTemplates { templates, _ ->

            CryptohopperTemplate.changeImageOfTemplate(
                templateId = templates?.get(0)?.templateId?.toInt() ?: 0,
                image = "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg"
            ) { response, error ->
                Assert.assertNotNull(response)
                Assert.assertNull(error)

                CryptohopperTemplate.getOneTemplate(
                    templates?.get(0)?.templateId?.toInt() ?: 0
                ) { template, _ ->
                    Assert.assertNotNull(template)
                    if (template?.templateId == templates?.get(0)?.templateId) {
                        Assert.assertTrue(template?.logo == "https://www.cryptohopper.com/templates/hopper_admin/assets/images/new/logo-dark.svg")
                    }
                }
            }
        }
    }

    @Test
    fun when_the_given_getMarketTemplates_Endpoint_is_called_with_correct_token_then_it_must_return_templates() {
        CryptohopperTemplate.getMarketTemplates { templates, error ->
            Assert.assertNotNull(templates)
            Assert.assertNull(error)

            Assert.assertNotNull(templates?.get(0)?.templateId)
            Assert.assertNotNull(templates?.get(0)?.type)
            Assert.assertNotNull(templates?.get(0)?.itemId)
            Assert.assertNotNull(templates?.get(0)?.name)
            Assert.assertNotNull(templates?.get(0)?.description)
            Assert.assertNotNull(templates?.get(0)?.logo)
            Assert.assertNotNull(templates?.get(0)?.exchange)
            Assert.assertNotNull(templates?.get(0)?.baseCurrency)
            Assert.assertNotNull(templates?.get(0)?.currencies)
            Assert.assertNotNull(templates?.get(0)?.hiddenConfig)
            Assert.assertNotNull(templates?.get(0)?.hasTriggers)
            Assert.assertNotNull(templates?.get(0)?.hasConfigPool)
            Assert.assertNotNull(templates?.get(0)?.hasSignals)
            Assert.assertNotNull(templates?.get(0)?.createdDate)
            Assert.assertNotNull(templates?.get(0)?.price)
            Assert.assertNotNull(templates?.get(0)?.priceCurrency)
        }
    }

    @Test
    fun when_the_given_getOneMarketTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_template_details() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->
            CryptohopperTemplate.getOneMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { template, error ->
                Assert.assertNotNull(template)
                Assert.assertNull(error)

                Assert.assertTrue(template?.templateId == templates?.get(0)?.templateId)
                Assert.assertNotNull(template?.templateId)
                Assert.assertNotNull(template?.type)
                Assert.assertNotNull(template?.itemId)
                Assert.assertNotNull(template?.name)
                Assert.assertNotNull(template?.description)
                Assert.assertNotNull(template?.logo)
                Assert.assertNotNull(template?.exchange)
                Assert.assertNotNull(template?.baseCurrency)
                Assert.assertNotNull(template?.currencies)
                Assert.assertNotNull(template?.hiddenConfig)
                Assert.assertNotNull(template?.hasTriggers)
                Assert.assertNotNull(template?.hasConfigPool)
                Assert.assertNotNull(template?.hasSignals)
                Assert.assertNotNull(template?.createdDate)
                Assert.assertNotNull(template?.price)
                Assert.assertNotNull(template?.priceCurrency)
            }
        }
    }

    @Test
    fun when_the_given_deleteMarketTemplate_Endpoint_is_called_with_correct_token_then_it_must_return_response() {
        CryptohopperTemplate.getMarketTemplates { templates, _ ->
            CryptohopperTemplate.deleteMarketTemplate(
                templates?.get(0)?.templateId?.toInt() ?: 0
            ) { _, error ->
                Assert.assertNull(error)
            }
        }
    }
}