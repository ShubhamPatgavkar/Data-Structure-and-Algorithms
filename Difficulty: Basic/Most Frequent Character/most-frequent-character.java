//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String line = br.readLine().trim();

            Solution obj = new Solution();

            System.out.println(obj.getMaxOccuringChar(line));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String s) {
        
       HashMap<Character,Integer> map = new HashMap<>();
       
       int count = 0;
       char ch = s.charAt(0);
       
       for(char ele : s.toCharArray()){
           map.put(ele, map.getOrDefault(ele, 0)+1);
       }
       
       for(int i=0; i<s.length(); i++){
           
           if(map.get(s.charAt(i)) > count){
               count = map.get(s.charAt(i));
               ch = s.charAt(i);
           }
           else if(count == map.get(s.charAt(i))){
            //   char min = (char)Math.min(s.charAt(i), ch);
            //   ch = min;
                
                if(s.charAt(i) < ch){  
                    ch = s.charAt(i);
                }
           }
       }
       return ch;
    }
}