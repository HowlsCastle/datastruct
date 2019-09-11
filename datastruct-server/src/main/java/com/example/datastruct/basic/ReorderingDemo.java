package com.example.datastruct.basic;

public class ReorderingDemo {
    static int x=0, y=0, a=0, b=0;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++) {
            x=y=a=b=0;
            Thread threada = new Thread(){
                @Override
                public void run() {
                    a=1;
                    x=b;
                }
            };

            Thread threadb = new Thread() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            };

            threada.start();
            threadb.start();
            threada.join();
            threadb.join();

            System.out.println(x + " " + y);
        }

    }
}
