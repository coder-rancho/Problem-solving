/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    var paths = {}
    return _uniquePaths(m, n, paths)
}

var _uniquePaths = function(m, n, paths) {
    const str_mn = m.toString() + "_" + n.toString();
    
    if (m < 1 || n < 1) return 0;
    if (m == 1 && n == 1) return 1;
        
    if ( paths[str_mn] == undefined ) paths[str_mn] = _uniquePaths(m, n-1, paths) + _uniquePaths(m-1, n, paths)
    
    return paths[str_mn]
    
}