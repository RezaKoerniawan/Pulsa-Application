package com.reza.pulsa.application.ui.status

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.pulsa.application.data.network.model.entity.status.TransactionContext
import com.reza.pulsa.application.domain.GetStatusUseCase
import kotlinx.coroutines.launch

class StatusViewModel(
    val getStatusUseCase: GetStatusUseCase
) : ViewModel() {

    val statusResult = MutableLiveData<TransactionContext?>()

    fun getStatusPayment() {
        viewModelScope.launch {
            getStatusUseCase().collect {
                statusResult.value = it.data
            }
        }
    }
}