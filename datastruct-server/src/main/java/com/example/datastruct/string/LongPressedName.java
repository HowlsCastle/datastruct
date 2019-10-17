package com.example.datastruct.string;

public class LongPressedName {

    public static boolean longPressedName(String name, String typed) {
        int lenName = name.length();
        int lenTyped = typed.length();

        int i = 0;
        int j = 0;
        while (i < lenName) {
            char c = name.charAt(i);

            int counti = 0;
            int countj = 0;
            while (i< lenName && name.charAt(i) == c) {
                i +=1;
                counti++;
            }

            while (j < lenTyped && typed.charAt(j) == c) {
                j += 1;
                countj++;
            }

            if (countj < counti) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longPressedName("alex", "aaleex"));
        System.out.println(longPressedName("saeed", "ssaaedd"));
        System.out.println(longPressedName("leelee", "lleeelee"));
        System.out.println(longPressedName("laiden", "laiden"));
    }
}
