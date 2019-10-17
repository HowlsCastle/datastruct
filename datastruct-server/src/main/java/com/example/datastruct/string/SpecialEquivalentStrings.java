package com.example.datastruct.string;

import java.util.Arrays;
import java.util.HashSet;

public class SpecialEquivalentStrings {

    public int specialEquivalentStrings(String[] strs) {
        HashSet<String> unique = new HashSet<>();

        for(String s : strs) {
            int[] a = new int[52];
            int len = s.length();

            for(int j=0;j<len;j++) {
                a[s.charAt(j)-'a'+26*(j%2)]++;
            }

            System.out.println(Arrays.toString(a));
            unique.add(Arrays.toString(a));
        }

        return unique.size();
    }

    public static void main(String[] args) {
        String[] s = {"a","b","c","a","c","c"};
        SpecialEquivalentStrings specialEquivalentStrings = new SpecialEquivalentStrings();
        System.out.println(specialEquivalentStrings.specialEquivalentStrings(s));

        String[] a = {"aa","bb","ab","ba"};
        System.out.println(specialEquivalentStrings.specialEquivalentStrings(a));

        String[] b = {"abc","acb","bac","bca","cab","cba"};
        System.out.println(specialEquivalentStrings.specialEquivalentStrings(b));

        String[] c = {"abcd","cdab","adcb","cbad"};
        System.out.println(specialEquivalentStrings.specialEquivalentStrings(c));
    }
}
