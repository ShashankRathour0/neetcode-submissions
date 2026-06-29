class Solution {
    public int swimInWater(int[][] grid) {
         int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // Min-heap
        boolean[][] visited = new boolean[n][n];
        
        // Start with the top-left corner
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], x = current[1], y = current[2];
            
            // If we reach the bottom-right corner, return the time
            if (x == n - 1 && y == n - 1) return time;
            
            // Mark as visited
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            // Explore neighbors
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{Math.max(time, grid[nx][ny]), nx, ny});
                }
            }
        }
        
        return -1;
    }
}
