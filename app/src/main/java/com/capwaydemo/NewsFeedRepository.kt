package com.capwaydemo

import com.capwaydemo.model.GetArticlesResponse
import com.capwaydemo.network.NewsAPI
import com.capwaydemo.network.RetrofitController
import retrofit2.Callback

abstract class NewsFeedRepository {
    companion object {
        fun getNewsFeed(searchString: String, date: String, callback: Callback<GetArticlesResponse>) {
            val retrofitController = RetrofitController.getRetrofitInstance().create(NewsAPI::class.java)
            retrofitController.getNewsFeed(searchString, date, "popularity").enqueue(callback)
        }
    }
}
