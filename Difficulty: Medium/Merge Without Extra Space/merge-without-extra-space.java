//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public void swapIfGreater(int a[] , int b[], int l, int r){
        if(a[l] >= b[r]){
            int temp = a[l];
            a[l] = b[r];
            b[r] = temp;
        }
    }
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int len = m+n;
        int gap = (n+m )/2 + (n+m )% 2;
        
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < len){
                
                if(left < n && right >= n){
                 swapIfGreater(a ,b, left, right - n);   
    
                }else if(right < n){
                    swapIfGreater(a, a,left, right );
                }
                else if(left >= n){
                    swapIfGreater(b, b, left - n, right - n);
                }
                left ++;
                right ++;
               
            } 
            if(gap == 1) break;
            gap = gap / 2 + gap % 2;
        }
    }
}
