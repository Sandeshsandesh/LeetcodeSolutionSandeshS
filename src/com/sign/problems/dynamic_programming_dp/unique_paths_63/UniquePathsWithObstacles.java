package com.sign.problems.dynamic_programming_dp.unique_paths_63;

public class UniquePathsWithObstacles {

    // Approach 1: Recursion with Memoization
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        return robot(0, 0, dp, obstacleGrid);
    }

    private int robot(int r, int c, int[][] dp, int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (r == m) {
            // row out of bound
            return 0;
        }

        int n = obstacleGrid[r].length;
        if (c == n) {
            // column out of bound
            return 0;
        }

        if (obstacleGrid[r][c] == 1) {
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
        return dp[r][c] = robot(r + 1, c, dp, obstacleGrid) + robot(r, c + 1, dp, obstacleGrid);
    }

    // Approach 2: Dynamic programming. Bottom-up, dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // store first column with 1s
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else if (dp[i-1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        // store first row with 1s
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else if (dp[0][j-1] == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    // Approach 3: Dynamic programming. Bottom-up, dp[i][j] = dp[i-1][j] + dp[i][j-1]
    // space complexity improved to O(n) by using obstacle array to store dp
    public int uniquePathsWithObstaclesDPAsInputArray(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;

        // store first column with 1s if it can be reached without obstacles
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else if (obstacleGrid[i-1][0] == 0) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        // store first row with 1s if it can be reached without obstacles
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                obstacleGrid[0][j] = 0;
            } else if (obstacleGrid[0][j-1] == 0) {
                obstacleGrid[0][j] = 0;
            } else {
                obstacleGrid[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
