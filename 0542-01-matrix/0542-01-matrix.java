class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int[] row : ans)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (mat[i][j] == 0)
                    q.add(new int[]{i, j, 0});
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1], dist = cell[2];
            
            if (x < 0 || x == m || y < 0 || y == n) continue;
            
            if (visited[x][y]) continue;
            else visited[x][y] = true;
            
            ans[x][y] = dist;
            
            q.add(new int[]{x, y-1, dist+1});
            q.add(new int[]{x, y+1, dist+1});
            q.add(new int[]{x-1, y, dist+1});
            q.add(new int[]{x+1, y, dist+1});
        }
        
        return ans;
    }
}