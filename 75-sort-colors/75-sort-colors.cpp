class Solution {
public:
    void sortColors(vector<int>& nums) {
        int l = 0;
        int p = 0;
        int r = nums.size() - 1;
        
        while (p <= r) {
            
            switch (nums[p]) {
            
                case 0:
                    swap(nums[l++], nums[p++]);
                    break;
                    
                case 1:
                    p++;
                    break;
                    
                case 2:
                    swap(nums[r--], nums[p]);
            }
        }
    }
};