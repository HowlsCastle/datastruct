package com.example.datastruct.string;

public class CountBinarySubStr {
    public static int countBinarySubStr(String s) {
        int zero = 0;
        int one = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if (i==0) {
                if (chars[i] == '1') ++one;
                else ++zero;

            } else {
                if (chars[i] == '1') {
                    one = ((chars[i-1] == '1') ? one+1 : 1);
                    if (zero >= one) ++count;
                } else if (chars[i] == '0') {
                    zero = ((chars[i-1] == '0') ? zero+1 : 1);
                    if (one>=zero) ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubStr("00110011"));
    }
}
