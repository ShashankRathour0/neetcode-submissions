class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         int n = edges.length;

        // Initialize Union-Find for n nodes
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            // If a and b are already connected, this edge is redundant
            if (!uf.union(a, b)) {
                return edge;
            }
        }

        // If no edge was found (shouldn't happen given the problem constraints)
        return new int[0];
    }

    // Union-Find class
    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];

            // Initialize each node's parent to itself
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        // Find the root of a node with path compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        // Union two nodes; return false if they are already connected
        public boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 == root2) {
                return false; // They are already connected
            }

            // Union by rank
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }

            return true;
        }
    }
}
