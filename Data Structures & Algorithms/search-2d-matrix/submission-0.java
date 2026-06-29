class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int m = matrix.length;
    int n = matrix[0].length;
    
    // Initialize the binary search range
    int left = 0;
    int right = m * n - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        // Convert mid to row and column in the 2D matrix
        int row = mid / n;
        int col = mid % n;
        
        // Check the value at the current position
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    // If the target is not found, return false
    return false;
    }
}
