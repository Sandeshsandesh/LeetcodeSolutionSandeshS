package com.sign.problems.searchmountainarray_1095;
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        // get peak index
        int peak = peakIndexInMountainArray(mountainArr);

        // search in left
        int leftIndex = binarySearch(mountainArr, 0, peak, target, true);

        if (-1 != leftIndex) {
            return leftIndex;
        } else {
            return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target, false);
        }


    }
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int low = 0;
        int high = mountainArr.length() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && mountainArr.get(mid - 1) > mountainArr.get(mid)) {
                // mid is not greater than its previous element, so search left array as descending array already started
                high = mid - 1;
            } else if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // mid is not greater than its next element, se search right array as increasing array is already started
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearch(MountainArray mountainArr, int low, int high, int target, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == mountainArr.get(mid)) {
                return mid;
            }

            if (target > mountainArr.get(mid)) {
                if (ascending) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (ascending) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}

// given
interface MountainArray {
    int length();
    int get(int index);
}
