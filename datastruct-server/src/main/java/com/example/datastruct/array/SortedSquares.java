package com.example.datastruct.array;

import java.util.Arrays;

public class SortedSquares {
    public static int[] sort(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        for(int i=0;i<len;i++) {
            b[i] = a[i] * a[i];
        }

        Arrays.sort(b);
        return b;
    }

    public static int[] sort1(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        int j = 0;
        while(j<len && a[j] < 0) {
            j++;
        }
        int i = j-1;
        int t = 0;
        while(i>=0 && j < len) {
            if (a[i]*a[i] < a[j]*a[j]) {
                b[t++] = a[i]*a[i];
                i--;
            } else {
                b[t++] = a[j]*a[j];
                j++;
            }
        }

        while(i>0) {
            b[t++] = a[i]*a[i];
            i--;
        }

        while (j < len) {
            b[t++] = a[j]*a[j];
            j++;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[] {-4,-1,0,3,10};
        int[] b =  sort(a);

        for(int i=0;i<b.length;i++) {
            System.out.println(b[i]);
        }


        int[] c =  sort1(a);

        for(int i=0;i<c.length;i++) {
            System.out.println(c[i]);
        }
    }
}
