package com.example.datastruct.queue;

import java.util.Arrays;

public class CircularQueue {

    private int[] list;
    private int head, tail, length;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        head = 0;
        tail = 0;
        length = k+1;
        list = new int[k+1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        list[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head +1) % length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return list[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) return -1;
        System.out.println(tail + "---------");
        for(int i=0;i<list.length;i++) {
            System.out.println(list[i]);
        }
        return list[(tail -1 +length) % length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return tail == head;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % length == head;
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) return 0;
        int[] list = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            list[tasks[i] - 'A']++;
        }
        Arrays.sort(list);
        for(int i=25;i>0;i--) {
            System.out.println(list[i]);
        }
        int num = 0;
        for (int i = 25; i > 0; i--) {
            if (list[i-1] == list[i]) num++;
            else break;
        }
        System.out.println(num);
        int cur = list[25] + (list[25] - 1) * n + num;
        if (tasks.length > cur) return tasks.length;
        else return cur;
    }

    public static void main(String[] args) {
        CircularQueue test = new CircularQueue(3);
        char[] chars = {'A', 'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(test.leastInterval(chars, 2));



        CircularQueue circularQueue = new CircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}
