class Solution {
    int[][] board;
    int m;
    int n;
    
    public int numEnclaves(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.board = grid;
        
        int i=0, j=0;
        while (j < n) _solve(i, j++);
        
        i=m-1; j=0;
        while (j < n) _solve(i, j++);
        
        j=0; i=0;
        while (i < m) _solve(i++, j);
        
        j=n-1; i=0;
        while (i < m) _solve(i++, j);
        
        int count = 0;
        for (int x = 0; x < m; ++x)
            for (int y = 0; y < n; ++y)
                if (board[x][y] == 1) count++;
        
        return count;
    }
    
    void _solve(int x, int y) {
        if (board[x][y] == 1)
            dfs(x, y);
    }
    
    void dfs(int x, int y) {
        if (x < 0 || y < 0 || x == m || y == n) return;
        
        if (board[x][y] != 1) return;
        board[x][y] = -1;
        
        dfs(x, y-1);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x+1, y);
        
    }
}