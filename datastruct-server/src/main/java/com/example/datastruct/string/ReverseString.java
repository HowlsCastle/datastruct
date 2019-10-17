package com.example.datastruct.string;

public class ReverseString {
    public static String reverseString(String s, int k) {
        int len = s.length();
        int i = 0;
        char[] arr = s.toCharArray();
        while (i< len) {
            int j = Math.min(i+k-1, len);
            swap(arr, i, j);
            i += 2 * k;
        }

        return String.valueOf(arr);
    }

    public static void swap(char[] arr, int l, int h) {
        while (l < h) {
            char temp = arr[l];
            arr[l++] = arr[h];
            arr[h--] = temp;
        }
    }

    public static String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            swap(c, i, Math.min(i + k-1, s.length()));
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefg", 2));
        System.out.println(reverseStr("abcdefg", 2));
    }
}
