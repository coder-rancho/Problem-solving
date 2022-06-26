/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    
    if (nums.length == 1) return nums
    
    elems = []
    freq = {}
    added = {}
    
    nums.forEach( num => {
        
        if ( freq[num] ) {
            freq[num] += 1;
        }
        else {
            freq[num] = 1;
        }
        
        if (freq[num] > Math.floor( nums.length / 3)) {
            
            if ( !added[num] ) {
                elems.push(num)
                added[num] = true
            }
        }
    })
    return elems;
};