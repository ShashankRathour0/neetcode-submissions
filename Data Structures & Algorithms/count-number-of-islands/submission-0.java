class Solution {
    public int numIslands(char[][] grid) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;

        // Iterate over every cell in the grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // If the current cell is land ('1'), perform DFS to mark the entire island
                if (grid[i][j] == '1') {
                    islandCount++;
                    dfs(grid, i, j, numRows, numCols);
                }
            }
        }

        return islandCount;
    }
     private void dfs(char[][] grid, int i, int j, int numRows, int numCols) {
        // Check if the current cell is out of bounds or already visited (water)
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid[i][j] == '0') {
            return;
        }

        // Mark the current cell as visited by changing it to '0'
        grid[i][j] = '0';

        // Visit the neighboring cells (up, down, left, right)
        dfs(grid, i - 1, j, numRows, numCols); // Up
        dfs(grid, i + 1, j, numRows, numCols); // Down
        dfs(grid, i, j - 1, numRows, numCols); // Left
        dfs(grid, i, j + 1, numRows, numCols); // Right
    }
}
