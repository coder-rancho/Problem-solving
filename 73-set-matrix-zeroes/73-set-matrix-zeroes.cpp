class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        unordered_set <int> null_m = {};
        unordered_set <int> null_n = {};
        
        int rows = matrix.size();
        int cols = matrix[0].size();
        
        for (int m=0; m < rows; m++) {
            for (int n=0; n < cols; n++) {
                if (matrix[m][n] == 0) {
                    null_m.insert(m);
                    null_n.insert(n);
                }
            }
        }
        
        for (auto itr = null_m.begin(); itr != null_m.end(); itr++) {
            vector<int> vect(cols, 0);
            int row = *itr;
            matrix[row] = vect;
        }
        
        for (auto itr = null_n.begin(); itr != null_n.end(); itr++) {
            int n = *itr;
            for (int m=0; m < rows; m++) {
                matrix[m][n] = 0;
            }
        }
    }
};