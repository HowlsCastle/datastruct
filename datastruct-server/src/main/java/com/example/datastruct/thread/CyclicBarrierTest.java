package com.example.datastruct.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {

        int n = 5;
        CyclicBarrier cb = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                System.out.println("****** 所有运动员已准备完毕，发令枪：跑！******");

            }
        });

        List<Thread> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            Thread t = new Thread(new PrepareWork(cb), "运动员[" + i + "]");
            list.add(t);
            t.start();

            if (i == 3) {
                t.interrupt();  // 运动员[3]置中断标志位
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Barrier是否损坏：" + cb.isBroken());
    }
}
