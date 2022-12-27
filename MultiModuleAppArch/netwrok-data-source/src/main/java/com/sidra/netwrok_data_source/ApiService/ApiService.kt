package com.sidra.netwrok_data_source.ApiService

import com.sidra.core.modelapi.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<Post>
}