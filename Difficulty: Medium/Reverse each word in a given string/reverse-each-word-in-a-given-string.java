//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Read the number of test cases
        sc.nextLine();        // Consume the newline character after reading the integer

        while (t-- > 0) {
            String s = sc.nextLine(); // Read the input string

            // Remove surrounding quotes from the string
            String str = s.substring(1, s.length() - 1);

            Solution obj = new Solution(); // Create an object of the Solution class
            String ans = obj.reverseWords(str); // Reverse the words in the string

            // Print the result with surrounding quotes
            System.out.println("\"" + ans + "\"");
            System.out.println("~"); // Print separator
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        Stack<String>st = new Stack<>();
        s.trim();
        s = " " + s;
        String str = "";
        
        for(int i=s.length()-1; i>=0 ; i--){
            
            if(s.charAt(i) == ' ' && str != ""){
                st.add(str.trim());
                str ="";
            }else if(s.charAt(i) == ' '){
                continue;
            }else{
            str += s.charAt(i);
        }        
            
        }
        
        String ans = "";
        while(!st.isEmpty()){
            ans += st.pop() + " ";
            
        }
    
        return ans.trim();
    }
}
