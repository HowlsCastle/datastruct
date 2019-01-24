package com.example.datastruct.string;

import com.example.datastruct.array.Array;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.HashSet;

public class PreStr {
    /**
     * 最长匹配前缀
     * @param strs
     * @return
     */
    public static String largePreStr(String[] strs) {
        int len = strs.length;
        if (strs == null || len == 0) {
            return "";
        }

        StringBuilder ret = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[len-1];
        int min = Math.min(first.length(), last.length());

        for(int i=0;i<min;i++) {
            if (first.charAt(i) == last.charAt(i)) {
                ret.append(first.charAt(i));
            } else {
                break;
            }
        }
        return ret.toString();

    }

    /**
     * 给定一个字符串构造最大回文
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> hashSet = new HashSet<>();

        char[] arr = s.toCharArray();
        int count = 0;
        for (int i=0;i< arr.length;i++) {
            if (!hashSet.contains(arr[i])) {
                hashSet.add(arr[i]);
            } else {
                hashSet.remove(arr[i]);
                count++;
            }
        }

        return hashSet.isEmpty() ? 2 * count : 2 * count +1;
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        int left = 0;
        int right = len -1;
        while(left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {

                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = { "customer", "cur", "cut" };
        System.out.println(PreStr.largePreStr(strs));

        System.out.println(PreStr.longestPalindrome("abccccdd"));

        System.out.println(PreStr.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(PreStr.isPalindrome("race a car"));
    }
}
