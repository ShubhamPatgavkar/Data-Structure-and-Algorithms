//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int maxLength(String s) {
        
        int l =0;
        int r =0; 
        int ans = 0;
     
     // for left traversal
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                r++;
            }
            if (ch == '('){
                l++;
            }
            
            if(l == r){
                ans = Math.max(ans,l*2);
            }else if(r > l){
                l =0;
                r =0;
            }
                
        }
        
        l =0;
        r =0;
        
        // for right to left
         for(int i= s.length()-1; i>=0; i--){
            
            char ch = s.charAt(i);
            if(ch == ')'){
                r++;
            }
            if (ch == '('){
                l++;
            }
            
            if(l == r){
                ans = Math.max(ans,l*2);
            }else if(r < l){
                l =0;
                r =0;
            }
                
        }
    
        
  
        
    
        return ans;
    }
}