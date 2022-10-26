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

        HashMap<TreeNode, Integer> nodeLevel = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> nodeVals = new ArrayList<>();

        int curLevel = 0;
        nodeLevel.put(root, curLevel);
 
        q.add(root);

        while( !q.isEmpty() ) {
            TreeNode node = q.remove();
            System.out.println(node.val + " " + nodeLevel.get(node) + " " + node.left + " " + node.right);
            

            if (nodeLevel.get(node) != curLevel) {
                // System.out.println(nodeLevel.get(node) + " " + node.val + "    " + curLevel);
                result.add(nodeVals);
                nodeVals = new ArrayList<Integer>();
                curLevel = nodeLevel.get(node);
            }

            nodeVals.add(node.val);
            

            if (node.left != null) {
                q.add(node.left);
                nodeLevel.put(node.left, curLevel+1);
            }

            if (node.right != null) {
                q.add(node.right);
                nodeLevel.put(node.right, curLevel+1);
            }
            
        }
        result.add(nodeVals);

        return result;
    }
}