/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    
    if (nums.length == 1) return nums[0];
    
    let freq = {}
    let elem;
    nums.forEach( num => {
             
        if ( freq[num] ) {
            freq[num] += 1

            if (freq[num] > Math.floor((nums.length)/2) ) {
                elem = num
                return // to return from forEach loop
            };
        }
        else {
            freq[num] = 1
        }
    })
    return elem;
};