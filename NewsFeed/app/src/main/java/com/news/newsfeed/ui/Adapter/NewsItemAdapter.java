package com.news.newsfeed.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.news.newsfeed.Model.ApiResponse.Article;
import com.news.newsfeed.R;
import com.news.newsfeed.ui.NewsDetail.NewsDetail;

import java.util.List;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<Article> newsArticle;

    public NewsItemAdapter(Context context, List<Article> newsArticle) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.newsArticle = newsArticle;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setNewsData(holder,position);
    }

    private void setNewsData(ViewHolder holder,int position)
    {
        if (newsArticle.get(position).getTitle()!=null)
        {
            holder.title.setText(newsArticle.get(position).getTitle());
        }else {
            holder.title.setText(context.getString(R.string.dummy_title));
        }
        if (newsArticle.get(position).getTitle()!=null)
        {
            holder.author.setText(newsArticle.get(position).getAuthor());
        }else {
            holder.author.setText(context.getString(R.string.dummy_author));
        }
        loadImage(holder,position);
    }

    private void loadImage(ViewHolder holder,int position)
    {
        RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(context).load(newsArticle.get(position).getUrlToImage())
                .apply(options)
                .into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return newsArticle.size();
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
