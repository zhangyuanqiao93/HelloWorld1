package com.bridge.helloworld.entity;


import org.litepal.crud.DataSupport;//手动引入
/**
 * Created by Bridge on 2018/1/2.
 *
 */


/**
 * Book 实体，验证litepal数据库
 */
public class Book extends DataSupport {

    private Integer id;//Book类主键
    private String name;//书名
    private String author;//作者
    private Double price;//价格
    private Integer pages;//页数

    //添加一个字段，press,出版社
    private String press;

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
