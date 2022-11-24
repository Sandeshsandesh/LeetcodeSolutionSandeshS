package com.sign.problems.grind75.g8BinarySearch_704;

// https://leetcode.com/problems/binary-search/

public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                high = high - 1;
            } else {
                low = low + 1;
            }
        }
        return -1;
    }

}
