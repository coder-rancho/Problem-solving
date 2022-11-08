import java.util.*;

class Solution {
    char[][] grid;
    Set<ArrayList> visited;
    int m;
    int n;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.visited = new HashSet<>();
        this.m = grid.length;
        this.n = grid[0].length;
        
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    if (visited.contains(List.of(i, j))) continue;
                    dfs(i, j);
                    count++;
                }
        return count;
    }
    
    void dfs(int row, int col){
        if (row < 0 || col < 0 || row == m || col == n) return;
        
        if (grid[row][col] == '0') return;
        
        if (visited.contains(List.of(row, col))) return;
        visited.add(new ArrayList<Integer>(List.of(row, col)));
        
        dfs(row, col - 1);
        dfs(row, col + 1);
        dfs(row - 1, col);
        dfs(row + 1, col);
    }
}