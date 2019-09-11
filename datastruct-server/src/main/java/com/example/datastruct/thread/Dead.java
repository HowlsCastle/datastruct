package com.example.datastruct.thread;

public class Dead {

    public static String obj1 = "obj1";
    public static  String obj2 = "obj2";

    public static void main(String[] args) {

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
