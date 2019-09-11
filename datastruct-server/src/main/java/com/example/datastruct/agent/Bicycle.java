package com.example.datastruct.agent;

public class Bicycle implements Car {
    private double price = 200;
    private String name  = "bicycle";

    @Override
    public double getPrice() {
        System.out.println("bicycle's price is " + price);
        return price;
    }

    @Override
    public String getName() {
        System.out.println("name is " + name);
        return name;
    }
}
