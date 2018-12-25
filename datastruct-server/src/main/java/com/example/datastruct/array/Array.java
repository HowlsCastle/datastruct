package com.example.datastruct.array;

public class Array {
    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    public Array(int n) {
        this.data = new int[n];
        this.n = n;
        this.count = 0;
    }

    public boolean insert(int position, int value) {
        if (count == n) {
            return false;
        }

        if (position < 0 || position > count) {
            return false;
        }

        for(int i=count; i>position;i--) {
            data[i] = data[i-1];
        }
        data[position] = value;
        count++;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];

    }

    public boolean contains(int value) {
        for (int i = 0; i < count;i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for(int i=index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
//        array.insert(3, 11);
        array.printAll();
        array.delete(0);
        array.printAll();
        array.insert(3, 11);
        array.printAll();

        System.out.println(array.contains(3));

    }

}
