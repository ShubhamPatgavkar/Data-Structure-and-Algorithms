//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/



class Solution {
    int count = 0;
    
    public void Solve(Node root, int sum, int k, HashMap<Integer, Integer> prefixSum) {
        if (root == null) {
            return;
        }

        // Update the current path sum
        sum += root.data;
        
        // Check if there is a prefix sum that results in the target sum
        if (prefixSum.containsKey(sum - k)) {
            count += prefixSum.get(sum - k);
        }
        
        // Store the current sum in the map
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        
        // Recur for left and right subtrees
        Solve(root.left, sum, k, prefixSum);
        Solve(root.right, sum, k, prefixSum);
        
        // Backtrack: remove the current sum from the map before returning
        prefixSum.put(sum, prefixSum.get(sum) - 1);
    }
    
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); // To handle the case where a path itself equals k
        Solve(root, 0, k, prefixSum);
        return count;
    }
}
