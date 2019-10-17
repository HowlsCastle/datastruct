package com.example.datastruct.sort;

public class BinarySearch {
    public static int binaruSearch(int[] a, int value) {
        if (a == null) return -1;

        int low = 0;
        int high = a.length-1;

        if (value < a[low] || value > a[high]) return -1;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] ==value) {
                return mid;
            } else if (a[mid] > value) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findFirtElement(int[]a, int value) {
        if (a == null) return -1;
        int low = 0;
        int high = a.length;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] < value) {
                low = mid +1;
            } else if (a[mid] > value) {
                high = mid-1;
            } else {
                if (mid == 0 || a[mid-1] != value) return mid;
                high = mid-1;
            }
        }
        return -1;
    }

    public static int findLastElement(int[] a, int value) {
        if (a == null) return -1;
        int low = 0;
        int high = a.length;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] < value) {
                low = mid +1;
            } else if (a[mid] > value) {
                high = mid-1;
            } else {
                if (mid == a.length-1 || a[mid+1] != value) return mid;
                high = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于某个数的位置
     */
    public static int findFirstLargeEqual(int[] a, int value) {
        if (a == null) return -1;
        int low = 0;
        int high = a.length;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] < value) {
                low = mid +1;
            } else if (a[mid] > value) {
                high = mid-1;
            } else {
                if (mid == 0 || a[mid-1] < value) return mid;
                high = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个一个小于等于某个数的位置
     */
    public static int findFirstLittleEqual(int[] a, int value) {
        if (a == null) return -1;
        int low = 0;
        int high = a.length;
        while (low <= high) {
            int mid = low + ((high-low) >> 2);
            if (a[mid] < value) {
                low = mid +1;
            } else if (a[mid] > value) {
                high = mid-1;
            } else {
                if (mid == a.length-1 || a[mid+1] > value) return mid;
                high = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int key = 9;

        System.out.println(binaruSearch(arr, key));
    }
}
