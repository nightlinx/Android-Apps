package com.example.anna.zad4.data;


public class AnotherData {
    private String name;
    private String price;
    private boolean isSport;

    public AnotherData(String name, String price, boolean isSport) {
        this.name = name;
        this.price = price;
        this.isSport = isSport;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ", " + price + ", " + isSport;
    }
}