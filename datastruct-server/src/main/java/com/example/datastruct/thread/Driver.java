package com.example.datastruct.thread;

import java.util.concurrent.CountDownLatch;

public class Driver {
    public static final int n =10;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(n);

        for (int i=0;i<n;i++) {
            new Thread(new Worker(countDownLatch)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doSomething();
//        countDownLatch.countDown();
    }

    public static void doSomething() {
        System.out.println("do something...");
    }
}
