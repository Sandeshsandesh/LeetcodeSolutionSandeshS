package com.sign.problems.search2dmatrix_74;

public class SearchMatrix2dMatrixTo1dArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        //convert 2D array to 1D array and apply binary search
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;          //row of mid
            int column = mid % n;       //column of mid
            if (target == matrix[row][column]) {
                return true;
            }
            if (target > matrix[row][column]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
