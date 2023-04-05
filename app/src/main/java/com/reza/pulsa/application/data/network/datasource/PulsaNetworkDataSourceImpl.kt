package com.reza.pulsa.application.data.network.datasource

import com.reza.pulsa.application.data.network.PulsaApiService
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse
import com.reza.pulsa.application.data.network.model.response.status.StatusPageResponse
import com.reza.pulsa.application.data.network.model.response.voucher.VoucherListResponse

class PulsaNetworkDataSourceImpl(val pulsaApiService: PulsaApiService) : PulsaNetworkDataSource {
    override suspend fun getPulsaListItem(): PulsaListResponse = pulsaApiService.getPulsaItem()
    override suspend fun getVoucherListItem(): VoucherListResponse = pulsaApiService.getVoucherItem()
    override suspend fun getStatusPage(): StatusPageResponse = pulsaApiService.getStatusPage()

}

interface PulsaNetworkDataSource {
    suspend fun getPulsaListItem(): PulsaListResponse
    suspend fun getVoucherListItem(): VoucherListResponse

    suspend fun getStatusPage(): StatusPageResponse

}