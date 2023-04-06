package com.reza.pulsa.application.data.network.model.response.status


import com.google.gson.annotations.SerializedName

data class TransactionContextResponse(
    @SerializedName("amount")
    val amount: String? = null,
    @SerializedName("applied_payment_type")
    val appliedPaymentType: String? = null,
    @SerializedName("checkout_amount")
    val checkoutAmount: String? = null,
    @SerializedName("expiration_time")
    val expirationTime: String? = null,
    @SerializedName("item_list")
    val itemResponseList: List<ItemResponse?>? = null,
    @SerializedName("merchant_details")
    val merchantDetails: MerchantDetailsResponse? = null,
    @SerializedName("order_id")
    val orderId: String? = null,
    @SerializedName("transaction_status")
    val transactionStatus: Int? = null,
    @SerializedName("transaction_token")
    val transactionToken: String? = null
)