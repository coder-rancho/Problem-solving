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
    int[] preord;
    int[] inord;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // init Global variables
        preord = preorder;
        inord = inorder;
        map = new HashMap<>();

        // init map to store index of preorder arr
        int i = 0;
        for(int elem : preorder)
            map.put(elem, i++);
        
        // return the root node
        return _buildTree(0, inorder.length-1);       

    }

    // Divide and Conquer => find the value of node and then find left & right child recursively
    public TreeNode _buildTree(int inS, int inE) { // inord-subarray = inord[inS...inE]
        
        // No sub-array is available for either left or right side
        if (inS > inord.length || inE < 0) return null;
        
        if (inS > inE) return null;

        // If only one node is there, that's the leaf node.
        int len = (inE - inS + 1);
        if ( len == 1) {
            TreeNode node = new TreeNode(inord[inS]);
            return node;
        }

        int minPreordIndx = Integer.MAX_VALUE;  
        int inordIndx = -1;

        for (int i = inS; i <= inE; i++) {
            int elem = inord[i];
            int preordIndx = map.get(elem);
            if (preordIndx < minPreordIndx) {
                minPreordIndx = preordIndx;
                inordIndx = i;
            }
        }

        TreeNode node = new TreeNode(inord[inordIndx]);
        node.left = _buildTree(inS, inordIndx - 1);
        node.right = _buildTree(inordIndx + 1, inE);
        
        return node;
    }
}