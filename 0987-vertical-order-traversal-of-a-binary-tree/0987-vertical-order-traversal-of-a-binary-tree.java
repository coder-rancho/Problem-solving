class Solution {

    class valAtX implements Comparable<valAtX> {
        int val;
        int x;
        valAtX(int val, int row) {
            this.val = val;
            this.x = row;
        }
        
        @Override
        public int compareTo(valAtX o) {
            // if (o.x != this.x) return o.x - this.x;
            if (o.x != this.x) return this.x - o.x;
            else return this.val - o.val;
        }
    }
    
    TreeMap<Integer, PriorityQueue<valAtX>> colNodes;

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        colNodes = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        _verticalTraversal(root, 0, 0);

        for (PriorityQueue<valAtX> pq : colNodes.values()) {
            List<Integer> list = new ArrayList<>();
            while(!pq.isEmpty()) list.add(pq.poll().val);
            ans.add(list);
        }
        return ans;
    }

    void _verticalTraversal(TreeNode node, int row, int col) {
        if (node == null) return;

        if (colNodes.get(col) == null) {
            PriorityQueue<valAtX> pq = new PriorityQueue<>();
            pq.add(new valAtX(node.val, row));
            colNodes.put(col, pq);
        } else {
            colNodes.get(col).add(new valAtX(node.val, row));
        }

        _verticalTraversal(node.left, row+1, col-1);
        _verticalTraversal(node.right, row+1, col+1);
    }
}