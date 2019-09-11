package com.example.datastruct.agent;

public class SimpleProxy implements Car {
    private Car proxied;

    public SimpleProxy(Car car) {
        this.proxied = car;
    }

    @Override
    public double getPrice() {
        System.out.println("car price is 1000");
        return 1000;
    }

    @Override
    public String getName() {

        return proxied.getName();
    }
}
