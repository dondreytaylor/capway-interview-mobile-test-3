package com.news.newsfeed.Presenter;

import android.content.Context;

import com.news.newsfeed.Model.ApiResponse.News;
import com.news.newsfeed.Model.NetworkHelper.NewsListContract;
import com.news.newsfeed.Model.NetworkManager.NewsModel;

public class NewsListPresenter implements NewsListContract.Presenter, NewsListContract.Model.OnFinishedListener {

    private NewsListContract.View newsListView;

    private NewsListContract.Model newsListModel;

    public NewsListPresenter(NewsListContract.View newsListView, Context context) {
        this.newsListView = newsListView;
        newsListModel = new NewsModel(context);
    }

    @Override
    public void onSuccess(News news) {
        // let the app know of success response
        newsListView.setDataToRecyclerView(news);
        if (newsListView != null) {
            newsListView.hideProgress();
        }
    }

    @Override
    public void onFailure(String message) {
        newsListView.onResponseFailure(message);
        if (newsListView != null) {
            newsListView.hideProgress();
        }
    }


    @Override
    public void requestnewsFromServer(String country, String apiKey) {
        if (newsListView != null) {
            newsListView.showProgress();
        }
        newsListModel.getNewsList(country,apiKey,this);
    }
}
