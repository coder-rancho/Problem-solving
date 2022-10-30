/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    const total = nums.reduce((a, b) => a+b, 0)
    let sum = 0
    for (let i = 0; i < nums.length; sum += nums[i++])
        if (sum*2 == total - nums[i]) return i
    return -1
};