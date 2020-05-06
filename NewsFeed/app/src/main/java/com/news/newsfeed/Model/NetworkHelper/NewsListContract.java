package com.news.newsfeed.Model.NetworkHelper;

import com.news.newsfeed.Model.ApiResponse.News;

public interface NewsListContract {

    interface Model {

        interface OnFinishedListener {

            void onSuccess(News news);

            void onFailure(String message);
        }

        void getNewsList(String country,String apiKey, OnFinishedListener onFinishedListener);
    }

    interface View {

        void setDataToRecyclerView(News news);

        void onResponseFailure(String throwable);

        void showProgress();

        void hideProgress();

    }

    interface Presenter {

        void requestnewsFromServer(String country,String apiKey);

    }
}
