package com.sign.problems.cyclic_sort_negative_marking.MissingNumbers_448;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumbersArray {
    public List<Integer> findDisappearedNumbersCyclicSort(int[] nums) {
        // cyclic sort
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // check incorrect/missing indexes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] -1 != i) {
                result.add(i+1);
            }
        }
        return result;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Mark index of found numbers as negative
        for (int i = 0; i < nums.length; i++) {
            mark(nums, Math.abs(nums[i]) - 1);
        }

        // check unmarked numbers and return
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    private void mark(int[] nums, int index) {
        if (nums[index] > 0) {
            nums[index] *= -1;
        }
    }

    public static void main(String[] args) {
        FindMissingNumbersArray findMissingNumbersArray = new FindMissingNumbersArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findMissingNumbersArray.findDisappearedNumbers(nums);
        System.out.println(result);
    }
}
