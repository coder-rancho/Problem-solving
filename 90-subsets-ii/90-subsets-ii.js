/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    
    function subsets(nums, l, r, subset=[]) {
        
        if (l > r) {
            let copy = [...subset];
            let copyStr = copy.join();
            
            if (dp[copyStr]) return;
            else {
                result.push(copy);
                dp[copyStr] = true;
            }
            
            return;
        }
        
        subset.push(nums[l]);
        
        subsets(nums, l+1, r, subset);
        
        subset.pop();
        
        subsets(nums, l+1, r, subset);
    }
    
    var result = [ ]
    var dp = {}
    nums.sort();
    subsets(nums, 0, nums.length - 1);
    
    return result;
};