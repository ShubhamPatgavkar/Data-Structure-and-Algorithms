//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        for(char ch : s2.toCharArray()){
            if(map.containsKey(ch)){
            int f = map.get(ch);
            f--;
            map.put(ch,f);
            if(f == 0){
                map.remove(ch);
               
            }
            }else{
                return false;
            }
        
        }
        
        if(map.isEmpty()){
            return true;
        }
    
        return false;
    }
}