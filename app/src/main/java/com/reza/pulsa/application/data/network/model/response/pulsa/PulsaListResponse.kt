package com.reza.pulsa.application.data.network.model.response.pulsa


import com.google.gson.annotations.SerializedName

data class PulsaListResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("products")
    val productItemRespons: List<ProductItemResponse?>? = null,
    @SerializedName("status")
    val status: String? = null
)