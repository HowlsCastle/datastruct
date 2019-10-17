package com.example.datastruct.string;

/**
 * 两个字符串的最大公约数
 */
public class GcdString {

    public static String gcdString(String a, String b) {
        if (!(a+b).equals(b+a)) {
            return "";
        }

        int n = Math.min(a.length(), b.length());
        for(int i=n;i>0;i--) {
            String s = a.substring(0, i);
            if (a.split(s).length ==0 && b.split(s).length == 0) {
                return s;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String str1 ="ABCABC";
        String str2 ="ABC";

        System.out.println(gcdString(str1, str2));
    }
}
