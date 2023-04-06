package com.reza.pulsa.application.data.mapper

import com.reza.pulsa.application.base.arc.BaseMapper
import com.reza.pulsa.application.data.network.model.entity.status.MerchantDetails
import com.reza.pulsa.application.data.network.model.response.status.MerchantDetailsResponse

class MerchantDetailsMapper:BaseMapper<MerchantDetailsResponse, MerchantDetails>() {
    override fun map(value: MerchantDetailsResponse): MerchantDetails {
        return MerchantDetails(
            value.logoUrl.orEmpty(),
            value.name.orEmpty()
        )
    }
}