/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    
    // Moore's voting approach
    let count = 0
    let candidate = 0
    
    nums.forEach(num => {
        
        if (count == 0) candidate = num;
        
        if ( num == candidate ) count++
        else count--
    })
    return candidate
};