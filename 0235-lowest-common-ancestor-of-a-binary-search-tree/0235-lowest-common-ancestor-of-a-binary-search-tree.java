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
        int a, b;
        a = p.val < q.val ? p.val : q.val;
        b = (p.val + q.val) - a;
        return lca(root, a, b);
    }
    
    TreeNode lca(TreeNode root, int p, int q) {
        
        if (root.val <= q && root.val >= p)
            return root;
        else if (q < root.val)
            return lca(root.left, p, q);
        else
            return lca(root.right, p, q);
    }
    
}