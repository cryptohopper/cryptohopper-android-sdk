package cryptohopper.android.sdk.SharedModels.Marketplace.Models

import com.google.gson.annotations.SerializedName

data class MarketCopyBot(
    @SerializedName("id") val id: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("quote_currency") val quoteCurrency: String?,
    @SerializedName("allowed_coins") val allowedCoins: List<String>?,
    @SerializedName("free_trial") val freeTrial: String?,
    @SerializedName("stats") val stats: MarketCopyBotStats?,
    @SerializedName("type") val type: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("feature_image") val featureImage: String?,
    @SerializedName("top_item") val topItem: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("total_votes") val totalVotes: String?,
    @SerializedName("sales") val sales: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("price_currency") val priceCurrency: String?,
    @SerializedName("max_downloads") val maxDownloads: String?,
    @SerializedName("available_in_app") val availableInApp: String?
)

data class MarketCopyBotStats(
    @SerializedName("total_trades") val totalTrades: String?,
    @SerializedName("total_buys") val totalBuys: String?,
    @SerializedName("total_sells") val totalSells: String?,
    @SerializedName("trades_win") val tradesWin: String?,
    @SerializedName("trades_loss") val tradesLoss: String?,
    @SerializedName("highest_profit") val highestProfit: String?,
    @SerializedName("drawdown") val drawdown: MarketCopyBotStatsDrawdown?,
    @SerializedName("average_profit") val averageProfit: String?,
    @SerializedName("trades_win_perc") val tradesWinPerc: String?,
    @SerializedName("trades_loss_perc") val tradesLossPerc: String?,
    @SerializedName("win_loss_ratio") val winLossRatio: String?,
    @SerializedName("chart") val chart: List<List<String>>?,
    @SerializedName("chart_assets") val chartAssets: Map<String,List<List<String>>?>?,
    @SerializedName("total_copiers") val totalCopiers: String?,
    @SerializedName("trade_currencies") val tradeCurrencies: List<MarketCopyBotStatsTradeCurrency>?,
    @SerializedName("trade_currencies_stats") val tradeCurrenciesStats: List<MarketCopyBotStatsTradeCurrencyStats>?,
    @SerializedName("start_date") val startDate: String?
)

data class MarketCopyBotStatsDrawdown(
    @SerializedName("in_value") val inValue: String?,
    @SerializedName("percentage") val percentage: String?,
    @SerializedName("peak") val peak: String?,
    @SerializedName("low") val low: String?,
    @SerializedName("all") val all: List<Map<String,String>>?,
)

data class MarketCopyBotStatsTradeCurrency(
    @SerializedName("cur") val cur: String?,
    @SerializedName("count") val count: String?,
    @SerializedName("perc") val perc: String?,
    @SerializedName("highest_profit") val highestProfit: String?,
    @SerializedName("lowest_profit") val lowestProfit: String?,
    @SerializedName("average_profit") val averageProfit: String?,
)

data class MarketCopyBotStatsTradeCurrencyStats(
    @SerializedName("cur") val cur: String?,
    @SerializedName("count") val count: String?,
    @SerializedName("highest_profit") val highestProfit: String?,
    @SerializedName("lowest_profit") val lowestProfit: String?,
    @SerializedName("average_profit") val averageProfit: String?,
    @SerializedName("perc") val perc: String?,
)