package com.reza.pulsa.application.data.network.model.response.status


import com.google.gson.annotations.SerializedName

data class MerchantDetailsResponse(
    @SerializedName("logo_url")
    val logoUrl: String? = null,
    @SerializedName("name")
    val name: String? = null
)