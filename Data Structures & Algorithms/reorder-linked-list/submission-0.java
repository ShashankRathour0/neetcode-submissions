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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        
        // Fast pointer moves two steps, slow pointer moves one step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Split the list into two halves
        ListNode second = slow.next;
        slow.next = null;  // Terminate the first half
        
        // Step 3: Reverse the second half
        second = reverse(second);
        
        // Step 4: Merge the two halves
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            first.next = second;
            second.next = tmp1;
            
            first = tmp1;
            second = tmp2;
        }
        
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
