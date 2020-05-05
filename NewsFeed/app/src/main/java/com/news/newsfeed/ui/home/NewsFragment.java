package com.news.newsfeed.ui.home;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.news.newsfeed.R;
import com.news.newsfeed.ui.Adapter.NewsItemAdapter;
import com.news.newsfeed.ui.Adapter.SlidingMenuAdapter;


public class NewsFragment extends Fragment {

    RecyclerView newsItems;
    NewsItemAdapter itemAdapter;

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
        // set news adapter
        itemAdapter = new NewsItemAdapter(getContext());
        newsItems.setAdapter(itemAdapter);
    }
}
