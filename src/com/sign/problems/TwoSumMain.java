package com.sign.problems;

public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.twoSum(new int[]{1,2,7,9}, 9);
        System.out.println(solution[0] + " and " + solution[1]);
    }
}
