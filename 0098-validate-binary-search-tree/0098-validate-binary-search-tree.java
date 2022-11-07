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
    
    ArrayList<Integer> arr;
    
    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean _isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return _isValidBST(root.left, min, root.val) && _isValidBST(root.right, root.val, max);
    }
    
  
}