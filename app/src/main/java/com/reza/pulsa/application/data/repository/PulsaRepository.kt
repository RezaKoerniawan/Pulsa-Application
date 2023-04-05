package com.reza.pulsa.application.data.repository

import com.reza.pulsa.application.base.arc.BaseContract
import com.reza.pulsa.application.base.arc.BaseRepositoryImpl
import com.reza.pulsa.application.base.wrapper.DataResource
import com.reza.pulsa.application.data.network.datasource.PulsaNetworkDataSource
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PulsaRepositoryImpl(val networkDataSource: PulsaNetworkDataSource) : BaseRepositoryImpl(),
    PulsaRepository {
    override suspend fun getPulsaItem(): Flow<DataResource<PulsaListResponse>> =
        flow {
            emit(safeNetworkCall { networkDataSource.getPulsaItem() })
        }

}

interface PulsaRepository : BaseContract.BaseRepository {
    suspend fun getPulsaItem():
            Flow<DataResource<PulsaListResponse>>
}