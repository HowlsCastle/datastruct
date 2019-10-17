package com.example.datastruct.string;

import javax.xml.stream.events.Characters;

public class ToLowerCase {
    public String lowerCase(String s) {
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                buffer.append(Character.toString((char)(s.charAt(i) + 32)));
                continue;
            }
            buffer.append(s.charAt(i));
        }

        return buffer.toString();
    }

    public String toLowerCase(String str) {
        char[] s = str.toCharArray();
        for(int i = 0 ; i < str.length() ; i++) {
            if(s[i] >= 'A' && s[i] <= 'Z') {
                s[i] += 32;
            }
        }
        return new String(s);
    }

    public static void main(String[] args) {
        ToLowerCase lowerCase = new ToLowerCase();

        String s = "Hello";
        System.out.println(lowerCase.lowerCase(s));
    }
}
