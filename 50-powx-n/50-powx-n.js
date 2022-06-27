/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    
    return Math.pow(x, n);
    
    if (n == 0) return 1
    
    const product = pow(x, Math.abs(n))
    
    if (n < 0) return 1/product
    
    return product
    
};

var pow = function(x, n) {
    var x_n = {}
    const str_xn = x.toString + "_" + n.toString
    
    if (n == 1) return x;
    
    if ( x_n[str_xn] ) return x_n[str_xn]
    
    let n_2 = Math.floor(n/2);
    let result;
    
    if (n % 2 == 0) {
        result = pow(x, n_2) * pow(x, n_2)
        x_n[str_xn] = result
    }
    else {
        result = pow(x, n_2) * pow(x, n_2 + 1)
        x_n[str_xn] = result
        
    }
    return result
}