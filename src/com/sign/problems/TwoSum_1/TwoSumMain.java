package com.sign.problems.TwoSum_1;

public class TwoSumMain {
    public static void main(String[] args) {
        TwoSum_25ms twoSum25ms = new TwoSum_25ms();
        int[] solution = twoSum25ms.twoSum(new int[]{1,2,7,9}, 9);
        System.out.println("O(n2) : " + solution[0] + " and " + solution[1]);

        TwoSumEfficient_3ms twoSumEfficient3ms = new TwoSumEfficient_3ms();
        solution = twoSumEfficient3ms.solution(new int[]{3,2,4}, 6);
        System.out.println("O(n) : " + solution[0] + " and " + solution[1]);

    }
}
