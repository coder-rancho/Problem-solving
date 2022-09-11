import java.util.*;

class Solution {

    class Pair{
        int num;
        int freq;

        Pair(int num) {
            this.num = num;
            this.freq = 1;
        }

        public int getFreq() {
            return this.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Pair> map = new HashMap<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparing(Pair::getFreq).reversed());
        int[] result = new int[k];

        for (int num : nums) {            
            if (map.containsKey(num)) {
                map.get(num).freq += 1;
            } else {
                Pair pair = new Pair(num);
                map.put(num, pair);
                pairs.add(pair);
            }
        }
        map.clear();

        for (Pair p : pairs) {
            maxHeap.add(p);
        }
        pairs.clear();

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().num;
        }

        return result;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,1,1,2,2,3,3,3,3,3};
        int k = 2;
        Solution obj = new Solution();

        int[] result = obj.topKFrequent(nums, k);

        for (int num : result) {
            System.out.println(num);
        }
    }
}