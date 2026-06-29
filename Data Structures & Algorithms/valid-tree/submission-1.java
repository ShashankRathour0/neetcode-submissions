class Solution {
    public boolean validTree(int n, int[][] edges) {

    // / Step 1: Check edge count
        if (edges.length != n - 1) {
            return false;
        }

        // Step 2: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 3: Perform DFS
        boolean[] visited = new boolean[n];
        if (hasCycle(graph, 0, -1, visited)) {
            return false; // Cycle detected
        }

        // Step 4: Check connectivity
        for (boolean v : visited) {
            if (!v) {
                return false; // Not all nodes were visited
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle detected
            }
        }

        return false;
    }

}
