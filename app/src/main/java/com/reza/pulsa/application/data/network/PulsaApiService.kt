package com.reza.pulsa.application.data.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.reza.pulsa.application.data.network.model.response.pulsa.PulsaListResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface PulsaApiService {

    @GET("59fced1c-2310-4455-b3b7-047e8acd46f3")
    suspend fun getPulsaItem(): PulsaListResponse

    @GET("08628435-198c-4925-aa6e-00ec923bfc70")
    suspend fun getVoucherItem()

    @GET("e1be6ceb-7ddd-41cb-9cd6-9407c14bf77e")
    suspend fun getStatusPage()

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