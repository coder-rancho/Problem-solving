class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        set <int> hashset;
        
        for(int num: nums) {
            hashset.insert(num);
        }
        
        int maxSeq = 0;
        
        for (int num: nums) {
            
            if ( !hashset.count(num - 1)) {
                int seq = 1;

                while ( hashset.count(num + 1) ) {
                    num += 1;
                    seq += 1;
                }
                
                maxSeq = max(seq, maxSeq);
            }
        }
        return maxSeq;
    }
};