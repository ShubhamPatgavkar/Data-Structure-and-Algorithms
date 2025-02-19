//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int M = Integer.parseInt(read.readLine());
            int mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(mat));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minRow(int mat[][]) {
        // code here/
        int c =0;
        int ans = Integer.MAX_VALUE;
        int r =0;
        
        for(int i=0; i< mat.length; i++){
            c =0;
            for(int j=0; j< mat[0].length; j++){
                if(mat[i][j] == 1){
                    c++;
                }
                
            }
            if(c < ans){
                ans = c;
                r = i; 
            }
        }
    
        return r+1 ;
    }
}