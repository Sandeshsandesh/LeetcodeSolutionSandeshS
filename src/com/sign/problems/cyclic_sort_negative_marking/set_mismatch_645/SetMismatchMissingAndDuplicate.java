package com.sign.problems.cyclic_sort_negative_marking.set_mismatch_645;

public class SetMismatchMissingAndDuplicate {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i=0; i< nums.length; i++) {
            int marking_index = Math.abs(nums[i]) - 1;
            if (nums[marking_index] < 0) {
                res[0] = marking_index + 1;
            } else {
                nums[marking_index] *= -1;
            }
        }

        for (int i=0; i< nums.length; i++) {
            if (nums[i] > 0) {
                res[1] = i+1;
                return res;
            }
        }
        return res;
    }
}
