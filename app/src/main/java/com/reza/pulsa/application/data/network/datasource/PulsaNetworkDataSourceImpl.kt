package com.reza.pulsa.application.data.network.datasource

import com.reza.pulsa.application.data.network.PulsaApiService
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse

class PulsaNetworkDataSourceImpl(val pulsaApiService: PulsaApiService) : PulsaNetworkDataSource {
    override suspend fun getPulsaItem(): PulsaListResponse = pulsaApiService.getPulsaItem()

}

interface PulsaNetworkDataSource {
    suspend fun getPulsaItem(): PulsaListResponse

}