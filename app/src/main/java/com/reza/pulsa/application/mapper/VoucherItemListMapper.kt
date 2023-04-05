package com.reza.pulsa.application.mapper

import com.reza.pulsa.application.base.arc.BaseMapper
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.data.network.model.response.voucher.VoucherListResponse

class VoucherItemListMapper : BaseMapper<VoucherListResponse, List<VoucherItem>>() {
    override fun map(value: VoucherListResponse): List<VoucherItem> {
        val vouchers = arrayListOf<VoucherItem>()
        value.data?.forEach { voucher ->
            vouchers.add(
                VoucherItem(
                    voucher?.endDate.orEmpty(),
                    voucher?.howToUse.orEmpty(),
                    voucher?.id ?: 0,
                    voucher?.imageUrl.orEmpty(),
                    voucher?.iterator ?: 0,
                    voucher?.maxDiscount ?: 0,
                    voucher?.minTransactionAmount ?: 0,
                    voucher?.name.orEmpty(),
                    voucher?.number ?: 0,
                    voucher?.percentage ?: 0,
                    voucher?.startDate.orEmpty(),
                    voucher?.termsAndCondition.orEmpty(),
                    voucher?.usageCount ?: 0,
                    voucher?.voucherCode.orEmpty()
                )
            )
        }
        return vouchers
    }
}