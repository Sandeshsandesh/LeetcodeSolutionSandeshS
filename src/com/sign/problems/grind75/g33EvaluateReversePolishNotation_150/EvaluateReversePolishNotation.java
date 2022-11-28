package com.sign.problems.grind75.g33EvaluateReversePolishNotation_150;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int rpn(String[] input) {
        if (input == null) throw new RuntimeException("null");

        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : input) {
            char c = s.charAt(0);
            if (s.length() > 1 || Character.isDigit(c)) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            int n2 = stack.pop();
            int n1 = stack.pop();

            switch (c) {
                case '+' : stack.push(n1+n2);
                    break;
                case '-' : stack.push(n1-n2);
                    break;
                case '*' : stack.push(n1*n2);
                    break;
                case '/' : stack.push(n1/n2);
                    break;
                default : throw new RuntimeException("invalid operator");
            }
        }
        return stack.pop();
    }

}
