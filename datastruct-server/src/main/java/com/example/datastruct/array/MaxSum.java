package com.example.datastruct.array;


public class MaxSum {
    public static int getMaxSum(int[] a) {
        int max = 0;
        int great = 0;
        for (int i=0;i<a.length;i++) {

            if (max < 0) {
                max = a[i];
            } else {
                max += a[i];
            }
            if (max > great) {
                great = max;
            }
        }

        return great;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,-2,3,10,-4,-7,-2,-5};

        System.out.println(getMaxSum(a));
    }
}
