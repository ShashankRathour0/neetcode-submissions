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
    public int goodNodes(TreeNode root) {
         return dfs(root, Integer.MIN_VALUE);
    }
     private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0; // Base case: No nodes, no good nodes
        }

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1; // Current node is good
        }

        // Update the maximum value for the path
        int newMax = Math.max(maxSoFar, node.val);

        // Recur for left and right subtrees
        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }
}
