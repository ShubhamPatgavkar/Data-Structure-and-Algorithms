//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
    Node prev = null;
    Node temp = head;

    while(temp != null){
        Node front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
    }

    return prev;
}

    public Node addOne(Node head) {
        int c = 1;
        head = reverse(head);
        Node temp = head;
        
        while(temp != null){
            temp.data += c;
            
            if(temp.data < 10){
                c =0;
                break;
            }
            
            temp.data = 0;
            c = 1;
            temp = temp.next;

        }
        
        head = reverse(head);
        if(c == 1){
            Node newone = new Node(1);
            newone.next = head;
            return newone;
        }
        
        return head;
        
    }
}
