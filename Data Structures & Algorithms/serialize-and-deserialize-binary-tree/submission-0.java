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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
          StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         String[] nodes = data.split(",");
        int[] index = new int[1];  // To keep track of current index while deserializing
        return deserializeHelper(nodes, index);
    }
    private TreeNode deserializeHelper(String[] nodes, int[] index) {
        if (index[0] >= nodes.length || nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = deserializeHelper(nodes, index);
        node.right = deserializeHelper(nodes, index);
        
        return node;
    }
}
