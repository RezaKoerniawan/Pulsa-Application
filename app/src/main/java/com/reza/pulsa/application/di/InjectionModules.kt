package com.reza.pulsa.application.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.reza.pulsa.application.data.network.PulsaApiService
import com.reza.pulsa.application.data.network.datasource.PulsaNetworkDataSource
import com.reza.pulsa.application.data.network.datasource.PulsaNetworkDataSourceImpl
import com.reza.pulsa.application.data.repository.PulsaRepository
import com.reza.pulsa.application.data.repository.PulsaRepositoryImpl
import com.reza.pulsa.application.domain.GetPulsaUseCase
import com.reza.pulsa.application.domain.GetVoucherUseCase
import com.reza.pulsa.application.ui.feature.pulsa.PulsaViewModel
import com.reza.pulsa.application.ui.feature.voucher.VoucherViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object InjectionModules {
    fun getModules() = listOf(network, dataSource, repository, useCases, viewModels)

    private val network = module {
        single { ChuckerInterceptor.Builder(androidContext()).build() }
        single { PulsaApiService.invoke(get()) }
    }
    private val dataSource = module {
        single<PulsaNetworkDataSource> { PulsaNetworkDataSourceImpl(get()) }
    }
    private val repository = module {
        single<PulsaRepository> { PulsaRepositoryImpl(get()) }
    }
    private val useCases = module {
        single { GetPulsaUseCase(get(), dispatcher = Dispatchers.IO) }
        single { GetVoucherUseCase(get(), dispatcher = Dispatchers.IO) }
    }
    private val viewModels = module {
        viewModelOf(::PulsaViewModel)
        viewModelOf(::VoucherViewModel)
    }

}