class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Queue to perform BFS
        Queue<int[]> queue = new LinkedList<>();

        // Count of fresh fruits
        int freshCount = 0;

        // Initialize the queue with all rotten fruits
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh fruits, return 0
        if (freshCount == 0) return 0;

        int minutes = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRotten = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check bounds and if the fruit is fresh
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        // Mark the fruit as rotten
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                        anyRotten = true;
                    }
                }
            }

            // Increment time if at least one fruit rotted in this level
            if (anyRotten) minutes++;
        }

        // If there are still fresh fruits, return -1
        return freshCount == 0 ? minutes : -1;
    }
}
