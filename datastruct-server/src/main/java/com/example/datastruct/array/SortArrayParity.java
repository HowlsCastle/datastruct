package com.example.datastruct.array;

public class SortArrayParity {
    public static int[] sortArray(int[] arr) {
        int len = arr.length;
        int i=0,j=len-1;

        while(i < j) {
//            while(i<j && arr[i] & 1 == 0) i++;
//            while(i<j && arr[j] & 1 == 1) j++;

            if ((arr[i] & 1) > (arr[j] & 1)) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            if ((arr[i] & 1) == 0) i++;
            if ((arr[j] & 1) == 1) j--;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,1,2,4,6};
        int[] b =  sortArray(a);

        for(int i=0;i<b.length;i++) {
            System.out.println(b[i]);
        }

    }
}
