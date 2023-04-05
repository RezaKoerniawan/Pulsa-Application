package com.reza.pulsa.application.domain

import com.reza.pulsa.application.base.arc.BaseUseCase
import com.reza.pulsa.application.base.wrapper.DataResource
import com.reza.pulsa.application.base.wrapper.ViewResource
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.data.repository.PulsaRepository
import com.reza.pulsa.application.mapper.VoucherItemListMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class GetVoucherUseCase(
    val repository: PulsaRepository,
    val dispatcher: CoroutineDispatcher
) : BaseUseCase<Any, List<VoucherItem>>(dispatcher) {
    override suspend fun execute(param: Any?): Flow<ViewResource<List<VoucherItem>>> {
        return repository.getVoucherListItem().map { resultNetwork ->
            when (resultNetwork) {
                is DataResource.Success -> {
                    if (resultNetwork.data != null) {
                        ViewResource.Success(VoucherItemListMapper().map(resultNetwork.data))
                    } else {
                        ViewResource.Error(resultNetwork.exception)
                    }
                }

                is DataResource.Error -> {
                    ViewResource.Error(resultNetwork.exception)
                }
            }
        }.onStart { emit(ViewResource.Loading()) }
    }
}