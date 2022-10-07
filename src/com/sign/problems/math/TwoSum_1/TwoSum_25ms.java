package com.sign.problems.math.TwoSum_1;

/**
 * O(n2) solution 25ms
 */
public class TwoSum_25ms {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    if (target == sum) {
                        return new int[]{i, j};
                    }
                }
            }
            //return new int[0];
            throw new IllegalArgumentException("No solution");
        }
}
