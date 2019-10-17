package com.example.datastruct.sort;

import java.util.Arrays;

public class SelectSort {

    public static int[] selectSort(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++) {
            int temp = a[i];
            int minFlag = i;
            for(int j=i+1;j<n;j++) {
                if (a[j] < temp) {
                    temp =a[j];
                    minFlag = j;
                }
            }
            if (i != minFlag) {
                a[minFlag] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int a[] = { 49,38,65,97,76,13,27,49 };
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
