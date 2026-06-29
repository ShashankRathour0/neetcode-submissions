class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Perform DFS from the borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific); // Left border (Pacific)
            dfs(heights, r, cols - 1, atlantic); // Right border (Atlantic)
        }
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific); // Top border (Pacific)
            dfs(heights, rows - 1, c, atlantic); // Bottom border (Atlantic)
        }

        // Collect cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        // Possible directions for movement
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < heights.length && newC >= 0 && newC < heights[0].length) {
                if (!visited[newR][newC] && heights[newR][newC] >= heights[r][c]) {
                    dfs(heights, newR, newC, visited);
                }
            }
        }
      
    }
}
