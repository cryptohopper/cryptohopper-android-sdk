package cryptohopper.android.sdk.API.apiv2.exchange.getexchange

import com.google.gson.annotations.SerializedName

data class V2Pair(
    @SerializedName("pair") val pair: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("quote") val quote: String?,
    @SerializedName("minPrice") val minPrice: Double?,
    @SerializedName("maxPrice") val maxPrice: Double?,
    @SerializedName("pricePrecision") val pricePrecision: Int?,
    @SerializedName("minQty") val minQty: Double?,
    @SerializedName("maxQty") val maxQty: Double?,
    @SerializedName("minQtyQuote") val minQtyQuote: Double?,
    @SerializedName("maxQtyQuote") val maxQtyQuote: Double?,
    @SerializedName("qtyPrecision") val qtyPrecision: Int?,
)



