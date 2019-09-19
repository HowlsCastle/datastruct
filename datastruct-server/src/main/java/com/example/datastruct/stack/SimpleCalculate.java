package com.example.datastruct.stack;

import java.util.Stack;

public class SimpleCalculate {
    public int result(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> ret = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char a = s.charAt(i);
            if (Character.isDigit(a)) {
                int cur = a - '0';
                while(i+1< s.length() && Character.isDigit(s.charAt(i+1))) {
                    cur = cur*10+s.charAt(++i) - '0';
                }

                res = cur * sign;
            } else if (a == '+') {
                sign = 1;
            } else if (a == '-') {
                sign = -1;
            } else if (a == '(') {
                ret.push(res);
                res = 0;
                ret.push(sign);
                sign = 1;
            } else if (a == ')') {
                res = ret.pop() * res + ret.pop();
            }
        }
        return res;
    }
}
