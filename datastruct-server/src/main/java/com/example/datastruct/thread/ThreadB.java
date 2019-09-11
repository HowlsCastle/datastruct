package com.example.datastruct.thread;

public class ThreadB implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("lock2 running");

            while (true) {
                synchronized (Dead.obj2) {
                    System.out.println("lock2 obj2");
                    Thread.sleep(2000);
                    synchronized (Dead.obj1) {
                        System.out.println("lock2 obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
