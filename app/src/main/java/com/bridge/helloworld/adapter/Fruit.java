package com.bridge.helloworld.adapter;

/**
 * Created by Bridge on 2017/12/11.
 */


/**
 * function:定义一个实体类，作为listview适配器的适配类型
 * date:2017/12/11
 * author:bridge
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
