package com.sign.problems.grind75.g25MaximumSubarray_53;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;

    }
}
