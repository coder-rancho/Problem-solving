class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix[0].size();
        int arr[4];
        
        for (int r=0; r <= n-2; r++) {
            for (int c=r; c <= n-2-r; c++ ) {
                arr[0] = matrix[r][c];
                arr[1] = matrix[c][n-1-r];
                arr[2] = matrix[n-1-r][n-1-c];
                arr[3] = matrix[n-1-c][r];
                
                matrix[c][n-1-r] = arr[0];
                matrix[n-1-r][n-1-c] = arr[1];
                matrix[n-1-c][r] = arr[2];
                matrix[r][c] = arr[3];
                
            }
        }
    }
};