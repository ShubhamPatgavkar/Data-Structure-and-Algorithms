//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
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

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    
    boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
    
    public void leftBoundary(Node node, ArrayList<Integer>list){
        while(node != null){
            if(!isLeaf(node)){
                list.add(node.data);
            }
            if(node.left == null){
                node = node.right;
            }else{
            node = node.left;
        }
        }
    }
    
    public void rightBoundary(Node node, ArrayList<Integer>list){
        
        ArrayList<Integer>rightlist = new ArrayList<Integer>();
        
        while(node != null){
            if(!isLeaf(node)){
                rightlist.add(node.data);
            }
            if(node.right == null){
                node = node.left;
            }else{
            node = node.right;
            }
        
        }
        
        // adding the right boundary reversed
        for(int i=rightlist.size()-1; i>=0 ; i--){
            list.add(rightlist.get(i));
        }
        
    }
    
    public void Inorder(Node root, ArrayList<Integer>list){
        if(root == null){
            return;
        }
        Inorder(root.left, list);
        if(isLeaf(root)){
            list.add(root.data);
        } 
        Inorder(root.right, list);
    }
    
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(node.data);
        if(!isLeaf(node)){
        leftBoundary(node.left,list);
        Inorder(node,list);
        rightBoundary(node.right, list);
        }
        return list;
        
    }
}
