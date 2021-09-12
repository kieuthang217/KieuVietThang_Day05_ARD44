package com.example.myapplication;

import java.io.Serializable;

public class Product implements Serializable {
    public String name;
    public int gia;

    public Product(String name, int gia) {
        this.name = name;
        this.gia = gia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
