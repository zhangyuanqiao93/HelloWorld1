package com.bridge.helloworld.entity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bridge.helloworld.R;

/**
 * Created by Bridge on 2017/12/18.
 */

/**
 * 碎片生命周期的测试类
 *
 */
public class RightFragment extends Fragment {

    private static final String TAG = "RightFragment";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: 1");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: 2");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: 3");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 4");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: 5");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 6");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 7");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: 9");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: 10");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: 8");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        Log.d(TAG, "onCreateView: 11");
        View view = inflater.inflate(R.layout.right_fragment,container,false);
        return view;
    }
}
