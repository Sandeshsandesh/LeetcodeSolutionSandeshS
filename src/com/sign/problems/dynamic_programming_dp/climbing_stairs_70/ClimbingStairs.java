package com.sign.problems.dynamic_programming_dp.climbing_stairs_70;

public class ClimbingStairs {
     /*
    Approach 1: Recursion with Memoization
    int[] mem = new int[46];
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;   // path found
        }
        if (n == -1) {
            return 0;   // no path
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        return mem[n] = climbStairs(n-1) + climbStairs(n-2);
    }
    */

    // Approach 2: Bottom up dynamic programming
    public int climbStairs(int n) {
        int first = 1, second = 2;
        if (n == 1 || n == 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
