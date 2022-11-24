package com.sign.problems.grind75.g29LongestSubstringWithoutRepeatingCharacters_3;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int i = 0, j = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        while (j < s.length()) {
            char cj = s.charAt(j);
            if (set.contains(cj)) {
                max = Math.max(max, j-i);
                while (s.charAt(i) != cj) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            } else {
                set.add(cj);
            }
            j++;
        }
        return Math.max(max, j-i);
    }
}
