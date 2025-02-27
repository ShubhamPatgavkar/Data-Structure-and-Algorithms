//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {

    private ArrayList<Integer> stack; // Main stack to store elements
    private ArrayList<Integer> minStack; // Stack to keep track of minimum elements

    public Solution() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    // Push an element onto the stack
    public void push(int x) {
        stack.add(x);
        // Update minStack only if it's empty or the new element is <= current minimum
        if (minStack.isEmpty() || x <= minStack.get(minStack.size() - 1)) {
            minStack.add(x);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (stack.isEmpty()) {
            return; // Stack is empty, do nothing
        }
        int poppedElement = stack.remove(stack.size() - 1);
        // If the popped element is the current minimum, remove it from minStack
        if (!minStack.isEmpty() && poppedElement == minStack.get(minStack.size() - 1)) {
            minStack.remove(minStack.size() - 1);
        }
    }

    // Return the top element of the stack
    public int peek() {
        if (stack.isEmpty()) {
            return -1; // Stack is empty, return -1
        }
        return stack.get(stack.size() - 1);
    }

    // Retrieve the minimum element from the stack
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1; // Stack is empty, return -1
        }
        return minStack.get(minStack.size() - 1);
    }
}