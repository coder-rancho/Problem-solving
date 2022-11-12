class Solution {
    char[][] board;
    int m;
    int n;
    
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        
        int i=0, j=0;
        while (j < n) _solve(i, j++);
        
        i=m-1; j=0;
        while (j < n) _solve(i, j++);
        
        j=0; i=0;
        while (i < m) _solve(i++, j);
        
        j=n-1; i=0;
        while (i < m) _solve(i++, j);
        
        for (int x = 0; x < m; ++x)
            for (int y = 0; y < n; ++y)
                if (board[x][y] == 'O') board[x][y] = 'X';
                else if (board[x][y] == 'V') board[x][y] = 'O';
    }
    
    void _solve(int x, int y) {
        if (board[x][y] == 'O')
            dfs(x, y);
    }
    
    void dfs(int x, int y) {
        if (x < 0 || y < 0 || x == m || y == n) return;
        
        if (board[x][y] != 'O') return;
        board[x][y] = 'V';
        
        dfs(x, y-1);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x+1, y);
        
    }
    
}