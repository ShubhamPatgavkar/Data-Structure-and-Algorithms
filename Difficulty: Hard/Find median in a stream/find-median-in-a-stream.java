//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        PriorityQueue<Integer> upper = new PriorityQueue<>(); // Min heap
        
        for (int num : arr) {
            // Insert into the correct heap
            if (lower.isEmpty() || num <= lower.peek()) {
                lower.add(num);
            } else {
                upper.add(num);
            }

            // Balance the heaps
            if (lower.size() > upper.size() + 1) {
                upper.add(lower.poll());
            } else if (upper.size() > lower.size()) {
                lower.add(upper.poll());
            }

            // Find median
            if (lower.size() == upper.size()) {
                medians.add((lower.peek() + upper.peek()) / 2.0); // Average of middle elements
            } else {
                medians.add((double) lower.peek()); // Middle element from max heap
            }
        }
        return medians;
    }
}