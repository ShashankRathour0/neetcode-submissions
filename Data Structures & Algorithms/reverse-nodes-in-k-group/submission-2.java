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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
        return head;
        if(head.next==null)
        return head;
        if(head==null||k==1)
        return head;
  ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head; // Not enough nodes to reverse
            temp = temp.next;
        }
        ListNode c=head;
        ListNode p=null;
        ListNode n=null;
        int l=k;
        while(c!=null&&l-->0)
        {
           
            n=c.next;
            c.next=p;
            p=c;
            c=n;

        }
if(n!=null)
        head.next=reverseKGroup(n,k);

        return p;

    }
}
