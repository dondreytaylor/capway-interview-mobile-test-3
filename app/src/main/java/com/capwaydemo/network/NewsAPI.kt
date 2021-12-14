package com.capwaydemo.network

import com.capwaydemo.model.GetArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("everything")
    fun getNewsFeed(@Query("q") searchString: String, @Query("from") date: String, @Query("sortBy") sortBy: String): Call<GetArticlesResponse>
}
