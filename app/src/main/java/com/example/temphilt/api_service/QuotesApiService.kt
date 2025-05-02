package com.example.temphilt.api_service

import com.example.temphilt.model.QuotesModelItem
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiService {
    @GET("posts")
    suspend fun getQuotes() : Response<List<QuotesModelItem>>
}