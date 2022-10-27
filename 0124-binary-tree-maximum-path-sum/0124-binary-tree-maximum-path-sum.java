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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = -1001;
        _maxPathSum(root);
        return maxSum;     
        
    }
    int _maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        int leftSum = Math.max(0, _maxPathSum(root.left));
        int rightSum = Math.max(0, _maxPathSum(root.right));
        int val = root.val;
        
        maxSum = Math.max(maxSum, val + leftSum + rightSum);
        
        return val + Math.max(0, Math.max(leftSum, rightSum));
    }
}

// public class Solution {
//     int maxValue;
    
//     public int maxPathSum(TreeNode root) {
//         maxValue = Integer.MIN_VALUE;
//         maxPathDown(root);
//         return maxValue;
//     }
    
//     private int maxPathDown(TreeNode node) {
//         if (node == null) return 0;
//         int left = Math.max(0, maxPathDown(node.left));
//         int right = Math.max(0, maxPathDown(node.right));
//         maxValue = Math.max(maxValue, left + right + node.val);
//         return Math.max(0, Math.max(left, right)) + node.val;
//     }
// }