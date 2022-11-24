package com.sign.problems.grind75.g27_01Matrix_542;

// https://leetcode.com/problems/01-matrix/

import java.util.Arrays;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        final int INF = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int left, top;
                if (i == 0) top = INF;
                else top = dp[i-1][j];

                if (j == 0) left = INF;
                else left = dp[i][j-1];

                int res = Math.min(top, left);
                dp[i][j] = 1 + (res == INF? INF-1 : res);
            }
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int down, right;
                if (i == m-1) down = INF;
                else down = dp[i+1][j];

                if (j == n-1) right = INF;
                else right = dp[i][j+1];

                int res = Math.min(right, down);
                dp[i][j] = Math.min(dp[i][j], 1 + (res==INF? INF-1 : res));
            }
        }
        return dp;
    }
}
