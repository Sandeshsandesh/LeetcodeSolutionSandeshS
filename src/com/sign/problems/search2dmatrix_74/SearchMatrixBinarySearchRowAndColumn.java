package com.sign.problems.search2dmatrix_74;

public class SearchMatrixBinarySearchRowAndColumn {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search for row having target
        // i.e 1 row less than next greater element
        // condition a[i] > target => FFFTT => return last F (1 less than first T) => high
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high-low) / 2;

            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (-1 == high) {
            return false;
        }

        int row = high;
        // apply binary search for the row

        low = 0;
        high = matrix[row].length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;

            if(target == matrix[row][mid]) {
                return true;
            }
            if (target > matrix[row][mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
