package com.sign.problems.grind75.g41RottingOranges_994;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            boolean flag = false;
            int size = q.size();
            while (size != 0) {
                int[] ij = q.remove();
                int i = ij[0], j = ij[1];
                if (i > 0) flag = rot(i-1, j, grid, q) || flag ;
                if(i < m-1) flag = rot(i+1, j, grid, q)|| flag ;
                if (j > 0) flag = rot(i, j-1, grid, q) || flag ;
                if(j < n-1) flag = rot(i, j+1, grid, q) || flag ;
                size--;
            }
            if (flag) {
                time++;
            } else break;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    private boolean rot(int i, int j, int[][] grid, Deque<int[]> q) {
        if (grid[i][j] != 1) return false;
        grid[i][j] = 2;
        q.add(new int[]{i,j});
        return true;
    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new RottingOranges().orangesRotting(grid));

    }
}

