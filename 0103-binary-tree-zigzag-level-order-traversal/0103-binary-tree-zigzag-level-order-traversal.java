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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        Deque<TreeNode> dq = new LinkedList<>();
        boolean isLeftToRight = true;
        dq.addLast(root);
        
        while (!dq.isEmpty()){
            
            int n = dq.size();
            ArrayList<Integer> nodes = new ArrayList<>();
            
            for (int i = n-1; i > -1; i--) {
                
                if (isLeftToRight) {
                    
                    TreeNode node = dq.removeFirst();
                        
                        nodes.add(node.val);
                        
                        if (node.left != null)
                            dq.addLast(node.left);
                        if (node.right != null)
                            dq.addLast(node.right);
                } else {
                    TreeNode node = dq.removeLast();
                        
                        nodes.add(node.val);
                        
                        if (node.right != null) 
                            dq.addFirst(node.right);
                        if (node.left != null)
                            dq.addFirst(node.left);
                }
                
            }
            if (nodes.size() > 0) result.add(nodes);
            isLeftToRight = !isLeftToRight;            
        }
        
        
        return result;
    }
}