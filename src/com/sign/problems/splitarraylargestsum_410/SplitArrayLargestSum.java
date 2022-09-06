package com.sign.problems.splitarraylargestsum_410;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        // Find min and max of possible solution
        int sum = 0, max = 0;
        for (int num: nums) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }

        // Apply binary search over range of possible answers
        int res = 0;
        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // use greedy algorithm to determine number of subarrays whose sum <= mid
            int subArrays = 0;
            int tempSum = 0;
            for (int num : nums) {
                tempSum += num;
                if (tempSum > mid) {
                    subArrays++;
                    tempSum = num;
                }
            }
            subArrays++;    // there will already be one subArray initially as subArray was incremented from 0

            if (subArrays <= m) {
                // mid is too high as number of subarrays is fewer
                // OR
                // search for even lesser mid
                high = mid - 1;
                res = mid;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
