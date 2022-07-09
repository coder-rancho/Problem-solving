/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let map = {}
    
    for (let i = 0; i < nums.length; i++) {
        
        let elem1 = nums[i];
        let pt2 = map[target - elem1];
        
        if (pt2 != undefined) {
            return [i, pt2];
        }
        else {
            map[elem1] = i;
        }
        
    }
};