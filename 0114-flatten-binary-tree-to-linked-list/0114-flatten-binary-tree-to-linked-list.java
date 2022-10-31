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
    public void flatten(TreeNode root) {
        _flatten(root, null);
    }
    
    TreeNode _flatten(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode newTail = _flatten(root.right, tail);
        root.right = _flatten(root.left, newTail);
        root.left = null;
        return root;
    }
}