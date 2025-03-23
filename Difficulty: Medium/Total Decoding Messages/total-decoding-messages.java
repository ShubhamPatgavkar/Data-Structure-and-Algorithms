//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        int dp[] = new int[digits.length()];
        Arrays.fill(dp, -1);
        return cWays(digits, 0, dp);
    }
    public int cWays(String d, int i, int []dp){
        // base cases 
        if(i >= d.length()){
            return 1;
        }
        else if(d.charAt(i) == '0'){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        if(i == d.length() - 1){
            return 1;
        }
        
        if(d.charAt(i) == '1' || d.charAt(i) == '2' && d.charAt(i+1) >= 48 && d.charAt(i+1) <= 54){
            return dp[i] = cWays(d , i + 1, dp) + cWays(d, i + 2,dp);
        }else{
            return dp[i] = cWays(d , i + 1, dp);
        }
    }
}