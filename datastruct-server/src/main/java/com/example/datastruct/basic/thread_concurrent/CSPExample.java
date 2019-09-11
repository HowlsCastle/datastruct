package com.example.datastruct.basic.thread_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CSPExample {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(1);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.submit(new GenerateNum(5, 700, blockingQueue));
        executor.submit(new GenerateNum(7, 650, blockingQueue));
        executor.submit(new GenerateNum(11, 400, blockingQueue));


        Future total = executor.submit(new SumProcess(blockingQueue));
        int totalNum = 0;
        try {
            totalNum = (int) total.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("the total num:" + totalNum);

        executor.shutdownNow();

    }

    private static class GenerateNum implements Runnable {

        private BlockingQueue blockingQueue;

        private int numberToGenerate;

        private int sleepPeriod;

        public GenerateNum(int numberToGenerate, int sleepPeriod, BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.numberToGenerate = numberToGenerate;
            this.sleepPeriod = sleepPeriod;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(sleepPeriod);
                    System.out.println(numberToGenerate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    blockingQueue.put(numberToGenerate);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SumProcess implements Callable {
        private BlockingQueue blockingQueue;

        public SumProcess(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public Object call() throws Exception {
            int sum = 0;
            while(sum < 100) {
                int num = (int)blockingQueue.take();
                sum += num;
                System.out.println("Got " + num + ", total is " + sum);
            }
            return sum;
        }
    }
}
