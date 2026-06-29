class Solution {
     private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, cols;
    public int longestIncreasingPath(int[][] matrix) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        rows = matrix.length;
        cols = matrix[0].length;

        // Memoization array to store the length of the longest path starting from each cell
        int[][] memo = new int[rows][cols];
        int maxPath = 0;

        // Compute the longest path starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // If the result is already computed, return it
        if (memo[i][j] != 0) return memo[i][j];

        int maxLength = 1; // At least the cell itself

        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, x, y, memo));
            }
        }

        // Store the result in memo and return it
        memo[i][j] = maxLength;
        return maxLength;
    }


}
