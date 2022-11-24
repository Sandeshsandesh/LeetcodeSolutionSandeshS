package com.sign.problems.grind75.g19MajorityElement_169;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int val: nums) {
            if (map.containsKey(val)) {
                int curCount = map.get(val) + 1;
                if (curCount > n/2) {
                    return val;
                } else {
                    map.put(val, curCount);
                }
            } else {
                map.put(val, 1);
            }
        }
        return nums[0];
    }

    // Boyer-Moore Voting Algorithm: Like Greedy
    public int majorityElement1(int[] nums) {
        int res = 0, count = 0;

        for (int num : nums) {
            if (count <= 0) {
                res = num;
                count = 1;
            } else {
                if (num == res) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }
}
