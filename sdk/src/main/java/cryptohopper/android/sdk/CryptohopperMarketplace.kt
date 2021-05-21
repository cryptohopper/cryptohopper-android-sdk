import cryptohopper.android.sdk.API.Marketplace.Seller.HopperAPIGetMarketSellerRequest
import cryptohopper.android.sdk.API.Marketplace.Seller.HopperAPIGetMarketSellerResponse
import cryptohopper.android.sdk.SharedModels.Marketplace.Models.MarketplaceSeller

class CryptohopperMarketplace {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Download item from marketplace
        ///
        /// - Parameter marketplaceItemId: (optional) Marketplace Item Id
        fun downloadItem(marketplaceItemId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDownloadItemRequest(marketplaceItemId).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get Home Page of Marketplace
        ///
        fun getHomePage(callback: (HopperAPIGetHomePageData?, HopperError?) -> Unit) {
            HopperAPIGetHomePageRequest("").request<HopperAPIGetHomePageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        // ------------- REVIEW ----------------------------------------

        /// Get Review
        ///
        ///- Parameter reviewId: (required) Review Id
        fun getReview(reviewId : Int,callback: (MarketReview?, HopperError?) -> Unit) {
            HopperAPIGetReviewRequest(reviewId).request<HopperAPIGetReviewResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Update Review
        ///
        ///- Parameter reviewId: (required) Review Id
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        ///- Parameter rating: (required) Rating
        fun updateReview(reviewId : Int,reviewName : String,review : String,rating : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateReviewRequest( reviewId,  reviewName,  review,  rating).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Delete Review
        ///
        ///- Parameter reviewId: (required) Review Id
        fun deleteReview(reviewId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteReviewRequest( reviewId).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Save Market Review
        ///
        ///
        ///- Parameter marketplaceId: (required) Marketplace Id
        ///- Parameter marketItemType: (required) Market Item Type
        ///- Parameter replyTo: (required) Reply Review Id
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        ///- Parameter rating: (required) Rating
        fun saveMarketReview(marketplaceId : Int,marketItemType : String,reviewName : String,review : String,rating : Int,replyTo : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPISaveMarketReviewRequest( marketplaceId,  marketItemType,  reviewName,  review,  rating,  replyTo).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Reply Market Review
        ///
        ///
        ///- Parameter reviewId: (required) Review Id
        ///- Parameter itemId: (required) Item Id
        ///- Parameter itemType: (required) Item Type
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        fun replyMarketReview(reviewId : Int,itemId : Int,itemType : String,reviewName : String,review : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIReplyMarketReviewRequest( reviewId,  itemId,  itemType,  reviewName,  review).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        // ------------- SIGNAL ----------------------------------------

        /// Get Available Signals
        ///
        ///
        fun getAvailableSignals(callback: (List<MarketSignal>?, HopperError?) -> Unit) {
            HopperAPIGetAvailableSignalsRequest("").request<HopperAPIGetAvailableSignalsResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get  Signal
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getSignal(signalId : Int ,callback: (MarketSignal?, HopperError?) -> Unit) {
            HopperAPIGetSignalRequest( signalId).request<HopperAPIGetSignalResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get  Signal Distribution
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getSignalDistribution(signalId : Int ,callback: (List<Int>?, HopperError?) -> Unit) {
            HopperAPIGetSignalDistributionRequest( signalId).request<HopperAPIGetSignalDistributionResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get  Signal Performance
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getSignalPerformance(signalId : Int ,callback: (List<MarketSignalPerformance>?, HopperError?) -> Unit) {
            HopperAPIGetSignalPerformanceRequest( signalId).request<HopperAPIGetSignalPerformanceResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get  One Review For Signal
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        ///- Parameter reviewId: (required) Review Id
        fun getOneReviewForSignal(signalId : Int ,reviewId :Int,callback: (MarketReview?, HopperError?) -> Unit) {
            HopperAPIGetOneReviewRequest( signalId, reviewId).request<HopperAPIGetOneReviewResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get  Marketplace Seller
        ///
        ///
        ///- Parameter sellerId: (required) Seller Id
        fun getMarketplaceSeller(sellerId : String ,callback: (MarketplaceSeller?, HopperError?) -> Unit) {
            HopperAPIGetMarketSellerRequest(sellerId).request<HopperAPIGetMarketSellerResponse>({ data ->
                callback(data.data,null)
            } ,{ error ->
                callback(null,error)
            })
        }

        /// Post Signal Review
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        ///- Parameter rating: (required) Rating 1-2-3-4-5
        fun postSignalReview(signalId : Int ,reviewName :String,review : String, rating : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPostSignalReviewRequest( signalId,  reviewName,  review,  rating).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get  One Review For Signal
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getSignalStats(signalId : Int,callback: (MarketSignalStat?, HopperError?) -> Unit) {
            HopperAPIGetSignalStatsRequest( signalId).request<HopperAPIGetSignalStatsResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        // ------------- STRATEGY ----------------------------------------


        /// Get Available Strategies
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getAvailableStrategies(callback: (List<MarketStrategy>?, HopperError?) -> Unit) {
            HopperAPIGetAvailableStrategiesRequest("").request<HopperAPIGetAvailableStrategiesResponse>({ data ->
                    callback(data.data?.strategy,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get  Strategies
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getStrategy(strategyId : Int ,callback: (MarketStrategy?, HopperError?) -> Unit) {
            HopperAPIGetStrategyRequest( strategyId).request<HopperAPIGetStrategyResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get  Strategy Reviews
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        ///- Parameter reviewId: (required) Review Id
        fun getOneStrategyReview(strategyId : Int ,reviewId : Int,callback: (MarketReview?, HopperError?) -> Unit) {
            HopperAPIGetOneReviewForStrategyRequest( strategyId, reviewId).request<HopperAPIGetOneReviewForStrategyResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Post Strategy Review
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        ///- Parameter rating: (required) Rating 1-2-3-4-5
        fun postStrategyReview(strategyId : Int ,reviewName : String, review : String,rating : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPostStrategyReviewRequest( strategyId,  reviewName,  review,  rating).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }



        // ------------- Template ----------------------------------------


        /// Get Available Templates
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getAvailableTemplates(callback: (List<MarketplaceTemplate>?, HopperError?) -> Unit) {
            HopperAPIGetAvailableTemplatesRequest("").request<HopperAPIGetAvailableTemplatesResponse>({ resp ->
                    callback(resp.data?.templates,null)
            }, { error ->
                    callback(null,error)
            })
        }


        /// Get Template
        ///
        ///
        ///- Parameter signalId: (required) Signal Id
        fun getMarketTemplate(templateId : Int,callback: (MarketplaceTemplate?, HopperError?) -> Unit) {
            HopperAPIGetTemplateRequest( templateId).request<HopperAPIGetTemplateResponse>({ resp ->
                    callback(resp.data,null)
            }, { error ->
                    callback(null,error)
            })
        }


        /// Get  Template Reviews
        ///
        ///
        ///- Parameter templateId: (required) Template Id
        ///- Parameter reviewId: (required) Review Id
        fun getOneTemplateReview(templateId : Int ,reviewId : Int,callback: (MarketReview?, HopperError?) -> Unit) {
            HopperAPIGetOneReviewForTemplateRequest( templateId,  reviewId).request<HopperAPIGetOneReviewForTemplateResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Post Template Review
        ///
        ///
        ///- Parameter templateId: (required) Template Id
        ///- Parameter reviewName: (required) Review Name
        ///- Parameter review: (required) Review Message
        ///- Parameter rating: (required) Rating 1-2-3-4-5
        fun postTemplateReview(templateId : Int ,reviewName : String, review : String,rating : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPostTemplateReviewRequest( templateId,  reviewName,  review,  rating).request<HopperCommonMessageResponse>({ data ->
                    callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

    }

}