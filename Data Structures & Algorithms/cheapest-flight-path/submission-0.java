class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[] {to, price});
        }

        // Priority queue for Dijkstra's algorithm: (cost, airport, stops)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});  // Start from the src with cost 0 and 0 stops
        
        // Distance table to track the minimum cost at each airport with a certain number of stops
        int[][] dist = new int[n][k + 2];  // n airports, up to k+1 stops
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;  // Cost to reach src with 0 stops is 0
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0], node = current[1], stops = current[2];

            // If we've reached the destination with at most k stops
            if (node == dst) {
                return cost;
            }

            // If we've already made k stops, don't explore further
            if (stops > k) continue;

            // Explore neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], price = neighbor[1];
                    // Check if visiting this neighbor with one more stop results in a cheaper cost
                    if (cost + price < dist[nextNode][stops + 1]) {
                        dist[nextNode][stops + 1] = cost + price;
                        pq.offer(new int[]{cost + price, nextNode, stops + 1});
                    }
                }
            }
        }

        // If we can't reach dst within k stops, return -1
        return -1;

    }
}
