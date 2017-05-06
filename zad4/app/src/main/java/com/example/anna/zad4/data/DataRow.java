package com.example.anna.zad4.data;


public class DataRow {
    private String name;
    private String weight;
    private String time;
    private float rating;

    public DataRow(String name, String weight, String time, float rating) {
        this.name = name;
        this.weight = weight;
        this.time = time;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + ", " + weight + ", " + time + ", " + String.valueOf(rating);
    }
}
