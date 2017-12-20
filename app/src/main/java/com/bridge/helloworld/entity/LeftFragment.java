package com.bridge.helloworld.entity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridge.helloworld.R;

/**
 * Created by Bridge on 2017/12/18.
 */

public class LeftFragment extends Fragment {

    /**
     * 为碎片加载布局（视图）时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //动态加载布局LeftFragment
        View view = inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }
}
