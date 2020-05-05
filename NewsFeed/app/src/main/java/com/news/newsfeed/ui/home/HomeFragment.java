package com.news.newsfeed.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.news.newsfeed.R;
import com.news.newsfeed.Util.Constants;
import com.news.newsfeed.ui.Adapter.NewsItemAdapter;
import com.news.newsfeed.ui.Adapter.SlidingMenuAdapter;

public class HomeFragment extends Fragment {

    private ViewPager menuPager;
    private TabLayout menuTabs;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        registerViews(root);
        setUpTabLayout();
        return root;
    }

    private void registerViews(View view)
    {
        menuPager = view.findViewById(R.id.viewpager_headlines);
        menuTabs = view.findViewById(R.id.tablayout_headlines);
    }

    private void setUpTabLayout()
    {
        // set up sliding menu with tab view and viewpager
        if (getActivity() != null) {
            SlidingMenuAdapter viewPager = new SlidingMenuAdapter(getChildFragmentManager(), Constants.categories);
            menuPager.setAdapter(viewPager);
            menuTabs.setupWithViewPager(menuPager);

        }
    }

}
