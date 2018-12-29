package com.example.datastruct.sort;

import java.util.Random;

public class BubbleSort {
    public void bubbleSort(int[] list) {
        int tmp = 0;
        for (int i=0;i < list.length-1; i++) {
            for (int j=1; j< list.length-i;j++) {
                if (list[j] < list[j-1]) {
                    tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
            }
            System.out.format("第 %d 趟： length: %d     i", i, list.length);
            printAll(list);
        }

//        printAll(list);
    }

    public void bubbleSort1(int[] list) {
        int temp = 0; // 用来交换的临时数

        // 要遍历的次数
        for (int i = 0; i < list.length; i++) {
            // 从后向前依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length-1; j > i; j--) {
                // 比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }

            System.out.format("第 %d 趟：	", i);
            printAll(list);
        }
//        printAll(list);

    }

    public void bubbleSort2(int[] list) {
        int tmp = 0;
        boolean flag = false;
        for (int i=0;i < list.length-1; i++) {
            for (int j=1; j< list.length-i;j++) {
                if (list[j] < list[j-1]) {
                    tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
//            System.out.format("第 %d 趟： length: %d     i", i, list.length);
//            printAll(list);
        }

        printAll(list);
    }

    public void printAll(int[] list) {

        for(int item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        final int MAX_SIZE = 10;
        int[] array = new int[MAX_SIZE];
        Random random = new Random();
        for (int i = 0; i < MAX_SIZE; i++) {
            array[i] = random.nextInt(MAX_SIZE);
//            array[i] = i;
        }

        int[] array1 = array.clone();



        BubbleSort bubble = new BubbleSort();
        bubble.printAll(array);
        System.out.println("===========================");
        bubble.bubbleSort(array);
        System.out.println("------------");
        bubble.bubbleSort1(array1);
    }

}
