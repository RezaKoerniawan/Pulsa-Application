package com.reza.pulsa.application.data.network.model.entity.status

data class TransactionContext(
    val amount: String?,
    val appliedPaymentType: String?,
    val checkoutAmount: String?,
    val expirationTime: String?,
    val itemResponseList: List<ItemPayment?>?,
    val merchantDetailsResponse: MerchantDetails?,
    val orderId: String?,
    val transactionStatus: Int?,
    val transactionToken: String?
)
