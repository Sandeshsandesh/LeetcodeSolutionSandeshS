package com.sign.problems.TwoSum_1;

public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.twoSum(new int[]{1,2,7,9}, 9);
        System.out.println(solution[0] + " and " + solution[1]);

        TwoSumEfficient twoSumEfficient = new TwoSumEfficient();
        solution = twoSumEfficient.solution(new int[]{3,2,4}, 6);
        System.out.println(solution[0] + " and " + solution[1]);

    }
}
