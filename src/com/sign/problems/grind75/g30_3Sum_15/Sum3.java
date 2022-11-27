package com.sign.problems.grind75.g30_3Sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = nums[i] * -1;
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < nums.length-1 && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (right > 0 && nums[right] == nums[right + 1]);
                } else if (nums[left] + nums[right] < target) {
                    do {
                        left++;
                    } while (left < nums.length-1 && nums[left] == nums[left - 1]);
                } else {
                    do {
                        right--;
                    } while (right > 0 && nums[right] == nums[right + 1]);
                }

            }
        }
        return res;
    }

}
