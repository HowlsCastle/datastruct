package com.example.datastruct.string;

public class ReverseOnlyLetter {

    public static String reverseOnlyLetter(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length -1;
        while (l < r) {
            while (l < r && !Character.isLetter(chars[l])) l++;
            while (l < r && !Character.isLetter(chars[r])) r--;

            if (l >= r) break;
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetter(s));
    }
}
