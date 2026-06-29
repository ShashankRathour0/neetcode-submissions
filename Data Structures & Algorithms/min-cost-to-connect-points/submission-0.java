class Solution {
    public int minCostConnectPoints(int[][] points) {
           int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // [cost, point]
        minHeap.add(new int[]{0, 0}); // Starting with the first point
        int totalCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int point = current[1];
            
            if (visited[point]) {
                continue;
            }
            
            visited[point] = true;
            totalCost += cost;
            edgesUsed++;
            
            // Add all edges from the current point to the minHeap
            for (int nextPoint = 0; nextPoint < n; nextPoint++) {
                if (!visited[nextPoint]) {
                    int nextCost = Math.abs(points[point][0] - points[nextPoint][0]) +
                                   Math.abs(points[point][1] - points[nextPoint][1]);
                    minHeap.add(new int[]{nextCost, nextPoint});
                }
            }
        }
        
        return totalCost;
    }
}
