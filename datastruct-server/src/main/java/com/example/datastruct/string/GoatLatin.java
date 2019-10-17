package com.example.datastruct.string;

public class GoatLatin {
    public static String goatLatin(String s) {

        StringBuilder builder = new StringBuilder("");

        String[] arr = s.split("\\s+");

        String vowels = "aeiou";
        StringBuilder suffix = new StringBuilder("a");

        for(String str : arr) {
            if (vowels.indexOf(str.charAt(0)) != -1) {
                builder.append("ma").append(suffix).append(" ");
            } else {
                builder.append(str.substring(1, str.length())).append(str.charAt(0)).append("ma").append(suffix).append(" ");
            }
            suffix.append("a");
        }

        return builder.toString().trim();
    }

    public static void main(String[] args) {
        String s = "I speak Goat Latin";

        System.out.println(goatLatin(s));
    }
}
