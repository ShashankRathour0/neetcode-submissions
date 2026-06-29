/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        // HashMap to store the mapping between original node and copied node
        Map<Node, Node> visited = new HashMap<>();
        
        // Start DFS to clone the graph
        return dfs(node, visited);
    }
        private Node dfs(Node node, Map<Node, Node> visited) {
        // If the node is already visited, return the copied node from the map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        // Create a new node with the same value as the original node
        Node newNode = new Node(node.val);
        
        // Add the new node to the visited map
        visited.put(node, newNode);
        
        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor, visited));
        }
        
        return newNode;
    }
}