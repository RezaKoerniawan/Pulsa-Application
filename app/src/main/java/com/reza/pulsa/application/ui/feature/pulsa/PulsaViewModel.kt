package com.reza.pulsa.application.ui.feature.pulsa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.pulsa.application.base.wrapper.ViewResource
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.domain.GetPulsaUseCase
import kotlinx.coroutines.launch

class PulsaViewModel(
    val getPulsaUseCase: GetPulsaUseCase
) : ViewModel() {

    val pulsaListResult = MutableLiveData<List<ProductItem>?>()

    fun getPulsaList() {
        viewModelScope.launch {
            getPulsaUseCase().collect {
                pulsaListResult.value = it.data
            }
        }
    }
}