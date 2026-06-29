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
 //  ljkshg




class Solution {
    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null) {
            return false; // No cycle possible in empty or single-node list
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by one step
            fast = fast.next.next;  // Move fast pointer by two steps

            if (slow == fast) {     // Cycle detected
                return true;
            }
        }

        return false; 
    }
}
