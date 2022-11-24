package com.sign.problems.grind75.g14FirstBadVersion_278;

// https://leetcode.com/problems/first-bad-version/

public abstract class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    abstract boolean isBadVersion(int version);
}
