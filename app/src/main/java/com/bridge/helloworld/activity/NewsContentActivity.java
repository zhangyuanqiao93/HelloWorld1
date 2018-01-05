package com.bridge.helloworld.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bridge.helloworld.R;
import com.bridge.helloworld.fragment.NewsContentFragment;
import com.bridge.helloworld.util.BaseActivity;

public class NewsContentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);

        String newsTitle = getIntent().getStringExtra("news_title");//获取传入的消息标题
        String newsContent = getIntent().getStringExtra("news_content");//获取传入的新闻内容

        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_fragment);
        newsContentFragment.refresh(newsTitle,newsContent);//刷新界面NewsContentFragment
    }

    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);

        context.startActivity(intent);
    }
}
