package com.sign.problems.sorting.findKthLargest_215;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {

    //Approach 1: Priority Queue using min heap
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        Queue<Integer> minHeap= new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
//            minHeap.add(nums[i]);
            minHeap.add(nums[i]);
        }

        while (k < nums.length) {
            if (nums[k] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(nums[k]);
            }
            k++;
        }
        return minHeap.peek();
    }

    //Approach 2: Quick select to find position of pivot
    public int findKthLargestQuickSelect(int[] nums, int k) {
        k = nums.length - k;
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k];
    }

    private void quickSelect(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return;
        }
        int i = low + 1;
        int j = high;
        int pivot = low;

        while (true) {
            while (i < nums.length && nums[i] <= nums[pivot]) {
                i++;
            }
            while (j > 0 && nums[j] > nums[pivot]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
            } else {
                break;
            }
        }
        // j is the correct position of pivot element
        swap(nums, pivot, j);
        if (k == j) {
            return;
        }
        if (k < j) {
            // quick select only left
            quickSelect(nums, low, j - 1, k);
        } else {
            // quick select only left
            quickSelect(nums, j + 1, high, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest kthLargest = new FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(kthLargest.findKthLargestPriorityQueue(nums, k));
        System.out.println(kthLargest.findKthLargestQuickSelect(nums, k));
    }
}
