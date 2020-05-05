package com.news.newsfeed.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.news.newsfeed.R;
import com.news.newsfeed.ui.NewsDetail.NewsDetail;
import com.news.newsfeed.ui.home.NewsFragment;

public class SlidingMenuAdapter extends FragmentPagerAdapter {
    private LayoutInflater mInflater;
    private Context context;
    FragmentManager fm;
    private final NewsFragment[] newsFragments;
    String[] categories;

    public SlidingMenuAdapter(FragmentManager fm, String[] categories) {
        super(fm);
        this.fm = fm;
        this.categories=categories;
        newsFragments = new NewsFragment[categories.length];
        for (int i = 0; i < categories.length; i++) {
            // return new fragment with every tab selection
            newsFragments[i] = NewsFragment.newInstance();
        }
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return newsFragments[position];
    }

    @Override
    public int getCount() {
        return newsFragments == null ? 0 : newsFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories[position];
    }
}
