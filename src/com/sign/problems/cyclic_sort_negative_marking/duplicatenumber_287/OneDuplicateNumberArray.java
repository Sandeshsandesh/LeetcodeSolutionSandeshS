package com.sign.problems.cyclic_sort_negative_marking.duplicatenumber_287;

import java.util.HashSet;
import java.util.Set;

public class OneDuplicateNumberArray {
    //Approach 1: Negative marking
    public int findDuplicateNegativeMarking(int[] nums) {
        // mark found index as negative
        for(int i = 0; i < nums.length; i++) {
            if (isMarked(nums, Math.abs(nums[i]) - 1)){
                return Math.abs(nums[i]);
            } else {
                // mark
                mark(nums, Math.abs(nums[i]) - 1);
            }
        }

        //restore positives in the array
        return -1;
    }

    private void mark(int[] nums, int index) {
        nums[index] = nums[index] * -1;
    }

    private boolean isMarked(int[] nums, int index) {
        return nums[index] < 0;
    }

    //Approach 2: HashSet
    public int findDuplicateHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }

    //Approach 3: Floyd's Cycle Detection
    // Step 1: Identify it as linked list with cycle problem
    // Step 2: Use Floy's Cycle Detection algorithm to find cycle entry point
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];

        do {
            tortoise = nums[tortoise];  // one hop at a time
            hare = nums[nums[hare]];    // two hops at a time
        } while (tortoise != hare);     // phase 1 complete: found the intersection point within the circle

        hare = nums[0];                 // hare will start from the beginning
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];          // this time hopping only one node at a time
        }

        return tortoise;                   // they meet at the strating point of cycle
    }
}
