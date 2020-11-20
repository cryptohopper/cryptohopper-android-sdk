
//
//  HopperAPIConfigurationManager.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

class HopperAPIConfigurationManager {

    companion object {
        val shared = HopperAPIConfigurationManager()
    }

    var config: HopperAPIConfiguration
        private set

    private constructor() {
        config = HopperAPIConfiguration()
    }
}
