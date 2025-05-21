class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, col0 = false;

        // Check if first row or first column need to be zero
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) col0 = true;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) row0 = true;

        // Mark cells in first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero using the markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        // Handle first column
        if (col0) for (int i = 0; i < m; i++) matrix[i][0] = 0;

        // Handle first row
        if (row0) for (int j = 0; j < n; j++) matrix[0][j] = 0;

    }
}