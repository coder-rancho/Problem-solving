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

class Job{
    constructor(id, dead, profit){
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let arr = [];
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<3*n;i+=3){
            arr.push(new Job(input_ar1[i], input_ar1[i+1], input_ar1[i+2]));
        }
        let obj = new Solution();
        let ans = obj.JobScheduling(arr, n);
        let s = '';
        s += ans[0] + " " + ans[1];
        console.log(s);
    }
}// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Job[]} arr
 * @param {number} n
 * @returns {number[]}
*/

/*
class Job{
    constructor(id, dead, profit){
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }
}
*/

class Solution 
{
    //Function to find the maximum profit and the number of jobs done.
    JobScheduling(arr, n)
    {
        // code here
        let jobCount = 0; let maxProfit = 0;
        let maxDays = 0;
        let dayAlloted = {};
        
        arr.sort( (a, b) => b.profit - a.profit);
        
        arr.forEach( job => {
            let dl = job.dead;
            
            while ( dayAlloted[dl] && dl > 0) dl -= 1;
            
            if (dl == 0) return;
            
            // console.log(job);
            dayAlloted[dl] = true;
            jobCount += 1;
            maxProfit += job.profit;
        });
        
        return [jobCount, maxProfit];
    }
}