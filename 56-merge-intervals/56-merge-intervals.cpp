class Solution {
public:
    
    // comparator function
    static bool compFunc( vector<int> v1, vector<int> v2) {
        return v1[0] < v2[0];
    }
    
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        if (intervals.size() == 0) return intervals;
        
        sort(intervals.begin(), intervals.end(), compFunc);

        vector <vector <int>> mergedIntervals = {};
        vector <int> temp = intervals[0];
        vector <int> interval;

        for (int i = 1; i < intervals.size(); i++) {
            interval = intervals[i];
            
            if ( interval[0] <= temp[1] ) {
                temp[1] = interval[1] > temp[1] ? interval[1] : temp[1];
            }
            else{
                mergedIntervals.push_back(temp);
                temp = interval;
            }
        }
        mergedIntervals.push_back(temp);
        
        return mergedIntervals;
    }
};