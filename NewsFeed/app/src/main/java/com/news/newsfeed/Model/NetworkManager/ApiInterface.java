package com.news.newsfeed.Model.NetworkManager;

import com.news.newsfeed.Model.ApiResponse.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.news.newsfeed.Model.NetworkHelper.ApiConstants.API_KEY;
import static com.news.newsfeed.Model.NetworkHelper.ApiConstants.COUNTRY;

public interface ApiInterface {

    // Method to get list of news of some specific country.
    @GET("top-headlines")
    Call<News> getNews(@Query(COUNTRY) String country , @Query(API_KEY) String apiKey);

}
