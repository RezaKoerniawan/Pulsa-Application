package com.reza.pulsa.application.data.network.model.response.voucher


import com.google.gson.annotations.SerializedName

data class VoucherItemResponse(
    @SerializedName("end_date")
    val endDate: String? = null,
    @SerializedName("how_to_use")
    val howToUse: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("iterator")
    val iterator: Int? = null,
    @SerializedName("max_discount")
    val maxDiscount: Int? = null,
    @SerializedName("min_transaction_amount")
    val minTransactionAmount: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
    val number: Int? = null,
    @SerializedName("percentage")
    val percentage: Int? = null,
    @SerializedName("start_date")
    val startDate: String? = null,
    @SerializedName("terms_and_condition")
    val termsAndCondition: String? = null,
    @SerializedName("usage_count")
    val usageCount: Int? = null,
    @SerializedName("voucher_code")
    val voucherCode: String? = null
)