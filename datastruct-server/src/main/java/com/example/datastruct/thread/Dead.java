package com.example.datastruct.thread;

public class Dead {

    public static String obj1 = "obj1";
    public static  String obj2 = "obj2";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable实现类的调用：");
            }
        }){
            @Override
            public void run() {
                System.out.println("继承Thread的调用：");
            }
        }.start();



        String s = "abc";

        System.out.println(s.hashCode());
        s = "ber";
        System.out.println(s.hashCode());


        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());

        threadA.start();
        threadB.start();

    }
}
