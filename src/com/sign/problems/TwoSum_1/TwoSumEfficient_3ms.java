package com.sign.problems.TwoSum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n) solution 3ms beats 99.82% of java submissions
 */
public class TwoSumEfficient_3ms {
    public int[] solution( int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey( target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        //return new int[0];
    }
}
