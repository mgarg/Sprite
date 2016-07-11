package com.example.mahak.myfirst;

import java.util.List;

/**
 * Created by Mahak Garg on 11-07-2016.
 */
class MyItem{
    String name;
    int limit;
    int[] imgs;

    public MyItem(String name, int limit, int[] imgs) {
        this.name = name;
        this.limit = limit;
        this.imgs = imgs;
    }

    public MyItem(String name, int limit) {
        this.name = name;
        this.limit = limit;

    }
}
