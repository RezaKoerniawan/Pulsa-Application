package com.reza.pulsa.application.domain

import com.reza.pulsa.application.base.arc.BaseUseCase
import com.reza.pulsa.application.base.wrapper.DataResource
import com.reza.pulsa.application.base.wrapper.ViewResource
import com.reza.pulsa.application.data.network.model.entity.status.TransactionContext
import com.reza.pulsa.application.data.repository.PulsaRepository
import com.reza.pulsa.application.mapper.StatusPaymentMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class GetStatusUseCase(
    val repository: PulsaRepository,
    val dispatcher: CoroutineDispatcher
) : BaseUseCase<Any, TransactionContext>(dispatcher) {
    override suspend fun execute(param: Any?): Flow<ViewResource<TransactionContext>> {
        return repository.getStatusPage().map { resultNetwork ->
            when (resultNetwork) {
                is DataResource.Success -> {
                    if (resultNetwork.data != null) {
                        ViewResource.Success(StatusPaymentMapper().map(resultNetwork.data))
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