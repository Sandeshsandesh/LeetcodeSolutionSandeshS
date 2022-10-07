package com.sign.problems.dynamic_programming_dp.fibonaccinumber_509;

public class FibonacciNumber {
    // Approach 1: Binet's formula
    // double goldenRatio = (1 + Math.sqrt(5)) / 2;
    // return (int)Math.round(Math.pow(goldenRatio, n)/ Math.sqrt(5)); works too
    public int fib_Math(int n) {
        double rootFive = Math.sqrt(5);

        double first = Math.pow(((1 + rootFive) / 2 ), n);
        double second = Math.pow(((1 - rootFive) / 2 ), n);

        return (int) ((first - second) / rootFive);
    }

    // Approach 2
    public int fib_bottom_up_dp(int n) {
        if (n < 2) {
            return n;
        }
        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

    // Approach 3: recursion
    public int fib_recursion(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n-1) + fib (n-2);
    }

    // Approach 3: recursion with memoization
    int[] fibonacci = new int[31];

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        if (fibonacci[n] != 0) {
            return fibonacci[n];
        }
        fibonacci[n] = fib(n-1) + fib(n-2);
        return fibonacci[n];
    }
}
