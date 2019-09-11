package com.example.datastruct.thread;

public class Interrupt implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("in run() -- about sleep 20s");
            Thread.sleep(20000);
            System.out.println("in run() -- woke up");
        } catch (InterruptedException e) {
            System.out.println("in run() -- interrupt while sleep");
            return;
        }
        System.out.println("in run() -- leaving normal");
    }

    public static void main(String[] args) {

        /*Thread t = Thread.currentThread();
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
        //待决中断，中断自身
        t.interrupt();
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());

        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch( InterruptedException x){
            System.out.println("was interrupted");
        }
        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());*/

        /*Interrupt interrupt = new Interrupt();
        Thread thread = new Thread(interrupt);

        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() -- interrupt other");
        thread.interrupt();
        System.out.println("in main() -- leaving");*/

        /*if (args.length ==0) {
            Thread.currentThread().interrupt();
        }
        long start = System.currentTimeMillis();
        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");

        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }
        System.out.println("time -- " + (System.currentTimeMillis()-start));*/
    }
}
