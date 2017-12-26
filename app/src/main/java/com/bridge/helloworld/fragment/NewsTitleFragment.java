package com.bridge.helloworld.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridge.helloworld.R;

/**
 * Created by Bridge on 2017/12/20.
 */

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.new_content_frags,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /**
         * 注意：R.id.news_content_fragment替换为R.id.news_content_layout
         */
        if (getActivity().findViewById(R.id.news_content_fragment) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }
}
