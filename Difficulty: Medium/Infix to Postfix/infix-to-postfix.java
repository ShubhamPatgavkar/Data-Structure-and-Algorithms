//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    public static int checkPre(char ch) {
        if (ch == '+' || ch == '-') return 1;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '^') return 3;
        return -1;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    public static String infixToPostfix(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!isOperator(ch) && ch != '(' && ch != ')') {
                res.append(ch);
            } else {
                if (ch == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        res.append(st.pop());
                    }
                    if (!st.isEmpty()) st.pop(); // Remove '('
                } else if (st.isEmpty() || ch == '(' || checkPre(ch) > checkPre(st.peek())) {
                    st.push(ch);
                } else {
                    while (!st.isEmpty() && checkPre(st.peek()) >= checkPre(ch)) {
                        res.append(st.pop());
                    }
                    st.push(ch);
                }
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.toString();
    }

}
