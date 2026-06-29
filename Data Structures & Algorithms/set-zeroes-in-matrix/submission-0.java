class Solution {
    public void setZeroes(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;  // Flag to check if the first row has any 0
        boolean firstColZero = false;  // Flag to check if the first column has any 0
        
        // Step 1: Check if first row has any 0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        // Step 2: Check if first column has any 0
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        // Step 3: Use the first row and first column to mark rows and columns to be set to 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark the first column of the row
                    matrix[0][j] = 0;  // Mark the first row of the column
                }
            }
        }
        
        // Step 4: Set matrix cells to 0 based on the marks in the first row and first column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Step 5: Handle the first row separately
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // Step 6: Handle the first column separately
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
