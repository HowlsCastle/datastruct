package com.example.datastruct.basic.thread_concurrent;

import sun.jvm.hotspot.HelloWorld;

public class CycliBarrierTest {


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());


        ClassLoader loader = HelloWorld.class.getClassLoader();
//        loader.loadClass("com.example.datastruct.basic.thread_concurrent.Test2");
//        Class.forName("com.example.datastruct.basic.thread_concurrent.Test2");
        Class.forName("com.example.datastruct.basic.thread_concurrent.Test2", false, loader);
    }
}
