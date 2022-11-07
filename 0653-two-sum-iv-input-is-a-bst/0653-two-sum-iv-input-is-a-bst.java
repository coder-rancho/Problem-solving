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
    public boolean findTarget(TreeNode root, int k) {
        inOrder = new ArrayList<>();
        inOrder(root);
        
        int l = 0, r = inOrder.size() - 1;
        while (l < r) {
            int sum = inOrder.get(l) + inOrder.get(r);
            if (sum == k)
                return true;
            else if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }
}