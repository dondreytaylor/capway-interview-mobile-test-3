package com.news.newsfeed.Model.NetworkManager;

import android.content.Context;
import android.util.Log;


import com.news.newsfeed.Model.ApiResponse.News;
import com.news.newsfeed.Model.NetworkHelper.NewsListContract;
import com.news.newsfeed.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.news.newsfeed.Model.NetworkHelper.ApiConstants.STATUS_OK;

public class NewsModel implements NewsListContract.Model {
    Context context;

    public NewsModel(Context context) {
        this.context = context;
    }


    @Override
    public void getNewsList(String country, String apiKey, final OnFinishedListener onFinishedListener) {
        // get instance of retrofit to initiate network call
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        // get api end point to hit
        Call<News> call;
        call = apiInterface.getNews(country, apiKey);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.body()!=null)
                {
                    if (response.body().getStatus().equals(STATUS_OK))
                    {
                        // tell app that response is successfully fetched
                        onFinishedListener.onSuccess(response.body());
                    }else {
                        // got some error while fetching response
                        onFinishedListener.onFailure(context.getString(R.string.something_wrong_internet));
                    }
                }else {
                    onFinishedListener.onFailure(context.getString(R.string.something_wrong_internet));
                }

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t.toString());
            }
        });
    }
}
