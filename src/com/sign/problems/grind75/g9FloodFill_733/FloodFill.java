package com.sign.problems.grind75.g9FloodFill_733;

// https://leetcode.com/problems/flood-fill/

public class FloodFill {
    int row, col;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }

        row = image.length;
        col = image[0].length;

        if (sr >= row || sc >= col || sr < 0 || sc < 0) {
            return null;
        }
        int currentColor = image[sr][sc];
        if (currentColor == color) {
            return image;
        }

        dfs(image, sr, sc, currentColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if (sr >= row || sc >= col || sr < 0 || sc < 0) {
            return;
        }

        if (originalColor == image[sr][sc]) {
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, originalColor, newColor);
            dfs(image, sr + 1, sc, originalColor, newColor);
            dfs(image, sr, sc + 1, originalColor, newColor);
            dfs(image, sr, sc - 1, originalColor, newColor);
        }
    }
}
