package com.reza.pulsa.application.data.network.model.response.status


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("aggregated_price")
    val aggregatedPrice: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("p_id")
    val pId: Int? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("sku")
    val sku: String? = null,
    @SerializedName("sku_type")
    val skuType: Int? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("total_amount")
    val totalAmount: String? = null,
    @SerializedName("unit_price")
    val unitPrice: String? = null
)