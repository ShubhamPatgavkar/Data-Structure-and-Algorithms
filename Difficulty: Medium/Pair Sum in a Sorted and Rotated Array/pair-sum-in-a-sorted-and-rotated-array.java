//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution obj = new Solution();

            System.out.println(obj.pairInSortedRotated(arr, target));
        }
    }
}
// } Driver Code Ends



class Solution {
    static boolean pairInSortedRotated(int arr[], int target) {
        // Your code here
        HashSet<Integer>set = new HashSet<>();
        
        for(int i=0; i< arr.length; i++){
            if(set.contains(target - arr[i])){
                return true;
            }
            set.add(arr[i]);
        }
    
        return false;
    }
}
