package com.reza.pulsa.application.data.mapper

import com.reza.pulsa.application.base.arc.BaseMapper
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse

class ProductPulsaListMapper : BaseMapper<PulsaListResponse, List<ProductItem>>() {
    override fun map(value: PulsaListResponse): List<ProductItem> {
        val products = arrayListOf<ProductItem>()
        value.productItemRespons?.forEach { product ->
            products.add(
                ProductItem(
                    product?.billType.orEmpty(),
                    product?.description.orEmpty(),
                    product?.label.orEmpty(),
                    product?.nominal.orEmpty(),
                    product?.operator.orEmpty(),
                    product?.price ?: 0,
                    product?.productCode.orEmpty(),
                    product?.sequence ?: 0
                )
            )
        }
        return products
    }
}