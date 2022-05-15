class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> pascalTriangle;
        vector<vector <int>> rowVect = { {1}, {1, 1}};
        
        for (int i=0; i < numRows; i++) {
            pascalTriangle.push_back(rowAt(i+1, rowVect) );
        }
        
        return pascalTriangle;
    }
    
    
    vector<int> rowAt(int row, vector<vector<int>> &rowVect) {
        vector<int> vect(row, 1);
        
        if (rowVect.size() >= row) {
            return rowVect[row - 1];
        }
        
        vector<int> upperRow = rowAt(row - 1, rowVect);
        
        for (int i=0, j=1; j < row-1; i++, j++) {
                vect[j] = upperRow[i] + upperRow[j];
        }
        
        rowVect.push_back(vect);
        return vect;
    }
};