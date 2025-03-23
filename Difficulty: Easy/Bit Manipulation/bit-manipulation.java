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
            int n = sc.nextInt();
            int i = sc.nextInt();

            Solution obj = new Solution();
            obj.bitManipulation(n, i);
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static void bitManipulation(int num, int i) {
        
        int getBit = (int)((num >> (i - 1)) & 1);

        // Set ith bit (turn it on)
        int setBit = num | (1 << (i - 1));

        // Clear ith bit (turn it off)
        int clearBit = num & ~(1 << (i - 1));

        // Print the results space-separated, no line break at the end
        System.out.print(getBit + " " + setBit + " " + clearBit);
    }
}
