package com.example.datastruct.sort;

public class InsertSort {

    public void insertSorts(int[] a) {
        int len = a.length;

        for (int i=1;i<len;i++) {
            for(int j=i;j>0;j--) {
                if (a[j] < a[j-1]) {
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                } else {
                    break;
                }
            }
        }
    }

    public void insertSort(int[] a) {
        int n = a.length;

        for(int i=1;i<n;i++) {
            int value = a[i];
            int j = i-1;
            for(;j>0;j--) {
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }

    }

    public static void main(String[] args) {
        int[] a = {8,7,6,5,4,2,3,2,2,1};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSorts(a);
        insertSort.printAll(a);

        insertSort.insertSort(a);
        insertSort.printAll(a);

    }

    public void printAll(int[] list) {

        for(int item : list) {
            System.out.println(item);
        }
    }


    public static void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        for (int i = 0; i < max + 1; ++i) {
            c[i] = 0;
        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i-1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤了，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]]-1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
