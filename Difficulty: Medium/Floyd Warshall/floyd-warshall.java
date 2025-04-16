//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.floydWarshall(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        
        for(int i=0; i< dist.length; i++){
            for(int j=0; j<dist.length; j++){
               for(int k =0; k < dist.length; k++){
                   if(dist[j][i] != 100000000 && dist[i][k] != 100000000){
                   dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                   }
                       
                   }
            }
        }
        
    }
}