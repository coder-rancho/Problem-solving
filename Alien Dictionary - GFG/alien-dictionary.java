//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = createGraph(dict, K);
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[K];
        
        for (int u = 0; u < K; ++u) {
            for (int v : adj.get(u)) indegree[v]++;
        }
        
        for (int i = 0; i < K; ++i) {
            if (indegree[i] == 0) q.add(i);
        }
        
        int[] order = new int[K];
        int i = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            order[i++] = node;
            
            for (int nbr : adj.get(node)) {
                indegree[nbr]--;
                
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }
        
        
        if (i != K) return ""; // No valid order exist
        
        return generateString(order);
        
    }
    
    private String generateString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        for (int number : numbers) {
            char c = (char) (number + 'a'); 
            sb.append(c);
        }
        return sb.toString();
    }
    
    private ArrayList<ArrayList<Integer>> createGraph(String[] dict, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < k; ++i) adj.add(new ArrayList<Integer>());
        
        for (int i = 0; i < dict.length - 1; ++i) {
            String str1 = dict[i];
            String str2 = dict[i+1];
            int s1 = 0, s2 = 0;
            
            while (s1 < str1.length() && s2 < str2.length()) {
                int u = str1.charAt(s1) - 'a';
                int v = str2.charAt(s2) - 'a';
                
                if (u != v) {
                    adj.get(u).add(v);
                    break;
                }
                s1++;
                s2++;
            }
        }
        return adj;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}










