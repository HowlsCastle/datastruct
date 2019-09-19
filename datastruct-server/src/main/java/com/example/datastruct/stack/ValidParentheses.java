package com.example.datastruct.stack;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if (a == '(') {
                stack.push(')');
            } else if (a == '{') {
                stack.push('}');
            } else if (a == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != a){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean strIsValid(String s) {
        int len = s.length();
        if (len%2==1 || s == null || len == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char a : s.toCharArray()) {
            if (a == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (a == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            } else if (a == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else {
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "({})([]){}(";
        System.out.println(validParentheses.isValid(s));
        System.out.println(validParentheses.strIsValid(s));
    }
}
