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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with carry

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Compute new carry
            int digit = sum % 10; // Digit to store in the result list

            // Add the digit to the result linked list
            current.next = new ListNode(digit);
            current = current.next;
        }

        // Return the result list starting from the next of dummy
        return dummy.next;
    }
}
