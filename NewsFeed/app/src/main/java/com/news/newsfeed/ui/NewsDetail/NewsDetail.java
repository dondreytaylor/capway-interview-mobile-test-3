package com.news.newsfeed.ui.NewsDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.news.newsfeed.Model.ApiResponse.Article;
import com.news.newsfeed.R;
import com.news.newsfeed.Util.Constants;
import com.news.newsfeed.ui.Adapter.NewsItemAdapter;
import com.news.newsfeed.ui.BaseClass.BaseActivity;

public class NewsDetail extends BaseActivity {

    ImageView newsImage, shareNews;
    TextView title, description,content,author,date;
    Article newsArticle;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_news_detail,false);
        registerViews();
        setNewsData();
        loadImage();
    }

    private void registerViews()
    {
        shareNews = findViewById(R.id.toolbar_icon);
        shareNews.setImageResource(R.drawable.share_icon);
        newsImage = findViewById(R.id.newsImage);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        description = findViewById(R.id.description);
        content = findViewById(R.id.content);
        author = findViewById(R.id.author);

        newsArticle = (Article) getIntent().getSerializableExtra(Constants.NEWS_DETAIL);
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

    private void setNewsData()
    {
        if (newsArticle.getTitle()!=null)
        {
            title.setText(newsArticle.getTitle());
        }else {
            title.setText(getString(R.string.dummy_title));
        }
        if (newsArticle.getAuthor()!=null)
        {
            author.setText(newsArticle.getAuthor());
        }else {
            author.setText(getString(R.string.dummy_author));
        }
        if (newsArticle.getPublishedAt()!=null)
        {
            date.setText(Constants.formatDateForDetails(newsArticle.getPublishedAt()));
        }else {
            date.setText(getString(R.string.dummy_date));
        }
        if (newsArticle.getDescription()!=null)
        {
            description.setText(HtmlCompat.fromHtml(newsArticle.getDescription(), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }else {
            description.setText(getString(R.string.dummy_desc));
        }
        if (newsArticle.getContent()!=null)
        {
            content.setText(HtmlCompat.fromHtml(newsArticle.getContent().replaceAll("(\\[\\+\\d+ chars])", ""), HtmlCompat.FROM_HTML_MODE_LEGACY));
        }else {
            content.setText(getString(R.string.dummy_content));
        }



        setupShareButton(newsArticle.getTitle()+"\n" + newsArticle.getDescription());
    }

    private void loadImage()
    {
        RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(this).load(newsArticle.getUrlToImage())
                .apply(options)
                .into(newsImage);
    }
}
