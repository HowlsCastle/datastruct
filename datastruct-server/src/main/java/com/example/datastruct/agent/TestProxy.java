package com.example.datastruct.agent;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void getCarInfo(Car car) {
        car.getPrice();
        car.getName();
    }

    public static void main(String[] args) {
        //代理对象需要持有被代理对象的引用,用于做请求的转发
        Car car1 = new SimpleProxy(new Bicycle());
        getCarInfo(car1);

        Bicycle bicycle = new Bicycle();
        //使用Proxy创建一个动态代理
        Car car = (Car) Proxy.newProxyInstance(bicycle.getClass().getClassLoader(), new Class<?>[]{Car.class}, new DynamicProxyHandler(bicycle));
        getCarInfo(car);

    }
}
