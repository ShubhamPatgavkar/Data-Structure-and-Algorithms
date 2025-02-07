//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java



class Solution {
    
    // Helper function to reverse a portion of the array
    void reverse(ArrayList<Long> arr, int st, int end) {
        end--; // Adjust end to be the last valid index
        while (st < end) {  
            long temp = arr.get(st);
            arr.set(st, arr.get(end));  
            arr.set(end, temp);  
            st++;
            end--;
        }
    }

    // Function to reverse every sub-array of size k
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();
        
        for (int i = 0; i < n; i += k) {
            // Calculate the correct endpoint for reversal
            int end = Math.min(i + k, n);
            reverse(arr, i, end);
        }
    }
}


//{ Driver Code Starts.

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            ArrayList<Long> arr = new ArrayList<>();
            Scanner ss = new Scanner(input);
            while (ss.hasNextLong()) {
                arr.add(ss.nextLong());
            }
            Solution ob = new Solution();
            ob.reverseInGroups(arr, k);
            for (long num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        
System.out.println("~");
}
        sc.close();
    }
}
// } Driver Code Ends