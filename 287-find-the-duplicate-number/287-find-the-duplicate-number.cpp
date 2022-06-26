class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        map <int, bool> isExist;
        
        for (int i = 0; i < nums.size(); i++ ) {
            int num = nums[i];
            
            if ( isExist[num] == true ) return num;
            else isExist[num] = true;
        }
        
        return 0;
    }
};