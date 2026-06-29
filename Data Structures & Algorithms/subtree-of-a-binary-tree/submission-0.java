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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
          if (root == null) {
            return false; // If the main tree is empty, it can't contain a subtree
        }
        
        if (isSameTree(root, subRoot)) {
            return true; // If the trees match, subRoot is a subtree of root
        }

        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
     private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true; // Both trees are empty
        }
        if (p == null || q == null) {
            return false; // One tree is empty, and the other is not
        }
        if (p.val != q.val) {
            return false; // Node values differ
        }

        // Check if left and right subtrees match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
