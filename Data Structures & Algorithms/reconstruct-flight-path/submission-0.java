class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
   Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // Step 2: Perform Hierholzer's Algorithm (DFS)
        List<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);

        // Step 3: Return the itinerary
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itinerary) {
        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String nextDestination = destinations.poll();
            dfs(nextDestination, graph, itinerary);
        }

        itinerary.add(0, airport); // Add to the front (reverse order)
    }
}
