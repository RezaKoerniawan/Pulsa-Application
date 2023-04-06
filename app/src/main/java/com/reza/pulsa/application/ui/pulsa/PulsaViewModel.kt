package com.reza.pulsa.application.ui.pulsa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.pulsa.application.base.wrapper.ViewResource
import com.reza.pulsa.application.data.network.model.entity.pulsa.ProductItem
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.domain.GetPulsaUseCase
import com.reza.pulsa.application.domain.GetVoucherUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PulsaViewModel(
    val getPulsaUseCase: GetPulsaUseCase,
    val getVoucherUseCase: GetVoucherUseCase
) : ViewModel() {

    val pulsaListResult = MutableLiveData<List<ProductItem>?>()
    val voucherListResult = MutableLiveData<List<VoucherItem>?>()

    fun getPulsaList() {
        viewModelScope.launch {
            getPulsaUseCase().collect {
                pulsaListResult.value = it.data
            }
        }
    }

    fun getVoucherList() {
        viewModelScope.launch {
            getVoucherUseCase().collect {
                voucherListResult.value = it.data
            }
        }
    }
}