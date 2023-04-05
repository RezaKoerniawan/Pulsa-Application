package com.reza.pulsa.application.data.network.model.entity.voucher

data class VoucherItem(
    val endDate: String?,
    val howToUse: String?,
    val id: Int?,
    val imageUrl: String?,
    val iterator: Int?,
    val maxDiscount: Int?,
    val minTransactionAmount: Int?,
    val name: String?,
    val number: Int?,
    val percentage: Int?,
    val startDate: String?,
    val termsAndCondition: String?,
    val usageCount: Int?,
    val voucherCode: String?
)
