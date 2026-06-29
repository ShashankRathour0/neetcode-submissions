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

        // Step 1: Interweave the original and copied nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Set the random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the interleaved list into original and copied lists
        Node original = head;
        Node copyHead = head.next;
        Node copy = copyHead;

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;

    }
}
