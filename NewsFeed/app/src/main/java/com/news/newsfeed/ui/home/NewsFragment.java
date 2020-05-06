package com.news.newsfeed.ui.home;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.news.newsfeed.Model.ApiResponse.News;
import com.news.newsfeed.Model.NetworkHelper.NewsListContract;
import com.news.newsfeed.Presenter.NewsListPresenter;
import com.news.newsfeed.R;
import com.news.newsfeed.Util.Constants;
import com.news.newsfeed.ui.Adapter.NewsItemAdapter;
import com.news.newsfeed.ui.Adapter.SlidingMenuAdapter;

import static com.news.newsfeed.Model.NetworkHelper.ApiConstants.SERVER_KEY;


public class NewsFragment extends Fragment implements NewsListContract.View {

    private RecyclerView newsItems;
    private NewsItemAdapter itemAdapter;
    private NewsListPresenter newsListPresenter;
    private ProgressBar progressBar;

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.news_fragment, container, false);
        registerViews(root);
        return root;
    }
    private void registerViews(View view)
    {
        newsItems = view.findViewById(R.id.news_item);
        progressBar = view.findViewById(R.id.progress);
        newsListPresenter = new NewsListPresenter(this,getContext());
        newsListPresenter.requestnewsFromServer(Constants.getCountry(),SERVER_KEY);
    }

    @Override
    public void setDataToRecyclerView(News news) {
        // set news adapter
        itemAdapter = new NewsItemAdapter(getContext(),news.getArticle());
        newsItems.setAdapter(itemAdapter);
    }

    @Override
    public void onResponseFailure(String throwable) {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
