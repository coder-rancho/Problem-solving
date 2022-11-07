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
    ArrayList<Integer> inOrder;
    public int kthSmallest(TreeNode root, int k) {
        inOrder = new ArrayList<>();
        inOrder(root);
        return inOrder.get(k-1);
    }
    
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }
}