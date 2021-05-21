package cryptohopper.android.sdk.SharedModels.Marketplace.Models

import com.google.gson.annotations.SerializedName

data class MarketplaceSeller (
        @SerializedName("id") val id: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("logo") val logo: String?,
        @SerializedName("description") val description: String?,
        @SerializedName("total_downloads") val totalDownloads: String?,
        @SerializedName("total_subscribers") val totalSubscribers: String?,
        @SerializedName("marketplace_items") val marketplaceItems: List<MarketplaceSellerItem>?
)

data class MarketplaceSellerItem (
        @SerializedName("id") val id: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("logo") val logo: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("rating") val rating: String?,
        @SerializedName("rating_count") val ratingCount: String?,
        @SerializedName("price") val price: String?,
        @SerializedName("price_currency") val priceCurrency: String?
)