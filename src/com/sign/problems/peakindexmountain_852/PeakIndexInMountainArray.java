package com.sign.problems.peakindexmountain_852;

public class PeakIndexInMountainArray {
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
}
