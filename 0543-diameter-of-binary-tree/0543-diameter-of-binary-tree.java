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
    
    int max;
    
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }
    
    int dfs(TreeNode node) {
        
        if (node == null) return 0;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        max = Math.max(max, left+right);
        
        return Math.max(left, right) + 1;
    }
}