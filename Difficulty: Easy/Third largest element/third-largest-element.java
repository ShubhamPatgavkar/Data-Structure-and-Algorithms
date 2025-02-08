//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.thirdLargest(arr));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution {
    int thirdLargest(int arr[]) {
        if (arr.length < 3) return -1; // If less than 3 elements, no third largest
        
        int f = Integer.MIN_VALUE;
        int s = Integer.MIN_VALUE;
        int t = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num >= f) {
                t = s;
                s = f;
                f = num;
            } else if (num >= s && num != f) {
                t = s;
                s = num;
            } else if (num >= t && num != s && num != f) {
                t = num;
            }
        }
        
        return (t == Integer.MIN_VALUE) ? -1 : t;
    }
}
