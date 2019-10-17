package com.example.datastruct.string;

public class FirstUniqueCharacter {

    public static int firstUniqueCharacter(String s) {
        int[] num = new int[26];
        for(int i=0;i<s.length();i++) {
            num[s.charAt(i)-'a']++;
        }

        for(int j=0;j<s.length();j++) {
            if (num[s.charAt(j)-'a'] ==1) {
                return j;
            }
        }

        return -1;
    }

    public static int firstUnique(String s) {
        for(int i=0;i< s.length();i++) {
            if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("leetcode"));
        System.out.println(firstUnique("leetcode"));

        System.out.println(firstUniqueCharacter("loveleetcode"));
        System.out.println(firstUnique("loveleetcode"));
    }
}
