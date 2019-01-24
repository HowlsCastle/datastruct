package com.example.datastruct.queue;

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String data) {
        if (tail == n) return false;

        items[tail] = data;
        ++tail;
        return true;
    }

    public boolean dequeue() {
        if (head == n) return false;

        String value = items[head];
        ++head;

        return true;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
