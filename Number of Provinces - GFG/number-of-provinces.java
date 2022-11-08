//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> adjM;
    static boolean[] visited;
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        // adjL = initAdjL(adj);
        adjM = adj;
        visited = new boolean[adj.size()];
        int count = 0;
        
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i]) continue;
            count++;
            dfs(i);
        }
        return count;
    }
    
    static void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        for (int i = 0; i < adjM.size(); i++)
            if (adjM.get(node).get(i) == 1) dfs(i);
    }
    
    
    
    
    
    
    
    
    
    static ArrayList<ArrayList<Integer>> initAdjL(ArrayList<ArrayList<Integer>> matrix) {
        int len = matrix.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < len; i++)
            res.add(new ArrayList<Integer>());
        
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (matrix.get(i).get(j) == 1 && i != j) {
                    res.get(i).add(j);
                    // res.get(j).add(i);
                }
        
        return res;
    }
};