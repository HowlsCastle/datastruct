package com.example.datastruct.stack;

import java.util.Stack;

public class SimpleQueueUseStack {
    Stack<Integer> positive = new Stack<>();
    Stack<Integer> backword = new Stack<>();

    public void push(int x) {
        positive.push(x);
    }

    public void pop() {
        if (!backword.empty()) {
            backword.pop();
        } else {
            while (!positive.empty()) {
                backword.push(positive.pop());
            }
            backword.pop();
        }
    }

    public Integer peek() {
        if (!backword.empty()) {
            return backword.peek();
        } else {
            while (!positive.empty()) {
                backword.push(positive.peek());
            }
            return backword.peek();
        }
    }

    public boolean empty() {
        return positive.empty() && backword.empty();
    }
}
