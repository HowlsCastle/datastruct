package com.example.datastruct.thread;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {
    private final CountDownLatch startSingnal;

    Worker(CountDownLatch countDownLatch) {
        startSingnal = countDownLatch;
    }
    @Override
    public void run() {

//            startSingnal.await();
        doWork();
        startSingnal.countDown();

    }

    public void doWork() {
        System.out.println("doWork.....");
    }
}
