package com.news.newsfeed.ui.NewsDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.newsfeed.R;
import com.news.newsfeed.ui.BaseClass.BaseActivity;

public class NewsDetail extends BaseActivity {

    ImageView newsImage, shareNews;
    TextView title, description,content,author;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_news_detail,false);
        registerViews();
    }

    private void registerViews()
    {
        shareNews = findViewById(R.id.toolbar_icon);
        shareNews.setImageResource(R.drawable.share_icon);
        newsImage = findViewById(R.id.news_image);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        content = findViewById(R.id.content);
        author = findViewById(R.id.author);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
