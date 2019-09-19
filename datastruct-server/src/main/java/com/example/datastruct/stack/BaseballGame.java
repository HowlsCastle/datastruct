package com.example.datastruct.stack;

import java.util.Stack;

public class BaseballGame {
    public int totalPoint(String[] ops) {
        Stack<Integer> points = new Stack<>();
        for(String s : ops) {
            switch (s) {
                case "+":
                    points.push(points.peek() + points.get(points.size()-2));
                    break;
                case "D":
                    points.push(points.peek() *2);
                    break;
                case "C":
                    points.pop();
                    break;
                default:
                    points.push(Integer.valueOf(s));
                    break;
            }
        }

        int sum = 0;
        for(Integer p : points) {
            sum += p;
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String[] a = {"5","2","C","D","+"};
        System.out.println(baseballGame.totalPoint(a));
    }
}
