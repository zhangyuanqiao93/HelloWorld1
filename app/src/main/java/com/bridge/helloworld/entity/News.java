package com.bridge.helloworld.entity;

/**
 * Created by Bridge on 2017/12/20.
 */

/**
 * 新闻实体类
 */
public class News {

    private String title;//新闻标题
    private String content;//新闻内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
