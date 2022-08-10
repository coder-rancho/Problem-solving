class Solution {
    List<List<String>> configs = new ArrayList<>();
        
    public List<List<String>> solveNQueens(int n) {
        
        if (n == 0) return configs;
        
        if (n == 1) {
            configs.add(new ArrayList<>(Arrays.asList("Q")));
            return configs;
        }
        
        String[] row = new String[n];
        Arrays.fill(row, ".");
        
        for (int i = 0; i < n; i++) {
            row[i] = "Q";
            _solveNQueens(n, new ArrayList<>(Arrays.asList(String.join("", row))));
            row[i] = ".";
        }
        
        return configs;
    }
    
    private void _solveNQueens(int n, List<String> config) {
        
        if (config.size() == n) {
            List<String> copy = new ArrayList<>(config);
            configs.add(copy);
            return;
        }
        
        int nextRowi = config.size();
        List<Boolean> queenPositions = new ArrayList<>(Collections.nCopies(n, true));
                
        // Set unavailable queen positions
        int rowi = 0;
        for (; rowi < config.size(); rowi++) {
            int coli = config.get(rowi).indexOf("Q");
            // Vertical 
            queenPositions.set(coli, false);
            // Diagonals
            int leftDiagonal = coli - (nextRowi - rowi);
            int rightDiagonal = coli + (nextRowi - rowi);
            
            if (leftDiagonal >= 0) queenPositions.set(leftDiagonal, false);
            if (rightDiagonal < n) queenPositions.set(rightDiagonal, false);
        }
        
        for (int pos = 0; pos < n; pos++) {
            
            Boolean isAvailable = queenPositions.get(pos);
            
            if (isAvailable) {
                String[] row = new String[n];
                Arrays.fill(row, ".");
                row[pos] = "Q";
                config.add(String.join("", row));
                _solveNQueens(n, config);
                config.remove(config.size() - 1);
            }
        }
        return;
    }
}