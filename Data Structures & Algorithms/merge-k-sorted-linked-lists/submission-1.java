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
//   if (lists == null || lists.length == 0) return null;

//         // Priority queue to store the smallest elements
//         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

//         // Add the head of each linked list to the priority queue
//         for (ListNode list : lists) {
//             if (list != null) {
//                 minHeap.add(list);
//             }
//         }

//         // Dummy node to build the result list
//         ListNode dummy = new ListNode(0);
//         ListNode current = dummy;

//         // While there are nodes in the priority queue
//         while (!minHeap.isEmpty()) {
//             // Get the smallest node
//             ListNode smallest = minHeap.poll();
//             current.next = smallest; // Add it to the result list
//             current = current.next;

//             // If the smallest node has a next, add it to the queue
//             if (smallest.next != null) {
//                 minHeap.add(smallest.next);
//             }
//         }

//         return dummy.next;

if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    
    }
}
