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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     maxGain(root);
        return maxSum;
    }

    // This function computes the max gain (path sum) starting from a given node
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;  // Base case: If the node is null, the max gain is 0
        }

        // Recursively compute the max gain from the left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0);  // If negative, ignore the left subtree
        int rightGain = Math.max(maxGain(node.right), 0);  // If negative, ignore the right subtree

        // Calculate the price of the current path (node + left subtree + right subtree)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum path sum if the current path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain that can be obtained by continuing the path upwards
        return node.val + Math.max(leftGain, rightGain);
        
    }
}
