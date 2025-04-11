//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int celebrity(int mat[][]) {
        int iknow [] = new int[mat.length];
        int knowme[] = new int[mat.length];
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(i != j && mat[i][j] == 1){
                    iknow[i]++;
                    knowme[j]++;
                }
            }
        }
        
      
        for(int i=0; i< mat.length; i++){
            if(iknow[i] == 0 && knowme[i] == mat.length -1){
                return i;
            }
        }
        
        
        return -1;
    }
}