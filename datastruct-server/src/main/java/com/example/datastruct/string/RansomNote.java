package com.example.datastruct.string;

public class RansomNote {

    public static boolean ransomNote(String ransom, String magezine) {
        int[] num = new int[26];

        for(int i=0;i< magezine.length();i++) {
            num[magezine.charAt(i)-'a']++;
        }

        for(int j=0;j<ransom.length();j++) {
            if (--num[ransom.charAt(j)-'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(ransomNote("a", "b"));
        System.out.println(ransomNote("aa", "ab"));
        System.out.println(ransomNote("aa", "aba"));
    }
}
