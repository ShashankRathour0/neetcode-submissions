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
    public ListNode removeNthFromEnd(ListNode head, int n) {
 // Create a dummy node to simplify edge case handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize fast and slow pointers
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n+1 steps ahead to maintain the gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from the end
        slow.next = slow.next.next;
        
        // Return the head of the modified list
        return dummy.next;
    }
}
