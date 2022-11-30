package com.sign.problems.grind75.g40NumberOfIslands_200;

public class NumberOfIslands {
    int m, n;
    char[][] nums;
    public int numIslands(char[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;

        int total = 0;
        nums = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == '1') {
                    dfs(i, j);
                    total++;
                }
            }
        }
        return total;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m) return;
        if (j < 0 || j >= n) return;

        if (nums[i][j] == '1') {
            nums[i][j] = '2';
            dfs(i+1,j);
            dfs(i-1,j);
            dfs(i,j+1);
            dfs(i,j-1);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
//        char[][] grid = new char[0][0];
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
