package com.example.datastruct.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PrepareWork implements Runnable {
    private CyclicBarrier cb;

    PrepareWork(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
//            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + ": 准备完成");
            cb.await();          // 在栅栏等待
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": 被中断");
        } catch (BrokenBarrierException e) {
            System.out.println(Thread.currentThread().getName() + ": 抛出BrokenBarrierException");
        }
    }
}
