package com.example.datastruct.offer;

public class PrintNum {
    public void printMaxNum(int n) {
        if (n<=0) {
            System.out.println("n 不存在意义");
            return;
        }
        int[] arr = new int[n];
        for (int i=0; i<n;i++) {
            arr[i] = 0;
        }


        while (!increment(arr)) {
            print(arr);
        }
    }


    public boolean increment(int[] arr) {
        boolean overflow = false;
        int n = arr.length;
        int flag = 0;

        for (int i=0;i<n;i++) {
            int sum = arr[i] + flag;
            if (i == 0) {
                sum++;
            }

            if (sum>=10) {
                if (i==n-1) {
                    overflow = true;
                }
                sum -= 10;
                flag = 1;
                arr[i] = sum;
            } else {
                arr[i] = sum;
                break;
            }
        }
        return overflow;
    }

    public void print(int[] arr) {
        int n = arr.length;
        boolean isBegin = true;
        for (int i=n-1;i>=0;i--) {
            if (arr[i] != 0 && isBegin) {
                isBegin = false;
            }
            if (!isBegin) {
                System.out.print(arr[i]);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        printNum.printMaxNum(390);
    }
}
