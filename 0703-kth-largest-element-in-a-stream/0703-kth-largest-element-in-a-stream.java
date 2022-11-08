class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        for (int num : nums) temp.add(num);
        while (this.pq.size() < k && !temp.isEmpty()) pq.add(temp.poll());
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */