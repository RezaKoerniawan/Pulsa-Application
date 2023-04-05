package com.reza.pulsa.application.data.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse
import com.reza.pulsa.application.data.network.model.response.status.StatusPageResponse
import com.reza.pulsa.application.data.network.model.response.voucher.VoucherListResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface PulsaApiService {

    @GET("59fced1c-2310-4455-b3b7-047e8acd46f3")
    suspend fun getPulsaItem(): PulsaListResponse

    @GET("3b567c89-e239-40ee-8e8b-c4caba7abd7a")
    suspend fun getVoucherItem(): VoucherListResponse

    @GET("2af4735c-6574-40b0-9789-f48212c8d543")
    suspend fun getStatusPage(): StatusPageResponse

    companion object {
        @JvmStatic
        operator fun invoke(chuckerInterceptor: ChuckerInterceptor): PulsaApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(chuckerInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(PulsaApiService::class.java)
        }
    }
}