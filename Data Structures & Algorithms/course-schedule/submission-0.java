class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Step 2: Use a visited array to track state of each node
        int[] visited = new int[numCourses];

        // Step 3: Perform DFS for each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false; // Cycle detected
            }
        }

        return true; // No cycle detected
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int course) {
        if (visited[course] == 1) {
            return false; // Cycle detected
        }
        if (visited[course] == 2) {
            return true; // Already processed
        }

        // Mark course as visiting
        visited[course] = 1;

        // Explore neighbors
        for (int neighbor : graph.get(course)) {
            if (!dfs(graph, visited, neighbor)) {
                return false;
            }
        }

        // Mark course as fully processed
        visited[course] = 2;
        return true;
    }
}
