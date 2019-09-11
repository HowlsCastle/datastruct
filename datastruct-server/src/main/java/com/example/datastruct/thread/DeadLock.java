package com.example.datastruct.thread;

public class DeadLock {
    private String objectId;

    public DeadLock(String id) {
        this.objectId = id;
    }

    public synchronized void checkOther(DeadLock other) {
        System.out.println("entering checkOther()");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in checkOther() - about to " + "invoke 'other.action()'");

        other.action();

        System.out.println("leaving checkOther()");
    }

    public synchronized void action() {
        System.out.println("entering action()");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("leaving action()");
    }

    public static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }


    public static void main(String[] args) {
        final DeadLock lock1 = new DeadLock("lock1");
        final DeadLock lock2 = new DeadLock("lock2");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                lock1.checkOther(lock2);
            }
        };
        Thread threadA = new Thread(r1, "threadA");
        threadA.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                lock2.checkOther(lock1);
            }
        };
        Thread threadB = new Thread(r2, "threadB");
        threadB.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPrint("finished sleeping");

        threadPrint("about to interrupt() threadA");
        threadA.interrupt();

        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        threadPrint("about to interrupt() threadB");
        threadB.interrupt();

        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        threadPrint("did that break the deadlock?");
    }
}
