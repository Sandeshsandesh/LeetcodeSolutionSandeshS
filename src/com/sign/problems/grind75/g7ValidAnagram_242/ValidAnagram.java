package com.sign.problems.grind75.g7ValidAnagram_242;

// https://leetcode.com/problems/valid-anagram/

public class ValidAnagram {
    public boolean validAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            chars[s2.charAt(i) - 'a'] -= 1;
        }

        for (int count: chars) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
