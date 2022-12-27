package com.sidra.netwrok_data_source.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL="https://jsonplaceholder.typicode.com/"


fun providesPostRetrofit() : Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun providesPostApiService(retrofit: Retrofit) : ApiService =
    retrofit.create(ApiService::class.java)