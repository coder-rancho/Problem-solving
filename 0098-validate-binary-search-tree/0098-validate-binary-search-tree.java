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
        arr = new ArrayList<Integer>();
        inorder(root);
        long prev = Long.MIN_VALUE;
        for (int num : arr)
            if (prev >= num) return false;
            else prev = num;
        return true;
    }
    
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
    
  
}