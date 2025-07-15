/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    
    public void inorder(Node root , ArrayList<Integer>list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        ArrayList<Integer>list = new ArrayList<>();
        inorder(root, list);
        
        return list.get(list.size()-k);
    }
}