/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getPermutation = function(n, k) {
    
    var _getPermutation = function(str, arr, permCount) {

        if (arr.length === 0) {
            return {
                count: permCount + 1,
                permutation: str
            }
        }

        for (let i in arr) {
            let newStr = str + arr[i].toString()
            let newArr = arr.filter(elem => elem != arr[i])
            let { count, permutation } = _getPermutation(newStr, newArr, permCount)
            
            if (count === k) return {count, permutation};
            else permCount = count
        }
        
        return {
            count: permCount,
            permutation: str
        }
    }

    let arr = [...Array(n+1).keys()].slice(1)
    let {count, permutation} = _getPermutation("", arr, 0)
    return permutation    
};