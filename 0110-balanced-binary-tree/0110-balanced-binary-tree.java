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
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        dfs(root);
        return flag;        
    }
    
    int dfs(TreeNode root) {
        if (root == null || !flag) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int diff = left - right;
        
        if (diff > 1 || diff < -1) flag = false;
        
        return Math.max(left, right) + 1;
    }
}