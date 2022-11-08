class Solution {
    Set<ArrayList<Integer>> visited;
    int m;
    int n;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new HashSet<>();
        this.m = image.length;
        this.n = image[0].length;
        _floodFill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    void _floodFill(int[][] image, int sr, int sc, int color, int matchColor) {
        
        if (sr < 0 || sc < 0 || sr == m || sc == n)
            return;
        
        if (image[sr][sc] != matchColor)
            return;
        
        if (visited.contains(new ArrayList<Integer>(List.of(sr, sc))))
            return;
        
        image[sr][sc] = color;
        visited.add(new ArrayList<Integer>(List.of(sr, sc)));
        
        _floodFill(image, sr, sc-1, color, matchColor);
        _floodFill(image, sr-1, sc, color, matchColor);
        _floodFill(image, sr, sc+1, color, matchColor);
        _floodFill(image, sr+1, sc, color, matchColor);
    }
}