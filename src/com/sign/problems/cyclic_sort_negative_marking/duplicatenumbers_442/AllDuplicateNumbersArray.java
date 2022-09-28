package com.sign.problems.cyclic_sort_negative_marking.duplicatenumbers_442;

import java.util.ArrayList;
import java.util.List;

public class AllDuplicateNumbersArray {
    public List<Integer> findDuplicates(int[] nums) {
        // Mark index of found numbers as negative
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int marking_index = Math.abs(nums[i]) - 1;
            if (nums[marking_index] < 0) {
                // already marked
                duplicates.add(Math.abs(nums[i]));
            } else {
                // mark as negative
                nums[marking_index] *= -1;
            }
        }
        return duplicates;
    }
}
