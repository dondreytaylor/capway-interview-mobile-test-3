package com.news.newsfeed.ui.NewsDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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
        setupShareButton(getString(R.string.dummy_content));
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

    private void setupShareButton(final String article) {
        shareNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // default share intent of mobile will open and news content will be shared through chosen item
                Intent intent = new Intent(Intent.ACTION_SEND);
                //String shareText = article.getTitle() + "\n" + article.getUrl();
                String shareText = article;
                intent.putExtra(Intent.EXTRA_TEXT, shareText);
                intent.setType("text/plain");

                startActivity(intent);
            }
        });
    }
}
