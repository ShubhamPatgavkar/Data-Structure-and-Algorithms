//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='^' || ch == '%';
    }
    static String postToInfix(String pos_exp) {
        Stack <String> st = new Stack<>();
        
        for(int i=0; i<pos_exp.length(); i++){
            char ch = pos_exp.charAt(i);
            
            if(!isOperator(ch)){
                st.push(Character.toString(ch));
            }else{
                //if operoter;
                String s1 = st.pop();
                String s2 = st.pop();
                
                String fin =  "("+ s2 + ch + s1 +")"  ;
                
                st.push(fin);
            }
        }
        
            return st.pop();
    }
}
