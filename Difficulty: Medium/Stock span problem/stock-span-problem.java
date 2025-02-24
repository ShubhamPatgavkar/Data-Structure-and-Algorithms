//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Stock {
    int price;  // Store stock price
    int index;  // Store index of the stock price

    public Stock(int price, int index) {
        this.price = price;
        this.index = index;
    }
}

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Stock> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // Pop elements until we find a greater element
            while (!st.isEmpty() && st.peek().price <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element exists on the left
            if (st.isEmpty()) {
                list.add(i + 1);
            } else {
                list.add(i - st.peek().index);
            }

            // Push current element as an instance of Stock class
            st.push(new Stock(arr[i], i));
        }

        return list;
    }

}
