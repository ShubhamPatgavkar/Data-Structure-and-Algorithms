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
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        
        int ans=-1;
        int l=0;
        int r=0;
        int n = s.length();
        HashMap<Character,Integer>map = new HashMap<>();
        
        // maintaining the window
    
        while(r < n){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            // int f = map.get(ch);
            
            if(map.size() == k){
                ans = Math.max(ans,r-l+1);
            }
            // if the map has more number of characters 
            while(l<n && map.size() > k){
                map.put(s.charAt(l),map.get(s.charAt(l)) -1);
                if(map.get(s.charAt(l))  == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            r++;
            
        }
        
        return ans;
        
    }
}