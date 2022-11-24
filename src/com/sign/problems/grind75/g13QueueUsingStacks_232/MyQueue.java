package com.sign.problems.grind75.g13QueueUsingStacks_232;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue<T> {
    Deque<T> pushStack;
    Deque<T> popStack;
    T first;

    MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void push(T ele) {
        if (pushStack.isEmpty()) {
            first = ele;
        }
        pushStack.push(ele);
    }

    public T pop() {
        if (popStack.isEmpty()) {
            populateStack();
        }
        return popStack.pop(); // throws RunTimeException
    }

    public T peek() {
        if (popStack.isEmpty()) {
            return first;
        }
        return popStack.peek();
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void populateStack() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
