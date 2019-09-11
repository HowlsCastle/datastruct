package com.example.datastruct.array;

public class sortArrayByParityII {
    public static int[] sort(int[] a) {
        int j = 1;
        int len = a.length;
        for(int i=0; i< len;i+=2) {
            if ((a[i] & 1) == 1) {
                while((a[j] & 1) == 1) {
                    j += 2;
                }

                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[] {4,2,5,7};

        int[] b = sort(a);

        for(int i=0;i<b.length;i++) {
            System.out.println(b[i]);
        }
    }
}
