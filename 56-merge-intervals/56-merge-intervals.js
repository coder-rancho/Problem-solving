/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    
    let compFunc = (a, b) => {
        return a[0] - b[0];
    }
    
    let sortedIntervals = intervals.sort(compFunc);
    let mergedIntervals = [];
    let mergedInterval = sortedIntervals[0];
    let low = 0, high = 1;
    
    sortedIntervals.forEach( interval => {
        
        if ( interval[low] <= mergedInterval[high] ) { // can be merged
            if ( interval[high] > mergedInterval[high] ) {
                mergedInterval[high] = interval[high];
            }
        } else {
            mergedIntervals.push(mergedInterval);
            mergedInterval = interval;
        }
    })
    mergedIntervals.push(mergedInterval); // last mergedInterval
    
    return mergedIntervals;
};
