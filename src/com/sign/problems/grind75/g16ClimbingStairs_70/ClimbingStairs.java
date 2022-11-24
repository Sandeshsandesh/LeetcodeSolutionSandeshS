package com.sign.problems.grind75.g16ClimbingStairs_70;

public class ClimbingStairs {
    public int climbStairsDP(int n) {
        if (n <= 0) {
            return -1;
        }
        int first = 1, second = 1;
        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    int target;
    int[] dp;
    public int climbStairsRecursion(int n) {
        if (n <= 0)	return -1;
        target = n;
        dp = new int[n+1];
        return cs(0);
    }
    private int cs(int n) {
        if (n == target) return 1;
        if (n > target) return 0;

        if (dp[n] != 0) return dp[n];
        dp[n]= cs(n+1) + cs(n+2);
        return dp[n];
    }

}
