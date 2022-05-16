class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int G = nums[0];
        
        for (auto num : nums) {
            if (num >= 0) {
                sum += num;
                G = sum > G ? sum : G;
            }
            else if (sum + num > 0) {
                sum += num;
            }
            else {
                sum = 0;
                if (num > G) G = num;
            }
            // cout << "Values for " << num << ":\t" << " G:" << G << " sum:" << sum << endl;
        }
        
        return G;
    }
};