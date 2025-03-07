//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     public int find(int i, int j , String s1, String s2, int[][] dp){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];    
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + find(i + 1, j + 1,s1,s2,dp);
        }
        
        return dp[i][j] = Math.max(find(i+1,j,s1,s2,dp), find(i, j+1, s1, s2,dp));
        
    }
    
    public int lcs(String s1, String s2) {
            
        int dp[][]=  new int[s1.length()][s2.length()];
        
        for(int i=0; i < s1.length();i++){
            for(int j =0; j < s2.length(); j++){
                dp[i][j] = -1;
            }
        }
        
        return find(0,0,s1,s2,dp);
    }
    
    public int longestPalinSubseq(String s) {
        // code here
        String t = s;
         String reversed = new StringBuffer(t).reverse().toString();
        return lcs(s,reversed);
    }
}