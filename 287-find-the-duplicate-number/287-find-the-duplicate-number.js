/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    let found = [];
    
    for (let i = 0; i < nums.length; i++) {
        let num = nums[i];
        if ( found[num] ) return num;
        else found[num] = true;
    }
};