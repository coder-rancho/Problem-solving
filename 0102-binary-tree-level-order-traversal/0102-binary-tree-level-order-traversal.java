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


    public List<List<Integer>> levelOrder(TreeNode root) {

        // Note: how I've defined the result.
        // type = List<List<Integer>>   bcoz return type should be identical
        // object = ArrayList<...>()    bcoz you can't create an object of type List<>
        // object = Ar...<List<Intege>>() and not Ar...<ArrayList<Integer>> 
        // bcoz List of List maybe equal to List of LinkedList which is not supported by Arraylist
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 

        if (root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> nodeVals = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                
                if (node == null) continue;
                
                nodeVals.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            
            if (nodeVals.size() > 0) result.add(nodeVals);
        }
        
        
        return result;
    }
}