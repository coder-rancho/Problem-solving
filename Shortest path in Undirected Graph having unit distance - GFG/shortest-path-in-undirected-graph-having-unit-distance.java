//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) adj.add(new ArrayList<Integer>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[src] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            for (int nbr : adj.get(node)) {
                
                if (ans[nbr] == -1) ans[nbr] = ans[node] + 1;
                else if (ans[nbr] > ans[node]) ans[nbr] = ans[node] + 1;
                else continue;
                
                q.add(nbr);
            }
        }
        
        return ans;
    }
}