

import cryptohopper.android.sdk.SharedModels.Hopper.Models.HopperOutput
import cryptohopper.android.sdk.SharedModels.Hopper.Models.HopperTradeHistory
import java.util.*

class CryptohopperHopper {

    companion object {
        // ------------- GENERAL ----------------------------------------

        /// Gets all hoppers in your account with defined filter parameters , if you send parameters as nill than you get all hoppers
        ///
        /// - Parameter name: (optional)  Hopper's name as a filter
        /// - Parameter exchange: (optional) Exchange as a  filter with type HopperConfigExchange
        /// - Parameter enabled: (optional) Filter as if hooper is enabled or disabled, 0 if disabled , 1 if enabled
        fun getAllHoppers(name : String?,exchange : HopperConfigExchange? , enabled : Int?,callback: (List<Hopper>?, HopperError?) -> Unit) {
            HopperAPIGetAllHoppersRequest( name,  exchange,  enabled).request({ hoppers ->
                    callback(hoppers.data?.hoppers,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Gets one hopper by id
        ///
        /// - Parameter (required) Hopper's id
        fun getHopper(hopperId : String,callback: (Hopper?, HopperError?) -> Unit) {
            HopperAPIGetSingleHopperRequest(hopperId).request({ hopper ->
                    callback(hopper.data?.hopper,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Create new Hopper with parameters
        ///
        /// - Parameter name:  (required) Hopper name
        /// - Parameter enabled: (optional) Select if hopper is enabled or disabled when you created it . 1 is enabled , 0 is disabled.
        /// - Parameter templateId: (optional) Hopper templateId if you are creating hopper from a template
        /// - Parameter apiConfig: (optional) Hopper api config defined with HopperConfigAPIConfig
        /// - Parameter config: (optional) Hopper config defined with HopperConfig object
        fun createHopper(name : String, enabled: Int?, templateId: Int?, apiConfig: HopperConfigAPIConfig?, config: HopperConfig?,callback: (String?, HopperError?) -> Unit) {
            HopperAPICreateHopperRequest( name,  enabled, templateId, apiConfig,  config).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper id
        /// - Parameter name:  (optional) Hopper name
        /// - Parameter enabled: (optional) Select if hopper is enabled or disabled when you created it . 1 is enabled , 0 is disabled.
        /// - Parameter templateId: (optional) Hopper templateId if you are creating hopper from a template
        /// - Parameter apiConfig: (optional) Hopper api config defined with HopperConfigAPIConfig
        /// - Parameter config: (optional) Hopper config defined with HopperConfig object
        fun updateHopper(hopperId : String,name: String?, enabled: Int?, apiConfig: HopperConfigAPIConfig?, config: HopperConfig?,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateHopperRequest(hopperId,  name,  enabled, apiConfig).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun deleteHopper(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteHopperRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Change Hopper Image
        ///
        /// - Parameter hopperId:  (required) Hopper id
        /// - Parameter image:  (required) Image Url
        fun changeHopperImage(hopperId : String,image : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIChangeHopperImageRequest(hopperId, image).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Disable Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun disableHopper(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDisableHopperRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Reset Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun resetHopper(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIResetHopperRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Set Hopper Disabled
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun setHopperAsDefault(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPISetHopperAsDefaultRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Disable Hopper Buying
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun disableHopperBuying(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDisableHopperBuyingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Disable Hopper Papertrading
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun disableHopperPapertrading(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDisableHopperPapertradingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Disable Hopper Selling
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun disableHopperSelling(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDisableHopperSellingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Enable Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun enableHopper(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnableHopperRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Enable Hopper Buying
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun enableHopperBuying(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnableHopperBuyingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Enable Hopper Papertrading
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun enableHopperPapertrading(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnableHopperPapertradingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Enable Hopper Selling
        ///
        /// - Parameter  (required) Hopper id
        fun enableHopperSelling(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnableHopperSellingRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Hopper Most Traded Currency
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun getHopperMostTradedCurrency(hopperId : String,callback: (List<HopperMostTradedModel>?, HopperError?) -> Unit) {
            HopperAPIHopperMostTradedCurrencyRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Enable Hopper Panic
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun enableHopperPanic(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnableHopperPanicRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Disable Hopper Panic
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun disableHopperPanic(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDisableHopperPanicRequest(hopperId).request ({ message ->
                    callback(message.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        // ------------- ORDER ----------------------------------------

        /// Get All Open Orders
        ///
        /// - Parameter hopperId:  (required) Hopper id
        fun getAllOpenOrders(hopperId : String,callback: (List<HopperOrder>?, HopperError?) -> Unit) {
            HopperAPIGetAllOpenOrdersRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get All Open Orders
        ///
        /// - Parameter hopperId:  (required) Hopper id
        /// - Parameter orderId:  (required) Order id
        fun getOneOpenOrder(hopperId : String,orderId : String,callback: (HopperOrder?, HopperError?) -> Unit) {
            HopperAPIGetOneOpenOrderRequest(hopperId, orderId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Create Order
        ///
        /// - Parameter hopperId:  (required) Hoppe Id
        /// - Parameter orderType:  (required) Order Type
        /// - Parameter marketOrder:  (required) Market Order
        /// - Parameter coin:  (required) Coin
        /// - Parameter price:  (required) Price
        /// - Parameter amount:  (required) Amount
        /// - Parameter orderTrigger:  (required) Order Trigger
        /// - Parameter percentageProfit:  (required) Percentage Profit
        /// - Parameter trailingBuy:  (required) Trailing Buy
        /// - Parameter trailingBuyPercentage:  (required) Trailing Buy Percentage
        fun createOrder(hopperId : String,orderType : String,marketOrder : Int,coin : String,price : Double,amount : Double,orderTrigger : String,percentageProfit : Double,trailingBuy : Double,trailingBuyPercentage : Double,callback: (String?, HopperError?) -> Unit) {
            HopperAPICreateOrderRequest(hopperId,orderType,marketOrder,coin,price, amount,  orderTrigger,  percentageProfit,  trailingBuy,  trailingBuyPercentage).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete Multiple Orders
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter orderIds:  (required) Order Ids as int array
        fun deleteMultipleOrders(hopperId : String,orderIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteMultipleOrdersRequest(hopperId, orderIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete One Order
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter orderId:  (required) Order Id
        fun deleteMultipleOrders(hopperId : String,orderId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteOneOrderRequest(hopperId, orderId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete All Open Orders
        ///
        /// - Parameter  (required) Hopper Id
        fun deleteAllOpenOrders(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteAllOpenOrdersRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Cancel TSB Order
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter orderId:  (required) Order Id
        fun cancelTsbOrder(hopperId : String,orderId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPICancelTSBOrderRequest(hopperId, orderId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Cancel Order
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter orderId:  (required) Order Id
        fun cancelOrder(hopperId : String,orderId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPICancelOrderRequest(hopperId, orderId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- PAPERTRADING ----------------------------------------


        /// Deposit Papertrading Account
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter coin:  (required) Coin example: BTC
        /// - Parameter amount:  (required) Deposit Amount
        fun depositPapertradingAccount(hopperId : String,coin : String,amount : Double,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPapertradingDepositRequest( hopperId,  coin,  amount).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Withdraw Papertrading Account
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter coin:  (required) Coin example: BTC
        /// - Parameter amount:  (required) Deposit Amount
        fun withdrawPapertradingAccount(hopperId : String,coin : String,amount : Double,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPapertradingWithdrawRequest( hopperId,  coin,  amount).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Reset Papertrading Account
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun resetPapertradingAccount(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPapertradingResetRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- POSITION ----------------------------------------


        /// Delete Multiple Short Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids as int array
        fun deleteMultipleShortPositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteMultipleShortPositionsRequest(hopperId,  positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete One Short Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        fun deleteOneShortPosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteOneShortPositionRequest(hopperId,positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Close Multiple Short Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids as int array
        fun closeMultipleShortPositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPICloseMultipleShortPositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Close One Short Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        fun closeOneShortPositions(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPICloseOneShortPositionRequest(hopperId, positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get All Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getAllPositions(hopperId : String,callback: (List<HopperPosition>?, HopperError?) -> Unit) {
            HopperAPIGetAllPositionsRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get All Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Hopper Id
        fun getOnePosition(hopperId : String,positionId : Int,callback: (HopperPosition?, HopperError?) -> Unit) {
            HopperAPIGetOnePositionRequest(hopperId, positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Short Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        /// - Parameter takeProfit:  (required) Take Profit
        /// - Parameter stopLoss:  (required) Stop Loss
        /// - Parameter stopLossPercentage:  (required) Stop Loss Percentage
        /// - Parameter trailingStopLoss:  (required) Trailing Stop Loss
        /// - Parameter trailingStopLossPercentage:  (required) Trailing Stop Loss Percentage
        /// - Parameter trailingStopLossArm:  (required) Trailing Stop Loss Arm
        /// - Parameter autoClose:  (required) Auto Close
        /// - Parameter autoCloseTime:  (required) Auto Close Time
        fun updatePosition(hopperId : String,positionId : Int,takeProfit : Int,stopLoss:Int,stopLossPercentage : Int,trailingStopLoss : Int,trailingStopLossPercentage : Int,trailingStopLossArm : Int,autoClose :Int,autoCloseTime : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdatePositionRequest(hopperId,  positionId,  takeProfit,  stopLoss,  stopLossPercentage,  trailingStopLoss,  trailingStopLossPercentage,  trailingStopLossArm,  autoClose,  autoCloseTime).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Short Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter shortId:  (required) Position Id
        /// - Parameter takeProfit:  (required) Take Profit
        /// - Parameter stopLoss:  (required) Stop Loss
        /// - Parameter stopLossPercentage:  (required) Stop Loss Percentage
        /// - Parameter trailingStopLoss:  (required) Trailing Stop Loss
        /// - Parameter trailingStopLossPercentage:  (required) Trailing Stop Loss Percentage
        /// - Parameter trailingStopLossArm:  (required) Trailing Stop Loss Arm
        /// - Parameter autoClose:  (required) Auto Close
        /// - Parameter autoCloseTime:  (required) Auto Close Time
        fun updateShortPosition(hopperId : String,shortId : Int,takeProfit : Int,stopLoss:Int,stopLossPercentage : Int,trailingStopLoss : Int,trailingStopLossPercentage : Int,trailingStopLossArm : Int,autoClose :Int,autoCloseTime : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateShortPositionRequest(hopperId,  shortId,  takeProfit,  stopLoss,  stopLossPercentage,  trailingStopLoss,  trailingStopLossPercentage,  trailingStopLossArm,  autoClose,  autoCloseTime).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Hold Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getHoldPositions(hopperId : String,callback: (List<HopperPosition>?, HopperError?) -> Unit) {
            HopperAPIGetHoldPositionsRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Hold Multiple Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun holdOnePosition(hopperId : String,positionId : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIHoldMultiplePositionsRequest(hopperId, positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Hold One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        fun holdOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIHoldOnePositionRequest(hopperId, positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Merge Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun mergePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIMergePositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Get Release Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getReleasePositions(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIGetReleasePositionsRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Release Multiple Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun releaseMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIReleaseMultiplePositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Release One Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        fun releaseOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIReleaseOnePositionRequest(hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Remove Multiple Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun removeMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIRemoveMultiplePositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Remove One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun removeOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIRemoveOnePositionRequest(hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Delete Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun deletePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeletePositionRequest(hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Sell Multiple Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun sellMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPISellMultiplePositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Sell One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun sellOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPISellOnePositionRequest(hopperId, positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Take Profit
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        /// - Parameter percentage:  (required) Percentage
        fun takeProfit(hopperId : String,positionIds : List<Int>,percentage : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIPositionsTakeProfitRequest(hopperId,  positionIds,  percentage).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Split Multiple Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun splitMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPISplitMultiplePositionsRequest(hopperId, positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Split One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun splitOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPISplitOnePositionRequest( hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Get Short Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getShortPositions(hopperId : String,callback: (List<HopperShortPosition>?, HopperError?) -> Unit) {
            HopperAPIGetShortsRequest(hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Get Reserved Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getReservedPositions(hopperId : String,callback: (List<HopperReserved>?, HopperError?) -> Unit) {
            HopperAPIGetReservedPositionsRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Short Multiple Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun shortMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIShortMultiplePositionsRequest( hopperId,  positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Short One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun shortOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIShortOnePositionRequest( hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// ActivateDCA Multiple Positions
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        /// - Parameter marketOrder:  (required) Market Order
        /// - Parameter trailingBuy:  (required) Trailing Buy
        /// - Parameter trailingBuyPercentage:  (required) Trailing Buy Percentage
        fun activateDcaForMultiplePositions(hopperId : String,positionIds : List<Int>,marketOrder : Int,trailingBuy : Int,trailingBuyPercentage : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIActivateDCAForMultiplePositionsRequest( hopperId,  positionIds, marketOrder,  trailingBuy,  trailingBuyPercentage).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// ActivateDCA One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Id
        /// - Parameter marketOrder:  (required) Market Order
        /// - Parameter trailingBuy:  (required) Trailing Buy
        /// - Parameter trailingBuyPercentage:  (required) Trailing Buy Percentage
        fun activateDcaForOnePosition(hopperId : String,positionId : Int,marketOrder : Int,trailingBuy : Int,trailingBuyPercentage : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIActivateDCAForOnePositionRequest( hopperId,  positionId, marketOrder,  trailingBuy,  trailingBuyPercentage).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Short Multiple Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionIds:  (required) Position Ids
        fun moveMultiplePositions(hopperId : String,positionIds : List<Int>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIRemoveMultiplePositionsRequest( hopperId,  positionIds).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        /// Short One Position
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter positionId:  (required) Position Ids
        fun moveOnePosition(hopperId : String,positionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIMoveOnePositionsToReservedRequest( hopperId,  positionId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- SIGNAL ----------------------------------------


        /// Get Signals In Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getSignalsInHopper(hopperId : String,callback: (List<MarketSignal>?, HopperError?) -> Unit) {
            HopperAPIGetSignalsInHopperRequest( hopperId).request ({ data ->
                    callback(data.data?.signals,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Signal by Id
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter signalId:  (required) Signal Id
        fun getSignalById(hopperId : String,signalId : Int,callback: (MarketSignal?, HopperError?) -> Unit) {
            HopperAPIGetSignalByIdRequest( hopperId,  signalId).request ({ data ->
                    callback(data.signal,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Subscribe To Signal
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter signalId:  (required) Signal Id
        fun subscribeToSignal(hopperId : String,signalId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPISubscribeToSignalRequest( hopperId,  signalId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Unsubscribe To Signal
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter signalId:  (required) Signal Id
        fun unsubscribeFromSignal(hopperId : String,signalId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUnsubscribeToSignalRequest( hopperId,  signalId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Last Signal
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getLastSignal(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIGetLastSignalRequest( hopperId).request ({ data ->
                    callback(data.signalLast,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Signal Config
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun updateSignalConfig(hopperId : String,signalId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateSignalConfigRequest( hopperId, signalId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- STATS ----------------------------------------

        /// Get Hopper Stats
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getHopperStats(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIGetHopperStatsRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Dashboard Stats
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getDashboardStats(hopperId : String,callback: (HopperDashboardStats?, HopperError?) -> Unit) {
            HopperAPIGetHopperDashboardStatsRequest( hopperId).request ({ data ->
                    callback(data.stats,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Reset Hopper Stats
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun resetHopperStats(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIResetHopperStatsRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- Subscription ----------------------------------------


        /// Get Subscription Of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getSubscription(hopperId : String,callback: (HopperSubscription?, HopperError?) -> Unit) {
            HopperAPIGetSubscriptionRequest( hopperId).request ({ data ->
                    callback(data.data?.subscription,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// ReAssign Of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun reAssignSubscription(hopperId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIReassignSubsriptionRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        // ------------- Config Pool ----------------------------------------

        /// Get Config of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getConfig(hopperId : String,callback: (HopperConfig?, HopperError?) -> Unit) {
            HopperAPIGetConfigRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Config of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun updateConfig(hopperId : String,callback: (HopperConfig?, HopperError?) -> Unit) {
            HopperAPIUpdateConfigRequest( hopperId).request ({ data ->
                    callback(data.data?.hoppers,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get All Config Pools
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getAllConfigPools(hopperId : String,callback: (List<HopperConfigPool>?, HopperError?) -> Unit) {
            HopperAPIGetAllConfigPoolsRequest( hopperId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get One Config Pool
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getOneConfigPools(hopperId : String,poolId : String,callback: (HopperConfigPool?, HopperError?) -> Unit) {
            HopperAPIGetOneConfigPoolRequest( hopperId,  poolId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Create Config Pool
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter enabled:  (required) Enabled with object HopperEnabled
        /// - Parameter configPool:  (required) Config Pool
        fun createConfigPool(hopperId : String,enabled : HopperEnabled,configPool : HopperConfigPool,callback: (String?, HopperError?) -> Unit) {
            HopperAPICreatePoolConfigRequest( hopperId,  enabled,  configPool).request ({ data ->
                    callback(data.id,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Config Pool
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter enabled:  (required) Enabled with object HopperEnabled
        /// - Parameter configPool:  (required) Config Pool
        fun updateConfigPool(hopperId : String,enabled : HopperEnabled,configPool : HopperConfigPool,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateConfigPoolRequest( hopperId,  enabled,  configPool).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Update Config Pool
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        /// - Parameter poolId:  (required) ConfigPool Id
        fun deleteConfigPool(hopperId : String,poolId : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIDeleteConfigPoolRequest( hopperId,  poolId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }


        // ------------- Trade ----------------------------------------

        /// Get Trade History of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getTradeHistory(hopperId : String,callback: (List<HopperTradeHistory>?, HopperError?) -> Unit) {
            HopperAPIGetTradeHistoryRequest(hopperId).request ({ data ->
                    callback(data.data?.trades,null)
            },{error ->
                    callback(null,error)
            })
        }

        /// Get Trade History By Id
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getTradeHistory(hopperId : String,tradeId : Int,callback: (HopperOrder?, HopperError?) -> Unit) {
            HopperAPIGetTradeHistoryByIdRequest( hopperId, tradeId).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

        // ------------- Output ----------------------------------------

        /// Get Trade History of Hopper
        ///
        /// - Parameter hopperId:  (required) Hopper Id
        fun getOutput(hopperId : String, dateFrom : Date, dateTo : Date, entryType: HopperSearchOptionsItemEntry, sortField : HopperSearchOptionsItemSortField, sortOrder : HopperSearchOptionsItemSortOrder, page : Int, perPage : Int, callback: (List<HopperOutput>?, HopperError?) -> Unit) {
            HopperAPIGetOutputRequest( hopperId,  dateFrom,  dateTo,  entryType,  sortField,  sortOrder,  page,  perPage).request ({ data ->
                    callback(data.data,null)
            },{error ->
                    callback(null,error)
            })
        }

    }


}
