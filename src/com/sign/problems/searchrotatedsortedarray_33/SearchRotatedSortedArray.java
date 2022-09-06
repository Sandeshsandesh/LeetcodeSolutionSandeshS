package com.sign.problems.searchrotatedsortedarray_33;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if (target == nums[pivot]) {
            return pivot;
        }

        int leftSearch = binarySearch(nums, 0, pivot - 1, target);

        if (-1 != leftSearch) {
            return leftSearch;
        }
        return binarySearch(nums, pivot + 1, nums.length - 1, target);

    }

    private int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid != low && nums[low] > nums[mid - 1]) {
                high = mid - 1;
            } else if (mid < nums.length - 1 && nums[mid + 1] > nums[high]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
