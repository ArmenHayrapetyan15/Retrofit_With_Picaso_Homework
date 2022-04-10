package com.example.retrofit_with_picasso_homework.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {
    private var retrofit: Retrofit? = null
    fun getRetrofitClient(baseUrl: String): Retrofit {

        var interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout((68 * 2).toLong(), TimeUnit.SECONDS)
            .connectTimeout((68 * 2).toLong(), TimeUnit.SECONDS)
            .writeTimeout((68 * 2).toLong(), TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        return retrofit!!
    }
}