/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (
            root == null    // couldn't find the LCA
            || root == p    // p is LCA (if q exists in subtree, else p's ancestor is LCA)
            || root == q    // q is LCA ....p.........................q's.................
        ) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null && right == null) // neither p or q is present in subtree
            return null;
        
        if (left != null && right != null) // both p and q are found, this node is the LCA
            return root;
        
        return left != null ? left : right; // Either p, q or LCA is present on one of the sub-tree
    }
}