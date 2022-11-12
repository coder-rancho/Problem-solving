class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                }
        
        int minTime = 0;
        
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int time = cell[2];
            
            if (x < 0 || x == m || y < 0 || y == n) continue;
            
            if (grid[x][y] <= 0) continue;
            
            if (grid[x][y] == -1) continue; //visited
            else grid[x][y] = -1;
            
            minTime = Math.max(minTime, time);
            
            q.add(new int[]{x, y+1, time+1});
            q.add(new int[]{x, y-1, time+1});
            q.add(new int[]{x-1, y, time+1});
            q.add(new int[]{x+1, y, time+1});
        }
        
        for (int[] row : grid)
            for (int elem : row)
                if (elem == 1) return -1;
        
        return minTime;
    }
}