package com.btzh.mycountdowntimer.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by wyb on 2017/6/29.
 */

public class Book extends DataSupport {
    private int id;
    private String name;
    private String author;
    private double price;
    private int page;
    private String press;



    public void setPress(String press) {
        this.press = press;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPress() {
        return press;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPage() {
        return page;
    }
}
