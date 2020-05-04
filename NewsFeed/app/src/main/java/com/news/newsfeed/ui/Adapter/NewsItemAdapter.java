package com.news.newsfeed.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.news.newsfeed.R;
import com.news.newsfeed.ui.NewsDetail.NewsDetail;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;

    public NewsItemAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //setNewsData(holder,position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,author,date;
        ImageView newsImage;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            registerView();
            registerListener();
        }

        private void registerView()
        {
            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            date = view.findViewById(R.id.date);
            newsImage = view.findViewById(R.id.news_image);
        }
        private void registerListener()
        {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity(NewsDetail.class);
                }
            });
        }
        public void openActivity(Class activtyToLaunch) {
            Intent intent = new Intent(context, activtyToLaunch);
            context.startActivity(intent);
        }


    }
}
