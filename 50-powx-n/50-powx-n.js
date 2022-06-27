/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    
    return n == 0 ? 1
        : n == 1 ? x
        : n == -1 ? 1/x
        : n % 2 == 0 ? (myPow(x, n/2))**2
        : x * myPow(x, n-1);
};
