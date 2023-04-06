package com.reza.pulsa.application.ui.voucher

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.pulsa.application.data.network.model.entity.voucher.VoucherItem
import com.reza.pulsa.application.domain.GetVoucherUseCase
import kotlinx.coroutines.launch

class VoucherViewModel(
    val getVoucherUseCase: GetVoucherUseCase
) : ViewModel() {

    val voucherListResult = MutableLiveData<List<VoucherItem>?>()

    fun getVoucherList() {
        viewModelScope.launch {
            getVoucherUseCase().collect {
                voucherListResult.value = it.data
            }
        }
    }
}