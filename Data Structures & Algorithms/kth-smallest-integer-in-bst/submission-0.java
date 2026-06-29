/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int count = 0;  // Counter to track the current node position
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }
     private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Increment the counter and check if it's the kth node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }
}
