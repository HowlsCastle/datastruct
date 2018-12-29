package com.example.datastruct.sort;

import java.util.Random;

public class QuickSort {

    private void quickSort(int[] list, int left, int right) {

        // 左下标一定小于右下标，否则就越界了
        if (left < right) {
            // 对数组进行分割，取出下次分割的基准标号
            int base = division(list, left, right);


            // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, left, base - 1);

            // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, base + 1, right);
        }
    }

    public int division(int[] list, int low, int high) {

//        if (list.length <= 1) return;
//        if (low > high) return;
        int key = list[low];
//        int i = low;
//        int j = high;
        while(low < high) {
            while(high > low && list[high] >= key) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= key) {
                low++;
            }
            list[high] = list[low];
        }

        list[low] = key;
        return low;

//        quickSort(list, i, low-1);
//        quickSort(list, low+1, j);
    }


    public void sort(int[] list, int low, int high) {
        if (low > high) return;
        int i = low;
        int j = high;
        int key = list[low];
        while(low < high) {
            while(high > low && list[high] >= key) {
                high--;
            }
            list[low] = list[high];
            while (low < high && list[low] <= key) {
                low++;
            }
            list[high] = list[low];
        }

        list[low] = key;

        quickSort(list, i, low-1);
        quickSort(list, low+1, j);
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


        QuickSort quickSort = new QuickSort();

        quickSort.printAll(array);
        System.out.println("=============");
        quickSort.sort(array, 0, MAX_SIZE-1);
        quickSort.printAll(array);
    }
}
