package com.sign.problems.grind75.g2ValidParanthesis_20;

// https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    private static Map<Character, Character> map = new HashMap<>();
    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }
    public boolean isValid(String input) {
        if (input == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (map.containsKey(ch)) {
// pop
                if (stack.size() == 0) {
                    return false;
                }

                Character top = stack.pop();
                if (top != null && top.charValue() == map.get(ch)) {
                    continue;
                } else {
                    return false;
                }
            } else {
// pop
                stack.push(ch);
            }
        }

        return stack.empty();
    }
}
