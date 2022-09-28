package com.sign.problems.cyclic_sort_negative_marking.MissingNumber_268;

public class MissingOneNumberArray {
    // Approach 1: Cyclic sort
    public int missingNumber_cyclic_sort(int[] nums) {
        // cyclic sort
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }

        // find missing element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // Approach 2: XOR a^b^b = a^0 = a
    public int missingNumberXOR(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }

    // Approach 3: Gauss formula. sum_of_indexes - sum_of_elemnets
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int total_sum = nums.length * (nums.length + 1) / 2;

        return total_sum - sum;
    }
}
