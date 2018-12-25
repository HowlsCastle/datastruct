package com.example.datastruct.array;

public class DynamicArray<T> {
    private T[] data;

    private int size;


    public DynamicArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T value) {
        for(int i=0;i<size;i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public int find(T value) {
        for(int i=0;i<size;i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void add (int index, T value) {
        checkIndex(index);
        if (size == data.length) {
            resize(2*size);
        }

        for(int i=size-1;i>=index;i--) {
            data[i+1] = data[i];
        }
        data[index] = value;
        size++;
    }

    public void addFirst(T value) {
        add(0, value);
    }

    public void addLast(T value) {
        add(size, value);
    }

    public T remove(int index) {
        checkIndex(index);
        T ret = data[index];
        for(int i = index+1;i < size;i++) {
            data[i] = data[i-1];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size-1);
    }

    public void removeElement(T value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }

    public void printArray() {
        for(int i=0;i<size;i++) {
            System.out.println(data[i]);
        }
    }

    public void resize(int resize) {
        T[] tmp = (T[]) new Object[resize];
        for(int i =0;i<size;i++) {
            tmp[i] = data[i];
        }
        data = tmp;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error！index =0 and index < size");
        }
    }


    public static void main(String[] args) {
        DynamicArray<String> test = new DynamicArray<>();
        test.addFirst("3");
        test.addFirst("2");
        test.addFirst("1");
        test.printArray();
    }
}
