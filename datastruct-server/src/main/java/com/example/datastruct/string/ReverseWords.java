package com.example.datastruct.string;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            str = new StringBuilder(str).reverse().toString();
            sb.append(str+" ");
        }
        return sb.toString().trim();
    }

    public String reverseWord(String s) {
        if (s == null || s.length() == 0) return s;
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            str = reverse(str);
            sb.append(str).append(" ");
        }
        return sb.toString().trim();
    }
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     *
     * 不使用额外空间反转字符串
     */
    public char[] reverseWord(char[] s) {
        int len = s.length;
        for(int i=0;i<len/2;i++) {
            char tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }

        return s;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        char[] c = {'h', 'e', 'l', 'l', 'o'};
        reverseWords.reverseWord(c);

        for(char a : c) {
            System.out.println(a);
        }
    }

}
