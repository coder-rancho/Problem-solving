/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let rev = 0;
    let tem = x;
    if(x<0 ||(x % 10 == 0 && x != 0) ){
        return false
    }
    
    while (x > 0){
        rev = rev * 10 + x % 10;   
        x = x / 10;
        x = parseInt(x)
    }
    
    return tem == rev
}; 