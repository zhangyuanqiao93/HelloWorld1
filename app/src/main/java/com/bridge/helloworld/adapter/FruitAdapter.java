package com.bridge.helloworld.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bridge.helloworld.R;

import java.util.List;

/**
 * Created by Bridge on 2017/12/11.
 */

/**
 * FruitAdapter:显示每个listview的图片和对应的名字
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    //ViewHolder viewHolder;
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Fruit fruit = getItem(position);//获取当前项的Fruit实例;

        /**
         * 将view的性能做优化，缓存在convertView中
         */

        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);

            viewHolder.fruitName = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将view存贮在viewholder中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取viewholder
        }
        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        //ImageView fruitImage = view.findViewById(R.id.fruit_image);
        //TextView fruitName = view.findViewById(R.id.fruit_name);
        assert fruit != null;
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    /**
     * 内部类ViewHolder对于控件的实例进行缓存
     */
    class ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
    }
}
