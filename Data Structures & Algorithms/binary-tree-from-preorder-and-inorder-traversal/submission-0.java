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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
       return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;  // Base case: if the current subarray is invalid, return null
        }
        
        // The first element in the preorder subarray is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root in the inorder array
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }
        
        // The number of nodes in the left subtree is the distance between the root index and the start of the inorder array
        int leftSize = rootIndexInInorder - inStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + leftSize, inStart, rootIndexInInorder - 1);
        root.right = buildTreeHelper(preorder, inorder, preStart + leftSize + 1, preEnd, rootIndexInInorder + 1, inEnd);
        
        return root;
}
}
