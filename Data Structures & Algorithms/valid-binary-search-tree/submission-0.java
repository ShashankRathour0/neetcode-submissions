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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true; // An empty tree is a valid BST
        }

        int val = node.val;

        // Check if the current node's value violates the boundaries
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        // Recursively validate left and right subtrees
        // The left subtree's upper bound is the current node's value
        // The right subtree's lower bound is the current node's value
        if (!validate(node.right, val, upper)) {
            return false;
        }
        if (!validate(node.left, lower, val)) {
            return false;
        }

        return true; // All conditions satisfied
    }
}
