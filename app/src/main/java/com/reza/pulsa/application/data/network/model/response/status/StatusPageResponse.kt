package com.reza.pulsa.application.data.network.model.response.status


import com.google.gson.annotations.SerializedName

data class StatusPageResponse(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("transaction_context")
    val transactionContextResponse: TransactionContextResponse? = null
)