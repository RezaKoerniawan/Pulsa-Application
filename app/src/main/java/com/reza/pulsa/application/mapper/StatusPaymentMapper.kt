package com.reza.pulsa.application.mapper

import com.reza.pulsa.application.base.arc.BaseMapper
import com.reza.pulsa.application.data.network.model.entity.status.TransactionContext
import com.reza.pulsa.application.data.network.model.response.status.StatusPageResponse

class StatusPaymentMapper : BaseMapper<StatusPageResponse, TransactionContext>() {
    override fun map(value: StatusPageResponse): TransactionContext {
        return TransactionContext(
            value.transactionContextResponse?.amount.orEmpty(),
            value.transactionContextResponse?.appliedPaymentType.orEmpty(),
            value.transactionContextResponse?.checkoutAmount.orEmpty(),
            value.transactionContextResponse?.expirationTime.orEmpty(),
            value.transactionContextResponse?.let { ItemListPaymentMapper().map(it) },
            value.transactionContextResponse?.merchantDetails?.let { MerchantDetailsMapper().map(it) },
            value.transactionContextResponse?.orderId.orEmpty(),
            value.transactionContextResponse?.transactionStatus ?: 0,
            value.transactionContextResponse?.transactionToken.orEmpty()

        )
    }
}