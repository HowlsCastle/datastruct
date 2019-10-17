package com.example.datastruct.string;

public class LongestUncommonSubStr {

    public static int longestUncommonSubStr(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
