import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperTemplate {

    companion object {

        // ------------- GENERAL ----------------------------------------


        /// Get Templates
        ///
        fun getTemplates(callback: (List<Template>?, HopperAPIError?) -> Unit) {
            HopperAPIGetTemplatesRequest("").request<HopperAPIGetTemplatesResponse>({ data ->
                callback(data.data?.templates, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Basic Templates
        ///
        fun getBasicTemplates(callback: (List<BasicTemplate>?, HopperAPIError?) -> Unit) {
            HopperAPIGetBasicTemplatesRequest("").request<HopperAPIGetBasicTemplatesResponse>({ data ->
                callback(data.basicTemplates, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Basic Templates For Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getBasicTemplateForExchange(
            exchange: String,
            callback: (List<BasicTemplate>?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetBasicTemplateForExchangeRequest(exchange).request<HopperAPIGetBasicTemplateForExchangeResponse>(
                { data ->
                    callback(data.basicTemplates, null)
                },
                { error ->
                    callback(null, error)
                })
        }


        /// Get One Template
        ///
        ///- Parameter templateId: (required) templateId
        fun getOneTemplate(templateId: Int, callback: (Template?, HopperAPIError?) -> Unit) {
            HopperAPIGetOneTemplateRequest(templateId).request<HopperAPIGetOneTemplateResponse>({ data ->
                callback(data.template, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Save Template
        ///
        ///- Parameter hopperId: (required) hopper id
        ///- Parameter saveAs: (required) save as
        ///- Parameter name: (required) name
        ///- Parameter description: (required) description
        fun saveTemplate(
            hopperId: Int,
            saveAs: Int,
            name: String,
            description: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPISaveTemplateRequest(
                hopperId,
                saveAs,
                name,
                description
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Delete Template
        ///
        ///- Parameter templateId: (required) templateId
        fun deleteTemplate(templateId: Int, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIDeleteTemplateRequest(templateId).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Change Image Of Template
        ///
        ///- Parameter templateId: (required) templateId
        ///- Parameter image: (required) image url
        fun changeImageOfTemplate(
            templateId: Int,
            image: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIChangeImageOfTemplateRequest(
                templateId,
                image
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Load Template into Hopper
        ///
        ///- Parameter templateId: (required) template id
        ///- Parameter hopperId: (required) hopper id
        fun loadTemplateIntoHopper(
            templateId: Int,
            hopperId: Int,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPILoadTemplateRequest(templateId, hopperId).request<HopperCommonMessageResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        // ------------- Market ----------------------------------------


        /// Get Market Templates
        ///
        fun getMarketTemplates(callback: (List<MarketTemplate>?, HopperAPIError?) -> Unit) {
            HopperAPIGetMarketTemplatesRequest("").request<HopperAPIGetMarketTemplatesResponse>({ data ->
                callback(data.data!!.templates, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get One Market Template
        ///
        ///- Parameter templateId: (required) templateId
        fun getOneMarketTemplate(
            templateId: Int,
            callback: (MarketTemplate?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetOneMarketTemplateRequest(templateId).request<HopperAPIGetOneMarketTemplateResponse>(
                { data ->
                    callback(data.template, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Delete Market Template
        ///
        ///- Parameter templateId: (required) templateId
        fun deleteMarketTemplate(templateId: Int, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIDeleteMarketTemplateRequest(templateId).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Load Market Template into Hopper
        ///
        ///- Parameter templateId: (required) template id
        ///- Parameter hopperId: (required) hopper id
        fun loadMarketTemplateIntoHopper(
            templateId: Int,
            hopperId: Int,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPILoadMarketTemplateRequest(
                templateId,
                hopperId
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

    }

}