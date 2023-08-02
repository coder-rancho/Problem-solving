//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    Arrays.sort(coins);
	    int[][] dp = new int[M][V+1];
	    return f(coins, coins.length-1, V, dp);
	}
	
	private int f(int coins[], int i, int V, int[][] dp) {
	    if (i < 0) return -1;
	    if (V == 0) return 0;
	    
	    if (dp[i][V] != 0) return dp[i][V];
	    
	    if (V < coins[i]) return f(coins, i-1, V, dp);
	    
	    int take = 1 + f(coins, i, V-coins[i], dp);
	    int notTake = f(coins, i-1, V, dp);
	    
	    int ans;
	    if (take == 0) ans = notTake;
	    else if (notTake == -1) ans = take;
	    else ans = Math.min(take, notTake);
	    
	    return dp[i][V] = ans;
	}
}