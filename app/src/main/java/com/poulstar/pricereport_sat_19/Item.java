package com.poulstar.pricereport_sat_19;

public class Item {
    String name;
    String price;
    String date;
    String base;

    public Item(String name, String price, String date, String base){
        this.name = name;
        this.price = price;
        this.date = date;
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public String getBase() {
        return base;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
