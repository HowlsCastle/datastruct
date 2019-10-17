package com.example.datastruct.string;

import java.util.Arrays;

public class RemoveVowels {
    public String removeVowels(String str) {
        Character[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        StringBuffer buffer = new StringBuffer(str);

        for(int i=0;i<buffer.length();i++) {
            if (Arrays.asList(chars).contains(buffer.charAt(i))) {
                buffer.replace(i, i+1, "");
                i--;
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        RemoveVowels removeVowels = new RemoveVowels();
        String str = "GeeeksforGeeks - A Computer Science Portal for Geeks";
        str = str.replaceAll("[AaEeIiOoUu]", "");
        System.out.println(str);


//        System.out.println(removeVowels.removeVowels(str));
    }
}
