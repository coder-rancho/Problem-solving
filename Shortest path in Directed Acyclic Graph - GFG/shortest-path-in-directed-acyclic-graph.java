//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    class Neighbour {
        int node;
        int distance;
        
        Neighbour(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Neighbour>> adj = new ArrayList<>();
		int[] visited = new int[N];
		int[] ans = new int[N];
		Arrays.fill(ans, -1);
		ans[0] = 0;
		
		for (int i = 0; i < N; ++i) adj.add(new ArrayList<Neighbour>());
		
		for (int[] edge : edges) adj.get(edge[0]).add(new Neighbour(edge[1], edge[2]));
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while (!q.isEmpty()) {
		   int node = q.poll();
		    
		    for (Neighbour nbrNode : adj.get(node)) {
		        int nbr = nbrNode.node;
		        int distance = nbrNode.distance;
		        
		        if (ans[nbr] == -1) ans[nbr] = ans[node] + distance;
		        else ans[nbr] = Math.min(ans[nbr], ans[node] + distance);
		        
		        q.add(nbr);
		    }
		}
		
		return ans;
	}
}