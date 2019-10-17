package com.example.datastruct.string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    public static List<String> flipGame(String s) {
        List<String> ret = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length-1;i++) {
            if (chars[i] == chars[i+1] && chars[i] == '+') {
                chars[i] = '-';
                chars[i+1] = '-';
                ret.add(new String(chars));
                chars[i] = '+';
                chars[i+1] = '+';
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String s = "+++++";
        List<String> ret = flipGame(s);

        System.out.println(ret.toString());
    }
}
