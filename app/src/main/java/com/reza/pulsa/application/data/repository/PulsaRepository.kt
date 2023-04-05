package com.reza.pulsa.application.data.repository

import com.reza.pulsa.application.base.arc.BaseContract
import com.reza.pulsa.application.base.arc.BaseRepositoryImpl
import com.reza.pulsa.application.base.wrapper.DataResource
import com.reza.pulsa.application.data.network.datasource.PulsaNetworkDataSource
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse
import com.reza.pulsa.application.data.network.model.response.status.StatusPageResponse
import com.reza.pulsa.application.data.network.model.response.voucher.VoucherListResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PulsaRepositoryImpl(val networkDataSource: PulsaNetworkDataSource) : BaseRepositoryImpl(),
    PulsaRepository {
    override suspend fun getPulsaListItem(): Flow<DataResource<PulsaListResponse>> =
        flow {
            emit(safeNetworkCall { networkDataSource.getPulsaListItem() })
        }

    override suspend fun getVoucherListItem(): Flow<DataResource<VoucherListResponse>> =
        flow {
            emit(safeNetworkCall { networkDataSource.getVoucherListItem() })
        }

    override suspend fun getStatusPage(): Flow<DataResource<StatusPageResponse>> =
        flow {
            emit(safeNetworkCall { networkDataSource.getStatusPage() })
        }

}

interface PulsaRepository : BaseContract.BaseRepository {
    suspend fun getPulsaListItem():
            Flow<DataResource<PulsaListResponse>>

    suspend fun getVoucherListItem():
            Flow<DataResource<VoucherListResponse>>

    suspend fun getStatusPage():
            Flow<DataResource<StatusPageResponse>>

}