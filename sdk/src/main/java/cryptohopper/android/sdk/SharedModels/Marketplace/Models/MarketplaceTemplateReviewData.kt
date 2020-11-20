
import com.google.gson.annotations.SerializedName

data class MarketplaceTemplateReviewData (
    @SerializedName("data") val data: List<MarketReview>?
)