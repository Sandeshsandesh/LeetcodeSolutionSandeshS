package com.sign.problems.cyclic_sort_negative_marking.first_missing_positive_41;

public class FirstMissingPositive {
    // Negative marking solution
    public int firstMissingPositive(int[] nums) {
        // convert all negatives to zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // Using array indexes as an Index Map. Marking found numbers (1-n) index as negative
        for (int i = 0; i < nums.length; i++) {
            int marking_index = Math.abs(nums[i]) - 1;
            if (marking_index < 0 || marking_index >= nums.length) {
                // skip out of bound indexes (zero and greater than n)
                continue;
            }


            if (nums[marking_index] == 0) {
                // handle marking indexes with value zero,
                // since marking_index + 1 is already available in array, we can duplicate it
                nums[marking_index] = (marking_index + 1) * -1;
            } else {
                nums[marking_index] = Math.abs(nums[marking_index]) * -1;
            }
        }

        // unmarked (positive) index is the missing number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
