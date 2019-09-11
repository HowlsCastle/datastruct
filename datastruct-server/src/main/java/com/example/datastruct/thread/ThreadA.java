package com.example.datastruct.thread;

public class ThreadA implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("lock1 running");

            while (true) {
                synchronized (Dead.obj1) {
                    System.out.println("lock obj1");
                    Thread.sleep(2000);
                    synchronized (Dead.obj2) {
                        System.out.println("lock obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
