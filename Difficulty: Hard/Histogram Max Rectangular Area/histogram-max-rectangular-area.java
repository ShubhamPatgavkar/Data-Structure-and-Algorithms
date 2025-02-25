//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int j = st.pop(); // Popped index
                int p = st.isEmpty() ? -1 : st.peek(); // Previous smaller element index
                maxArea = Math.max(maxArea, arr[j] * (i - p - 1));
            }
            st.push(i);
        }

        // Process remaining elements in stack
        while (!st.isEmpty()) {
            int j = st.pop();
            int p = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, arr[j] * (n - p - 1));
        }

        return maxArea;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.getMaxArea(arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends