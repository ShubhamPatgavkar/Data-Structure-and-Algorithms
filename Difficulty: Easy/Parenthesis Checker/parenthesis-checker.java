//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false; // Closing bracket without matching opening bracket
                }

                char top = st.peek();
                if ((ch == '}' && top == '{') ||
                    (ch == ')' && top == '(') ||
                    (ch == ']' && top == '[')) {
                    st.pop(); // Valid matching pair
                } else {
                    return false; // Mismatched bracket
                }
            }
        }
        return st.isEmpty(); // If stack is empty, it's balanced
    }
}