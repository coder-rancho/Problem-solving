import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Solution {
    
    class Elem {
        int idx;
        int val;

        Elem(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int resultSize = nums.length - k + 1;
        int[] result = new int[resultSize];
        PriorityQueue<Elem> maxheap = new PriorityQueue<>(Comparator.comparing(Elem::getVal).reversed());

        int ptr = 0;
        for(; ptr < k; ++ptr) maxheap.add(new Elem(ptr, nums[ptr]));
        
        int r = 0;
        result[r++] = maxheap.peek().val;

        for (; ptr < nums.length; ++ptr) {
            maxheap.add(new Elem(ptr, nums[ptr]));
            result[r++] = currMax(maxheap, ptr - k + 1);
        }

        return result;
    }

    private int currMax(PriorityQueue<Elem> heap, int start) {
        while(heap.peek().idx < start) heap.poll();
        return heap.peek().val;
    }


    public static void main(String[] args) {
        Solution o = new Solution();
        int[] nums = {1};
        int k = 1;

        for (int num : o.maxSlidingWindow(nums, k)) System.out.println(num);
    }
}