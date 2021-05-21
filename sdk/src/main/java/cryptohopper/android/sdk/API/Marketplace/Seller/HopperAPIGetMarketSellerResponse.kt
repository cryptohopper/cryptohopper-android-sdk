package cryptohopper.android.sdk.API.Marketplace.Seller

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Marketplace.Models.MarketplaceSeller

data class HopperAPIGetMarketSellerResponse (
        @SerializedName("data") val data: MarketplaceSeller?
)