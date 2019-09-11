package com.example.datastruct.basic.thread_concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Task implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {

        log.info(Thread.currentThread().getName() + " is waitting");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            log.info("All thread start");
        });


        Thread thread1 = new Thread(new Task(cyclicBarrier));
        Thread thread2 = new Thread(new Task(cyclicBarrier));
        Thread thread3 = new Thread(new Task(cyclicBarrier));

        while(!cyclicBarrier.isBroken()) {
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
