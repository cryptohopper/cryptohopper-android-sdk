
class CryptohopperTemplate {

    companion object {

        // ------------- GENERAL ----------------------------------------


        /// Get Templates
        ///
        fun getTemplates(callback: (List<Template>?, HopperError?) -> Unit) {
            HopperAPIGetTemplatesRequest("").request({ data ->
                    callback(data.data?.templates,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Basic Templates
        ///
        fun getBasicTemplates(callback: (List<BasicTemplate>?, HopperError?) -> Unit) {
            HopperAPIGetBasicTemplatesRequest("").request({ data ->
                    callback(data.basicTemplates,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get Basic Templates For Exchange
        ///
        ///- Parameter exchange: (required) exchange
        fun getBasicTemplateForExchange(exchange : String,callback: (List<BasicTemplate>?, HopperError?) -> Unit) {
            HopperAPIGetBasicTemplateForExchangeRequest( exchange).request({ data ->
                    callback(data.basicTemplates,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Get One Template
        ///
        ///- Parameter templateId: (required) templateId
        fun getOneTemplate(templateId : Int,callback: (Template?, HopperError?) -> Unit) {
            HopperAPIGetOneTemplateRequest( templateId).request({ data ->
                    callback(data.template,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Save Template
        ///
        ///- Parameter hopperId: (required) hopper id
        ///- Parameter saveAs: (required) save as
        ///- Parameter name: (required) name
        ///- Parameter description: (required) description
        fun saveTemplate(hopperId : Int,saveAs : Int,name : String,description : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPISaveTemplateRequest( hopperId,  saveAs,  name,  description).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }


        /// Delete Template
        ///
        ///- Parameter templateId: (required) templateId
        fun deleteTemplate(templateId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteTemplateRequest( templateId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Change Image Of Template
        ///
        ///- Parameter templateId: (required) templateId
        ///- Parameter image: (required) image url
        fun changeImageOfTemplate(templateId : Int,image: String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIChangeImageOfTemplateRequest( templateId, image).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Load Template into Hopper
        ///
        ///- Parameter templateId: (required) template id
        ///- Parameter hopperId: (required) hopper id
        fun loadTemplateIntoHopper(templateId : Int,hopperId: Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPILoadTemplateRequest( templateId, hopperId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        // ------------- Market ----------------------------------------


        /// Get Market Templates
        ///
        fun getMarketTemplates(callback: (List<MarketTemplate>?, HopperError?) -> Unit) {
            HopperAPIGetMarketTemplatesRequest("").request({ data ->
                    callback(data.data!!.templates,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Get One Market Template
        ///
        ///- Parameter templateId: (required) templateId
        fun getOneMarketTemplate(templateId : Int,callback: (MarketTemplate?, HopperError?) -> Unit) {
            HopperAPIGetOneMarketTemplateRequest( templateId).request({ data ->
                    callback(data.template,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Delete Market Template
        ///
        ///- Parameter templateId: (required) templateId
        fun deleteMarketTemplate(templateId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteMarketTemplateRequest( templateId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

        /// Load Market Template into Hopper
        ///
        ///- Parameter templateId: (required) template id
        ///- Parameter hopperId: (required) hopper id
        fun loadMarketTemplateIntoHopper(templateId : Int,hopperId: Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPILoadMarketTemplateRequest( templateId, hopperId).request({ data ->
                    callback(data.data,null)
            } , { error ->
                    callback(null,error)
            })
        }

    }

}