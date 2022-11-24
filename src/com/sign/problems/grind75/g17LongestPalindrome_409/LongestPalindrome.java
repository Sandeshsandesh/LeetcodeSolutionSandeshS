package com.sign.problems.grind75.g17LongestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String str) {
        if (str == null) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean oddFlag = false;
        for (int val : map.values()) {
            if (val % 2 == 0) {
                count += val;
            } else {
                count += val - 1;
                oddFlag = true;

            }
        }
        if (oddFlag) {
            return count + 1;
        }
        return count;

    }
}
