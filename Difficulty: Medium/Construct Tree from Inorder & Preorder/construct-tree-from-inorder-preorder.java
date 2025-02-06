//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends

 
/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    
    public static Node create(int inst, int ine, int preorder[], int pst, int pend, HashMap<Integer, Integer> map) {
        
        if (inst > ine || pst >= pend) {
            return null;
        }
        
        int rootValue = preorder[pst];
        Node root = new Node(rootValue);
        
        // Find the index of rootValue in inorder array using the hashmap
        int i = map.get(rootValue);
        
        // Left subtree
        root.left = create(inst, i - 1, preorder, pst + 1, pst + 1 + (i - inst), map);
        
        // Right subtree
        root.right = create(i + 1, ine, preorder, pst + 1 + (i - inst), pend, map);
        
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Map element to its index in inorder
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        // Build the tree starting from the whole range of both arrays
        return create(0, inorder.length - 1, preorder, 0, preorder.length, map);
    }
}
