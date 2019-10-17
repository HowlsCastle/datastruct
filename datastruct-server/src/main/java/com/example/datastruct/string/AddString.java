package com.example.datastruct.string;

public class AddString {

    public static String addString(String a, String b) {
        String ret = "";
        int lena = a.length()-1;
        int lenb = b.length()-1;
        int flag = 0;

        while (lena >=0 || lenb >=0) {
            int x = (lena >=0) ? a.charAt(lena--) - '0' : 0;
            int y = (lenb >=0) ? b.charAt(lenb--) - '0' : 0;

            int sum = x + y + flag;
            ret += ((sum % 10)+"");
            flag = sum / 10;
        }

        if (flag > 0) {
            ret += flag + "";
        }

        return new StringBuilder(ret).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addString("123", "9889"));
    }
}
