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
            String ans = obj.preToInfix(s);
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
    static String preToInfix(String pre_exp) {
        Stack <String> st = new Stack<>();
        
        for(int i=pre_exp.length()-1; i>=0; i--){
            char ch = pre_exp.charAt(i);
            
            if(!isOperator(ch)){
                st.push(Character.toString(ch));
            }else{
                //if operoter;
                String s1 = st.pop();
                String s2 = st.pop();
                
                String fin = "(" + s1 + ch +  s2 + ")";
                
                st.push(fin);
            }
        }
        
        String res = "";
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
        
    }
}
