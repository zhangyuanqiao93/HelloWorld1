package com.bridge.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.bridge.helloworld.entity.Fruit;
import com.bridge.helloworld.adapter.FruitAdapter;
import com.bridge.helloworld.util.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity {

    //定义一个String数组存放水果名称列表
    private String[] data = {"Apple","Banana","Orange","Watermelon",
            "Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
            "Apple","Banana","Orange","Watermelon", "Pear","Grape",
            "Pineapple","Strawberry","Cherry","Mango"};

    private List<Fruit> fruitList = new ArrayList<>();
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initFruits();
        //借助适配器将数组数据传递给listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,
                android.R.layout.simple_list_item_1,data);

        FruitAdapter adapter1 = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        listView = findViewById(R.id.list_view);
        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });


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
}
