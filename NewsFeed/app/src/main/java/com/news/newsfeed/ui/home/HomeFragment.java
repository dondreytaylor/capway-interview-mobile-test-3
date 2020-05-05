package com.news.newsfeed.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.news.newsfeed.R;
import com.news.newsfeed.ui.Adapter.NewsItemAdapter;

public class HomeFragment extends Fragment {

    RecyclerView newsItems;
    NewsItemAdapter itemAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
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
