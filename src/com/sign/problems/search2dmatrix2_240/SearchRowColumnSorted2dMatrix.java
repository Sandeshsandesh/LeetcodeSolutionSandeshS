package com.sign.problems.search2dmatrix2_240;

public class SearchRowColumnSorted2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int column = n - 1;

        // search space reduction. Start from top-right and work our way to bottom
        while (row < m && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            }
            if (target > matrix[row][column]) {
                // eliminate current row
                row++;
            } else {
                // eliminate current column
                column--;
            }
        }
        return false;
    }
}
