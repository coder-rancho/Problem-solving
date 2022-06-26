/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    
    if ( intervals.length == 0 ) return intervals;
    
    intervals.sort( (a, b) => a[0] - b[0]) // -ve => a < b
    
    let mergedIntervals = []
    let temp = intervals[0]
    
    for (let i = 1; i < intervals.length; i++) {
        let interval = intervals[i]
        
        // merge condition
        if ( interval[0] <= temp[1] ) {
            temp[1] = interval[1] > temp[1] ? interval[1] : temp[1];
        }
        else {
            mergedIntervals.push(temp)
            temp = interval
        }
    }
    
    mergedIntervals.push(temp)
    
    return mergedIntervals
}