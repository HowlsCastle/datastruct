package com.example.datastruct.sort;

public class MergeSort {
    public static void mergeSort(int[] a) {
        if (a == null) return;
        mergeSort(a, 0, a.length-1);
    }

    public static void mergeSort(int[] a, int low, int high) {
        if (low >= high) return;

        int mid = low + ((high-low) >> 1);

        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[a.length];


        int start1 = low;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = high;
        int pos = start1;
        int index = low;
        while (start1<=end1 && start2<=end2) {
            if (a[start1] < a[start2]) {
                temp[pos++] = a[start1++];
            } else {
                temp[pos++] = a[start2++];
            }
        }
        while (start1 <= end1) {
            temp[pos++] = a[start1++];
        }
        while (start2 <= end2) {
            temp[pos++] = a[start2++];
        }
        while (index <= high) {
            a[index] = temp[index++];
        }
    }


    private static void printArr(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 1, 8, 3, 7, 9, 5};
        mergeSort(arr);
        printArr(arr);
    }
}
