//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
    int low =0;
    int mid =0;
    int h = arr.length-1;
    int n = arr.length;
    
        while(mid <= h){
            // if the mid value is zero
            // swap with left increment the left and mid
            if(arr[mid] == 0){
                arr[mid] = arr[low];
                arr[low] = 0;
                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] == 2){
                arr[mid] = arr[h];
                arr[h] = 2;
                h--;
            }
        }
           
    }
}

//{ Driver Code Starts.
// } Driver Code Ends