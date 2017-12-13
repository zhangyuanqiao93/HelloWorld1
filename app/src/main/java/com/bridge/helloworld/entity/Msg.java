package com.bridge.helloworld.entity;

/**
 * Created by Bridge on 2017/12/13.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;//接收消息
    public static final int TYPE_SENT = 1;//发送消息

    private String content;//消息的内容
    private int type;//消息的类型

    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
