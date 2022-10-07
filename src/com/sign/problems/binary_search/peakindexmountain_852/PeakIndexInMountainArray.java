package com.sign.problems.binary_search.peakindexmountain_852;

public class PeakIndexInMountainArray {
    /**
     * logn
     */
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                // mid is not greater than its previous element, so search left array as descending array already started
                high = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                // mid is not greater than its next element, se search right array as increasing array is already started
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Simple approach with logn
     * Comparison: a[i] < a[i+1]
     * TTTTFF (find first F)
     */
    public int binarySearchOverComparisonsApproachPeakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid+1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
