package com.bridge.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bridge.helloworld.R;


/**
 * Created by Bridge on 2017/12/20.
 */

public class NewsContentFragment extends Fragment{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.new_content_frags,container,false);

        return view;
    }

    /**
     * 更新标题和内容refresh();
     * @param newsTitle
     * @param newsContent
     */
    public void refresh(String newsTitle,String newsContent){

        View visibility_layout = this.view.findViewById(R.id.visibility_layout);
        visibility_layout.setVisibility(View.VISIBLE);
        TextView newsTitleText = view.findViewById(R.id.news_title);
        TextView newsTitleContent = view.findViewById(R.id.news_content);


        newsTitleText.setText(newsTitle);//刷新新闻标题
        newsTitleContent.setText(newsContent);//刷新新闻内容

    }
}
