/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
  if (lists == null || lists.length == 0) return null;

        // Priority queue to store the smallest elements
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // While there are nodes in the priority queue
        while (!minHeap.isEmpty()) {
            // Get the smallest node
            ListNode smallest = minHeap.poll();
            current.next = smallest; // Add it to the result list
            current = current.next;

            // If the smallest node has a next, add it to the queue
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
