class Solution {
    private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;

        // Directions for up, down, left, right movement
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all the treasure chest positions (0s)
        // and set INF (2147483647) for land cells (1s)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j]==-1)
                {
                    continue;
                }
                else {
                    grid[i][j] = Integer.MAX_VALUE; // Set INF for land cells
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and ensure we only update INF cells
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == INF) {
                    grid[newX][newY] = grid[x][y] + 1; // Update distance
                    queue.offer(new int[]{newX, newY}); // Enqueue the updated cell
                }
            }
        }
    }
}
