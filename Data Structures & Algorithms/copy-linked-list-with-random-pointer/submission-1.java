/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
        public Node copyRandomList(Node head) {
         if (head == null) {
            return null;
        }

        // Step 1: Create a map to store the mapping between original and copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        // First pass: Create copies of all nodes and store them in the map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Set the next and random pointers for the copied nodes
        current = head;
        while (current != null) {
            Node copy = map.get(current);
            copy.next = map.get(current.next);   // Get the copy of the next node
            copy.random = map.get(current.random); // Get the copy of the random node
            current = current.next;
        }

        // Step 3: Return the copied head
        return map.get(head);

    }
}
