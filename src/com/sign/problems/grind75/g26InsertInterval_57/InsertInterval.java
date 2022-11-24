package com.sign.problems.grind75.g26InsertInterval_57;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res= new ArrayList<>();

        if (intervals.length == 0) {
            // res.add(newInterval);
            // return res.toArray(new int[1][2]);
            return new int[][]{newInterval};
        }


        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int cur = 0;

        // insert all intervals which is ending before start of new interval
        while (cur < intervals.length && intervals[cur][1] < newStart) {
            res.add(intervals[cur]);
            cur++;
        }

        // merge intervals if cur interval's start is not after end of new interval
        while (cur < intervals.length && intervals[cur][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[cur][0]);
            newEnd= Math.max(newEnd, intervals[cur][1]);
            cur++;
        }
        res.add(new int[]{newStart, newEnd});

        // insert last remaining intervals
        while (cur < intervals.length) {
            res.add(intervals[cur]);
            cur++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
