package com.reza.pulsa.application.mapper

import com.reza.pulsa.application.base.arc.BaseMapper
import com.reza.pulsa.application.data.network.model.entity.status.ItemPayment
import com.reza.pulsa.application.data.network.model.response.status.TransactionContextResponse

class ItemListPaymentMapper : BaseMapper<TransactionContextResponse, List<ItemPayment>>() {
    override fun map(value: TransactionContextResponse): List<ItemPayment> {
        val payments = arrayListOf<ItemPayment>()
        value.itemResponseList?.forEach { payment ->
            payments.add(
                ItemPayment(
                    payment?.aggregatedPrice.orEmpty(),
                    payment?.category.orEmpty(),
                    payment?.name.orEmpty(),
                    payment?.pId ?: 0,
                    payment?.quantity ?: 0,
                    payment?.sku.orEmpty(),
                    payment?.skuType ?: 0,
                    payment?.status.orEmpty(),
                    payment?.totalAmount.orEmpty(),
                    payment?.unitPrice.orEmpty()
                )
            )
        }
        return payments
    }
}