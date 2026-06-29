class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate over every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // When a land cell ('1') is found, perform DFS to find the area of the island
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, rows, cols));
                }
            }
        }

        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j, int rows, int cols) {
        // If out of bounds or already visited (water)
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }

        // Mark the current cell as visited by changing it to water ('0')
        grid[i][j] = 0;

        // Perform DFS on all 4 possible directions (up, down, left, right)
        int area = 1; // The current cell counts as 1 unit of area
        area += dfs(grid, i - 1, j, rows, cols); // Up
        area += dfs(grid, i + 1, j, rows, cols); // Down
        area += dfs(grid, i, j - 1, rows, cols); // Left
        area += dfs(grid, i, j + 1, rows, cols); // Right

        return area;
    }
}
