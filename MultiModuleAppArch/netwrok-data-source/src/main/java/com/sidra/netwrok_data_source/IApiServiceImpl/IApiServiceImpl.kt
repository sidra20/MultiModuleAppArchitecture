package com.sidra.netwrok_data_source.IApiServiceImpl

import com.sidra.core.modelapi.Post
import com.sidra.netwrok_data_source.ApiService.ApiService
import retrofit2.Response

class IApiServiceImpl : ApiService {
    override suspend fun getPosts(): Response<Post> {
        TODO("Not yet implemented")
    }
}