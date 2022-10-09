package com.sign.problems.dynamic_programming_dp.unique_paths_62;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return robot(0, 0, dp, m, n);
    }

    private int robot(int r, int c, int[][] dp, int m, int n) {
        if (r == m) {
            // row out of bound
            return 0;
        }
        if (c == n) {
            // column out of bound
            return 0;
        }

        if (r == m - 1 && c == n - 1) {
            // reached end destination
            return 1;
        }
        if (dp[r][c] != 0) {
            // return from cache
            return dp[r][c];
        }

        // calculate distance from current node
        return dp[r][c] = robot(r + 1, c, dp, m, n) + robot(r, c + 1, dp, m, n);
    }
}
