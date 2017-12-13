package com.bridge.helloworld;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bridge.helloworld.entity.Fruit;
import com.bridge.helloworld.adapter.FruitRecyclerAdapter2;
import com.bridge.helloworld.util.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleActivity extends BaseActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initFruits2();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        /**
         * LinearLayoutManager.HORIZONTAL:设置为横向布局
         * */
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//横向布局


        /**
         * *****************************
         * 实现瀑布流布局
         * *****************************
         */
        StaggeredGridLayoutManager layoutManager1 = new StaggeredGridLayoutManager(
                3,StaggeredGridLayoutManager.VERTICAL);


        recyclerView.setLayoutManager(layoutManager1);
        FruitRecyclerAdapter2 fruitRecyclerAdapter2 = new FruitRecyclerAdapter2(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdapter2);
    }

    /**
     * 初始化所有的水果数据，在Fruit类中将对应的水果的名字和相应的图片id传入到其中。
     */
    private void initFruits() {
        for (int i = 0;i<2;i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple2);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.apple2);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.apple2);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.apple2);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear",R.drawable.apple2);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape",R.drawable.apple2);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.apple2);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.apple2);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry",R.drawable.apple2);
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango",R.drawable.apple2);
            fruitList.add(mango);
        }
    }

    private void initFruits2() {
        for (int i = 0;i<2;i++){
            Fruit apple = new Fruit(getRandomLengthName("apple"),R.drawable.apple2);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"),R.drawable.apple2);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.apple2);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"),R.drawable.apple2);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"),R.drawable.apple2);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"),R.drawable.apple2);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.drawable.apple2);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.drawable.apple2);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"),R.drawable.apple2);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengthName("Mango"),R.drawable.apple2);
            fruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length =random.nextInt(20)+1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<length;i++){
            stringBuilder.append(name);
        }

        return stringBuilder.toString();
    }
}
