class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         // Step 1: Build the graph as an adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // Step 2: Initialize distances and priority queue
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // {node, distance}

        // Step 3: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], time = current[1];

            // Skip if we've already found a shorter path
            if (time > dist[node]) continue;

            // Relax neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], weight = neighbor[1];
                    int newDist = time + weight;
                    if (newDist < dist[nextNode]) {
                        dist[nextNode] = newDist;
                        pq.offer(new int[]{nextNode, newDist});
                    }
                }
            }
        }

        // Step 4: Find the maximum distance
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
