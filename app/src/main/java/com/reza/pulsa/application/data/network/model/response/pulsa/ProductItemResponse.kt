package com.reza.pulsa.application.data.network.model.response.pulsa


import com.google.gson.annotations.SerializedName

data class ProductItemResponse(
    @SerializedName("bill_type")
    val billType: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("nominal")
    val nominal: String? = null,
    @SerializedName("operator")
    val operator: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("product_code")
    val productCode: String? = null,
    @SerializedName("sequence")
    val sequence: Int? = null
)