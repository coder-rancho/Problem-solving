//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}

// } Driver Code Ends

public class GfG
{
    int max_sum(int A[], int n)
    {
	// Your code here
		int[] arr = new int[A.length*2];
		
		int indx = 0;
		for(int num : A) arr[indx++] = num;
		for(int num : A) arr[indx++] = num;
		
		int i = 1;
		int sum = 0;
		int store = 0;
		while (i < A.length) {
			sum += (i * A[i]);
			store += A[i];
			i++;
		}
		
		int max = Math.max(sum, Integer.MIN_VALUE);
		
		int l = 1, r = A.length;
		while (r < arr.length) {
		  //  System.out.println(sum);
			sum = sum + (arr[r] * (n-1)) - store;
			store = store + arr[r] - arr[l];
			max = Math.max(max, sum);
			l++; r++;
		}
		return max;
    }

// 	public static void main(String[] args) {
// 		GfG o = new GfG();
// 		System.out.println(o.max_sum(new int[]{8, 3, 1, 2}, 4));
// 	}
}

