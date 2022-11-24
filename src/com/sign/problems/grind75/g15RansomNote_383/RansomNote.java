package com.sign.problems.grind75.g15RansomNote_383;

// https://leetcode.com/problems/ransom-note/

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String rn, String mz) {
        if (mz == null) {
            return false;
        }

        Map<Character, Integer> charCt = new HashMap<>();

        for (int i = 0; i < mz.length(); i++) {
            char cur = mz.charAt(i);
            charCt.put(cur, charCt.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < rn.length(); i++) {
            char cur = rn.charAt(i);
            if (!charCt.containsKey(cur)) {
                return false;
            }
            if (charCt.get(cur) < 1) {
                return false;
            }
            charCt.put(cur, charCt.get(cur) - 1);
        }
        return true;

    }
}
