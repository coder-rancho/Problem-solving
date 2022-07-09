class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> pair;
        unordered_map<int, int> map;
        
        for (int i = 0; i < nums.size(); i++) {
            
            int elem1 = nums[i];
            auto pt2 = map.find(target - elem1);
            
            if (pt2 != map.end() ) {
                pair.emplace_back(i);
                pair.emplace_back(pt2 -> second);
                break;
            }
            
            map[nums[i]] = i;
        }
        return pair;
    }
};