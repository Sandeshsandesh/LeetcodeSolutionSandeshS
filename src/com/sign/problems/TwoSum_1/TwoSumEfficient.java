package com.sign.problems.TwoSum_1;

import java.util.HashMap;
import java.util.Map;

public class TwoSumEfficient {
    public int[] solution( int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey( target - nums[i])) {
                System.out.println("Efficient O(n) : " + map.get( target - nums[i]) + " and " + i);
                return new int[]{map.get(target - nums[i]), i};
            }
            else {
                map.put(nums[i], i);
                System.out.println(map);
            }
        }

        return new int[0];
    }
}
