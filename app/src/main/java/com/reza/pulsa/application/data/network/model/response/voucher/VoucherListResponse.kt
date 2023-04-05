package com.reza.pulsa.application.data.network.model.response.voucher


import com.google.gson.annotations.SerializedName

data class VoucherListResponse(
    @SerializedName("data")
    val data: List<VoucherItemResponse?>? = null,
    @SerializedName("status")
    val status: String? = null
)