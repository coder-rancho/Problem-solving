class Solution {
public:
    void sortColors(vector<int>& nums) {
        int l = 0;
        int p = 0;
        int r = nums.size() - 1;
        
        while (p <= r) {
            
            if (nums[p] == 2) {
                nums[p] = nums[r];
                nums[r--] = 2;
            }
            else if (nums[p] == 0) {
                nums[p++] = nums[l];
                nums[l++] = 0;
            }
            else {
                p++;
            }
        }
    }
};