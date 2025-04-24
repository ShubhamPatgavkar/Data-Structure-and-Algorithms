//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


import java.io.*;
import java.util.*;


class Array {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.findSum(a,n));
        
System.out.println("~");
}
        
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public static void findMinMax(int ans[], int arr[], int i, int j) {
        // Base case: only one element
        if (i == j) {
            ans[0] = Math.min(ans[0], arr[i]);
            ans[1] = Math.max(ans[1], arr[i]);
            return;
        }

        // Base case: two elements
        if (j == i + 1) {
            int localMin = Math.min(arr[i], arr[j]);
            int localMax = Math.max(arr[i], arr[j]);
            ans[0] = Math.min(ans[0], localMin);
            ans[1] = Math.max(ans[1], localMax);
            return;
        }

        // Recursive case
        int mid = i + (j - i) / 2;
        findMinMax(ans, arr, i, mid);
        findMinMax(ans, arr, mid + 1, j);
    }

    public static int findSum(int A[], int N) {
        int ans[] = new int[2];
        ans[0] = Integer.MAX_VALUE; // min
        ans[1] = Integer.MIN_VALUE; // max
        findMinMax(ans, A, 0, N - 1);
        return ans[0] + ans[1];
    }
}
