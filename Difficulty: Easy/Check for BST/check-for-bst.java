//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            if (g.isBST(root))
                System.out.println("true");
            else
                System.out.println("false");
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean res = true;

    // Helper function to check if the tree is a BST
    public int[] isBSTUtil(Node root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}; // min, max
        }

        int[] left = isBSTUtil(root.left);
        int[] right = isBSTUtil(root.right);

        // If left subtree's max is greater than root, or right subtree's min is less than root, it's not a BST
        if (left[1] >= root.data || right[0] <= root.data) {
            res = false;
        }

        // Return updated min and max values for the current subtree
        return new int[]{Math.min(left[0], root.data), Math.max(right[1], root.data)};
    }

    // Main function to check if a tree is a BST
    boolean isBST(Node root) {
        res = true; // Reset for each call
        isBSTUtil(root);
        return res;
    }
}
