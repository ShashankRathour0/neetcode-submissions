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
    public int maxDepth(TreeNode root) {
          if (root == null) {
            return 0; // Base case: empty tree has depth 0
        }

        int leftDepth = maxDepth(root.left);  // Depth of left subtree
        int rightDepth = maxDepth(root.right); // Depth of right subtree

        return 1 + Math.max(leftDepth, rightDepth); 
    }
}
