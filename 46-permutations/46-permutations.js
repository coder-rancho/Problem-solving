/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    
    function _permute( candidates, perm) {
        
        if (candidates.length === 0) {
            permutations.push([...perm])
            return
        }
        
        for (let cand of candidates) {
            perm.push(cand);
            _permute(
                candidates.filter(elem => elem != cand),
                perm
            )
            perm.pop()
        }
    }
    
    var permutations = []
    _permute(nums, []);
    return permutations;    
};