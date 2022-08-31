package com.sign.problems.firstandlastpositioninsortedarray_34;

import java.util.Arrays;

public class TargetRangeSearch {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // find target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return new int[]{findFirstPosition(nums, target, low, mid-1), findLastPosition(nums, target, mid+1, high)};
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    private int findFirstPosition(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target <= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return low;
    }

    private int findLastPosition(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        TargetRangeSearch search = new TargetRangeSearch();
        int[] nums = {1};
//        int[] nums = {5,7,7,8,8,10};
        int target = 1;
        int[] output = search.searchRange(nums, target);
        System.out.println(Arrays.toString(output));
    }
}
