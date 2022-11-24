package com.sign.problems.grind75.g1TwoSum_1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int secondValue = target - nums[i];
            if (map.containsKey(secondValue)) {
                return new int[]{map.get(secondValue), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
