package com.bridge.helloworld.adapter;

/**
 * Created by Bridge on 2017/12/12.
 */

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bridge.helloworld.R;
import com.bridge.helloworld.entity.Fruit;

import java.util.List;

/**
 * 定义一个RecyclerView
 */
public class FruitRecyclerAdapter2 extends RecyclerView.Adapter<FruitRecyclerAdapter2.ViewHolder> {

    private List<Fruit> mFruitList;
    private static final String TAG = "FruitRecyclerAdapter2";

    /**
     * 内部类继承自RecyclerView.ViewHolder
     */
    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fruitImage;
        private TextView fruitName;

        View fruitView;

        //内部类构造函数，这个子项通常就是RecyclerView子项的最外层布局，可以通过寻找Id的方法找到。
        public ViewHolder(View view) {
            super(view);
            fruitView = view;

            fruitImage =  view.findViewById(R.id.fruit_image2);
            fruitName =  view.findViewById(R.id.fruit_name2);

        }


    }


    /**
     * 用于创建ViewHolder对象
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: " + viewType);

        /**
         * *********************************************************
         * R.layout.recycler_item
         * 注意引入布局时适配正确的布局，并且和相对应的id以及image对应
         * *********************************************************
         */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item,parent,false);

        /**
         * ************************
         * 注册点击事件
         * ************************
         */
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"You clicked image  "+ fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        //ViewHolder viewHolder = new ViewHolder(view);
        //return viewHolder;

        return holder;
    }


    /**
     * 将要展示的数据源传递进来，并且赋值给一个全局变量
     * @param fruitList
     */
    public FruitRecyclerAdapter2(List<Fruit> fruitList){
        mFruitList = fruitList;
    }


    /**
     * 对每个子项进行赋值，会在每个子项滚动到屏幕的时候加载
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    /**
     * 获取总数子项
     * @return
     */
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
