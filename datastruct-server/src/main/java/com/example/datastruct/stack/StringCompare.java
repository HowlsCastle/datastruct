package com.example.datastruct.stack;

import java.util.Stack;

public class StringCompare {
    public boolean compare(String a, String b) {
        Stack<Character> str1 = new Stack<>();
        Stack<Character> str2 = new Stack<>();

        for(int i=0;i< a.length(); i++) {
            if (a.charAt(i) == '#') {
                str1.pop();
            } else {
                str1.push(a.charAt(i));
            }
        }

        for(int i=0;i<b.length();i++) {
            if (b.charAt(i) == '#') {
                str2.pop();
            } else {
                str2.push(b.charAt(i));
            }
        }

        return str1.equals(str2);
    }

    public static void main(String[] args) {
        StringCompare stringCompare = new StringCompare();
        System.out.println(stringCompare.compare("a#c", "b"));
    }
}
