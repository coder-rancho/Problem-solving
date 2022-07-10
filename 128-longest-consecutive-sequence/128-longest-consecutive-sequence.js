/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
    let maxSeq = 0
    let isExist = {}
    
    for (let i = 0; i < nums.length; i++) {        
        let seq = 1;
        isExist[nums[i]] = true
        
        let itr = nums[i]
        while ( isExist[++itr] != undefined ) seq++;
        itr = nums[i]
        while ( isExist[--itr] != undefined ) seq++;
        
        
        if (seq > maxSeq) maxSeq = seq;
    }
    return maxSeq;
};