// { Driver Code Starts
//Initial Template for javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let start = new Array(n);
        let end = new Array(n);
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            start[i] = input_ar1[i];
        let input_ar2 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            end[i] = input_ar2[i];
        let obj = new Solution();
        console.log(obj.maxMeetings(start, end, n));
    }
}// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} start
 * @param {number[]} end
 * @param {number} n
 * @returns {number}
*/

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    maxMeetings(start, end, n)
    {
        if ( !(start.length) ) return 0;
        // code here
        let slots = [];
        
        start.forEach( (s, i) => {
            slots.push([s, end[i]]);
        });
        
        slots.sort( (a, b) => a[0] - b[0]);
        
        let prev = slots[0]; // largest possible interval
        let count = 1;
        
        slots.forEach( slot => {
            
            if (slot[0] > prev[1]) { // disjoint
                count++;
                prev = slot;
            }
            else if (slot[1] < prev[1]) {
                prev = slot;
            }
        })
        return count;
    }
}






















