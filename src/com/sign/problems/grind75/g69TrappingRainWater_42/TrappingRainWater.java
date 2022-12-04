package com.sign.problems.grind75.g69TrappingRainWater_42;

public class TrappingRainWater {
    public int trap(int[] ht) {
        int length = ht.length;
        int[] lm = new int[length];
        int[] rm = new int[length];

        for (int i = 1; i < length; i++) {
            lm[i] = Math.max(lm[i-1], ht[i-1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            rm[i] = Math.max(rm[i+1], ht[i+1]);
        }

        int water = 0;
        for (int i = 1; i < length - 1; i++) {
            int cur = Math.min(lm[i], rm[i]) - ht[i];
            if (cur > 0) water += cur;
        }
        return water;
    }
}
