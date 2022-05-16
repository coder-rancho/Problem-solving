class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count[3] = {0};
        int len = nums.size();
        
        for (auto i : nums) {
            count[i]++;
        }
            
        int indx = 0;
        for (int c = 0; c < 3; c++) {
            int elemCount = count[c];
            
            while(elemCount--) {
                nums[indx++] = c;
            }
        }
    }
};