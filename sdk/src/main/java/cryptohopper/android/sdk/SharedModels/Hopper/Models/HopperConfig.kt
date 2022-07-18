//
//  HopperConfig.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperConfig(
    @SerializedName("name") var name: String?,
    @SerializedName("live") var live: String?,
    @SerializedName("submit") var submit: String?,
    @SerializedName("status") var status: String?,
    @SerializedName("exchange") var exchange: String?,
    @SerializedName("api_passphrase") var api_passphrase: String?,
    @SerializedName("api_key") var api_key: String?,
    @SerializedName("api_secret") var api_secret: String?,
    @SerializedName("stop_buying") var stop_buying: String?,
    @SerializedName("stop_selling") var stop_selling: String?,
    @SerializedName("paper_trading") var paper_trading: String?,
    @SerializedName("paper_trading_account") var paper_trading_account: String?,
    @SerializedName("hopper_id") var hopper_id: String?,
    @SerializedName("last_loaded_config") var last_loaded_config: String?,
    @SerializedName("last_loaded_config_date") var last_loaded_config_date: String?,
    @SerializedName("minimum_profit") var minimum_profit: String?,
    @SerializedName("gdax_post_only") var gdax_post_only: String?,
    @SerializedName("extra_api_key") var extra_api_key: String?,
    @SerializedName("extra_api_secret") var extra_api_secret: String?,
    @SerializedName("max_open_time") var max_open_time: String?,
    @SerializedName("base_coins") var base_coins: List<String>?,
    @SerializedName("trading_fees") var trading_fees: Map<String, String>?,
    @SerializedName("loop_waittime") var loop_waittime: String?,
    @SerializedName("buy_btc_amount") var buy_btc_amount: String?,
    @SerializedName("send_trade_email") var send_trade_email: String?,
    @SerializedName("send_trade_error_email") var send_trade_error_email: String?,
    @SerializedName("send_cancelled_email") var send_cancelled_email: String?,
    @SerializedName("template_type") var template_type: String?,
    @SerializedName("template_id") var template_id: String?,
    @SerializedName("silent") var silent: String?,
    @SerializedName("arbitrage") var arbitrage: String?,
    @SerializedName("from_market_id") var from_market_id: String?,
    @SerializedName("set_percentage") var set_percentage: String?,
    @SerializedName("collect_currency") var collect_currency: String?,
    @SerializedName("allowed_coins") var allowed_coins: List<String>?,
    @SerializedName("walletscrubber_leftovers") var walletscrubber_leftovers: String?,
    @SerializedName("walletscrubber_auto") var walletscrubber_auto: String?,
    @SerializedName("walletscrubber_noopen") var walletscrubber_noopen: String?,
    @SerializedName("autosync") var autosync: String?,
    @SerializedName("autosync_all_coins") var autosync_all_coins: String?,
    @SerializedName("autosync_allowed_coins") var autosync_allowed_coins: List<String>?,
    @SerializedName("auto_merge_positions") var auto_merge_positions: String?,
    @SerializedName("output_live_feed") var output_live_feed: Int?,
    @SerializedName("output_errors_only") var output_errors_only: String?,
    @SerializedName("hold_assets") var hold_assets: String?,
    @SerializedName("set_percentage_ask") var set_percentage_ask: String?,
    @SerializedName("set_percentage_bid") var set_percentage_bid: String?,
    @SerializedName("ticker_type") var ticker_type: String?,
    @SerializedName("perc_buy_amount") var perc_buy_amount: String?,
    @SerializedName("min_buy_amount") var min_buy_amount: String?,
    @SerializedName("min_buy_amount_force") var min_buy_amount_force: String?,
    @SerializedName("max_amount_allocated") var max_amount_allocated: String?,
    @SerializedName("strategy") var strategy: String?,
    @SerializedName("sell_with_strategy") var sell_with_strategy: String?,
    @SerializedName("num_targets_per_buy") var num_targets_per_buy: String?,
    @SerializedName("rsi_candle_size") var rsi_candle_size: String?,
    @SerializedName("rsi_period") var rsi_period: String?,
    @SerializedName("rsi_oversold") var rsi_oversold: String?,
    @SerializedName("bbands_candle_size") var bbands_candle_size: String?,
    @SerializedName("bbands_days") var bbands_days: String?,
    @SerializedName("bbands_deviation") var bbands_deviation: String?,
    @SerializedName("bid_percentage") var bid_percentage: String?,
    @SerializedName("bid_percentage_type") var bid_percentage_type: String?,
    @SerializedName("max_open_time_buy") var max_open_time_buy: String?,
    @SerializedName("max_open_positions") var max_open_positions: String?,
    @SerializedName("max_open_positions_per_coin") var max_open_positions_per_coin: String?,
    @SerializedName("one_open_order") var one_open_order: String?,
    @SerializedName("only_when_positive") var only_when_positive: String?,
    @SerializedName("only_when_positive_time") var only_when_positive_time: String?,
    @SerializedName("cooldown") var cooldown: String?,
    @SerializedName("cooldown_when") var cooldown_when: String?,
    @SerializedName("cooldown_count") var cooldown_count: String?,
    @SerializedName("cooldown_val") var cooldown_var: String?,
    @SerializedName("ask_percentage") var ask_percentage: String?,
    @SerializedName("ask_percentage_type") var ask_percentage_type: String?,
    @SerializedName("advanced_ta_candle_size") var advanced_ta_candle_size: String?,
    @SerializedName("allow_all_coins") var allow_all_coins: String?,
    @SerializedName("buy_order_type") var buy_order_type: String?,
    @SerializedName("dca_order_type") var dca_order_type: String?,
    @SerializedName("sell_order_type") var sell_order_type: String?,
    @SerializedName("advanced_ta_rsi_period") var advanced_ta_rsi_period: String?,
    @SerializedName("advanced_ta_ema_disabled") var advanced_ta_ema_disabled: String?,
    @SerializedName("advanced_ta_rsi_disabled") var advanced_ta_rsi_disabled: String?,
    @SerializedName("advanced_ta_rsi_oversold") var advanced_ta_rsi_oversold: String?,
    @SerializedName("advanced_ta_sma_disabled") var advanced_ta_sma_disabled: String?,
    @SerializedName("advanced_ta_stoch_fast_k") var advanced_ta_stoch_fast_k: String?,
    @SerializedName("advanced_ta_stoch_slow_d") var advanced_ta_stoch_slow_d: String?,
    @SerializedName("advanced_ta_stoch_slow_k") var advanced_ta_stoch_slow_k: String?,
    @SerializedName("advanced_ta_bbands_dev_up") var advanced_ta_bbands_dev_up: String?,
    @SerializedName("advanced_ta_bbands_dev_low") var advanced_ta_bbands_dev_low: String?,
    @SerializedName("advanced_ta_bbands_matype") var advanced_ta_bbands_matype: String?,
    @SerializedName("advanced_ta_bbands_period") var advanced_ta_bbands_period: String?,
    @SerializedName("advanced_ta_ema_necessary") var advanced_ta_ema_necessary: String?,
    @SerializedName("advanced_ta_kama_disabled") var advanced_ta_kama_disabled: String?,
    @SerializedName("advanced_ta_kama_short_period") var advanced_ta_kama_short_period: String?,
    @SerializedName("advanced_ta_kama_long_period") var advanced_ta_kama_long_period: String?,
    @SerializedName("advanced_ta_sma_short_period") var advanced_ta_sma_short_period: String?,
    @SerializedName("advanced_ta_sma_long_period") var advanced_ta_sma_long_period: String?,
    @SerializedName("advanced_ta_macd_disabled") var advanced_ta_macd_disabled: String?,
    @SerializedName("advanced_ta_rsi_necessary") var advanced_ta_rsi_necessary: String?,
    @SerializedName("advanced_ta_rsi_overbought") var advanced_ta_rsi_overbought: String?,
    @SerializedName("advanced_ta_stoch_disabled") var advanced_ta_stoch_disabled: String?,
    @SerializedName("advanced_ta_stoch_oversold") var advanced_ta_stoch_oversold: String?,
    @SerializedName("advanced_ta_bbands_disabled") var advanced_ta_bbands_disabled: String?,
    @SerializedName("advanced_ta_ema_long_period") var advanced_ta_ema_long_period: String?,
    @SerializedName("advanced_ta_stochrsi_fast_d") var advanced_ta_stochrsi_fast_d: String?,
    @SerializedName("advanced_ta_stochrsi_fast_k") var advanced_ta_stochrsi_fast_k: String?,
    @SerializedName("advanced_ta_stochrsi_period") var advanced_ta_stochrsi_period: String?,
    @SerializedName("advanced_ta_bbands_necessary") var advanced_ta_bbands_necessary: String?,
    @SerializedName("advanced_ta_ema_short_period") var advanced_ta_ema_short_period: String?,
    @SerializedName("advanced_ta_macd_fast_period") var advanced_ta_macd_fast_period: String?,
    @SerializedName("advanced_ta_macd_slow_period") var advanced_ta_macd_slow_period: String?,
    @SerializedName("advanced_ta_stoch_overbought") var advanced_ta_stoch_overbought: String?,
    @SerializedName("advanced_ta_stochrsi_disabled") var advanced_ta_stochrsi_disabled: String?,
    @SerializedName("advanced_ta_stochrsi_oversold") var advanced_ta_stochrsi_oversold: String?,
    @SerializedName("advanced_ta_macd_signal_period") var advanced_ta_macd_signal_period: String?,
    @SerializedName("advanced_ta_stoch_slow_d_matype") var advanced_ta_stoch_slow_d_matype: String?,
    @SerializedName("advanced_ta_stoch_slow_k_matype") var advanced_ta_stoch_slow_k_matype: String?,
    @SerializedName("advanced_ta_stochrsi_overbought") var advanced_ta_stochrsi_overbought: String?,
    @SerializedName("advanced_ta_stochrsi_fast_d_matype") var advanced_ta_stochrsi_fast_d_matype: String?,
    @SerializedName("advanced_ta_stoch_necessary") var advanced_ta_stoch_necessary: String?,
    @SerializedName("advanced_ta_stochrsi_necessary") var advanced_ta_stochrsi_necessary: String?,
    @SerializedName("advanced_ta_sma_necessary") var advanced_ta_sma_necessary: String?,
    @SerializedName("advanced_ta_macd_necessary") var advanced_ta_macd_necessary: String?,
    @SerializedName("advanced_ta_kama_necessary") var advanced_ta_kama_necessary: String?,
    @SerializedName("stop_loss") var stop_loss: String?,
    @SerializedName("stop_loss_percentage") var stop_loss_percentage: String?,
    @SerializedName("trailing_buy") var trailing_buy: String?,
    @SerializedName("stop_loss_trailing") var stop_loss_trailing: String?,
    @SerializedName("stop_loss_trailing_percentage") var stop_loss_trailing_percentage: String?,
    @SerializedName("stop_loss_trailing_arm") var stop_loss_trailing_arm: String?,
    @SerializedName("stop_loss_trailing_only") var stop_loss_trailing_only: String?,
    @SerializedName("trailing_stop_loss_reset") var trailing_stop_loss_reset: String?,
    @SerializedName("trailing_stop_loss_profit") var trailing_stop_loss_profit: String?,
    @SerializedName("trailing_buy_percentage") var trailing_buy_percentage: String?,
    @SerializedName("short_reset_position") var short_reset_position: String?,
    @SerializedName("short_restore_position") var short_restore_position: String?,
    @SerializedName("automatic_shorting") var automatic_shorting: String?,
    @SerializedName("max_open_short_positions") var max_open_short_positions: String?,
    @SerializedName("short_sell_with_strategy") var short_sell_with_strategy: String?,
    @SerializedName("short_buy_with_strategy") var short_buy_with_strategy: String?,
    @SerializedName("short_always") var short_always: String?,
    @SerializedName("short_percentage_profit") var short_percentage_profit: String?,
    @SerializedName("short_use_actual_profit") var short_use_actual_profit: String?,
    @SerializedName("short_stop_loss_trailing") var short_stop_loss_trailing: String?,
    @SerializedName("short_stop_loss_trailing_percentage") var short_stop_loss_trailing_percentage: String?,
    @SerializedName("short_stop_loss_trailing_arm") var short_stop_loss_trailing_arm: String?,
    @SerializedName("short_stop_loss_trailing_only") var short_stop_loss_trailing_only: String?,
    @SerializedName("short_auto_close_positions") var short_auto_close_positions: String?,
    @SerializedName("short_auto_close_positions_time") var short_auto_close_positions_time: String?,
    @SerializedName("short_auto_remove_positions") var short_auto_remove_positions: String?,
    @SerializedName("short_auto_remove_positions_time") var short_auto_remove_positions_time: String?,
    @SerializedName("short_remove_on_loss") var short_remove_on_loss: String?,
    @SerializedName("short_ignore_max_pos") var short_ignore_max_pos: String?,
    @SerializedName("auto_close_positions") var auto_close_positions: String?,
    @SerializedName("auto_close_positions_time") var auto_close_positions_time: String?,
    @SerializedName("auto_dca") var auto_dca: String?,
    @SerializedName("auto_dca_time") var auto_dca_time: String?,
    @SerializedName("auto_dca_max") var auto_dca_max: String?,
    @SerializedName("auto_dca_percentage") var auto_dca_percentage: String?,
    @SerializedName("auto_dca_strategy") var auto_dca_strategy: String?,
    @SerializedName("auto_dca_size") var auto_dca_size: String?,
    @SerializedName("auto_dca_size_custom") var auto_dca_size_custom: String?,
    @SerializedName("load_api_from") var load_api_from: String?,


    //AI Configs
    @SerializedName("min_buy_score") var minBuyScore: String?,
    @SerializedName("min_sell_score") var minSellScore: String?,
    @SerializedName("sell_score_corrected") var sellScoreCorrected: String?,
    @SerializedName("buy_score_corrected") var buyScoreCorrected: String?,
) {
    constructor() : this(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    ) {

    }
}
