class Node{
    int data;
    Node left;
    Node right;
    int Lbit;
    int Rbit;

    Node (int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.Lbit = 0;
        this.Rbit = 0;
    }
    
    Node() { // used for dummy Node 
        this.left = null;
        this.right = null;
        this.Lbit = 0;
        this.Rbit = 0;
    }

}




public class TBT {
    

 
    public static Node create(int data , Node root ){
        Node temp = new Node(data);

        if (root == null){
            root = temp;
            
            Node head = new Node(); // head is the dummy Node Which is only created in the intial      state of the TBT
            head.left = root;
            head.Lbit = 1;
            head.right = head;
            head.Rbit = 1;

            root.left = head;
            root.right = head;
            return root;

        }
        else{
            insert (root, temp);
        }
        return root;
    }

    public static void insert(Node root, Node temp) {

        if(temp.data < root.data){
            
            if(root.Lbit == 0){
            
                temp.left = root.left;
                root.left = temp;
                root.Lbit = 1;
                temp.right = root; // root is the inorder successor of the temp
            }
            else{
                insert(root.left, temp);
            }
        }
        else{ // when (root.data < temp.data)
            if(root.Rbit == 0){
                temp.right =  root.right;
                root.right = temp;
                root.Rbit = 1;
                temp.left = root;
                }
            else{
                    insert(root.right,temp);
                } 
        }        
    }



    public static void main(String [] args){
        int arr[] ={2,6,7,8,1,9,20};
        Node root = null;
        
        for (int i=0; i<arr.length; i++){
            root = create(arr[i],root);
        }
       



    }
    
}