

import com.google.gson.annotations.SerializedName

data class MarketStrategyReviewData (
    @SerializedName("data") val data: List<MarketReview>?
)