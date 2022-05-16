class Solution {
public:
    
    int findInd1(vector<int>& nums, int len) {
        int ind1 = -1;
    
        for (int i=len-2; i >= 0; i--) {
            
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }
        
        return ind1;
    }
    
    int findInd2(vector<int>& nums, int len, int ind1) {
        int ind2;
        for (int i = len - 1; i > ind1; i-- ) {
            if (nums[i] > nums[ind1]) {
                ind2 = i;
                break;
            }
        }
        return ind2;
    }
    
    void reverseRight(vector<int>& nums, int indStart) {
        auto startItr = nums.begin() + indStart;
        auto endItr = nums.end();
        reverse(startItr, endItr);
    }
    
    void swap(vector<int>& nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void nextPermutation(vector<int>& nums) {
        if (nums.size() == 0 || nums.size() == 1) return;
        // if (nums.size() == 2)
        
        int len = nums.size();
        int ind1 = findInd1(nums, len);
        cout << "Ind1:\t" << ind1 << endl;
        
        if (ind1 == -1) { // not found
            reverse(nums.begin(), nums.end());
            return;
        }
        
        int ind2 = findInd2(nums, len, ind1);
        cout << "Ind2:\t" << ind2 << endl;
        
        swap(nums, ind1, ind2);
        cout << "Vector after Swapping:\t";
        for (auto i : nums) cout << i << " ";
        
        reverseRight(nums, ind1 + 1);
        
        
    }
};