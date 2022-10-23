package com.example.myapplication.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceCreator {
    const val BASE_URL = "http://218.7.112.123:10001/"
    private const val CONNECT_TIMEOUT = 30L
    private const val READ_TIMEOUT = 10L

    private fun create(): Retrofit {
        //
        val okHttpClientBuilder = OkHttpClient().newBuilder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            build()

        }
        return RetrofitBuild(
            url = BASE_URL,
            client = okHttpClientBuilder.build(),
            gsonFactory = GsonConverterFactory.create()
        ).retrofit
    }

    fun <T> create(service: Class<T>): T = create().create(service)
}

class RetrofitBuild(url: String, client: OkHttpClient, gsonFactory: GsonConverterFactory) {
    val retrofit: Retrofit = Retrofit.Builder().apply {
        baseUrl(url)
        client(client)
//        addConverterFactory(ScalarsConverterFactory.create())
        addConverterFactory(gsonFactory)
    }.build()
}