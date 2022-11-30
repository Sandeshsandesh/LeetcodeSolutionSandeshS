package com.sign.problems.grind75.g38MinStack_155;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<int[]> stack;

    MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int min = stack.isEmpty() ? Integer.MAX_VALUE : getMin();
        min = Math.min(min, val);
        stack.push(new int[]{val, min});
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return stack.peek()[0];
    }
    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return stack.peek()[1];
    }
}
