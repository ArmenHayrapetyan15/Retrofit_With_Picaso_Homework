package com.example.retrofit_with_picasso_homework.Common

import com.example.retrofit_with_picasso_homework.Network.APIService
import com.example.retrofit_with_picasso_homework.Network.Retrofit

object Common {
    private const val BASE_URL = "https://simplifiedcoding.net/demos/"
    val getAPIService: APIService
        get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}