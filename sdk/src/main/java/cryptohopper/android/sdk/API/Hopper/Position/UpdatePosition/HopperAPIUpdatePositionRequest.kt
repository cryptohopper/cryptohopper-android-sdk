//
//  HopperAPIUpdatePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdatePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId:Int,takeProfit : Double,stopLoss:Int,stopLossPercentage : Double,trailingStopLoss : Int, trailingStopLossPercentage : Double,trailingStopLossArm : Double,autoClose : Int,autoCloseTime : Long) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/setpositionsetting")

        addBodyItem( "position_ids", listOf<Int>(positionId))

        var settings = mutableMapOf<String,Any>()

        settings["take_profit"] = takeProfit

        settings["stop_loss_enabled"] = stopLoss
        if(stopLoss == 1){
            settings["stop_loss_percentage"] = stopLossPercentage
        }else{
            settings["stop_loss_percentage"] = 0.0
        }

        settings["trailing_enabled"] = trailingStopLoss
        if(trailingStopLoss == 1){
            settings["trailing_percentage"] = trailingStopLossPercentage
            settings["trailing_arm_percentage"] = trailingStopLossArm
        }else{
            settings["trailing_percentage"] = 0.0
            settings["trailing_arm_percentage"] = 0.0
        }

        if(autoClose == 1){
            settings["auto_close_time"] = autoCloseTime
        }else{
            settings["auto_close_time"] = 0
        }

        addBodyItem( "setting", settings)
    }
    
}
