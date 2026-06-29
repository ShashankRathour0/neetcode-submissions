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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
             ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Initialize pointers for both lists
        ListNode p1 = list1;
        ListNode p2 = list2;
        
        // Merge the two lists
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                current.next = p1;  // Attach p1's node
                p1 = p1.next;  // Move p1 forward
            } else {
                current.next = p2;  // Attach p2's node
                p2 = p2.next;  // Move p2 forward
            }
            current = current.next;  // Move current forward
        }
        
        // If one list is not empty, attach the remaining nodes
        if (p1 != null) {
            current.next = p1;
        } else {
            current.next = p2;
        }
        
        // Return the merged list (skip the dummy node)
        return dummy.next;
    }
}